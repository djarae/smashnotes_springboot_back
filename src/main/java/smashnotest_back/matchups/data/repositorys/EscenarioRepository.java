package smashnotest_back.matchups.data.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import smashnotest_back.matchups.data.entitys.Escenario;

public interface EscenarioRepository extends JpaRepository<Escenario, Integer> {
    // Aquí puedes agregar métodos personalizados si los necesitas
}
