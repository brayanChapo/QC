package pe.qc.com.validator.util.excepcion;

public class BusinessLogicException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BusinessLogicException() {
	}

	public BusinessLogicException(String mensaje) {
		super(mensaje);
	}

	public BusinessLogicException(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}
}
