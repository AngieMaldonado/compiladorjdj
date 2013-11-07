package co.edu.uniquindio.analizadorSintactico.logic;

import java.util.List;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de SentenciasMetodo.java y 
 * maneja su información
 */
public class SentenciasMetodo 
{
	/**
	 * Atributo que contiene el valor de sentenciasMetodo dentro de la clase
	*/
	List<SentenciaMetodo> sentenciasMetodo;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la SentenciasMetodo.java
	 * @param sentenciasMetodo
	 */
	public SentenciasMetodo(List<SentenciaMetodo> sentenciasMetodo) {
		super();
		this.sentenciasMetodo = sentenciasMetodo;
	}

	/**
	 * Este metodo permite obtener el valor del atributo sentenciasMetodo
	 * @return el sentenciasMetodo
	 */
	public List<SentenciaMetodo> getSentenciasMetodo() {
		return sentenciasMetodo;
	}

	/**
	 * Este metodo permite asignar un valor al atributo sentenciasMetodo
	 * @param sentenciasMetodo se asigna a sentenciasMetodo
	 */
	public void setSentenciasMetodo(List<SentenciaMetodo> sentenciasMetodo) {
		this.sentenciasMetodo = sentenciasMetodo;
	}
}