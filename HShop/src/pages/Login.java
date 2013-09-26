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

public class Login extends JFrame{
	private JPanel paneA;
	
	private JFrame tis;
	private JLabel us;
	private JTextField usr;
	private JLabel ps;
	private JTextField pass;
	private JButton submit;
	public Login(){
		tis = this;
		us = new JLabel("Username");
		usr = new JTextField();
		usr.setPreferredSize(new Dimension(200,20));
		ps = new JLabel("Password");
		pass = new JTextField();
		pass.setPreferredSize(new Dimension(200,20));
		submit = new JButton("Submit");
		submit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(usr.getText().equals("admin") && pass.getText().equals("password")){
					HShop shop = new HShop();
					HShopUI ui = new HShopUI(shop);
					shop.addObserver(ui);
					tis.setVisible(false);
				}
				
			}
			
		});
		paneA = new JPanel();
		paneA.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			paneA.add(us,c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 0;
			paneA.add(usr,c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 1;
			paneA.add(ps,c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 1;
			paneA.add(pass,c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 2;
			paneA.add(submit,c);
			paneA.setBackground(Color.cyan);
			this.add(paneA);
	
		
		setPreferredSize(new Dimension(700, 700));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}
