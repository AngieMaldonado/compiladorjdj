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
	 * Atributo que contiene el valor de tipoParametro dentro de la clase
	*/
	Lenguaje tipoParametro;
	
	/**
	 * Atributo que contiene el valor de identificadorParametro dentro de la clase
	*/
	Lenguaje identificadorParametro;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la Parametro.java
	 * @param tipoParametro
	 * @param identificadorParametro
	 */
	public Parametro(Lenguaje tipoParametro, Lenguaje identificadorParametro) {
		super();
		this.tipoParametro = tipoParametro;
		this.identificadorParametro = identificadorParametro;
	}

	/**
	 * Este metodo permite obtener el valor del atributo tipoParametro
	 * @return el tipoParametro
	 */
	public Lenguaje getTipoParametro() {
		return tipoParametro;
	}

	/**
	 * Este metodo permite asignar un valor al atributo tipoParametro
	 * @param tipoParametro se asigna a tipoParametro
	 */
	public void setTipoParametro(Lenguaje tipoParametro) {
		this.tipoParametro = tipoParametro;
	}

	/**
	 * Este metodo permite obtener el valor del atributo identificadorParametro
	 * @return el identificadorParametro
	 */
	public Lenguaje getIdentificadorParametro() {
		return identificadorParametro;
	}

	/**
	 * Este metodo permite asignar un valor al atributo identificadorParametro
	 * @param identificadorParametro se asigna a identificadorParametro
	 */
	public void setIdentificadorParametro(Lenguaje identificadorParametro) {
		this.identificadorParametro = identificadorParametro;
	}
}