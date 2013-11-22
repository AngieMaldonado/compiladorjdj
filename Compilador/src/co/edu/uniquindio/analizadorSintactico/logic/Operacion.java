package co.edu.uniquindio.analizadorSintactico.logic;

import co.edu.uniquindio.analizadorLexico.logic.Lenguaje;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de Operacion.java y 
 * maneja su información
 */
public class Operacion 
{
	/**
	 * Atributo que contiene el valor de operador1 dentro de la clase
	*/
	Lenguaje operador1;
	
	/**
	 * Atributo que contiene el valor de operacion dentro de la clase
	*/
	Lenguaje operacion;
	
	/**
	 * Atributo que contiene el valor de operador2 dentro de la clase
	*/
	Operacion operador2;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la Operacion.java
	 * @param operador1
	 * @param operacion
	 * @param operador2
	 */
	public Operacion(Lenguaje operador1, Lenguaje operacion, Operacion operador2) {
		super();
		this.operador1 = operador1;
		this.operacion = operacion;
		this.operador2 = operador2;
	}

	/**
	 * Este metodo permite obtener el valor del atributo operador1
	 * @return el operador1
	 */
	public Lenguaje getOperador1() {
		return operador1;
	}

	/**
	 * Este metodo permite asignar un valor al atributo operador1
	 * @param operador1 se asigna a operador1
	 */
	public void setOperador1(Lenguaje operador1) {
		this.operador1 = operador1;
	}

	/**
	 * Este metodo permite obtener el valor del atributo operacion
	 * @return el operacion
	 */
	public Lenguaje getOperacion() {
		return operacion;
	}

	/**
	 * Este metodo permite asignar un valor al atributo operacion
	 * @param operacion se asigna a operacion
	 */
	public void setOperacion(Lenguaje operacion) {
		this.operacion = operacion;
	}

	/**
	 * Este metodo permite obtener el valor del atributo operador2
	 * @return el operador2
	 */
	public Operacion getOperador2() {
		return operador2;
	}

	/**
	 * Este metodo permite asignar un valor al atributo operador2
	 * @param operador2 se asigna a operador2
	 */
	public void setOperador2(Operacion operador2) {
		this.operador2 = operador2;
	}
}