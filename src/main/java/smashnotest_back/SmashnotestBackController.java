package smashnotest_back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import smashnotest_back.dtos.RegistroDTO;
import smashnotest_back.matchups.data.entitys.*;
import smashnotest_back.matchups.data.repositorys.*;
import smashnotest_back.services.RegistroService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@RestController
@RequestMapping("apiSmash")
public class SmashnotestBackController {

    @Autowired
    private PersonajeRepository personajeRepository;
    @Autowired
    private MovimientoRepository movimientoRepository;
    @Autowired
    private EscenarioRepository escenarioRepository;
    @Autowired
    private PosicionRepository posicionRepository;
    @Autowired
    private RegistroService registroService;

    @GetMapping("/Registro")
    public List<RegistroDTO> getListRegistros() {
        return registroService.getRegistrosFiltrados(null, null, null, null, null, null);
    }

    @PostMapping("/Registro")
    public Registro insertRegistro(@RequestBody Registro registro) {
        return registroService.insertarRegistro(registro);
    }

    @PutMapping("/Registro")
    public Registro updateRegistro(@RequestBody Registro registro) {
        return registroService.actualizarRegistro(registro);
    }

    @DeleteMapping("/Registro/{id}")
    public void deleteRegistro(@PathVariable Long id) {
        registroService.eliminarRegistro(id);
    }

    @GetMapping("/Escenarios")
    public List<Escenario> getListEscenarios() {
        return escenarioRepository.findAll();
    }

    @GetMapping("/Personajes")
    public String getListPersonajes() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(personajeRepository.findAll());
    }

    @GetMapping("/Movimientos")
    public String getMovimientos() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(movimientoRepository.findAll());
    }

    @GetMapping("/Posiciones")
    public List<Posicion> getListPosiciones() {
        return posicionRepository.findAll();
    }
}
