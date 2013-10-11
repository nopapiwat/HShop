package pages;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import tools.Topping;

public class ConfirmUI extends JFrame{
	private JTextPane textPane;
	private MainPage mainP;
	private OrderUI orderP;
	private PaidUI paidP;
	private JTextField textField;
	private JTextField textField_1;
	public ConfirmUI(MainPage m, OrderUI orderUI){
		this.mainP = m;
		this.orderP = orderUI;
		paidP = new PaidUI(m);
		paidP.setVisible(false);
		setPreferredSize(new Dimension(700, 700));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		
		JButton btnConfrim = new JButton("Confirm");
		btnConfrim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paidP.showChange(Double.parseDouble(textField_1.getText())-Double.parseDouble(textField.getText()));
				paidP.showDetail(textPane.getText());
				mainP.getShop().sellB();
				ConfirmUI.this.setVisible(false);
				paidP.setVisible(true);
				textPane.setText("");
				orderP.clearText();
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
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(570, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(253)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnConfrim, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE))
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(82)
							.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)))
					.addGap(59))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(138)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnConfrim, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
							.addGap(67))
						.addGroup(groupLayout.createSequentialGroup()
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