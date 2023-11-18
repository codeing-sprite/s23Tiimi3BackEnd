package hh.sof05.dogbackend.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


public interface ItemRepository extends CrudRepository<Item, Long> {
    List<Item> findByCategory(Category category); 
    List<Item> findByManufacturer(Optional<Manufacturer> manufacturer);
}
