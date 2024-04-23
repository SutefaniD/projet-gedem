package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import tools.ControlConnection;
import view.App;
import view.ViewConnection;
import view.VueCpteAdmin_Accueil_ListeFormations;
import view.VueCpteAdmin_CreationPersonne;
import view.VueCpteAdmin_Emargt;
import view.VueCpteAdmin_ListeFormateurs;
import view.VueCpteAdmin_ListePersonnes;
import view.VueCpteAdmin_ListeStagiaires;
import view.VueCpteAdmin_PlanningMensuel;
import view.VueCpteFormateur_Accueil_EmargtEnCours;
import view.VueCpteFormateur_EmargtMensuel;
import view.VueCpteFormateur_PlanningMensuel;
import view.VueCpteStagiaire_Accueil_EmargtEnCours;
import view.VueCpteStagiaire_EmargtMensuel;
import view.VueCpteStagiaire_PlanningMensuel;
import view.VuePage_MonCompte;

/**
 * ControleMenuBar appelle la barre de menu pour les comptes Stagiaire,
 * Formateur et Admin
 * 
 * @author steph
 *
 */
public class ControleMenuBar {

    private App app;
    private JMenuBar menuBar;
    private ControlConnection cc;
    private ControlLogin controlLogin;
    private String role;
    private JMenu menuPlanning;
    private JMenu menuEmargement;
    private JMenu menuCompte;
    private JMenu menuFormation;
    private JMenuItem menuItemEmargementEnCours;
    private JMenuItem menuItemEmargementMensuel;
    private JMenuItem menuItemEmargementFeuille;
    private JMenuItem menuItemPlanningMensuel;
    private JMenuItem menuItemCompte;
    private JMenuItem menuItemDeconnexion;
    private JMenuItem menuItemListeFormations;
    private JMenuItem menuItemListeFormateurs;
    private JMenuItem menuItemListeStagiaires;
    private JMenuItem menuItemListePersonnes;
    private JMenuItem menuItemAjouterPersonne;

    public ControleMenuBar(App app, String role, ControlLogin controlLogin) {
	this.app = app;
	this.role = role;
	this.controlLogin = controlLogin;
	this.menuBar = new JMenuBar();
	this.cc = ControlConnection.getInstance();

	configureMenu();
    }

