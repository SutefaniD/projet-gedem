package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueCpteStagiaire_PlanningMensuel extends JPanel {
	private App app;
	private JLabel label;	
	private JPanel p;
	
	public VueCpteStagiaire_PlanningMensuel(App app) {
		this.app = app;
		this.label = new JLabel();
		label.setText("Planning");
		label.setBounds(200, 150, 50, 50);
		
		this.p = new JPanel();
		VueCalendrier vc = new VueCalendrier();
		p.add(vc);
		
		this.setBackground(new Color(66, 245, 105));
		this.add(label);
		this.add(p);
		
	}

}
