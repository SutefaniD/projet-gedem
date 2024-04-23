package model;

import java.util.Date;

// idFormation- nomFormation - dateDebut - dateFin
public class Formation {
	
	private int idFormation;
	private String nomFormation;
	private Date dateDebut;
	private Date dateFin;
	
	public Formation(int id, String nom, Date debut, Date fin) {
		this.idFormation = id;
		this.nomFormation = nom;
		this.dateDebut = debut;
		this.dateFin = fin;
	}

	/**
	 * @return the idFormation
	 */
	public int getIdFormation() {
		return idFormation;
	}

	/**
	 * @param idFormation the idFormation to set
	 */
	public void setIdFormation(int idFormation) {
		this.idFormation = idFormation;
	}

	/**
	 * @return the nomFormation
	 */
	public String getNomFormation() {
		return nomFormation;
	}

	/**
	 * @param nomFormation the nomFormation to set
	 */
	public void setNomFormation(String nomFormation) {
		this.nomFormation = nomFormation;
	}

	/**
	 * @return the dateDebut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	// Methode sans id
	public Formation(String nom, Date debut, Date fin) {
		this.nomFormation = nom;
		this.dateDebut = debut;
		this.dateFin = fin;
	}

}
