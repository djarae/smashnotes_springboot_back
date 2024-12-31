package smashnotes_springboot_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmashnotesSpringbootBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmashnotesSpringbootBackApplication.class, args);
		System.out.println("Conexion exitosa");
	}

}
