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
public class MVobException {
	
	@AfterThrowing(pointcut = "execution(* pe.qc.com.validator.persistencia.mapper.MVob.insertarVob(..))", throwing = "error")
	public void insertarVob(JoinPoint joinPoint, Throwable error){
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
	
	@AfterThrowing(pointcut = "execution(* pe.qc.com.validator.persistencia.mapper.MVob.modificarVob(..))", throwing = "error")
	public void modificarVob(JoinPoint joinPoint, Throwable error) {
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
		
	@AfterThrowing(pointcut = "execution(* pe.qc.com.validator.persistencia.mapper.MVob.eliminarVob(..))", throwing = "error")
	public void eliminarVob(JoinPoint joinPoint, Throwable error) {
		if (error instanceof DataIntegrityViolationException) {
			throw new PersistenciaExcepcion(
					"No se pudo eliminar vob porque está siendo usado actualmente",
					error);
		} else if (error instanceof UncategorizedDataAccessException) {
			throw new PersistenciaExcepcion(Constantes.ERROR_ACCESO_DATOS_NO_CATEGORIZADO, error);
		} else {
			throw new PersistenciaExcepcion(Constantes.ERROR_ACCESO_DATOS, error);
		}
	
	}
}
