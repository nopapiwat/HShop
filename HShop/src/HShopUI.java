import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HShopUI extends JFrame implements Observer{
	private HShop shop;
	
	private JPanel paneA;
	
	private JButton ok;
	public HShopUI(HShop s){
		super("HShop");
		this.shop = s;
		
		paneA = new JPanel();
		ok = new JButton("OK");
		paneA.add(ok);
		this.add(paneA);
		
		setPreferredSize(new Dimension(700, 700));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
