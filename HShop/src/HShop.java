import java.util.ArrayList;
import java.util.Observable;

import tools.Burger;
import tools.Topping;


public class HShop extends Observable{
	private ArrayList<Burger> history;
	public HShop(){
		history = new ArrayList<Burger>();
	}
	public double sellB(Topping[] t){
		Burger b = new Burger();
		for(Topping a : t)
			b.addTopping(a);
		history.add(b);
		return b.getPrice();
	}
	public ArrayList getHis(){
		return history;
	}
	public void deleteHis(int index){
		history.remove(index);
	}
}
