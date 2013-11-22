/**
 * 
 */
package co.edu.uniquindio.analizadorLexico.logic;

import java.util.ArrayList;


/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.0 Mayo-2013 
 * Esta clase es la que contiene los atributos de AnalizadorLexico y 
 * maneja su información
 */
public class AnalizadorLexico 
{
	/**
	 * Atributo que contiene el valor de filaActual dentro de la clase
	 */
	private int filaActual;
	/**
	 * Atributo que contiene el valor de columnaActual dentro de la clase
	 */
	private int columnaActual;
	/**
	 * Atributo que contiene el valor de posicionActual dentro de la clase
	 */
	private int posicionActual;
	/**
	 * Atributo que contiene el valor de caracterActual dentro de la clase
	 */
	private char caracterActual;
	/**
	 * Atributo que contiene el valor de codigoFuente dentro de la clase
	 */
	private String codigoFuente;
	/**
	 * Atributo que contiene el valor de tablaLenguaje dentro de la clase
	 */
	private ArrayList<Lenguaje> tablaLenguaje;
	/**
	 * Atributo que contiene el valor de tablaErrores dentro de la clase
	 */
	private ArrayList<Lenguaje> tablaErrores;

	// constante para indicar fin del archivo
	public static final char fin = 0;


	/**
	 * Este metodo permite obtener el valor del atributo filaActual
	 * 
	 * @return filaActual
	 *    Retorna el valor del atributo filaActual
	 */
	public int getFilaActual() {
		return filaActual;
	}


	/**
	 * Este metodo permite asignar un valor al atributo filaActual
	 * 
	 * @param filaActual
	 *            El valor a ser asginado al atributo filaActual
	 */
	public void setFilaActual(int filaActual) {
		this.filaActual = filaActual;
	}


	/**
	 * Este metodo permite obtener el valor del atributo columnaActual
	 * 
	 * @return columnaActual
	 *    Retorna el valor del atributo columnaActual
	 */
	public int getColumnaActual() {
		return columnaActual;
	}


	/**
	 * Este metodo permite asignar un valor al atributo columnaActual
	 * 
	 * @param columnaActual
	 *            El valor a ser asginado al atributo columnaActual
	 */
	public void setColumnaActual(int columnaActual) {
		this.columnaActual = columnaActual;
	}


	/**
	 * Este metodo permite obtener el valor del atributo posicionActual
	 * 
	 * @return posicionActual
	 *    Retorna el valor del atributo posicionActual
	 */
	public int getPosicionActual() {
		return posicionActual;
	}


	/**
	 * Este metodo permite asignar un valor al atributo posicionActual
	 * 
	 * @param posicionActual
	 *            El valor a ser asginado al atributo posicionActual
	 */
	public void setPosicionActual(int posicionActual) {
		this.posicionActual = posicionActual;
	}


	/**
	 * Este metodo permite obtener el valor del atributo caracterActual
	 * 
	 * @return caracterActual
	 *    Retorna el valor del atributo caracterActual
	 */
	public char getCaracterActual() {
		return caracterActual;
	}


	/**
	 * Este metodo permite asignar un valor al atributo caracterActual
	 * 
	 * @param caracterActual
	 *            El valor a ser asginado al atributo caracterActual
	 */
	public void setCaracterActual(char caracterActual) {
		this.caracterActual = caracterActual;
	}


	/**
	 * Este metodo permite obtener el valor del atributo codigoFuente
	 * 
	 * @return codigoFuente
	 *    Retorna el valor del atributo codigoFuente
	 */
	public String getCodigoFuente() {
		return codigoFuente;
	}


	/**
	 * Este metodo permite asignar un valor al atributo codigoFuente
	 * 
	 * @param codigoFuente
	 *            El valor a ser asginado al atributo codigoFuente
	 */
	public void setCodigoFuente(String codigoFuente) {
		this.codigoFuente = codigoFuente;
	}


	/**
	 * Este metodo permite obtener el valor del atributo tablaLenguaje
	 * 
	 * @return tablaLenguaje
	 *    Retorna el valor del atributo tablaLenguaje
	 */
	public ArrayList<Lenguaje> getTablaLenguaje() {
		return tablaLenguaje;
	}


	/**
	 * Este metodo permite asignar un valor al atributo tablaLenguaje
	 * 
	 * @param tablaLenguaje
	 *            El valor a ser asginado al atributo tablaLenguaje
	 */
	public void setTablaLenguaje(ArrayList<Lenguaje> tablaLenguaje) {
		this.tablaLenguaje = tablaLenguaje;
	}

	/**
	 * Este metodo permite obtener el valor del atributo tablaErrores
	 * 
	 * @return tablaErrores
	 *    Retorna el valor del atributo tablaErrores
	 */
	public ArrayList<Lenguaje> getTablaErrores() {
		return tablaErrores;
	}

	/**
	 * Este metodo permite asignar un valor al atributo tablaErrores
	 * 
	 * @param tablaErrores
	 *            El valor a ser asginado al atributo tablaErrores
	 */
	public void setTablaErrores(ArrayList<Lenguaje> tablaErrores) {
		this.tablaErrores = tablaErrores;
	}


