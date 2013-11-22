package co.edu.uniquindio.analizadorSintactico.logic;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de SentenciaMetodo_Hacermientras.java y 
 * maneja su información
 */
public class SentenciaMetodo_Hacermientras extends SentenciaMetodo
{
	/**
	 * Atributo que contiene el valor de operaciones dentro de la clase
	*/
	SentenciasMetodo operaciones;
	
	/**
	 * Atributo que contiene el valor de condiciones dentro de la clase
	*/
	Operacion condiciones;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la SentenciaMetodo_Hacermientras.java
	 * @param operaciones
	 * @param condiciones
	 */
	public SentenciaMetodo_Hacermientras(SentenciasMetodo operaciones,
			Operacion condiciones) {
		super();
		this.operaciones = operaciones;
		this.condiciones = condiciones;
	}

	/**
	 * Este metodo permite obtener el valor del atributo operaciones
	 * @return el operaciones
	 */
	public SentenciasMetodo getOperaciones() {
		return operaciones;
	}

	/**
	 * Este metodo permite asignar un valor al atributo operaciones
	 * @param operaciones se asigna a operaciones
	 */
	public void setOperaciones(SentenciasMetodo operaciones) {
		this.operaciones = operaciones;
	}

	/**
	 * Este metodo permite obtener el valor del atributo condiciones
	 * @return el condiciones
	 */
	public Operacion getCondiciones() {
		return condiciones;
	}

	/**
	 * Este metodo permite asignar un valor al atributo condiciones
	 * @param condiciones se asigna a condiciones
	 */
	public void setCondiciones(Operacion condiciones) {
		this.condiciones = condiciones;
	}
}