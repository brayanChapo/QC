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
public class MVobException {
	
	@AfterThrowing(pointcut = "execution(* pe.qc.com.validator.persistencia.mapper.MVob.listarVob())", throwing = "error")
	public void listarVob(JoinPoint joinPoint, Throwable error){
		if(error instanceof UncategorizedDataAccessException){
			throw new DataAccessException(Constantes.ERROR_ACCESO_DATOS_NO_CATEGORIZADO, error);
		}else{
			throw new DataAccessException(Constantes.ERROR_ACCESO_DATOS_OTRO, error);
		}
	}
	
	@AfterThrowing(pointcut = "execution(* pe.qc.com.validator.persistencia.mapper.MVob.insertarVob(..))", throwing = "error")
	public void insertarVob(JoinPoint joinPoint, Throwable error){
		if (error instanceof DuplicateKeyException){
			throw new DataAccessException("Nombre de Vob debe ser único", error);
		} else if (error instanceof DataIntegrityViolationException){
			throw new DataAccessException("Nombre de Vob no debe ser nulo", error);
		} else if(error instanceof UncategorizedDataAccessException){
			throw new DataAccessException(Constantes.ERROR_ACCESO_DATOS_NO_CATEGORIZADO, error);
		}else{
			throw new DataAccessException(Constantes.ERROR_ACCESO_DATOS_OTRO, error);
		}
	}
	
	@AfterThrowing(pointcut = "execution(* pe.qc.com.validator.persistencia.mapper.MVob.modificarVob(..))", throwing = "error")
	public void modificarVob(JoinPoint joinPoint, Throwable error){
		if (error instanceof DuplicateKeyException){
			throw new DataAccessException("Nombre de Vob debe ser único", error);
		} else if (error instanceof DataIntegrityViolationException){
			throw new DataAccessException("Nombre de Vob no debe ser nulo", error);
		} else if(error instanceof UncategorizedDataAccessException){
			throw new DataAccessException(Constantes.ERROR_ACCESO_DATOS_NO_CATEGORIZADO, error);
		}else{
			throw new DataAccessException(Constantes.ERROR_ACCESO_DATOS_OTRO, error);
		}
	}
}
