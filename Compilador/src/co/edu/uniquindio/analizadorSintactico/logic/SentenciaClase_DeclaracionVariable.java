package co.edu.uniquindio.analizadorSintactico.logic;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import co.edu.uniquindio.analizadorLexico.logic.Lenguaje;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de DeclaracionVariable.java y 
 * maneja su información
 */
public class SentenciaClase_DeclaracionVariable extends SentenciaClase
{
	/**
	 * Atributo que contiene el valor de tipoAcceso dentro de la clase
	*/
	private Lenguaje tipoAcceso;
	
	/**
	 * Atributo que contiene el valor de tipo dentro de la clase
	*/
	private Lenguaje tipo;
	
	/**
	 * Atributo que contiene el valor de indentificadoresVariables dentro de la clase
	*/
	private List<Lenguaje> identificadoresVariables;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la DeclaracionVariable.java
	 * @param tipoAcceso
	 * @param tipo
	 * @param indentificadoresVariables
	 */
	public SentenciaClase_DeclaracionVariable(Lenguaje tipoAcceso, Lenguaje tipo,
			List<Lenguaje> identificadoresVariables) {
		super();
		this.tipoAcceso = tipoAcceso;
		this.tipo = tipo;
		this.identificadoresVariables = identificadoresVariables;
	}
	
	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la SentenciaClase_DeclaracionVariable.java
	 */
	public SentenciaClase_DeclaracionVariable() {}
	
	/* (non-Javadoc)
	 * @see co.edu.uniquindio.analizadorSintactico.logic.SentenciaClase#getArbolVisual()
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode miRaiz= new DefaultMutableTreeNode("DeclaracionVariable");
		miRaiz.add(new DefaultMutableTreeNode("Nombre: " + tipoAcceso.getToken()));
		miRaiz.add(new DefaultMutableTreeNode("Nombre: " + tipo.getToken()));
		
		if(identificadoresVariables != null && identificadoresVariables.size()>0)
		{
			DefaultMutableTreeNode raizIdentificadoresVariables= new DefaultMutableTreeNode("Identificadores de Variable");
			
			for(Lenguaje identiVariables : identificadoresVariables)
			{
				raizIdentificadoresVariables.add(new DefaultMutableTreeNode("Nombre: "+identiVariables.getToken()));
			}
			
			miRaiz.add(raizIdentificadoresVariables);
		}
		
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
	 * Este metodo permite obtener el valor del atributo tipo
	 * @return el tipo
	 */
	public Lenguaje getTipo() {
		return tipo;
	}

	/**
	 * Este metodo permite asignar un valor al atributo tipo
	 * @param tipo se asigna a tipo
	 */
	public void setTipo(Lenguaje tipo) {
		this.tipo = tipo;
	}

	/**
	 * Este metodo permite obtener el valor del atributo indentificadoresVariables
	 * @return el indentificadoresVariables
	 */
	public List<Lenguaje> getIdentificadoresVariables() {
		return identificadoresVariables;
	}

	/**
	 * Este metodo permite asignar un valor al atributo indentificadoresVariables
	 * @param identificadoresVariables se asigna a identificadoresVariables
	 */
	public void setIndentificadoresVariables(
			List<Lenguaje> identificadoresVariables) {
		this.identificadoresVariables = identificadoresVariables;
	}
}