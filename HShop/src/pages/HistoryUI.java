package pages;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HistoryUI extends JFrame {
	private JFrame mainP;
	private DefaultTableModel tableModel;
	private JPanel tablePanel;
	private JTable table;
	private JButton btnBack;
	
	public HistoryUI(JFrame m) {
		this.mainP = m;
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
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistoryUI.this.setVisible(false);
				mainP.setVisible(true);
			}
		});
		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tablePanel, GroupLayout.PREFERRED_SIZE, 690, GroupLayout.PREFERRED_SIZE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tablePanel, GroupLayout.PREFERRED_SIZE, 670, GroupLayout.PREFERRED_SIZE)
		);
		GroupLayout gl_tablePanel = new GroupLayout(tablePanel);
		gl_tablePanel.setHorizontalGroup(
			gl_tablePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tablePanel.createSequentialGroup()
					.addGroup(gl_tablePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tablePanel.createSequentialGroup()
							.addGap(154)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_tablePanel.createSequentialGroup()
							.addGap(55)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(83, Short.MAX_VALUE))
		);
		gl_tablePanel.setVerticalGroup(
			gl_tablePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tablePanel.createSequentialGroup()
					.addGap(5)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(78))
		);
		tablePanel.setLayout(gl_tablePanel);
		getContentPane().setLayout(groupLayout);
	}
}
