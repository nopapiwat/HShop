package pages;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditSaleUI extends JFrame {
	private JFrame mainP;
	private DefaultTableModel tableModel;
	private JPanel tablePanel;
	private JTable table;
	private JButton btnBack;
	
	public EditSaleUI(JFrame m) {
		mainP = m;
		createTablePanel();
		tableModel.addRow(new Object[] { "1", "cheese",
				"5",2 });
		tableModel.addRow(new Object[] { "2", "pork",
				"6",2 });
		
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
		getContentPane().add(tablePanel);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditSaleUI.this.setVisible(false);
				mainP.setVisible(true);
			}
		});
		GroupLayout gl_tablePanel = new GroupLayout(tablePanel);
		gl_tablePanel.setHorizontalGroup(
			gl_tablePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tablePanel.createSequentialGroup()
					.addGroup(gl_tablePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tablePanel.createSequentialGroup()
							.addGap(118)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_tablePanel.createSequentialGroup()
							.addGap(54)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(119, Short.MAX_VALUE))
		);
		gl_tablePanel.setVerticalGroup(
			gl_tablePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tablePanel.createSequentialGroup()
					.addGap(5)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addGap(73))
		);
		tablePanel.setLayout(gl_tablePanel);
	}
}
