package hh.sof05.dogbackend.webcontrol;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.sof05.dogbackend.domain.Order;
import hh.sof05.dogbackend.domain.OrderRepository;
import hh.sof05.dogbackend.domain.OrderStatusRepository;
import hh.sof05.dogbackend.domain.User;
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

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String listClientsWithOrders(Model model) {
        List<User> clients = new ArrayList<User>();
        for (User user : userRepository.findAll()) {
            if (user.getOrders().size() > 0) {
                clients.add(user);
            }
        }
        model.addAttribute("clients", clients);
        return "orderlist";
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String clientOrders(@PathVariable("id") Long id, Model model) {
        User user = userRepository.findById(id).get();
        model.addAttribute("statuses", orderStatusRepository.findAll());
        model.addAttribute("client", user);
        model.addAttribute("orders", orderRepository.findByUser(user));
        return "clientorders";
    }

    @GetMapping("/order/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String orderDetails(@PathVariable("id") Long id, Model model) {
        Order order = orderRepository.findById(id).get();
        model.addAttribute("order", order);
        model.addAttribute("statuses", orderStatusRepository.findAll());
        model.addAttribute("client", order.getUser());
        return "orderdetails";
    }

    @PostMapping("/order/save")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String updateOrder(@ModelAttribute("order") Order order) {
        orderRepository.save(order);
        return "redirect:/orderlist";
    }

}
