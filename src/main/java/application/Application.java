package application;

import application.entities.User;
import application.repositories.UserRepository;
import webClients.UserWebClient;

import java.util.stream.Stream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        
        UserWebClient userWebClient = new UserWebClient();
//        userWebClient.consume();
    }
    /**Notes - In order to run this application, you need the following:
     * 		npm installation
     * 		nodejs 10.13 or higher - https://nodejs.org/dist/latest-v10.x/		(node-v10.22.1-win-x64.msi)
     * 		npm install @angular/cli
     * 		Make sure Control Panel\System and Security\System -> Advanced system settings ->
     * 			PATH = C:\Users\jostroff\AppData\Roaming\npm
     * 			JAVA_HOME = C:\Program Files\Java\jdk1.8.0_241
     * 			M2_HOME = C:\opt\apache\apache-maven-3.3.9
     * 			DOCKER_TOOLBOX_INSTALL_PATH = C:\Program Files\Docker Toolbox
     *		Install Angular on STS as well.
    */
    //ng serve --open
    

    //If we get Error message of:
    //  		Note: Identify and stop the process that's listening on port 8080 or 
    //  		configure this application to listen on another port.
    //Then we need to go to Terminal/Command Line: 
    //  	>netstat -ao |find /i "listening"		->		Gives port number 8080 ... LISTENING 69904
    //  	>Taskkill /F /IM 69904					->		Kills port number 8080 so can restart.
    

    @Bean
    CommandLineRunner init(UserRepository userRepository) {
//    	long id = 1;
    	String[] data = {"John", "Julie", "Jennifer", "Helen", "Rachel"};
        return args -> {
        	for (int i = 0; i < data.length; i++) {
                User user = new User(i + 1, data[i], data[i].toLowerCase() + "@domain.com");
                UserRepository.save(user);
        	}
//            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
//            	long i = id;
//                User user = new User(id++, name, name.toLowerCase() + "@domain.com");
//                UserRepository.save(user);
//            });
            UserRepository.findAll().forEach(System.out::println);
        };
    }
    
    

}
