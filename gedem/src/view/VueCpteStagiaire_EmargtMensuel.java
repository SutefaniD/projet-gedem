package view;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueCpteStagiaire_EmargtMensuel extends JPanel {
	private App app;
	private JLabel label;	
	
	public VueCpteStagiaire_EmargtMensuel(App app) {
		this.app = app;
		this.label = new JLabel();
		this.label.setText("Feuille d'émargement mensuelle");
		this.label.setBounds(200, 150, 50, 50);
		this.add(label);
	}
}
