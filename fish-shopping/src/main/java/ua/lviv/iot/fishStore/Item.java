package ua.lviv.iot.fishStore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
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