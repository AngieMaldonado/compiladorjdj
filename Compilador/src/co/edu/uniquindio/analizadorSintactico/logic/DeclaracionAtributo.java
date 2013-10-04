package co.edu.uniquindio.analizadorSintactico.logic;

import co.edu.uniquindio.analizadorLexico.logic.Lenguaje;

public class DeclaracionAtributo extends InstruccionClase 
{
	private Lenguaje identificadorVariable;
	
	private Expresion expresion;

	public DeclaracionAtributo(Lenguaje identificadorVariable, Expresion expresion) {
		super();
		this.identificadorVariable = identificadorVariable;
		this.expresion = expresion;
	}

	public Lenguaje getIdentificadorVariable() {
		return identificadorVariable;
	}

	public void setIdentificadorVariable(Lenguaje identificadorVariable) {
		this.identificadorVariable = identificadorVariable;
	}

	public Expresion getExpresion() {
		return expresion;
	}

	public void setExpresion(Expresion expresion) {
		this.expresion = expresion;
	}
}
