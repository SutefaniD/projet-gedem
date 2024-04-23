package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import tools.ControlConnection;
import view.App;
import view.ViewConnection;
import view.VueCpteAdmin_Accueil_ListeFormations;
import view.VueCpteFormateur_Accueil_EmargtEnCours;
import view.VueCpteStagiaire_Accueil_EmargtEnCours;

public class ControlLogin {	
	private App appli;
    private ControlConnection cc;
    private String loginStr;
    private JTextField passwordRes;
    private ControleMenuBar controleMenuBar;
    private Connection conn;
    private Statement st;
    private PreparedStatement stmt;
    private ResultSet rs;
    private int nbTentaEchec;
	private int nbBlocage;
	private boolean compteBloque;
    
    
    public ControlLogin(ControlConnection controlConnection, App app) {
        this.cc = controlConnection;
        this.appli = app;
    }
        
    public ControlLogin(ViewConnection cn, App appli) {
        this.appli = appli;
        this.cc = ControlConnection.getInstance();
        this.conn = cc.getConn();
        this.st = cc.getSt();
        this.loginStr = cn.getULogin().getText();
        this.passwordRes = cn.getUPassword();
        
        try {
        	// Code pour vérifier le login et le mot de passe dans la base de données
            String query = "SELECT p.idRole, r.nomRole, p.nbTentaEchec, p.nbBlocage, p.compteBloque, p.password FROM personne p " +
                           "INNER JOIN role r ON p.idRole = r.idRole " +
                           "WHERE p.login = ?";
            
            			// "WHERE p.login = ? AND p.password = ?";
            
            // Utiliser des paramètres de substitution (?) à la place des valeurs réelles
            // du login et du mot de passe permet d'éviter les injections SQL 
            // et d'améliorer la sécurité de l'application.
            
            stmt = conn.prepareStatement(query);            
            stmt.setString(1, loginStr); 
            //stmt.setString(2, passwordRes.getText());
            // les valeurs du login et du mot de passe entrés par l'utilisateur 
            // sont respectivement substituées aux paramètres ? dans la requête.
                                              
            rs = stmt.executeQuery();
            //-----------------------------------------------------------------------                      
            if (rs.next()) {
                int roleId = rs.getInt("idRole");
                String role = rs.getString("nomRole");
               
                this.nbTentaEchec = rs.getInt("nbTentaEchec");
                this.nbBlocage = rs.getInt("nbBlocage");
                this.compteBloque = rs.getBoolean("compteBloque");
                
                if (compteBloque) {
                	JOptionPane.showMessageDialog(null, "Compte Bloqué", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return; // Arrêter le processus de connexion
                }
               
            	if (nbTentaEchec < 3) {
                	String passwordFromDB = rs.getString("password");
                	if (passwordRes.getText().equals(passwordFromDB)) {
                		nbTentaEchec = 0;
                		System.out.println("Rôle : " + role);                 
                        controleMenuBar = new ControleMenuBar(appli, role, this);
                        configureContentPanel(role);              		
                	} else {
                		nbTentaEchec++;
                		String req = "UPDATE personne SET nbTentaEchec = " +nbTentaEchec+ " WHERE login = '" +loginStr+ "';";
                        st.executeUpdate(req);
                        JOptionPane.showMessageDialog(null, "Erreur : Le mot de passe est incorrect", "Erreur", JOptionPane.ERROR_MESSAGE);                       

	                	// Requête préparée
	                    // String req = "UPDATE personne SET nbTentaEchec = ?;";
	                    // PreparedStatement updateStmt = conn.prepareStatement(req);
	                    // updateStmt.setInt(1, nbTentaEchec);
	                    // updateStmt.executeUpdate();
                        
                        if (nbTentaEchec == 3) {
                        	nbBlocage++;
                            String req2 = "UPDATE personne SET compteBloque = true, nbBlocage = '" +nbBlocage+ "' WHERE login = '" + loginStr + "';";
                            st.executeUpdate(req2);
                            JOptionPane.showMessageDialog(null, "Compte Bloqué", "Erreur", JOptionPane.ERROR_MESSAGE);
                            return; // Arrêter le processus de connexion
                        }
                        
                        ViewConnection newViewConnection = new ViewConnection(appli);
                        appli.getContentPane().add(newViewConnection);
                        appli.getContentPane().repaint();
                        appli.getContentPane().revalidate();
                	}                                         
                     
            	} else {
            		JOptionPane.showMessageDialog(null, "Compte Bloqué", "Erreur", JOptionPane.ERROR_MESSAGE);
                	return; // Arrêter le processus de connexion
                	                	
                	// Requête préparée
                	// String req2 = "UPDATE personne SET nbBlocage = ?;";
                	// PreparedStatement updateStmt = conn.prepareStatement(req2);
                	// updateStmt.setInt(1, nbBlocage);
                	// updateStmt.executeUpdate();
            	}              
            } else {
                System.out.println("ACCESS REFUSE console");                              
                JOptionPane.showMessageDialog(null, "Erreur : Le login est incorrect.", "Erreur", JOptionPane.ERROR_MESSAGE);               
            }                               
        } catch (SQLException e) {
            System.out.println("Erreur ControlLogin");
            e.printStackTrace();
        } 
        //this.cc= null;    // on tue la connexion
    }
   
    /**
     * Méthode pour afficher la page d'accueil correspondante en fonction du rôle
     * @param role
     */
    private void configureContentPanel(String role) {
        appli.getContentPane().removeAll();

        controleMenuBar = new ControleMenuBar(appli, role, this); // On ajoute ControleMenuBar à la fenêtre principale
        controleMenuBar.configureMenu(); // Appel à configureMenu() après avoir créé l'objet controleMenuBar
        
        switch (role) {
            case "User":
                System.out.println("Vous êtes stagiaire.");
                VueCpteStagiaire_Accueil_EmargtEnCours accSt = new VueCpteStagiaire_Accueil_EmargtEnCours(appli);
                appli.getContentPane().add(accSt);
                controleMenuBar = new ControleMenuBar(appli, role, this);
                controleMenuBar.configureMenu();
                break;
            case "Admin":
                System.out.println("Vous êtes admin.");
                VueCpteAdmin_Accueil_ListeFormations accAdm = new VueCpteAdmin_Accueil_ListeFormations(appli);
                appli.getContentPane().add(accAdm);
                controleMenuBar = new ControleMenuBar(appli, role, this);
                controleMenuBar.configureMenu();
                break;
            case "Formateur":
                System.out.println("Vous êtes formateur/trice.");
                VueCpteFormateur_Accueil_EmargtEnCours accF = new VueCpteFormateur_Accueil_EmargtEnCours(appli);
                appli.getContentPane().add(accF);
                controleMenuBar = new ControleMenuBar(appli, role, this);
                controleMenuBar.configureMenu();
                break;               
            default:
                System.out.println("PROBLEME: Le nom du rôle n'est pas valide : " + role);
                JOptionPane.showMessageDialog(null, "Erreur : Le rôle n'est pas valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                ViewConnection newViewConnection = new ViewConnection(appli);
                appli.getContentPane().add(newViewConnection);
                break;
        }
        
        // Appel de la méthode configureMenuBar(role)
        //controleMenuBar = new ControleMenuBar(appli, role, this);
     
        // Appel à la méthode closeResources() ici, après avoir configuré le contenu de la vue
        //closeResources();
        
        appli.getContentPane().repaint();
        appli.getContentPane().revalidate();
    }
  
    
    public void reinitialiserVueConnection() {
        appli.getContentPane().removeAll();
        ViewConnection newViewConnection = new ViewConnection(appli);
        appli.getContentPane().add(newViewConnection);
        appli.getContentPane().repaint();
        appli.getContentPane().revalidate();
    }
    
   
   
    private void closeResources() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            // on ne ferme pas la connexion ici
            //if (conn != null) {
                //conn.close();
            //}
        } catch (SQLException e) {
            System.err.println("Erreur lors de la fermeture des ressources : " + e.getMessage());
        }
    }
  
    /**
     * Méthode pour rouvrir les ressources nécessaires 
     * pour récupérer les données à afficher dans chaque onglet
     */
    public void reopenResources() {
        try {
            /*if (rs != null && rs.isClosed()) {*/
                rs = stmt.executeQuery();  // Réexécutez la requête pour obtenir un nouveau ResultSet
           // }
            // Réexécutez d'autres instructions pour rouvrir les ressources nécessaires
        } catch (SQLException e) {
            System.err.println("Erreur lors de la réouverture des ressources : " + e.getMessage());
        }
    }


    

}
    
    
