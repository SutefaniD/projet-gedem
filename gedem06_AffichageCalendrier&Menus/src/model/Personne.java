package model;

public class Personne {

	private int idPersonne;
	private String nom;
	private String prenom;
	private String mail;
	private String tel;
	private int idRole;
	private String login;
	private String password;
	
	public Personne(String n, String p, String m, String t) {
		
		this.nom = n;
		this.prenom = p;
		this.mail = m;
		this.tel = t;
		
	}
	
	public Personne(String n, String p, String m, String t, String login, String password) {
		
		this.nom = n;
		this.prenom = p;
		this.mail = m;
		this.tel = t;
		this.setLogin(login);
		this.setPassword(password);
		
		
	}
	
	public Personne(int idRole,String n, String p, String m, String t) {
		this.setIdRole(idRole);
		this.nom = n;
		this.prenom = p;
		this.mail = m;
		this.tel = t;
	
	}
	
	public Personne(int idRole, String n, String p, String m, String t, String login, String password) {
		this.setIdRole(idRole);
		this.nom = n;
		this.prenom = p;
		this.mail = m;
		this.tel = t;
		this.setLogin(login);
		this.setPassword(password);
		
	}

	public int getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
