package co.edu.uniquindio.analizadorSintactico.logic;

import java.util.List;

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
	List<Import> imports;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la Importacion.java
	 * @param token
	 * @param imports
	 */
	public Importacion(List<Import> imports) {
		super();
		this.imports = imports;
	}

	/**
	 * Este metodo permite obtener el valor del atributo imports
	 * @return el imports
	 */
	public List<Import> getImports() {
		return imports;
	}

	/**
	 * Este metodo permite asignar un valor al atributo imports
	 * @param imports se asigna a imports
	 */
	public void setImports(List<Import> imports) {
		this.imports = imports;
	}
}