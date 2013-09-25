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

import tools.Topping;

public class HShopUI extends JFrame implements Observer{
	private HShop shop;
	
	private JPanel paneA;
	private JPanel paneB;
	private JButton create;
	private JButton sell;
	private JButton[] nums;
	
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
		paneA.setLayout(new GridLayout(2,1));
		paneB = new JPanel();
		nums = new JButton[shop.getMenu().size()];
		for(int i = 0 ; i < nums.length ; i++){
			final int j = i;
			nums[i] = new JButton(((Topping)(shop.getMenu()).get(i)).getName());
			nums[i].addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					shop.addTopping((Topping)(shop.getMenu()).get(j));
					
				}
				
			});
			paneA.add(nums[i]);
		}
		create = new JButton("Create");
		create.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				shop.createBurger();
			}	
		});
		sell = new JButton("Sell");
		sell.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				shop.sellB();
			}
			
		});
		
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
		System.out.println("oo");
	}

}
