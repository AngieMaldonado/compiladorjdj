package co.edu.uniquindio.analizadorSintactico.logic;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import co.edu.uniquindio.analizadorLexico.logic.Lenguaje;
import co.edu.uniquindio.analizadorSemantico.logic.TablaSimbolos;

/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.1 Septiembre-2013 
 * Esta clase es la que contiene los atributos de UnidadCompilacion.java y 
 * maneja su informaciÃ³n
 */
public class UnidadCompilacion 
{
	/**
	 * Atributo que contiene el valor de paquete dentro de la clase
	 */
	private Paquete paquete;

	/**
	 * Atributo que contiene el valor de imports dentro de la clase
	 */
	private Importacion imports;

	/**
	 * Atributo que contiene el valor de declaracionClase dentro de la clase
	 */
	private Clase declaracionClase;

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la UnidadCompilacion.java
	 * @param paquete
	 * @param imports
	 * @param declaracionClase
	 */
	public UnidadCompilacion(Paquete paquete, Importacion imports,
			Clase declaracionClase) {
		super();
		this.paquete = paquete;
		this.imports = imports;
		this.declaracionClase = declaracionClase;
	}

	/**
	 * Metodo que se encarga de reservar memoria y luego instanciar la UnidadCompilacion.java
	 */
	public UnidadCompilacion() {}

	/**
	 * Este metodo permite obtener el valor del atributo paquete
	 * @return el paquete
	 */
	public Paquete getPaquete() {
		return paquete;
	}

