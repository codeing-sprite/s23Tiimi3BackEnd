package hh.sof05.dogbackend.webcontrol;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hh.sof05.dogbackend.domain.Manufacturer;
import hh.sof05.dogbackend.domain.ManufacturerRepository;


@RestController
@RequestMapping("/rest") 
public class ManufacturerRestController {
    
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @GetMapping("/manufacturers")
    List<Manufacturer> listAllManufacturers() {
        return (List<Manufacturer>) manufacturerRepository.findAll();
    }

    @GetMapping("/manufacturers/{id}") 
    Optional<Manufacturer> getManufacturerById(@PathVariable("id") long manuId) {
        return manufacturerRepository.findById(manuId);
    }
}
