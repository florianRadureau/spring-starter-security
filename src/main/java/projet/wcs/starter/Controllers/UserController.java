package projet.wcs.starter.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.Entities.User;
import projet.wcs.starter.Repositories.UserRepository;

import java.net.URI;
import java.util.Arrays;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository repo;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid User user) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("password");
        String[] roles = {"ROLE_USER"};
        User newUser = new User("tototo@gmail.com", password, Arrays.asList(roles));
        User savedUser = repo.save(newUser);
        URI userURI = URI.create("/users/" + savedUser.getId());

        return ResponseEntity.created(userURI).body(savedUser);
    }

}
