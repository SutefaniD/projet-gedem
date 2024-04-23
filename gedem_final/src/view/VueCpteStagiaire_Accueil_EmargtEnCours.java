package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

// Page d'accueil du compte Stagiaire (login successful)
// on arrive sur page émargement du jour
public class VueCpteStagiaire_Accueil_EmargtEnCours extends JMenuBar {
	
	private JTextField texte;
	private App appli;
	
	private JPanel p1; // panel haut page
	private JPanel p2; // panel centre page
	private JPanel p3; // panel bas page
	
	private JLabel label;

	
	/**
	 * Constructeur
	 */
	public VueCpteStagiaire_Accueil_EmargtEnCours(App appli) {
		
		// Barre de menu dans la frame
		//appli.setJMenuBar(appli.getJMenuBar());
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
			//TODO: Emargement
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//this.p2.add(vls);
		this.add(p2);
		
		
		this.setLayout(new BorderLayout());
		this.add(p1, BorderLayout.NORTH);
		this.add(p2, BorderLayout.CENTER);
		//this.add(p3, BorderLayout.SOUTH);
		
		//this.setBackground(Color.red);
		
/*
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setTitle("Demo menu");
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());
*/		
	
	}

	

}
