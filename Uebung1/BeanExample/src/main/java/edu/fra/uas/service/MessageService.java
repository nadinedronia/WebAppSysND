package edu.fra.uas.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//Markiert die Klasse als Spring-Bean, damit sie automatisch von Spring verwaltet wird
import org.springframework.stereotype.Component;

//Registriert die Klasse als Bean in Spring. Sie kann in anderen Klassen injiziert werden.
@Component
public class MessageService {

    // gleiches Pattern wie in deiner BeanExampleApplication
    //erstellt einen Logger für diese Klasse.
    private static final Logger log = LoggerFactory.getLogger(MessageService.class);

    private String message;

    public String getMessage() {
        // Diagnose-Log: Aufruf + Zustand
        log.debug("getMessage() called -> returning message (len={}, null={})",
                  message == null ? 0 : message.length(),
                  message == null);
        return message;
    }

    public void setMessage(String message) {
        // sinnvolle Zusatzinfos: alt -> neu (nur Längen/Null-Status, kein Klartext)
        int oldLen = this.message == null ? 0 : this.message.length();
        int newLen = message == null ? 0 : message.length();

        log.debug("setMessage(...) called -> length {} -> {} (oldNull={}, newNull={})",
                  oldLen, newLen, this.message == null, message == null);

        this.message = message;

        // sichtbares Event (INFO) – wird ohne Extra-Config angezeigt
        log.info("Message updated (length={})", newLen);
    }
}


