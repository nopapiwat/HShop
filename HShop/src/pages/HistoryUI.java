package pages;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HistoryUI extends JFrame {
	
	private DefaultTableModel tableModel;
	private JPanel tablePanel;
	private JTable table;
	
	public HistoryUI() {
		
		createTablePanel();
		tableModel.addRow(new Object[] { 1,"00:00" ,"cheese+pork",
				"45.00" });
		
		tableModel.addRow(new Object[] { 2, "00:00","apple+paper",
		"30.00" });
		
		setVisible(true);
		setPreferredSize(new Dimension(700, 700));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}
	
	
	
	private void createTablePanel() {
		tablePanel = new JPanel();
		tableModel = new DefaultTableModel();
		tableModel.addColumn("No.");
		tableModel.addColumn("Time");
		tableModel.addColumn("Detail");
		tableModel.addColumn("Price");
		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		tablePanel.add(scrollPane);
		this.add(tablePanel);
	}
}
