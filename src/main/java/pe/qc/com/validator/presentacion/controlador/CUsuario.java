package pe.qc.com.validator.presentacion.controlador;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import pe.qc.com.validator.presentacion.form.FLogin;

@Controller("cUsuario")
@Scope("view")
public class CUsuario {

	private FLogin datos;

	@PostConstruct
	public void init() {
		datos = new FLogin();
		try {
			datos = (FLogin) SecurityContextHolder.getContext().getAuthentication().getDetails();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		datos.setFecha(sdf.format(new Date()));
	}

	public boolean renderizar(String valor) {
		for (GrantedAuthority sg : SecurityContextHolder.getContext().getAuthentication().getAuthorities()) {
			if (valor.equals(sg.getAuthority())) {
				return true;
			}
		}
		return false;
	}

	public FLogin getDatos() {
		return datos;
	}

	public void setDatos(FLogin datos) {
		this.datos = datos;
	}

}

