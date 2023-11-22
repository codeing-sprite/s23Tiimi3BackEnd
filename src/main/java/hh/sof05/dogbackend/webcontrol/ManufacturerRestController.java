package hh.sof05.dogbackend.webcontrol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hh.sof05.dogbackend.domain.Item;
import hh.sof05.dogbackend.domain.ItemRepository;
import hh.sof05.dogbackend.domain.Manufacturer;
import hh.sof05.dogbackend.domain.ManufacturerRepository;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/rest") 
public class ManufacturerRestController {
    
    @Autowired
    private ManufacturerRepository manufacturerRepository;
    
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/manufacturers")
    List<Manufacturer> listAllManufacturers() {
        return (List<Manufacturer>) manufacturerRepository.findAll();
    }

    @GetMapping("/manufacturers/{id}") 
    Manufacturer getManufacturerById(@PathVariable("id") long manuId) {
        return manufacturerRepository.findById(manuId).get();
    }
    
    @GetMapping("manufacturersitems/{id}")
    public @ResponseBody List<Item> itemsByManufacturer(@PathVariable("id") long manufacturerId) {
   	 Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId).get();
   	 return itemRepository.findByManufacturer(manufacturer);
    }
}
