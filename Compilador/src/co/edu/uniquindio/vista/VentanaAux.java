package co.edu.uniquindio.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import co.edu.uniquindio.analizadorLexico.logic.AnalizadorLexico;
import co.edu.uniquindio.analizadorLexico.logic.Lenguaje;
import co.edu.uniquindio.analizadorSintactico.logic.AnalizadorSintactico;
import co.edu.uniquindio.analizadorSintactico.logic.ErrorSintactico;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
@SuppressWarnings("serial")
public class VentanaAux extends javax.swing.JFrame implements ActionListener {

	private JMenuItem jMenuSalir;
	private JMenuItem jMenuNuevo;
	private JTabbedPane jTabbedPaneContenedor;
	private JMenuItem jMenuGuardar;
	private JMenuItem jMenuAbrir;
	private JMenu jMenu1;
	private JMenuBar jMenu;

	private JPanel lexico;
	
	private JPanel jPanelTextoIngresado;
	private JTextArea jTextAreaTextoIngresado;
	private JLabel jLabelEtiquetaIngresar;
	private JButton jButtonAnalizar;
	private JScrollPane jScrollPanelErroresSintacticos;
	private JScrollPane jScrollPaneArbol;
	@SuppressWarnings("unused")
	private JScrollPane jScrollPane2;
	private JLabel jLabelErroresSintacticos;
	private JTable jTableErroresSintacticos;
	private JScrollPane jScrollPane1;
	private JLabel jLabel1;
	private JScrollPane jScrollPaneErrores;
	private JLabel jLabelMensajeAnalizado;
	private JButton jButtonAFD;
	private JTable jTableAnalizado;
	private JTable jTableErrores;
	private JSeparator jSeparator2;
	private JScrollPane jScrollPanelMensajeAnalizado;
	private JSeparator jSeparator1;
	private AnalizadorLexico analizador;
	private VisorAFNs visor;

	private JPanel sintactico;
	
	private JTree arbolGrafico;
	private AnalizadorSintactico analizadorSintactico;
	
