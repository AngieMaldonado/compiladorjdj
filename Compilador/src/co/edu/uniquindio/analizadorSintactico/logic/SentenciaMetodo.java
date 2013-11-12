package co.edu.uniquindio.analizadorSintactico.logic;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de SentenciaMetodo.java y 
 * maneja su información
 */
public abstract class SentenciaMetodo 
{
	/**
	 * @return miRaiz la cual contendra el arbol grafico de esta clase
	 */
	public abstract DefaultMutableTreeNode getArbolVisual();
}
