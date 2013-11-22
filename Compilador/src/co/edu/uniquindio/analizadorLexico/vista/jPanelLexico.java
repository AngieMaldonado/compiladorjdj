package co.edu.uniquindio.analizadorLexico.vista;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import co.edu.uniquindio.analizadorLexico.logic.AnalizadorLexico;
import co.edu.uniquindio.analizadorLexico.logic.Lenguaje;


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
public class jPanelLexico extends javax.swing.JPanel implements ActionListener{
	
	private JPanel jPanelTextoIngresado;
	private JTextArea jTextAreaTextoIngresado;
	private JLabel jLabelEtiquetaIngresar;
	private JButton jButtonAnalizar;
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
	
	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new jPanelLexico());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public jPanelLexico() {
		super();
		analizador = new AnalizadorLexico();
		visor = new VisorAFNs();
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				jPanelTextoIngresado = new JPanel();
				this.add(jPanelTextoIngresado);
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
				this.add(jSeparator1);
				jSeparator1.setBounds(15, 101, 234, 8);
			}
			{
				jLabelEtiquetaIngresar = new JLabel();
				this.add(jLabelEtiquetaIngresar);
				jLabelEtiquetaIngresar.setText("Cadena de caracteres a ser analizada :");
				jLabelEtiquetaIngresar.setBounds(12, 78, 228, 15);
			}
			{
				jButtonAnalizar = new JButton();
				this.add(jButtonAnalizar);
				jButtonAnalizar.setText("Analizar");
				jButtonAnalizar.setBounds(71, 359, 94, 35);
				jButtonAnalizar.addActionListener(this);
			}
			{
				jScrollPanelMensajeAnalizado = new JScrollPane();
				this.add(jScrollPanelMensajeAnalizado);
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
				this.add(jScrollPaneErrores);
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
				this.add(jSeparator2);
				jSeparator2.setBounds(290, 33, 452, 7);
			}
			{
				jLabelMensajeAnalizado = new JLabel();
				this.add(jLabelMensajeAnalizado);
				jLabelMensajeAnalizado.setText("Analisis de codigo:");
				jLabelMensajeAnalizado.setBounds(291, 12, 204, 16);
			}
			{
				jButtonAFD = new JButton();
				this.add(jButtonAFD);
				jButtonAFD.setText("AFD del lenguaje AJC");
				jButtonAFD.setBounds(13, 15, 163, 34);
				jButtonAFD.addActionListener(this);
			}
			{
				jLabel1 = new JLabel();
				this.add(jLabel1);
				jLabel1.setText("Errores:");
				jLabel1.setBounds(293, 265, 56, 16);
			}
			setPreferredSize(new Dimension(770, 471));
			this.setLayout(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// cuando se presiona el  boton analizar para obtener el texto ingresado y ser mandado para ser analizado 
		if(jButtonAnalizar==e.getSource())
		{
			String codigoFuente=jTextAreaTextoIngresado.getText();
			char a = 0;
			analizarCodigo(codigoFuente+a);
		}
		if(jButtonAFD == e.getSource())
		{
			visor.setVisible(true);
		}
	}

	/**
	 * Este metodo permite obtener el valor del atributo jPanelTextoIngresado
	 * @return el jPanelTextoIngresado
	 */
	public JPanel getjPanelTextoIngresado() {
		return jPanelTextoIngresado;
	}

	/**
	 * Este metodo permite obtener el valor del atributo jTextAreaTextoIngresado
	 * @return el jTextAreaTextoIngresado
	 */
	public JTextArea getjTextAreaTextoIngresado() {
		return jTextAreaTextoIngresado;
	}

	/**
	 * Este metodo permite obtener el valor del atributo jLabelEtiquetaIngresar
	 * @return el jLabelEtiquetaIngresar
	 */
	public JLabel getjLabelEtiquetaIngresar() {
		return jLabelEtiquetaIngresar;
	}

	/**
	 * Este metodo permite obtener el valor del atributo jButtonAnalizar
	 * @return el jButtonAnalizar
	 */
	public JButton getjButtonAnalizar() {
		return jButtonAnalizar;
	}

	/**
	 * Este metodo permite obtener el valor del atributo jLabel1
	 * @return el jLabel1
	 */
	public JLabel getjLabel1() {
		return jLabel1;
	}

	/**
	 * Este metodo permite obtener el valor del atributo jLabelMensajeAnalizado
	 * @return el jLabelMensajeAnalizado
	 */
	public JLabel getjLabelMensajeAnalizado() {
		return jLabelMensajeAnalizado;
	}

	/**
	 * Este metodo permite obtener el valor del atributo jButtonAFD
	 * @return el jButtonAFD
	 */
	public JButton getjButtonAFD() {
		return jButtonAFD;
	}

	/**
	 * Este metodo permite obtener el valor del atributo jTableAnalizado
	 * @return el jTableAnalizado
	 */
	public JTable getjTableAnalizado() {
		return jTableAnalizado;
	}

	/**
	 * Este metodo permite obtener el valor del atributo jTableErrores
	 * @return el jTableErrores
	 */
	public JTable getjTableErrores() {
		return jTableErrores;
	}

	/**
	 * Este metodo permite obtener el valor del atributo analizador
	 * @return el analizador
	 */
	public AnalizadorLexico getAnalizador() {
		return analizador;
	}

	/**
	 * Este metodo permite obtener el valor del atributo visor
	 * @return el visor
	 */
	public VisorAFNs getVisor() {
		return visor;
	}

	
}
