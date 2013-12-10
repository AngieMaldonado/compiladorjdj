package co.edu.uniquindio.analizadorSemantico.logic;

import java.util.ArrayList;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de TablaSimbolos.java y 
 * maneja su información
 */
public class TablaSimbolos
{
	private ArrayList<Simbolo> simbolos; 

	public void agregarSimboloMetodo(String nombre, String ambito, String ret, ArrayList<String> params)  
	{   
		simbolos.add(new Simbolo(nombre, ambito, ret, params));  
	}

	public void agregarSimboloGeneral(String nombre, String tipoDato, String ambito)  
	{   
		simbolos.add(new Simbolo(nombre, tipoDato, ambito));  
	}

	public Simbolo getSimbolo(String nombre, String ambito)  
	{   
		for (Simbolo simbolo : simbolos)    
		{    
			if(simbolo.getNombre().equals(nombre) && simbolo.getAmbito().equals(ambito))     
				return new Simbolo(simbolo.getNombre(), simbolo.getAmbito(), simbolo.getRet());   
		}   
		return null;  
	}

	public boolean esRepetido(String nombreFuncion)  
	{   
		int cont = 0;  
		for (Simbolo simbolo : simbolos)    
		{    
			if(simbolo.getNombre().equals(nombreFuncion))    
			{  
				cont++;    
			}  
		}    
		if(cont>1)   
		{ 
			return true;   
		}   
		else    
			return false;  
	}

	/**
	 * 
	 */
	public void imprimir() {
		// TODO : COMPLETAR
	} 

}