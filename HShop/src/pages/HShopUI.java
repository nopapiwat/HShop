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

public class HShopUI extends JFrame implements Observer{
	private HShop shop;
	
	private JPanel paneA;
	private JPanel paneAA;
	private JPanel paneAB;
	private JPanel paneB;
	private JButton create;
	private JButton sell;
	private JButton[] nums;
	
	private JTextField report;
	private JTextField result;
	
	public HShopUI(HShop s){
		super("HShop");
		this.shop = s;
		initComponent();
		
		setPreferredSize(new Dimension(700, 700));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	public void initComponent(){

		this.setLayout(new GridLayout(2,1));
		paneA = new JPanel();
		paneA.setLayout(new GridLayout(1,2));
		paneAA = new JPanel();
		paneAA.setLayout(new GridLayout(5,1));
		paneAB = new JPanel();
		paneB = new JPanel();
		nums = new JButton[shop.getMenu().size()];
		for(int i = 0 ; i < nums.length ; i++){
			final int j = i;
			nums[i] = new JButton(((Topping)(shop.getMenu()).get(i)).getName());
			nums[i].setEnabled(false);
			nums[i].addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					shop.addTopping((Topping)(shop.getMenu()).get(j));
					report.setText(report.getText()+"\n"+nums[j].getText());
					
				}
				
			});
			paneAA.add(nums[i]);
		}
		create = new JButton("Create");
		create.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				result.setText("0");
				report.setText("");
				shop.createBurger();
				for(int i = 0 ; i < nums.length ; i++){
					nums[i].setEnabled(true);
				}
			}	
		});
		sell = new JButton("Sell");
		sell.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// what is it?
				shop.sellB();
				
				new EditSaleUI();
			}
			
		});
		paneA.add(paneAA);
		report = new JTextField();
		report.setPreferredSize(new Dimension(350,350));
		report.setEditable(false);
		paneAB.add(report);
		paneA.add(paneAB);
		result = new JTextField();
		result.setPreferredSize(new Dimension(100,20));
		paneB.add(create);
		paneB.add(sell);
		paneB.add(result);
		this.add(paneA);
		this.add(paneB);
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		result.setText(arg.toString());
	}

}
