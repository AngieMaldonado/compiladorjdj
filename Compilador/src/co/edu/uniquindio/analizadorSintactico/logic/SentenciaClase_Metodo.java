package co.edu.uniquindio.analizadorSintactico.logic;

import javax.swing.tree.DefaultMutableTreeNode;

import co.edu.uniquindio.analizadorLexico.logic.Lenguaje;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de Metodo.java y 
 * maneja su información
 */
public class SentenciaClase_Metodo extends SentenciaClase
{
	/**
	 * Atributo que contiene el valor de tipoAcceso dentro de la clase
	*/
	private Lenguaje tipoAcceso;
	
	/**
	 * Atributo que contiene el valor de tipoRetorno dentro de la clase
	*/
	private Lenguaje tipoRetorno;
	
	/**
	 * Atributo que contiene el valor de identificadorMetodo dentro de la clase
	*/
	private Lenguaje identificadorMetodo;
	
	/**
	 * Atributo que contiene el valor de parametros dentro de la clase
	*/
	private Parametros parametros;
	
	/**
	 * Atributo que contiene el valor de cuerpoMetodo dentro de la clase
	*/
	private SentenciasMetodo cuerpoMetodo;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la Metodo.java
	 * @param tipoAcceso
	 * @param tipoRetorno
	 * @param identificadorMetodo
	 * @param parametros
	 * @param cuerpoMetodo
	 */
	public SentenciaClase_Metodo(Lenguaje tipoAcceso, Lenguaje tipoRetorno,
			Lenguaje identificadorMetodo, Parametros parametros,
			SentenciasMetodo cuerpoMetodo) {
		super();
		this.tipoAcceso = tipoAcceso;
		this.tipoRetorno = tipoRetorno;
		this.identificadorMetodo = identificadorMetodo;
		this.parametros = parametros;
		this.cuerpoMetodo = cuerpoMetodo;
	}
	
	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la SentenciaClase_Metodo.java
	 */
	public SentenciaClase_Metodo(){}

	/* (non-Javadoc)
	 * @see co.edu.uniquindio.analizadorSintactico.logic.SentenciaClase#getArbolVisual()
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode miRaiz= new DefaultMutableTreeNode("Metodo");
		miRaiz.add(new DefaultMutableTreeNode("Nombre: "+ tipoAcceso.getToken()));
		miRaiz.add(new DefaultMutableTreeNode("Nombre: " + tipoRetorno.getToken()));
		miRaiz.add(new DefaultMutableTreeNode("Nombre: " + identificadorMetodo.getToken()));
		miRaiz.add(parametros.getArbolVisual());
		miRaiz.add(cuerpoMetodo.getArbolVisual());
		
		return miRaiz;
	}
	
	/**
	 * Este metodo permite obtener el valor del atributo tipoAcceso
	 * @return el tipoAcceso
	 */
	public Lenguaje getTipoAcceso() {
		return tipoAcceso;
	}

	/**
	 * Este metodo permite asignar un valor al atributo tipoAcceso
	 * @param tipoAcceso se asigna a tipoAcceso
	 */
	public void setTipoAcceso(Lenguaje tipoAcceso) {
		this.tipoAcceso = tipoAcceso;
	}

	/**
	 * Este metodo permite obtener el valor del atributo tipoRetorno
	 * @return el tipoRetorno
	 */
	public Lenguaje getTipoRetorno() {
		return tipoRetorno;
	}

	/**
	 * Este metodo permite asignar un valor al atributo tipoRetorno
	 * @param tipoRetorno se asigna a tipoRetorno
	 */
	public void setTipoRetorno(Lenguaje tipoRetorno) {
		this.tipoRetorno = tipoRetorno;
	}

	/**
	 * Este metodo permite obtener el valor del atributo identificadorMetodo
	 * @return el identificadorMetodo
	 */
	public Lenguaje getIdentificadorMetodo() {
		return identificadorMetodo;
	}

	/**
	 * Este metodo permite asignar un valor al atributo identificadorMetodo
	 * @param identificadorMetodo se asigna a identificadorMetodo
	 */
	public void setIdentificadorMetodo(Lenguaje identificadorMetodo) {
		this.identificadorMetodo = identificadorMetodo;
	}

	/**
	 * Este metodo permite obtener el valor del atributo parametros
	 * @return el parametros
	 */
	public Parametros getParametros() {
		return parametros;
	}

	/**
	 * Este metodo permite asignar un valor al atributo parametros
	 * @param parametros se asigna a parametros
	 */
	public void setParametros(Parametros parametros) {
		this.parametros = parametros;
	}

	/**
	 * Este metodo permite obtener el valor del atributo cuerpoMetodo
	 * @return el cuerpoMetodo
	 */
	public SentenciasMetodo getCuerpoMetodo() {
		return cuerpoMetodo;
	}

	/**
	 * Este metodo permite asignar un valor al atributo cuerpoMetodo
	 * @param cuerpoMetodo se asigna a cuerpoMetodo
	 */
	public void setCuerpoMetodo(SentenciasMetodo cuerpoMetodo) {
		this.cuerpoMetodo = cuerpoMetodo;
	}
}