package co.edu.uniquindio.analizadorSintactico.logic;

import co.edu.uniquindio.analizadorLexico.logic.Lenguaje;

public class DeclaracionClase 
{
	private Lenguaje identificadorClase;
	
	private InstruccionesClase instruccionesClase;

	public DeclaracionClase(Lenguaje identificadorClase,
			InstruccionesClase instruccionesClase) {
		super();
		this.identificadorClase = identificadorClase;
		this.instruccionesClase = instruccionesClase;
	}

	public Lenguaje getIdentificadorClase() {
		return identificadorClase;
	}

	public void setIdentificadorClase(Lenguaje identificadorClase) {
		this.identificadorClase = identificadorClase;
	}

	public InstruccionesClase getInstruccionesClase() {
		return instruccionesClase;
	}

	public void setInstruccionesClase(InstruccionesClase instruccionesClase) {
		this.instruccionesClase = instruccionesClase;
	}
}