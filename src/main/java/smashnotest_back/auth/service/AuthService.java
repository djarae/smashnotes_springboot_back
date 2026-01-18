package smashnotest_back.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import smashnotest_back.auth.dto.LoginRequestDTO;
import smashnotest_back.auth.dto.LoginResponseDTO;
import smashnotest_back.auth.entity.Usuario;
import smashnotest_back.auth.repository.UsuarioRepository;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * Autentica al usuario y devuelve un token JWT
     */
    public LoginResponseDTO login(LoginRequestDTO request) throws AuthenticationException {
        // Autenticamos con Spring Security
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email, request.password));

        // Si llegamos aquí, la autenticación fue exitosa
        Usuario usuario = usuarioRepository.findByEmail(request.email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Generamos el token JWT
        String token = jwtService.generateToken(usuario);

        return new LoginResponseDTO(token, usuario.getEmail(), usuario.getRol());
    }
}
