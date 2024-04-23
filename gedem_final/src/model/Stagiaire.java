package model;
/**
 * un stagiaire est créé dans une formation
 * un stagiaire a un nom, prénom, tel et mail
 * un stagiaire fait son émargement pour un créneau: présent ou absent ou erreur
 * @author steph
 *
 */
public class Stagiaire {
	
		//private int id;
	    private String nomStagiaire;
	    private String prenomStagiaire;
	    private String telStagiaire;
	    private String mailStagiaire;
	    private String roleStagiaire;
	    
	    /**
	     * CONSTRUCTEUR Stagiaire
	     * 
	     * @param pStg : prénom
	     * @param nStg : nom
	     * @param telStg : tel
	     * @param melStg : mail
	     * @param rStg : role
	     */
	    public Stagiaire(String pStg, String nStg, String telStg, String melStg, String rStg) 
	    {
	    	//this.id = Id;
	    	this.prenomStagiaire = pStg;
	    	this.nomStagiaire = nStg;
	    	this.telStagiaire = telStg;
	    	this.mailStagiaire = melStg;
	    	this.roleStagiaire = rStg;
	    }
	    	    
	   	        
	        
	    /**
	     * Constructeur sans attribut téléphone
	     * @param prenomStagiaire
	     * @param nomStagiaire
	     * @param mailStagiaire
	     */
	    public Stagiaire(String prenomStagiaire, String nomStagiaire, String mailStagiaire)
	    {
	    	this.prenomStagiaire = prenomStagiaire;
	    	this.nomStagiaire = nomStagiaire;  	
	    	this.mailStagiaire = mailStagiaire;
	    }
	    
	   

	    
		/**
		 * GETTER
		 * @return nomStagiaire
		 */
		public String getNomStagiaire() {
			return nomStagiaire;
		}

		/**
		 * SETTER
		 * @param nomStagiaire
		 */
		public void setNomStagiaire(String nomStagiaire) {
			this.nomStagiaire = nomStagiaire;
		}

		/**
		 * GETTER
		 * @return prenomStagiaire
		 */
		public String getPrenomStagiaire() {
			return prenomStagiaire;
		}

		/**
		 * SETTER 
		 * @param prenomStagiaire
		 */
		public void setPrenomStagiaire(String prenomStagiaire) {
			this.prenomStagiaire = prenomStagiaire;
		}

		/**
		 * GETTER
		 * @return telStagiaire
		 */
		public String getTelStagiaire() {
			return telStagiaire;
		}

		/**
		 * SETTER
		 * @param telStagiaire
		 */
		public void setTelStagiaire(String telStagiaire) {
			this.telStagiaire = telStagiaire;
		}

		/**
		 * GETTER
		 * @return mailStagiaire
		 */
		public String getMailStagiaire() {
			return mailStagiaire;
		}

		/**
		 * SETTER
		 * @param mailStagiaire
		 */
		public void setMailStagiaire(String mailStagiaire) {
			this.mailStagiaire = mailStagiaire;
		}



		/**
		 * GETTER
		 * @return the roleStagiaire
		 */
		public String getRoleStagiaire() {
			return roleStagiaire;
		}



		/**
		 * SETTER
		 * @param roleStagiaire the roleStagiaire to set
		 */
		public void setRoleStagiaire(String roleStagiaire) {
			this.roleStagiaire = roleStagiaire;
		}


		


}
