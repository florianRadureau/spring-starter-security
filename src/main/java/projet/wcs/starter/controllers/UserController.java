package projet.wcs.starter.controllers;

import jakarta.validation.Valid;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.dao.User;
import projet.wcs.starter.dto.UserDto;
import projet.wcs.starter.repositories.UserRepository;
import projet.wcs.starter.services.UserDetailsImpl;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository repo;

    @Autowired
    private ModelMapper modelMapper;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<UserDto> list() {
        return repo.findAll().stream().map(
                user -> modelMapper.map(user, UserDto.class)
        ).toList();
    }

    @GetMapping("/me")
    public UserDto me() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> user = repo.findById(userDetails.getId());
        if (user.isPresent()) {
            return modelMapper.map(user, UserDto.class);
        } else {
            throw new ObjectNotFoundException(userDetails.getId(), "User");
        }
    }

    @PutMapping("/me")
    public UserDto updateMe(@RequestBody @Valid UserDto userDto) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> optionalUser = repo.findById(userDetails.getId());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setProfilePicture(userDto.getProfilePicture().getBytes());
            user.setEmail(userDto.getEmail());
            user = repo.save(user);
            return modelMapper.map(user, UserDto.class);
        } else {
            throw new ObjectNotFoundException(userDetails.getId(), User.class.toGenericString());
        }

    }


}
