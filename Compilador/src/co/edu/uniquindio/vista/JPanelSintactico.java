package co.edu.uniquindio.vista;

import java.awt.Dimension;

import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.tree.DefaultMutableTreeNode;


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
public class JPanelSintactico extends javax.swing.JPanel {

	private JTree arbolGrafico;
	
	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new JPanelSintactico());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public JPanelSintactico() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setPreferredSize(new Dimension(400, 300));
			this.setLayout(null);
			{
				DefaultMutableTreeNode raiz=new 
						DefaultMutableTreeNode("Colores"); 
						 
						 raiz.add(new DefaultMutableTreeNode("azul")); 
						 raiz.add(new DefaultMutableTreeNode("rojo")); 
						 raiz.add(new DefaultMutableTreeNode("verde")); 
						 
						 DefaultMutableTreeNode subCarpeta=new 
						 DefaultMutableTreeNode("Claros"); 
						 
						 subCarpeta.add(new DefaultMutableTreeNode("blanco")); 
						 subCarpeta.add(new DefaultMutableTreeNode("beige")); 
						 
						 raiz.add(subCarpeta); 
						 
						 //creo el arbol con todos los nodos (incluidos en el objeto raiz) 
						 arbolGrafico=new JTree(raiz); 
						 
						 //agrego el árbol a la ventana 
						 this.add(arbolGrafico); 
						 //posiciona 
						 arbolGrafico.setBounds(10, 10, 200, 400); 

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
