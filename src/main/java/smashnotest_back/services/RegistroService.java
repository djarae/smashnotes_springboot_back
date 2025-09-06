package smashnotest_back.services;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import smashnotest_back.configs.Configs;
import smashnotest_back.dtos.RegistroDTO;
import smashnotest_back.model.Registro;
import smashnotest_back.repositorys.RegistroRepository;
public class RegistroService {
    public static String GetRegistros(
            String filtroEmisor,
            String filtroReceptor,
            String filtroRage,
            String filtroPosicion,
            String filtroStage,
            String filtroMovimiento) throws SQLException, JsonProcessingException {
        System.out.println("filtro movimient");
        System.out.println(filtroMovimiento);

        ResultSet rs = RegistroRepository.getDataRegistro(
                filtroEmisor,
                filtroReceptor,
                filtroRage,
                filtroPosicion,
                filtroStage,
                filtroMovimiento);

        List<RegistroDTO> registroList = new ArrayList<>();
        System.out.println("registro <<<<asdas rs post query");
        System.out.println(rs);
        while (rs.next()) {
            RegistroDTO itemRegistro = new RegistroDTO(
                    rs.getInt("id"),
                    rs.getInt("idPersonajeEmisor"),
                    rs.getString("nombrePersonajeEmisor"),
                    rs.getString("abreviaturaPersonajeEmisor"),
                    rs.getInt("idPersonajeReceptor"),
                    rs.getString("nombrePersonajeReceptor"),
                    rs.getString("abreviaturaPersonajeReceptor"),
                    rs.getInt("idMovimiento"),
                    rs.getString("nombreMovimiento"),
                    rs.getInt("idEscenario"),
                    rs.getString("nombreEscenario"),
                    rs.getInt("idPosicion"),
                    rs.getString("nombrePosicion"),
                    rs.getInt("rage"),
                    rs.getBoolean("di"),
                    rs.getInt("porcentajeKo")
            );
            registroList.add(itemRegistro);
        };
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("registro dtolist post serializeeeeeeeeeeeeeeeeeeeeeeeeeeeeer");
        System.out.println(registroList);
        System.out.println(mapper.writeValueAsString(registroList));
        return  mapper.writeValueAsString(registroList);
    };
    public static String InsertRegistro(Registro registro) throws SQLException, JsonProcessingException {
        RegistroRepository.insertRegistro(registro);
        return "Registro insertado correctamente";
    }
    public static String updateService(Registro registro) throws SQLException, JsonProcessingException {
        System.out.println("Entreo al update reg service !!!!!!!!!!!!! vale_");
        System.out.println(registro.getPorcentajeKO());
        RegistroRepository.updateRegistro(registro);  // Llama al método update del repositorio
        return "Registro actualizado correctamente";  // Mensaje de éxito
    }
    public static String deleteService(int id) throws SQLException, JsonProcessingException {
        RegistroRepository.deleteRegistro(id);  // Llama al método delete del repositorio
        return "Registro eliminado correctamente";  // Mensaje de éxito
    }
}
