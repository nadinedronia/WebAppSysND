package com.example.hausis;

import org.springframework.stereotype.Service;

@Service
public class ServiceB {
    private final CounterService counterService;

    public ServiceB(CounterService counterService) {
        this.counterService = counterService;
    }

    public void doSomething() {
        counterService.count();
    }
}
