package projet.wcs.starter.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projet.wcs.starter.dao.User;
import projet.wcs.starter.dto.UserDto;
import projet.wcs.starter.repositories.UserRepository;
import projet.wcs.starter.services.UserDetailsImpl;

import java.util.List;
import java.util.stream.Collectors;

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
        ).collect(Collectors.toList());
    }

    @GetMapping("/me")
    public UserDto me() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = repo.findById(userDetails.getId()).get();
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }


}
