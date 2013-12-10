package co.edu.uniquindio.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import co.edu.uniquindio.analizadorLexico.logic.AnalizadorLexico;


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

	private AnalizadorLexico analizador;
	private jPanelLexico lexico;
	private JPanelSintactico sintactico;


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
					lexico = new jPanelLexico();
					jTabbedPaneContenedor.addTab("Analizador Léxico", null, lexico, null);
					lexico.setPreferredSize(new java.awt.Dimension(744, 420));
				}
				{
					sintactico = new JPanelSintactico();
					jTabbedPaneContenedor.addTab("Analizador Sintáctico", null, sintactico, null);
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
			lexico.getjTextAreaTextoIngresado().setText(null);
			DefaultTableModel modelo = new DefaultTableModel(null,new String[]{"Simbolo", "Significado", "Fila", "Columna" });
			lexico.getjTableAnalizado().setModel(modelo);
		}
		if(jMenuSalir == e.getSource())
		{
			System.exit(0);
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
				GUARDADO.write(lexico.getjTextAreaTextoIngresado().getText());
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
				lexico.getjTextAreaTextoIngresado().setText("");  
				FileReader Fichero=new FileReader(Abrir);
				BufferedReader leer=new BufferedReader(Fichero);
				while((Text=leer.readLine())!=null)
				{
					lexico.getjTextAreaTextoIngresado().append(Text+ "\n"); //append Concatena la linea leida
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
}