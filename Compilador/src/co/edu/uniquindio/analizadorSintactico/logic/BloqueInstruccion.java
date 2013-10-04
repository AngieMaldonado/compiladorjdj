package co.edu.uniquindio.analizadorSintactico.logic;

import java.util.ArrayList;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de BloqueInstruccion.java y 
 * maneja su información
 */
public class BloqueInstruccion 
{	
	/**
	 * Atributo que contiene el valor de instrucciones dentro de la clase
	*/
	ArrayList<Instruccion> instrucciones;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la BloqueInstruccion.java
	 * @param idBloqueInstruccion
	 */
	public BloqueInstruccion() {
		super();
	}

	/**
	 * Este metodo permite obtener el valor del atributo instrucciones
	 * @return el instrucciones
	 */
	public ArrayList<Instruccion> getInstrucciones() {
		return instrucciones;
	}

	/**
	 * Este metodo permite asignar un valor al atributo instrucciones
	 * @param instrucciones se asigna a instrucciones
	 */
	public void setInstrucciones(ArrayList<Instruccion> instrucciones) {
		this.instrucciones = instrucciones;
	}
}