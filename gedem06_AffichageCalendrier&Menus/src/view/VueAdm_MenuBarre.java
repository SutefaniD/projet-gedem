package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import controller.ControleMenu_Compte;
import controller.ControleMenu_Emargt;
import controller.ControleMenu_Formation;
import controller.ControleMenu_Planning;

public class VueAdm_MenuBarre extends JMenuBar implements ActionListener {

	private JMenu formation_menu;
	private JMenu planning_menu;
	private JMenu emargt_menu;
	private JMenu compte_menu;
	private JMenu choixFormation_menu;

	private JMenuItem listeFormations_item;
	private JMenuItem listeFormateurs_item;
	private JMenuItem listeStagiaires_item;
	private JMenuItem listeAdmin_item;
	private JMenuItem vueMensuelle_item;
	private JMenuItem creerPlanning_item;
	private JMenuItem vueEmargt_item;
	private JMenuItem vueEmargtGlobale_item;
	private JMenuItem mesInfos_item;
	private JMenuItem deconnecter_item;	

	
	private int var1;
	
	
	/*
	 * Constructur VueMenuBarre
	 */
	public VueAdm_MenuBarre(App app)  {
		
		
	// ---- Création d'un menu (attributs et instance) ------------------------------
		this.formation_menu = new JMenu("Formations");	
	// ---- Création des sous-menus ---------------------------------------------------
		this.listeFormations_item = new JMenuItem("Liste des formations");
		this.listeFormateurs_item = new JMenuItem("Liste des formateurs");
		this.listeStagiaires_item = new JMenuItem("Liste des stagiaires");
		this.listeAdmin_item = new JMenuItem("Liste des personnes");	
	// ---- Faire apparaître les menus (ajouter les menus à la menubar) -----------------
		this.add(formation_menu);
	// ---- Faire apparaître les sous-menus (ajouter les sous-menus aux menus) ----------
		this.formation_menu.add(listeFormations_item);
		this.formation_menu.add(listeFormateurs_item);
		this.formation_menu.add(listeStagiaires_item);
		this.formation_menu.add(listeAdmin_item);

	// Menu Planning ---------------------------------------------------------------------
		this.planning_menu = new JMenu("Planning");	
		this.vueMensuelle_item = new JMenuItem("Planning mensuel");
		this.creerPlanning_item = new JMenuItem("Creer/Modifier Planning");
		this.add(planning_menu);
		this.planning_menu.add(vueMensuelle_item);
		this.planning_menu.add(creerPlanning_item);
		
	// Menu Emargement --------------------------------------------------------------------
		this.emargt_menu = new JMenu("Emargement");
		this.vueEmargt_item = new JMenuItem("Emargement");
		this.vueEmargtGlobale_item = new JMenuItem("Emargement Formation");
		this.add(emargt_menu);
		this.emargt_menu.add(vueEmargt_item);
		this.emargt_menu.add(vueEmargtGlobale_item);
		
	// Menu Mon Compte --------------------------------------------------------------------		
		this.compte_menu = new JMenu("Mon compte");
		this.mesInfos_item= new JMenuItem("Mes Infos");
		this.deconnecter_item = new JMenuItem("Déconnexion");
		this.add(compte_menu);
		this.compte_menu.add(mesInfos_item);
		this.compte_menu.add(deconnecter_item);
		
	// Choix Formation --------------------------------------------------------------------	
		this.choixFormation_menu = new JMenu("Nom Formation");
		this.add(choixFormation_menu);
	
		
// ----- Chaque menu doit répondre à MenuListener ----------------------------------------------
		this.formation_menu.addMenuListener(new MenuListener() {			
			@Override
			public void menuSelected(MenuEvent e) {
				new ControleMenu_Formation(app); 				
			}

			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
			
		
		this.planning_menu.addMenuListener(new MenuListener() {			
			@Override
			public void menuSelected(MenuEvent e) {
				new ControleMenu_Planning(app); 				
			}
			
			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		this.compte_menu.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				new ControleMenu_Compte(app);
				
			}
			
			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
// ---- ActionListener : voir les sous-menus quand on clique sur menu ---------------
		this.emgEnCours_item.addActionListener(new ActionListener() {
			
			@Override
			/**
			 * actionPerformed
			 * clic sur sous-menu = direction page correspondante
			 */
			public void actionPerformed(ActionEvent e) {
				// obtenir la source de l'action à faire
				if (e.getSource() == emgEnCours_item) {
					// définir l'action à faire : faire appel au contrôleur
					// System.out.println("Vous avez cliqué sur le sous-menu Emargement À faire");
					var1 = 1;
					new ControleMenu_Emargt(app, var1);
				
				}
			}
		});
		
		
		this.emgMensuel_item.addActionListener(new ActionListener() {
			/*
			 * actionPerformed
			 * clic sur sous-menu = direction page correspondante
			 */
			public void actionPerformed(ActionEvent evt2) {
				if (evt2.getSource() == emgMensuel_item) {
					System.out.println("Vous avez cliqué sur le sous-menu Feuille d'émargement mensuelle");	
					var1 = 2;
					new ControleMenu_Emargt(app, var1);
				}
			}
		});		
	}
	
	/**
	 * GETTER var1
	 * @return var1
	 */
	public int getVar1() {
		return var1;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}	
}
