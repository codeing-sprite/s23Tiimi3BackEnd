package hh.sof05.dogbackend.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof05.dogbackend.domain.CategoryRepository;
import hh.sof05.dogbackend.domain.Item;
import hh.sof05.dogbackend.domain.ItemRepository;
import hh.sof05.dogbackend.domain.ManufacturerRepository;

@Controller
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ManufacturerRepository manufacturerRepository;

    // Add @PreAuthorize to all methods?

    // List all items
    @GetMapping("/items")
    public String listItems(Model model) {
        model.addAttribute("items", itemRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        return "itemlist";
    }

    // Add a new item into itemlist
    @GetMapping("/additem")
    public String addItem(Model model) {
        model.addAttribute("item", new Item());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        return "additem";
    }

    // Save added/edited item
    @PostMapping("/saveitem")
    public String saveItem(Item item) {
        itemRepository.save(item);
        return "redirect:items";
    }

    // Delete an item from itemlist based on its id value
    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable("id") Long itemId, Model model) {
        itemRepository.deleteById(itemId);
        return "redirect:../items";
    }

    // Edit an item on itemlist based on its id value
    @GetMapping("/edit/{id}")
    public String editItem(@PathVariable("id") Long itemId, Model model) {
        model.addAttribute(("item"), itemRepository.findById(itemId));
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        return "edititem";
    }
}
