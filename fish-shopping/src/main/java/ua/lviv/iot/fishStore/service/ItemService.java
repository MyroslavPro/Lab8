package ua.lviv.iot.fishStore.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import ua.lviv.iot.fishStore.Item;


@Service
@ApplicationScope
public class ItemService {
	private AtomicInteger id = new AtomicInteger(0);

	private Map<Integer, Item> itemsMap = new HashMap<Integer, Item>();

	public Item addItem(Item item) {
		Integer itemId = id.incrementAndGet();
		item.setId(itemId);
		itemsMap.put(itemId, item);
		return item;
	}

	public Item updateItem(Item item) {
		return itemsMap.put(item.getId(), item);
	}

	public List<Item> getItems(){
		return itemsMap.values().stream().collect(Collectors.toList());
	}

	public Item getItem(Integer id) {
		return itemsMap.get(id);
	}	
}
