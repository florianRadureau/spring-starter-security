package projet.wcs.starter.models;

import java.util.Set;

public class RegisterRequest extends AuthRequest {
    private Set<String> role;

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}
