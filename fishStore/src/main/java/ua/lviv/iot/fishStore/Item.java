package ua.lviv.iot.fishStore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Item {
	public int id;
	public String name;
	public double price;
	public String country;
	public String provider;

	public Item(final String name, final double price, final String country, final String provider) {
		this.name = name;
		this.price = price;
		this.country = country;
		this.provider = provider;
	}
}