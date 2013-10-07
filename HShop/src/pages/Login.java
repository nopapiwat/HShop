package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tools.HShop;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Login extends JFrame{
	
	private JFrame tis;
	private JLabel lblHshop;
	private JTextField UsrText;
	private JTextField PassText;

	public Login(){
		getContentPane().setFont(new Font("Dialog", Font.PLAIN, 48));
		tis = this;
		
		
		setPreferredSize(new Dimension(700, 700));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		
		lblHshop = new JLabel("HShop");
		lblHshop.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblHshop.setFont(new Font("Dialog", Font.BOLD, 48));
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Dialog", Font.BOLD, 20));
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 20));
		
		UsrText = new JTextField();
		UsrText.setColumns(10);
		
		PassText = new JTextField();
		PassText.setColumns(10);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				if (UsrText.getText().equals("admin") && PassText.getText().equals("password")){
				if (true){
					HShop shop = new HShop();
					MainPage m = new MainPage(shop);
					tis.setVisible(false);
				}
					
			}
		});
		btnLogIn.setFont(new Font("Dialog", Font.BOLD, 20));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(264, Short.MAX_VALUE)
					.addComponent(lblHshop)
					.addGap(250))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(166)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(PassText, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblUsername)
							.addGap(32)
							.addComponent(UsrText, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)))
					.addGap(161))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(303, Short.MAX_VALUE)
					.addComponent(btnLogIn)
					.addGap(284))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(140)
					.addComponent(lblHshop)
					.addGap(117)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(UsrText, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(PassText, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(80)
					.addComponent(btnLogIn)
					.addContainerGap(147, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		setVisible(true);
	}
}
