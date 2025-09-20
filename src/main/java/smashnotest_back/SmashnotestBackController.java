package smashnotest_back;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import smashnotest_back.configs.Configs;
import smashnotest_back.matchups.data.entitys.Personaje;
import smashnotest_back.matchups.data.entitys.Escenario;
import smashnotest_back.matchups.data.repositorys.EscenarioRepository;
//import smashnotest_back.model.Escenario;
import smashnotest_back.matchups.data.entitys.Posicion;
import smashnotest_back.matchups.data.repositorys.PosicionRepository;
import smashnotest_back.model.Registro;
import smashnotest_back.matchups.data.repositorys.PersonajeRepository;
import smashnotest_back.services.RegistroService;
import java.util.ArrayList;
import java.util.List;
import smashnotest_back.matchups.data.entitys.Movimiento;
import smashnotest_back.matchups.data.repositorys.MovimientoRepository;

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


    //Constructor:(A FUTURO BORRARLO )

    public  SmashnotestBackController()
    {
        Configs.ConexionDB();
    }
    
        //Ruta de testing , importante para comprobar que funciona app sin conexion bd:
        @GetMapping(value = "/tLocalDeploy" )
        public String testLocalDeploy() {
            System.out.println("Hola mundo desde logs");
            return "Hola22!Empoleon:ruta => http://127.0.0.1:8080/apiSmash/tLocalDeploy";
        }
        @GetMapping(value = "/tCloudDeploy" )
        public String testCloudDeploy() {
            System.out.println("Hola mundo desde logs");
            return "Hola11 !Torterra:ruta=> https://smashnotes-springboot-back-1.onrender.com/apiSmash/tCloudDeploy";
        }


    //Auth:

    //Registros:
    @GetMapping("/Registro")
    public String GetListRegistros(@RequestParam(required = false)
                                       String filtroEmisor,
                                       String filtroReceptor,
                                       String filtroRage,
                                       String filtroPosicion,
                                       String filtroStage,
                                       String filtroMovimiento)
            throws SQLException, JsonProcessingException {

            System.out.println("filtroMovimiento");
            System.out.println(filtroMovimiento);

        return RegistroService.GetRegistros(
                filtroEmisor,
                filtroReceptor,
                filtroRage,
                filtroPosicion,
                filtroStage,
                filtroMovimiento);
    }

        @PostMapping("/Registro")
        public String InsertRegistro(@RequestBody Registro registro) throws SQLException, JsonProcessingException {
            RegistroService.InsertRegistro(registro);
            return "OK";
        }

        @PutMapping("/Registro")
        public String updateRegistro(@RequestBody Registro registro) throws SQLException, JsonProcessingException {
            //  System.out.println("Entreo al update registtro vale_");
            // System.out.println(registro.getPorcentajeKO());
            RegistroService.updateService(registro);  // Llama al servicio de actualización
            return "Registro actualizado correctamente";  // Mensaje de éxito
        }

        @DeleteMapping("/Registro/{id}")
        public String deleteRegistro(@PathVariable int id) throws SQLException, JsonProcessingException {
            RegistroService.deleteService(id);  // Llama al servicio de eliminación
            return "Registro eliminado correctamente";  // Mensaje de éxito
        }

    //DataSources:



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



