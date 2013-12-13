package co.edu.uniquindio.analizadorSintactico.logic;

import javax.swing.tree.DefaultMutableTreeNode;

import co.edu.uniquindio.analizadorLexico.logic.Lenguaje;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de Paquete.java y 
 * maneja su información
 */
public class Paquete 
{
	/**
	 * Atributo que contiene el valor de identificadorPaquete dentro de la clase
	*/
	private Lenguaje identificadorPaquete;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la Paquete.java
	 * @param identificadorPaquete
	 */
	public Paquete(Lenguaje identificadorPaquete) {
		super();
		this.identificadorPaquete = identificadorPaquete;
	}
	
	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la Paquete.java
	 */
	public Paquete() {}

	/**
	 * Este metodo permite obtener el valor del atributo identificadorPaquete
	 * @return el identificadorPaquete
	 */
	public Lenguaje getIdentificadorPaquete() {
		return identificadorPaquete;
	}

	/**
	 * Este metodo permite asignar un valor al atributo identificadorPaquete
	 * @param identificadorPaquete se asigna a identificadorPaquete
	 */
	public void setIdentificadorPaquete(Lenguaje identificadorPaquete) {
		this.identificadorPaquete = identificadorPaquete;
	}

	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode miRaiz= new DefaultMutableTreeNode("Paquete");
		miRaiz.add(new DefaultMutableTreeNode("Nombre: "+identificadorPaquete.getToken()));
		
		return miRaiz;
	}
	
	/**
	 * El codigo en java
	 * @return java code
	 */
	public String getJavaCode(){
		return "package "+identificadorPaquete.getToken()+";";
	}
}