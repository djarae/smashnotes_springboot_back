package smashnotest_back.matchups.data.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import smashnotest_back.matchups.data.entitys.Posicion;

public interface PosicionRepository extends JpaRepository<Posicion, Integer> {
    // Aquí puedes agregar consultas personalizadas si lo necesitas
}
