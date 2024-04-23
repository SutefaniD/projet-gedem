package view;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

import controller.ControlLogin;
import controller.ControleMenuBar;

public class App extends JFrame {

    private Dimension screenSize;
    private JMenuBar menuBar;

    public App() {
	// Initialisation de l'instance de App sans paramètres
    }

    public App(String str) {

	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	this.setSize(screenSize.width, screenSize.height);
	this.setResizable(false);
	this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	this.setTitle("Page de Connexion à GEDEM");
	this.setLocationRelativeTo(null);
	this.centre(); // centrage de la JFrame, après le pacck()
	this.setVisible(true);

	this.menuBar = new JMenuBar();
	this.setJMenuBar(menuBar);

    }

    public void centre() {

	Dimension windowsSize = this.getSize();
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int x = (screenSize.width - windowsSize.width) / 2;
	int y = (screenSize.height - windowsSize.height) / 2;
	this.setLocation(x, y);
    }

    public void reset() {
	// Réinitialiser l'état de l'application
	// Quand un utilisateur se déconnecte, un autre peut se connecter
	// sans avoir besoin de fermer et relancer l'appli
	setJMenuBar(null);
	setContentPane(new ViewConnection(this));
	validate();
    }

    // ----------- MAIN
    // --------------------------------------------------------------------------------------

    public static void main(String[] args) {

	// instanciation de la JFrame
	App appli = new App("GEDEM");

	// Instanciation de la vue de connexion
	ViewConnection cn = new ViewConnection(appli); // appli en paramètre de
						       // l'instance de
						       // ViewConnexion (vue)

	// Ajout de la vue de connexion au conteneur de l'application
	appli.getContentPane().add(cn);

	// appli.pack(); // la taille de la fenetre s'adapte au contenu
	appli.centre(); // centrage de la JFrame, après le pacck()
	appli.setVisible(true);

    }

}
