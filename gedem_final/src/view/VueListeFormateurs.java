package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControleurFormateur;

public class VueListeFormateurs extends JPanel {

	private DefaultTableModel model;
	private Object[] col;
	private JTable table;
	private ControleurFormateur cf;
	
	public VueListeFormateurs() throws Exception {
			
			this.cf = new ControleurFormateur();
			
			// On récupère le nombre de colonnes de la table
			int colonnes = cf.getRsmd().getColumnCount();
			
			// On récupère les noms de colonnes de la table
			// pb: n'apparaissent pas dans JTable sans JScrollPane
			col = new Object[colonnes];
			for (int i = 0; i < colonnes; i++) {
				this.col[i] = cf.getRsmd().getColumnName(i+1);	
				//System.out.println(this.col[i]);
			}
			
			// Création d'une DefaultTableModel
			// On ne connait pas le nombre de lignes, donc 0
			model = new DefaultTableModel(col, 0);
			
			// Récupérer les données (cellules ou lignes) de la BD
			while (cf.getRs().next()) {
				
				Object[] data = new Object[colonnes];
				for (int i = 0; i < colonnes; i++) {
					data[i] = cf.getRs().getObject(i+1);
				  
				}
				model.addRow(data);

			}
			
			this.table = new JTable(model);
			
			JScrollPane jScp = new JScrollPane(table);
			table.setFillsViewportHeight(true);
			this.add(jScp);
			
		}	

}
