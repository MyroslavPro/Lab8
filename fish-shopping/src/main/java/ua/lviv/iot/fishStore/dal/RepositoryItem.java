package ua.lviv.iot.fishStore.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.fishStore.Item;

@Repository
public interface RepositoryItem extends JpaRepository<Item, Integer> {
}
