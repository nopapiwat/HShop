package pages;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EditSaleUI extends JFrame {
	
	private DefaultTableModel tableModel;
	private JPanel tablePanel;
	private JTable table;
	
	public EditSaleUI() {
		
		createTablePanel();
		tableModel.addRow(new Object[] { "1", "cheese",
				"5",2 });
		tableModel.addRow(new Object[] { "2", "pork",
				"6",2 });
		
		
		setVisible(true);
		setPreferredSize(new Dimension(700, 700));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}
	
	
	private void createTablePanel() {
		tablePanel = new JPanel();
		tableModel = new DefaultTableModel();
		tableModel.addColumn("No.");
		tableModel.addColumn("Topping");
		tableModel.addColumn("Price");
		tableModel.addColumn("Amount");
		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		tablePanel.add(scrollPane);
		this.add(tablePanel);
	}
}
