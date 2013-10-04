package co.edu.uniquindio.analizadorSintactico.logic;

import java.util.ArrayList;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de Importacion.java y 
 * maneja su información
 */
public class Importacion 
{
	/**
	 * Atributo que contiene el valor de imports dentro de la clase
	*/
	ArrayList<DeclaracionImport> imports;
	
	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la Importacion.java
	 */
	public Importacion() {
		super();
	}

	/**
	 * Este metodo permite obtener el valor del atributo imports
	 * @return el imports
	 */
	public ArrayList<DeclaracionImport> getImports() {
		return imports;
	}

	/**
	 * Este metodo permite asignar un valor al atributo imports
	 * @param imports se asigna a imports
	 */
	public void setImports(ArrayList<DeclaracionImport> imports) {
		this.imports = imports;
	}
}
