package pe.qc.com.validator.seguridad;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import pe.qc.com.validator.negocio.bo.BOUsuario;
import pe.qc.com.validator.negocio.servicio.NArea;
import pe.qc.com.validator.negocio.servicio.NRol;
import pe.qc.com.validator.negocio.servicio.NUsuario;
import pe.qc.com.validator.presentacion.form.FLogin;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.ConstantesServicios;
import pe.qc.com.validator.util.excepcion.UsuarioIncorrectoExcepcion;

public class ProveedorAutenticacion implements AuthenticationProvider {
	
	@Autowired
	NUsuario nUsuario;
	@Autowired
	NRol nRol;
	@Autowired
	NArea nArea;
	
	BOUsuario boUsuario;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		// return autenticacion(authentication);
		return autenticacionPrueba(authentication);// Cuando se quiere realizar
													// una prueba sin obtener
													// datos de la bd
	}

	private Authentication autenticacion(Authentication authentication) {
		String username = (String) authentication.getName();
		String password = (String) authentication.getCredentials();
		return null;
	}

	private Authentication autenticacionPrueba(Authentication authentication) {
		String username = (String) authentication.getName();
		String password = (String) authentication.getCredentials();

		// crear una consulta para la validacion existencia de usuario ->
		// retorna datos del usuario empleado 
		boUsuario = new BOUsuario();
		boUsuario = nUsuario.obtenerUsuarioXCodigo(username);
		
		//Empleado em = empleaodService.verificarExistencia(usuario,contrasenia);
		
		if(boUsuario != null) {
			String usuario = boUsuario.getCodigoUsuario();
			String pass = boUsuario.getPassUsuario();
			int rol = boUsuario.getIdRol();
			System.out.println("user: " + usuario + " password: " + pass + "rol: " + rol);
			if(username.equalsIgnoreCase(usuario) && password.equals(pass)) {//falta añadir al suario activo o inactivo
				String accesos = obtenerAccesosUsuario(rol);
				// crear una consulta obtener el rol y accesos de un usuario
				// List<GrantedAuthority> listaPermisos = obtenerAccesosUsuario();
				//BORol rol = rolService.obtenerAccesosUsuario(usuario);  // Consultos,00S01S....NNS
				List<GrantedAuthority> listaPermisos = getAuthorities(accesos);//rol.getAccessos()
				UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(
						authentication.getName(), authentication.getCredentials(), listaPermisos);
				System.out.println("autoridades : " + userToken.getAuthorities());
				FLogin infoLogin = new FLogin();
				infoLogin.setUsuario(username);
				infoLogin.setDatosUsuario(recuperarDatosUsuario(boUsuario));
				userToken.setDetails(infoLogin);
				return userToken;
				
				
			}else {
				throw new UsuarioIncorrectoExcepcion("Usuario y/o Contraseña incorrecta");
			}
		}else {
			throw new UsuarioIncorrectoExcepcion("Usuario no registrado");
		}
		
//		if(em!==null)
//		if (username.equalsIgnoreCase("admi") && password.equals("123")) {
//			String accesos = obtenerAccesosUsuarioLocal(authentication.getName());
//
//			// crear una consulta obtener el rol y accesos de un usuario
//			// List<GrantedAuthority> listaPermisos = obtenerAccesosUsuario();
//			//BORol rol = rolService.obtenerAccesosUsuario(usuario);  // Consultos,00S01S....NNS
//			List<GrantedAuthority> listaPermisos = getAuthorities(accesos);//rol.getAccessos()
//
//			UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(
//					authentication.getName(), authentication.getCredentials(), listaPermisos);
//			System.out.println("autoridades : " + userToken.getAuthorities());
//			FLogin infoLogin = new FLogin();
//			infoLogin.setUsuario(username);
//			infoLogin.setDatosUsuario(recuperarDatosUsuarioLocal(authentication.getName()));
//			userToken.setDetails(infoLogin);
//			return userToken;
//		} else {
//			throw new UsuarioIncorrectoExcepcion("Usuario y/o Contraseña incorrecta");
//		}

	}

//	private Usuario recuperarDatosUsuarioLocal(String username) {
//		Usuario usuario = new Usuario();
//		usuario.setNombre("Alfredo");
//		usuario.setApellido("Chapoñan");
//		usuario.obtenerNombre();
//		usuario.setCodigoUsuario("S66202");
//		usuario.setNombreArea("QC");
//		usuario.setRolUsuario("REVISOR");
//		return usuario;
//	}
	
	//Datos del usuario
	private Usuario recuperarDatosUsuario(BOUsuario boUsuario) {
		Usuario usuario = new Usuario();
		usuario.setNombre(boUsuario.getNombreUsuario());
		usuario.setApellido(boUsuario.getApellidoUsuario());
		usuario.obtenerNombre();
		usuario.setCodigoUsuario(boUsuario.getCodigoUsuario());
		usuario.setNombreArea(nArea.obtenerAreaXId(boUsuario.getIdArea()).getNombreArea());
		usuario.setRolUsuario(nRol.obtenerRolXId(boUsuario.getIdRol()).getNombreRol());
		return usuario;
	}

	private String obtenerAccesosUsuarioLocal(String usuario) {
		if (usuario.equalsIgnoreCase("admi"))
			return "00S01";
			//return "00S01N02N03N04N05N06S07S08S09S10S11S12S13S14S15S16S17S18S19S20S21S22S";
//			return "00S01N02N03N04N05N06S07S08S09S10S11S12S13S14S15S16S17S18S19S20S";
		return "";
	}
	
	//usuario administrador
	private String obtenerAccesosUsuario(int rol) {
		if(rol == Constantes.USUARIO_ADMINISTRADOR) {
			return "00S01S02S03S04S05S06S07S08S09N10N11S12N13S14S15S16S17N";
		}
		if(rol == Constantes.USUARIO_DIGITADOR) {
			return "00S01N02N03N04N05S06S07S08S09S10S11S12S13N14N15N16N17S";
		}
		if(rol == Constantes.USUARIO_CONSULTOR) {
			return "00S01N02N03N04N05S06S07S08S09N10N11N12N13N14N15S16S17S";
		}
		return "";
	}
	
	
	
	private List<GrantedAuthority> getAuthorities(String permisos) {
		List<GrantedAuthority> listaAuthorities = new ArrayList<GrantedAuthority>();
		permisos += " ";
		for (int i = 0; i < permisos.length() - 3; i = i + 3) {
			if (ConstantesServicios.OPCION_ROL.containsKey(permisos.substring(i, i + 3))) {
				listaAuthorities.add(
						new SimpleGrantedAuthority(ConstantesServicios.OPCION_ROL.get(permisos.substring(i, i + 3))));
			}
		}
		return listaAuthorities;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class));
	}

	public BOUsuario getBoUsuario() {
		return boUsuario;
	}

	public void setBoUsuario(BOUsuario boUsuario) {
		this.boUsuario = boUsuario;
	}

}
