package pe.qc.com.validator.util.aspecto;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logging {

	private static final Logger logger = LogManager.getLogger(Logging.class);

	@Before("execution(* pe.qc.com.validator.negocio.servicio.*.*(..))")
	public void logBeforeService(JoinPoint joinPoint) {
		logger.debug("Log antes del servicio: " + joinPoint.getSignature());
	}

	@Before("execution(* pe.qc.com.validator.persistencia.mapper.*.*(..))")
	public void logBeforeMapper(JoinPoint joinPoint) {
		logger.debug("Log antes del mapper: " + joinPoint.getSignature());
	}
}