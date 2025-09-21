package smashnotest_back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smashnotest_back.dtos.RegistroDTO;
import smashnotest_back.matchups.data.entitys.*;
import smashnotest_back.matchups.data.repositorys.*;
import smashnotest_back.services.RegistroService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import smashnotest_back.dtos.RegistroCreateDTO;
import smashnotest_back.dtos.RegistroUpdateDTO;

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
    public List<RegistroDTO> getListRegistros(
            @RequestParam(required = false) String filtroEmisor,
            @RequestParam(required = false) String filtroReceptor,
            @RequestParam(required = false) String filtroMovimiento,
            @RequestParam(required = false) String filtroStage,
            @RequestParam(required = false) String filtroPosicion,
            @RequestParam(required = false) String filtroRage
    ) {
        // System.out.println para depuración
        System.out.println("desde el controller el valor de filtroEmisor es: " + filtroEmisor);
        System.out.println("desde el controller el valor de filtroReceptor es: " + filtroReceptor);
        System.out.println("desde el controller el valor de filtroMovimiento es: " + filtroMovimiento);
        System.out.println("desde el controller el valor de filtroStage es: " + filtroStage);
        System.out.println("desde el controller el valor de filtroPosicion es: " + filtroPosicion);
        System.out.println("desde el controller el valor de filtroRage es: " + filtroRage);

        // Llamada al service
        return registroService.getRegistrosFiltrados(filtroEmisor, filtroReceptor, filtroMovimiento, filtroStage, filtroPosicion, filtroRage);
    }


    @PostMapping("/Registro")
    public Registro insertarRegistro(@RequestBody RegistroCreateDTO dto) {
        Registro registro = new Registro();

        Personaje emisor = new Personaje();
        emisor.setId(dto.idPersonajeEmisor);

        Personaje receptor = new Personaje();
        receptor.setId(dto.idPersonajeReceptor);

        Movimiento movimiento = new Movimiento();
        movimiento.setId(dto.idMovimiento);

        Escenario escenario = new Escenario();
        escenario.setId(dto.idEscenario);

        Posicion posicion = new Posicion();
        posicion.setId(1);

        registro.setIdPersonajeEmisor(emisor);
        registro.setIdPersonajeReceptor(receptor);
        registro.setIdMovimiento(movimiento);
        registro.setIdEscenario(escenario);
        registro.setIdPosicion(posicion);

        registro.setRage(dto.rage);
        registro.setDi(dto.di);  // ✅ directo, ya es Boolean
        registro.setPorcentajeKO(dto.porcentajeKO);

        return registroService.insertarRegistro(registro);
    }




    @PutMapping("/Registro")
    public ResponseEntity<String> updateRegistro(@RequestBody RegistroUpdateDTO dto) {
        Registro registro = new Registro();
        registro.setId(dto.id);

        Personaje emisor = new Personaje();
        emisor.setId(dto.idPersonajeEmisor);
        registro.setIdPersonajeEmisor(emisor);

        Personaje receptor = new Personaje();
        receptor.setId(dto.idPersonajeReceptor);
        registro.setIdPersonajeReceptor(receptor);

        Movimiento movimiento = new Movimiento();
        movimiento.setId(dto.idMovimiento);
        registro.setIdMovimiento(movimiento);

        Escenario escenario = new Escenario();
        escenario.setId(dto.idEscenario);
        registro.setIdEscenario(escenario);

        Posicion posicion = new Posicion();
        posicion.setId(dto.idPosicion != null ? dto.idPosicion : 1);
        registro.setIdPosicion(posicion);

        registro.setPorcentajeKO(dto.porcentajeKO);
        registro.setRage(dto.rage);
        registro.setDi(dto.di);

        registroService.actualizarRegistro(registro);

        return ResponseEntity.ok("Registro actualizado correctamente");
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
