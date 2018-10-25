package pe.qc.com.validator.util.transformador;

import java.util.List;

/**
 * 
 * Resumen: Provee los métodos para convertir business objects a objetos form de
 * la capa vista, y viceversa
 * 
 */

public interface TransformadorBOForm<X, Y> {

	public Y toForm(final X input);

	public List<Y> toForm(final List<X> lista);

	public X toBO(final Y input);
}
