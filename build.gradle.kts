plugins {
  java
  application
}

repositories {
  mavenCentral()
}

dependencies {
  val vertxVersion = "5.0.0.CR2"
  implementation("io.vertx:vertx-core:${vertxVersion}")
  implementation("io.vertx:vertx-web-client:${vertxVersion}")
}

application {
  mainClass = "io.vertx.howtos.httpclient.JokeVerticle"
}
