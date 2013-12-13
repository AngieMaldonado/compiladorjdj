package co.edu.uniquindio.analizadorSemantico.logic;

import java.util.ArrayList;

import co.edu.uniquindio.analizadorLexico.logic.Lenguaje;
import co.edu.uniquindio.analizadorSintactico.logic.Operacion;
import co.edu.uniquindio.analizadorSintactico.logic.SentenciaClase;
import co.edu.uniquindio.analizadorSintactico.logic.SentenciaClase_Asignacion;
import co.edu.uniquindio.analizadorSintactico.logic.SentenciaClase_DeclaracionVariable;
import co.edu.uniquindio.analizadorSintactico.logic.SentenciaClase_Metodo;
import co.edu.uniquindio.analizadorSintactico.logic.SentenciaMetodo;
import co.edu.uniquindio.analizadorSintactico.logic.SentenciaMetodo_Asignacion;
import co.edu.uniquindio.analizadorSintactico.logic.SentenciaMetodo_Ciclo;
import co.edu.uniquindio.analizadorSintactico.logic.SentenciaMetodo_DeclaracionVariable;
import co.edu.uniquindio.analizadorSintactico.logic.SentenciaMetodo_Delocontrario;
import co.edu.uniquindio.analizadorSintactico.logic.SentenciaMetodo_Hacermientras;
import co.edu.uniquindio.analizadorSintactico.logic.SentenciaMetodo_Mientras;
import co.edu.uniquindio.analizadorSintactico.logic.SentenciaMetodo_Retorno;
import co.edu.uniquindio.analizadorSintactico.logic.SentenciaMetodo_Si;
import co.edu.uniquindio.analizadorSintactico.logic.SentenciaMetodo_Sino;
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
	/**
	 * Atributo que contiene el valor de tablaSimbolos dentro de la clase
	 */
	private TablaSimbolos tablaSimbolos;

	/**
	 * Atributo que contiene el valor de unidadDeCompilacion dentro de la clase
	 */
	private UnidadCompilacion unidadDeCompilacion;

	/**
	 * Atributo que contiene el valor de errores dentro de la clase
	 */
	private ArrayList<Error> errores; 

	public void analizar()     
	{   
		tablaSimbolos = new TablaSimbolos();    
		tablaSimbolos.imprimir();      
		errores = new ArrayList<Error>();   
		analizarSemantica();   
	}


	/**
	 * Calcula el tipo resultante
	 * @param tipo1 tipo de la variable 1
	 * @param tipo2 tipo de la variable 2
	 * @return el tipo resultante
	 */
	public String calcularTipo(Lenguaje op1, Lenguaje op2, Lenguaje op)
	{   
		String tipo1 = op1.getTipoToken();
		String tipo2 = op2.getTipoToken();
		String operacion = op.getTipoToken();

		if(((tipo1.equals("entero") && tipo2.equals("decimal")) || (tipo1.equals("decimal") && tipo2.equals("entero"))) && !operacion.toLowerCase().contains("operador logico") && !operacion.toLowerCase().contains("operador relacional") && !operacion.toLowerCase().contains("modulo"))   
			return "decimal";

		if(((tipo1.equals("cadena") && (tipo2.equals("entero") || tipo2.equals("decimal")) || tipo2.equals("cadena") || tipo2.equals("caracter")) || (tipo2.equals("cadena") && (tipo1.equals("entero") || tipo1.equals("decimal")) || tipo1.equals("cadena") || tipo1.equals("caracter"))) && operacion.toLowerCase().contains("suma"))   
			return "cadena";

		if((tipo1.equals("entero") && tipo2.equals("entero")) && !operacion.toLowerCase().contains("operador logico") && !operacion.toLowerCase().contains("operador relacional") && !operacion.toLowerCase().contains("division"))   
			return "entero";

		if((tipo1.equals("decimal") || tipo1.equals("integer") && tipo2.equals("decimal") || tipo2.equals("integer")) && !operacion.toLowerCase().contains("operador logico") && !operacion.toLowerCase().contains("operador relacional") && !operacion.toLowerCase().contains("modulo"))   
			return "decimal";

		if((tipo1.equals("boolean") && tipo2.equals("boolean")) && operacion.toLowerCase().contains("operador logico"))
			return "boolean";

		return null;  
	}

	/**
	 * @param op
	 * @param nombre
	 * @param ambito
	 * @return
	 */
	public String resolverOperacion(Operacion op, String nombre, String ambito)
	{
		Lenguaje op1 = op.getOperador1();
		Lenguaje op2 = op.getOperador2().getOperador1();
		String ret = op1.getTipoToken();

		while(op2 != null)
		{
			String tipo = calcularTipo(op1, op2, op.getOperacion());
			if(tipo  == null)
			{
				// Agrego el error entre los operadores. Ej: V + 5
				errores.add(new Error("Tipos incompatibles en la operacion de "+ nombre +" donde el ambito es: "+ ambito + " entre "+op1.getTipoToken()+" y "+ op2.getTipoToken()));
				break;
			}
			else
			{
				ret = tipo;
				op = op.getOperador2();
				op1 = op.getOperador1();
				op2 = op.getOperador2().getOperador1();
			}
		}

		return ret;
	}


	/**
	 * 
	 */
	public void analizarSemantica() 
	{
		for (SentenciaClase sc : unidadDeCompilacion.getDeclaracionClase().getCuerpoClase().getSentencias()) 
		{
			if(sc instanceof SentenciaClase_Asignacion)
			{
				// Busco la variable para asignarle el valor
				Simbolo s = tablaSimbolos.getSimbolo(((SentenciaClase_Asignacion) sc).getVariable().getToken(), unidadDeCompilacion.getDeclaracionClase().getIdentificadorClase().getToken());

				// Si es null es por que el simbolo no fue encontrado en la tabla de simbolos
				if(s != null)
				{
					// Resuelvo la operacion con un metodo auxiliar
					String ret = resolverOperacion(((SentenciaClase_Asignacion) sc).getValor(), s.getNombre(), s.getAmbito());

					// Agrego el error de retorno de la asignacion
					if(!ret.equals(s.getRet()))
						errores.add(new Error("Tipos incompatibles en la asignacion de "+ s.getNombre() +" donde el ambito es: "+ s.getAmbito()));
				}
				else
				{
					errores.add(new Error("La variable " + ((SentenciaClase_Asignacion) sc).getVariable().getToken()+ " no fue encontrada en "+ unidadDeCompilacion.getDeclaracionClase().getIdentificadorClase().getToken()));
				}
			}
			if(sc instanceof SentenciaClase_Metodo)
			{
				for (SentenciaMetodo sm : ((SentenciaClase_Metodo) sc).getCuerpoMetodo().getSentenciasMetodo()) 
				{
					if(sm instanceof SentenciaMetodo_Retorno)
					{
						Simbolo s = tablaSimbolos.getSimbolo(((SentenciaClase_Metodo) sc).getIdentificadorMetodo().getToken(), unidadDeCompilacion.getDeclaracionClase().getIdentificadorClase().getToken());

						if(s != null)
						{
							String ret = resolverOperacion(((SentenciaMetodo_Retorno) sm).getValor(), "Retorno", ((SentenciaClase_Metodo) sc).getIdentificadorMetodo().getToken());

							// Agrego el error de retorno de la operacion
							if(!ret.equals(s.getRet()))
								errores.add(new Error("Tipos incompatibles en el retorno de "+ s.getNombre() +" donde el ambito es: "+ s.getAmbito()));
						}
						else
						{
							errores.add(new Error("El metodo " + ((SentenciaClase_Asignacion) sc).getVariable().getToken()+ " no fue encontrado en "+ unidadDeCompilacion.getDeclaracionClase().getIdentificadorClase().getToken()));
						}
					}
					else
					{

					}
				}
			}
		}
	}

	public void analizarSemanticaR(SentenciaMetodo sentencia, String ambito)
	{
		if(sentencia instanceof SentenciaMetodo_Asignacion)  
		{    
			SentenciaMetodo_Asignacion dv = (SentenciaMetodo_Asignacion) sentencia;     

			// Busco la variable para asignarle el valor
			Simbolo s = tablaSimbolos.getSimbolo(((SentenciaMetodo_Asignacion) dv).getVariable().getToken(), unidadDeCompilacion.getDeclaracionClase().getIdentificadorClase().getToken());

			// Si es null es por que el simbolo no fue encontrado en la tabla de simbolos
			if(s != null)
			{
				// Resuelvo la operacion con un metodo auxiliar
				String ret = resolverOperacion(((SentenciaMetodo_Asignacion) dv).getValor(), s.getNombre(), s.getAmbito());

				// Agrego el error de retorno de la asignacion
				if(!ret.equals(s.getRet()))
					errores.add(new Error("Tipos incompatibles en la asignacion de "+ s.getNombre() +" donde el ambito es: "+ s.getAmbito()));
			}
			else
			{
				errores.add(new Error("La variable " + ((SentenciaMetodo_Asignacion) dv).getVariable().getToken()+ " no fue encontrada en "+ unidadDeCompilacion.getDeclaracionClase().getIdentificadorClase().getToken()));
			}
		}        
		else if(sentencia instanceof SentenciaMetodo_Si)
		{
			SentenciaMetodo_Si dv = (SentenciaMetodo_Si) sentencia;     

			// Resuelvo la operacion con un metodo auxiliar
			String ret = resolverOperacion(((SentenciaMetodo_Si) dv).getCondiciones(), "Si", ambito);

			// Agrego el error de retorno de la asignacion
			if(!ret.equals("boolean"))
				errores.add(new Error("Se esperaba booleano en "+ambito));

			for (SentenciaMetodo sentenciaAux : ((SentenciaMetodo_Si) sentencia).getOperaciones().getSentenciasMetodo()) 
			{
				analizarSemanticaR(sentenciaAux, ambito+" Si");
			}
		}
		else if(sentencia instanceof SentenciaMetodo_Sino)
		{
			SentenciaMetodo_Sino dv = (SentenciaMetodo_Sino) sentencia;     

			// Resuelvo la operacion con un metodo auxiliar
			String ret = resolverOperacion(((SentenciaMetodo_Sino) dv).getCondiciones(), "SiNo", ambito);

			// Agrego el error de retorno de la asignacion
			if(!ret.equals("boolean"))
				errores.add(new Error("Se esperaba booleano en "+ambito));

			for (SentenciaMetodo sentenciaAux : ((SentenciaMetodo_Si) sentencia).getOperaciones().getSentenciasMetodo()) 
			{
				analizarSemanticaR(sentenciaAux, ambito+" Sino");
			}
		}
		else if(sentencia instanceof SentenciaMetodo_Delocontrario)
		{
			for (SentenciaMetodo sentenciaAux : ((SentenciaMetodo_Si) sentencia).getOperaciones().getSentenciasMetodo()) 
			{
				analizarSemanticaR(sentenciaAux, ambito+" Delocontrario");
			}
		}
		else if(sentencia instanceof SentenciaMetodo_Ciclo)
		{
			SentenciaMetodo_Ciclo dv = (SentenciaMetodo_Ciclo) sentencia;     

			// Resuelvo la operacion con un metodo auxiliar
			String ret = resolverOperacion(((SentenciaMetodo_Ciclo) dv).getCondicion(), "SiNo", ambito);

			// Agrego el error de retorno de la asignacion
			if(!ret.equals("boolean"))
				errores.add(new Error("Se esperaba booleano en "+ambito));
			
			for (SentenciaMetodo sentenciaAux : ((SentenciaMetodo_Si) sentencia).getOperaciones().getSentenciasMetodo()) 
			{
				analizarSemanticaR(sentenciaAux, ambito+" Ciclo");
			}
		}
		else if(sentencia instanceof SentenciaMetodo_Hacermientras)
		{
			SentenciaMetodo_Hacermientras dv = (SentenciaMetodo_Hacermientras) sentencia;     

			// Resuelvo la operacion con un metodo auxiliar
			String ret = resolverOperacion(((SentenciaMetodo_Hacermientras) dv).getCondiciones(), "SiNo", ambito);

			// Agrego el error de retorno de la asignacion
			if(!ret.equals("boolean"))
				errores.add(new Error("Se esperaba booleano en "+ambito));
			
			for (SentenciaMetodo sentenciaAux : ((SentenciaMetodo_Si) sentencia).getOperaciones().getSentenciasMetodo()) 
			{
				analizarSemanticaR(sentenciaAux, ambito+" Hacermientras");
			}
		}
		else if(sentencia instanceof SentenciaMetodo_Mientras)
		{
			SentenciaMetodo_Mientras dv = (SentenciaMetodo_Mientras) sentencia;     

			// Resuelvo la operacion con un metodo auxiliar
			String ret = resolverOperacion(((SentenciaMetodo_Mientras) dv).getCondiciones(), "SiNo", ambito);

			// Agrego el error de retorno de la asignacion
			if(!ret.equals("boolean"))
				errores.add(new Error("Se esperaba booleano en "+ambito));
			
			for (SentenciaMetodo sentenciaAux : ((SentenciaMetodo_Si) sentencia).getOperaciones().getSentenciasMetodo()) 
			{
				analizarSemanticaR(sentenciaAux, ambito+" Mientras");
			}
		}
	}
}