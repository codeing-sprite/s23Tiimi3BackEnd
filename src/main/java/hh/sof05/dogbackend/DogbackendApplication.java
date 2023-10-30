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

@SpringBootApplication
public class DogbackendApplication {

	private static final Logger log = LoggerFactory.getLogger(DogbackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DogbackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandRunner(ItemRepository itemRepository, CategoryRepository categoryRepository,
			ManufacturerRepository manufacturerRepository) {
		return (args) -> {

			log.info("Saving a couple of categories");
			Category category1 = categoryRepository.save(new Category("Clothing"));
			Category category2 = categoryRepository.save(new Category("Dogbeds"));
			Category category3 = categoryRepository.save(new Category("Dogtoys"));

			log.info("Saving a couple of manufacturers");
			Manufacturer manufacturer1 = manufacturerRepository.save(new Manufacturer("Hurtta"));
			Manufacturer manufacturer2 = manufacturerRepository.save(new Manufacturer("Rukka"));
			Manufacturer manufacturer3 = manufacturerRepository.save(new Manufacturer("Ruffwear"));

			log.info("Saving a couple of products");
			itemRepository.save(new Item("Dog jacket", "Blue", "Medium", 26.95, manufacturer1, category1));
			itemRepository.save(new Item("Dog socks", "Green", "Extra-large", 99.99, manufacturer3, category1));
		};
	};
}
