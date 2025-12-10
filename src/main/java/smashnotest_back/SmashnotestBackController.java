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
    private AtaquePropiedadRepository ataquePropiedadRepository;
    @Autowired
    private RegistroService registroService;

    // Ruta de testing , importante para comprobar que funciona app sin conexion bd:
    @GetMapping(value = "/tLocalDeploy")
    public String testLocalDeploy() {
        return "Hola22!Empoleon:ruta => http://127.0.0.1:8080/apiSmash/tLocalDeploy";
    }

    @GetMapping(value = "/tCloudDeploy")
    public String testCloudDeploy() {
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

        // Llamada al service
        return registroService.getRegistrosFiltrados(filtroEmisor, filtroReceptor, filtroMovimiento, filtroStage,
                filtroPosicion, filtroRage);
    }

    @PostMapping("/Registro")
    public ResponseEntity<String> insertarRegistro(@RequestBody RegistroCreateDTO dto) {

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
            // Es un Movimiento - buscar en tabla ataque donde id_movimiento = dto.idAtaque
            Ataque ataque = ataqueRepository.findByIdMovimiento(dto.idAtaque).orElse(null);

            System.out.println("Prueba" + dto.tipoAtaque);

            if (ataque != null) {
                registro.setIdAtaque(ataque);
                System.out
                        .println("en registro controller registro id ataque****************" + registro.getIdAtaque());
                System.out.println("//////////////////////////////////////");
                System.out.println("//////////////////////////////////////");
                System.out.println("//////////////////////////////////////");
                System.out.println("//////////////////////////////////////");

                System.out.println("//////////////////////////////////////");
                System.out.println("//////////////////////////////////////");
                System.out.println("//////////////////////////////////////");
                System.out.println("//////////////////////////////////////");
                System.out.println("//////////////////////////////////////");

            }
        } else if ("2".equals(dto.tipoAtaque)) {
            // Es un Combo - buscar en tabla ataque donde id_combo = dto.idAtaque
            Ataque ataque = ataqueRepository.findByIdCombo(dto.idAtaque).orElse(null);
            if (ataque != null) {
                registro.setIdAtaque(ataque);
            }
        }

        // Asignar propiedad del ataque
        if (dto.idAtaquePropiedad != null) {
            AtaquePropiedad propiedad = new AtaquePropiedad();
            propiedad.setId(dto.idAtaquePropiedad);
            registro.setIdAtaquePropiedad(propiedad);
        }

        registro.setRage(dto.rage);
        registro.setDi(dto.di);
        registro.setPorcentajeKO(dto.porcentajeKO);

        System.out.println("registro tipo ataque " + registro.getIdAtaque());

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

        registroService.insertarRegistro(registro);

        return ResponseEntity.ok("Registro creado correctamente");
    }

    @PutMapping("/Registro")
    public ResponseEntity<String> updateRegistro(@RequestBody RegistroUpdateDTO dto) {

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
            // Es un Movimiento - buscar en tabla ataque donde id_movimiento = dto.idAtaque
            Ataque ataque = ataqueRepository.findByIdMovimiento(dto.idAtaque).orElse(null);
            if (ataque != null) {
                registro.setIdAtaque(ataque);
            } else {
                registro.setIdAtaque(null);
            }
        } else if ("2".equals(dto.tipoAtaque)) {
            // Es un Combo - buscar en tabla ataque donde id_combo = dto.idAtaque
            Ataque ataque = ataqueRepository.findByIdCombo(dto.idAtaque).orElse(null);
            if (ataque != null) {
                registro.setIdAtaque(ataque);
            } else {
                registro.setIdAtaque(null);
            }
        }

        // Asignar propiedad del ataque
        if (dto.idAtaquePropiedad != null) {
            AtaquePropiedad propiedad = new AtaquePropiedad();
            propiedad.setId(dto.idAtaquePropiedad);
            registro.setIdAtaquePropiedad(propiedad);
        }

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

    @GetMapping("/Combo")
    public String getCombos() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(comboRepository.findAll());
    }

    @GetMapping("/AtaquePropiedades")
    public List<AtaquePropiedad> getAtaquePropiedades() {
        return ataquePropiedadRepository.findAll();
    }

    @GetMapping("/Ataques")
    public List<Ataque> getAtaques() {
        return ataqueRepository.findAll();
    }
}
