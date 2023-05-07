package tools;

import java.sql.*;

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

	
		
	/**
	 * CONSTRUCTEUR PAR DEFAUT
	 * 
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
	 * @return the conn
	 */
	public Connection getConn() {
		return conn;
	}

	/**
	 * GETTER 
	 * @return st : le Statement
	 */
	public Statement getSt() {
		return st;
	}

//===== Alias S.O.P =================================================
	public void sop(String texte) {
			System.out.println(texte);
	}

//==================================================================
	
	/**
	 * METHODE 	pour fermer connexion
	 * 
	 */
	public void fermerConn() {
		try {
			st.close();
			conn.close();			
		}
		catch (SQLException efc) {
			System.out.println("Erreur de fermeture de connexion / Statement (Driver jdbs)");
			efc.printStackTrace();
		}
	}

// ===========================================================================
	/**
	 * METHODE pour supprimer
	 * @param idS
	 */
	public void supprimer(int idS) {
		
		try {
			if (!conn.isClosed()) {
			
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
	


	


