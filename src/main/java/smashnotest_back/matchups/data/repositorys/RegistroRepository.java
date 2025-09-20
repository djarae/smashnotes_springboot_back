package smashnotest_back.matchups.data.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smashnotest_back.matchups.data.entitys.Registro;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Integer> {
}
