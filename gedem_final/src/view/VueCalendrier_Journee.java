package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Matiere;

public class VueCalendrier_Journee extends JPanel {
	
	JPanel vueCell;
	JPanel vueAM; // pour matin
	JPanel vuePM; // pour aprem	
	private JComboBox<String> cours;
	
	
	public VueCalendrier_Journee(ArrayList<Matiere> liste) {
		
		JPanel vueCell = new JPanel(new GridBagLayout());
  	    GridBagConstraints c2 = new GridBagConstraints();
  	    c2.gridx = 0;
  	    c2.gridy = 0;
  	    vueAM = new JPanel();
	    vueAM.add(new JLabel("matin")); 	    
	    vueCell.add(vueAM, c2);
  	    
	    c2.gridx = 1;
	    c2.gridy = 0;
	    
		vueCell.add(listeMatieresCbB(liste),c2);
		
		c2.gridx = 0;
  	    c2.gridy = 1;
  	    vuePM = new JPanel();
	    vuePM.add(new JLabel("après-midi")); 	    
	    vueCell.add(vuePM, c2);
  	    
	    c2.gridx = 1;
	    c2.gridy = 1;	   
	    vueCell.add(listeMatieresCbB(liste),c2);
		
		this.add(vueCell);
	}
	
	/*public void vueMatin(ArrayList<Matiere> liste) {
		
		JLabel matin = new JLabel("Cours");
		this.add(matin);
				
		VueListeMatieresCbB mat2 = new VueListeMatieresCbB(liste);
		this.add(mat2);
		
		
	}
	
	public void vueAprem(ArrayList<Matiere> liste) {
		
		JLabel aprem = new JLabel("Cours");
		this.add(aprem);
				
		VueListeMatieresCbB mat = new VueListeMatieresCbB(liste);
		this.add(mat);
		
		
	}
	*/
	
	public JComboBox<String> listeMatieresCbB (ArrayList <Matiere> listeMatieres) {
		
		
		this.cours = new JComboBox<String>();
			
		for (int i = 0; i < listeMatieres.size(); i++) {
			
		cours.addItem(listeMatieres.get(i).getNomMatiere());
		}
		
		
		return cours;
		
		
	}
}
