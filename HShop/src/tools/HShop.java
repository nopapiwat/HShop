package tools;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

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
		menu.add(new Tomato());
	}
	public void sellB(){
		curB.setTime(new Date());
		history.add(curB);
	}
	
	public void createBurger(){
		curB = new Burger();
	}
	public void addTopping(Topping t){
		curB.addTopping(t);
		setChanged();
		this.notifyObservers(curB.getPrice());
	}
	public ArrayList<Burger> getHis(){
		return history;
	}
	public void deleteHis(int index){
		history.remove(index);
	}
	public ArrayList getMenu(){
		return menu;
	}
	public Burger getBurger(){
		return curB;
	}
}
