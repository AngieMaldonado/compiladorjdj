package co.edu.uniquindio.vista;

import co.edu.uniquindio.analizadorLexico.logic.Lenguaje;
import co.edu.uniquindio.analizadorSintactico.logic.Operacion;

public class main {

	public static void main(String[] args) 
	{
		Operacion op = new Operacion();
		//String token, String tipoToken, int fila, int columna
		op.setOperador1(new Lenguaje("a","letra", 1, 2));
		op.setOperacion(new Lenguaje("+","suma", 1, 3));
		
		Operacion op2 = new Operacion();
		op2.setOperador1(new Lenguaje("b","letra", 1, 4));
		op.setOperador2(op2);
		op2.setOperacion(new Lenguaje("*","multiplicacion", 1, 5));
		
		Operacion op3 = new Operacion();
		op3.setOperador1(new Lenguaje("3","letra", 1, 4));
		op2.setOperador2(op3);
		
		System.out.println(op.getJavaCode());
	}

}
