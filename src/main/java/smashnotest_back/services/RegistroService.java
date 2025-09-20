package smashnotest_back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smashnotest_back.matchups.data.repositorys.RegistroRepository;
import smashnotest_back.matchups.data.entitys.Registro;

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

    public void eliminarRegistro(int id) {
        registroRepository.deleteById(id);
    }

    public List<Registro> getAllRegistros() {
        return registroRepository.findAll();
    }
}
