package tools;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

public class HShop extends Observable{
	private ArrayList<Burger> history;
	private Burger curB;
	private ArrayList<Topping> menu;
	public HShop(){
		history = new ArrayList<Burger>();
		menu = new ArrayList<Topping>();
		menu.add(new Topping("Pork",5));
		menu.add(new Topping("Cheese",3));
		menu.add(new Topping("Tomato",4));
		menu.add(new Topping("Onion",2));
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
	public List getMenu(){
		return menu;
	}
	public Burger getBurger(){
		return curB;
	}
}
