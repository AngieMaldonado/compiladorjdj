package co.edu.uniquindio.analizadorSintactico.logic;

import javax.swing.tree.DefaultMutableTreeNode;

import co.edu.uniquindio.analizadorLexico.logic.Lenguaje;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de Import.java y 
 * maneja su información
 */
public class Import 
{	
	/**
	 * Atributo que contiene el valor de identificadorClase dentro de la clase
	*/
	private Lenguaje identificadorClase;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la Import.java
	 * @param identificadorClase
	 */
	public Import(Lenguaje identificadorClase) {
		super();
		this.identificadorClase = identificadorClase;
	}
	
	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la Import.java
	 */
	public Import(){}

	/**
	 * @return miRaiz la cual contendra el arbol grafico de esta clase
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode miRaiz= new DefaultMutableTreeNode("Import");
		miRaiz.add(new DefaultMutableTreeNode("Nombre: "+identificadorClase.getToken()));
		
		return miRaiz;
	}
	
	/**
	 * Este metodo permite obtener el valor del atributo identificadorClase
	 * @return el identificadorClase
	 */
	public Lenguaje getIdentificadorClase() {
		return identificadorClase;
	}

	/**
	 * Este metodo permite asignar un valor al atributo identificadorClase
	 * @param identificadorClase se asigna a identificadorClase
	 */
	public void setIdentificadorClase(Lenguaje identificadorClase) {
		this.identificadorClase = identificadorClase;
	}
}