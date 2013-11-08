package co.edu.uniquindio.analizadorSintactico.logic;

import co.edu.uniquindio.analizadorLexico.logic.Lenguaje;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de SentenciaMetodo_DeclaracionVariable.java y 
 * maneja su información
 */
public class SentenciaMetodo_DeclaracionVariable extends SentenciaMetodo
{
	/**
	 * Atributo que contiene el valor de tipo dentro de la clase
	*/
	Lenguaje tipo;
	
	/**
	 * Atributo que contiene el valor de identificadorVariable dentro de la clase
	*/
	Lenguaje identificadorVariable;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la SentenciaMetodo_DeclaracionVariable.java
	 * @param tipo
	 * @param identificadorVariable
	 */
	public SentenciaMetodo_DeclaracionVariable(Lenguaje tipo,
			Lenguaje identificadorVariable) {
		super();
		this.tipo = tipo;
		this.identificadorVariable = identificadorVariable;
	}

	/**
	 * Este metodo permite obtener el valor del atributo tipo
	 * @return el tipo
	 */
	public Lenguaje getTipo() {
		return tipo;
	}

	/**
	 * Este metodo permite asignar un valor al atributo tipo
	 * @param tipo se asigna a tipo
	 */
	public void setTipo(Lenguaje tipo) {
		this.tipo = tipo;
	}

	/**
	 * Este metodo permite obtener el valor del atributo identificadorVariable
	 * @return el identificadorVariable
	 */
	public Lenguaje getIdentificadorVariable() {
		return identificadorVariable;
	}

	/**
	 * Este metodo permite asignar un valor al atributo identificadorVariable
	 * @param identificadorVariable se asigna a identificadorVariable
	 */
	public void setIdentificadorVariable(Lenguaje identificadorVariable) {
		this.identificadorVariable = identificadorVariable;
	}
}
