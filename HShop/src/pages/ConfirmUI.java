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
import javax.swing.SwingConstants;

public class ConfirmUI extends JFrame{
	private JTextPane textPane;
	private MainPage mainP;
	private OrderUI orderP;
	private JTextField textField;
	public ConfirmUI(MainPage m, OrderUI orderUI){
		this.mainP = m;
		this.orderP = orderUI;
		setPreferredSize(new Dimension(700, 700));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		
		JButton btnConfrim = new JButton("Confrim");
		btnConfrim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainP.getShop().sellB();
				ConfirmUI.this.setVisible(false);
				mainP.setVisible(true);
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
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmUI.this.setVisible(false);
				orderP.setVisible(true);
				textPane.setText("");
				}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(62)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
							.addGap(79))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(191)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField, Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnConfrim, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(73, Short.MAX_VALUE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(570, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(181)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnConfrim, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
							.addGap(67))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(36))))
		);
		getContentPane().setLayout(groupLayout);
		}

	public void showText(Object[] objects){                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
		for( Object i : objects){
			textPane.setText(textPane.getText()+((Topping)i).getName()+"\n");}
		textField.setText(mainP.getShop().getBurger().getPrice()+"");
	}
}