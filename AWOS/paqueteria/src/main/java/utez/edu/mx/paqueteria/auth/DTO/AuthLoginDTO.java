package utez.edu.mx.paqueteria.auth.DTO;

public class AuthLoginDTO {
    private String password, user;

    public AuthLoginDTO() {
    }

    public AuthLoginDTO(String password, String user) {
        this.password = password;
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public AuthLoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUser() {
        return user;
    }

    public AuthLoginDTO setUser(String user) {
        this.user = user;
        return this;
    }
}
