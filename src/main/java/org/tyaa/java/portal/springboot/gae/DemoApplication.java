package org.tyaa.java.portal.springboot.gae;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
    "org.tyaa.java.portal.springboot.gae.controller"
        , "org.tyaa.java.portal.springboot.gae.service"
        , "org.tyaa.java.portal.springboot.gae.dao"
})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
