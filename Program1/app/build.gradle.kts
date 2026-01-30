plugins {
    id("org.jetbrains.kotlin.jvm") version "1.9.22"
    id("application")
}

application {
    mainClass.set("com.training.ramram.MainKt")
}

dependencies {
    testImplementation(kotlin("test"))
}