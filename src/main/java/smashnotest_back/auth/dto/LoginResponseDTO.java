package smashnotest_back.auth.dto;

public class LoginResponseDTO {

    public String token;
    public String email;
    public String rol;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(String token, String email, String rol) {
        this.token = token;
        this.email = email;
        this.rol = rol;
    }
}
