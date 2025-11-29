package smashnotest_back.matchups.data.repositorys;

import smashnotest_back.matchups.data.entitys.Registro;
import smashnotest_back.matchups.presentation.dtos.RegistroDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegistroRepository extends JpaRepository<Registro, Long> {

        @Query("SELECT " +
                        "r.id as id, " +
                        "pe.id as idPersonajeEmisor, pe.nombre as nombrePersonajeEmisor, pe.abreviatura as abreviaturaEmisor, "
                        +
                        "pr.id as idPersonajeReceptor, pr.nombre as nombrePersonajeReceptor, pr.abreviatura as abreviaturaReceptor, "
                        +
                        "m.id as idMovimiento, m.nombre as nombreMovimiento, m.abreviatura as abreviaturaMovimiento, " +
                        "e.id as idEscenario, e.nombre as nombreEscenario, e.abreviatura as abreviaturaEscenario, " +
                        "pos.id as idPosicion, pos.nombre as nombrePosicion, " +
                        "r.rage as rage, r.di as di, r.porcentajeKO as porcentajeKO, " +
                        "CASE WHEN r.tipoAtaque = 'movimiento' THEN m.nombre " +
                        "     WHEN r.tipoAtaque = 'combo' THEN c.nombre " +
                        "     ELSE 'Desconocido' END as nombreAtaque, " +
                        "r.tipoAtaque as tipoAtaque, " +
                        "r.idAtaque as idAtaque " +
                        "FROM Registro r " +
                        "JOIN r.idPersonajeEmisor pe " +
                        "JOIN r.idPersonajeReceptor pr " +
                        "LEFT JOIN Movimiento m ON (r.idAtaque = m.id AND r.tipoAtaque = 'movimiento') " +
                        "LEFT JOIN Combo c ON (r.idAtaque = c.id AND r.tipoAtaque = 'combo') " +
                        "JOIN r.idEscenario e " +
                        "JOIN r.idPosicion pos " +
                        "WHERE (:filtroEmisor IS NULL OR pe.nombre LIKE %:filtroEmisor%) " +
                        "AND (:filtroReceptor IS NULL OR pr.nombre LIKE %:filtroReceptor%) " +
                        "AND (:filtroMovimiento IS NULL OR (m.nombre LIKE %:filtroMovimiento% OR c.nombre LIKE %:filtroMovimiento%)) "
                        +
                        "AND (:filtroStage IS NULL OR e.nombre LIKE %:filtroStage%) " +
                        "AND (:filtroPosicion IS NULL OR pos.nombre LIKE %:filtroPosicion%) " +
                        "AND (:filtroRage IS NULL OR r.rage = :filtroRage) " +
                        "ORDER BY r.id")
        List<RegistroDTO> findRegistrosFiltrados(
                        @Param("filtroEmisor") String filtroEmisor,
                        @Param("filtroReceptor") String filtroReceptor,
                        @Param("filtroMovimiento") String filtroMovimiento,
                        @Param("filtroStage") String filtroStage,
                        @Param("filtroPosicion") String filtroPosicion,
                        @Param("filtroRage") Integer filtroRage);

}
