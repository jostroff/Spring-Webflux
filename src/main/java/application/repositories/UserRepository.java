package application.repositories;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import application.entities.User;

@Repository
public class UserRepository {
	public static Map<Long, User> userData = new HashMap<>();
	
//	public static void fillUserData() {
//		
//	}
	
	public static void save(User user) {
		
		System.out.println(userData.size());
		userData.put((long) userData.size() + 1, user); //user.getId(), (long) userData.size()
	}
	public static List<User> findAll() {
		return new ArrayList<>(userData.values());
	}
	
	public static Mono<User> findUserById(Long id){
		return Mono.just(userData.get(id));
	}
	public static Flux<User> findAllUsers(){
		return Flux.fromIterable(findAll());
	}
	 public static Mono<User> updateUser(User user) {
        User existingUser = userData.get(user.getId());
        if(existingUser != null) {
        	existingUser.setEmail(user.getEmail());
        	existingUser.setName(user.getName());
        }
        return Mono.just(existingUser);
    }
}
