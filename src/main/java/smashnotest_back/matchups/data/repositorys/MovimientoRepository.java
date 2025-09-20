package smashnotest_back.matchups.data.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import smashnotest_back.matchups.data.entitys.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {
    // Puedes agregar queries personalizadas aquí si quieres
}
