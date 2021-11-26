package org.acme.vertx;

import io.quarkus.vertx.ConsumeEvent;
import io.smallrye.mutiny.Uni;
import io.vertx.core.eventbus.Message;
import org.eclipse.microprofile.context.ManagedExecutor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class GreetingService {
    /*
    @Inject
    ManagedExecutor executor;
     */

    @ConsumeEvent("greeting")
    public void consume(Message<String> msg) {
        System.out.println(msg.address());
        System.out.println(msg.body());
    }

    /*
    @ConsumeEvent("greeting")
    public String consume(String name) {
        return name.toUpperCase();
    }
     */

    /*
    @ConsumeEvent("greeting")
    public Uni<String> consume2(String name) {
        return Uni.createFrom().item(() -> name.toUpperCase()).emitOn(executor);
    }

    @ConsumeEvent(value = "blocking-consumer", blocking = true)
    void consumeBlocking(String message) {
        // Something blocking
    }
    */
}
