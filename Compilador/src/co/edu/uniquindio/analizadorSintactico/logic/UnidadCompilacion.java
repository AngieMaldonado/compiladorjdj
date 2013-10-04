package co.edu.uniquindio.analizadorSintactico.logic;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de UnidadCompilacion.java y 
 * maneja su información
 */
public class UnidadCompilacion 
{
	/**
	 * Atributo que contiene el valor de paquete dentro de la clase
	*/
	DeclaracionPaquete paquete;
	
	/**
	 * Atributo que contiene el valor de imports dentro de la clase
	*/
	Importacion imports;
	
	/**
	 * Atributo que contiene el valor de clase dentro de la clase
	*/
	DeclaracionClase clase;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la UnidadCompilacion.java
	 * @param paquete
	 * @param imports
	 * @param clase
	 */
	public UnidadCompilacion(DeclaracionPaquete paquete, Importacion imports,
			DeclaracionClase clase) {
		super();
		this.paquete = paquete;
		this.imports = imports;
		this.clase = clase;
	}

	/**
	 * Este metodo permite obtener el valor del atributo paquete
	 * @return el paquete
	 */
	public DeclaracionPaquete getPaquete() {
		return paquete;
	}

	/**
	 * Este metodo permite asignar un valor al atributo paquete
	 * @param paquete se asigna a paquete
	 */
	public void setPaquete(DeclaracionPaquete paquete) {
		this.paquete = paquete;
	}

	/**
	 * Este metodo permite obtener el valor del atributo imports
	 * @return el imports
	 */
	public Importacion getImports() {
		return imports;
	}

	/**
	 * Este metodo permite asignar un valor al atributo imports
	 * @param imports se asigna a imports
	 */
	public void setImports(Importacion imports) {
		this.imports = imports;
	}

	/**
	 * Este metodo permite obtener el valor del atributo clase
	 * @return el clase
	 */
	public DeclaracionClase getClase() {
		return clase;
	}

	/**
	 * Este metodo permite asignar un valor al atributo clase
	 * @param clase se asigna a clase
	 */
	public void setClase(DeclaracionClase clase) {
		this.clase = clase;
	}
}