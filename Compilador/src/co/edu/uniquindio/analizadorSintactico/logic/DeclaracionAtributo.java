package co.edu.uniquindio.analizadorSintactico.logic;

import co.edu.uniquindio.analizadorLexico.logic.Lenguaje;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de DeclaracionAtributo.java y 
 * maneja su información
 */
public class DeclaracionAtributo implements InstruccionClase 
{
	/**
	 * Atributo que contiene el valor de idAtributo dentro de la clase
	*/
	private Lenguaje idAtributo;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la DeclaracionAtributo.java
	 * @param idAtributo
	 * @param expresion
	 */
	public DeclaracionAtributo(Lenguaje idAtributo) {
		super();
		this.idAtributo = idAtributo;
	}

	/**
	 * Este metodo permite obtener el valor del atributo idAtributo
	 * @return el idAtributo
	 */
	public Lenguaje getIdAtributo() {
		return idAtributo;
	}

	/**
	 * Este metodo permite asignar un valor al atributo idAtributo
	 * @param idAtributo se asigna a idAtributo
	 */
	public void setIdAtributo(Lenguaje idAtributo) {
		this.idAtributo = idAtributo;
	}
}