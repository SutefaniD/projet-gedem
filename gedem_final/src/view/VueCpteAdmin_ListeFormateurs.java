package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueCpteAdmin_ListeFormateurs extends JPanel {
	private App app;
	private JPanel p1; // panel haut page
	private JPanel p2; // panel centre page
	//private JPanel p3; // panel bas page
	
	private JLabel label;
	private VueListeFormateurs vlf;

	/**
	 * CONSTRUCTEUR
	 * @param appli
	 */
	public VueCpteAdmin_ListeFormateurs (App appli) {
		this.app = appli;
					
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
		this.label.setText("Liste des formateurs");
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
			this.vlf = new VueListeFormateurs();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.p2.add(vlf);
		this.add(p2);
		
		
		this.setLayout(new BorderLayout());
		this.add(p1, BorderLayout.NORTH);
		this.add(p2, BorderLayout.CENTER);
		//this.add(p3, BorderLayout.SOUTH);
		
		//this.setBackground(Color.red);
		
	}

}
