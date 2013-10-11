package pages;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import tools.Burger;
import tools.HShop;
import tools.Topping;

public class HistoryUI extends JFrame {
	private JFrame mainP;
	private DefaultTableModel tableModel;
	private JPanel tablePanel;
	private JTable table;
	private JButton btnBack;
	
	public HistoryUI(JFrame m) {
		this.mainP = m;
		createTablePanel();
		
		final HShop shop = ((MainPage) mainP).getShop();
		List<Burger> list = shop.getHis();
		
		Action delete = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				JTable table = (JTable)e.getSource();
				int modelRow = Integer.valueOf( e.getActionCommand() );
//				System.out.println("delete " + modelRow);
				((DefaultTableModel)table.getModel()).removeRow(modelRow);
				shop.getHis().remove(modelRow);
			}
		};
		
		int no = 1;
		for (Burger b : list) {
			StringBuilder toppings = new StringBuilder();
			for (Topping t : b.getDetail()) {
				toppings.append(t.getName()).append(", ");
			}
			tableModel.addRow(new Object[] {no++,
					aZ(b.getTime().getHours()) + ":" +  aZ(b.getTime().getMinutes()) + ":"+  aZ(b.getTime().getSeconds()) , toppings.substring(0, toppings.length()-2),
					b.getPrice(),new ButtonColumn(table,delete,4)});
		}
//		table.setEnabled(false);

		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(220);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		table.getColumnModel().getColumn(4).setPreferredWidth(20);
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
		tableModel.addColumn("x");
	
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
	
	private String aZ(int x) {
		return (x<10)? "0"+x : x+"";
	}
}
