package co.edu.uniquindio.analizadorSintactico.logic;

import co.edu.uniquindio.analizadorLexico.logic.Lenguaje;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de SentenciaMetodo_Delocontrario.java y 
 * maneja su información
 */
public class SentenciaMetodo_Delocontrario extends SentenciaMetodo
{	
	/**
	 * Atributo que contiene el valor de operaciones dentro de la clase
	*/
	SentenciasMetodo operaciones;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la SentenciaMetodo_Delocontrario.java
	 * @param operaciones
	 */
	public SentenciaMetodo_Delocontrario(SentenciasMetodo operaciones) {
		super();
		this.operaciones = operaciones;
	}

	/**
	 * Este metodo permite obtener el valor del atributo operaciones
	 * @return el operaciones
	 */
	public SentenciasMetodo getOperaciones() {
		return operaciones;
	}

	/**
	 * Este metodo permite asignar un valor al atributo operaciones
	 * @param operaciones se asigna a operaciones
	 */
	public void setOperaciones(SentenciasMetodo operaciones) {
		this.operaciones = operaciones;
	}
}