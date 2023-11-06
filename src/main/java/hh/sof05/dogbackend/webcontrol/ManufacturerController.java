package hh.sof05.dogbackend.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof05.dogbackend.domain.Manufacturer;
import hh.sof05.dogbackend.domain.ManufacturerRepository;

@Controller
public class ManufacturerController {

    @Autowired
    ManufacturerRepository manufacturerRepository;

    @GetMapping("/manufacturerlist")
    public String listManufacturers(Model model) {
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        return "manufacturerlist";
    }

    @GetMapping("/addmanufacturer")
    public String addManufacturer(Model model) {
        model.addAttribute("manufacturer", new Manufacturer());
        return ("/addmanufacturer");
    }

    @PostMapping("/savemanufacturer")
    public String saveManufacturer(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
        return ("redirect:manufacturerlist");
    }

    @GetMapping("manufacturerlist/delete/{id}")
    public String deleteManufacturer(@PathVariable("id") Long manufacturerId, Model model) {
        manufacturerRepository.deleteById(manufacturerId);

        return "redirect:../../manufacturerlist";
    }

}
