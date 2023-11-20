package hh.sof05.dogbackend.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof05.dogbackend.domain.CategoryRepository;
import hh.sof05.dogbackend.domain.Item;
import hh.sof05.dogbackend.domain.ItemRepository;
import hh.sof05.dogbackend.domain.ManufacturerRepository;
import jakarta.validation.Valid;

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
    @GetMapping("/itemlist")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String listItems(Model model) {
        model.addAttribute("items", itemRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        model.addAttribute("allstock", itemRepository.findAllStock());
        return "itemlist";
    }

    // Add a new item into itemlist
    @GetMapping("/additem")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addItem(Model model) {
        model.addAttribute("item", new Item());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        return "additem";
    }

    // Save added/edited item
    @PostMapping("/saveitem")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveItem(@Valid Item item, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryRepository.findAll());
            model.addAttribute("manufacturers", manufacturerRepository.findAll());
            return "additem";
        }
        itemRepository.save(item);
        return "redirect:itemlist";
    }

    // Delete an item from itemlist based on its id value
    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteItem(@PathVariable("id") Long itemId, Model model) {
        itemRepository.deleteById(itemId);
        return "redirect:../itemlist";
    }

    // Edit an item on itemlist based on its id value
    @GetMapping("/edit/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editItem(@PathVariable("id") Long itemId, Model model) {
        model.addAttribute(("item"), itemRepository.findById(itemId));
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        return "edititem";
    }
}
