package com.example.hausis;

import org.springframework.stereotype.Service;

@Service
public class ServiceA {
    private final CounterService counterService;

    public ServiceA(CounterService counterService) {
        this.counterService = counterService;
    }

    public void doSomething() {
        counterService.count();
    }
}
