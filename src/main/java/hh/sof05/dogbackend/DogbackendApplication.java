package hh.sof05.dogbackend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof05.dogbackend.domain.Category;
import hh.sof05.dogbackend.domain.CategoryRepository;
import hh.sof05.dogbackend.domain.Item;
import hh.sof05.dogbackend.domain.ItemRepository;
import hh.sof05.dogbackend.domain.Manufacturer;
import hh.sof05.dogbackend.domain.ManufacturerRepository;
import hh.sof05.dogbackend.domain.User;
import hh.sof05.dogbackend.domain.UserRepository;

@SpringBootApplication
public class DogbackendApplication {

	private static final Logger log = LoggerFactory.getLogger(DogbackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DogbackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandRunner(ItemRepository itemRepository, CategoryRepository categoryRepository,
			ManufacturerRepository manufacturerRepository, UserRepository userRepository) {
		return (args) -> {

			log.info("Saving a couple of categories");
			Category category1 = categoryRepository.save(new Category("Clothing"));
			Category category2 = categoryRepository.save(new Category("Food"));
			Category category3 = categoryRepository.save(new Category("Toys"));

			log.info("Saving a couple of manufacturers");
			Manufacturer manufacturer1 = manufacturerRepository.save(new Manufacturer("Hurtta"));
			Manufacturer manufacturer2 = manufacturerRepository.save(new Manufacturer("Royal Canin"));
			Manufacturer manufacturer3 = manufacturerRepository.save(new Manufacturer("Pro Dog"));

			log.info("Saving a couple of products");
			itemRepository.save(new Item("Dog jacket", "Blue", "Medium", 26.95, manufacturer1, category1, 10));
			itemRepository.save(new Item("Dog food", "", "", 10.49, manufacturer2, category2, 10));
			itemRepository.save(new Item("Dog toy", "Orange", "", 7.95, manufacturer3, category3, 5));

			log.info("Saving a couple of users");

			userRepository.save(new User("admin", "$2a$12$aQLOSgr68.ZYV71E32Hb/Ou3nO5uMS3fO/z3wp9hYsbCeJFKjr9fy",
					"admin@admin.com", "ADMIN"));
		};
	};
}
