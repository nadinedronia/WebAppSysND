package edu.fra.uas.v3autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MasterV3 {

    private final Journeyman journeyman;
    private final Journeyman2 journeyman2;

    public MasterV3(Journeyman journeyman, Journeyman2 journeyman2) {
        this.journeyman = journeyman;
        this.journeyman2 = journeyman2;
    }

    public void delegateWork() {
        journeyman.performWork();
        journeyman2.performWork();
    }
}
