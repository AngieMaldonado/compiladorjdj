package co.edu.uniquindio.analizadorSintactico.logic;

import co.edu.uniquindio.analizadorLexico.logic.Lenguaje;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de DeclaracionVariable.java y 
 * maneja su información
 */
public class DeclaracionVariable 
{
	/**
	 * Atributo que contiene el valor de idVariable dentro de la clase
	*/
	Lenguaje idVariable;
	
	/**
	 * Atributo que contiene el valor de tipo dentro de la clase
	*/
	Tipo tipo;
	
	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la DeclaracionVariable.java
	 * @param idVariable
	 */
	public DeclaracionVariable(Lenguaje idVariable, Tipo tipo) {
		super();
		this.idVariable = idVariable;
		this.tipo = tipo;
	}

	/**
	 * Este metodo permite obtener el valor del atributo idVariable
	 * @return el idVariable
	 */
	public Lenguaje getIdVariable() {
		return idVariable;
	}

	/**
	 * Este metodo permite asignar un valor al atributo idVariable
	 * @param idVariable se asigna a idVariable
	 */
	public void setIdVariable(Lenguaje idVariable) {
		this.idVariable = idVariable;
	}

	/**
	 * Este metodo permite obtener el valor del atributo tipo
	 * @return el tipo
	 */
	public Tipo getTipo() {
		return tipo;
	}

	/**
	 * Este metodo permite asignar un valor al atributo tipo
	 * @param tipo se asigna a tipo
	 */
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
}
