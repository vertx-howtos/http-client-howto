plugins {
  java
  application
}

repositories {
  mavenCentral()
}

dependencies {
  val vertxVersion = "3.6.3"
  implementation("io.vertx:vertx-core:${vertxVersion}")
  implementation("io.vertx:vertx-web-client:${vertxVersion}")
}

application {
  mainClassName = "io.vertx.howtos.httpclient.JokeVerticle"
}

tasks.wrapper {
  gradleVersion = "5.2"
}
