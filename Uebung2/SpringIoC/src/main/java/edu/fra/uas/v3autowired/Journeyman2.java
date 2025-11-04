package edu.fra.uas.v3autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Component;

@Component
public class Journeyman2 {
    @Autowired
   @Qualifier("pleaseHammer")
    Work work;

    public void performWork() {
        System.out.println("Journeyman2 is working:");
        work.doWork();
   }
}