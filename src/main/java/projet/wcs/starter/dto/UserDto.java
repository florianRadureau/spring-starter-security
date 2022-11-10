package projet.wcs.starter.dto;

public class UserDto {
    private String uri;
    private int id;
    private String email;

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
}
