package io.vertx.howtos.httpclient;

import io.vertx.core.Vertx;

public class App {

  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new JokeApiVerticle());
    vertx.deployVerticle(new TellMeAJokeVerticle());
  }
}
