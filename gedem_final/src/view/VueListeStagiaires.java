package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.ControleurStagiaire;

public class VueListeStagiaires extends JPanel {
	
	private DefaultTableModel model;

	private Object[] col;

	private JTable table;
	
	
	public VueListeStagiaires() throws Exception {
			
			ControleurStagiaire cs = new ControleurStagiaire();
			
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
			model = new DefaultTableModel(col, 0);
			
			// Récupérer les données (cellules ou lignes) de la BD
			while (cs.getRs().next()) {
				
				Object[] data = new Object[colonnes];
				for (int i = 0; i < colonnes; i++) {
					data[i] = cs.getRs().getObject(i+1);
				  
				}
				model.addRow(data);

			}
			
			this.table = new JTable(model);
			
			JScrollPane scp = new JScrollPane(table);
			table.setFillsViewportHeight(true);
			this.add(scp);
			
			
			// Autre méthode pour afficher enTetes colonnes
			//this.setLayout(new BorderLayout());
			//this.add(table.getTableHeader(), BorderLayout.NORTH);
			//this.add(table, BorderLayout.CENTER);
			
			
		}
	

	}
