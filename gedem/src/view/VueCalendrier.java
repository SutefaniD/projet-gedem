package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class VueCalendrier extends JPanel {
	
// Page divisée en 3 blocs horizontaux avec un GridBagLayout 

	JPanel pn1; // panel 1er bloc horizontal
	JLabel titre; // titre pn1
	JPanel pn2; // panel 2eme bloc horizontal avec affichage du calendrier
	JPanel pn3; // panel 3eme bloc horizontal
	JLabel date;
	

	
	public VueCalendrier() {
		
		
//------Panel 1ere ligne --------------------------------------		
		pn1 = new JPanel(new GridLayout(2, 1));
		pn1.setBackground(Color.yellow);
		
		JPanel t = new JPanel();
		this.titre = new JLabel("Bonjour"); //titre
		t.setBackground(Color.green);
		t.add(titre, BorderLayout.NORTH);
				
		JPanel p = new JPanel();
		p.setBackground(Color.red);		
		date = new JLabel();
		date.setText(DateFormat.getDateInstance().format(new Date()));
		p.add(date);
		//Date aujourdhui = new Date();
		//System.out.println(aujourdhui);
		//p.add(new JLabel("date ici"), BorderLayout.SOUTH);
		this.pn1.add(t);
		this.pn1.add(p);
		
// -----Panel 2 eme Ligne ---------------------------------------	

/*
// ----- Option 1 : Construction structure table ------------------
		// En-têtes du JTable
		String[] column = {"N° semaine", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
		
		// Lignes du JTable
		String[][] data = {
				{"01", "maths", "info", "français", "histoire", "physique", "", ""},
				{"02", "réseaux", "anglais", "chimie", "info", "info", "", ""},
				{"03", "maths", "info", "réseaux", "info", "CEJM", "", ""},
				{"04", "algo", "info", "info", "info", "info", "", ""},
				{"05", "info", "info", "info", "maths", "info", "", ""},
		};
		
		// Créer le JTable
		JTable table = new JTable(data, column);
		JScrollPane scroll = new JScrollPane(table);
		
		pn2 = new JPanel();
		this.pn2.add(scroll);
		//System.out.println(scroll);
		
*/		
	
//----- Option 2: Disposition avec GridLayout -------------------------------------------------------
/*		pn2 = new JPanel();
		// Colonnes header
		JLabel nsem = new JLabel("N° semaine");
		this.pn2.add(nsem);
		
		// Ligne
		JLabel nb1 = new JLabel("sem 1");
		this.pn2.add(nb1);
		
		JLabel nb2 = new JLabel("sem 2");
		this.pn2.add(nb2);
		
		JLabel nb3 = new JLabel("sem 3");
		this.pn2.add(nb3);
		
		JLabel nb4 = new JLabel("sem 4");
		this.pn2.add(nb4);
		
		JLabel nb5 = new JLabel("sem 5");
		this.pn2.add(nb5);
		
		JLabel nb6 = new JLabel("sem 6");
		this.pn2.add(nb6);
		
		// Colonne header Lundi
		JLabel lun = new JLabel("Lundi");
		this.pn2.add(lun);
		// Lignes lundi
		JPanel j1 = new JPanel();
		JLabel j1b = new JLabel("01");
		j1.add(j1b);		
		this.pn2.add(j1);
		
		// Colonne header Mardi
		JLabel ma = new JLabel("Mardi");
		this.pn2.add(ma);
		// Lignes mardi
		JPanel j2 = new JPanel();
		JLabel j2b = new JLabel("02");
		j2.add(j2b);		
		this.pn2.add(j2);
		
		// Colonne header Mercredi
		JLabel mer = new JLabel("Mercredi");
		this.pn2.add(mer);
		// Lignes mercredi
		JPanel j3 = new JPanel();
		JLabel j3b = new JLabel("03");
		j3.add(j3b);		
		this.pn2.add(j3);
		
		// Colonne header Jeudi
		JLabel jeu = new JLabel("Jeudi");
		this.pn2.add(jeu);
		// Lignes jeudi
		JPanel j4 = new JPanel();
		JLabel j4b = new JLabel("04");
		j1.add(j4b);		
		this.pn2.add(j4);
		
		// Colonne header Vendredi
		JLabel ven = new JLabel("Vendredi");
		this.pn2.add(ven);
		// Lignes vendredi
		JPanel j5 = new JPanel();
		JLabel j5b = new JLabel("05");
		j1.add(j5b);		
		this.pn2.add(j5);
				
		pn2.setLayout(new GridLayout(0, 7));
		this.pn2.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.red));
		this.pn2.setBackground(Color.yellow);
*/
//----- Commun options 1 & 2 ----------------------------------------------
//----- Panel 3eme ligne --------------------------------------------------		
/*		pn3 = new JPanel();
		JButton btn1 = new JButton("Valider");
		this.pn3.add(btn1);
*/
// --- Ajouter les panels au JPanel principal
/*
		pn1.setSize(new Dimension(10,10));
		this.add(pn1);
		pn2.setSize(new Dimension(500, 400));
		this.add(pn2);
		pn1.setSize(new Dimension(10,10));
		this.add(pn3);
		
		
		this.setLayout(new GridLayout(3, 1));
		this.setSize(800, 300);
				
		this.setVisible(true);
*/	
//	}
//}
 
// ----FIN OPTION 1 ------------------------------------------------------

		
// ---- Option 2: nouveau GridLayout pour créer tableau -------------------
		this.pn2 = new JPanel(new GridBagLayout());

		
		//JPanel p4 = new JPanel(new GridBagLayout());
		
		// Créer un objet de contraintes
		GridBagConstraints c = new GridBagConstraints();
		
		// Spécifier le padding externe de tous les composants
		c.insets = new Insets(25, 25, 20, 20);
		
		//c.fill = c.BOTH;
		c.weighty = 1;
		
		
		
//----- Colonne 0 ---------------------------------------------------------------		
		c.gridx = 0;
		c.gridy = 0;
		// augmente la largeur des composants de 10 pixels
        c.ipadx = 10; 
        // augmente la hauteur des composants de 50 pixels
        c.ipady = 10;  
        // Ajouter les contraintes
        pn2.add(new JLabel("N° semaine"), c);
        
//----- Ligne 1 -----------------------------------------------------
  		c.gridx = 0;
  		c.gridy = 1;
  		// augmente la largeur des composants de 10 pixels
  	    c.ipadx = 20; 
  	    // augmente la hauteur des composants de 50 pixels
  	    c.ipady = 20;  
  	    // Ajouter les contraintes
  	    pn2.add(new JLabel("sem 1"), c);
//----- Ligne 2 -----------------------------------------------------
  		c.gridx = 0;
  		c.gridy = 2;
  		// augmente la largeur des composants de 10 pixels
  	    c.ipadx = 20; 
  	    // augmente la hauteur des composants de 50 pixels
  	    c.ipady = 20;  
  	    // Ajouter les contraintes
  	    pn2.add(new JLabel("sem 2"), c);
//----- Ligne 3 -----------------------------------------------------
  		c.gridx = 0;
  		c.gridy = 3;
  		// augmente la largeur des composants de 10 pixels
  	    c.ipadx = 20; 
  	    // augmente la hauteur des composants de 50 pixels
  	    c.ipady = 20;  
  	    // Ajouter les contraintes
  	    pn2.add(new JLabel("sem 3"), c);
//----- Ligne 4 -----------------------------------------------------
  		c.gridx = 0;
  		c.gridy = 4;
  		// augmente la largeur des composants de 10 pixels
  	    c.ipadx = 20; 
  	    // augmente la hauteur des composants de 50 pixels
  	    c.ipady = 20;  
  	    // Ajouter les contraintes
  	    pn2.add(new JLabel("sem 4"), c);
//----- Ligne 5 -----------------------------------------------------
  		c.gridx = 0;
  		c.gridy = 5;
  		// augmente la largeur des composants de 10 pixels
  	    c.ipadx = 20; 
  	    // augmente la hauteur des composants de 50 pixels
  	    c.ipady = 20;  
  	    // Ajouter les contraintes
  	    pn2.add(new JLabel("sem 5"), c);
//----- Ligne 6 -----------------------------------------------------
  		c.gridx = 0;
  		c.gridy = 6;
  		// augmente la largeur des composants de 10 pixels
  	    c.ipadx = 20; 
  	    // augmente la hauteur des composants de 50 pixels
  	    c.ipady = 20;  
  	    // Ajouter les contraintes
  	    pn2.add(new JLabel("sem 6"), c);
		
        
//----- Colonne 1: LUNDI -----------------------------------------------------
		c.gridx = 1;
		c.gridy = 0;
		// augmente la largeur des composants de 10 pixels
	     c.ipadx = 20; 
	     // augmente la hauteur des composants de 50 pixels
	     c.ipady = 20;  
	     // Ajouter les contraintes
	     pn2.add(new JLabel("Lundi"), c);
//----- Col1 -Ligne 1 -----------------------------------------------------
  		c.gridx = 1;
  		c.gridy = 1;
  		// augmente la largeur des composants de 10 pixels
  	    c.ipadx = 20; 
  	    // augmente la hauteur des composants de 50 pixels
  	    c.ipady = 20;  
  	    // Ajouter les contraintes 	    
  	    pn2.add(new JPanel().add(new JLabel("")), c);
//----- Col 1-Ligne 2 -----------------------------------------------------
  		c.gridx = 1;
  		c.gridy = 2;
  		// augmente la largeur des composants de 10 pixels
  	    c.ipadx = 20; 
  	    // augmente la hauteur des composants de 50 pixels
  	    c.ipady = 20;  
  	    // Ajouter les contraintes
  	  pn2.add(new JPanel().add(new JLabel("2")), c);
//----- Col 1-Ligne 3 -----------------------------------------------------
  		c.gridx = 1;
  		c.gridy = 3;
  		// augmente la largeur des composants de 10 pixels
  	    c.ipadx = 20; 
  	    // augmente la hauteur des composants de 50 pixels
  	    c.ipady = 20;  
  	    // Ajouter les contraintes
  	  pn2.add(new JPanel().add(new JLabel("9")), c);
//----- Col 1-Ligne 4 -----------------------------------------------------
  		c.gridx = 1;
  		c.gridy = 4;
  		// augmente la largeur des composants de 10 pixels
  	    c.ipadx = 20; 
  	    // augmente la hauteur des composants de 50 pixels
  	    c.ipady = 20;  
  	    // Ajouter les contraintes
  	  pn2.add(new JPanel().add(new JLabel("16")), c);
//----- Col 1-Ligne 5 -----------------------------------------------------
  		c.gridx = 1;
  		c.gridy = 5;
  		// augmente la largeur des composants de 10 pixels
  	    c.ipadx = 20; 
  	    // augmente la hauteur des composants de 50 pixels
  	    c.ipady = 20;  
  	    // Ajouter les contraintes
  	  pn2.add(new JPanel().add(new JLabel("23")), c);
//----- Col 1-Ligne 6 -----------------------------------------------------
  		c.gridx = 1;
  		c.gridy = 6;
  		// augmente la largeur des composants de 10 pixels
  	    c.ipadx = 20; 
  	    // augmente la hauteur des composants de 50 pixels
  	    c.ipady = 20;  
  	    // Ajouter les contraintes
  	  pn2.add(new JPanel().add(new JLabel("30")), c);
			
	     
//----- Colonne 2 : MARDI -----------------------------------------------------
		c.gridx = 2;
		c.gridy = 0;
		// augmente la largeur des composants de 10 pixels
	     c.ipadx = 20; 
	     // augmente la hauteur des composants de 50 pixels
	     c.ipady = 20;  
	     // Ajouter les contraintes
	     pn2.add(new JLabel("Mardi"), c);
//----- Col2 -Ligne 1 -----------------------------------------------------
  		c.gridx = 2;
  		c.gridy = 1;
  		// augmente la largeur des composants de 10 pixels
  	    c.ipadx = 20; 
  	    // augmente la hauteur des composants de 50 pixels
  	    c.ipady = 20;  
  	    // Ajouter les contraintes
  	    pn2.add(new JPanel().add(new JLabel("")), c); // TODO: jour de la semaine
//----- Col 2-Ligne 2 -----------------------------------------------------
  		c.gridx = 2;
  		c.gridy = 2;
  		// augmente la largeur des composants de 10 pixels
  	    c.ipadx = 20; 
  	    // augmente la hauteur des composants de 50 pixels
  	    c.ipady = 20;  
  	    // Ajouter les contraintes
  	    pn2.add(new JPanel().add(new JLabel("03")), c); // TODO: jour du mois
//----- Col 2-Ligne 3 -----------------------------------------------------
  		c.gridx = 2;
  		c.gridy = 3;
  		// augmente la largeur des composants de 10 pixels
  	    c.ipadx = 20; 
  	    // augmente la hauteur des composants de 50 pixels
  	    c.ipady = 20;  
  	    // Ajouter les contraintes
  	    pn2.add(new JPanel().add(new JLabel("10")), c); // TODO: jour du mois
//----- Col 2-Ligne 4 -----------------------------------------------------
  		c.gridx = 2;
  		c.gridy = 4;
  		// augmente la largeur des composants de 10 pixels
  	    c.ipadx = 20; 
  	    // augmente la hauteur des composants de 50 pixels
  	    c.ipady = 20;  
  	    // Ajouter les contraintes
  	    pn2.add(new JPanel().add(new JLabel("17")), c); // TODO: jour du mois
//----- Col 2-Ligne 5 -----------------------------------------------------
  		c.gridx = 2;
  		c.gridy = 5;
  		// augmente la largeur des composants de 10 pixels
  	    c.ipadx = 20; 
  	    // augmente la hauteur des composants de 50 pixels
  	    c.ipady = 20;  
  	    // Ajouter les contraintes
  	    pn2.add(new JPanel().add(new JLabel("24")), c); // TODO: jour du mois
//----- Col 2-Ligne 6 -----------------------------------------------------
  		c.gridx = 2;
  		c.gridy = 6;
  		// augmente la largeur des composants de 10 pixels
  	    c.ipadx = 20; 
  	    // augmente la hauteur des composants de 50 pixels
  	    c.ipady = 20;  
  	    // Ajouter les contraintes
  	    pn2.add(new JPanel().add(new JLabel("31")), c); // TODO: jour du mois
				
//----- Colonne 3 : MERCREDI -----------------------------------------------------
		c.gridx = 3;
		c.gridy = 0;
		// augmente la largeur des composants de 10 pixels
	     c.ipadx = 20; 
	     // augmente la hauteur des composants de 50 pixels
	     c.ipady = 20;  
	     // Ajouter les contraintes
	     pn2.add(new JLabel("Mercredi"), c);
//----- Col3 -Ligne 1 -----------------------------------------------------
  		c.gridx = 3;
  		c.gridy = 1;
  		// augmente la largeur des composants de 10 pixels
  	    c.ipadx = 20; 
  	    // augmente la hauteur des composants de 50 pixels
  	    c.ipady = 20;  
  	    // Ajouter les contraintes
  	    pn2.add(new JPanel().add(new JLabel("")), c); // TODO: jour du mois
//----- Col 3-Ligne 2 -----------------------------------------------------
  		c.gridx = 3;
  		c.gridy = 2;
  		// augmente la largeur des composants de 10 pixels
  	    c.ipadx = 20; 
  	    // augmente la hauteur des composants de 50 pixels
  	    c.ipady = 20;  
  	    // Ajouter les contraintes
  	    pn2.add(new JPanel().add(new JLabel("04")), c); // TODO: jour du mois
//----- Col 3-Ligne 3 -----------------------------------------------------
  		c.gridx = 3;
  		c.gridy = 3;
  		// augmente la largeur des composants de 10 pixels
  	    c.ipadx = 20; 
  	    // augmente la hauteur des composants de 50 pixels
  	    c.ipady = 20;  
  	    // Ajouter les contraintes
  	    pn2.add(new JPanel().add(new JLabel("11")), c); // TODO: jour du mois
//----- Col 3-Ligne 4 -----------------------------------------------------
  		c.gridx = 3;
  		c.gridy = 4;
  		// augmente la largeur des composants de 10 pixels
  	    c.ipadx = 20; 
  	    // augmente la hauteur des composants de 50 pixels
  	    c.ipady = 20;  
  	    // Ajouter les contraintes
  	    pn2.add(new JPanel().add(new JLabel("18")), c); // TODO: jour du mois
//----- Col 3-Ligne 5 -----------------------------------------------------
  		c.gridx = 3;
  		c.gridy = 5;
  		// augmente la largeur des composants de 10 pixels
  	    c.ipadx = 20; 
  	    // augmente la hauteur des composants de 50 pixels
  	    c.ipady = 20;  
  	    // Ajouter les contraintes
  	    pn2.add(new JPanel().add(new JLabel("25")), c); // TODO: jour du mois
//----- Col 3-Ligne 6 -----------------------------------------------------
  		c.gridx = 3;
  		c.gridy = 6;
  		// augmente la largeur des composants de 10 pixels
  	    c.ipadx = 20; 
  	    // augmente la hauteur des composants de 50 pixels
  	    c.ipady = 20;  
  	    // Ajouter les contraintes
  	    pn2.add(new JPanel().add(new JLabel("")), c); // TODO: jour du mois
		     
//----- Colonne 4: JEUDI -----------------------------------------------------
		c.gridx = 4;
		c.gridy = 0;
		// augmente la largeur des composants de 10 pixels
	    c.ipadx = 20; 
	    // augmente la hauteur des composants de 50 pixels
	    c.ipady = 20;  
	    // Ajouter les contraintes
	    pn2.add(new JLabel("Jeudi"), c);
//----- Col4 -Ligne 1 -----------------------------------------------------
  		c.gridx = 4;
  		c.gridy = 1;
  		// augmente la largeur des composants de 10 pixels
  	    c.ipadx = 20; 
  	    // augmente la hauteur des composants de 50 pixels
  	    c.ipady = 20;  
  	    // Ajouter les contraintes
  	    pn2.add(new JPanel().add(new JLabel("")), c); // TODO: jour du mois
//----- Col 4-Ligne 2 -----------------------------------------------------
  		c.gridx = 4;
  		c.gridy = 2;
  		// augmente la largeur des composants de 10 pixels
  	    c.ipadx = 20; 
  	    // augmente la hauteur des composants de 50 pixels
  	    c.ipady = 20;  
  	    // Ajouter les contraintes
  	    pn2.add(new JPanel().add(new JLabel("05")), c); // TODO: jour du mois
//----- Col 4-Ligne 3 -----------------------------------------------------
  		c.gridx = 4;
  		c.gridy = 3;
  		// augmente la largeur des composants de 10 pixels
  	    c.ipadx = 20; 
  	    // augmente la hauteur des composants de 50 pixels
  	    c.ipady = 20;  
  	    // Ajouter les contraintes
  	    pn2.add(new JPanel().add(new JLabel("12")), c); // TODO: jour du mois
//----- Col 4-Ligne 4 -----------------------------------------------------
  		c.gridx = 4;
  		c.gridy = 4;
  		// augmente la largeur des composants de 10 pixels
  	    c.ipadx = 20; 
  	    // augmente la hauteur des composants de 50 pixels
  	    c.ipady = 20;  
  	    // Ajouter les contraintes
  	    pn2.add(new JPanel().add(new JLabel("19")), c); // TODO: jour du mois
//----- Col 4-Ligne 5 -----------------------------------------------------
  		c.gridx = 4;
  		c.gridy = 5;
  		// augmente la largeur des composants de 10 pixels
  	    c.ipadx = 20; 
  	    // augmente la hauteur des composants de 50 pixels
  	    c.ipady = 20;  
  	    // Ajouter les contraintes
  	    pn2.add(new JPanel().add(new JLabel("26")), c); // TODO: jour du mois
//----- Col 4-Ligne 6 -----------------------------------------------------
  		c.gridx = 2;
  		c.gridy = 6;
  		// augmente la largeur des composants de 10 pixels
  	    c.ipadx = 20; 
  	    // augmente la hauteur des composants de 50 pixels
  	    c.ipady = 20;  
  	    // Ajouter les contraintes
  	    pn2.add(new JPanel().add(new JLabel("")), c); // TODO: jour du mois
				     
//----- Colonne 5 : VENDREDI -----------------------------------------------------
		c.gridx = 5;
		c.gridy = 0;
		// augmente la largeur des composants de 10 pixels
	    c.ipadx = 20; 
	    // augmente la hauteur des composants de 50 pixels
	    c.ipady = 20;  
	    // Ajouter les contraintes
	    pn2.add(new JLabel("Vendredi"), c);
 //----- Col5 -Ligne 1 -----------------------------------------------------
		c.gridx = 5;
		c.gridy = 1;
		// augmente la largeur des composants de 10 pixels
	    c.ipadx = 20; 
	    // augmente la hauteur des composants de 50 pixels
	    c.ipady = 20;  
	    // Ajouter les contraintes
	    pn2.add(new JPanel().add(new JLabel("")), c); // TODO: jour du mois
//----- Col 5-Ligne 2 -----------------------------------------------------
		c.gridx = 5;
		c.gridy = 2;
		// augmente la largeur des composants de 10 pixels
	    c.ipadx = 20; 
	    // augmente la hauteur des composants de 50 pixels
	    c.ipady = 20;  
	    // Ajouter les contraintes
	    pn2.add(new JPanel().add(new JLabel("06")), c); // TODO: jour du mois
//----- Col 5-Ligne 3 -----------------------------------------------------
		c.gridx = 5;
		c.gridy = 3;
		// augmente la largeur des composants de 10 pixels
	    c.ipadx = 20; 
	    // augmente la hauteur des composants de 50 pixels
	    c.ipady = 20;  
	    // Ajouter les contraintes
	    pn2.add(new JPanel().add(new JLabel("13")), c); // TODO: jour du mois
//----- Col 5-Ligne 4 -----------------------------------------------------
		c.gridx = 5;
		c.gridy = 4;
		// augmente la largeur des composants de 10 pixels
	    c.ipadx = 20; 
	    // augmente la hauteur des composants de 50 pixels
	    c.ipady = 20;  
	    // Ajouter les contraintes
	    pn2.add(new JPanel().add(new JLabel("20")), c); // TODO: jour du mois
//----- Col 5-Ligne 5 -----------------------------------------------------
		c.gridx = 5;
		c.gridy = 5;
		// augmente la largeur des composants de 10 pixels
	    c.ipadx = 20; 
	    // augmente la hauteur des composants de 50 pixels
	    c.ipady = 20;  
	    // Ajouter les contraintes
	    pn2.add(new JPanel().add(new JLabel("27")), c); // TODO: jour du mois
//----- Col 5-Ligne 6 -----------------------------------------------------
		c.gridx = 5;
		c.gridy = 6;
		// augmente la largeur des composants de 10 pixels
	    c.ipadx = 20; 
	    // augmente la hauteur des composants de 50 pixels
	    c.ipady = 20;  
	    // Ajouter les contraintes
	    pn2.add(new JPanel().add(new JLabel("")), c); // TODO: jour du mois
	    
//----- Colonne 6 : SAMEDI -----------------------------------------------------
  		c.gridx = 6;
  		c.gridy = 0;
		// augmente la largeur des composants de 10 pixels
	    c.ipadx = 20; 
	    // augmente la hauteur des composants de 50 pixels
	    c.ipady = 20;  
	    // Ajouter les contraintes
	    pn2.add(new JLabel("Samedi"), c);
//----- Col6 -Ligne 1 -----------------------------------------------------
		c.gridx = 6;
		c.gridy = 1;
		// augmente la largeur des composants de 10 pixels
	    c.ipadx = 20; 
	    // augmente la hauteur des composants de 50 pixels
	    c.ipady = 20;  
	    // Ajouter les contraintes
	    pn2.add(new JPanel().add(new JLabel("")), c); //TODO: jour du mois

//----- Col 6-Ligne 2 -----------------------------------------------------
		c.gridx = 6;
		c.gridy = 2;
		// augmente la largeur des composants de 10 pixels
	    c.ipadx = 20; 
	    // augmente la hauteur des composants de 50 pixels
	    c.ipady = 20;  
	    // Ajouter les contraintes
	  pn2.add(new JPanel().add(new JLabel("07")), c); //TODO: jour du mois
  //----- Col 6-Ligne 3 -----------------------------------------------------
		c.gridx = 6;
		c.gridy = 3;
		// augmente la largeur des composants de 10 pixels
	    c.ipadx = 20; 
	    // augmente la hauteur des composants de 50 pixels
	    c.ipady = 20;  
	    // Ajouter les contraintes
	  pn2.add(new JPanel().add(new JLabel("14")), c); //TODO: jour du mois
  //----- Col 6-Ligne 4 -----------------------------------------------------
		c.gridx = 6;
		c.gridy = 4;
		// augmente la largeur des composants de 10 pixels
	    c.ipadx = 20; 
	    // augmente la hauteur des composants de 50 pixels
	    c.ipady = 20;  
	    // Ajouter les contraintes
	  pn2.add(new JPanel().add(new JLabel("21")), c); //TODO: jour du mois
  //----- Col 6-Ligne 5 -----------------------------------------------------
		c.gridx = 6;
		c.gridy = 5;
		// augmente la largeur des composants de 10 pixels
	    c.ipadx = 20; 
	    // augmente la hauteur des composants de 50 pixels
	    c.ipady = 20;  
	    // Ajouter les contraintes
	  pn2.add(new JPanel().add(new JLabel("28")), c); //TODO: jour du mois
  //----- Col 6-Ligne 6 -----------------------------------------------------
		c.gridx = 6;
		c.gridy = 6;
		// augmente la largeur des composants de 10 pixels
	    c.ipadx = 20; 
	    // augmente la hauteur des composants de 50 pixels
	    c.ipady = 20;  
	    // Ajouter les contraintes
	    pn2.add(new JPanel().add(new JLabel("")), c); //TODO: jour du mois
	  
//----- Colonne 7 : DIMANCHE -----------------------------------------------------
		c.gridx = 7;
		c.gridy = 0;
		// augmente la largeur des composants de 10 pixels
	    c.ipadx = 20; 
	    // augmente la hauteur des composants de 50 pixels
	    c.ipady = 20;  
	    // Ajouter les contraintes
	    pn2.add(new JLabel("Dimanche"), c);
//----- Col7 -Ligne 1 -----------------------------------------------------
		c.gridx = 7;
		c.gridy = 1;
		// augmente la largeur des composants de 10 pixels
	    c.ipadx = 20; 
	    // augmente la hauteur des composants de 50 pixels
	    c.ipady = 20;  
	    // Ajouter les contraintes
	    pn2.add(new JPanel().add(new JLabel("01")), c); //TODO: jour du mois
//----- Col 7-Ligne 2 -----------------------------------------------------
		c.gridx = 7;
		c.gridy = 2;
		// augmente la largeur des composants de 10 pixels
	    c.ipadx = 20; 
	    // augmente la hauteur des composants de 50 pixels
	    c.ipady = 20;  
	    // Ajouter les contraintes
	    pn2.add(new JPanel().add(new JLabel("08")), c); //TODO: jour du mois
//----- Col 7-Ligne 3 -----------------------------------------------------
		c.gridx = 7;
		c.gridy = 3;
		// augmente la largeur des composants de 10 pixels
	    c.ipadx = 20; 
	    // augmente la hauteur des composants de 50 pixels
	    c.ipady = 20;  
	    // Ajouter les contraintes
	    pn2.add(new JPanel().add(new JLabel("15")), c); //TODO: jour du mois
//----- Col 7-Ligne 4 -----------------------------------------------------
		c.gridx = 7;
		c.gridy = 4;
		// augmente la largeur des composants de 10 pixels
	    c.ipadx = 20; 
	    // augmente la hauteur des composants de 50 pixels
	    c.ipady = 20;  
	    // Ajouter les contraintes
	    pn2.add(new JPanel().add(new JLabel("22")), c); //TODO: jour du mois
//----- Col 7-Ligne 5 -----------------------------------------------------
		c.gridx = 7;
		c.gridy = 5;
		// augmente la largeur des composants de 10 pixels
	    c.ipadx = 20; 
	    // augmente la hauteur des composants de 50 pixels
	    c.ipady = 20;  
	    // Ajouter les contraintes
	    pn2.add(new JPanel().add(new JLabel("29")), c); //TODO: jour du mois
//----- Col 7-Ligne 6 -----------------------------------------------------
	    c.gridx = 7;
		c.gridy = 6;
		// augmente la largeur des composants de 10 pixels
		c.ipadx = 20; 
		// augmente la hauteur des composants de 50 pixels
		c.ipady = 20;  
		// Ajouter les contraintes
		pn2.add(new JPanel().add(new JLabel("")), c); //TODO: jour du mois
		
		
		
	    		
//----- Panel 3eme ligne --------------------------------------------------		
		pn3 = new JPanel();
		pn3.setBackground(Color.yellow);
		JButton btn1 = new JButton("Valider");
		this.pn3.add(btn1);


		
		
// --- Ajouter les panels à la Frame -----------------
		this.setLayout(new BorderLayout());
		this.add(pn1, BorderLayout.NORTH);
		this.add(pn2, BorderLayout.CENTER);
		this.add(pn3, BorderLayout.SOUTH);

	}
}
