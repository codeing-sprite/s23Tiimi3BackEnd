package hh.sof05.dogbackend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof05.dogbackend.domain.Item;
import hh.sof05.dogbackend.domain.ItemRepository;

@SpringBootApplication
public class DogbackendApplication {

	private static final Logger log = LoggerFactory.getLogger(DogbackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DogbackendApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandRunner(ItemRepository itemRepository) {
		return (args) -> {
			log.info("Saving a couple of products");
			itemRepository.save(new Item("Dog jacket", "Blue", "Medium", 26.95));
			itemRepository.save(new Item("Dog socks", "Green", "Extra-large", 99.95));
		};
	};
}
