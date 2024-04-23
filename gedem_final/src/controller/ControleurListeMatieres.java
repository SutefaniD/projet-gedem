package controller;

import java.awt.GridBagConstraints;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Matiere;
import tools.ControlConnection;
import view.VueCalendrier_Journee;

// Controleur appelle la vue et pas l'inverse
// Modif des objets, récupération en BD et aiguillage = controleur
	public class ControleurListeMatieres {

	//private DefaultTableModel model;
	public static ArrayList<Matiere> listeMatieres;
	private ControlConnection acces;
	
	private ResultSet rs;
	private String strQuery;
	//private ResultSetMetaData rsmd;
	

// - CONTROLEUR ------------------------------------------
	
	public ControleurListeMatieres(JPanel p, GridBagConstraints c) {
		
		acces = ControlConnection.getInstance();
		listeMatieres = new ArrayList<Matiere>();
		
		
		try {			
			// REQUETE SQL
			this.strQuery = "SELECT * FROM matiere;";
				
			// RESULTAT DE LA REQUETE (EXECUTER LA REQUETE ET STOCKER LE RESULTAT)
			this.rs = acces.getSt().executeQuery(strQuery);
			
			//this.rsmd = rs.getMetaData();
			
			//-INSTANCIER UNE LISTE D'OBJETS A PARTIR DES VALEURS STOCKEES EN BDD ----------		
			while(rs.next()) {
								
				//listeMatieres.add(new Matiere(rs.getInt(1), rs.getString(2), rs.getString(3)));
				listeMatieres.add(new Matiere(rs.getString(2)));
			}
			
			//tm.getContentPane().add(new EssaiPlanning(listeMatieres));
			p.add(new VueCalendrier_Journee(listeMatieres), c);
			p.repaint();
			p.revalidate();
//----------pour tester VueJournee  (public ControleurListeMatieres(JPanel p, GridBagConstraints c)) ---------------------------------			
			//p.add(new VueJournee(listeMatieres), c);
			//p.repaint();
			//p.revalidate();
//---------------------------------------------------------------------------------------------------------			
			acces.deconnexionBd();;
		}
		catch(SQLException efc) {
			System.out.println("Erreur de fermeture de connexion / Statement (Driver jdbc)");
			efc.printStackTrace();
		}
	}


	/**
	 * @return the listeMatieres
	 */
	public static ArrayList<Matiere> getListeMatieres() {
		return listeMatieres;
	}


	/**
	 * @param listeMatieres the listeMatieres to set
	 */
	public static void setListeMatieres(ArrayList<Matiere> listeMatieres) {
		ControleurListeMatieres.listeMatieres = listeMatieres;
	}


	/**
	 * @return the rs
	 */
	public ResultSet getRs() {
		return rs;
	}
			
}
