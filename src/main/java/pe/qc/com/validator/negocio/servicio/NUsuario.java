package pe.qc.com.validator.negocio.servicio;

import java.util.List;
import java.util.Map;

import pe.qc.com.validator.negocio.bo.BOUsuario;

public interface NUsuario {

	public List<BOUsuario> listarUsuario();
	
	public BOUsuario obtenerUsuarioXId(Integer id);
	
	public BOUsuario obtenerUsuarioXCodigo(String codigoUsuario);
	
	public void insertarUsuario(BOUsuario Usuario);
	
	public void modificarUsuario(BOUsuario Usuario);
	
	public void eliminarUsuario(BOUsuario Usuario);
	
	public List<Map<String, Object>> listarMapUsuarios();
	
	public Map<String, Object> obtenerMapUsuario(Integer idUsuario);
	
	public List<Map<String, Object>> listarMapconsultaUsuarios();
	
}
