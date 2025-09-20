package smashnotest_back.matchups.data.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import smashnotest_back.matchups.data.entitys.Personaje;

public interface PersonajeRepository extends JpaRepository<Personaje, Integer> {
    // Aquí puedes agregar métodos personalizados si los necesitas
}
