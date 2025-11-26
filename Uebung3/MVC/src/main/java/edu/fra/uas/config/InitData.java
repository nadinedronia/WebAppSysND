package edu.fra.uas.config;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.fra.uas.model.User;
import edu.fra.uas.service.UserService;
import jakarta.annotation.PostConstruct;

// InitData ist eine Spring Komponente
// Diese Klasse wird beim Start der Anwendung von Spring erzeugt
@Component
public class InitData {

    // Logger fuer Log Meldungen beim Initialisieren der Daten
    private final Logger log = org.slf4j.LoggerFactory.getLogger(InitData.class);
    
    // Der UserService wird von Spring injiziert
    // Ueber diesen Service werden die User spaeter gespeichert
    @Autowired
    UserService userService;

    // Die init Methode wird nach Erzeugen dieser Bean genau ein Mal automatisch aufgerufen
    // Die PostConstruct Annotation sorgt fuer diesen Aufruf direkt nach dem Start
    @PostConstruct
    public void init() {
        log.debug("### Initialize Data ###");

        // Ersten User anlegen mit Rolle ADMIN und in der Datenbank speichern
        log.debug("create user admin");
        User user = new User();
        user.setRole("ADMIN");
        user.setFirstName("Administrator");
        user.setLastName("Administrator");
        user.setEmail("admin@example.com");
        user.setPassword("extremeSecurePassword1234");
        // Uebergabe des User Objekts an den Service der es abspeichert
        userService.createUser(user);

        // Zweiten User Alice anlegen und speichern
        log.debug("create user alice");
        user = new User();
        user.setRole("USER");
        user.setFirstName("Alice");
        user.setLastName("Adams");
        user.setEmail("alice@example.com");
        user.setPassword("alice1234");
        userService.createUser(user);

        // Dritten User Bob anlegen und speichern
        log.debug("create user bob");
        user = new User();
        user.setRole("USER");
        user.setFirstName("Bob");
        user.setLastName("Builder");
        user.setEmail("bob@example.com");
        user.setPassword("bob1234");
        userService.createUser(user);

        log.debug("### Data initialized ###");
    }

}
