package webClients;

import org.springframework.web.reactive.function.client.WebClient;

import application.entities.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class UserWebClient {
	
	WebClient client = WebClient.create("http://localhost:8080");
	
	public void consume() {
		Mono<User> userMono = client.get()
				  .uri("/users/webflux/{id}", "1")
				  .retrieve()
				  .bodyToMono(User.class);
		
		userMono.subscribe(System.out::println);
		
		Flux<User> userFlux = client.get()
				  .uri("/users/webflux")
				  .retrieve()
				  .bodyToFlux(User.class);
				        
		userFlux.subscribe(System.out::println);
	}


}
