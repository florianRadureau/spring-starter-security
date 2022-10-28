package projet.wcs.starter.Configurations;

import java.util.List;

public class AuthResponse {
    private int id;
    private String email;
    private String accessToken;
    private String tokenType = "Bearer";
    private List<String> roles;

    public AuthResponse() { }

    public AuthResponse(int id, String email, String accessToken, List<String> roles) {
        this.id = id;
        this.email = email;
        this.accessToken = accessToken;
        this.roles = roles;
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

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
