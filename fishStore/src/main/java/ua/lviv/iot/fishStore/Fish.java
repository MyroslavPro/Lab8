package ua.lviv.iot.fishStore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Fish extends Item {

	public Type typeOfFish;
	public String origin;
	public String dateOfExpiration;

	public Fish(String name, final double price, final String country, final String provider, final Type typeOfFish,
			final String origin, final String dateOfExpiration) {
		super(name, price, country, provider);
		this.typeOfFish = typeOfFish;
		this.origin = origin;
		this.dateOfExpiration = dateOfExpiration;
	}

	@Override
	public String toString() {
		return "Fish [typeOfFish=" + typeOfFish + ", origin=" + origin + ", dateOfExpiration=" + dateOfExpiration
				+ ", name=" + name + ", price=" + price + ", country=" + country + ", provider=" + provider + "]";
	}

}
