package co.edu.uniquindio.analizadorSintactico.logic;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de SentenciaMetodo_Ciclo.java y 
 * maneja su información
 */
public class SentenciaMetodo_Ciclo extends SentenciaMetodo 
{
	/**
	 * Atributo que contiene el valor de asignacion dentro de la clase
	*/
	Operacion asignacion;
	
	/**
	 * Atributo que contiene el valor de condicion dentro de la clase
	*/
	Operacion condicion;
	
	/**
	 * Atributo que contiene el valor de iteracion dentro de la clase
	*/
	Operacion iteracion;
	
	/**
	 * Atributo que contiene el valor de operaciones dentro de la clase
	*/
	SentenciasMetodo operaciones;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la SentenciaMetodo_Ciclo.java
	 * @param asignacion
	 * @param condicion
	 * @param iteracion
	 * @param operaciones
	 */
	public SentenciaMetodo_Ciclo(Operacion asignacion, Operacion condicion,
			Operacion iteracion, SentenciasMetodo operaciones) {
		super();
		this.asignacion = asignacion;
		this.condicion = condicion;
		this.iteracion = iteracion;
		this.operaciones = operaciones;
	}

	/**
	 * Este metodo permite obtener el valor del atributo asignacion
	 * @return el asignacion
	 */
	public Operacion getAsignacion() {
		return asignacion;
	}

	/**
	 * Este metodo permite asignar un valor al atributo asignacion
	 * @param asignacion se asigna a asignacion
	 */
	public void setAsignacion(Operacion asignacion) {
		this.asignacion = asignacion;
	}

	/**
	 * Este metodo permite obtener el valor del atributo condicion
	 * @return el condicion
	 */
	public Operacion getCondicion() {
		return condicion;
	}

	/**
	 * Este metodo permite asignar un valor al atributo condicion
	 * @param condicion se asigna a condicion
	 */
	public void setCondicion(Operacion condicion) {
		this.condicion = condicion;
	}

	/**
	 * Este metodo permite obtener el valor del atributo iteracion
	 * @return el iteracion
	 */
	public Operacion getIteracion() {
		return iteracion;
	}

	/**
	 * Este metodo permite asignar un valor al atributo iteracion
	 * @param iteracion se asigna a iteracion
	 */
	public void setIteracion(Operacion iteracion) {
		this.iteracion = iteracion;
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
}