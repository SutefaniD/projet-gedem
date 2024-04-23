package model;

// appartient à classe Formation dans modèle
public class Matiere {

	private int id;
	private String nomMatiere;
	private String nomUV;
	
	
	/**
	 * Constructeur Matière
	 * @param id
	 * @param nom
	 * @param uv
	 */
	public Matiere(String nom) {
		this.nomMatiere = nom;		
	}

	/**
	 * GETTER id
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * SETTER id
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * GETTER nomMatiere
	 * @return the nomMatiere
	 */
	public String getNomMatiere() {
		return nomMatiere;
	}

	/**
	 * SETTER nomMatiere
	 * @param nomMatiere the nomMatiere to set
	 */
	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}

	/**
	 * GETTER nomUV
	 * @return the nomUV
	 */
	public String getNomUV() {
		return nomUV;
	}

	/**
	 * SETTER nomUV
	 * @param nomUV the nomUV to set
	 */
	public void setNomUV(String nomUV) {
		this.nomUV = nomUV;
	}
	
	
	
	
}
