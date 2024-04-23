package controller;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Formation;
import model.Stagiaire;
import tools.ControlConnection;

public class ControleurFormation {

	private ControlConnection acces;
	private DefaultTableModel model;
	private ArrayList <Formation> listeFormations;
	private ResultSet rs;
	private String strQuery;
	private ResultSetMetaData rsmd;


	// récupérer table liste de toutes les formations
	public ControleurFormation() {
		
		this.acces = ControlConnection.getInstance();
		this.setListeFormations(new ArrayList <Formation>());
		try {
			
			// Vérifier si la connexion à la base de données est ouverte
	        if (!acces.getConn().isClosed()) {
	        	
	        	// REQUETE SQL
	        	this.strQuery = "SELECT nomFormation, dateDebut, dateFin FROM formation;";
				
	        	// RESULTAT DE LA REQUETE (EXECUTER LA REQUETE ET STOCKER LE RESULTAT)
	        	this.rs = acces.getSt().executeQuery(strQuery);			
	        	this.rsmd = rs.getMetaData();			

	        } else {
	        	 System.out.println("Erreur de connexion à la base de données");
	        }
        } catch(SQLException efc) {
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

	public ArrayList <Formation> getListeFormations() {
		return listeFormations;
	}

	public void setListeFormations(ArrayList <Formation> listeFormations) {
		this.listeFormations = listeFormations;
	}
			
		
}
