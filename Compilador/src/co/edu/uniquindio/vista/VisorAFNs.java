package co.edu.uniquindio.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

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
/**
 * @author Jorge Hernan Arcila Alzate
 * @author Dival Mauricio Hoyos Castro
 * @author Julian David Serna Echeverri
 * @version 1.0 Mayo-2013 
 * Esta clase es la que muestra los AFN del AnalizadorLexico
 */
@SuppressWarnings("serial")
public class VisorAFNs extends javax.swing.JFrame implements ActionListener{

	private File[] ficheros;
	private String[] nombres;
	@SuppressWarnings("rawtypes")
	private JComboBox jComboBoxImagenes;
	private JLabel jLabel1;
	private JLabel imagen;

	public VisorAFNs() {
		super();
		listar();
		initGUI();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			getContentPane().setBackground(new java.awt.Color(255,255,255));
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Seleccione la imagen a mostrar: ");
				jLabel1.setBounds(12, 12, 196, 16);
			}
			{
				ComboBoxModel jComboBoxImagenesModel = 
						new DefaultComboBoxModel(nombres);
				jComboBoxImagenes = new JComboBox();
				getContentPane().add(jComboBoxImagenes);
				jComboBoxImagenes.setModel(jComboBoxImagenesModel);
				jComboBoxImagenes.setBounds(12, 36, 170, 23);
				jComboBoxImagenes.addActionListener(this);
			}
			{
				imagen = new JLabel();
				getContentPane().add(imagen);
				imagen.setBounds(12, 71, 398, 198);
			}
			pack();
			this.setSize(438, 320);
		} catch (Exception e) {
			//add your error handling code here
			e.printStackTrace();
		}
	}

	private void listar()
	{
		String letra = "./src/co/edu/uniquindio/analizadorLexico/imagenes/";
		
		File Dir = new File(letra);
		ficheros = Dir.listFiles();
		nombres = new String[ficheros.length];
		
		for (int x=0;x<ficheros.length;x++){
			nombres[x] = ficheros[x].getName().replaceAll(".png", "");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		int act = jComboBoxImagenes.getSelectedIndex();
		try 
		{
			ImageIcon image = new ImageIcon( ImageIO.read( ficheros[act] ) );
			imagen.setIcon(image);
			
			imagen.setBounds(12, 71, image.getIconWidth(), image.getIconHeight());
			this.setSize(image.getIconWidth()+24, image.getIconHeight()+95);
			this.setTitle(nombres[act]);
			
			System.out.println(getSize().getHeight()+" "+getSize().getWidth());
			
			repaint();
		} 
		catch (Exception e1) 
		{
			e1.printStackTrace();
		}
	}
}
