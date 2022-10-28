package projet.wcs.starter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projet.wcs.starter.models.ERole;
import projet.wcs.starter.models.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(ERole name);
}
