package co.edu.uniquindio.analizadorSintactico.logic;

import javax.swing.tree.DefaultMutableTreeNode;

import co.edu.uniquindio.analizadorLexico.logic.Lenguaje;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de Clase.java y 
 * maneja su información
 */
public class Clase {

	/**
	 * Atributo que contiene el valor de identificadorClase dentro de la clase
	*/
	Lenguaje identificadorClase;

	/**
	 * Atributo que contiene el valor de cuerpoClase dentro de la clase
	*/
	SentenciasClase cuerpoClase;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la Clase.java
	 * @param identificadorClase
	 * @param cuerpoClase
	 */
	public Clase(Lenguaje identificadorClase, SentenciasClase cuerpoClase) {
		super();
		this.identificadorClase = identificadorClase;
		this.cuerpoClase = cuerpoClase;
	}

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la Clase.java
	 */
	public Clase() {}
	
	/**
	 * @return miRaiz la cual contendra el arbol grafico de esta clase
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode miRaiz= new DefaultMutableTreeNode("Clase");
		miRaiz.add(new DefaultMutableTreeNode("Nombre: "+identificadorClase.getToken()));
		miRaiz.add(cuerpoClase.getArbolVisual());
		
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

	/**
	 * Este metodo permite obtener el valor del atributo cuerpoClase
	 * @return el cuerpoClase
	 */
	public SentenciasClase getCuerpoClase() {
		return cuerpoClase;
	}

	/**
	 * Este metodo permite asignar un valor al atributo cuerpoClase
	 * @param cuerpoClase se asigna a cuerpoClase
	 */
	public void setCuerpoClase(SentenciasClase cuerpoClase) {
		this.cuerpoClase = cuerpoClase;
	}
}