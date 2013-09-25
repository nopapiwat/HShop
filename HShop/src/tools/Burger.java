package tools;
import java.util.ArrayList;


public class Burger {
	private ArrayList<Topping> topping;
	public Burger(){
		topping = new ArrayList<Topping>();
		
	}
	public void addTopping(Topping a){
		topping.add(a);
	}
	
	public double getPrice(){
		Object[] t = topping.toArray();
		double sum = 0;
		for (Object a : t){
			if (a instanceof Topping)
				sum+=((Topping)a).getValue();
		}
		return sum;
	}
	public ArrayList getDetail(){
		return topping;
	}
}
