package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import controller.ControleMenu_Compte;
import controller.ControleMenu_Emargt;
import controller.ControleMenu_Planning;

// TO DO: Ajouter 
public class VueStg_MenuBarre extends JMenuBar implements ActionListener {

	
	private JMenu planning_menu;
	private JMenu emargt_menu;
	private JMenu compte_menu;

	private JMenuItem emgEnCours_item;
	private JMenuItem emgMensuel_item;
	
	private int var1;
	
	
	/*
	 * Constructur VueMenuBarre
	 */
	public VueStg_MenuBarre(App app)  {
		
		
		// ---- Création d'un menu (attributs et instance) ------------------------------
				this.planning_menu = new JMenu("Planning");
				this.emargt_menu = new JMenu("Emargement");
				this.compte_menu = new JMenu("Mon compte");
				
		// ---- Création des sous-menus ---------------------------------------------------
				this.emgEnCours_item = new JMenuItem("Emargement à faire");
				this.emgMensuel_item = new JMenuItem("Feuille d'émargement mensuel");

		// ---- Faire apparaître les menus (ajouter les menus à la menubar) -----------------
				this.add(planning_menu);
				this.add(emargt_menu); 
				this.add(compte_menu);
						
		// ---- Faire apparaître les sous-menus (ajouter les sous-menus aux menus) ----------
				this.emargt_menu.add(emgEnCours_item);
				this.emargt_menu.add(emgMensuel_item);

		// ----- Chaque menu doit répondre à MenuListener -----------------------------------
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
