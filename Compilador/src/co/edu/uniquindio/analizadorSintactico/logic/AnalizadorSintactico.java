/**
 *
 */
package co.edu.uniquindio.analizadorSintactico.logic;

import java.util.ArrayList;

import co.edu.uniquindio.analizadorLexico.logic.AnalizadorLexico;
import co.edu.uniquindio.analizadorLexico.logic.Lenguaje;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de AnalizadorSintactico.java y 
 * maneja su informaciÃ³n
 */
public class AnalizadorSintactico 
{
	/**
	 * Atributo que contiene el valor de listaSimbolosLexicos dentro de la clase
	*/
	private ArrayList<Lenguaje> listaSimbolosLexicos;
	
	/**
	 * Atributo que contiene el valor de token dentro de la clase
	*/
	private Lenguaje tokenActual;
	
	/**
	 * Atributo que contiene el valor de indice dentro de la clase
	*/
	private int indice;
	
	/**
	 * Atributo que contiene el valor de unidadDeCompilacion dentro de la clase
	*/
	private UnidadCompilacion unidadDeCompilacion;
	
	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la AnalizadorSintactico.java
	 * @param listasimbolos la cual es la que le envia el analizador lexico al sintactico
	 */
	public AnalizadorSintactico(ArrayList<Lenguaje> listasimbolos)
	{
		listaSimbolosLexicos=listasimbolos;
//		listaErroresSintacticos = new ArrayList<ErrorSintactico>(); 
		indice = 0; 
		tokenActual = listaSimbolosLexicos.get(indice); 
		unidadDeCompilacion = esUnidadDeCompilacion(); 

	}
	
	/**
	 * Metodo usado para avanzar de token
	 */
	public void darSiguienteToken() 
	{ 
		if(indice == listaSimbolosLexicos.size()-1) 
		{ 
			return; 
	 
		}else 
		{ 
			indice++; 
			tokenActual = listaSimbolosLexicos.get(indice); 
		} 
	 } 
	 
	/**
	 * metodo para realizar el bactraking
	 * @param posBT posicion inicial
	 */
	public void realizarBactracking(int posBT) 
	{ 
		indice = posBT; 
		tokenActual = listaSimbolosLexicos.get(indice); 
	}

	/**
	 * Este metodo permite obtener el valor del atributo listaSimbolosLexicos
	 * @return el listaSimbolosLexicos
	 */
	public ArrayList<Lenguaje> getListaSimbolosLexicos() {
		return listaSimbolosLexicos;
	} 
	
	public UnidadCompilacion esUnidadDeCompilacion()
	{
		Paquete paquete= esPaquete();
		
		if(paquete==null)
		{
			//manejo de error
		}
		
		Importacion importacion= esImportacion();
		
		Clase clase= esClase();
		
		if(clase==null)
		{
			//manejo de error
		}
		
		
		return new UnidadCompilacion(paquete, importacion, clase);
	}
	
	public Paquete esPaquete()
	{
		Lenguaje identificador= null;
		
		if(tokenActual.getToken().equals("paquete"))
		{
			darSiguienteToken();
		}
		else
		{
			return null;
		}
		
		if(tokenActual.getTipoToken().equals("Identificador de paquete"))
		{
			identificador=tokenActual;
			darSiguienteToken();
		}
		else
		{
			//manejo de error;
		}
		
		if(tokenActual.getToken().equals("."))
		{
			darSiguienteToken();
			return new Paquete(identificador);
		}
		else
		{
			//manejo de error
		}
		
		return null;
	}
	
	public Importacion esImportacion()
	{
		ArrayList<Import> Importaciones= new ArrayList<Import>();
		Import import1= esImport();
		
		while(import1!=null)
		{
			Importaciones.add(import1);
			
		}
		
		return new Importacion(Importaciones);
	}
	
	public Import esImport()
	{
		Lenguaje identificador= null;
		
		if(tokenActual.getToken().equals("importar"))
		{
			darSiguienteToken();
		}
		else
		{
			return null;
		}
		if(tokenActual.getTipoToken().equals("identificador de importacion"))
		{
			identificador = tokenActual;
			darSiguienteToken();
		}
		else
		{
			//manejo de error
		}
		if(tokenActual.getToken().equals("."))
		{
			darSiguienteToken();
			return new Import(identificador);
		}
		else
		{
			//manejo de error
		}
		
		return null;
	}
	
	public Clase esClase()
	{
		Lenguaje identificador=null;
		
		if(tokenActual.getToken().equals("clase"))
		{
			darSiguienteToken();
		}
		else
		{
			return null;
		}
		
		if(tokenActual.getTipoToken().equals("Identificador de clase"))
		{
			identificador=tokenActual;
			darSiguienteToken();
		}
		else
		{
			//manejo de error
		}
		
		if(tokenActual.getToken().equals("{"))
		{
			darSiguienteToken();
		}
		else
		{
			//manejo de error
		}
		
		SentenciasClase cuerpoclase= esSentenciasClase();
		
		if(cuerpoclase==null)
		{
			//manejo de error
		}
		
		if(tokenActual.getToken().equals("}"))
		{
			darSiguienteToken();
			return new Clase(identificador, cuerpoclase);
		}
		else
		{
			//manejo de error
		}
		
		return null;
	}
}
