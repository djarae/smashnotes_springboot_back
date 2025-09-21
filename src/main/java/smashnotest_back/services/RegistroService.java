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

    public Registro insertarRegistro(Registro registro) {
        return registroRepository.save(registro);
    }

    public Registro actualizarRegistro(Registro registro) {
        return registroRepository.save(registro);
    }

    public void eliminarRegistro(Long id) {
        registroRepository.deleteById(id);
    }

    public List<RegistroDTO> getRegistrosFiltrados(
            String filtroEmisor,
            String filtroReceptor,
            String filtroMovimiento,
            String filtroStage,
            String filtroPosicion,
            Integer filtroRage
    ) {
        // Imprimir todos los filtros para debug
        System.out.println("Filtros recibidos desde serice:");
        System.out.println("filtroEmisor: " + filtroEmisor);
        System.out.println("filtroReceptor: " + filtroReceptor);
        System.out.println("filtroMovimiento: " + filtroMovimiento);
        System.out.println("filtroStage: " + filtroStage);
        System.out.println("filtroPosicion: " + filtroPosicion);
        System.out.println("filtroRage: " + filtroRage);

        return registroRepository.findRegistrosFiltrados(
                filtroEmisor,
                filtroReceptor,
                filtroMovimiento,
                filtroStage,
                filtroPosicion,
                filtroRage
        );
    }
}
