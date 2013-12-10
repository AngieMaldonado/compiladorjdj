package co.edu.uniquindio.analizadorSemantico.logic;

import java.util.ArrayList;

import co.edu.uniquindio.analizadorLexico.logic.Lenguaje;
import co.edu.uniquindio.analizadorSintactico.logic.UnidadCompilacion;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de AnalizadorSemantico.java y 
 * maneja su información
 */
public class AnalizadorSemantico 
{
	private TablaSimbolos tablaSimbolos;  
	private UnidadCompilacion unidadDeCompilacion;  
	private ArrayList<Error> errores; 

	public static String calcularTipo(String tipo1, String tipo2)
	{   
		if((tipo1.equals("entero") && tipo2.equals("real")) || (tipo1.equals("real") && tipo2.equals("entero")))   
		{    
			return "real";
		}
		if(tipo1.equals("cadenaCaracteres") && (tipo2.equals("entero") || tipo2.equals("real")) || tipo2.equals("cadenaCaracteres") && (tipo1.equals("entero") || tipo1.equals("real")))   
		{    
			return "cadenaCaracteres";   
		}
		if((tipo1.equals("entero") && tipo2.equals("entero")))   
		{    
			return "entero";   
		}  
		if((tipo1.equals("real") && tipo2.equals("real")))   
		{    
			return "real";   
		}

		return "";  
	}


	public void analizar()     
	{   
		tablaSimbolos = new TablaSimbolos();   
		unidadDeCompilacion.llenarTabla(tablaSimbolos);   
		tablaSimbolos.imprimir();      
		errores = new ArrayList<Error>();   
		unidadDeCompilacion.analizarSemantica(tablaSimbolos, errores);   
	} 

	public static String getTipoOperando(Lenguaje s)  
	{   
		if(s.getToken().equals("bool"))   
		{    
			return "boolean";   
		}     
		if(s.getToken().equals("entero"))   
		{    
			return "entero";   
		}      
		if(s.getToken().equals("racional"))   
		{    
			return "real";   
		}      
		if(s.getToken().equals("caracter"))   
		{    
			return "caracter";   
		}    
		if(s.getToken().equals("cadena"))   
		{    
			return "cadenaCaracteres";   
		}      

		return "tipo";  
	}

	public static boolean sonCompatibles(String tipo1, String tipo2)  
	{   
		if(tipo1.equals(tipo2))   
		{    
			return true;   
		}
		
		return false;  
	}
	
	
}