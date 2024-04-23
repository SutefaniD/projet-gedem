package view;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import model.Matiere;

public class VueListeMatieresCbB extends JPanel {
	
	private JComboBox<String> cours;
	

	// Créer une liste déroulante pour sélectionner les matières
	public VueListeMatieresCbB (ArrayList <Matiere> listeMatieres) {
		
		
		this.cours = new JComboBox<String>();
			
		for (int i = 0; i < listeMatieres.size(); i++) {
			
		cours.addItem(listeMatieres.get(i).getNomMatiere());
		}
		
		this.add(cours);
	}

}