    public void configureMenu() {
	// Code pour configurer le menu de la barre de menu en fonction du rôle

	// Il faut s'assurer de ne pas ajouter les menus à la barre de menu
	// plusieurs fois
	if (menuBar.getMenuCount() == 0)
	{
	    // ---- Création des menus communs ------------------------------
	    this.menuPlanning = new JMenu("Planning");
	    this.menuCompte = new JMenu("Mon compte");

	    // ---- Création des sous-menus communs
	    // ---------------------------------------------------
	    this.menuItemPlanningMensuel = new JMenuItem("Planning mensuel");
	    this.menuItemCompte = new JMenuItem("Gérer mon compte");
	    this.menuItemDeconnexion = new JMenuItem("Déconnexion");

	    // ---- Associer un ActionListener aux sous-menus
	    // ------------------------------
	    // Item "Planning mensuel"
	    this.menuItemPlanningMensuel
		    .addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			    // Réouvrir les ressources avant de changer le
			    // contenu de l'application
			    // controlLogin.reopenResources();
			    app.getContentPane().removeAll();
			    if (role.equals("User"))
			    {
				app.setContentPane(
					new VueCpteStagiaire_PlanningMensuel(
						app));
				// controlLogin.switchToStagiaireView(app);
			    } else if (role.equals("Formateur"))
			    {
				app.setContentPane(
					new VueCpteFormateur_PlanningMensuel(
						app));
				// controlLogin.switchToFormateurView(app);
			    } else if (role.equals("Admin"))
			    {
				app.setContentPane(
					new VueCpteAdmin_PlanningMensuel(app));
				// controlLogin.switchToAdminView(app);
			    }
			    // app.removeAll();
			    app.getContentPane().repaint();
			    app.getContentPane().revalidate();
			}
		    });

	    // Item "Gérer mon compte"
	    this.menuItemCompte.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		    // Réouvrir les ressources avant de changer le contenu de
		    // l'application
		    app.getContentPane().removeAll();
		    controlLogin.reopenResources();
		    app.setContentPane(new VuePage_MonCompte(app));
		    app.getContentPane().repaint();
		    app.getContentPane().revalidate();
		}
	    });

	    // Item "Déconnexion"
	    this.menuItemDeconnexion.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		    // Réouvrir les ressources avant de changer le contenu de
		    // l'application
		    controlLogin.reopenResources();
		    deconnexion();
		}
	    });

	    // ---- Ajouter les sous-menus aux menus communs ----------
	    this.menuPlanning.add(menuItemPlanningMensuel);
	    this.menuCompte.add(menuItemCompte);
	    this.menuCompte.add(menuItemDeconnexion);

	    // ---- Menu "Emargement" --------------------------------
	    this.menuEmargement = new JMenu("Emargement");

	    // Ajouter les sous-menus correspondants en fonction du rôle
	    if (role.equals("User") || role.equals("Formateur"))
	    {
		this.menuItemEmargementEnCours = new JMenuItem(
			"Emargement à faire");
		this.menuItemEmargementMensuel = new JMenuItem(
			"Feuille d'émargement mensuel");

		this.menuItemEmargementEnCours
			.addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
				app.getContentPane().removeAll();
				// Réouvrir les ressources avant de changer le
				// contenu de l'application
				// controlLogin.reopenResources();

				if (role.equals("User"))
				{
				    app.setContentPane(
					    new VueCpteStagiaire_Accueil_EmargtEnCours(
						    app));
				    // controlLogin.switchToStagiaireView(app);
				} else if (role.equals("Formateur"))
				{
				    app.setContentPane(
					    new VueCpteFormateur_Accueil_EmargtEnCours(
						    app));
				    // controlLogin.switchToFormateurView(app);
				}
				app.getContentPane().repaint();
				app.getContentPane().revalidate();
			    }
			});

		this.menuItemEmargementMensuel
			.addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
				// Réouvrir les ressources avant de changer le
				// contenu de l'application
				// controlLogin.reopenResources();
				app.getContentPane().removeAll();
				if (role.equals("User"))
				{
				    app.setContentPane(
					    new VueCpteStagiaire_EmargtMensuel(
						    app));
				    // controlLogin.switchToStagiaireView(app);
				} else if (role.equals("Formateur"))
				{
				    app.setContentPane(
					    new VueCpteFormateur_EmargtMensuel(
						    app));
				    // controlLogin.switchToFormateurView(app);
				}
				app.getContentPane().repaint();
				app.getContentPane().revalidate();
			    }
			});

		this.menuEmargement.add(menuItemEmargementEnCours);
		this.menuEmargement.add(menuItemEmargementMensuel);

	    } else if (role.equals("Admin"))
	    {
		this.menuItemEmargementFeuille = new JMenuItem("Emargement");
		this.menuItemEmargementFeuille
			.addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
				// Réouvrir les ressources avant de changer le
				// contenu de l'application
				// controlLogin.reopenResources();
				app.getContentPane().removeAll();
				app.setContentPane(
					new VueCpteAdmin_Emargt(app));
				// controlLogin.switchToAdminView(app);
				app.getContentPane().repaint();
				app.getContentPane().revalidate();
			    }
			});
		this.menuEmargement.add(menuItemEmargementFeuille);
	    }
	    this.menuBar.add(menuEmargement);

	    // Menu "Formations" (pour le compte "Admin")
	    if (this.role.equals("Admin"))
	    {
		this.menuFormation = new JMenu("Formations");
		// Ajouter les sous-menus spécifiques à "Formations"
		this.menuItemListeFormations = new JMenuItem(
			"Liste des formations");
		this.menuItemListeFormations
			.addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
				// Réouvrir les ressources avant de changer le
				// contenu de l'application
				// controlLogin.reopenResources();
				app.getContentPane().removeAll();
				// Action à effectuer lorsque le sous-menu
				// "Liste des formations" est sélectionné
				app.setContentPane(
					new VueCpteAdmin_Accueil_ListeFormations(
						app));
				app.getContentPane().repaint();
				app.getContentPane().revalidate();
			    }
			});
		this.menuFormation.add(menuItemListeFormations);

		this.menuItemListeFormateurs = new JMenuItem(
			"Liste des Formateurs");
		this.menuItemListeFormateurs
			.addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
				// Réouvrir les ressources avant de changer le
				// contenu de l'application
				// controlLogin.reopenResources();
				app.getContentPane().removeAll();
				// Action à effectuer lorsque le sous-menu
				// "Liste des formateurs" est sélectionné
				app.setContentPane(
					new VueCpteAdmin_ListeFormateurs(app));
				app.getContentPane().repaint();
				app.getContentPane().revalidate();
			    }
			});
		this.menuFormation.add(menuItemListeFormateurs);

		this.menuItemListeStagiaires = new JMenuItem(
			"Liste des Stagiaires");
		this.menuItemListeStagiaires
			.addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
				// Réouvrir les ressources avant de changer le
				// contenu de l'application
				// controlLogin.reopenResources();
				app.getContentPane().removeAll();
				// Action à effectuer lorsque le sous-menu
				// "Liste des Stagiaires" est sélectionné
				app.setContentPane(
					new VueCpteAdmin_ListeStagiaires(app));
				app.getContentPane().repaint();
				app.getContentPane().revalidate();
			    }
			});
		this.menuFormation.add(menuItemListeStagiaires);

		this.menuItemListePersonnes = new JMenuItem(
			"Liste des Personnes");
		this.menuItemListePersonnes
			.addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
				// Réouvrir les ressources avant de changer le
				// contenu de l'application
				// controlLogin.reopenResources();
				app.getContentPane().removeAll();
				// Action à effectuer lorsque le sous-menu
				// "Liste des Personnes" est sélectionné
				app.setContentPane(
					new VueCpteAdmin_ListePersonnes());
				app.getContentPane().repaint();
				app.getContentPane().revalidate();
			    }
			});
		this.menuFormation.add(menuItemListePersonnes);

		this.menuItemAjouterPersonne = new JMenuItem(
			"Créer des Personnes");
		this.menuItemAjouterPersonne
			.addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
				// Réouvrir les ressources avant de changer le
				// contenu de l'application
				// controlLogin.reopenResources();
				app.getContentPane().removeAll();
				// Action à effectuer lorsque le sous-menu
				// "Liste des Personnes" est sélectionné
				app.setContentPane(
					new VueCpteAdmin_CreationPersonne(app));
				app.getContentPane().repaint();
				app.getContentPane().revalidate();
			    }
			});
		this.menuFormation.add(menuItemAjouterPersonne);

		// Ajouter le menu "Formations" à la barre de menu
		menuBar.add(menuFormation);

	    }

	    // ---- Ajouter les menus à la barre de menu
	    // --------------------------------------
	    this.menuBar.add(menuPlanning);
	    this.menuBar.add(menuEmargement);
	    this.menuBar.add(menuCompte);

	    // Rafraîchir l'affichage de la barre de menu
	    app.setJMenuBar(menuBar);
	}

    }

    private void deconnexion() {
	// Déconnecter de la base de données
	controlLogin = null;

	// Supprimer la barre de menu
	app.setJMenuBar(null);

	// Afficher la page de connexion sans barre de menu
	app.setContentPane(new ViewConnection(app));
	app.validate();

	// Réinitialiser l'application
	app.reset();

	// Réinitialiser la vue de connexion
	controlLogin.reinitialiserVueConnection();

    }

}
