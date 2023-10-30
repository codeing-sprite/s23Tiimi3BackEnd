package hh.sof05.dogbackend.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof05.dogbackend.domain.Item;
import hh.sof05.dogbackend.domain.ItemRepository;

@Controller
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/items")
    public String listItems(Model model) {
        model.addAttribute("items", itemRepository.findAll());
        return "itemlist";
    }

    @GetMapping("/additem")
    public String addItem(Model model) {
        model.addAttribute("item", new Item());
        return "additem";
    }

    @PostMapping("/saveitem")
    public String saveItem(Item item) {
        itemRepository.save(item);
        return "redirect:items";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable("id") Long itemId, Model model) {
        itemRepository.deleteById(itemId);
        return "redirect:../items";
    }

    @GetMapping("/edit/{id}")
    public String editItem(@PathVariable("id") Long itemId, Model model) {
        model.addAttribute(("item"), itemRepository.findById(itemId));
        return "edititem";
    }
}
