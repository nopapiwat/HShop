import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import tools.Burger;
import tools.Topping;
import topping.Bread;
import topping.Cheese;
import topping.Onion;
import topping.Pork;
import topping.Tomato;


public class HShop extends Observable{
	private ArrayList<Burger> history;
	private Burger curB;
	private ArrayList<Topping> menu;
	public HShop(){
		history = new ArrayList<Burger>();
		menu = new ArrayList<Topping>();
		menu.add(new Bread());
		menu.add(new Cheese());
		menu.add(new Onion());
		menu.add(new Pork());
		// fapfapfapfapfap
		menu.add(new Tomato());
	}
	public void sellB(){
		history.add(curB);
		setChanged();
		this.notifyObservers(curB.getPrice());
	}
	
	public void createBurger(){
		curB = new Burger();
	}
	public void addTopping(Topping t){
		curB.addTopping(t);
	}
	public ArrayList getHis(){
		return history;
	}
	public void deleteHis(int index){
		history.remove(index);
	}
	public ArrayList getMenu(){
		return menu;
	}
}
