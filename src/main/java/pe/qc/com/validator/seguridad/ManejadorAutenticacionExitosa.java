package pe.qc.com.validator.seguridad;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import pe.qc.com.validator.util.PaginaUtil;

public class ManejadorAutenticacionExitosa implements AuthenticationSuccessHandler {

	// @Autowired
	// @Qualifier("sCatalogoImpl")
	// private transient SCatalogo sCatalogo;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// Set<String> roles = AuthorityUtils.authorityListToSet(authentication
		// .getAuthorities());

		request.getSession().setMaxInactiveInterval(obtenerSegundosDeInactividad());
		// request.getSession().setMaxInactiveInterval(5);
		
		
		PaginaUtil.redireccionar("/validator/iniciar_sesion.jsf?faces-redirect=true");
		
		
	}

	private int obtenerSegundosDeInactividad() {
		// return
		// Integer.parseInt(sCatalogo.obtenerCatalogo(TipoCatalogo.PARAMETROS.getId(),1).getDescripcion())*60;
		return 800;
	}

}