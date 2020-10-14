package application.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import application.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
//@NoArgsConstructor
@AllArgsConstructor
@Entity
public @Setter @Getter class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private /*final*/ String name;
    private /*final*/ String email;
    
    public User() { //This one gets called when clicking "/adduser"
    	this.id = UserRepository.userData.size() + 1;
        this.name = "";
        this.email = "";
    }
    
    public User(String name, String email) { //Skeleton code, uncalled.
    	this.id = UserRepository.userData.size() + 1;
        this.name = name;
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", email=" + email + '}';
    }
}
