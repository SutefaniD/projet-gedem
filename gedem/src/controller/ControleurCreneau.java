package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import model.Creneau;
import tools.ControlConnection;

public class ControleurCreneau {

	public class ControlCreneau {

		private String debutFormationStr;
		private String finFormationStr;
		private int cpt;
		private Date debutFormation;
		private Date finFormation;
		private Date heureDebutMat;
		private Date heureDebutAprem;
		boolean  doublons_cren_flag = false;
		private ControlConnection cc;



		// java.time --> année bissextile ? boolean isLeap = year.isLeap();

		//======================================== CONSTRUCTEUR 2
			public ControlCreneau(Date deb, Date fin) {
				this.debutFormation=deb;
				this.finFormation=fin;
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH);
				SimpleDateFormat sdf_SQL = new SimpleDateFormat("yyyy-MM-dd", Locale.FRENCH);

			}

		//======================================== CONSTRUCTEUR 3
		public ControlCreneau(String deb, String fin) throws ParseException {

		this.debutFormationStr=deb;
		this.finFormationStr=fin;

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDateTime date1 = LocalDate.parse(debutFormationStr, dtf).atStartOfDay(); // on formate date1 dd-MM-yyyy

		//LocalDateTime date1 = debutFormationStr.formatted(dtf);
		LocalDateTime date2 = LocalDate.parse(finFormationStr, dtf).atStartOfDay(); // on formate date2 dd-MM-yyyy
		System.out.print("\ndate1 (sans formatage): "+ date1); // test
		System.out.print("\tdate 1 : "+ date1.getDayOfMonth()+"/"+date1.getMonthValue()+"/"+date1.getYear()+"\t"); // test

		long daysBetween = Duration.between(date1, date2).toDays(); // calcul intervalle de temps (en jours)
		System.out.print ("daysBetween : " + daysBetween); // test
		int nbCreneaux = (int) daysBetween *2; // on double le nombre de creneaux (matin / aprem)
		System.out.println("\tnbCreneaux: "+nbCreneaux); // test

		ArrayList<Creneau>ligneCreneauAm = new ArrayList<>();
		ArrayList<Creneau>ligneCreneauPm = new ArrayList<>();
		cpt=1;
		for (int i=0; i<daysBetween && cpt<700; i++) {

				LocalDateTime nextCren_matin = date1.plusDays(i); // on crée une valeur de date pour chaque jour de la boucle
				LocalDateTime nextCren_aprem = date1.plusDays(i); // créneau matin puis après-midi
				// conversions pour l'insertion dans la BDD :
				java.sql.Date nextCren_matinSql = java.sql.Date.valueOf(nextCren_matin.toLocalDate());
				java.sql.Date nextCren_apremSql = java.sql.Date.valueOf(nextCren_aprem.toLocalDate());
				//System.out.println("sql date : "+nextCren_matinSql.toString());
				// 11/04/2023
				//DateTimeFormatter format1 = DateTimeFormatter.ofPattern("HH:mm");
				//java.sql.Time timeValue = new Time(Creneau.heureDebut_matin);
				// heureDebut_matin : format String, attribut de la classe creneau
				LocalTime heureDebutMat = LocalTime.parse((Creneau.heureDebut_matin));
				LocalTime heureFinMat = LocalTime.parse((Creneau.heureFin_matin));
				LocalTime heureDebutAprem = LocalTime.parse((Creneau.heureDebut_aprem));
				LocalTime heureFinAprem = LocalTime.parse((Creneau.heureFin_aprem));

				// vérification de la présence de créneaux dans la BDD pour empêcher les doublons. =============  DOUBLONS ?
				String req_verif_doublons="SELECT COUNT(dateCreneau) from creneau GROUP BY dateCreneau;";
				// la requete compte le nombre de dates de créneau identiques, qui doit être au maximum de 2 par jour. (matin, aprem)

				cc = ControlConnection.getInstance();

				try {
					ResultSet rs1 = cc.getSt().executeQuery(req_verif_doublons);
					// ArrayList pour ranger les comptages issus de la requête.
					ArrayList<Integer> doublons_cren = new ArrayList<>();


					while (rs1.next()) {
						//if (rs1.getInt(1)>2) {
						doublons_cren.add(rs1.getInt(1));
						System.out.println("boucle rs1 : "+String.valueOf(rs1.getInt(1))); // conv int -> String
						//}
					}
					for (i = 0; i<doublons_cren.size();i++) { // on parcourt l'ArrayList des doublons
						if (doublons_cren.get(i)>2) { // si il y a plus de 2 dates de creneau dans la liste
							doublons_cren_flag = true; // drapeau pour tester présence de doublons
							System.out.println("flag : detection presence de creneaux en double (>2)");
							cpt=700;// condition de sortie de boucle.
						}
					//else { doublons_cren_flag = false; }
					}

				} // Fin du "try"
				catch (SQLException e1) {
					System.out.println("Erreur au moment de la verif de doublons");
					e1.printStackTrace();
				}


				//==================== INSERTION ==============
				String requete1="INSERT INTO creneau (dateCreneau,heureDebut,heureFin,duree,am_pm)"
						+ " VALUES ('"+nextCren_matinSql+"','"+heureDebutMat+"','"+heureFinMat+"','"+Creneau.dureeStr+"',1);";
				String requete2="INSERT INTO creneau (dateCreneau,heureDebut,heureFin,duree,am_pm)"
						+ " VALUES ('"+nextCren_apremSql+"','"+heureDebutAprem+"','"+heureFinAprem+"','"+Creneau.dureeStr+"',2);";

				//ControlConnection cc = new ControlConnection();

				try {
					if (!doublons_cren_flag) { // exécution de la requête si absence de doublon
					cc.getSt().executeUpdate(requete1); // INSERTION CRENEAU MATIN
					}
					else {
						System.out.println("Dates de creneau en double : abandon.");

						// optionnel : rajouté pour vérifier l'état de la connexion / statement
							cc.deconnexionBd();
							if (cc != null ) {
								System.out.println("la connexion à la BDD n'est pas \"null\".");
							}
							if (!cc.getConn().isClosed()) {
							System.out.println("la connexion à la bdd n'est pas fermée.");
							}
						// fin rajout vérif connexion
					}
				} catch (SQLException e) {
					System.out.println("Erreur d'execution de la requete1, creneau");
					e.printStackTrace();
				}

				try {
					if (!doublons_cren_flag) { // exécution de la requête si absence de doublon
					cc.getSt().executeUpdate(requete2); // INSERTION CRENEAU APRES-MIDI
					}

				} catch (SQLException e) {
					System.out.println("ControlCreneau : Erreur d'execution de la requete2, creneau");
					e.printStackTrace();
				}


				// Listing des créneaux en cours de création
				System.out.println("Creneau "+cpt+" : " +nextCren_matin.format(dtf));
				cpt++;
				System.out.println("Creneau "+cpt+" : " +nextCren_aprem.format(dtf) );
				cpt++;
				this.supressDouble(); // Méthode supressDouble de la classe.

		} // fin de boucle for


	}


