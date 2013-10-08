package pages;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import tools.Topping;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ConfirmUI extends JFrame{
	private JTextPane textPane;
	private MainPage mainP;
	private OrderUI orderP;
	private JTextField textField;
	private JTextField textField_1;
	public ConfirmUI(MainPage m, OrderUI orderUI){
		this.mainP = m;
		this.orderP = orderUI;
		setPreferredSize(new Dimension(700, 700));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		
		textPane = new JTextPane();
		
		JButton btnConfrim = new JButton("Confrim");
		btnConfrim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainP.getShop().sellB();
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmUI.this.setVisible(false);
				orderP.setVisible(true);
				textPane.setText("");
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmUI.this.setVisible(false);
				orderP.clearText();
				mainP.setVisible(true);
				textPane.setText("");
			}
		});
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(62)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnConfrim, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(textField)
							.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(73, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(198)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
					.addGap(64)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnConfrim, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
					.addGap(62))
		);
		getContentPane().setLayout(groupLayout);
		}

	public void showText(Object[] objects){                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
		for( Object i : objects){
			textPane.setText(textPane.getText()+((Topping)i).getName()+"\n");}
		textField.setText(mainP.getShop().getBurger().getPrice()+"");
	}
}