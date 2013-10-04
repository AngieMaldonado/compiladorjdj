package co.edu.uniquindio.analizadorSintactico.logic;

import co.edu.uniquindio.analizadorLexico.logic.Lenguaje;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de DeclaracionImport.java y 
 * maneja su información
 */
public class DeclaracionImport 
{
	/**
	 * Atributo que contiene el valor de idClase dentro de la clase
	*/
	Lenguaje idClase;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la DeclaracionImport.java
	 * @param idClase
	 */
	public DeclaracionImport(Lenguaje idClase) {
		super();
		this.idClase = idClase;
	}

	/**
	 * Este metodo permite obtener el valor del atributo idClase
	 * @return el idClase
	 */
	public Lenguaje getIdClase() {
		return idClase;
	}

	/**
	 * Este metodo permite asignar un valor al atributo idClase
	 * @param idClase se asigna a idClase
	 */
	public void setIdClase(Lenguaje idClase) {
		this.idClase = idClase;
	}
}