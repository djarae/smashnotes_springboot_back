package smashnotest_back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smashnotest_back.matchups.data.repositorys.RegistroRepository;
import smashnotest_back.matchups.data.entitys.Registro;
import smashnotest_back.dtos.RegistroDTO;

import java.util.List;

@Service
public class RegistroService {

    @Autowired
    private RegistroRepository registroRepository;

    // Guardar un registro
    public Registro insertarRegistro(Registro registro) {
        return registroRepository.save(registro);
    }

    // Actualizar un registro existente
    public Registro actualizarRegistro(Registro registro) {
        return registroRepository.save(registro);
    }

    // Eliminar un registro por ID
    public void eliminarRegistro(int id) {
        registroRepository.deleteById(id);
    }

    // Obtener todos los registros sin filtros
    public List<Registro> getAllRegistros() {
        return registroRepository.findAll();
    }

    // Obtener registros filtrados con DTO (para front)
    // Obtener registros filtrados con DTO (para front)
    public List<RegistroDTO> getRegistrosFiltrados(
            String filtroEmisor,
            String filtroReceptor,
            String filtroMovimiento,
            String filtroStage,
            String filtroPosicion,
            Integer filtroRage
    ) {
        System.out.println("avancee---------------------------------------------");
        // Agregar % para LIKE, o null si no hay filtro
        List<RegistroDTO> resultados = registroRepository.findRegistrosFiltrados(
                filtroEmisor != null && !filtroEmisor.isEmpty() ? "%" + filtroEmisor + "%" : null,
                filtroReceptor != null && !filtroReceptor.isEmpty() ? "%" + filtroReceptor + "%" : null,
                filtroMovimiento != null && !filtroMovimiento.isEmpty() ? "%" + filtroMovimiento + "%" : null,
                filtroStage != null && !filtroStage.isEmpty() ? "%" + filtroStage + "%" : null,
                filtroPosicion != null && !filtroPosicion.isEmpty() ? "%" + filtroPosicion + "%" : null,
                filtroRage
        );

        System.out.println("Resultados obtenidos------------------------------------------------: " + resultados.size());
        resultados.forEach(r -> System.out.println(
                "RegistroDTO: id=" + r.getId() +
                        ", emisor=" + r.getNombrePersonajeEmisor() +
                        ", receptor=" + r.getNombrePersonajeReceptor() +
                        ", movimiento=" + r.getNombreMovimiento() +
                        ", escenario=" + r.getNombreEscenario() +
                        ", posicion=" + r.getNombrePosicion()
        ));

        return resultados;
    }

}
