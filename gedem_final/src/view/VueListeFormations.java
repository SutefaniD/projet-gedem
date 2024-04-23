package view;

import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControleurFormation;

public class VueListeFormations extends JPanel {

	private DefaultTableModel modelF;
	private Object[] col;
	private JTable table;
	
	
	public VueListeFormations() throws Exception {
		try {	
			ControleurFormation cs = new ControleurFormation();
			try {
				// On récupère le nombre de colonnes de la table
				int colonnes = cs.getRsmd().getColumnCount();
				
				// On récupère les noms de colonnes de la table
				// pb: n'apparaissent pas dans JTable sans JScrollPane
				col = new Object[colonnes];
				for (int i = 0; i < colonnes; i++) {
					this.col[i] = cs.getRsmd().getColumnName(i+1);	
					//System.out.println(this.col[i]);
				}
				
				// Création d'une DefaultTableModel
				// On ne connait pas le nombre de lignes, donc 0
				modelF = new DefaultTableModel(col, 0);
				
				// Récupérer les données (cellules ou lignes) de la BD
				while (cs.getRs().next()) {
					
					Object[] data = new Object[colonnes];
					for (int i = 0; i < colonnes; i++) {
						data[i] = cs.getRs().getObject(i+1);				  
					}
					modelF.addRow(data);
				}
				
				this.table = new JTable(modelF);
				
				JScrollPane sc = new JScrollPane(table);
				table.setFillsViewportHeight(true);
				this.add(sc);
				
				// Autre méthode pour afficher enTetes colonnes
				//this.setLayout(new BorderLayout());
				//this.add(table.getTableHeader(), BorderLayout.NORTH);
				//this.add(table, BorderLayout.CENTER);	   
		    } finally {
		    	// Fermer le resultSet
		        if (cs.getRs() != null) {
		            try {
		                cs.getRs().close();
		            } catch (SQLException e) {
		                System.out.println("Erreur lors de la fermeture du resultSet");
		                e.printStackTrace();
		            }
		        }
		    }
		} catch (Exception e) {
        // Gérer l'exception localement
        e.printStackTrace();
		}
	}
}
