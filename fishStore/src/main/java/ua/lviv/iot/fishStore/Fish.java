package ua.lviv.iot.fishStore;

import ua.lviv.iot.fishStore.Type;
import ua.lviv.iot.fishStore.Item;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
@NoArgsConstructor
@Data
public class Fish extends Item {
	public Type typeOfFish;
	public String origin;
	public String dateOfExpiration;

	//@Builder(builderMethodName = "fishBuilder")
	public Fish(final String name, final double price, final String country, final String provider,
			final Type typeOfFish, final String origin, final String dateOfExpiration) {
		super(name,price,country,provider);
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
