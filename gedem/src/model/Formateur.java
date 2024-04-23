package model;

public class Formateur {

	private String nomFormateur;
    private String prenomFormateur;
    private String telFormateur;
    private String mailFormateur;
    private Matiere intitMatiere;
    private Formation nomFormation;

    public Formateur (String nom, String prenom, String tel, String mel, Matiere mat) {
    	this.nomFormateur = nom;
    	this.prenomFormateur = prenom;
    	this.telFormateur = tel;
    	this.mailFormateur = mel;
    	this.intitMatiere = mat;
    	
    }
    
    public Formateur (String nom, String prenom, String tel, String mel, Matiere mat, Formation nomF) {
    	this.nomFormateur = nom;
    	this.prenomFormateur = prenom;
    	this.telFormateur = tel;
    	this.mailFormateur = mel;
    	this.intitMatiere = mat;
    	this.nomFormation = nomF;
    }
    
    
    /**
     * pour utiliser le getter getNomMatiere de la classe Matiere
     * sert à obtenir le nom de la matière correspondante
     * en appelant la méthode getNomMatiere() sur une instance de la classe Formateur
     * ex: Formateur formateur = new Formateur("John", "Doe", "123456789", "john.doe@example.com", new Matiere("Mathématiques"));
     * String nomMatiere = formateur.getNomMatiere();
     * @return
     */
    public String getNomMatiere() {
        return intitMatiere.getNomMatiere();
    }

	/**
	 * @return the nomFormateur
	 */
	public String getNomFormateur() {
		return nomFormateur;
	}

	/**
	 * @param nomFormateur the nomFormateur to set
	 */
	public void setNomFormateur(String nomFormateur) {
		this.nomFormateur = nomFormateur;
	}

	/**
	 * @return the prenomFormateur
	 */
	public String getPrenomFormateur() {
		return prenomFormateur;
	}

	/**
	 * @param prenomFormateur the prenomFormateur to set
	 */
	public void setPrenomFormateur(String prenomFormateur) {
		this.prenomFormateur = prenomFormateur;
	}

	/**
	 * @return the telFormateur
	 */
	public String getTelFormateur() {
		return telFormateur;
	}

	/**
	 * @param telFormateur the telFormateur to set
	 */
	public void setTelFormateur(String telFormateur) {
		this.telFormateur = telFormateur;
	}

	/**
	 * @return the mailFormateur
	 */
	public String getMailFormateur() {
		return mailFormateur;
	}

	/**
	 * @param mailFormateur the mailFormateur to set
	 */
	public void setMailFormateur(String mailFormateur) {
		this.mailFormateur = mailFormateur;
	}

	
}
