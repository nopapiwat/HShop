package pages;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tools.HShop;
import tools.Topping;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class OrderUI extends JFrame implements Observer{
	private HShop shop;
	private MainPage mainP;
	private ConfirmUI conf;
	private JTextArea text;
	private JButton btnBack;
	private JTextField textField;

	
	public OrderUI(HShop s, MainPage mainPage){
		super("HShop");
		this.shop = s;
		this.shop.addObserver(this);
		this.mainP = mainPage;
		conf = new ConfirmUI(mainPage,this);
		conf.setVisible(false);
		
		
		setPreferredSize(new Dimension(700, 700));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		
		JButton btnPork = new JButton("Pork");
		btnPork.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shop.addTopping((Topping)shop.getMenu().get(0));
				text.setText(text.getText()+"\nPork");
			}
		});
		
		JButton btnCheese = new JButton("Cheese");
		btnCheese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shop.addTopping((Topping)shop.getMenu().get(1));
				text.setText(text.getText()+"\nCheese");
			}
		});
		
		JButton btnTomato = new JButton("Tomato");
		btnTomato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shop.addTopping((Topping)shop.getMenu().get(2));
				text.setText(text.getText()+"\nTomato");
			}
		});
		
		JButton btnOnion = new JButton("Onion");
		btnOnion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shop.addTopping((Topping)shop.getMenu().get(3));
				text.setText(text.getText()+"\nOnion");
			}
		});
		
		JButton button_3 = new JButton("Pork");
		
		JButton button_4 = new JButton("Pork");
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conf.setVisible(true);
				OrderUI.this.setVisible(false);
				conf.showText(shop.getBurger().getDetail().toArray());
			}
		});
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shop.createBurger();
				clearText();
			}
		});
		
		text = new JTextArea("Topping:");
		text.setEditable(false);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearText();
				mainP.setVisible(true);
				OrderUI.this.setVisible(false);
			}
		});
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setEditable(false);
		textField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(text, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnPork, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
									.addGap(32)
									.addComponent(btnCheese, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnTomato, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
									.addGap(32)
									.addComponent(btnOnion, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
									.addGap(32)
									.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
									.addGap(32)
									.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
							.addGap(59))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(102)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnPork, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCheese, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnTomato, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnOnion, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(text, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
					.addGap(48)
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(72))
		);
		getContentPane().setLayout(groupLayout);
	}


	public void clearText() {
		text.setText("Topping:");
		textField.setText("");
	}


	@Override
	public void update(Observable o, Object arg) {
		textField.setText(arg.toString());		
	}
}
