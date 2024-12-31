package smashnotest_back;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//Nota 17-12-2024: Ideas para ordenar codigo. Mover la conexion a otro archivo. El SQL a otras carpetas
 // e importarlo. Algunas funciones tambien y solo retornar, esto se volvio monolitico

@RestController
@RequestMapping("apiSmash")
public class SmashnotestBackController {
    //Ruta de testing , importante para comprobar que funciona app sin conexion bd:
    @GetMapping(value = "/tLocalDeploy" )
    public String testLocalDeploy() {
        return "Hola!Empoleon:ruta => http://127.0.0.1:8080/apiSmash/tLocalDeploy";
    }
    @GetMapping(value = "/tCloudDeploy" )
    public String testCloudDeploy() {
        return "Hola!Torterra:ruta=>http://https://smashnotes-springboot-back.onrender.com/apiSmash/tCloudDeploy";
    }


}
