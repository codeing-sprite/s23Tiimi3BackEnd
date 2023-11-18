package hh.sof05.dogbackend.webcontrol;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hh.sof05.dogbackend.domain.Item;
import hh.sof05.dogbackend.domain.ItemRepository;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/rest")
public class ItemRestController {

    @Autowired
    private ItemRepository itemRepository;

     @GetMapping("/items")
     public @ResponseBody List<Item> listAllItems() {
         return (List<Item>) itemRepository.findAll();
     }

     @GetMapping("/items/{id}")
     public @ResponseBody Optional<Item> getItemById(@PathVariable("id") long itemId) {
        return itemRepository.findById(itemId);
     } 

}
