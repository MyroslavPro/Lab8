package ua.lviv.iot.fishStore;

//import org.springframework.boot.SpringApplication;

//import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.lviv.iot.fishStore.Type;
import ua.lviv.iot.fishStore.Kind;
import ua.lviv.iot.fishStore.Freezing;
import ua.lviv.iot.fishStore.Order;
import ua.lviv.iot.fishStore.ShopManager;
import ua.lviv.iot.fishStore.Fish;
import ua.lviv.iot.fishStore.Item;

public class App {
	public static void main(String[] args) {
		ShopManager Alex = new ShopManager();
		// Alex.addFish(Fish.builder().name("Salmon").price(15.0).country("China").provider("ChiCO").typeOfFish(Type.Sea).dateOfExpiration("July14").origrin("Black
		// Sea").build());
		// Alex.addFish(Fish.builder().name("Cyprinys").price(144.0).country("UK").provider("UkInc.").typeOfFish(Type.Sea).dateOfExpiration("June24").origrin("North
		// Sea").build());
		// Alex.addFish(Fish.builder().name("Carassius").price(9.0).country("US").provider("MAFA2020").typeOfFish(Type.Fresh).dateOfExpiration("March12").origrin("Hudson").build());
		Alex.addFish(new Fish("Salmon", 15.0, "China", "ChiCO", Type.Sea, "Black Sea", "July14"));
		Alex.addFish(new Fish("Cyprinys", 144.0, "UK", "UkInc.", Type.Sea, "North Sea", "June24"));
		Alex.addFish(new Fish("Carassius", 9.0, "US", "MAFA2020", Type.FreshWater, "Hudson", "March12"));

		System.out.println("I want to see all fish in range from 10 to 200$");
		System.out.println(Alex.searchByPrice(10, 20));
		System.out.println("I want to see the Sea fish");
		System.out.println(Alex.searchByTypeOfFish(Type.Sea));
		System.out.println("Sort Price(Ascending/descending options)");
		System.out.println(Alex.sortFishByPrice(Order.ASC));
		System.out.println("Sort by name");
		System.out.println(Alex.sortFishByName());
	}

}