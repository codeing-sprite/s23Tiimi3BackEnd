package hh.sof05.dogbackend.webcontrol;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hh.sof05.dogbackend.domain.CategoryRepository;
import hh.sof05.dogbackend.domain.Item;
import hh.sof05.dogbackend.domain.ItemRepository;
import hh.sof05.dogbackend.domain.Category;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/rest")
public class CategoryRestController {
    
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/categories")
    List<Category> listAllCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    @GetMapping("/categories/{id}")
    Optional<Category> getCategoryById(@PathVariable("id") long catId) {
        return categoryRepository.findById(catId);
    }

     @GetMapping("/categories/{id}/items")
     List<Item> getItemsInCategory(@PathVariable("id") long catId) {
         Category category = categoryRepository.findById(catId).get(); 
         List<Item> items = itemRepository.findByCategory(category);
         return items;
    }



}
