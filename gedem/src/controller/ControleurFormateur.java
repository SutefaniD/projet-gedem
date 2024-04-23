package controller;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Formateur;
import tools.ControlConnection;

public class ControleurFormateur {
	private ControlConnection acces;
	private DefaultTableModel model;
	private ArrayList <Formateur> listeFormateurs;
	private ResultSet rs;
	private String strQuery;
	private ResultSetMetaData rsmd;


	// récupérer table formateurs
	public ControleurFormateur() {
		
		this.acces = ControlConnection.getInstance();
		this.listeFormateurs = new ArrayList <Formateur>();
		try {			
			// REQUETE SQL
			this.strQuery =  "select nom, prenom, tel, mail, intituleMatiere, nomFormation from personne"
				    + " join h_personne_formateur using (idPersonne)"
				    + " left join df_formateur_matiere using (idFormateur)"
				    + " left join matiere using (idMatiere)"
				    + " left join df_matiere_formation using (idMatiere)"
				    + " left join formation using (idFormation)"
				    + " order by nom;";
			
			/*
			 * liste des formateurs et leur matiere (un nom = une matiere)
			 *  "SELECT DISTINCT nom, prenom, tel, mail, intituleMatiere FROM personne"
			 *  + "JOIN h_personne_formateur USING (idPersonne)"
			 *  + "LEFT JOIN df_formateur_matiere USING (idFormateur)"
			 *  + "LEFT JOIN matiere USING (idMatiere)"
			 *  + "LEFT JOIN df_matiere_formation USING (idMatiere)"
			 *  + "ORDER BY nom;";
			 */
				
			// RESULTAT DE LA REQUETE (EXECUTER LA REQUETE ET STOCKER LE RESULTAT)
			this.rs = acces.getSt().executeQuery(strQuery);
			

			this.rsmd = rs.getMetaData();			

		}
		catch(SQLException efc) {
			System.out.println("Erreur de fermeture de connexion / Statement (Driver jdbc)");
			efc.printStackTrace();
		}
					 
	}

	
	/*
	 * GETTER
	 * 
	 */	
	public DefaultTableModel getModel() {
		return model;
	}

	public ResultSetMetaData getRsmd() {
		return rsmd;
	}

	public ResultSet getRs() {
		return rs;
	}


	public ArrayList <Formateur> getListeFormateurs() {
		return listeFormateurs;
	}
			
}

