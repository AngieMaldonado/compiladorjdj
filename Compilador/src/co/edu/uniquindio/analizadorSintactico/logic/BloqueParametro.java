package co.edu.uniquindio.analizadorSintactico.logic;

import java.util.ArrayList;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de BloqueParametro.java y 
 * maneja su información
 */ 
public class BloqueParametro {

	/**
	 * Atributo que contiene el valor de parametros dentro de la clase
	*/
	private ArrayList<Parametro> parametros;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la BloqueParametro.java
	 */
	public BloqueParametro() 
	{
		super();
	}

	/**
	 * Este metodo permite obtener el valor del atributo parametros
	 * @return el parametros
	 */
	public ArrayList<Parametro> getParametros() {
		return parametros;
	}

	/**
	 * Este metodo permite asignar un valor al atributo parametros
	 * @param parametros se asigna a parametros
	 */
	public void setParametros(ArrayList<Parametro> parametros) {
		this.parametros = parametros;
	}
}
