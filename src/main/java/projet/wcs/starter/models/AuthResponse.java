package projet.wcs.starter.models;

import java.util.List;

public class AuthResponse {
    private int id;
    private String email;
    private String accessToken;
    private String refreshToken;
    private String tokenType = "Bearer";
    private List<String> roles;

    public AuthResponse() { }

    public AuthResponse(int id, String email, String accessToken, List<String> roles, String refreshToken) {
        this.id = id;
        this.email = email;
        this.accessToken = accessToken;
        this.roles = roles;
        this.refreshToken = refreshToken;
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

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
