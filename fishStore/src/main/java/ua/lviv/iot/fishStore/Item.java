package ua.lviv.iot.fishStore;

import lombok.Data;
//import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class Item {
	public String name;
	public double price;
	public String country;
	public String provider;

	public Item(String name, double price, String country, String provider) {
		this.name = name;
		this.price = price;
		this.country = country;
		this.provider = provider;
	}
}