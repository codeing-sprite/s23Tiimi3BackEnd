package hh.sof05.dogbackend.webcontrol;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import hh.sof05.dogbackend.domain.Manufacturer;
import hh.sof05.dogbackend.domain.ManufacturerRepository;


@RestController
public class ManufacturerRestController {
    
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @GetMapping("/restmanufacturers")
    List<Manufacturer> listAllManufacturers() {
        return (List<Manufacturer>) manufacturerRepository.findAll();
    }

    @GetMapping("/restmanufacturers/{id}")
    Optional<Manufacturer> getManufacturerById(@PathVariable("id") long manuId) {
        return manufacturerRepository.findById(manuId);
    }
}
