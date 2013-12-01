package co.edu.uniquindio.analizadorSintactico.logic;

public class ErrorSintactico {
	private String msgError; 
	 private int fila, columna; 
	 
	 public ErrorSintactico( String msgError, int fila, int columna) 
	{ 
	this.msgError=msgError; 
	this.fila = fila; 
	this.columna = columna ; 
	}

	public String getMsgError() {
		return msgError;
	}

	public void setMsgError(String msgError) {
		this.msgError = msgError;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	} 
	 
	 
}