	/**
	 * Este metodo permite asignar un valor al atributo paquete
	 * @param paquete se asigna a paquete
	 */
	public void setPaquete(Paquete paquete) {
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
	 * Este metodo permite obtener el valor del atributo declaracionClase
	 * @return el declaracionClase
	 */
	public Clase getDeclaracionClase() {
		return declaracionClase;
	}

	/**
	 * Este metodo permite asignar un valor al atributo declaracionClase
	 * @param declaracionClase se asigna a declaracionClase
	 */
	public void setDeclaracionClase(Clase declaracionClase) {
		this.declaracionClase = declaracionClase;
	}

	/**
	 * @param tablaSimbolos
	 */
	public void llenarTabla(TablaSimbolos ts) 
	{
		//Almacenar Todos símbolos métodos   
		ArrayList<String> parm = new ArrayList<String>();

		SentenciasClase cuerpoClase = declaracionClase.getCuerpoClase();

		for (int i = 0; i < cuerpoClase.getSentencias().size(); i++)  
		{   
			SentenciaClase sc = cuerpoClase.getSentencias().get(i);

			if(sc instanceof SentenciaClase_DeclaracionVariable)
			{
				SentenciaClase_DeclaracionVariable variable = (SentenciaClase_DeclaracionVariable) sc;

				for (Lenguaje ids : variable.getIdentificadoresVariables()) 
				{
					ts.agregarSimboloGeneral(ids.getToken(), variable.getTipo().getToken(), declaracionClase.getIdentificadorClase().getToken());
				}

			}
			if(sc instanceof SentenciaClase_Metodo)
			{
				SentenciaClase_Metodo metodo = (SentenciaClase_Metodo) sc;

				if(metodo.getParametros()!=null || metodo.getParametros().getParametros().size() > 0)     
				{      
					parm = new ArrayList<String>();

					//Almacenar el método nombre, ámbito, retorno, parametros  
					for (Parametro p : metodo.getParametros().getParametros())              
					{ 
						ts.agregarSimboloGeneral(p.getIdentificadorParametro().getToken(), p.getTipoParametro().getToken(), metodo.getIdentificadorMetodo().getToken()); 

						parm.add(""+p.getTipoParametro().getToken());   
					}  

					ts.agregarSimboloMetodo(metodo.getIdentificadorMetodo().getToken(), declaracionClase.getIdentificadorClase().getToken(), metodo.getTipoRetorno().getToken(), parm);
				}

				//Si se crea una variable en una funcion  
				for (SentenciaMetodo s : metodo.getCuerpoMetodo().getSentenciasMetodo())      
				{       
					if(s instanceof SentenciaMetodo_DeclaracionVariable) // Devuelve un valor Booleano que indica  si un objeto es una instancia de una clase en particular.  
					{    
						SentenciaMetodo_DeclaracionVariable dv = (SentenciaMetodo_DeclaracionVariable) s;     

						ts.agregarSimboloGeneral(dv.getIdentificadorVariable().getToken(), dv.getTipo().getToken(), metodo.getIdentificadorMetodo().getToken());    
					}
					else
					{
						llenarTablaAux(ts, s, metodo.getIdentificadorMetodo().getToken());
					}
				}
			} 
		}    
	} 

	public void llenarTablaAux(TablaSimbolos ts, SentenciaMetodo sm, String ambito)
	{
		if(sm instanceof SentenciaMetodo_DeclaracionVariable) // Devuelve un valor Booleano que indica  si un objeto es una instancia de una clase en particular.  
		{    
			SentenciaMetodo_DeclaracionVariable dv = (SentenciaMetodo_DeclaracionVariable) sm;     

			ts.agregarSimboloGeneral(dv.getIdentificadorVariable().getToken(), dv.getTipo().getToken(), ambito);    
		}        
		else if(sm instanceof SentenciaMetodo_Si)
		{
			for (SentenciaMetodo smAux : ((SentenciaMetodo_Si) sm).getOperaciones().getSentenciasMetodo()) 
			{
				llenarTablaAux(ts, smAux, ambito+" Si");
			}
		}
		else if(sm instanceof SentenciaMetodo_Sino)
		{
			for (SentenciaMetodo smAux : ((SentenciaMetodo_Si) sm).getOperaciones().getSentenciasMetodo()) 
			{
				llenarTablaAux(ts, smAux, ambito+" Sino");
			}
		}
		else if(sm instanceof SentenciaMetodo_Delocontrario)
		{
			for (SentenciaMetodo smAux : ((SentenciaMetodo_Si) sm).getOperaciones().getSentenciasMetodo()) 
			{
				llenarTablaAux(ts, smAux, ambito+" Delocontrario");
			}
		}
		else if(sm instanceof SentenciaMetodo_Ciclo)
		{
			for (SentenciaMetodo smAux : ((SentenciaMetodo_Si) sm).getOperaciones().getSentenciasMetodo()) 
			{
				llenarTablaAux(ts, smAux, ambito+" Ciclo");
			}
		}
		else if(sm instanceof SentenciaMetodo_Hacermientras)
		{
			for (SentenciaMetodo smAux : ((SentenciaMetodo_Si) sm).getOperaciones().getSentenciasMetodo()) 
			{
				llenarTablaAux(ts, smAux, ambito+" Hacermientras");
			}
		}
		else if(sm instanceof SentenciaMetodo_Mientras)
		{
			for (SentenciaMetodo smAux : ((SentenciaMetodo_Si) sm).getOperaciones().getSentenciasMetodo()) 
			{
				llenarTablaAux(ts, smAux, ambito+" Mientras");
			}
		}
	}

	/**
	 * @return miRaiz la cual contendra el arbol grafico de esta clase
	 */
	public DefaultMutableTreeNode getArbolVisual() 
	{ 
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode("Unidad de CompilaciÃ³n"); 
		miRaiz.add(paquete.getArbolVisual());
		miRaiz.add(imports.getArbolVisual());
		miRaiz.add(declaracionClase.getArbolVisual());
	
		return miRaiz; 
	}
	
	/**
	 * @return
	 */
	public String getJavaCode()
	{
		return paquete.getJavaCode()+"\n"+imports.getJavaCode()+"\n"+declaracionClase.getJavaCode();
	}
}