		// Méthode supression 2 lignes de créneau (en cas de doublon)
		public void supressDouble() {
			String reqCount = "SELECT COUNT(dateCreneau) AS cdc,dateCreneau FROM creneau GROUP BY dateCreneau HAVING cdc > 2;";
			//String delEnr = "DELETE "
			try {
				cc = ControlConnection.getInstance();
				ResultSet rs1 = cc.getSt().executeQuery(reqCount);
				ArrayList<Date> crenListSuppr = new ArrayList<>();
				while (rs1.next()) {
					crenListSuppr.add(rs1.getDate(2));
				}
				for (int i=0; i<crenListSuppr.size(); i++) {
					System.out.println("crenListSuppr : "+(i+1)+"\t"+crenListSuppr.get(i));

				}

			} catch (SQLException e) {
				System.out.println("Erreur connexion / statement, méthode supressDouble de ControlCreneau");
				e.printStackTrace();
			}

		}


		/*
		 * //================================== CONSTRUCTEUR1
		public Creneau() {

			System.out.println("CREATION DE CRENEAUX - PLANNING DE FORMATION");
			Scanner lecture = new Scanner(System.in);
			sop("Saisir une date pour le creneau (jj/MM/YYYY) :");
			// utilisation de la méthode java.util.Scanner next(Pattern pattern)
			// il faut indiquer un regex qui corresponde au pattern recherché
			// on boucle tant que cette condition n'a pas été remplie (tant que l'utilisateur n'a pas rentré la date avec
			// le bon format, comme jj/mm/AAAA
			// regex : [0-9]{1,2}\/[0-9]{1,2}\/\d{2,4}
			// soit : tout chiffre entre 0 et 9 (1 occurence mini, 2 au maximum) + symbole "/" + 1 ou 2 chiffres entre 0 et 9
			// + symbole "/" + un nombre (entre 2 et 4 caractères - pour l'année)
			String pattern = "[0-9]{1,2}\\/[0-9]{1,2}\\/\\d{2,4}";
			try {
			if(lecture.hasNext()){


				String[] patternSplit = lecture.next(pattern).split("/");	// on sépare la date saisie en 3 parties, on range le résultat dans un tableau.
				patternSplit[0] = patternSplit[0].length()<2 ? "0"+patternSplit[0] : patternSplit[0]; // on rajoute un 0 au jour si moins de 2 chiffres (opérateur ternaire)
				patternSplit[1] = patternSplit[1].length()<2 ? "0"+patternSplit[1] : patternSplit[1]; // idem pour le mois
				patternSplit[2] = patternSplit[0].length()<4 ? "20"+patternSplit[2] : patternSplit[2]; // on rajoute "20" devant l'année si elle fait moins de 4 caractères
				String dateCreneauStr = patternSplit[0]+"/"+patternSplit[1]+"/"+patternSplit[2];  // on déclare une chaine qui récupère la nouvelle valeur de dateCreneau

				try {
					Date dateCreneau = new SimpleDateFormat("dd/MM/yyyy").parse(dateCreneauStr); // fait une conversion de String vers Date
					this.dateCreneau = dateCreneau;
				}
				 catch (ParseException e) {
					sop("Erreur dans le traitement de la conversion String 2 date");
					e.printStackTrace();
				}
				 System.out.println();

			}

			}
			catch (NoSuchElementException e1) {
				sop("Erreur : pas d'element correspondant : mauvais format de saisie.");
				e1.printStackTrace();
			}
			catch (IllegalStateException e2) {
				sop("This exception is used to signal that a method is called at an illegal or inappropriate time.");
				e2.printStackTrace();
			}
			sop("Saisir une durée (par defaut : 3h30) : ");
			duree = lecture.next();
			if (duree == "") {
				this.duree = "3h30"; // si aucune donnée entrée > on met 3h30 par défaut.
			}

		}
		 */

}
}
