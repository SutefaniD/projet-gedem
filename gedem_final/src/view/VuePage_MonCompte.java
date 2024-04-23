package view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class VuePage_MonCompte extends JPanel {
	private App app;
	private JLabel label;
	
	public VuePage_MonCompte(App app) {
		this.app = app;
		this.label = new JLabel();
		label.setText("Mon Compte");
		this.setBackground(new Color(81, 152, 207));
		label.setBounds(200, 150, 50, 50);
		this.add(label);
		
	}

}
