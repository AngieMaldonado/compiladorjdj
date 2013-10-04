package co.edu.uniquindio.analizadorSintactico.logic;

import co.edu.uniquindio.analizadorLexico.logic.Lenguaje;

public class DeclaracionMetodo extends InstruccionClase
{
	private Lenguaje identificadorMetodo;
	
	private BloqueParametro parametros;
	
	private BloqueInstruccion bloqueInstrucciones;

	public DeclaracionMetodo(Lenguaje identificadorMetodo,
			BloqueParametro parametros, BloqueInstruccion bloqueInstrucciones) {
		super();
		this.identificadorMetodo = identificadorMetodo;
		this.parametros = parametros;
		this.bloqueInstrucciones = bloqueInstrucciones;
	}

	public Lenguaje getIdentificadorMetodo() {
		return identificadorMetodo;
	}

	public void setIdentificadorMetodo(Lenguaje identificadorMetodo) {
		this.identificadorMetodo = identificadorMetodo;
	}

	public BloqueParametro getParametros() {
		return parametros;
	}

	public void setParametros(BloqueParametro parametros) {
		this.parametros = parametros;
	}

	public BloqueInstruccion getBloqueInstrucciones() {
		return bloqueInstrucciones;
	}

	public void setBloqueInstrucciones(BloqueInstruccion bloqueInstrucciones) {
		this.bloqueInstrucciones = bloqueInstrucciones;
	}
}