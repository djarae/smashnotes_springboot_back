package smashnotest_back.matchups.data.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import smashnotest_back.matchups.data.entitys.Registro;
import smashnotest_back.dtos.RegistroDTO;

import java.util.List;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Integer> {

    @Query("""
        SELECT new smashnotest_back.dtos.RegistroDTO(
            r.id,
            pe.id, pe.nombre, pe.abreviatura,
            pr.id, pr.nombre, pr.abreviatura,
            m.id, m.nombre, m.abreviatura,
            e.id, e.nombre, e.abreviatura,
            pos.id, pos.nombre,
            r.rage, r.di, r.porcentajeKO
        )
        FROM Registro r
        JOIN Personaje pe ON r.idPersonajeEmisor = pe.id
        JOIN Personaje pr ON r.idPersonajeReceptor = pr.id
        JOIN Movimiento m ON r.idMovimiento = m.id
        JOIN Escenario e ON r.idEscenario = e.id
        JOIN Posicion pos ON r.idPosicion = pos.id
        WHERE (:filtroEmisor IS NULL OR pe.nombre LIKE :filtroEmisor)
          AND (:filtroReceptor IS NULL OR pr.nombre LIKE :filtroReceptor)
          AND (:filtroMovimiento IS NULL OR m.nombre LIKE :filtroMovimiento)
          AND (:filtroStage IS NULL OR e.nombre LIKE :filtroStage)
          AND (:filtroPosicion IS NULL OR pos.nombre LIKE :filtroPosicion)
          AND (:filtroRage IS NULL OR r.rage = :filtroRage)
        ORDER BY r.id
    """)
    List<RegistroDTO> findRegistrosFiltrados(
            @Param("filtroEmisor") String filtroEmisor,
            @Param("filtroReceptor") String filtroReceptor,
            @Param("filtroMovimiento") String filtroMovimiento,
            @Param("filtroStage") String filtroStage,
            @Param("filtroPosicion") String filtroPosicion,
            @Param("filtroRage") Integer filtroRage
    );
}
