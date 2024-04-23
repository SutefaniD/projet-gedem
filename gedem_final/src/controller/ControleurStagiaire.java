package controller;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Stagiaire;
import tools.ControlConnection;


public class ControleurStagiaire {
	
	private ControlConnection acces;
	private DefaultTableModel model;
	private ArrayList <Stagiaire> listeStagiaires;
	private ResultSet rs;
	private String strQuery;
	private ResultSetMetaData rsmd;


	// récupérer table stagiaires (tous les stagiaires)
	public ControleurStagiaire() {
		
		this.acces = ControlConnection.getInstance();
		this.listeStagiaires = new ArrayList <Stagiaire>();
		try {			
			// REQUETE SQL
			this.strQuery = "SELECT nom, prenom, tel, mail FROM personne "
					+ "JOIN h_personne_stagiaire USING (idPersonne);";
				
			// RESULTAT DE LA REQUETE (EXECUTER LA REQUETE ET STOCKER LE RESULTAT)
			this.rs = acces.getSt().executeQuery(strQuery);
			

			this.rsmd = rs.getMetaData();			
	
			


// -------- LISTER LE CONTENU D'UNE TABLE ------------------------------------------------------------------------------------------
//			while(rs.next()) {					
//			System.out.println(
//						" [prenom: " + rs.getString(1) + "] "
//						+ "[nom: " + rs.getString(2) + "] " 
//						+ "[tel: " + rs.getString(3) + "] "
//						+ "[mail: " + rs.getString(4) + "] ");				
//			}

				
//----------INSTANCIER UNE LISTE D'OBJETS A PARTIR DES VALEURS STOCKEES EN BDD -----------------------------------------------------
//			while(rs.next()) {
//					
//				listeStagiaires.add(new Gakusei(rs.getInt(0), rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
//					
//			}

//----------------------------------------------------------------------------------------------------------------------------------
				
			
			//rs.close();

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
	
//===============Méthode:  listerStagiaireStr() =======================================================	
// pour créer une liste de stagiaire sous forme de String
	
	public String listerStagiaireStr() { 
		
		String nomTable = "h_personne_stagiaire";	

		String monEspace="";
		String monEspace2="";
		String listeStagStr="";
		
		try {
			// acces.getConn() : on utilise le getter sur l'instance de ControlConnection 
			if (!acces.getConn().isClosed()) {
					 
				String req = "SELECT * FROM "+nomTable+" JOIN personne USING (idPersonne);";
				//ResultSet rs = ControlConnection.getSt().executeQuery(req); // getter sur le statement
				ControlConnection cc4 = ControlConnection.getInstance();
				ResultSet rs = cc4.getSt().executeQuery(req);
				while (rs.next()) {
					
					listeStagiaires.add(new Stagiaire(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5)));
				}
				
				int i;
				
				for (i = 0; i < listeStagiaires.size(); i++) {
				
					if (listeStagiaires.get(i).getNomStagiaire().length()<8) {
						monEspace="\t\t";
						monEspace2="\t";
					}
					else {
						monEspace="\t";
						monEspace2="\t\t";
					}
				
					listeStagStr += listeStagiaires.get(i).getNomStagiaire()+monEspace
							+listeStagiaires.get(i).getPrenomStagiaire()+monEspace2
							+listeStagiaires.get(i).getTelStagiaire()+"\t"
							+listeStagiaires.get(i).getMailStagiaire()+"\t"
							+listeStagiaires.get(i).getRoleStagiaire()+"\n"	;
			
				}
			}
				
			acces.deconnexionBd(); // appel de la prodédure de ControlConnection qui ferme la connexion
		}
		catch (SQLException efc){
			System.out.println("Erreur listerStagiaire");
			efc.printStackTrace();
		}
		
		return listeStagStr;
			
		}
		
		
}
