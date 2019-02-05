package io.vertx.howtos.httpclient;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;

public class TellMeAJokeVerticle extends AbstractVerticle {

  @Override
  public void start() {
    vertx.eventBus().<JsonObject>consumer("jokes", msg -> {
      System.out.println(msg.body().getString("joke")); // <1>
      System.out.println("🤣");
      System.out.println();
    });
  }
}
