package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import tools.ControlConnection;

public class Role {
	
	protected int idRole;
	protected String nomRole;
	protected ControlConnection ccr;
	protected static Vector<String> vectorRole;
	
	/**
	 * CONSTRUCTEUR role
	 * @param int id = idRole
	 * @param String n = nomRole 
	 */
	public Role(int id, String n) {
		this.idRole=id;
		this.nomRole=n;		
	}
	
	
	public Role() {
		System.out.println("Contructeur pour role avec connexion BDD");
		vectorRole = new Vector<String>();
		if (this.vectorRole.isEmpty()) { 
		// on instancie une connexion bdd si la liste de roles n'existe pas encore.
		ccr = ControlConnection.getInstance();
		}
	}

	/**
	 * METHODE listerRole()
	 * 
	 * @return role (1=Admin, 2=Formateur, 3=Stagiaire)
	 */
	
	public Vector<String> listerRole() {
		String req = "select nomRole from role;";
		try {
			ResultSet rs = ccr.getSt().executeQuery(req);
			
			while (rs.next()) {
				// on remplit le vector avec les éléments de la table role
				vectorRole.addElement(rs.getString(1));
				
			}
			for (int i = 0; i < vectorRole.size(); i++) {
			System.out.println("vectorRole : "+vectorRole.get(i));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("erreur pour recuperer le role");
			e.printStackTrace();
		}
		//cc.fermerConn();
		return vectorRole;
		
	}
	
	
	public int getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public String getNomRole() {
		return nomRole;
	}
	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}
	public ControlConnection getCcr() {
		return ccr;
	}
	public void setCcr(ControlConnection ccr) {
		this.ccr = ccr;
	}
	public Vector<String> getVectorRole() {
		return vectorRole;
	}
	public void setVectorRole(Vector<String> vectorRole) {
		this.vectorRole = vectorRole;
	}
	
}
