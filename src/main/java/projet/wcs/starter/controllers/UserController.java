package projet.wcs.starter.controllers;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projet.wcs.starter.entities.User;
import projet.wcs.starter.repositories.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository repo;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<User> list() {
        return repo.findAll();
    }



}
