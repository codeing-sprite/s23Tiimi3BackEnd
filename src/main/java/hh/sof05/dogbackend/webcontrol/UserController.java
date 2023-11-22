package hh.sof05.dogbackend.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof05.dogbackend.domain.User;
import hh.sof05.dogbackend.domain.UserRepository;

@Controller
public class UserController {
	
	@Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }
	
    @GetMapping(value="/userlist")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String userlist(Model model) {
    	model.addAttribute("users", userRepository.findAll());
        return "userlist";
    }
    
    @GetMapping(value="/adduser")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addUser(Model model) {
    	model.addAttribute("user", new User());
        return ("adduser");
    }
    
    @PostMapping(value="/saveuser")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveUser(User user) {
    	userRepository.save(user);
        return ("redirect:userlist");
    }
    
    @GetMapping("/edituser/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editUser(@PathVariable("id") Long userId, Model model) {
        model.addAttribute(("user"), userRepository.findById(userId));
        return "edituser";
    }
    
    @GetMapping("/deleteuser/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteUser(@PathVariable("id") Long userId, Model model) {
    	userRepository.deleteById(userId);
        return "redirect:../userlist";
    }
   
}
