package co.edu.uniquindio.analizadorSintactico.logic;

import co.edu.uniquindio.analizadorLexico.logic.Lenguaje;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de DeclaracionMetodo.java y 
 * maneja su información
 */
public class DeclaracionMetodo implements InstruccionClase
{
	/**
	 * Atributo que contiene el valor de idMetodo dentro de la clase
	*/
	private Lenguaje idMetodo;
	
	/**
	 * Atributo que contiene el valor de parametros dentro de la clase
	*/
	private BloqueParametro parametros;
	
	/**
	 * Atributo que contiene el valor de bloqueInstrucciones dentro de la clase
	*/
	private BloqueInstruccion bloqueInstrucciones;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la DeclaracionMetodo.java
	 * @param idMetodo
	 * @param parametros
	 * @param bloqueInstrucciones
	 */
	public DeclaracionMetodo(Lenguaje idMetodo,
			BloqueParametro parametros, BloqueInstruccion bloqueInstrucciones) {
		super();
		this.idMetodo = idMetodo;
		this.parametros = parametros;
		this.bloqueInstrucciones = bloqueInstrucciones;
	}

	/**
	 * Este metodo permite obtener el valor del atributo idMetodo
	 * @return el idMetodo
	 */
	public Lenguaje getIdMetodo() {
		return idMetodo;
	}

	/**
	 * Este metodo permite asignar un valor al atributo idMetodo
	 * @param idMetodo se asigna a idMetodo
	 */
	public void setIdMetodo(Lenguaje idMetodo) {
		this.idMetodo = idMetodo;
	}

	/**
	 * Este metodo permite obtener el valor del atributo parametros
	 * @return el parametros
	 */
	public BloqueParametro getParametros() {
		return parametros;
	}

	/**
	 * Este metodo permite asignar un valor al atributo parametros
	 * @param parametros se asigna a parametros
	 */
	public void setParametros(BloqueParametro parametros) {
		this.parametros = parametros;
	}

	/**
	 * Este metodo permite obtener el valor del atributo bloqueInstrucciones
	 * @return el bloqueInstrucciones
	 */
	public BloqueInstruccion getBloqueInstrucciones() {
		return bloqueInstrucciones;
	}

	/**
	 * Este metodo permite asignar un valor al atributo bloqueInstrucciones
	 * @param bloqueInstrucciones se asigna a bloqueInstrucciones
	 */
	public void setBloqueInstrucciones(BloqueInstruccion bloqueInstrucciones) {
		this.bloqueInstrucciones = bloqueInstrucciones;
	}
}