plugins {
  java
  application
}

repositories {
  mavenCentral()
}

dependencies {
  val vertxVersion = "4.4.1"
  implementation("io.vertx:vertx-core:${vertxVersion}")
  implementation("io.vertx:vertx-web-client:${vertxVersion}")
}

application {
  mainClass = "io.vertx.howtos.httpclient.JokeVerticle"
}
