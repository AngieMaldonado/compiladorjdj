package co.edu.uniquindio.analizadorSintactico.logic;

import java.util.ArrayList;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de InstruccionesClase.java y 
 * maneja su información
 */
public class InstruccionesClase 
{
	/**
	 * Atributo que contiene el valor de instrucciones dentro de la clase
	*/
	private ArrayList<InstruccionClase> instrucciones;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la InstruccionesClase.java
	 * @param instrucciones
	 */
	public InstruccionesClase(ArrayList<InstruccionClase> instrucciones) {
		super();
		this.instrucciones = instrucciones;
	}

	/**
	 * Este metodo permite obtener el valor del atributo instrucciones
	 * @return el instrucciones
	 */
	public ArrayList<InstruccionClase> getInstrucciones() {
		return instrucciones;
	}

	/**
	 * Este metodo permite asignar un valor al atributo instrucciones
	 * @param instrucciones se asigna a instrucciones
	 */
	public void setInstrucciones(ArrayList<InstruccionClase> instrucciones) {
		this.instrucciones = instrucciones;
	}
}