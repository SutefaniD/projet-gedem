package view;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;


public class App extends JFrame{

	//private App appli;
	//private Dimension dim;
	
	
	public App(String str) {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize.width,screenSize.height);
		this.setResizable(false);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		this.setTitle("Page de Connexion à GEDEM");
		
		this.setLocationRelativeTo(null);

		this.centre(); // centrage de la JFrame, après le pacck()
		this.setVisible(true);
		
	}
	

	public void centre() {
		
        Dimension windowsSize = this.getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - windowsSize.width) / 2;
        int y = (screenSize.height- windowsSize.height)/ 2;
        this.setLocation(x, y); 
    }


//----------- MAIN --------------------------------------------------------------------------------------

	public static void main(String[] args) {

		// instanciation de la JFrame
		App appli = new App("GEDEM");
				
		ViewConnection cn = new ViewConnection(appli); // appli en paramètre de l'instance de ViewConnexion (vue)
		
		appli.getContentPane().add(cn);
		
		//appli.pack(); // la taille de la fenetre s'adapte au contenu
		appli.centre(); // centrage de la JFrame, après le pacck()
		appli.setVisible(true);
		
		
	}

	
    
}
