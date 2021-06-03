package ua.lviv.iot.fishStore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Item {
	protected int id;
	protected String name;
	protected double price;
	protected String country;
	protected String provider;

	public Item(final String name, final double price, final String country, final String provider) {
		this.name = name;
		this.price = price;
		this.country = country;
		this.provider = provider;
	}
}