package hh.sof05.dogbackend.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hh.sof05.dogbackend.domain.User;
import hh.sof05.dogbackend.domain.UserRepository;

@RestController
@RequestMapping("/rest")
public class UserRestController {
	
	@Autowired
    private UserRepository userRepository;
    
	@GetMapping("/login/{username}")
    public User login(@PathVariable("username") String username) {
        return userRepository.findByUsername(username);
    }
	
	@PostMapping("/register")
	public String register(User user){
		userRepository.save(user);
		return "Registeration successfull";
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public String deleteUser(@PathVariable("id") Long userId) {
		userRepository.deleteById(userId);
		return "Registeration removed";
	}
}
