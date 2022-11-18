package projet.wcs.starter.dto;

import jakarta.persistence.Lob;

public class UserDto {
    private String uri;
    private int id;
    private String email;
    @Lob
    private String profilePicture;

    public String getUri() {
        return "/users/".concat(String.valueOf(this.id));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
