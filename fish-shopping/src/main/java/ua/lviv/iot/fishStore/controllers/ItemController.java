package ua.lviv.iot.fishStore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import ua.lviv.iot.fishStore.Item;
import ua.lviv.iot.fishStore.exceptions.ItemNotFoundException;
import ua.lviv.iot.fishStore.service.ItemService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

@RequestMapping("/item")
@RestController
public class ItemController {
	private static final Logger LOGGER = Logger.getLogger("ua.lviv.iot.shop.controllers.PerformanceController");

	@Autowired
	private ItemService itemService;

	@GetMapping(path = "/{id}")
	public ResponseEntity<Item> getItem(@PathVariable Integer id) {
		try {
			return new ResponseEntity<>(itemService.getItem(id), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			LOGGER.severe("Item with this id -:" + id + "doesn't exist");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	public List<Item> getItems() {
		return itemService.getItems();
	}

	@PostMapping
	public ResponseEntity<Item> createItem(@RequestBody Item item) {
		if (item.getId() == null) {
			itemService.addItem(item);
			return new ResponseEntity<Item>(item, HttpStatus.OK);
		}
		LOGGER.severe("Failed to create an Item with passed id. Item creation should not use external ids");
		return new ResponseEntity<Item>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Item> updateItem(@PathVariable Integer id, @RequestBody Item item) {
		try {
			item.setId(id);
			itemService.updateItem(id, item);
			return new ResponseEntity<>(item, HttpStatus.OK);
		} catch (ItemNotFoundException e) {
			LOGGER.severe("Can't update an item with non-existing id");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteItem(@PathVariable Integer id) {
		if (itemService.deleteItem(id)) {
			return ResponseEntity.ok("Deleted");
		}
		return ResponseEntity.notFound().build();
	}
}
