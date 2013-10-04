/**
 * 
 */
package co.edu.uniquindio.analizadorLexico.logic;

/** 
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Agosto-2013 
 * Esta clase es la que contiene los atributos de Lenguaje y 
 * maneja su información
 */
public class Lenguaje 
{
	/**
	 * Atributo que contiene el valor de lenguaje dentro de la clase
	 */
	private String token;
	
	/**
	 * Atributo que contiene el valor de token dentro de la clase
	 */
	private String tipoToken;
	
	/**
	 * Atributo que contiene el valor de fila dentro de la clase
	 */
	int fila;
	
	/**
	 * Atributo que contiene el valor de columna dentro de la clase
	 */
	int columna;
	
	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la Lenguaje.java
	 * @param lenguaje
	 * @param token
	 * @param fila
	 * @param columna
	 */
	public Lenguaje(String token, String tipoToken, int fila, int columna) {
		super();
		this.token = token;
		this.tipoToken = tipoToken;
		this.fila = fila;
		this.columna = columna;
	}

	/**
	 * Este metodo permite obtener el valor del atributo lenguaje
	 * @return el lenguaje
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Este metodo permite asignar un valor al atributo lenguaje
	 * @param lenguaje se asigna a lenguaje
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * Este metodo permite obtener el valor del atributo token
	 * @return el token
	 */
	public String getTipoToken() {
		return tipoToken;
	}

	/**
	 * Este metodo permite asignar un valor al atributo token
	 * @param token se asigna a token
	 */
	public void setTipoToken(String tipoToken) {
		this.tipoToken = tipoToken;
	}

	/**
	 * Este metodo permite obtener el valor del atributo fila
	 * @return el fila
	 */
	public int getFila() {
		return fila;
	}

	/**
	 * Este metodo permite asignar un valor al atributo fila
	 * @param fila se asigna a fila
	 */
	public void setFila(int fila) {
		this.fila = fila;
	}

	/**
	 * Este metodo permite obtener el valor del atributo columna
	 * @return el columna
	 */
	public int getColumna() {
		return columna;
	}

	/**
	 * Este metodo permite asignar un valor al atributo columna
	 * @param columna se asigna a columna
	 */
	public void setColumna(int columna) {
		this.columna = columna;
	}
}