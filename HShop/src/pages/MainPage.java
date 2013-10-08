package pages;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import tools.HShop;

public class MainPage extends JFrame{
	private HShop shop;
	private MainPage tis;
	private OrderUI order;
	private AboutUI about;
	private EditSaleUI edit;
	
	public MainPage(HShop shop){
		tis = this;
		this.shop = shop;
		about = new AboutUI(this);
		about.setVisible(false);
		order = new OrderUI(tis.getShop(),this);
		order.setVisible(false);
		edit = new EditSaleUI(this);
		edit.setVisible(false);
		setPreferredSize(new Dimension(700, 700));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		
		JLabel lblH = new JLabel("HShop");
		lblH.setFont(new Font("Dialog", Font.BOLD, 48));
		
		JButton btnOrder = new JButton("Order");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tis.getShop().createBurger();
				order.setVisible(true);
				tis.setVisible(false);
			}
		});
		
		JButton btnAbout = new JButton("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				about.setVisible(true);
				tis.setVisible(false);
			}
		});
		
		JButton btnHistory = new JButton("History");
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HistoryUI(tis);
				tis.setVisible(false);
			}
		});
		
		JButton btnSetting = new JButton("Setting");
		btnSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tis.setVisible(false);
				edit.setVisible(true);
			}
		});
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int x = JOptionPane.showConfirmDialog(null,
					    "Do you want to log out?",
					    "Logout",JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (x == 0)
					System.exit(0);
			}
		});
		
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(97, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnOrder, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAbout, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
							.addGap(44)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnSetting, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnHistory, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(87))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblH)
							.addGap(249))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(160, Short.MAX_VALUE)
					.addComponent(lblH)
					.addGap(135)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOrder, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnHistory, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAbout, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSetting, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
					.addGap(131))
		);
		getContentPane().setLayout(groupLayout);
		setVisible(true);
	}
	
	public HShop getShop(){
		return this.shop;
	}

}
