package hh.sof05.dogbackend.webcontrol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hh.sof05.dogbackend.domain.Manufacturer;
import hh.sof05.dogbackend.domain.ManufacturerRepository;

@RestController
public class ManufacturerRestController {
    
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @GetMapping("/manufacturers")
    List<Manufacturer> listAllManufacturers() {
        return (List<Manufacturer>) manufacturerRepository.findAll();
    }
}
