package com.example.hausis;

import org.springframework.stereotype.Service;

@Service
public class ServiceC {
    private final CounterService counterService;

    public ServiceC(CounterService counterService) {
        this.counterService = counterService;
    }

    public void doSomething() {
        counterService.count();
    }
}

