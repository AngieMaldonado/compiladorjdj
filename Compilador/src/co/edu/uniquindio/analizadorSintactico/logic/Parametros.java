package co.edu.uniquindio.analizadorSintactico.logic;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de Parametros.java y 
 * maneja su información
 */
public class Parametros 
{
	/**
	 * Atributo que contiene el valor de parametros dentro de la clase
	*/
	List<Parametro> parametros;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la Parametros.java
	 * @param parametros
	 */
	public Parametros(List<Parametro> parametros) {
		super();
		this.parametros = parametros;
	}
	
	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la Parametros.java
	 */
	public Parametros(){}
	
	/**
	 * @return miRaiz la cual contendra el arbol grafico de esta clase
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode("Parametros");
		
		if(parametros != null && parametros.size()>0)
		{
			DefaultMutableTreeNode raizParametros= new DefaultMutableTreeNode("VariosParametros");
			
			for (Parametro parametro: parametros) 
			{
				raizParametros.add(parametro.getArbolVisual());
			}
			miRaiz.add(raizParametros);
		}
		
		return miRaiz;
	}

	/**
	 * Este metodo permite obtener el valor del atributo parametros
	 * @return el parametros
	 */
	public List<Parametro> getParametros() {
		return parametros;
	}

	/**
	 * Este metodo permite asignar un valor al atributo parametros
	 * @param parametros se asigna a parametros
	 */
	public void setParametros(List<Parametro> parametros) {
		this.parametros = parametros;
	}
}