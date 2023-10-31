package hh.sof05.dogbackend.webcontrol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hh.sof05.dogbackend.domain.Item;
import hh.sof05.dogbackend.domain.ItemRepository;

@RestController
public class ItemRestController {
    
    @Autowired
    private ItemRepository itemRepository;

    // @GetMapping("/items")
    // List<Item> listAllItems() {
    //     return (List<Item>) itemRepository.findAll();
    // }

}
