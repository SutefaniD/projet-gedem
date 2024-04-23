package controller;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Personne;
import tools.ControlConnection;


public class ControleurPersonne {
	
	private ControlConnection acces;
	private DefaultTableModel model;
	private ArrayList <Personne> listePersonnes;
	private ResultSet rs;
	private String strQuery;
	private ResultSetMetaData rsmd;


	// récupérer table personne
	public ControleurPersonne() {
		
		this.acces = ControlConnection.getInstance();
		this.listePersonnes = new ArrayList <Personne>();
		try {			
			// REQUETE SQL
			// C'est un peu long, mais on a toutes les infos sur les Personnes,
			// avec le nom de la matière enseignée si c'est un Formateur
			// le nom de la formation si c'est un Stagiaire
			// la fonction si c'est un Administratif
			this.strQuery = "SELECT nom, prenom, tel, mail, login, password, nbTentaEchec, nbBlocage, nomRole, nomFormation, intituleMatiere, fonction"
					+ " FROM personne JOIN role USING (idRole) "
					+ " LEFT JOIN h_personne_stagiaire USING (idPersonne)"
					+ " LEFT JOIN df_stagiaire_formation USING (idStagiaire)"
					+ " LEFT JOIN formation USING (idFormation)"
					+ " LEFT JOIN h_personne_formateur USING (idPersonne)"
					+ " LEFT JOIN df_formateur_matiere USING (idFormateur)"
					+ " LEFT JOIN matiere USING (idMatiere)"
					+ " LEFT JOIN h_personne_administratif USING (idPersonne);";
				
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


	public ArrayList <Personne> getListePersonnes() {
		return listePersonnes;
	}
		
		
}
