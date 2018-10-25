package pe.qc.com.validator.util.excepcion;

import org.springframework.security.core.AuthenticationException;

public class UsuarioIncorrectoExcepcion extends AuthenticationException {

	public UsuarioIncorrectoExcepcion(String msg) {
		super(msg);
	}

}
