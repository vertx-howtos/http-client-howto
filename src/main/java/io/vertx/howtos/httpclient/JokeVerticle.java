package io.vertx.howtos.httpclient;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.client.HttpRequest;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.predicate.ResponsePredicate;
import io.vertx.ext.web.codec.BodyCodec;

public class JokeVerticle extends AbstractVerticle {

  private HttpRequest<JsonObject> request;

  @Override
  public void start() {

    request = WebClient.create(vertx) // <1>
      .get(443, "icanhazdadjoke.com", "/") // <2>
      .ssl(true)  // <3>
      .putHeader("Accept", "application/json")  // <4>
      .as(BodyCodec.jsonObject()) // <5>
      .expect(ResponsePredicate.SC_OK);  // <6>

    vertx.setPeriodic(3000, id -> fetchJoke());
  }

  private void fetchJoke() {
    request.send(asyncResult -> {
      if (asyncResult.succeeded()) {
        System.out.println(asyncResult.result().body().getString("joke")); // <7>
        System.out.println("🤣");
        System.out.println();
      }
    });
  }

  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new JokeVerticle());
  }
}
