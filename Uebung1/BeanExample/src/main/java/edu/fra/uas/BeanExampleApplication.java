package edu.fra.uas;

import org.springframework.beans.factory.annotation.Autowired;
//Schnittstelle für Code, der nach dem Start der App einmalig läuft.
import org.springframework.boot.CommandLineRunner;
//bootstrapped die Spring-Boot-App.
import org.springframework.boot.SpringApplication;
//Meta-Annotation für Konfiguration/Autosetup/Komponentenscan.
import org.springframework.boot.autoconfigure.SpringBootApplication;
//markiert eine Fabrikmethode, deren Rückgabewert als Bean im Container registriert wird.
import org.springframework.context.annotation.Bean;

import edu.fra.uas.controller.BeanController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class BeanExampleApplication {
private static final Logger log =LoggerFactory.getLogger(BeanExampleApplication.class);
@Autowired
private BeanController beanController;
public static void main(String[] args) {
SpringApplication.run(BeanExampleApplication.class, args);
}
@Bean
CommandLineRunner init() {
CommandLineRunner action = new CommandLineRunner() {
@Override
public void run(String... args) throws Exception {
log.debug(beanController.putMessage("Hallo Welt"));
log.debug(beanController.putMessage("--> OOOHOOO <--"));
}
};
return action;
}
}