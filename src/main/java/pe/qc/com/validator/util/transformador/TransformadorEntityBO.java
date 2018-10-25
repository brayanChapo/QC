package pe.qc.com.validator.util.transformador;

import java.util.List;

/**
 * 
 * Resumen: Provee los métodos para convertir entidades de la base de datos a
 * business object, y viceversa
 * 
 */

public interface TransformadorEntityBO<X, Y> {

	public Y toBO(final X input);

	public List<Y> toBO(final List<X> lista);

	public X toEntity(final Y input);
}
