package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTextField;

import model.*;
import tools.ControlConnection;
import view.VueAdmin_ListeFormations;
import view.VueFormateur_Accueil_EmargtEnCours;
import view.VueListeStagiaires;
import view.VueStagiaire_Accueil_EmargtEnCours;
import view.App;
import view.ViewConnection;



public class ControlLogin {
	
	private ControlConnection cc;
	private VueStagiaire_Accueil_EmargtEnCours accSt;
	private VueFormateur_Accueil_EmargtEnCours accF;
	private VueAdmin_ListeFormations accAdm;
	//ArrayList<Login> listeLogin;
	//private VueListeStagiaires vls;
	//private ViewFormPersonne vfp;
	//private ViewListeFormation vform;
	
	private int flag;
	
	// /** CONSTRUCTEUR =========================
	/**
	 * 
	 * @param cn = ViewConnection (JPanel)
	 * @param appli = App (JFrame)
	 */
	public ControlLogin(ViewConnection cn,App appli) {
		cc = new ControlConnection();
		// ViewConnection et App en paramètres, pour pouvoir échanger  
		// des infos entre les vues et le controleur - 	cn : JPanel		appli : JFrame

		// recupère uLogin avec le getter de la classe ViewConnection
		String loginStr = cn.getULogin().getText(); 
		// recupère uPassword avec le getter de la classe ViewConnection
		JTextField password = cn.getUPassword();	
		// on transforme l'objet TextField en String, pour le passer en paramètre de la requête SQL				
		String passwordresStr = password.getText();

		//this.listeLogin = new ArrayList<Login>();
		this.flag = 0;
		
		try {
			//la requete récupère les infos dans la BDD en sélectionnant 
			//les champs qui correspondent aux logins, passwords et roles de la vue "ViewConnection"
			String req2="SELECT idRole,login,password from personne where login='"+loginStr+"' AND password='"+passwordresStr+"' ; ";				
			
			// on fait un get pour recup le statement de ControlConnection
			ResultSet rs2 = cc.getSt().executeQuery(req2);
			
			// si rs2 contient une donnée, donc si login et mot de passe correspondent
			if (rs2.next()) { 
				
				int monIdRole = rs2.getInt(1); // on recup le 1er champ du resultset, qui est idRole 
				System.out.println("int monIdRole : "+rs2.getInt(1));
				
				String req3="SELECT nomRole from role where idRole='"+monIdRole+"';";				
				ResultSet rs3 = cc.getSt().executeQuery(req3);
	
				System.out.println("LOGIN ET MOT DE PASSE OK");
			
				// si le resultSet retourne nomRole	
				if (rs3.next()) { 
								
					System.out.println("Rôle : " +rs3.getString(1));
				
					// --- Traitement des resultats dans la console -----------------------------------
					if (rs3.getString(1).equals("User")) {
						System.out.println("Vous êtes stagiaire.");
						flag = 1;
					}
					else if (rs3.getString(1).equals("Admin")) {
						System.out.println("Vous êtes admin.");
						flag = 2;
					}
					else if (rs3.getString(1).equals("Formateur")) {
						System.out.println("Vous êtes formateur/trice.");
						flag = 3;
					}
					else 
						System.out.println("Valeur de rs3.getString(1): "+rs3.getString(1));
				
					// --- Traitement des resultats vers la JFrame -----------------------------------
				
					// on supprime ce qu'il y avait précédemment sur le JPanel
					appli.getContentPane().removeAll();
				
					switch (flag) {
						case 1:
							// cas "User" --> Stagiaire
							accSt = new VueStagiaire_Accueil_EmargtEnCours(appli);
							appli.getContentPane().add(accSt);
							break;
				
						case 2:
							// cas "Admin"
							accAdm = new VueAdmin_ListeFormations(appli);
							appli.getContentPane().add(accAdm);
							break;
					
						case 3:
							// cas "Formateur"
							accF = new VueFormateur_Accueil_EmargtEnCours(appli);
							appli.getContentPane().add(accF);
							break;				
					}
				
					appli.getContentPane().repaint();
					appli.getContentPane().revalidate();
	
				}
				else { // Affichage console si login et password ne "match" pas avec la BDD
					System.out.println("ACCESS REFUSE console");
	
					appli.getContentPane().add(cn.getMessage2());
					appli.getContentPane().repaint();
					appli.getContentPane().revalidate();
				
				}
			}
		}
			
		/*
// Affichage 
		for (int i=0;i<listeLogin.size(); i++) {
		System.out.print(listeLogin.get(i).getULogin()+"\t");
		System.out.print(listeLogin.get(i).getDbPassword()+"\t");
		System.out.print(listeLogin.get(i).getURole()+"\n");
		
			}
		
		}
		*/
		
		catch (SQLException efc){
			System.out.println("Erreur ControlLogin");
			efc.printStackTrace();
		}

	}

}	
	

	

