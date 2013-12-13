/**
 *
 */
package co.edu.uniquindio.analizadorSintactico.logic;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

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
	 * Atributo que contiene el valor de listaErroresSintacticos dentro de la clase
	*/
	private ArrayList<ErrorSintactico> listaErroresSintacticos;
	
	
	private final String ERROR_NO_TERMINAL = "Simbolo terminal '.' no encontrado";
	private final String ERROR_PARENTESIS_APERTURA = "Simbolo '(' no encontrado";
	private final String ERROR_PARENTESIS_CIERRE = "Simbolo ')' no encontrado";
	private final String ERROR_LLAVE_APERTURA = "Simvolo '{' no encontrado";
	private final String ERROR_LLAVE_CIERRE = "Simbolo '}' no encontrado";
	private final String ERROR_NO_IDENTIFICADOR = "identificador no encontrado";
	private final String ERROR_NO_PALABRA_RESERVADA = "No se encontró la palabra reservada indicada";
	private final String ERROR_NO_PARENTESIS = "no se encontraron '(', ni ')')";
	private final String ERROR_VARIABLE_CLASE = "Error al crear la variable de clase";
	
	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la AnalizadorSintactico.java
	 * @param listasimbolos la cual es la que le envia el analizador lexico al sintactico
	 */
	public AnalizadorSintactico(ArrayList<Lenguaje> listasimbolos)
	{
		listaSimbolosLexicos=listasimbolos;
		listaErroresSintacticos = new ArrayList<ErrorSintactico>(); 
		indice = 0; 
		tokenActual = listaSimbolosLexicos.get(indice); 
		unidadDeCompilacion = esUnidadDeCompilacion(); 

	}
	
	public void almacenarErrorSintactico(String mensaje) {

			ErrorSintactico error = new ErrorSintactico(mensaje, tokenActual.getFila(), tokenActual.getColumna());
			listaErroresSintacticos.add(error);
	}
	
	public void almacenarErrorSintactico(Class<?> clase) {


			ErrorSintactico error = new ErrorSintactico("No se pudo crear el/la "+ clase.getSimpleName(), tokenActual.getFila(), tokenActual.getColumna());
			listaErroresSintacticos.add(error);

	}
	
	public void modoPanicoTerminal()
	{
		while(!tokenActual.getToken().equals(".") && indice<listaSimbolosLexicos.size())
		{
			darSiguienteToken();
		}
	}
	
	public void modoPanicoLlaveCierre()
	{
		while(!tokenActual.getToken().equals("}") && indice<listaSimbolosLexicos.size())
		{
			darSiguienteToken();
		}
	}
	
	private void recuperacionParentesisCierre(String mensaje) {

		almacenarErrorSintactico(mensaje);
	}

	private void recuperacionParentesisApertura(String mensaje) {

		almacenarErrorSintactico(mensaje);
	}

	private void recuperacionLLaveApertura(String mensaje) {

		almacenarErrorSintactico(mensaje);
	}

	private void recuperacionTerminalSentencia(String mensaje) {

		almacenarErrorSintactico(mensaje);
	}
	
	/**
	 * Metodo usado para avanzar de token
	 */
	
	public DefaultMutableTreeNode getArbolSintactico()
	{
		if(unidadDeCompilacion!=null)
			return unidadDeCompilacion.getArbolVisual();
		
		return null;
	}
	
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
	public void realizarBacktracking(int posBT) 
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
	
	/**
	 * Este metodo permite obtener el valor del atributo listaErroresSintacticos
	 * @return el listaErroresSintacticos
	 */
	public ArrayList<ErrorSintactico> getListaErroresSintacticos() {
		return listaErroresSintacticos;
	}

	public UnidadCompilacion esUnidadDeCompilacion()
	{
		int indiceaux= indice;
		
		Paquete paquete= esPaquete();
		
		if(paquete==null)
		{
			almacenarErrorSintactico(Paquete.class);
			return null;
			//manejo de error
		}
		
		Importacion importacion= esImportacion();
		
		Clase clase= esClase();
		
		if(clase==null)
		{
			almacenarErrorSintactico(Clase.class);
			return null;
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
			almacenarErrorSintactico(ERROR_NO_PALABRA_RESERVADA);
			return null;
		}
		
		if(tokenActual.getTipoToken().equals("Identificador de paquete"))
		{
			identificador=tokenActual;
			darSiguienteToken();
		}
		else
		{
			almacenarErrorSintactico(ERROR_NO_IDENTIFICADOR);
			return null;
			//manejo de error;
		}
		
		if(tokenActual.getToken().equals("."))
		{
			darSiguienteToken();
			return new Paquete(identificador);
		}
		else
		{
			almacenarErrorSintactico(ERROR_NO_TERMINAL);
			return null;
//			modoPanicoTerminal();
			
		}

	}
	
	public Importacion esImportacion()
	{
		ArrayList<Import> Importaciones= new ArrayList<Import>();
		Import import1= esImport();
		
		while(import1!=null)
		{
			Importaciones.add(import1);
			import1= esImport();
			
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
			almacenarErrorSintactico(ERROR_NO_PALABRA_RESERVADA);
			return null;
		}
		if(tokenActual.getTipoToken().equals("Identificador de Import"))
		{
			identificador = tokenActual;
			darSiguienteToken();
		}
		else
		{
			almacenarErrorSintactico(ERROR_NO_IDENTIFICADOR);
			return null;
			//manejo de error
		}
		if(tokenActual.getToken().equals("."))
		{
			darSiguienteToken();
			return new Import(identificador);
		}
		else
		{
			almacenarErrorSintactico(ERROR_NO_TERMINAL);
			return null;
			//manejo de error
		}
		
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
			almacenarErrorSintactico(ERROR_NO_PALABRA_RESERVADA);
			return null;
		}
		
		if(tokenActual.getTipoToken().equals("Identificador de clase"))
		{
			identificador=tokenActual;
			darSiguienteToken();
		}
		else
		{
			almacenarErrorSintactico(ERROR_NO_IDENTIFICADOR);
			return null;
			//manejo de error
		}
		
		if(tokenActual.getToken().equals("{"))
		{
			darSiguienteToken();
		}
		else
		{
			almacenarErrorSintactico(ERROR_LLAVE_APERTURA);
			return null;
			//manejo de error
		}
		
		SentenciasClase cuerpoclase= esSentenciasClase();
		
		if(cuerpoclase==null)
		{
			return null;
			//manejo de error
		}
		
		if(tokenActual.getToken().equals("}"))
		{
			darSiguienteToken();
			return new Clase(identificador, cuerpoclase);
		}
		else
		{
			almacenarErrorSintactico(ERROR_LLAVE_CIERRE);
			//manejo de error
		}
		
		return null;
	}
	
	public SentenciasClase esSentenciasClase()
	{
		ArrayList<SentenciaClase> sentenciasClases= new ArrayList<SentenciaClase>();
		
		SentenciaClase sentenciaClase = esSentenciaClase();
		
		while(sentenciaClase!=null)
		{
			sentenciasClases.add(sentenciaClase);
			sentenciaClase= esSentenciaClase();
			
		}
		
		return new SentenciasClase(sentenciasClases);
	}
	
	public SentenciaClase esSentenciaClase()
	{
		Lenguaje tipoAcceso= null;
		Lenguaje tipoVariable=null;
		Lenguaje identificador=null;
		
		if(tokenActual.getToken().equals("publico") || tokenActual.getToken().equals("privado"))
		{
			tipoAcceso= tokenActual;
			darSiguienteToken();
		}
		else
		{
			almacenarErrorSintactico(ERROR_NO_PALABRA_RESERVADA);
			return null;
		}
		
		if(tokenActual.getToken().equals("cadena") || tokenActual.getToken().equals("caracter") || tokenActual.getToken().equals("racional")
				|| tokenActual.getToken().equals("entero") || tokenActual.getToken().equals("bool"))
		{
			tipoVariable=tokenActual;
			darSiguienteToken();
		}
		else
		{
			almacenarErrorSintactico(ERROR_NO_PALABRA_RESERVADA);
			return null;
			//manejo de error
		}
		
		if(tokenActual.getTipoToken().equals("Identificador de atributo"))
		{
			ArrayList<Lenguaje> identificadoresVaribles= new ArrayList<Lenguaje>();
			identificador=tokenActual;
			
			identificadoresVaribles.add(identificador);
			
			darSiguienteToken();
			
			while(tokenActual.getToken().equals(",") && !tokenActual.getToken().equals("."))
			{
				darSiguienteToken();
				if(tokenActual.getTipoToken().equals("Identificador de atributo"))
				{
					identificador=tokenActual;
					identificadoresVaribles.add(identificador);
					darSiguienteToken();
				}
				else
				{
					almacenarErrorSintactico(ERROR_NO_IDENTIFICADOR);
					return null;
					//manejo de error
				}
			}
			
			if(tokenActual.getToken().equals("."))
			{
				darSiguienteToken();
				return new SentenciaClase_DeclaracionVariable(tipoAcceso, tipoVariable, identificadoresVaribles);
			}
			else
			{
				almacenarErrorSintactico(ERROR_NO_TERMINAL);
				return null;
				//manejo de error
			}
		}
		else
		{
			//manejo de error
		}
		
		if(tokenActual.getTipoToken().equals("Identificador de metodo"))
		{
			identificador=tokenActual;
			darSiguienteToken();
			
			if(tokenActual.getToken().equals("("))
			{
				darSiguienteToken();
			}
			else
			{
				almacenarErrorSintactico(ERROR_NO_IDENTIFICADOR);
				return null;
				//manejo de error
			}
			
			Parametros parametros= esParametros();
			
			if(parametros==null)
			{
				return null;
				//manejo de error
			}
			
			if(tokenActual.getToken().equals(")"))
			{
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
			
			SentenciasMetodo sentenciasMetodo= esSentenciasMetodo();
			
			if(sentenciasMetodo==null)
			{
				//manejo de error
			}
			
			if(tokenActual.getToken().equals("}"))
			{
				darSiguienteToken();
				return new SentenciaClase_Metodo(tipoAcceso, tipoVariable, identificador, parametros, sentenciasMetodo);
			}
			else
			{
				//manejo de error
			}
		}
		else
		{
			//manejo de error
		}
		
		return null;
	}
	
	public Parametros esParametros()
	{
		ArrayList<Parametro> parametros= new ArrayList<Parametro>();
		Parametro parametro= esParametro();
		
		while (parametro!=null) 
		{
			parametros.add(parametro);
			
			if(tokenActual.getToken().equals(","))
			{
				darSiguienteToken();
			}
			else
			{
				//manejo de error
			}
			parametro =esParametro();
		}
		return new Parametros(parametros);
	}
	
	public Parametro esParametro()
	{
		Lenguaje tipo=null;
		Lenguaje identificador=null;
		
		if(tokenActual.getToken().equals("cadena") || tokenActual.getToken().equals("caracter") || tokenActual.getToken().equals("racional")
				|| tokenActual.getToken().equals("entero") || tokenActual.getToken().equals("bool"))
		{
			tipo=tokenActual;
			darSiguienteToken();
		}
		else
		{
			//manejo de error
		}
		
		if(tokenActual.getTipoToken().equals("Identificador de atributo"))
		{
			darSiguienteToken();
			return new Parametro(tipo, identificador);
		}
		else
		{
			//manejo de error
		}
		
		return null;
	}
	
	public SentenciasMetodo esSentenciasMetodo()
	{
		ArrayList<SentenciaMetodo> sentenciasMetodos= new ArrayList<SentenciaMetodo>();
		
		SentenciaMetodo sentenciaMetodo = esSentenciaMetodo();
		
		while(sentenciaMetodo!=null)
		{
			sentenciasMetodos.add(sentenciaMetodo);
			sentenciaMetodo= esSentenciaMetodo();
			
		}
		
		return new SentenciasMetodo(sentenciasMetodos);
	}
	
	public SentenciaMetodo esSentenciaMetodo()
	{
		if(tokenActual.getToken().equals("SI"))
		{
			darSiguienteToken();
			return esSi();
		}
		if(tokenActual.getToken().equals("SINO"))
		{
			
		}
		if(tokenActual.getToken().equals("DELOCONTRARIO"))
		{
			
		}
		if(tokenActual.getToken().equals("CICLO"))
		{
			
		}
		if(tokenActual.getToken().equals("MIENTRAS"))
		{
			
		}
		if(tokenActual.getToken().equals("HACER"))
		{
			
		}
		
		return null;
	}
	
	public SentenciaMetodo_Si esSi()
	{
		if(tokenActual.getToken().equals("("))
		{
			darSiguienteToken();
		}
		else
		{
			//manejo de error
		}
		
		Operacion operacion= esOperacion();
		
		if(operacion==null)
		{
			//manejo de error
		}
		
		if(tokenActual.getToken().equals(")"))
		{
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
		
		SentenciasMetodo sentenciasMetodo= esSentenciasMetodo();
		
		if(sentenciasMetodo==null)
		{
			//mnejo de error
		}
		
		if(tokenActual.getToken().equals("}"))
		{
			darSiguienteToken();
			return new SentenciaMetodo_Si(operacion, sentenciasMetodo);
		}
		else
		{
			//manejo de error
		}
		return null;
	}
	
	public SentenciaMetodo_Sino esSino()
	{
		if(tokenActual.getToken().equals("("))
		{
			darSiguienteToken();
		}
		else
		{
			//manejo de error
		}
		
		Operacion operacion= esOperacion();
		
		if(operacion==null)
		{
			//manejo de error
		}
		
		if(tokenActual.getToken().equals(")"))
		{
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
		
		SentenciasMetodo sentenciasMetodo= esSentenciasMetodo();
		
		if(sentenciasMetodo==null)
		{
			//mnejo de error
		}
		
		if(tokenActual.getToken().equals("}"))
		{
			darSiguienteToken();
			return new SentenciaMetodo_Sino(operacion, sentenciasMetodo);
		}
		else
		{
			//manejo de error
		}
		return null;
	}
	
	public SentenciaMetodo_Delocontrario esDelocontrario()
	{
	
		if(tokenActual.getToken().equals("{"))
		{
			darSiguienteToken();
		}
		else
		{
			//manejo de error
		}
		
		SentenciasMetodo sentenciasMetodo= esSentenciasMetodo();
		
		if(sentenciasMetodo==null)
		{
			//mnejo de error
		}
		
		if(tokenActual.getToken().equals("}"))
		{
			darSiguienteToken();
			return new SentenciaMetodo_Delocontrario(sentenciasMetodo);
		}
		else
		{
			//manejo de error
		}
		return null;
	}
	
	public SentenciaMetodo_Ciclo esCiclo()
	{
		if(tokenActual.getToken().equals("("))
		{
			darSiguienteToken();
		}
		else
		{
			//manejo de error
		}
		
		Operacion asignacion= esOperacion();
		
		if(asignacion==null)
		{
			//manejo de error
		}
		
		if(tokenActual.getToken().equals(";"))
		{
			darSiguienteToken();
		}
		else
		{
			//manejo de error
		}
		
		Operacion condicion= esOperacion();
		
		if(condicion==null)
		{
			//manejo de error
		}
		
		if(tokenActual.getToken().equals(";"))
		{
			darSiguienteToken();
		}
		else
		{
			//manejo de error
		}
		
		Operacion iteracion= esOperacion();
		
		if(iteracion==null)
		{
			//manejo de error
		}
		
		if(tokenActual.getToken().equals(")"))
		{
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
		
		SentenciasMetodo sentenciasMetodo= esSentenciasMetodo();
		
		if(sentenciasMetodo==null)
		{
			//mnejo de error
		}
		
		if(tokenActual.getToken().equals("}"))
		{
			darSiguienteToken();
			return new SentenciaMetodo_Ciclo(asignacion, condicion, iteracion, sentenciasMetodo);
		}
		else
		{
			//manejo de error
		}
		return null;
	}
	
	public SentenciaMetodo_Mientras esMientras()
	{
		if(tokenActual.getToken().equals("("))
		{
			darSiguienteToken();
		}
		else
		{
			//manejo de error
		}
		
		Operacion condicion= esOperacion();
		
		if(condicion==null)
		{
			//manejo de error
		}
		
		if(tokenActual.getToken().equals(")"))
		{
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
		
		SentenciasMetodo cuerpoSentencia= esSentenciasMetodo();
		
		if(cuerpoSentencia==null)
		{
			//mnejo de error
		}
		
		if(tokenActual.getToken().equals("}"))
		{
			darSiguienteToken();
			return new SentenciaMetodo_Mientras(condicion, cuerpoSentencia);
		}
		else
		{
			//manejo de error
		}
		return null;
	}
	
	public SentenciaMetodo_Hacermientras esHacermientras()
	{
		if(tokenActual.getToken().equals("{"))
		{
			darSiguienteToken();
		}
		else
		{
			//manejo de error
		}
		
		SentenciasMetodo cuerpoSentencia= esSentenciasMetodo();
		
		if(cuerpoSentencia==null)
		{
			//mnejo de error
		}
		
		if(tokenActual.getToken().equals("}"))
		{
			darSiguienteToken();
		}
		else
		{
			//manejo de error
		}
		
		if(tokenActual.getToken().equals("MIENTRAS"))
		{
			darSiguienteToken();
		}
		else
		{
			//manejo de error
		}
		
		if(tokenActual.getToken().equals("("))
		{
			darSiguienteToken();
		}
		else
		{
			//manejo de error
		}
		
		Operacion condicion= esOperacion();
		
		if(condicion==null)
		{
			//manejo de error
		}
		
		if(tokenActual.getToken().equals(")"))
		{
			darSiguienteToken();
			return new SentenciaMetodo_Hacermientras(cuerpoSentencia, condicion);
		}
		else
		{
			//manejo de error
		}
		return null;
	}
	
	public Operacion esOperacion()
	{
		Lenguaje operador1= null;
		Lenguaje operacion= null;
		
		if(tokenActual.getToken().equals("("))
		{
			darSiguienteToken();
		}
		if(tokenActual.getToken().equals("cadena") || tokenActual.getTipoToken().equals("Identificador de atributo")
				|| tokenActual.getToken().equals("entero") || tokenActual.getToken().equals("racional")
				|| tokenActual.getToken().equals("caracter") || tokenActual.getToken().equals("bool"))
		{
			operador1=tokenActual;
		}
		
		if(tokenActual.getToken().equals("=") || tokenActual.getToken().equals("==") || tokenActual.getToken().equals("<")
				|| tokenActual.getToken().equals("<=") || tokenActual.getToken().equals(">") || tokenActual.getToken().equals(">=")
				|| tokenActual.getToken().equals("+") || tokenActual.getToken().equals("-") || tokenActual.getToken().equals("*")
				|| tokenActual.getToken().equals("/"))
		{
			operacion=tokenActual;
		}
		
		Operacion operacion2= esOperacion();
		
		if(operacion2==null)
		{
			if(operacion==null)
			{
				darSiguienteToken();
				return new Operacion(operador1, operacion, operacion2);
			}
			else
			{
				//manejo de error
			}
		}
		else
		{
			//manejo de error
		}
		
		if(tokenActual.getToken().equals("("))
		{
			darSiguienteToken();
		}
			
		return null;
	}
}
