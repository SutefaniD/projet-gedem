package view;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class VuePage_EmargtMensuel extends JPanel {

	private JLabel label;
	
	public VuePage_EmargtMensuel() {
		
		this.label = new JLabel();
		this.label.setText("Feuille d'émargement mensuelle");
		this.label.setBounds(200, 150, 50, 50);
		this.add(label);
	}
}
