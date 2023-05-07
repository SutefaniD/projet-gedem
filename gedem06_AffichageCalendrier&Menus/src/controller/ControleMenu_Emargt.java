
package controller;

import view.App;
import view.VuePage_EmargtEnCours;
import view.VuePage_EmargtMensuel;

public class ControleMenu_Emargt {
	
	// Constructeur pour Afficher page Emargement
	public ControleMenu_Emargt (App app, int var1) {
		
		
		// var1 = 1 : emgEnCours_item
		// var1 = 2 : emgMensuel_item
		switch(var1) {
			case 1: 
				app.getContentPane().removeAll();
				app.getContentPane().add(new VuePage_EmargtEnCours());	
				app.getContentPane().repaint();		
				app.getContentPane().revalidate();
				break;
			
			case 2:
				app.getContentPane().removeAll();
				app.getContentPane().add(new VuePage_EmargtMensuel());	
				app.getContentPane().repaint();		
				app.getContentPane().revalidate();
				break;
				
			default:
				break;
				
		}
		
	}
	
}
