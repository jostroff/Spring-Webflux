package application.controllers;

import application.entities.User;
import application.repositories.UserRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

//    private final UserRepository userRepository;

//    public UserController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
	
	@GetMapping("/users/{id}")
	public Mono<User> getUser(@PathVariable long id) {
		return UserRepository.findUserById(id);
	}
	
	@GetMapping("/users")
	public Flux<User> getUsers() {
		return UserRepository.findAllUsers();
	}
	
	@PostMapping("/users")
	void addUsers(@RequestBody User user) {
		  UserRepository.save(user);
	}
}
