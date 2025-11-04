package edu.fra.uas.v3autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("pleaseHammer")

public class Hammering implements Work{
            private static final Logger LOGGER = LoggerFactory.getLogger(Hammering.class);

    @Override
    public void doWork() {

        // TODO Auto-generated method stub
        LOGGER.info(" --> Hammering a nail into the wall");
    }}