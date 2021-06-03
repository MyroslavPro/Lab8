package ua.lviv.iot.fishStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import ua.lviv.iot.fishStore.Item;
import ua.lviv.iot.fishStore.dal.RepositoryItem;
import ua.lviv.iot.fishStore.exceptions.ItemNotFoundException;

@Service
@ApplicationScope
public class ItemService {

	@Autowired
	private RepositoryItem repository;

	public Item addItem(Item item) {
		return repository.save(item);
	}

	public Item updateItem(Integer id,Item item) throws ItemNotFoundException{
		if (repository.existsById(item.getId())) {
            //item.setId(id);
            return repository.save(item);
        }
        throw new ItemNotFoundException("Item with id: " + item.getId() + "not found");
	}

	public List<Item> getItems() {
		return repository.findAll();
	}

	public Item getItem(Integer id) {
		return repository.findById(id).orElseThrow();
	}
	
	public boolean deleteItem(Integer id){
        if(repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
