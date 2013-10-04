package co.edu.uniquindio.analizadorSintactico.logic;

import java.util.List;

public class InstruccionesClase 
{
	private List<InstruccionClase> instrucciones;

	public InstruccionesClase(List<InstruccionClase> instrucciones) {
		super();
		this.instrucciones = instrucciones;
	}

	public List<InstruccionClase> getInstrucciones() {
		return instrucciones;
	}

	public void setInstrucciones(List<InstruccionClase> instrucciones) {
		this.instrucciones = instrucciones;
	}
}
