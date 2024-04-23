package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;

import model.Personne;
import tools.ControlConnection;
import view.App;
import view.VueCpteAdmin_CreationPersonne;

public class ControlFormPersonne {

    private Vector<String> vectorRole; // tableau qui liste les roles
    private ControlConnection cc;
    // private ViewFormPersonne vfp;
    private Personne pers;
    private ArrayList<Personne> al_personne;
    private String val1_role = "aucun"; // role sélectionné dans la JComboBox
    private String val1_roleBase; // correspond à nomRole de la table role
    private int val1;
    private String val2, val3, val4, val5 = "0", val6;
    private char[] val7;
    private String val7_str, val5new;
    private App appli;
    private VueCpteAdmin_CreationPersonne vfp;
    boolean flag_validation = true; // drapeau pour confirmer que le formulaire
				    // est ok avant insertion BDD
    boolean flag_al_personne = false;
    /**
     * CONSTRUCTEUR
     *
     * @param vfp
     * @param appli
     */
    public ControlFormPersonne(VueCpteAdmin_CreationPersonne vfp, App appli) {
	this.vfp = vfp;
	this.appli = appli;
	cc = ControlConnection.getInstance();

	if (!flag_al_personne)
	{ // On créer une liste seulement si elle n'existe pas déjà.

	    al_personne = new ArrayList<>();
	    flag_al_personne = true;
	}

	ajouterPersonne();

    }

    /**
     * METHODE ajouterPersonne;
     *
     * @param n
     * @param prenom
     */
    public void ajouterPersonne() {

	String val1_role = (String) vfp.getJc_role().getSelectedItem(); // recup
									// sélection
									// JComboBox

	System.out.println(
		"val1_role dans méthode ajouterPersonne() : " + val1_role);
	String val2 = vfp.getJt_nom().getText(); // nom
	String val3 = vfp.getJt_prenom().getText(); // prenom
	String val4 = vfp.getJt_mail().getText(); // mail
	String val5 = vfp.getJt_tel().getText(); // Tel
	String val6 = vfp.getJt_login().getText(); // login
	char[] val7 = vfp.getJt_pass().getPassword(); // password
	val7_str = new String(val7);
	System.out.println("char val7 2str (password) : " + val7_str); // Sysout
								       // du
								       // password
								       // pour
								       // test

	if (vfp.isFlag_btnf1())
	{ // si le bouton du formulaire a été actionné
	    System.out.println("Bouton actionne : " + vfp.isFlag_btnf1());
	    if (!val5.isEmpty())
	    { // si un Tel a été entré
		System.out.println("val5 empty ? : " + val5.isEmpty());
		if (val5.length() > 12)
		{ // contrôle de saisie num. de Téléphone
		    System.out.println(
			    "val5 > 12 - taille  ? : " + val5.length());
		    val5new = verifTel(val5); // appel à la méthode un peu plus
					      // bas.
		    // System.out.println("verifTel appelée - valeur de val5
		    // :"+val5);
		    // System.out.println("verifTel appelée - valeur de val5new
		    // :"+val5new);
		}
	    }
	}
	// val5=val5_v2;
	// System.out.println("2 - verifTel appelée - valeur de val5new
	// :"+val5new);

	switch (val1_role) { // pour faire correspondre la sélection du
			     // JCombobox avec le contenu de la BDD
	    case "Admin" :
		val1_roleBase = "Admin";
		break;
	    case "User" :
		val1_roleBase = "User";
		break;
	    case "Formateur" :
		val1_roleBase = "Formateur";
		break; // Pour Formateur >> Formateur (pas de changement)
	}

	String req_val1 = "SELECT idRole FROM role where nomRole='"
		+ val1_roleBase + "';";
	try
	{ // on recupere l'idRole (int) correspondant au rôle sélectionné dans
	  // la JComboBox.
	    ResultSet rs_val1 = cc.getSt().executeQuery(req_val1);
	    if (rs_val1.next())
	    { // si un enregistrement correspond
		this.val1 = rs_val1.getInt(1);
		System.out.println("Affectation de valeur pour val1 : " + val1);
	    } else
	    {
		System.out.println(
			"\tPas d'enregistrement correspondant pour val1.");
	    }
	    // else this.val1 = 3; // par défaut on considère que c'est un User
	    // (stagiaire)

	    // System.out.println("val1 ajouterPersonne() : "+val1);
	} catch (SQLException e)
	{

	    e.printStackTrace();
	    System.out.println(
		    "ControlFormPersonne : Erreur lors de la recuperation de idRole");
	}
	verifSelectionRole(); // fonction qui vérifie si un rôle a été
			      // selectionné.

	if (flag_validation)
	{ // si le formulaire a été correctement renseigné

	    String req = "INSERT INTO personne (idRole,nom,prenom,mail,tel,login,password)"
		    + " values (" + val1 + ",'" + val2 + "','" + val3 + "','"
		    + val4 + "','" + val5new + "','" + val6 + "','" + val7_str
		    + "');";
	    String req2 = "select * from personne where nom='" + val2 + "';";
	    try
	    {
		System.out.println("req :" + req);
		System.out.println("req2 :" + req2);
		cc.getSt().executeUpdate(req);

		ResultSet rsi = cc.getSt().executeQuery(req2); // insertion dans
							       // la BDD

		while (rsi.next())
		{ // on ajoute l'entrée dans l'ArrayList al_personne
		    al_personne.add(new Personne(val1, val2, val3, val4,
			    val5new, val6, val7_str, 0, 0));
		}

		for (Personne element : al_personne)
		{ // Affichage dans la console des enregistrements
		    System.out.println(element.toString());
		    // System.out.println("Retour de l'insertion :
		    // "+al_personne);

		}

	    } catch (SQLException e)
	    {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(
			"ControlFormPersonne : Erreur dans l'insertion du formulaire (ajouter personne)");
	    }
	    // Personne pers = new Personne();

	    if (!this.val1_role.equals("") && this.val1 > 3)
	    { // si idPersonne existe et est non nul
		System.out.println("val1 (idPersonne) : " + val1); // Affichage
								   // console
		String req_stagiaire = "INSERT INTO h_personne_stagiaire (idPersonne) VALUES ("
			+ val1 + ");";
		try
		{
		    cc.getSt().executeUpdate(req_stagiaire);
		} catch (SQLException e)
		{
		    System.out.println(
			    "ControlFormPersonne : problème pour l'insertion de l'idPersonne dans la table h_personne_stagiaire");
		    e.printStackTrace();
		}

	    }
	    System.out.println("\tInsertion effectuée dans la BDD");
	    vfp.setJmessageLabelColor("white");
	    vfp.setJmessageLabel("Profil enregistré dans la base.");
	} // Fin if (flag_validation)
	else
	{
	    System.out.println("flag_validation : " + flag_validation);
	}
	// Quelques LOGS console...
	System.out.println("val1_role : " + val1_role + "\tval2 : " + val2
		+ "\tval3 : " + val3);
    }

