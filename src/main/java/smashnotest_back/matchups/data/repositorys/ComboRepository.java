package smashnotest_back.matchups.data.repositorys;

import smashnotest_back.matchups.data.entitys.Combo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComboRepository extends JpaRepository<Combo, Integer> {
}
