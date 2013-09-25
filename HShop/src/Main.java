import tools.Topping;
import topping.Bread;
import topping.Pork;
import topping.Tomato;


public class Main {
	public static void main(String[] args){
		HShop shop = new HShop();
		HShopUI ui = new HShopUI(shop);
		shop.addObserver(ui);
		Topping[] a = {new Tomato(),new Bread(),new Pork()};
		System.out.println(shop.sellB(a));
	}
}