	/**
	 * este metodo identifica que partes del codigo fuente son identificadas como palabras reservadas de lenguaje AJC
	 * P=(cadena ,caracter,entero,racional,bool,V,F,metodo,|clase|,SI,SINO,DELOCONTRARIO,CICLO,MIENTRAS,HACERMIENTRAS, return)
	 * La expresion regular es P
	 */
	public boolean palabraReservada() 
	{
		String lenguaje = "";
		int posicionAtras = posicionActual;
		int filaIniToken = filaActual;
		int columnaInicialToken = columnaActual;	

		//Para cadena
		if(caracterActual == 'c')
		{
			lenguaje+=caracterActual;
			siguienteCaracter();

			if(caracterActual == 'a')
			{
				lenguaje+=caracterActual;
				siguienteCaracter();

				if(caracterActual == 'd')
				{
					lenguaje+=caracterActual;
					siguienteCaracter();

					if(caracterActual == 'e')
					{
						lenguaje+=caracterActual;
						siguienteCaracter();

						if(caracterActual == 'n')
						{
							lenguaje+=caracterActual;
							siguienteCaracter();

							if(caracterActual == 'a')
							{
								lenguaje+=caracterActual;
								siguienteCaracter();

								almacenarToken(lenguaje, "Palabra reservada", filaActual, columnaActual);
								return true;
							}
						}
					}
				}
			}
		}
		atras(posicionAtras, filaIniToken, columnaInicialToken);
		lenguaje="";


		//para caracter
		if(caracterActual == 'c')
		{
			lenguaje+=caracterActual;
			siguienteCaracter();

			if(caracterActual == 'a')
			{
				lenguaje+=caracterActual;
				siguienteCaracter();

				if(caracterActual == 'r')
				{
					lenguaje+=caracterActual;
					siguienteCaracter();

					if(caracterActual == 'a')
					{
						lenguaje+=caracterActual;
						siguienteCaracter();

						if(caracterActual == 'c')
						{
							lenguaje+=caracterActual;
							siguienteCaracter();

							if(caracterActual == 't')
							{
								lenguaje+=caracterActual;
								siguienteCaracter();

								if(caracterActual == 'e')
								{
									lenguaje+=caracterActual;
									siguienteCaracter();

									if(caracterActual == 'r')
									{
										lenguaje+=caracterActual;
										siguienteCaracter();

										almacenarToken(lenguaje, "Palabra reservada", filaActual, columnaActual);
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		atras(posicionAtras, filaIniToken, columnaInicialToken);
		lenguaje = "";

		//para entero
		if(caracterActual == 'e')
		{
			lenguaje+=caracterActual;
			siguienteCaracter();

			if(caracterActual == 'n')
			{
				lenguaje+=caracterActual;
				siguienteCaracter();

				if(caracterActual == 't')
				{
					lenguaje+=caracterActual;
					siguienteCaracter();

					if(caracterActual == 'e')
					{
						lenguaje+=caracterActual;
						siguienteCaracter();

						if(caracterActual == 'r')
						{
							lenguaje+=caracterActual;
							siguienteCaracter();

							if(caracterActual == 'o')
							{
								lenguaje+=caracterActual;
								siguienteCaracter();
								almacenarToken(lenguaje, "Palabra reservada", filaActual, columnaActual);
								return true;
							}
						}
					}
				}
			}
		}
		atras(posicionAtras, filaIniToken, columnaInicialToken);


		//para racional
		if(caracterActual == 'r')
		{
			lenguaje+=caracterActual;
			siguienteCaracter();

			if(caracterActual == 'a')
			{
				lenguaje+=caracterActual;
				siguienteCaracter();

				if(caracterActual == 'c')
				{
					lenguaje+=caracterActual;
					siguienteCaracter();

					if(caracterActual == 'i')
					{
						lenguaje+=caracterActual;
						siguienteCaracter();

						if(caracterActual == 'o')
						{
							lenguaje+=caracterActual;
							siguienteCaracter();

							if(caracterActual == 'n')
							{
								lenguaje+=caracterActual;
								siguienteCaracter();

								if(caracterActual == 'a')
								{
									lenguaje+=caracterActual;
									siguienteCaracter();

									if(caracterActual == 'l')
									{
										lenguaje+=caracterActual;
										siguienteCaracter();

										almacenarToken(lenguaje, "Palabra reservada", filaActual, columnaActual);
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		atras(posicionAtras, filaIniToken, columnaInicialToken);

		// para bool
		if(caracterActual == 'b')
		{
			lenguaje+=caracterActual;
			siguienteCaracter();

			if(caracterActual == 'o')
			{
				lenguaje+=caracterActual;
				siguienteCaracter();

				if(caracterActual == 'o')
				{
					lenguaje+=caracterActual;
					siguienteCaracter();

					if(caracterActual == 'l')
					{
						lenguaje+=caracterActual;
						siguienteCaracter();

						almacenarToken(lenguaje, "Palabra reservada", filaActual, columnaActual);
						return true;
					}
				}
			}
		}
		atras(posicionAtras, filaIniToken, columnaInicialToken);

		// para V (verdad)
		if(caracterActual == 'V')
		{
			lenguaje+=caracterActual;
			siguienteCaracter();

			almacenarToken(lenguaje, "Palabra reservada", filaActual, columnaActual);
			return true;
		}
		atras(posicionAtras, filaIniToken, columnaInicialToken);


		//para F (falsedad)
		if(caracterActual == 'F')
		{
			lenguaje+=caracterActual;
			siguienteCaracter();

			almacenarToken(lenguaje, "Palabra reservada", filaActual, columnaActual);
			return true;
		}
		atras(posicionAtras, filaIniToken, columnaInicialToken);

		// para definicion de metodo
		if(caracterActual == 'm')
		{
			lenguaje+=caracterActual;
			siguienteCaracter();

			if(caracterActual == 'e')
			{
				lenguaje+=caracterActual;
				siguienteCaracter();

				if(caracterActual == 't')
				{
					lenguaje+=caracterActual;
					siguienteCaracter();

					if(caracterActual == 'o')
					{
						lenguaje+=caracterActual;
						siguienteCaracter();

						if(caracterActual == 'd')
						{
							lenguaje+=caracterActual;
							siguienteCaracter();

							if(caracterActual == 'o')
							{
								lenguaje+=caracterActual;
								siguienteCaracter();

								almacenarToken(lenguaje, "Palabra reservada", filaActual, columnaActual);
								return true;
							}
						}
					}
				}
			}
		}
		atras(posicionAtras, filaIniToken, columnaInicialToken);

		//para definicion de clase
		if(caracterActual == 'c')
		{
			lenguaje+=caracterActual;
			siguienteCaracter();

			if(caracterActual == 'l')
			{
				lenguaje+=caracterActual;
				siguienteCaracter();

				if(caracterActual == 'a')
				{
					lenguaje+=caracterActual;
					siguienteCaracter();

					if(caracterActual == 's')
					{
						lenguaje+=caracterActual;
						siguienteCaracter();

						if(caracterActual == 'e')
						{
							lenguaje+=caracterActual;
							almacenarToken(lenguaje, "Palabra reservada", filaActual, columnaActual);
							siguienteCaracter();
							return true;
							
						}
					}
				}
			}
		}
		atras(posicionAtras, filaIniToken, columnaInicialToken);

		//para definicon de desicion SINO
		if(caracterActual == 'S')
		{
			lenguaje+=caracterActual;
			siguienteCaracter();

			if(caracterActual == 'I')
			{
				lenguaje+=caracterActual;
				siguienteCaracter();

				if(caracterActual == 'N')
				{
					lenguaje+=caracterActual;
					siguienteCaracter();

					if(caracterActual == 'O')
					{
						lenguaje+=caracterActual;
						siguienteCaracter();

						almacenarToken(lenguaje, "Palabra reservada", filaActual, columnaActual);
						return true;
					}
				}
			}
		}
		atras(posicionAtras, filaIniToken, columnaInicialToken);
		lenguaje="";

		// para definicon de desicion SI
		if(caracterActual == 'S')
		{
			lenguaje+=caracterActual;
			siguienteCaracter();

			if(caracterActual == 'I')
			{
				lenguaje+=caracterActual;
				siguienteCaracter();

				almacenarToken(lenguaje, "Palabra reservada", filaActual, columnaActual);
				return true;
			}

		}
		atras(posicionAtras, filaIniToken, columnaInicialToken);


		// para definicion de desicion DELOCONTRARIO
		if(caracterActual == 'D')
		{
			lenguaje+=caracterActual;
			siguienteCaracter();

			if(caracterActual == 'E')
			{
				lenguaje+=caracterActual;
				siguienteCaracter();

				if(caracterActual == 'L')
				{
					lenguaje+=caracterActual;
					siguienteCaracter();

					if(caracterActual == 'O')
					{
						lenguaje+=caracterActual;
						siguienteCaracter();

						if(caracterActual == 'C')
						{
							lenguaje+=caracterActual;
							siguienteCaracter();

							if(caracterActual == 'O')
							{
								lenguaje+=caracterActual;
								siguienteCaracter();

								if(caracterActual == 'N')
								{
									lenguaje+=caracterActual;
									siguienteCaracter();

									if(caracterActual == 'T')
									{
										lenguaje+=caracterActual;
										siguienteCaracter();
										if(caracterActual == 'R')
										{
											lenguaje+=caracterActual;
											siguienteCaracter();
											if(caracterActual == 'A')
											{
												lenguaje+=caracterActual;
												siguienteCaracter();
												if(caracterActual == 'R')
												{
													lenguaje+=caracterActual;
													siguienteCaracter();
													if(caracterActual == 'I')
													{
														lenguaje+=caracterActual;
														siguienteCaracter();

														if(caracterActual == 'O')
														{
															lenguaje+=caracterActual;
															siguienteCaracter();

															almacenarToken(lenguaje, "Palabra reservada", filaActual, columnaActual);
															return true;
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		atras(posicionAtras, filaIniToken, columnaInicialToken);

		// para definicon de CICLO
		if(caracterActual == 'C')
		{
			lenguaje+=caracterActual;
			siguienteCaracter();

			if(caracterActual == 'I')
			{
				lenguaje+=caracterActual;
				siguienteCaracter();

				if(caracterActual == 'C')
				{
					lenguaje+=caracterActual;
					siguienteCaracter();
					if(caracterActual == 'L')
					{
						lenguaje+=caracterActual;
						siguienteCaracter();
						if(caracterActual == 'O')
						{
							lenguaje+=caracterActual;
							siguienteCaracter();

							almacenarToken(lenguaje, "Palabra reservada", filaActual, columnaActual);
							return true;
						}
					}
				}
			}
		}

		atras(posicionAtras, filaIniToken, columnaInicialToken);
		lenguaje="";



		//para definion de ciclo HACERMIENTRAS
		if(caracterActual == 'H')
		{
			lenguaje+=caracterActual;
			siguienteCaracter();

			if(caracterActual == 'A')
			{
				lenguaje+=caracterActual;
				siguienteCaracter();

				if(caracterActual == 'C')
				{
					lenguaje+=caracterActual;
					siguienteCaracter();
					if(caracterActual == 'E')
					{
						lenguaje+=caracterActual;
						siguienteCaracter();
						if(caracterActual == 'R')
						{
							lenguaje+=caracterActual;
							siguienteCaracter();
							if(caracterActual == 'M')
							{
								lenguaje+=caracterActual;
								siguienteCaracter();
								if(caracterActual == 'I')
								{
									lenguaje+=caracterActual;
									siguienteCaracter();
									if(caracterActual == 'E')
									{
										lenguaje+=caracterActual;
										siguienteCaracter();
										if(caracterActual == 'N')
										{
											lenguaje+=caracterActual;
											siguienteCaracter();
											if(caracterActual == 'T')
											{
												lenguaje+=caracterActual;
												siguienteCaracter();
												if(caracterActual == 'R')
												{
													lenguaje+=caracterActual;
													siguienteCaracter();
													if(caracterActual == 'A')
													{
														lenguaje+=caracterActual;
														siguienteCaracter();

														if(caracterActual == 'S')
														{
															lenguaje+=caracterActual;
															siguienteCaracter();

															almacenarToken(lenguaje, "palabra reservada", filaActual, columnaActual);
															return true;
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		atras(posicionAtras, filaIniToken, columnaInicialToken);
		lenguaje="";

		// para definicon de ciclo MIENTRAS
		if(caracterActual == 'M')
		{
			lenguaje+=caracterActual;
			siguienteCaracter();

			if(caracterActual == 'I')
			{
				lenguaje+=caracterActual;
				siguienteCaracter();

				if(caracterActual == 'E')
				{
					lenguaje+=caracterActual;
					siguienteCaracter();
					if(caracterActual == 'N')
					{
						lenguaje+=caracterActual;
						siguienteCaracter();
						if(caracterActual == 'T')
						{
							lenguaje+=caracterActual;
							siguienteCaracter();
							if(caracterActual == 'R')
							{
								lenguaje+=caracterActual;
								siguienteCaracter();
								if(caracterActual == 'A')
								{
									lenguaje+=caracterActual;
									siguienteCaracter();

									if(caracterActual == 'S')
									{
										lenguaje+=caracterActual;
										siguienteCaracter();

										almacenarToken(lenguaje, "palabra reservada", filaActual, columnaActual);
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		atras(posicionAtras, filaIniToken, columnaInicialToken);
		lenguaje="";

		//Para definicion del return
		if(caracterActual=='r')
		{
			lenguaje+=caracterActual;
			siguienteCaracter();
			if(caracterActual=='e')
			{
				lenguaje+=caracterActual;
				siguienteCaracter();
				if(caracterActual=='t')
				{
					lenguaje+=caracterActual;
					siguienteCaracter();
					if(caracterActual=='u')
					{
						lenguaje+=caracterActual;
						siguienteCaracter();
						if(caracterActual=='r')
						{
							lenguaje+=caracterActual;
							siguienteCaracter();
							if(caracterActual=='n')
							{
								lenguaje+=caracterActual;
								almacenarToken(lenguaje, "Palabra reservada", filaActual, columnaActual);
								siguienteCaracter();
								return true;
							}
						}
					}
				}
			}
		}
		atras(posicionAtras, filaIniToken, columnaInicialToken);
		lenguaje="";
		
		//paquete
		if(caracterActual=='p')
		{
			lenguaje+=caracterActual;
			siguienteCaracter();
			if(caracterActual=='a')
			{
				lenguaje+=caracterActual;
				siguienteCaracter();
				if(caracterActual=='q')
				{
					lenguaje+=caracterActual;
					siguienteCaracter();
					if(caracterActual=='u')
					{
						lenguaje+=caracterActual;
						siguienteCaracter();
						if(caracterActual=='e')
						{
							lenguaje+=caracterActual;
							siguienteCaracter();
							if(caracterActual=='t')
							{
								lenguaje+=caracterActual;
								siguienteCaracter();
								if(caracterActual=='e')
								{
									lenguaje+=caracterActual;
									almacenarToken(lenguaje, "Palabra reservada", filaActual, columnaActual);
									siguienteCaracter();
									return true;
								}
							}
						}
					}
				}
			}
		}
		atras(posicionAtras, filaIniToken, columnaInicialToken);
		lenguaje="";
		
		//paquete
		if(caracterActual=='i')
		{
			lenguaje+=caracterActual;
			siguienteCaracter();
			if(caracterActual=='m')
			{
				lenguaje+=caracterActual;
				siguienteCaracter();
				if(caracterActual=='p')
				{
					lenguaje+=caracterActual;
					siguienteCaracter();
					if(caracterActual=='o')
					{
						lenguaje+=caracterActual;
						siguienteCaracter();
						if(caracterActual=='r')
						{
							lenguaje+=caracterActual;
							siguienteCaracter();
							if(caracterActual=='t')
							{
								lenguaje+=caracterActual;
								siguienteCaracter();
								if(caracterActual=='a')
								{
									lenguaje+=caracterActual;
									siguienteCaracter();
									if(caracterActual=='r')
									{
										lenguaje+=caracterActual;
										almacenarToken(lenguaje, "Palabra reservada", filaActual, columnaActual);
										siguienteCaracter();
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		atras(posicionAtras, filaIniToken, columnaInicialToken);
		lenguaje="";
		
		//publico
		if(caracterActual=='p')
		{
			lenguaje+=caracterActual;
			siguienteCaracter();
			if(caracterActual=='u')
			{
				lenguaje+=caracterActual;
				siguienteCaracter();
				if(caracterActual=='b')
				{
					lenguaje+=caracterActual;
					siguienteCaracter();
					if(caracterActual=='l')
					{
						lenguaje+=caracterActual;
						siguienteCaracter();
						if(caracterActual=='i')
						{
							lenguaje+=caracterActual;
							siguienteCaracter();
							if(caracterActual=='c')
							{
								lenguaje+=caracterActual;
								siguienteCaracter();
								if(caracterActual=='o')
								{
									lenguaje+=caracterActual;
									almacenarToken(lenguaje, "Palabra reservada", filaActual, columnaActual);
									siguienteCaracter();
									return true;
								}
							}
						}
					}
				}
			}
		}
		atras(posicionAtras, filaIniToken, columnaInicialToken);
		lenguaje="";
		
		//privado
		if(caracterActual=='p')
		{
			lenguaje+=caracterActual;
			siguienteCaracter();
			if(caracterActual=='r')
			{
				lenguaje+=caracterActual;
				siguienteCaracter();
				if(caracterActual=='i')
				{
					lenguaje+=caracterActual;
					siguienteCaracter();
					if(caracterActual=='v')
					{
						lenguaje+=caracterActual;
						siguienteCaracter();
						if(caracterActual=='a')
						{
							lenguaje+=caracterActual;
							siguienteCaracter();
							if(caracterActual=='d')
							{
								lenguaje+=caracterActual;
								siguienteCaracter();
								if(caracterActual=='o')
								{
									lenguaje+=caracterActual;
									almacenarToken(lenguaje, "Palabra reservada", filaActual, columnaActual);
									siguienteCaracter();
									return true;
								}
							}
						}
					}
				}
			}
		}
		
		atras(posicionAtras, filaIniToken, columnaInicialToken);
//		lenguaje="";
		return false;


	}

	/**
	 * Este metodo define los operadores relacionales establecidos en el lenguaje AJC
	 * La expresion regular es (>U<)U(>U<)=
	 * @return true si es un operador relacional de lo contrario false
	 */
	public boolean operadorRelacional()
	{
		String lenguaje = caracterActual + "";
		int posicionParaAtras = posicionActual;
		int filaIniToken = filaActual;
		int columnaInicialToken = columnaActual;

		// operador logico mayor igual que
		if (caracterActual == '>') {
			siguienteCaracter();	
			if (caracterActual == '=') {
				lenguaje += caracterActual;
				siguienteCaracter();
				almacenarToken(lenguaje, "Operador relacional mayor igual", filaIniToken,
						columnaInicialToken);
				return true;
			}
		}


		atras(posicionParaAtras, filaIniToken, columnaInicialToken);

		// operador logico mayor que
		if (caracterActual == '>') {
			siguienteCaracter();
			almacenarToken(lenguaje, "Operador relacional mayor", filaIniToken,
					columnaInicialToken);
			return true;
		}

		atras(posicionParaAtras, filaIniToken, columnaInicialToken);

		// operador logico menor igual que

		if (caracterActual == '<') {
			siguienteCaracter();
			if (caracterActual == '=') {
				lenguaje += caracterActual;
				siguienteCaracter();
				almacenarToken(lenguaje, "Operador relacional menor igual", filaIniToken,
						columnaInicialToken);
				return true;
			}
		}


		atras(posicionParaAtras, filaIniToken, columnaInicialToken);

		// operador logico menor que
		if (caracterActual == '<') {
			siguienteCaracter();
			almacenarToken(lenguaje, "Operador relacional menor", filaIniToken,
					columnaInicialToken);
			return true;
		}


		atras(posicionParaAtras, filaIniToken, columnaInicialToken);
		return false;
	}

	/**
	 * Este metodo define los operadores logicos establesidos en el lenguaje AJC
	 * La expresion regular es &&U|| U != U ¡ U == 
	 */
	public boolean operadorLogico()
	{
		String lenguaje = caracterActual + "";
		int posicionParaAtras = posicionActual;
		int filaIniToken = filaActual;
		int columnaInicialToken = columnaActual;


		// operador logico diferente

		if (caracterActual == '!') {
			siguienteCaracter();
			lenguaje += caracterActual;
			if (caracterActual == '=') {
				siguienteCaracter();
				almacenarToken(lenguaje, "Operador logico diferente", filaIniToken,
						columnaInicialToken);
				return true;
			}
		}
		atras(posicionParaAtras, filaIniToken, columnaInicialToken);

		//operador logico negado
		if (caracterActual == '!') {
			siguienteCaracter();
			almacenarToken(lenguaje, "Operador logico negado", filaIniToken,
					columnaInicialToken);
			return true;

		}

		atras(posicionParaAtras, filaIniToken, columnaInicialToken);		

		// operador logico igual igual
		if (caracterActual == '=') {
			siguienteCaracter();
			lenguaje += caracterActual;
			if (caracterActual == '=') {
				siguienteCaracter();
				almacenarToken(lenguaje, "Operador logico igual igual", filaIniToken,
						columnaInicialToken);
				return true;
			}
		}

		atras(posicionParaAtras, filaIniToken, columnaInicialToken);

		//		// operador logico mayor igual que
		//		if (caracterActual == '>') {
		//			siguienteCaracter();	
		//			if (caracterActual == '=') {
		//				lenguaje += caracterActual;
		//				siguienteCaracter();
		//				almacenarToken(lenguaje, "Operador relacional mayor igual", filaIniToken,
		//						columnaInicialToken);
		//				return true;
		//			}
		//		}
		//
		//
		//		atras(posicionParaAtras, filaIniToken, columnaInicialToken);
		//
		//		// operador logico mayor que
		//		if (caracterActual == '>') {
		//			siguienteCaracter();
		//			almacenarToken(lenguaje, "Operador relacional mayor", filaIniToken,
		//					columnaInicialToken);
		//			return true;
		//		}
		//
		//		atras(posicionParaAtras, filaIniToken, columnaInicialToken);
		//
		//		// operador logico menor igual que
		//
		//		if (caracterActual == '<') {
		//			siguienteCaracter();
		//			if (caracterActual == '=') {
		//				lenguaje += caracterActual;
		//				siguienteCaracter();
		//				almacenarToken(lenguaje, "Operador relacional menor igual", filaIniToken,
		//						columnaInicialToken);
		//				return true;
		//			}
		//		}
		//
		//
		//		atras(posicionParaAtras, filaIniToken, columnaInicialToken);
		//
		//		// operador logico menor que
		//		if (caracterActual == '<') {
		//			siguienteCaracter();
		//			almacenarToken(lenguaje, "Operador relacional menor", filaIniToken,
		//					columnaInicialToken);
		//			return true;
		//		}
		//
		//
		//		atras(posicionParaAtras, filaIniToken, columnaInicialToken);


		// operador logico Y
		if (caracterActual == '&') {
			siguienteCaracter();
			lenguaje += caracterActual;
			if (caracterActual == '&') {
				siguienteCaracter();
				almacenarToken(lenguaje, "Operador logico Y", filaIniToken,
						columnaInicialToken);
				return true;
			}
		}
		atras(posicionParaAtras, filaIniToken, columnaInicialToken);

		// operador logico o
		if (caracterActual == '|') {
			siguienteCaracter();
			lenguaje += caracterActual;
			if (caracterActual == '|') {
				siguienteCaracter();
				almacenarToken(lenguaje, "Operador logico O", filaIniToken,
						columnaInicialToken);
				return true;
			}
		}
		atras(posicionParaAtras, filaIniToken, columnaInicialToken);
		return false;
	}


	/**
	 * Este metodo define los operadores aritmeticos establecidos por el lenguaje AJC
	 * Expresion regular de los operadores aditivos +U-
	 * Expresion regular de los operadores multiplicativos *U÷
	 */
	public boolean operadorAritmetico()
	{
		String lexema = caracterActual + "";
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual;
		int columnaInicialToken = columnaActual;

		// operador aritmetico suma

		if (caracterActual == '+') {
			siguienteCaracter();
			almacenarToken(lexema, "Operador aditivo suma", filaIniToken,
					columnaInicialToken);
			return true;
		}
		atras(posicionParaBactraking, filaIniToken, columnaInicialToken);

		//operador aritmetico resta
		if (caracterActual == '-') {
			siguienteCaracter();
			almacenarToken(lexema, "Operador aditivo resta", filaIniToken,
					columnaInicialToken);
			return true;
		}

		atras(posicionParaBactraking, filaIniToken, columnaInicialToken);

		//operador aritmetico multiplicacion
		if (caracterActual == '*') {
			siguienteCaracter();
			almacenarToken(lexema, "Operador multiplicativo multiplicacion", filaIniToken,
					columnaInicialToken);
			return true;
		}

		atras(posicionParaBactraking, filaIniToken, columnaInicialToken);

		//operador aritmetico division
		if (caracterActual == '/') {
			siguienteCaracter();
			almacenarToken(lexema, "Operador multiplicativo division", filaIniToken,
					columnaInicialToken);
			return true;
		}
		atras(posicionParaBactraking, filaIniToken, columnaInicialToken);

		//operador aritmetico igual
		if (caracterActual == '=') {
			siguienteCaracter();
			almacenarToken(lexema, "Operador de asignacion igual", filaIniToken,
					columnaInicialToken);
			return true;
		}
		atras(posicionParaBactraking, filaIniToken, columnaInicialToken);

		//operador aritmetico modulo
		if (caracterActual == '%') {
			siguienteCaracter();
			almacenarToken(lexema, "Operador aritmetico modulo", filaIniToken,
					columnaInicialToken);
			return true;
		}
		atras(posicionParaBactraking, filaIniToken, columnaInicialToken);
		return false;
	}


	public boolean otrosSimbolos()
	{
		String lexema = caracterActual + "";
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual;
		int columnaInicialToken = columnaActual;

		// Lave abierta

		if (caracterActual == '{') {
			siguienteCaracter();
			almacenarToken(lexema, " Agrupador Llave abierta", filaIniToken,
					columnaInicialToken);
			return true;
		}
		atras(posicionParaBactraking, filaIniToken, columnaInicialToken);

		//Llave cerrada
		if (caracterActual == '}') {
			siguienteCaracter();
			almacenarToken(lexema, "Agrupador Llave cerrada", filaIniToken,
					columnaInicialToken);
			return true;
		}

		atras(posicionParaBactraking, filaIniToken, columnaInicialToken);

		//Parentesis abierto
		if (caracterActual == '(') {
			siguienteCaracter();
			almacenarToken(lexema, "Agrupador Parentesis abierto", filaIniToken,
					columnaInicialToken);
			return true;
		}
		atras(posicionParaBactraking, filaIniToken, columnaInicialToken);

		//Parentesis cerrado
		if (caracterActual == ')') {
			siguienteCaracter();
			almacenarToken(lexema, "Agrupador Parentesis cerrado", filaIniToken,
					columnaInicialToken);
			return true;
		}
		atras(posicionParaBactraking, filaIniToken, columnaInicialToken);
		return false;
	}

	/**
	 * Este metodo define los comentarios en el lenguaje 
	 */
	@SuppressWarnings("unused")
	public boolean comentario()
	{
		int posicionAtras = posicionActual;
		int filaIniToken = filaActual;
		int columnaInicialToken = columnaActual;
		String lenguaje =  "";

		//comentario de linea
		if (caracterActual == '/') {
			siguienteCaracter();
			if (caracterActual == '/') {
				siguienteCaracter();
				while(Character.isLetter(caracterActual)||Character.isDigit(caracterActual)|| caracterActual==' '|| caracterActual=='\t')
				{
					siguienteCaracter();
				}
				return true;
			}
		}
		atras(posicionAtras, filaIniToken, columnaInicialToken);
		lenguaje="";

		//comentario de bloque
		if (caracterActual == '/') {
			siguienteCaracter();
			if (caracterActual == '*') {
				siguienteCaracter();
				while(Character.isLetter(caracterActual)||Character.isDigit(caracterActual)|| caracterActual==' '|| caracterActual=='\t'|| caracterActual=='\n')
				{
					//					lenguaje+=caracterActual;
					siguienteCaracter();
				}
				if(caracterActual=='*')
				{
					//					lenguaje += caracterActual;
					siguienteCaracter();
					if(caracterActual=='/')
					{
						//						lenguaje += caracterActual;
						siguienteCaracter();
						//						almacenarToken(lenguaje, "Comentario de bloque", filaIniToken,
						//								columnaInicialToken);
						return true;

					}
				}

			}
		}
		atras(posicionAtras, filaIniToken, columnaInicialToken);
		return false;
	}

	/**
	 * Este metodo define el salto de linea permitido por el lenguje AJc
	 */
	public boolean saltoLinea()
	{
		if (caracterActual == '\n') {
			siguienteCaracter();
			return true;
		}
		return false;
	}

	/**
	 * Este metodo define el fin de linea aceptado por el lenguaje AJC
	 */
	public boolean finDeLinea() 
	{
		int filaIniToken = filaActual;
		int columnaInicialToken = columnaActual;

		String lenguaje = caracterActual + "";

		if (caracterActual == '.') 
		{
			siguienteCaracter();
			almacenarToken(lenguaje, "Terminal", filaIniToken,
					columnaInicialToken);
			return true;
		}
		return false;

	}

	/**
	 * Este metodo define como seran establecidas las reglas de como sera escrito un identificador de clase
	 * la expresion regular es #L(DUL)^*#
	 */
	public boolean identificadorClase()
	{
		int posicionAtras = posicionActual;
		int filaIniToken = filaActual;
		int columnaInicialToken = columnaActual;
		String lenguaje =  "";

		if(caracterActual=='#')
		{
			lenguaje+=caracterActual;
			siguienteCaracter();
			if(Character.isLetter(caracterActual))
			{
				lenguaje+=caracterActual;
				siguienteCaracter();
				while(Character.isLetter(caracterActual)||Character.isDigit(caracterActual))
				{
					lenguaje+=caracterActual;
					siguienteCaracter();
				}

				if(caracterActual=='#')
				{
					lenguaje+=caracterActual;
					siguienteCaracter();
					almacenarToken(lenguaje, "Identificador de clase", filaIniToken, columnaInicialToken);

					return true;
				}

			}
		}
		atras(posicionAtras, filaIniToken, columnaInicialToken);
		return false;
	}

	/**
	 * Este metodo define como seran establecidas las reglas de como sera escrito un identificador de metodo
	 * La expresion regular es $L(D,L)^*$ 
	 */
	public boolean identificadorMetodo()
	{
		int posicionAtras = posicionActual;
		int filaIniToken = filaActual;
		int columnaInicialToken = columnaActual;
		String lenguaje =  "";

		if(caracterActual=='$')
		{
			lenguaje+=caracterActual;
			siguienteCaracter();
			if(Character.isLetter(caracterActual))
			{
				lenguaje+=caracterActual;
				siguienteCaracter();
				while(Character.isLetter(caracterActual)||Character.isDigit(caracterActual))
				{
					lenguaje+=caracterActual;
					siguienteCaracter();
				}

				if(caracterActual=='$')
				{
					lenguaje+=caracterActual;
					siguienteCaracter();
					almacenarToken(lenguaje, "Identificador de metodo", filaIniToken, columnaInicialToken);

					return true;
				}

			}
		}
		atras(posicionAtras, filaIniToken, columnaInicialToken);
		return false;
	}

	/**
	 * Este metodo define como seran establecidas las reglas de como sera escrito un identificador de atributo
	 * la Expresion regular es @L(D,L)^*
	 */
	public boolean identificadorAtributo()
	{
		int posicionAtras = posicionActual;
		int filaIniToken = filaActual;
		int columnaInicialToken = columnaActual;
		String lenguaje =  "";

		if(caracterActual=='@')
		{
			lenguaje+=caracterActual;
			siguienteCaracter();
			if(Character.isLetter(caracterActual))
			{
				lenguaje+=caracterActual;
				siguienteCaracter();
				while(Character.isLetter(caracterActual)||Character.isDigit(caracterActual))
				{
					lenguaje+=caracterActual;
					siguienteCaracter();
				}

				almacenarToken(lenguaje, "Identificador de atributo", filaIniToken, columnaInicialToken);

				return true;


			}
		}
		atras(posicionAtras, filaIniToken, columnaInicialToken);
		return false;
	}

	/**
	 *Este metodo define como seran establecidas las reglas para definir las clases en el lenguaje AJC
	 */
	public boolean definicionClase() 
	{
		String lenguaje = caracterActual + "";
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual;
		int columnaInicialToken = columnaActual;

		if (caracterActual == '|') {
			siguienteCaracter();
			lenguaje += caracterActual;
			if (caracterActual == 'c') {
				siguienteCaracter();
				lenguaje += caracterActual;
				if (caracterActual == 'l') {
					siguienteCaracter();
					lenguaje += caracterActual;
					if (caracterActual == 'a') {
						siguienteCaracter();
						lenguaje += caracterActual;
						if (caracterActual == 's') {
							siguienteCaracter();
							lenguaje += caracterActual;
							if (caracterActual == 'e') {
								siguienteCaracter();
								lenguaje += caracterActual;
								if (caracterActual == '|') {
									siguienteCaracter();
									if(Character.isLetter(caracterActual))
									{
										while (Character.isLetter(caracterActual)) {
											lenguaje += caracterActual;
											siguienteCaracter();
										}
										almacenarToken(lenguaje,
												"Identificador de clase", filaIniToken,
												columnaInicialToken);
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		atras(posicionParaBactraking, filaIniToken, columnaInicialToken);
		return false;
	}


	/**
	 * Este metodo definen que simbolos seran aceptados como enteros en el lenguaje AJC
	 * La expresion regular es N^+
	 */
	public boolean entero() {

		if (!Character.isDigit(caracterActual)) 
		{
			return false;
		}

		int posicionAtras = posicionActual;
		int filaIniToken = filaActual;
		int columnaInicialToken = columnaActual;

		String lenguaje = caracterActual + "";

		if (Character.isDigit((caracterActual)))
			siguienteCaracter();

		while (Character.isDigit(caracterActual)) 
		{
			lenguaje += caracterActual;

			siguienteCaracter();
		}
		if (caracterActual == ',')
		{
			atras(posicionAtras, filaIniToken,
					columnaInicialToken);
			return false;
		}

		else {
			almacenarToken(lenguaje, "entero", filaIniToken, columnaInicialToken);
			return true;
		}

	}

	/**
	 * Este metodo definen que simbolos seran aceptados como cadena en el lenguaje AJC
	 * La expresion regular es LL*
	 */
	private boolean cadena() 
	{
		int posicionAtras = posicionActual;
		int filaIniToken = filaActual;
		int columnaInicialToken = columnaActual;
		String lenguaje =  "";

		if(caracterActual=='"')
		{
			lenguaje+=caracterActual;
			siguienteCaracter();
			if(Character.isLetter(caracterActual))
			{
				lenguaje+=caracterActual;
				siguienteCaracter();
				while(Character.isLetter(caracterActual))
				{
					lenguaje+=caracterActual;
					siguienteCaracter();
				}

				if(caracterActual=='"')
				{
					lenguaje+=caracterActual;
					siguienteCaracter();
					almacenarToken(lenguaje, "cadena", filaIniToken, columnaInicialToken);

					return true;
				}

			}
		}
		atras(posicionAtras, filaIniToken, columnaInicialToken);
		return false;
	}


	/**
	 * Este metodo definen que simbolos seran aceptados como caracteres en el lenguaje AJC
	 * La expresion regular es L
	 */
	public boolean caracter()
	{
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual;
		int columnaInicialToken = columnaActual;
		String lenguaje = "";

		if(Character.isLetter(caracterActual))
		{
			lenguaje+=caracterActual;
			siguienteCaracter();
			almacenarToken(lenguaje, "Caracter", filaIniToken, columnaInicialToken);
			return true;
		}				
		atras(posicionParaBactraking, filaIniToken, columnaInicialToken);
		return false;
	}	

	/**
	 * Este metodo definen que simbolos seran aceptados como racionales en el lenguaje AJC
	 * La expresion regular es N^+,N^+
	 */
	@SuppressWarnings("unused")
	public boolean racional()
	{
		int posicionAtras = posicionActual;
		int filaIniToken = filaActual;
		int columnaInicialToken = columnaActual;

		String lenguaje = caracterActual + "";

		if (Character.isDigit((caracterActual)))
		{
			siguienteCaracter();
			while (Character.isDigit(caracterActual)) {
				lenguaje += caracterActual;
				siguienteCaracter();
			}
			if(caracterActual==',')
			{
				lenguaje+=caracterActual;
				siguienteCaracter();
				if(Character.isDigit(caracterActual))
				{
					lenguaje+=caracterActual;
					siguienteCaracter();
					while (Character.isDigit(caracterActual)) {
						lenguaje += caracterActual;
						siguienteCaracter();
					}
					almacenarToken(lenguaje, "Racional", filaIniToken, columnaInicialToken);
					return true;
				}
			}
		}
		return false;
	}


	/**
	 * este metodo genera la manera del siguiente caracter
	 */
	private void siguienteCaracter()
	{
		if (codigoFuente.charAt(posicionActual + 1) == fin) 
		{
			caracterActual = fin;
		}
		else 
		{
			if (codigoFuente.charAt(posicionActual + 1) == '\n')
			{		filaActual++;
			columnaActual = 0;
			}
			else 
			{
				if (codigoFuente.charAt(posicionActual + 1) == '\t')
					columnaActual += 4;
				else
					columnaActual++;
			}

			posicionActual++;
			caracterActual = codigoFuente.charAt(posicionActual);

		}
	}



	/**
	 * Este metodo almacena los tokens que van siendo analizados
	 */
	private void almacenarToken(String lexema, String token, int filaInicial,int columnaInicial) 
	{
		Lenguaje miLenguaje = new Lenguaje(lexema, token, filaInicial,columnaInicial);
		tablaLenguaje.add(miLenguaje);
	}

	/**
	 * 
	 */
	private void atras(int posicionAtras, int filaInicialToken,int columnaInicialToken) 
	{
		posicionActual = posicionAtras; 
		caracterActual = codigoFuente.charAt(posicionActual); 
		columnaActual = columnaInicialToken; 
		filaActual = filaInicialToken;
	}

	/**
	 * 
	 */
	public void analizadorLenguaje(String codigoFuente)
	{
		filaActual = columnaActual = 1;
		this.codigoFuente = codigoFuente;
		posicionActual = 0;
		tablaLenguaje = new ArrayList<Lenguaje>();
		tablaErrores = new ArrayList<Lenguaje>();

		if (codigoFuente.length() != fin) 
		{
			caracterActual = codigoFuente.toCharArray()[posicionActual];
		} 
		else
		{
			caracterActual = fin;
		}

		while (caracterActual != fin)
		{
			if (palabraReservada())
				continue;
			if (operadorRelacional())
				continue;
			if (operadorLogico())
				continue;
			if (comentario())
				continue;
			if (operadorAritmetico())
				continue;
			if (saltoLinea())
				continue;
			if (finDeLinea())
				continue;
			if(identificadorClase())
				continue;
			if(identificadorMetodo())
				continue;
			if(identificadorAtributo())
				continue;
			if (definicionClase())
				continue;
			if (cadena())
				continue;
			if (caracter())
				continue;
			if (entero())
				continue;
			if (racional())
				continue;
			if (otrosSimbolos())
				continue;

			desconocido("" + caracterActual, "Invalido", filaActual,
					columnaActual);
			siguienteCaracter();

		}
	}


	/**
	 * @param lenguaje
	 * @param error
	 * @param filaInicial
	 * @param columnaInicial
	 */
	private void desconocido(String lenguaje, String error, int filaInicial,int columnaInicial) 
	{
		if(lenguaje.equals(" ") || lenguaje.equals("\t"))
			return;
		Lenguaje temporal = new Lenguaje(lenguaje, error, filaInicial,columnaInicial);
		tablaErrores.add(temporal);
	}
}
