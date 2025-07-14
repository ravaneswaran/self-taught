package rave.code.spring.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SpringWebFluxTutorWebApplication {

    public static void main(String[] args) {
        /*
        * java.lang.ClassCastException: class rave.code.spring.webflux.entity.Employee
        * cannot be cast to class rave.code.spring.webflux.entity.Employee
        * (rave.code.spring.webflux.entity.Employee is in unnamed module of loader 'app';
        * rave.code.spring.webflux.entity.Employee is in unnamed module of loader
        * org.springframework.boot.devtools.restart.classloader.RestartClassLoader)
        * */
        System.setProperty("spring.devtools.restart.enabled", "false"); // this property is set false inorder to eradicate java.lang.ClassCastException
        SpringApplication.run(SpringWebFluxTutorWebApplication.class, args);
    }

}
