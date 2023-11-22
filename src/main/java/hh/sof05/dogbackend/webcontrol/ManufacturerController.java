package hh.sof05.dogbackend.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof05.dogbackend.domain.ItemRepository;
import hh.sof05.dogbackend.domain.Manufacturer;
import hh.sof05.dogbackend.domain.ManufacturerRepository;
import jakarta.validation.Valid;

@Controller
public class ManufacturerController {

    @Autowired
    ManufacturerRepository manufacturerRepository;

    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/manufacturerlist")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String listManufacturers(Model model) {
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        return "manufacturerlist";
    }

    @GetMapping("/addmanufacturer")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addManufacturer(Model model) {
        model.addAttribute("manufacturer", new Manufacturer());
        return "addmanufacturer";
    }

    @PostMapping("/savemanufacturer")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveManufacturer(@Valid Manufacturer manufacturer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addmanufacturer";
        }
        manufacturerRepository.save(manufacturer);
        return "redirect:/manufacturerlist";
    }

    @GetMapping("manufacturerlist/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteManufacturer(@PathVariable("id") Long manufacturerId, Model model) {
        manufacturerRepository.deleteById(manufacturerId);

        return "redirect:/manufacturerlist";
    }

    @GetMapping("manufacturer/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String listItemsOfManufacturer(@PathVariable("id") Long manufacturerId, Model model) {
        Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId).get();
        model.addAttribute("manufacturer", manufacturer);
        model.addAttribute("items", itemRepository.findByManufacturer(manufacturer));
        return "manufacturer"; 
    } 
}
