package co.edu.uniquindio.analizadorSintactico.logic;

import co.edu.uniquindio.analizadorLexico.logic.Lenguaje;

public class DeclaracionClase 
{
	/**
	 * Atributo que contiene el valor de idClase dentro de la clase
	*/
	private Lenguaje idClase;
	
	/**
	 * Atributo que contiene el valor de instruccionesClase dentro de la clase
	*/
	private InstruccionesClase instruccionesClase;

	public DeclaracionClase(Lenguaje idClase,
			InstruccionesClase instruccionesClase) {
		super();
		this.idClase = idClase;
		this.instruccionesClase = instruccionesClase;
	}

	/**
	 * Este metodo permite obtener el valor del atributo idClase
	 * @return el idClase
	 */
	public Lenguaje getIdClase() {
		return idClase;
	}

	/**
	 * Este metodo permite asignar un valor al atributo idClase
	 * @param idClase se asigna a idClase
	 */
	public void setIdClase(Lenguaje idClase) {
		this.idClase = idClase;
	}

	/**
	 * Este metodo permite obtener el valor del atributo instruccionesClase
	 * @return el instruccionesClase
	 */
	public InstruccionesClase getInstruccionesClase() {
		return instruccionesClase;
	}

	/**
	 * Este metodo permite asignar un valor al atributo instruccionesClase
	 * @param instruccionesClase se asigna a instruccionesClase
	 */
	public void setInstruccionesClase(InstruccionesClase instruccionesClase) {
		this.instruccionesClase = instruccionesClase;
	}
}