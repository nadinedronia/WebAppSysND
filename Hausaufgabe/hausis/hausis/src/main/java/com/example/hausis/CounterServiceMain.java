package com.example.hausis;
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//@SpringBootApplication
public class CounterServiceMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(CounterServiceMain.class, args);

        ServiceA a = ctx.getBean(ServiceA.class);
        ServiceB b = ctx.getBean(ServiceB.class);
        ServiceC c = ctx.getBean(ServiceC.class);

        a.doSomething(); // Counter: 1
        b.doSomething(); // Counter: 2
        c.doSomething(); // Counter: 3
    }
}
