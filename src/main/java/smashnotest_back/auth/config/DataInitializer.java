package smashnotest_back.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import smashnotest_back.auth.entity.Usuario;
import smashnotest_back.auth.repository.UsuarioRepository;

/**
 * Inicializador que crea el usuario admin si no existe al iniciar la
 * aplicación.
 * Esto es útil para desarrollo y para asegurar que siempre exista el usuario
 * admin.
 */
@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Credenciales del admin (en producción, usar variables de entorno)
    private static final String ADMIN_EMAIL = "megawhitegengar@gmail.com";
    private static final String ADMIN_PASSWORD = "Secreta655%";
    private static final String ADMIN_ROL = "ADMIN";

    @Override
    public void run(String... args) {
        // Verificar si ya existe el usuario admin
        if (!usuarioRepository.existsByEmail(ADMIN_EMAIL)) {
            System.out.println("========================================");
            System.out.println("Creando usuario admin por primera vez...");
            System.out.println("========================================");

            Usuario admin = new Usuario();
            admin.setEmail(ADMIN_EMAIL);
            admin.setPassword(passwordEncoder.encode(ADMIN_PASSWORD));
            admin.setRol(ADMIN_ROL);

            usuarioRepository.save(admin);

            System.out.println("Usuario admin creado exitosamente!");
            System.out.println("Email: " + ADMIN_EMAIL);
            System.out.println("========================================");
        } else {
            System.out.println("Usuario admin ya existe, no se creará otro.");
        }
    }
}
