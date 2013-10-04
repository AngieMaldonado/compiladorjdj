package co.edu.uniquindio.analizadorSintactico.logic;

import co.edu.uniquindio.analizadorLexico.logic.Lenguaje;
import co.edu.uniquindio.analizadorSintactico.logic.interfaces.Linea;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de Factor.java y 
 * maneja su información
 */
public class Factor implements Linea 
{
	/**
	 * Atributo que contiene el valor de token dentro de la clase
	*/
	Lenguaje token;
	
	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la Factor.java
	 * @param token
	 */
	public Factor(Lenguaje token) {
		super();
		this.token = token;
	}

	/**
	 * Este metodo permite obtener el valor del atributo token
	 * @return el token
	 */
	public Lenguaje getToken() {
		return token;
	}

	/**
	 * Este metodo permite asignar un valor al atributo token
	 * @param token se asigna a token
	 */
	public void setToken(Lenguaje token) {
		this.token = token;
	}

	/* (non-Javadoc)
	 * @see co.edu.uniquindio.analizadorSintactico.logic.interfaces.Linea#analizar()
	 */
	@Override
	public boolean analizar() {
		return true;
	}
}