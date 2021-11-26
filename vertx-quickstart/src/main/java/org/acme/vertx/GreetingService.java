package org.acme.vertx;

import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    @ConsumeEvent("greeting")
    public String consume(String name) {
        return name.toUpperCase();
    }

    @ConsumeEvent(value = "blocking-consumer", blocking = true)
    void consumeBlocking(String message) {
        // Something blocking
    }
}
