package co.edu.uniquindio.analizadorSintactico.logic;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de InstruccionesClase.java y 
 * maneja su información
 */
public class SentenciasClase 
{
	/**
	 * Atributo que contiene el valor de sentencias dentro de la clase
	*/
	private List<SentenciaClase> sentencias;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la SentenciasClase.java
	 * @param sentencias
	 */
	public SentenciasClase(List<SentenciaClase> sentencias) {
		super();
		this.sentencias = sentencias;
	}

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la SentenciasClase.java
	 */
	public SentenciasClase(){}
	
	/**
	 * @return miRaiz la cual contendra el arbol grafico de esta clase
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode miRaiz= new DefaultMutableTreeNode("SentenciasClase");
			
			if(sentencias !=null && sentencias.size()>0)
			{
				DefaultMutableTreeNode raizSentencia= new DefaultMutableTreeNode("Imports");
				
				for(SentenciaClase sentenciaclase : sentencias)
				{
					raizSentencia.add(sentenciaclase.getArbolVisual());
				}
				
				miRaiz.add(raizSentencia);
			}		
		return miRaiz;
	}
	
	/**
	 * Este metodo permite obtener el valor del atributo sentencias
	 * @return el sentencias
	 */
	public List<SentenciaClase> getSentencias() {
		return sentencias;
	}

	/**
	 * Este metodo permite asignar un valor al atributo sentencias
	 * @param sentencias se asigna a sentencias
	 */
	public void setSentencias(List<SentenciaClase> sentencias) {
		this.sentencias = sentencias;
	}
}
