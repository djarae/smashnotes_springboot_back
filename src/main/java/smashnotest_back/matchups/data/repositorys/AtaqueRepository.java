package smashnotest_back.matchups.data.repositorys;

import smashnotest_back.matchups.data.entitys.Ataque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AtaqueRepository extends JpaRepository<Ataque, Integer> {

    @Query("SELECT a FROM Ataque a WHERE a.idMovimiento.id = :idMovimiento")
    Optional<Ataque> findByIdMovimiento(@Param("idMovimiento") Integer idMovimiento);

    @Query("SELECT a FROM Ataque a WHERE a.idCombo.id = :idCombo")
    Optional<Ataque> findByIdCombo(@Param("idCombo") Integer idCombo);
}
