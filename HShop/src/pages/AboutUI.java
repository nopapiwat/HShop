package pages;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import tools.Burger;
import tools.Topping;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AboutUI extends JFrame {
	private MainPage other;
	private JTextArea textArea;
	
	public AboutUI(MainPage m) {
		other = m;
		JLabel lblHshop = new JLabel("HShop");
		lblHshop.setFont(new Font("Verdana", Font.BOLD, 32));
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setText("Bla Bla Bla");
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				Object[] b =other.getShop().getHis().toArray();
				for (Object c : b){
					for (Object d : ((Burger)c).getDetail().toArray()){
						textArea.setText(textArea.getText()+"+"+((Topping)d).getName());
					}
					textArea.setText(textArea.getText()+"\n");
				}
				AboutUI.this.setVisible(false);
				other.setVisible(true);
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
							.addGap(31))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblHshop)
							.addContainerGap(312, Short.MAX_VALUE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(351, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addGap(22))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(lblHshop)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
					.addGap(12)
					.addComponent(btnBack)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		setPreferredSize(new Dimension(700, 700));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}
}
