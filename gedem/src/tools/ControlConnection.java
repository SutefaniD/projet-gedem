package tools;

import java.sql.*;

import controller.ControlLogin;
import view.App;

public class ControlConnection {
	
	private String dbName = "gedem_used_in_java";
	private String dbLogin = "gedem";
	private String dbMotdepasse = "gedem";
	// pilote
	private String strClassName ="com.mysql.cj.jdbc.Driver";
	// identifiant connexion
	private String strUrl = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
	private Connection conn;
	private Statement st;
	private static ControlConnection instance;
	private ControlLogin controlLoginInstance;
	private App app;
	
		
	/**
	 * CONSTRUCTEUR PAR DEFAUT
	 * Constructeur privé pour empêcher l'instanciation directe
	 */
	public ControlConnection() {

		try {
			// charger le pilote
			Class.forName(strClassName);
			sop("\nConnexion effectuee.");
			// établir la connexion
			this.conn = DriverManager.getConnection(strUrl, dbLogin, dbMotdepasse);
			System.out.println("Connecté !");
			this.st = conn.createStatement();						
		}
		catch(ClassNotFoundException e1) {
			System.err.println("Driver non chargé !");
			// Afficher détails erreurs dans la console
			e1.printStackTrace();
		}
		catch(SQLException e2) {
			
		}	
		
	}
	
	/**
	 *  CONSTRUCTEUR SURCHARGE
	 *  Ce constructeur prend 3 paramètres : le nom de la base, le login et le password.
	 * @param dao_db : nom de la base
	 * @param dao_login : id 
	 * @param dao_password : mdp
	 */
	public ControlConnection (String dao_db, String dao_login, String dao_password) {
		this.dbName = dao_db;
		this.dbLogin = dao_login;
		this.dbMotdepasse = dao_password;
		//this.listeStag = new ArrayList<Stagiaire>();
		
		try {
			Class.forName(strClassName);
			sop("Connexion effectuee.");
			System.out.println("Constructeur 2 avec params - Adresse de connexion : "+ strUrl+" ");
			this.conn = DriverManager.getConnection(strUrl, dbLogin, dbMotdepasse);
			this.st = conn.createStatement();
		}
		catch (SQLException e) {
			System.out.println("Erreur au premier \"try\".  Probleme de Connection ou Statement -> Constructeur 2");
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			System.out.println("Classe introuvable : erreur de driver.");
			e.printStackTrace();
		}
	}
	

	/**
	 * Méthode qui garantit qu'une seule instance d'une classe 
	 * est créée dans toute l'application
	 * @return instance
	 */
	public static ControlConnection getInstance() {
        if (instance == null) {
            instance = new ControlConnection();
        }
        return instance;
    }	
	
	/**
	 * GETTER
	 * @return the conn
	 *  la connexion sera rouverte si elle est fermée, 
	 *  
	 */
	public Connection getConn() {
		try {
            	// La connexion est fermée ou n'a pas encore été établie, ouvrez une nouvelle connexion
                conn = DriverManager.getConnection(strUrl, dbLogin, dbMotdepasse);
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données");
            e.printStackTrace();
        }
		return conn;
	}
	

	/**
	 * GETTER 
	 * @return st : le Statement
	 */
	public Statement getSt() {
		return st;
	}

	
	/**
     * Méthode pour effectuer la déconnexion de l'utilisateur
     */
    public void deconnexionBd() {
        try {
        	if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }

            // Réinitialiser les champs de connexion
            dbName = "gedem_used_in_java";
            dbLogin = "gedem";
            dbMotdepasse = "gedem";

            controlLoginInstance = null; // Réinitialiser l'instance de ControlLogin
            sop("Déconnexion effectuée.");
        } catch (SQLException efc) {
            System.out.println("Erreur lors de la fermeture de la connexion / du Statement (Driver JDBC)");
            efc.printStackTrace();
        }
    }
    
  


    /**
     * Méthode pour récupérer l'instance de ControlLogin
     * sert pour gérer la connexion à la base de données et 
     * effectuer des opérations liées à l'authentification 
     * et à l'autorisation des utilisateurs
     * @return instance de ControlLogin
     */
    public ControlLogin getControlLogin() {
        if (controlLoginInstance == null) {
			// Instanciez ici une nouvelle instance de ControlLogin si nécessaire
            controlLoginInstance = new ControlLogin(this, app);
        }
        return controlLoginInstance;
    }
    
    
//===== Alias S.O.P =================================================
	public void sop(String texte) {
			System.out.println(texte);
	}


// ===========================================================================
	/**
	 * METHODE pour supprimer
	 * @param idS
	 */
	public void supprimer(int idS) {
		
		try {
			if (conn != null && !conn.isClosed()) {
			
			String req="DELETE FROM Acces WHERE id="+idS+";";
			st.executeUpdate(req);
			
			}
			else {
				sop("Erreur lors de la supression : la connexion à la Bdd est fermée.");
			}
			
		}
		catch (SQLException es) {
			sop("Erreur lors de l'appel de la fonction supprimer()");
			es.printStackTrace();
		}
		
	}

}
	


	


