package hh.sof05.dogbackend.webcontrol;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DogController {

    @GetMapping("/index")
    public String indexPage() {
        return "/index";
    }

}
