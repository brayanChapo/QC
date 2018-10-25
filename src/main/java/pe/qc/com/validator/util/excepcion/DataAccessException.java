package pe.qc.com.validator.util.excepcion;

public class DataAccessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataAccessException() {

	}

	public DataAccessException(String mensaje) {
		super(mensaje);
	}

	public DataAccessException(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}
}
