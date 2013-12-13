package co.edu.uniquindio.analizadorSintactico.logic;

import javax.swing.tree.DefaultMutableTreeNode;

import co.edu.uniquindio.analizadorLexico.logic.Lenguaje;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de SentenciaMetodo_Asignacion.java y 
 * maneja su información
 */
public class SentenciaMetodo_Asignacion extends SentenciaMetodo
{
	/**
	 * Atributo que contiene el valor de variable dentro de la clase
	*/
	private Lenguaje variable;
	
	/**
	 * Atributo que contiene el valor de valor dentro de la clase
	*/
	private Operacion valor;
	
	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la SentenciaMetodo_Asignacion.java
	 * @param variable
	 * @param valor
	 */
	public SentenciaMetodo_Asignacion(Lenguaje variable, Operacion valor) {
		super();
		this.variable = variable;
		this.valor = valor;
	}

	/**
	 * Este metodo permite obtener el valor del atributo variable
	 * @return el variable
	 */
	public Lenguaje getVariable() {
		return variable;
	}

	/**
	 * Este metodo permite asignar un valor al atributo variable
	 * @param variable se asigna a variable
	 */
	public void setVariable(Lenguaje variable) {
		this.variable = variable;
	}

	/**
	 * Este metodo permite obtener el valor del atributo valor
	 * @return el valor
	 */
	public Operacion getValor() {
		return valor;
	}

	/**
	 * Este metodo permite asignar un valor al atributo valor
	 * @param valor se asigna a valor
	 */
	public void setValor(Operacion valor) {
		this.valor = valor;
	}

	/* (non-Javadoc)
	 * @see co.edu.uniquindio.analizadorSintactico.logic.SentenciaMetodo#getArbolVisual()
	 */
	@Override
	public DefaultMutableTreeNode getArbolVisual() {
		// TODO Auto-generated method stub
		return null;
	}
}