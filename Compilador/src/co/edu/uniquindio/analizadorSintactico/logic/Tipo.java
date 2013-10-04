package co.edu.uniquindio.analizadorSintactico.logic;

import co.edu.uniquindio.analizadorLexico.logic.Lenguaje;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de Tipo.java y 
 * maneja su información
 */
public class Tipo 
{
	/**
	 * Atributo que contiene el valor de idTipo dentro de la clase
	*/
	Lenguaje idTipo;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la Tipo.java
	 * @param idTipo
	 */
	public Tipo(Lenguaje idTipo) {
		super();
		this.idTipo = idTipo;
	}

	/**
	 * Este metodo permite obtener el valor del atributo idTipo
	 * @return el idTipo
	 */
	public Lenguaje getIdTipo() {
		return idTipo;
	}

	/**
	 * Este metodo permite asignar un valor al atributo idTipo
	 * @param idTipo se asigna a idTipo
	 */
	public void setIdTipo(Lenguaje idTipo) {
		this.idTipo = idTipo;
	}
}