    // ===================== METHODE verifSelectionRole
    /**
     * vérifie que val1 existe, et donc que l'utilisateur a bien sélectionné une
     * valeur dans le champ de sélection -> soit Administratif, stagiaire ou
     * formateur
     *
     * @return
     */
    public void verifSelectionRole() {
	if (this.val1 > 0)
	{
	    vfp.setJmessageLabel(""); // on supprime un éventuel message
				      // d'erreur
	    System.out.println(
		    "Fonction verifSelectionRole : val1 existe et vaut : "
			    + val1);
	    vfp.setImage(new ImageIcon("./img/eleve2.png"));
	} else
	{
	    System.out.println(
		    "Fonction verifSelectionRole : val1 n'existe pas ou nomRole est vide.\t val1 : "
			    + val1);
	    flag_validation = false;

	    try
	    {
		vfp.setJmessageLabelColor("red");
		vfp.setJmessageLabel("Vous devez sélectionner un Rôle, svp.");
		vfp.setImage(new ImageIcon("./img/eleve2r.png"));

	    } catch (Exception e)
	    {
		System.out.println(
			"ControlFormPersonne : Fonction verifSelectionRole : erreur setJmessageLabel");
		e.printStackTrace();
	    }
	}
	System.out.println("flag_jc_role : " + vfp.isFlag_jc_role());
    }

    // ===================== METHODE verifTel
    /**
     * verifTel vérifie si le numéro de Tel entré par l'utilisateur ne dépasse
     * pas 12 caractères Si dépassement : on retire les caractères inutiles pour
     * ne conserver que les chiffres.
     * 
     * @return
     */
    public String verifTel(String tel) {
	String res_verifTel = tel; // prend la valeur entrée par l'utilisateur,
				   // par défaut.
	if (tel.length() > 12)
	{
	    String[] tabVal5 = tel.split("[^09]"); // on éclate la String en ne
						   // récupérant que les
						   // chiffres
	    System.out.println("Supressions des caractères inutiles");
	    for (String splitWord : tabVal5)
	    { // on parcourt chaque élément "splitWord" du tableau tabVal5
		res_verifTel += splitWord; // concaténation des chiffres du TEL
	    }
	    // si malgré tout le numéro dépasse 12 caractères : on récupère le
	    // début de la chaine.
	    if (res_verifTel.length() > 12)
	    {
		res_verifTel = res_verifTel.substring(0, 12);
		System.out.println("Reduction de la longueur du num. de Tel.");
	    }
	}
	return res_verifTel;

    }

    // ============================ ACCESSEURS
    public Vector<String> getVectorRole() {
	return vectorRole;
    }
    public void setVectorRole(Vector<String> vectorRole) {
	this.vectorRole = vectorRole;
    }

}
