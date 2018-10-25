package pe.qc.com.validator.presentacion.controlador;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;

import pe.qc.com.validator.presentacion.form.FLogin;
import pe.qc.com.validator.util.PaginaUtil;
import pe.qc.com.validator.util.excepcion.UsuarioIncorrectoExcepcion;

@Controller("cLogin")
@Scope("view")
public class CLogin implements PhaseListener {
	FLogin fLogin;
	int activo;
	
	@PostConstruct
	public void init() {
		fLogin = new FLogin();
	}

	public void iniciarSesion() {
		activo = 0;
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
				.getRequestDispatcher("/j_spring_security_check");
		try {
			dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
		} catch (ServletException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		FacesContext.getCurrentInstance().responseComplete();
	}

	@Override
	public void afterPhase(PhaseEvent event) {
		System.out.println("afterphase");
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		if(sessionActiva()==false){
			activo = 1;
		}else {
			activo = 0;
		}
		System.out.println("beforePhase");
		Exception e = (Exception) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.remove(WebAttributes.AUTHENTICATION_EXCEPTION);
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest servletRequest = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String fullURI = servletRequest.getRequestURI();
		
		if (fullURI.contains("/validator/iniciar_sesion.jsf")) {// Solamente mostrar
															// los errores en la
														// pagina del login
			if (e instanceof UsuarioIncorrectoExcepcion) {
				PaginaUtil.mensajeJSF(3, e.getMessage());//MOSTRAR MENSAJE
				
			} else {
				if(activo ==1) {
					PaginaUtil.ejecutar("PF('SessionExpirada').show()");
				}
			}
			
			PaginaUtil.actualizarComponente("loginForm");

		}else {
			
		}

	}

	private boolean sessionActiva() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if ((!(auth instanceof AnonymousAuthenticationToken))) {
			return true;
		}
		return false;
	}
	
	public void sessionInActiva() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (((auth instanceof AnonymousAuthenticationToken)) && activo == 1) {
			System.out.println("AcaboSession");
			activo = 0;
			PaginaUtil.ejecutar("PF('SessionExpirada').show()");
			
		}
		
	}

	public boolean estaLogeado() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if ((!(auth instanceof AnonymousAuthenticationToken))) {
			this.redireccionar();
			return true;
		}
		return false;

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}
	
	public void redireccionar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			fc.getExternalContext().redirect("/validator/paginas/principal.jsf?faces-redirect=true");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void redireccionar2() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			fc.getExternalContext().redirect("/validator/iniciar_sesion.jsf?faces-redirect=true");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public FLogin getfLogin() {
		return fLogin;
	}

	public void setfLogin(FLogin fLogin) {
		this.fLogin = fLogin;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}
	
}