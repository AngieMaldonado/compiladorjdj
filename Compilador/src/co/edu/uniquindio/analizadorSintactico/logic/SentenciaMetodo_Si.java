package co.edu.uniquindio.analizadorSintactico.logic;

import javax.swing.tree.DefaultMutableTreeNode;

import co.edu.uniquindio.analizadorLexico.logic.Lenguaje;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de SentenciaMetodo_Si.java y 
 * maneja su información
 */
public class SentenciaMetodo_Si extends SentenciaMetodo
{
	/**
	 * Atributo que contiene el valor de condiciones dentro de la clase
	*/
	Operacion condiciones;
	
	/**
	 * Atributo que contiene el valor de operaciones dentro de la clase
	*/
	SentenciasMetodo operaciones;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la SentenciaMetodo_Si.java
	 * @param condiciones
	 * @param operaciones
	 */
	public SentenciaMetodo_Si(Operacion condiciones,
			SentenciasMetodo operaciones) {
		super();
		this.condiciones = condiciones;
		this.operaciones = operaciones;
	}
	
	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la SentenciaMetodo_Si.java
	 */
	public SentenciaMetodo_Si() {
		
	}
	
	/* (non-Javadoc)
	 * @see co.edu.uniquindio.analizadorSintactico.logic.SentenciaMetodo#getArbolVisual()
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode("Si");
		miRaiz.add(condiciones.getArbolVisual());
		miRaiz.add(operaciones.getArbolVisual());
		
		return miRaiz;
	}

	/**
	 * Este metodo permite obtener el valor del atributo condiciones
	 * @return el condiciones
	 */
	public Operacion getCondiciones() {
		return condiciones;
	}

	/**
	 * Este metodo permite asignar un valor al atributo condiciones
	 * @param condiciones se asigna a condiciones
	 */
	public void setCondiciones(Operacion condiciones) {
		this.condiciones = condiciones;
	}

	/**
	 * Este metodo permite obtener el valor del atributo operaciones
	 * @return el operaciones
	 */
	public SentenciasMetodo getOperaciones() {
		return operaciones;
	}

	/**
	 * Este metodo permite asignar un valor al atributo operaciones
	 * @param operaciones se asigna a operaciones
	 */
	public void setOperaciones(SentenciasMetodo operaciones) {
		this.operaciones = operaciones;
	}
}