	private ArrayList<Lenguaje> simbolos;

	
	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VentanaAux inst = new VentanaAux();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public VentanaAux() {
		super();
		analizador = new AnalizadorLexico();
		visor = new VisorAFNs();

		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jTabbedPaneContenedor = new JTabbedPane();
				getContentPane().add(jTabbedPaneContenedor);
				jTabbedPaneContenedor.setBounds(3, 27, 750, 499);
				{
					lexico = new JPanel();
					jTabbedPaneContenedor.addTab("Analizador Léxico", null, lexico, null);
					lexico.setPreferredSize(new java.awt.Dimension(744, 420));
					lexico.setLayout(null);
					{
						jPanelTextoIngresado = new JPanel();
						lexico.add(jPanelTextoIngresado);
						jPanelTextoIngresado.setBounds(24, 107, 225, 229);
						jPanelTextoIngresado.setLayout(null);
						{
							jScrollPane1 = new JScrollPane();
							jPanelTextoIngresado.add(jScrollPane1);
							jScrollPane1.setBounds(3, 17, 222, 212);
							{
								jTextAreaTextoIngresado = new JTextArea();
								jScrollPane1.setViewportView(jTextAreaTextoIngresado);
								jTextAreaTextoIngresado.setBounds(0, 12, 218, 226);
							}
						}
					}
					{
						jSeparator1 = new JSeparator();
						lexico.add(jSeparator1);
						jSeparator1.setBounds(15, 101, 234, 8);
					}
					{
						jLabelEtiquetaIngresar = new JLabel();
						lexico.add(jLabelEtiquetaIngresar);
						jLabelEtiquetaIngresar.setText("Cadena de caracteres a ser analizada :");
						jLabelEtiquetaIngresar.setBounds(12, 78, 228, 15);
					}
					{
						jButtonAnalizar = new JButton();
						lexico.add(jButtonAnalizar);
						jButtonAnalizar.setText("Analizar");
						jButtonAnalizar.setBounds(71, 359, 94, 35);
						jButtonAnalizar.addActionListener(this);
					}
					{
						jScrollPanelMensajeAnalizado = new JScrollPane();
						lexico.add(jScrollPanelMensajeAnalizado);
						jScrollPanelMensajeAnalizado.setBounds(293, 46, 446, 203);
						{
							TableModel jTableAnalizadoModel = 
									new DefaultTableModel(
											new String[][] { {"",""}, {"",""},{"",""},{"",""} },
											new String[] {"Simbolo", "Significado" ,"fila","columna"});
							jTableAnalizado = new JTable();
							jScrollPanelMensajeAnalizado.setViewportView(jTableAnalizado);
							jTableAnalizado.setBounds(248, 107, 54, 172);
							jTableAnalizado.setModel(jTableAnalizadoModel);
						}
					}
					{
						jScrollPaneErrores = new JScrollPane();
						lexico.add(jScrollPaneErrores);
						jScrollPaneErrores.setBounds(293, 287, 446, 107);
						{
							TableModel jTableErroresModel = 
									new DefaultTableModel(
											new String[][] { {"",""}, {"",""},{"",""},{"",""} },
											new String[] {"Simbolo", "Significado" ,"fila","columna"});
							jTableErrores = new JTable();
							jScrollPaneErrores.setViewportView(jTableErrores);
							jTableErrores.setModel(jTableErroresModel);
						}
					}
					{
						jSeparator2 = new JSeparator();
						lexico.add(jSeparator2);
						jSeparator2.setBounds(290, 33, 452, 7);
					}
					{
						jLabelMensajeAnalizado = new JLabel();
						lexico.add(jLabelMensajeAnalizado);
						jLabelMensajeAnalizado.setText("Analisis de codigo:");
						jLabelMensajeAnalizado.setBounds(291, 12, 204, 16);
					}
					{
						jButtonAFD = new JButton();
						lexico.add(jButtonAFD);
						jButtonAFD.setText("AFD del lenguaje AJC");
						jButtonAFD.setBounds(13, 15, 163, 34);
						jButtonAFD.addActionListener(this);
					}
					{
						jLabel1 = new JLabel();
						lexico.add(jLabel1);
						jLabel1.setText("Errores:");
						jLabel1.setBounds(293, 265, 56, 16);
					}
					
				}
				{
					sintactico = new JPanel();
					jTabbedPaneContenedor.addTab("Analizador Sintáctico", null, sintactico, null);
					sintactico.setLayout(null);
					{
						jLabelErroresSintacticos = new JLabel();
						sintactico.add(jLabelErroresSintacticos);
						jLabelErroresSintacticos.setText("Errores Sintácticos:");
						jLabelErroresSintacticos.setBounds(272, 23, 158, 16);
					}
					{
						jScrollPaneArbol = new JScrollPane();
						sintactico.add(jScrollPaneArbol);
						jScrollPaneArbol.setBounds(10, 10, 200, 398);
						{
							DefaultMutableTreeNode raiz=new 
									DefaultMutableTreeNode(); 
							//								 
							//								 raiz.add(new DefaultMutableTreeNode("azul")); 
							//								 raiz.add(new DefaultMutableTreeNode("rojo")); 
							//								 raiz.add(new DefaultMutableTreeNode("verde")); 
							//								 
							//								 DefaultMutableTreeNode subCarpeta=new 
							//								 DefaultMutableTreeNode("Claros"); 
							//								 
							//								 subCarpeta.add(new DefaultMutableTreeNode("blanco")); 
							//								 subCarpeta.add(new DefaultMutableTreeNode("beige")); 
							//								 
							//								 raiz.add(subCarpeta); 
							
							//creo el arbol con todos los nodos (incluidos en el objeto raiz) 
							arbolGrafico=new JTree(raiz); 
							jScrollPaneArbol.setViewportView(arbolGrafico);

							//agrego el árbol a la ventana 
							//posiciona 
							arbolGrafico.setBounds(10, 10, 200, 400); 
							
						}
					}
					{
						jScrollPanelErroresSintacticos = new JScrollPane();
						sintactico.add(jScrollPanelErroresSintacticos);
						jScrollPanelErroresSintacticos.setBounds(272, 49, 449, 166);
						{
							TableModel jTableErroresSintacticosModel = 
									new DefaultTableModel(
											new String[][] { { "", "" }, { "", "" } },
											new String[] { "Error", "Fila", "Columna" });
							jTableErroresSintacticos = new JTable();
							jScrollPanelErroresSintacticos.setViewportView(jTableErroresSintacticos);
							jTableErroresSintacticos.setModel(jTableErroresSintacticosModel);
							jTableErroresSintacticos.setBounds(272, 49, 454, 147);
						}
					}

				}
			}
			{
				jMenu = new JMenuBar();
				setJMenuBar(jMenu);
				{
					jMenu1 = new JMenu();
					jMenu.add(jMenu1);
					jMenu1.setText("Archivo");
					jMenu1.addActionListener(this);
					{
						jMenuAbrir = new JMenuItem();
						jMenu1.add(jMenuAbrir);
						jMenuAbrir.setText("Abrir");
						jMenuAbrir.addActionListener(this);
					}
					{
						jMenuGuardar = new JMenuItem();
						jMenu1.add(jMenuGuardar);
						jMenuGuardar.setText("Guardar");
						jMenuGuardar.addActionListener(this);
					}
					{
						jMenuNuevo = new JMenuItem();
						jMenu1.add(jMenuNuevo);
						jMenuNuevo.setText("Nuevo");
						jMenuNuevo.addActionListener(this);
					}
					{
						jMenuSalir = new JMenuItem();
						jMenu1.add(jMenuSalir);
						jMenuSalir.setText("Salir");
						jMenuSalir.addActionListener(this);
					}
				}
			}
			
