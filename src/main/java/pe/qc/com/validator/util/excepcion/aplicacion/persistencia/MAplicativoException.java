package pe.qc.com.validator.util.excepcion.aplicacion.persistencia;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.UncategorizedDataAccessException;
import org.springframework.stereotype.Component;

import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.excepcion.aplicacion.PersistenciaExcepcion;

@Component
@Aspect
public class MAplicativoException {
	
	@AfterThrowing(pointcut = "execution(* pe.qc.com.validator.persistencia.mapper.MAplicativo.insertarAplicativo(..))", throwing = "error")
	public void insertarAplicativo(JoinPoint joinPoint, Throwable error){
		if (error instanceof DuplicateKeyException) {
			throw new PersistenciaExcepcion("Nombre debe ser único", error);
		} else if (error instanceof DataIntegrityViolationException) {
			throw new PersistenciaExcepcion("Nombre no debe ser nulo",
					error);
		} else if (error instanceof UncategorizedDataAccessException) {
			throw new PersistenciaExcepcion(Constantes.ERROR_ACCESO_DATOS_NO_CATEGORIZADO, error);
		} else {
			throw new PersistenciaExcepcion(Constantes.ERROR_ACCESO_DATOS, error);
		}
	}
	
	@AfterThrowing(pointcut = "execution(* pe.qc.com.validator.persistencia.mapper.MAplicativo.modificarAplicativo(..))", throwing = "error")
	public void modificarAplicativo(JoinPoint joinPoint, Throwable error) {
		if (error instanceof DuplicateKeyException) {
			throw new PersistenciaExcepcion("Nombre debe ser único", error);
		} else if (error instanceof DataIntegrityViolationException) {
			throw new PersistenciaExcepcion("Nombre no debe ser nulo",
					error);
		} else if (error instanceof UncategorizedDataAccessException) {
			throw new PersistenciaExcepcion(Constantes.ERROR_ACCESO_DATOS_NO_CATEGORIZADO, error);
		} else {
			throw new PersistenciaExcepcion(Constantes.ERROR_ACCESO_DATOS, error);
		}
	}
		
	@AfterThrowing(pointcut = "execution(* pe.qc.com.validator.persistencia.mapper.MAplicativo.eliminarAplicativo(..))", throwing = "error")
	public void eliminarAplicativo(JoinPoint joinPoint, Throwable error) {
		if (error instanceof DataIntegrityViolationException) {
			throw new PersistenciaExcepcion(
					"No se pudo eliminar Aplicativo porque está siendo usado actualmente",
					error);
		} else if (error instanceof UncategorizedDataAccessException) {
			throw new PersistenciaExcepcion(Constantes.ERROR_ACCESO_DATOS_NO_CATEGORIZADO, error);
		} else {
			throw new PersistenciaExcepcion(Constantes.ERROR_ACCESO_DATOS, error);
		}
	
	}
}
