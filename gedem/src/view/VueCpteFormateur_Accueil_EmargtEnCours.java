package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VueCpteFormateur_Accueil_EmargtEnCours extends JPanel {
	
	private JTextField texte;
	private App appli;
	
	private JPanel p1; // panel haut page
	private JPanel p2; // panel centre page
	private JPanel p3; // panel bas page
	
	private JLabel label;
	
	
	public VueCpteFormateur_Accueil_EmargtEnCours (App appli) {		
		this.appli = appli;
			
	// --Disposition de la JFrame -------------------------			
				
		this.p1 = new JPanel(new GridBagLayout());
		this.p1.setBackground(Color.pink);
		GridBagConstraints c = new GridBagConstraints();
		// spécifier le padding externe de tous les composants
		c.insets = new Insets(1,1,1,1);
		
		c.gridx = 0; // colonne 0
		c.gridy = 0; // ligne 0
		c.ipadx = 20; //largeur composants
		c.ipady = 40; // hauteur composants
		this.label = new JLabel();
		this.label.setText("Emargement à faire");
		this.label.setBackground(Color.pink);
		this.p1.add(this.label, c);
		
		c.gridx = 0; // colonne 0
		c.gridy = 1; // ligne 1
		c.ipadx = 20; //largeur composants
		c.ipady = 40; // hauteur composants
		JLabel l2 = new JLabel("Essai blablabla");
		this.p1.add(l2, c);
			
// ---------------------------------------------
		this.p2 = new JPanel();
		try {
			//TODO
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.add(p2);
		
		
		this.setLayout(new BorderLayout());
		this.add(p1, BorderLayout.NORTH);
		this.add(p2, BorderLayout.CENTER);
		//this.add(p3, BorderLayout.SOUTH);
		
		//this.setBackground(Color.red);

	
	}
}
