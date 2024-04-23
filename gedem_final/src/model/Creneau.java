package model;

import java.util.ArrayList;
import java.util.Date;

public class Creneau {
	
	private int idCreneau, idMatiere;
	private Date dateCreneau;
	private int am_pm;
	private String heureDebut;
	private String heureFin;
	private Date duree;
	private ArrayList<Creneau> listeCreneau;
	public static String dureeStr = "03:30";
	public static String heureDebut_matin = "08:30";
	public static String heureFin_matin = "12:00";
	public static String heureDebut_aprem = "13:30";
	public static String heureFin_aprem = "17:00";
	

	public Creneau(Date dateCreneau, String heureDebut, String heureFin, Date duree) {
		this.dateCreneau = dateCreneau;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.duree = duree;
		this.listeCreneau = new ArrayList<>();
	}
	
	public int getIdCreneau() {
		return idCreneau;
	}

	public void setIdCreneau(int idCreneau) {
		this.idCreneau = idCreneau;
	}

	public int getIdMatiere() {
		return idMatiere;
	}

	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}

	public Date getDateCreneau() {
		return dateCreneau;
	}

	public void setDateCreneau(Date dateCreneau) {
		this.dateCreneau = dateCreneau;
	}

	public int getAm_pm() {
		return am_pm;
	}

	public void setAm_pm(int am_pm) {
		this.am_pm = am_pm;
	}

	public String getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}

	public String getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}

	public Date getDuree() {
		return duree;
	}

	public void setDuree(Date duree) {
		this.duree = duree;
	}
	
	
}
