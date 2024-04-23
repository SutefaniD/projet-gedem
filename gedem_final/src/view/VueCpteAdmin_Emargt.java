package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueCpteAdmin_Emargt extends JPanel {
	private App app;
	private JLabel label;	
	private JPanel p;
	
	public VueCpteAdmin_Emargt(App app) {
		this.app = app;
		this.label = new JLabel();
		label.setText("Liste d'Emargement");
		label.setBounds(200, 150, 50, 50);
		
		
		
		this.setBackground(new Color(66, 245, 105));
		this.add(label);

		
	}

}
