package hh.sof05.dogbackend.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long> {
	Optional<Manufacturer> findById(Long id);
}