			pack();
			this.setSize(770, 597);
		} catch (Exception e) {
			//add your error handling code here
			e.printStackTrace();
		}
	}

	
	

	@SuppressWarnings({ "unused", "resource" })
	private String LeerArchivo(File f)
	{
		StringBuffer texto=new StringBuffer();
		try {
			int c;
			FileReader entrada=new FileReader(f);
			while((c=entrada.read())!=-1){
				texto.append((char)c);
			}
		}catch (IOException ex) {}
		return texto.toString();
	}
	
	public void analizarCodigo(String codigoFuente)
	{
		//pregunta si los campos de texto estan vacios, de ser asi solicita por medio de un mensaje ke los datos sean ingresados
		if(codigoFuente.equals(""))
			JOptionPane.showMessageDialog( this, "Debe ingresar una codigo fuente", "Error", JOptionPane.ERROR_MESSAGE );

		//de lo contrario
		else
		{
			//se envia el codigo fuente para ser analizado
			analizador.analizadorLenguaje(codigoFuente);
			//
			mostrarSignificado();
			mostrarErrores();
		}
	}

	public void mostrarErrores(){
		//se crea e inicializa un arraylist del tipo lenguaje AJC donde se cargan los datos de la tabla de lenguaje
		ArrayList<Lenguaje> miTablaDeErrores;
		miTablaDeErrores = analizador.getTablaErrores();
		// se crea una matriz donde con un ciclo se cargaran los datos a mostrar en pantalla
		String [][]matriz = new String[miTablaDeErrores.size()][4];
		int i=0;					
		while(i<miTablaDeErrores.size())
		{
			matriz[i][0]=miTablaDeErrores.get(i).getToken();
			matriz[i][1]=miTablaDeErrores.get(i).getTipoToken();
			matriz[i][2]=""+miTablaDeErrores.get(i).getFila();
			matriz[i][3]=""+miTablaDeErrores.get(i).getColumna();
			i++;
		}			
		DefaultTableModel model =	new DefaultTableModel(matriz,new String[]{"Simbolo", "Significado", "Fila", "Columna" });			
		jTableErrores.setModel(model);		
	}

	public void mostrarSignificado()
	{
		//se crea e inicializa un arraylist del tipo lenguaje AJC donde se cargan los datos de la tabla de lenguaje
		ArrayList<Lenguaje> miTablaDeSimbolos;
		miTablaDeSimbolos = analizador.getTablaLenguaje();
		// se crea una matriz donde con un ciclo se cargaran los datos a mostrar en pantalla
		String [][]matriz = new String[miTablaDeSimbolos.size()][4];
		int i=0;					
		while(i<miTablaDeSimbolos.size())
		{
			matriz[i][0]=miTablaDeSimbolos.get(i).getToken();
			matriz[i][1]=miTablaDeSimbolos.get(i).getTipoToken();
			matriz[i][2]=""+miTablaDeSimbolos.get(i).getFila();
			matriz[i][3]=""+miTablaDeSimbolos.get(i).getColumna();
			i++;
		}			
		DefaultTableModel model =	new DefaultTableModel(matriz,new String[]{"Simbolo", "Significado", "Fila", "Columna" });			
		jTableAnalizado.setModel(model);			
		
		setSimbolos(miTablaDeSimbolos);
	}
	
	public void mostrarErroresSintactico()
	{
		ArrayList<ErrorSintactico> tablaErrores;
		tablaErrores = analizadorSintactico.getListaErroresSintacticos();
		
		String [][] matriz = new String[tablaErrores.size()][3];
		int i=0;
		while (i<tablaErrores.size()) 
		{
			matriz[i][0]=tablaErrores.get(i).getMsgError();
			matriz[i][1]=""+tablaErrores.get(i).getFila();
			matriz[i][2]=""+tablaErrores.get(i).getColumna();
			i++;
		}
		DefaultTableModel model = new DefaultTableModel(matriz,new String[]{"Error", "Fila", "Columna" });
		jTableErroresSintacticos.setModel(model);
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if(jMenuAbrir == e.getSource())
		{
			Abrir();
		}
		if(jMenuGuardar == e.getSource())
		{
			Guardar();
		}
		if(jMenuNuevo == e.getSource())
		{
			jTextAreaTextoIngresado.setText(null);
			DefaultTableModel modelo = new DefaultTableModel(null,new String[]{"Simbolo", "Significado", "Fila", "Columna" });
			jTableAnalizado.setModel(modelo);
		}
		if(jMenuSalir == e.getSource())
		{
			System.exit(0);
		}
		if(jButtonAnalizar==e.getSource())
		{
			String codigoFuente=jTextAreaTextoIngresado.getText();
			char a = 0;
			analizarCodigo(codigoFuente+a);
			analizadorSintactico = new AnalizadorSintactico(simbolos);
			JTree aux= new JTree(analizadorSintactico.getArbolSintactico());
			arbolGrafico.setModel(aux.getModel());
			mostrarErroresSintactico();
			repaint();
			validate();
			
		}
		if(jButtonAFD == e.getSource())
		{
			visor.setVisible(true);
		}

	}

	/**
	 * este metodo me permite guardar el codigo fuente que tengo en el area de texto de codigo a analizar
	 */
	@SuppressWarnings("unused")
	public void Guardar () //Guardar el TextArea
	{
		try
		{
			String nombre = "";
			JFileChooser archivo=new JFileChooser(System.getProperty("user.dir"));
			archivo.showSaveDialog(this);
			File guardar =archivo.getSelectedFile();
			if(guardar != null)
			{
				nombre=archivo.getSelectedFile().getName();
				FileWriter GUARDADO=new FileWriter(guardar);
				GUARDADO.write(jTextAreaTextoIngresado.getText());
				GUARDADO.close();
			}
		}
		catch(IOException exp)
		{
			System.out.println(exp);
		}
	}

	/**
	 * este metodo me permite abrir archivos los cuales seran cargados en el area de texto a analizar
	 */
	@SuppressWarnings("unused")
	public void Abrir ()
	{
		String Text="", nombre ="";
		try
		{
			JFileChooser fc=new JFileChooser(System.getProperty("user.dir"));
			fc.showOpenDialog(this);
			File Abrir=fc.getSelectedFile(); //Devuelve el File que vamos a leerName

			if(Abrir!=null)
			{
				nombre=fc.getSelectedFile().getName();
			}

			if(Abrir!=null)
			{
				jTextAreaTextoIngresado.setText("");  
				FileReader Fichero=new FileReader(Abrir);
				BufferedReader leer=new BufferedReader(Fichero);
				while((Text=leer.readLine())!=null)
				{
					jTextAreaTextoIngresado.append(Text+ "\n"); //append Concatena la linea leida
				}

				leer.close();
			}

		}
		catch(IOException exp)
		{
			System.out.println(exp);
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.Window#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
		System.exit(0);
	}

	/**
	 * Este metodo permite obtener el valor del atributo simbolos
	 * @return el simbolos
	 */
	public ArrayList<Lenguaje> getSimbolos() {
		return simbolos;
	}

	/**
	 * Este metodo permite asignar un valor al atributo simbolos
	 * @param simbolos se asigna a simbolos
	 */
	public void setSimbolos(ArrayList<Lenguaje> simbolos) {
		this.simbolos = simbolos;
	}
}