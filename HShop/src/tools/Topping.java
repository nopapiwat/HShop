package tools;

public class Topping {
	private double value;
	private String name;
	public Topping(String n,double v){
		name = n;
		value = v;
	}
	public double getValue(){
		return value;
	}
	public String getName(){
		return name;
	}
	public void setValue(double v){
		this.value = v;
	}
	
	public void setName(String n){
		this.name = n;
	}
	
}
