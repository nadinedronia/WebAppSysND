package com.example.hausis;

import org.springframework.stereotype.Service;

@Service
public class CounterService {

    private int counter = 0;

    public int count() {
        counter++;
        System.out.println("Counter: " + counter);
        return counter;
    }
}