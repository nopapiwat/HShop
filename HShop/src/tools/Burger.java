package tools;
import java.util.ArrayList;
import java.util.Date;


public class Burger {
	private ArrayList<Topping> topping;
	private Date time;
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
	public ArrayList<Topping> getDetail(){
		return topping;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
