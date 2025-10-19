package smashnotest_back.matchups.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smashnotest_back.matchups.data.repositorys.RegistroRepository;
import smashnotest_back.matchups.data.entitys.Registro;
import smashnotest_back.matchups.presentation.dtos.RegistroDTO;

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
            String filtroRageStr
    ) {

        // Normalizar filtros: null si está vacío o "undefined"
        filtroEmisor = (filtroEmisor == null || filtroEmisor.isEmpty() || filtroEmisor.equals("undefined")) ? null : filtroEmisor;
        filtroReceptor = (filtroReceptor == null || filtroReceptor.isEmpty() || filtroReceptor.equals("undefined")) ? null : filtroReceptor;
        filtroMovimiento = (filtroMovimiento == null || filtroMovimiento.isEmpty() || filtroMovimiento.equals("undefined")) ? null : filtroMovimiento;
        filtroStage = (filtroStage == null || filtroStage.isEmpty() || filtroStage.equals("undefined")) ? null : filtroStage;
        filtroPosicion = (filtroPosicion == null || filtroPosicion.isEmpty() || filtroPosicion.equals("undefined")) ? null : filtroPosicion;

        Integer filtroRage = null;
        if (filtroRageStr != null && !filtroRageStr.isEmpty() && !filtroRageStr.equals("undefined")) {
            try {
                filtroRage = Integer.parseInt(filtroRageStr);
            } catch (NumberFormatException e) {
                filtroRage = null; // fallback seguro
            }
        }

        System.out.println("Filtros recibidos desde Service:");
        System.out.println("filtroEmisor: " + filtroEmisor);
        System.out.println("filtroReceptor: " + filtroReceptor);
        System.out.println("filtroMovimiento: " + filtroMovimiento);
        System.out.println("filtroStage: " + filtroStage);
        System.out.println("filtroPosicion: " + filtroPosicion);
        System.out.println("filtroRage: " + filtroRage);

        return registroRepository.findRegistrosFiltrados(
                filtroEmisor, filtroReceptor, filtroMovimiento,
                filtroStage, filtroPosicion, filtroRage
        );
    }


}
