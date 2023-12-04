package hh.sof05.dogbackend.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.sof05.dogbackend.domain.OrderRepository;
import hh.sof05.dogbackend.domain.OrderStatusRepository;
import hh.sof05.dogbackend.domain.UserRepository;

@Controller
@RequestMapping("/orderlist")
public class OrderController {
    
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderStatusRepository orderStatusRepository;

    @Autowired
    UserRepository userRepository;

    public String listOrders(Model model) {
        model.addAttribute("orders", orderRepository.findAll());
        return "orderlist";
    }
}
