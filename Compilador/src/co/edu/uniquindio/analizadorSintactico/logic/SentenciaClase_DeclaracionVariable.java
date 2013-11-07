package co.edu.uniquindio.analizadorSintactico.logic;

import java.util.List;

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
	private List<Lenguaje> indentificadoresVariables;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la DeclaracionVariable.java
	 * @param tipoAcceso
	 * @param tipo
	 * @param indentificadoresVariables
	 */
	public SentenciaClase_DeclaracionVariable(Lenguaje tipoAcceso, Lenguaje tipo,
			List<Lenguaje> indentificadoresVariables) {
		super();
		this.tipoAcceso = tipoAcceso;
		this.tipo = tipo;
		this.indentificadoresVariables = indentificadoresVariables;
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
	public List<Lenguaje> getIndentificadoresVariables() {
		return indentificadoresVariables;
	}

	/**
	 * Este metodo permite asignar un valor al atributo indentificadoresVariables
	 * @param indentificadoresVariables se asigna a indentificadoresVariables
	 */
	public void setIndentificadoresVariables(
			List<Lenguaje> indentificadoresVariables) {
		this.indentificadoresVariables = indentificadoresVariables;
	}
}