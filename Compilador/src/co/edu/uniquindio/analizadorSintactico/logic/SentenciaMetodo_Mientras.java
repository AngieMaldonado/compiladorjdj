package co.edu.uniquindio.analizadorSintactico.logic;

import javax.jws.Oneway;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de SentenciaMetodo_Mientras.java y 
 * maneja su información
 */
public class SentenciaMetodo_Mientras extends SentenciaMetodo
{
	/**
	 * Atributo que contiene el valor de condiciones dentro de la clase
	*/
	Operacion condiciones;
	
	/**
	 * Atributo que contiene el valor de cuerpoSentencia dentro de la clase
	*/
	SentenciasMetodo cuerpoSentencia;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la SentenciaMetodo_Mientras.java
	 * @param condiciones
	 * @param cuerpoSentencia
	 */
	public SentenciaMetodo_Mientras(Operacion condiciones,
			SentenciasMetodo cuerpoSentencia) {
		super();
		this.condiciones = condiciones;
		this.cuerpoSentencia = cuerpoSentencia;
	}

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la SentenciaMetodo_Mientras.java
	 */
	public SentenciaMetodo_Mientras() {
		
	}
	
	/* (non-Javadoc)
	 * @see co.edu.uniquindio.analizadorSintactico.logic.SentenciaMetodo#getArbolVisual()
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode miRaiz= new DefaultMutableTreeNode("Mientras");
		miRaiz.add(condiciones.getArbolVisual());
		miRaiz.add(cuerpoSentencia.getArbolVisual());
		
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
	 * Este metodo permite obtener el valor del atributo cuerpoSentencia
	 * @return el cuerpoSentencia
	 */
	public SentenciasMetodo getCuerpoSentencia() {
		return cuerpoSentencia;
	}

	/**
	 * Este metodo permite asignar un valor al atributo cuerpoSentencia
	 * @param cuerpoSentencia se asigna a cuerpoSentencia
	 */
	public void setCuerpoSentencia(SentenciasMetodo cuerpoSentencia) {
		this.cuerpoSentencia = cuerpoSentencia;
	}
}