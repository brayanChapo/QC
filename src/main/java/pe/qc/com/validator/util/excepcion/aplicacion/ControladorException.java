package pe.qc.com.validator.util.excepcion.aplicacion;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControladorException {

	@Pointcut("execution (* pe.qc.com.validator.negocio.servicio.impl.*.*(..))")
	public void errorNegocio() {
	}

	@Pointcut("execution(* pe.qc.com.validator.persistencia.mapper.*.*(..))")
	public void errorPersistencia() {
	}

	@Pointcut("errorNegocio() || errorPersistencia()")
	public void errorAplicacion() {
	}

	@AfterThrowing(pointcut = "errorAplicacion() ", throwing = "error")
	public void manejarExcepcion(JoinPoint jointPoint, Throwable error) {
		if (error instanceof NegocioExcepcion) {
			error.printStackTrace();
		} else if (error instanceof PersistenciaExcepcion) {
		}
	}
}