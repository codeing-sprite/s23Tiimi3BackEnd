package hh.sof05.dogbackend.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ItemRepository extends CrudRepository<Item, Long> {
    List<Item> findByCategory(Category category); 
    List<Item> findByManufacturer(Manufacturer manufacturer);

    @Query(value = "SELECT SUM(stock) FROM items", nativeQuery = true)
    Long findAllStock();

}
