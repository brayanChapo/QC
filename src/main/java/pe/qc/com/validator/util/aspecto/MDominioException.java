package pe.qc.com.validator.util.aspecto;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.UncategorizedDataAccessException;
import org.springframework.stereotype.Component;

import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.excepcion.DataAccessException;

@Component
@Aspect
public class MDominioException {
	
	@AfterThrowing(pointcut = "execution(* pe.qc.com.validator.persistencia.mapper.MDominio.listarDominio())", throwing = "error")
	public void listarDominio(JoinPoint joinPoint, Throwable error){
		if(error instanceof UncategorizedDataAccessException){
			throw new DataAccessException(Constantes.ERROR_ACCESO_DATOS_NO_CATEGORIZADO, error);
		}else{
			throw new DataAccessException(Constantes.ERROR_ACCESO_DATOS_OTRO, error);
		}
	}
	
	@AfterThrowing(pointcut = "execution(* pe.qc.com.validator.persistencia.mapper.MDominio.insertarDominio(..))", throwing = "error")
	public void insertarDominio(JoinPoint joinPoint, Throwable error){
		if (error instanceof DuplicateKeyException){
			throw new DataAccessException("Nombre de Dominio debe ser único", error);
		} else if (error instanceof DataIntegrityViolationException){
			throw new DataAccessException("Nombre de Dominio no debe ser nulo", error);
		} else if(error instanceof UncategorizedDataAccessException){
			throw new DataAccessException(Constantes.ERROR_ACCESO_DATOS_NO_CATEGORIZADO, error);
		}else{
			throw new DataAccessException(Constantes.ERROR_ACCESO_DATOS_OTRO, error);
		}
	}
	
	@AfterThrowing(pointcut = "execution(* pe.qc.com.validator.persistencia.mapper.MDominio.modificarDominio(..))", throwing = "error")
	public void modificarDominio(JoinPoint joinPoint, Throwable error){
		if (error instanceof DuplicateKeyException){
			throw new DataAccessException("Nombre de Dominio debe ser único", error);
		} else if (error instanceof DataIntegrityViolationException){
			throw new DataAccessException("Nombre de Dominio no debe ser nulo", error);
		} else if(error instanceof UncategorizedDataAccessException){
			throw new DataAccessException(Constantes.ERROR_ACCESO_DATOS_NO_CATEGORIZADO, error);
		}else{
			throw new DataAccessException(Constantes.ERROR_ACCESO_DATOS_OTRO, error);
		}
	}
}
