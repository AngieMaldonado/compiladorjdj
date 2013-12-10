package co.edu.uniquindio.analizadorSemantico.logic;

import java.util.ArrayList;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de Simbolos.java y 
 * maneja su información
 */
public class Simbolo 
{	
	/**
	 * Atributo que contiene el valor de nombre dentro de la clase
	*/
	String nombre;
	
	/**
	 * Atributo que contiene el valor de ambito dentro de la clase
	*/
	String ambito;
	
	/**
	 * Atributo que contiene el valor de ret dentro de la clase
	*/
	String ret;
	
	/**
	 * Atributo que contiene el valor de params dentro de la clase
	*/
	ArrayList<String> params;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la Simbolo.java
	 * @param nombre
	 * @param ambito
	 * @param ret
	 */
	public Simbolo(String nombre, String ambito, String ret) {
		super();
		this.nombre = nombre;
		this.ambito = ambito;
		this.ret = ret;
	}
	
	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la Simbolo.java
	 * @param nombre
	 * @param ambito
	 * @param ret
	 * @param params
	 */
	public Simbolo(String nombre, String ambito, String ret,
			ArrayList<String> params) {
		super();
		this.nombre = nombre;
		this.ambito = ambito;
		this.ret = ret;
		this.params = params;
	}

	/**
	 * Este metodo permite obtener el valor del atributo nombre
	 * @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Este metodo permite asignar un valor al atributo nombre
	 * @param nombre se asigna a nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Este metodo permite obtener el valor del atributo ambito
	 * @return el ambito
	 */
	public String getAmbito() {
		return ambito;
	}

	/**
	 * Este metodo permite asignar un valor al atributo ambito
	 * @param ambito se asigna a ambito
	 */
	public void setAmbito(String ambito) {
		this.ambito = ambito;
	}

	/**
	 * Este metodo permite obtener el valor del atributo ret
	 * @return el ret
	 */
	public String getRet() {
		return ret;
	}

	/**
	 * Este metodo permite asignar un valor al atributo ret
	 * @param ret se asigna a ret
	 */
	public void setRet(String ret) {
		this.ret = ret;
	}

	/**
	 * Este metodo permite obtener el valor del atributo params
	 * @return el params
	 */
	public ArrayList<String> getParams() {
		return params;
	}

	/**
	 * Este metodo permite asignar un valor al atributo params
	 * @param params se asigna a params
	 */
	public void setParams(ArrayList<String> params) {
		this.params = params;
	}
}