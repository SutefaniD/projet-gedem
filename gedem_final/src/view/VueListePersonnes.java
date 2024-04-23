package view;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.ControleurPersonne;
import controller.ControleurStagiaire;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Vector;

import tools.ControlConnection;

public class VueListePersonnes extends JPanel {
	
	private DefaultTableModel model;

	private Object[] col;

	private JTable table;
	
	
	public VueListePersonnes() throws Exception {
			
			ControleurPersonne cp = new ControleurPersonne();
			
			// On récupère le nombre de colonnes de la table
			int colonnes = cp.getRsmd().getColumnCount();
			
			// On récupère les noms de colonnes de la table
			// pb: n'apparaissent pas dans JTable sans JScrollPane
			col = new Object[colonnes];
			for (int i = 0; i < colonnes; i++) {
				this.col[i] = cp.getRsmd().getColumnName(i+1);	
				//System.out.println(this.col[i]);
			}
			
			// Création d'une DefaultTableModel
			// On ne connait pas le nombre de lignes, donc 0
			model = new DefaultTableModel(col, 0);
			
			// Récupérer les données (cellules ou lignes) de la BD
			while (cp.getRs().next()) {
				
				Object[] data = new Object[colonnes];
				for (int i = 0; i < colonnes; i++) {
					data[i] = cp.getRs().getObject(i+1);
				  
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
