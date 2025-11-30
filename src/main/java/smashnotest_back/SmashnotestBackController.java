package smashnotest_back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smashnotest_back.matchups.presentation.dtos.RegistroDTO;
import smashnotest_back.matchups.data.entitys.*;
import smashnotest_back.matchups.data.repositorys.*;
import smashnotest_back.matchups.business.services.RegistroService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import smashnotest_back.matchups.presentation.dtos.RegistroCreateDTO;
import smashnotest_back.matchups.presentation.dtos.RegistroUpdateDTO;

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
    private ComboRepository comboRepository;
    @Autowired
    private AtaqueRepository ataqueRepository;
    @Autowired
    private RegistroService registroService;

    // Ruta de testing , importante para comprobar que funciona app sin conexion bd:
    @GetMapping(value = "/tLocalDeploy")
    public String testLocalDeploy() {
        System.out.println("Hola mundo desde logs");
        return "Hola22!Empoleon:ruta => http://127.0.0.1:8080/apiSmash/tLocalDeploy";
    }

    @GetMapping(value = "/tCloudDeploy")
    public String testCloudDeploy() {
        System.out.println("Hola mundo desde logs");
        return "Hola11 !Torterra:ruta=> https://smashnotes-springboot-back-1.onrender.com/apiSmash/tCloudDeploy";
    }

    @GetMapping("/Registro")
    public List<RegistroDTO> getListRegistros(
            @RequestParam(required = false) String filtroEmisor,
            @RequestParam(required = false) String filtroReceptor,
            @RequestParam(required = false) String filtroMovimiento,
            @RequestParam(required = false) String filtroStage,
            @RequestParam(required = false) String filtroPosicion,
            @RequestParam(required = false) String filtroRage) {
        // System.out.println para depuración
        System.out.println("desde el controller el valor de filtroEmisor es: " + filtroEmisor);
        System.out.println("desde el controller el valor de filtroReceptor es: " + filtroReceptor);
        System.out.println("desde el controller el valor de filtroMovimiento es: " + filtroMovimiento);
        System.out.println("desde el controller el valor de filtroStage es: " + filtroStage);
        System.out.println("desde el controller el valor de filtroPosicion es: " + filtroPosicion);
        System.out.println("desde el controller el valor de filtroRage es: " + filtroRage);

        // Llamada al service
        return registroService.getRegistrosFiltrados(filtroEmisor, filtroReceptor, filtroMovimiento, filtroStage,
                filtroPosicion, filtroRage);
    }

    @PostMapping("/Registro")
    public Registro insertarRegistro(@RequestBody RegistroCreateDTO dto) {
        Registro registro = new Registro();

        Personaje emisor = new Personaje();
        emisor.setId(dto.idPersonajeEmisor);
        registro.setIdPersonajeEmisor(emisor);

        Personaje receptor = new Personaje();
        receptor.setId(dto.idPersonajeReceptor);
        registro.setIdPersonajeReceptor(receptor);

        Escenario escenario = new Escenario();
        escenario.setId(dto.idEscenario);
        registro.setIdEscenario(escenario);

        Posicion posicion = new Posicion();
        posicion.setId(dto.idPosicion != null ? dto.idPosicion : 1);
        registro.setIdPosicion(posicion);

        // Lógica para Ataque (Movimiento o Combo)
        if ("1".equals(dto.tipoAtaque)) {
            // Es un Movimiento
            Movimiento movimiento = new Movimiento();
            movimiento.setId(dto.idAtaque);
            registro.setIdMovimiento(movimiento);
            registro.setIdCombo(null);
            registro.setTipoAtaque("1");

            // Buscar Ataque correspondiente
            Ataque ataque = ataqueRepository.findByIdMovimiento(dto.idAtaque).orElse(null);
            if (ataque != null) {
                registro.setIdAtaque(ataque);
            }
        } else if ("2".equals(dto.tipoAtaque)) {
            // Es un Combo
            Combo combo = new Combo();
            combo.setId(dto.idAtaque);
            registro.setIdCombo(combo);
            registro.setIdMovimiento(null);
            registro.setTipoAtaque("2");

            // Buscar Ataque correspondiente
            Ataque ataque = ataqueRepository.findByIdCombo(dto.idAtaque).orElse(null);
            if (ataque != null) {
                registro.setIdAtaque(ataque);
            }
        }

        registro.setRage(dto.rage);
        registro.setDi(dto.di);
        registro.setPorcentajeKO(dto.porcentajeKO);

        return registroService.insertarRegistro(registro);
    }

    @PutMapping("/Registro")
    public ResponseEntity<String> updateRegistro(@RequestBody RegistroUpdateDTO dto) {
        System.out.println("UPDATE REGISTRO - START");
        System.out.println("DTO idAtaque: " + dto.idAtaque);
        System.out.println("DTO tipoAtaque: " + dto.tipoAtaque);

        Registro registro = registroService.obtenerRegistroPorId(dto.id);
        if (registro == null) {
            return ResponseEntity.badRequest().body("Registro no encontrado");
        }

        Personaje emisor = new Personaje();
        emisor.setId(dto.idPersonajeEmisor);
        registro.setIdPersonajeEmisor(emisor);

        Personaje receptor = new Personaje();
        receptor.setId(dto.idPersonajeReceptor);
        registro.setIdPersonajeReceptor(receptor);

        Escenario escenario = new Escenario();
        escenario.setId(dto.idEscenario);
        registro.setIdEscenario(escenario);

        Posicion posicion = new Posicion();
        posicion.setId(dto.idPosicion != null ? dto.idPosicion : 1);
        registro.setIdPosicion(posicion);

        // Lógica para Ataque (Movimiento o Combo)
        if ("1".equals(dto.tipoAtaque)) {
            System.out.println("Procesando como MOVIMIENTO");
            // Es un Movimiento
            Movimiento movimiento = new Movimiento();
            movimiento.setId(dto.idAtaque);
            registro.setIdMovimiento(movimiento);
            registro.setIdCombo(null);
            registro.setTipoAtaque("1");

            // Buscar Ataque correspondiente
            Ataque ataque = ataqueRepository.findByIdMovimiento(dto.idAtaque).orElse(null);
            System.out.println("Ataque encontrado (Movimiento): " + (ataque != null ? ataque.getId() : "NULL"));
            if (ataque != null) {
                registro.setIdAtaque(ataque);
            } else {
                // Fallback: Si no se encuentra el ataque, intentamos mantener el existente si
                // coincide el tipo, o lo dejamos null
                System.out.println("WARNING: No se encontró Ataque para Movimiento ID: " + dto.idAtaque);
                registro.setIdAtaque(null);
            }
        } else if ("2".equals(dto.tipoAtaque)) {
            System.out.println("Procesando como COMBO");
            // Es un Combo
            Combo combo = new Combo();
            combo.setId(dto.idAtaque);
            registro.setIdCombo(combo);
            registro.setIdMovimiento(null);
            registro.setTipoAtaque("2");

            // Buscar Ataque correspondiente
            Ataque ataque = ataqueRepository.findByIdCombo(dto.idAtaque).orElse(null);
            System.out.println("Ataque encontrado (Combo): " + (ataque != null ? ataque.getId() : "NULL"));
            if (ataque != null) {
                registro.setIdAtaque(ataque);
            } else {
                System.out.println("WARNING: No se encontró Ataque para Combo ID: " + dto.idAtaque);
                registro.setIdAtaque(null);
            }
        } else {
            System.out.println("Tipo de ataque no reconocido o nulo: " + dto.tipoAtaque);
        }

        registro.setPorcentajeKO(dto.porcentajeKO);
        registro.setRage(dto.rage);
        registro.setDi(dto.di);

        registroService.actualizarRegistro(registro);
        System.out.println("UPDATE REGISTRO - END");

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

    @GetMapping("/Combo")
    public String getCombos() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(comboRepository.findAll());
    }
}
