package smashnotest_back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import smashnotest_back.dtos.RegistroDTO;
import smashnotest_back.matchups.data.entitys.Registro;
import smashnotest_back.services.RegistroService;

import smashnotest_back.matchups.data.entitys.Posicion;
import smashnotest_back.matchups.data.repositorys.PosicionRepository;
import smashnotest_back.matchups.data.repositorys.PersonajeRepository;
import smashnotest_back.services.RegistroService;
import java.util.ArrayList;
import java.util.List;
import smashnotest_back.matchups.data.entitys.Movimiento;
import smashnotest_back.matchups.data.repositorys.MovimientoRepository;

import smashnotest_back.matchups.data.entitys.Personaje;
import smashnotest_back.matchups.data.entitys.Escenario;
import smashnotest_back.matchups.data.repositorys.EscenarioRepository;

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
        System.out.println("desde el controller antes de getRegistrosFiltrados");
        // Trae todos los registros, sin filtros
        List<RegistroDTO> resultados = registroService.getRegistrosFiltrados(null, null, null, null, null, null);

        System.out.println("Cantidad de registros obtenidos: " + resultados.size());
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


    @PostMapping("/Registro")
    public Registro insertRegistro(@RequestBody Registro registro) {
        return registroService.insertarRegistro(registro);
    }

    @PutMapping("/Registro")
    public Registro updateRegistro(@RequestBody Registro registro) {
        return registroService.actualizarRegistro(registro);
    }

    @DeleteMapping("/Registro/{id}")
    public void deleteRegistro(@PathVariable int id) {
        registroService.eliminarRegistro(id);
    }



    // Obtener todos los escenarios
    @GetMapping("/Escenarios")
    public List<Escenario> getListEscenarios() {
        return escenarioRepository.findAll();
    }


    @GetMapping("/Personajes")
    public String getListPersonajes() throws JsonProcessingException {
        List<Personaje> personajeList = personajeRepository.findAll(); // Obtiene todos los personajes desde la base de datos

        // Serializamos el objeto a JSON para enviarlo
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(personajeList);

        return json;
    }


    // Obtener todos los movimientos
    @GetMapping("/Movimientos")
    public String getMovimientos() throws JsonProcessingException {
        List<Movimiento> movimientoList = movimientoRepository.findAll(); // Usa el nombre correcto

        // Serializamos el objeto a JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(movimientoList);

        return json;
    }

    // Obtener todas las posiciones
    @GetMapping("/Posiciones")
    public List<Posicion> getListPosiciones() {
        return posicionRepository.findAll();
    }

}
