package ua.lviv.iot.fishStore;

import ua.lviv.iot.fishStore.Fish;
import ua.lviv.iot.fishStore.Type;
import ua.lviv.iot.fishStore.Order;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collections;

@Data
@NoArgsConstructor
public class ShopManager {
	@Getter
	private List<Fish> fishList;

	public ShopManager() {
		this.fishList = new ArrayList<Fish>();
	}

	public void addFish(final Fish fish) {
		this.fishList.add(fish);
	}

	public List<Fish> sortFishByPrice(final Order order) {
		if (order == Order.ASC) {
			fishList.sort((Fish fish1, Fish fish2) -> fish1.getPrice() - fish2.getPrice());
			fishList.sort((Fish fish1, Fish fish2) -> fish1.price - fish2.price); 
		}
		if (order == Order.DESC) {
			fishList.sort((Fish fish1, Fish fish2) -> fish2.getPrice() - fish1.getPrice());
		}
		return fishList;
	}

	public List<Fish> sortFishByName() {
		fishList.sort((Fish fish1, Fish fish2) -> fish1.getName() - fish2.getName());
		return fishList;
	}

	public List<Fish> searchByTypeOfFish(final Type typeOfFish) {
		List<Fish> fishesOfNeededType = fishList.stream().filter(fish -> fish.getTypeOfFish() == typeOfFish)
				.collect(Collectors.toList());

		return fishesOfNeededType;
	}

	public List<Fish> searchByPrice(final double priceMin, final double priceMax) {
		List<Fish> fishesInRange = fishList.stream()
				.filter(fish -> fish.getPrice() >= priceMin && fish.getPrice() <= priceMax)
				.collect(Collectors.toList());

		return fishesInRange;
	}

}
