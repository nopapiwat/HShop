package pages;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import tools.HShop;
import tools.Topping;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class SettingUI extends JFrame {
	private JFrame mainP;
	private DefaultTableModel tableModel;
	private JPanel tablePanel;
	private JTable table;
	private JButton btnBack;
	
	private List<Topping> list;
	
	public SettingUI(JFrame m) {
		mainP = m;
		createTablePanel();
		HShop shop = ((MainPage) mainP).getShop();
		list = shop.getMenu();
		
		for (Topping b : list) {
			tableModel.addRow(new Object[] {b.getName() , b.getValue()});
		}
		
		setPreferredSize(new Dimension(700, 700));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}
	
	
	private void createTablePanel() {
		tablePanel = new JPanel();
		tableModel = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int col) {
			     switch (col) {
			         case 1:
			             return true;
			         default:
			             return false;
			      }
			}
		};
		tableModel.addColumn("Topping");
		tableModel.addColumn("Value");

		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(tablePanel);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < list.size(); i++)
					((Topping)list.get(i)).setValue(1.0*(Double)(table.getValueAt(i, 1)));
				SettingUI.this.setVisible(false);
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
