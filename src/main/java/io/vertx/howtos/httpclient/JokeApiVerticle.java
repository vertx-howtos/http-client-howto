package io.vertx.howtos.httpclient;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.eventbus.EventBus;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.predicate.ResponsePredicate;
import io.vertx.ext.web.codec.BodyCodec;

public class JokeApiVerticle extends AbstractVerticle {

  @Override
  public void start(Future<Void> startFuture) {
    WebClient webClient = WebClient.create(vertx);  // <1>
    EventBus eventBus = vertx.eventBus();
    vertx.setPeriodic(3000, id -> {
      webClient.get(443, "icanhazdadjoke.com", "/") // <2>
        .ssl(true)  // <3>
        .putHeader("Accept", "application/json")  // <4>
        .as(BodyCodec.jsonObject()) // <5>
        .expect(ResponsePredicate.SC_OK)  // <6>
        .send(ar -> {
          if (ar.succeeded()) {
            eventBus.publish("jokes", ar.result().body());  // <7>
          }
        });
    });
  }
}
