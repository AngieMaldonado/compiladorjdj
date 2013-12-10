package co.edu.uniquindio.analizadorSintactico.logic;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import co.edu.uniquindio.analizadorSemantico.logic.TablaSimbolos;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de UnidadCompilacion.java y 
 * maneja su información
 */
public class UnidadCompilacion 
{
	/**
	 * Atributo que contiene el valor de paquete dentro de la clase
	*/
	private Paquete paquete;
	
	/**
	 * Atributo que contiene el valor de imports dentro de la clase
	*/
	private Importacion imports;
	
	/**
	 * Atributo que contiene el valor de declaracionClase dentro de la clase
	*/
	private Clase declaracionClase;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la UnidadCompilacion.java
	 * @param paquete
	 * @param imports
	 * @param declaracionClase
	 */
	public UnidadCompilacion(Paquete paquete, Importacion imports,
			Clase declaracionClase) {
		super();
		this.paquete = paquete;
		this.imports = imports;
		this.declaracionClase = declaracionClase;
	}

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la UnidadCompilacion.java
	 */
	public UnidadCompilacion() {}
	
	/**
	 * @return miRaiz la cual contendra el arbol grafico de esta clase
	 */
	public DefaultMutableTreeNode getArbolVisual() 
	 { 
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode("Unidad de Compilación"); 
		miRaiz.add(paquete.getArbolVisual());
		miRaiz.add(imports.getArbolVisual());
		miRaiz.add(declaracionClase.getArbolVisual());
	 
		return miRaiz; 
	 } 

	
	/**
	 * Este metodo permite obtener el valor del atributo paquete
	 * @return el paquete
	 */
	public Paquete getPaquete() {
		return paquete;
	}

	/**
	 * Este metodo permite asignar un valor al atributo paquete
	 * @param paquete se asigna a paquete
	 */
	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}

	/**
	 * Este metodo permite obtener el valor del atributo imports
	 * @return el imports
	 */
	public Importacion getImports() {
		return imports;
	}

	/**
	 * Este metodo permite asignar un valor al atributo imports
	 * @param imports se asigna a imports
	 */
	public void setImports(Importacion imports) {
		this.imports = imports;
	}

	/**
	 * Este metodo permite obtener el valor del atributo declaracionClase
	 * @return el declaracionClase
	 */
	public Clase getDeclaracionClase() {
		return declaracionClase;
	}

	/**
	 * Este metodo permite asignar un valor al atributo declaracionClase
	 * @param declaracionClase se asigna a declaracionClase
	 */
	public void setDeclaracionClase(Clase declaracionClase) {
		this.declaracionClase = declaracionClase;
	}
	
	/**
	 * @param tablaSimbolos
	 * @param errores
	 */
	public void analizarSemantica(TablaSimbolos tablaSimbolos,
			ArrayList<Error> errores) {
		// TODO : COMPLETAR
	}
}