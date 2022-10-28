package projet.wcs.starter.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.entities.User;
import projet.wcs.starter.repositories.UserRepository;

import java.net.URI;
import java.util.Arrays;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository repo;


}
