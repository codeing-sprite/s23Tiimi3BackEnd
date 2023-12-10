package hh.sof05.dogbackend.webcontrol;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// import hh.sof05.dogbackend.domain.Category;
// import hh.sof05.dogbackend.domain.CategoryRepository;
// import hh.sof05.dogbackend.domain.Item;
// import hh.sof05.dogbackend.domain.ItemRepository;
// import hh.sof05.dogbackend.domain.Manufacturer;
// import hh.sof05.dogbackend.domain.ManufacturerRepository;
// import hh.sof05.dogbackend.domain.User;
// import hh.sof05.dogbackend.domain.UserRepository;

@Controller
public class IndexController {

    // @Autowired
    // CategoryRepository categoryRepository;

    // @Autowired
    // ItemRepository itemRepository;

    // @Autowired
    // ManufacturerRepository manufacturerRepository;

    // @Autowired
    // UserRepository userRepository;

    @GetMapping("/")
    public String getHomePage() {
        return "index";
    }

    // @GetMapping("/resetdb")
    // public String resetDb() {

    //     categoryRepository.deleteAll();
    //     itemRepository.deleteAll();
    //     manufacturerRepository.deleteAll();
    //     userRepository.deleteAll();

       
	// 		Category category1 = categoryRepository.save(new Category("Clothing"));
	// 		Category category2 = categoryRepository.save(new Category("Food"));
	// 		Category category3 = categoryRepository.save(new Category("Toys"));

			
	// 		Manufacturer manufacturer1 = manufacturerRepository.save(new Manufacturer("Hurtta"));
	// 		Manufacturer manufacturer2 = manufacturerRepository.save(new Manufacturer("Royal Canin"));
	// 		Manufacturer manufacturer3 = manufacturerRepository.save(new Manufacturer("Pro Dog"));

	// 		itemRepository.save(new Item("Dog jacket", "Blue", "Medium", 26.95, manufacturer1, category1, 10));
	// 		itemRepository.save(new Item("Dog food", "", "", 10.49, manufacturer2, category2, 10));
	// 		itemRepository.save(new Item("Dog toy", "Orange", "", 7.95, manufacturer3, category3, 5));

	// 		userRepository.save(new User("admin", "$2a$12$aQLOSgr68.ZYV71E32Hb/Ou3nO5uMS3fO/z3wp9hYsbCeJFKjr9fy",
	// 				"admin@admin.com", "ADMIN"));
		
    //     return "/login";
    // }

}
