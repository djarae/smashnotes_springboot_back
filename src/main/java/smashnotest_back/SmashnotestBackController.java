package smashnotest_back;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import smashnotest_back.configs.Configs;
import smashnotest_back.entity.Personaje2;
import smashnotest_back.model.Escenario;
import smashnotest_back.model.Movimiento;
import smashnotest_back.model.Personaje;
import smashnotest_back.model.Registro;
import smashnotest_back.repositorys.Personaje2Repository;
import smashnotest_back.services.RegistroService;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("apiSmash")
public class SmashnotestBackController {
    @Autowired
    private Personaje2Repository personaje2Repository;

    //Constructor:
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
    @GetMapping("/Personajes")
    public String GetListPersonajes() throws SQLException, JsonProcessingException {
        Statement s = Configs.Conexion.createStatement();
        ResultSet rs = s.executeQuery ( "SELECT id, echo, nombre FROM personaje");
        List<Personaje> personajeList = new ArrayList<>();
        while (rs.next()) {
          //  System.out.println ("agregamos data al listado de ojbetos de escenario");
            Personaje itemPersonaje = new Personaje(
                    rs.getInt("id"),
                    rs.getInt("echo"),
                    rs.getString("nombre"));
            personajeList.add(itemPersonaje);
          //  System.out.println (rs.getInt("id"));
           // System.out.println (rs.getString("nombre"));
        }
        // Serializamos el objeto a json para enviarlo
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(personajeList);
        return json;
    }

    @GetMapping("/Escenarios")
    public String GetListEscenarios() throws SQLException, JsonProcessingException {
        Statement s = Configs.Conexion.createStatement();
        ResultSet rs = s.executeQuery ( "SELECT id, nombre FROM escenario where id=1 or id=2 or id=5");
        List<Escenario> escenarioList = new ArrayList<>();
        while (rs.next()) {
            Escenario itemEscenario = new Escenario(
                    rs.getInt("id"),
                    rs.getString("nombre"));
            escenarioList.add(itemEscenario);
        }
        // Serializamos el objeto a json para enviarlo
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(escenarioList);
        return json;
    }

    @GetMapping("/Movimientos")
    public String GetListMovimientos() throws SQLException, JsonProcessingException {
        Statement s = Configs.Conexion.createStatement();
        ResultSet rs = s.executeQuery("SELECT id, nombre, abreviatura FROM movimiento");

        List<Movimiento> movimientoList = new ArrayList<>();
        while (rs.next()) {
            Movimiento itemMovimiento = new Movimiento(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("abreviatura"));
            movimientoList.add(itemMovimiento);
        }
        System.out.println("movs list");
        System.out.println(movimientoList);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(movimientoList);
        return json;
    }

    @GetMapping("/personajes2")
    public String getListPersonajes() throws JsonProcessingException {
        List<Personaje2> personajeList = personaje2Repository.findAll(); // Obtiene todos los personajes desde la base de datos

        // Serializamos el objeto a JSON para enviarlo
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(personajeList);

        return json;
    }


}



