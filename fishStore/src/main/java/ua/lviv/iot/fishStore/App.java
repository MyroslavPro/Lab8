package ua.lviv.iot.fishStore;

public class App {
	public static void main(String[] args) {
		final ShopManager alex = new ShopManager();

		alex.addFish(new Fish("Salmon", 15.0, "China", "ChiCO", Type.Sea, "Black Sea", "July14"));
		alex.addFish(new Fish("Cyprinys", 144.0, "UK", "UkInc.", Type.Sea, "North Sea", "June24"));
		alex.addFish(new Fish("Carassius", 9.0, "US", "MAFA2020", Type.FreshWater, "Hudson", "March12"));

		System.out.println("I want to see all fish in range from 10 to 20$");
		System.out.println(alex.searchByPrice(10, 20));
		System.out.println("I want to see the Sea fish");
		System.out.println(alex.searchByTypeOfFish(Type.Sea));
		System.out.println("Sort Price(Ascending/descending options)");
		System.out.println(alex.sortFishByPrice(Order.ASC));
		System.out.println("Sort by name");
		System.out.println(alex.sortFishByName());
	}

}
