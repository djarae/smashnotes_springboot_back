package smashnotest_back.matchups.data.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import smashnotest_back.matchups.data.entitys.Registro;

public interface RegistroRepository extends JpaRepository<Registro, Integer> {
    // Aquí puedes agregar queries personalizadas si quieres
}
