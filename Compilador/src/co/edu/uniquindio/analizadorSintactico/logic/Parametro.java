/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de Parametro.java y 
 * maneja su información
 */
package co.edu.uniquindio.analizadorSintactico.logic;

import co.edu.uniquindio.analizadorLexico.logic.Lenguaje;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de Parametro.java y 
 * maneja su información
 */
public class Parametro 
{
	/**
	 * Atributo que contiene el valor de idParametro dentro de la clase
	*/
	Lenguaje idParametro;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la Parametro.java
	 * @param idParametro
	 */
	public Parametro(Lenguaje idParametro) {
		super();
		this.idParametro = idParametro;
	}

	/**
	 * Este metodo permite obtener el valor del atributo idParametro
	 * @return el idParametro
	 */
	public Lenguaje getIdParametro() {
		return idParametro;
	}

	/**
	 * Este metodo permite asignar un valor al atributo idParametro
	 * @param idParametro se asigna a idParametro
	 */
	public void setIdParametro(Lenguaje idParametro) {
		this.idParametro = idParametro;
	}
}