package ua.lviv.iot.fishStore;

import lombok.Data;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

@Data
public class ShopManager {
	private List<Fish> fishList;

	public ShopManager() {
		this.fishList = new ArrayList<Fish>();
	}

	public void addFish(final Fish fish) {
		this.fishList.add(fish);
	}

	public List<Fish> sortFishByPrice(final Order order) {
		if (order == Order.ASC) {
			fishList.sort(Comparator.comparing(Fish::getPrice));
		}
		if (order == Order.DESC) {
			fishList.sort(Comparator.comparing(Fish::getPrice).reversed());
		}
		return fishList;
	}

	public List<Fish> sortFishByName() {
		fishList.sort(Comparator.comparing(Fish::getName));
		return fishList;
	}

	public List<Fish> searchByTypeOfFish(final Type typeOfFish) {
		List<Fish> fishesOfNeededType = fishList.stream().filter(fish -> fish.getTypeOfFish() == typeOfFish)
				.collect(Collectors.toList());

		return fishesOfNeededType;
	}

	public List<Fish> searchByPrice(final double priceMin, final double priceMax) {
		List<Fish> fishesInPriceRange = fishList.stream()
				.filter(fish -> fish.getPrice() >= priceMin && fish.getPrice() <= priceMax)
				.collect(Collectors.toList());

		return fishesInPriceRange;
	}

}
