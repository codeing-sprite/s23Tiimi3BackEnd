package hh.sof05.dogbackend.webcontrol;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import hh.sof05.dogbackend.domain.CategoryRepository;
import hh.sof05.dogbackend.domain.Category;

@RestController
public class CategoryRestController {
    
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/restcategories")
    List<Category> listAllCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    @GetMapping("/restcategories/{id}")
    Optional<Category> getCategoryById(@PathVariable("id") long catId) {
        return categoryRepository.findById(catId);
    }



}
