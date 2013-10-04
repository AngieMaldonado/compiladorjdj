package co.edu.uniquindio.analizadorSintactico.logic;

import co.edu.uniquindio.analizadorLexico.logic.Lenguaje;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de DeclaracionPaquete.java y 
 * maneja su información
 */
public class DeclaracionPaquete 
{
	/**
	 * Atributo que contiene el valor de idPaquete dentro de la clase
	*/
	Lenguaje idPaquete;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la DeclaracionPaquete.java
	 * @param idPaquete
	 */
	public DeclaracionPaquete(Lenguaje idPaquete) {
		super();
		this.idPaquete = idPaquete;
	}

	/**
	 * Este metodo permite obtener el valor del atributo idPaquete
	 * @return el idPaquete
	 */
	public Lenguaje getIdPaquete() {
		return idPaquete;
	}

	/**
	 * Este metodo permite asignar un valor al atributo idPaquete
	 * @param idPaquete se asigna a idPaquete
	 */
	public void setIdPaquete(Lenguaje idPaquete) {
		this.idPaquete = idPaquete;
	}
}	