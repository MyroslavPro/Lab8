package ua.lviv.iot.fishStore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import ua.lviv.iot.fishStore.Item;
import ua.lviv.iot.fishStore.service.ItemService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
 
@RequestMapping("/item")
@RestController
public class ItemController {
	
	    @Autowired
	    private ItemService itemService;
	    
	    
	    @GetMapping(path = "/{id}")
	    public Item getItem(@PathVariable Integer id) {
	        return itemService.getItem(id);
	    }

	    @GetMapping
	    public List<Item> getItems() {
	        return itemService.getItems();
	    }
	    
	    @PostMapping
	    public Item createPerformance(@RequestBody Item item) {
	        return itemService.addItem(item);
	    }

	    @PutMapping
	    public ResponseEntity<Item> updateItem(@RequestBody Item item) {
	        if (itemService.getItem(item.getId()) != null) {
	            return new ResponseEntity<Item>(itemService.updateItem(item), HttpStatus.OK);
	        } 
	        else {
	            return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
	        }
	    }
}
