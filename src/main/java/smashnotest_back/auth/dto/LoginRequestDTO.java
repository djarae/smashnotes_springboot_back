package smashnotest_back.auth.dto;

public class LoginRequestDTO {

    public String email;
    public String password;

    public LoginRequestDTO() {
    }

    public LoginRequestDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
