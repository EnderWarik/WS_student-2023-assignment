plugins {
    kotlin("jvm") version "1.8.21"

}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation ("org.apache.httpcomponents:httpclient:4.5.13")
    implementation ("com.google.code.gson:gson:2.8.8")
    testImplementation(kotlin("test"))
    testImplementation("org.testng:testng:7.1.0")
    testImplementation ("io.mockk:mockk:1.12.4")
    testImplementation("junit:junit:4.13.1")
}

tasks.test {
    useJUnitPlatform()
}
tasks.jar {
    manifest {
        attributes["Main-Class"] = "MainKt"
    }

    dependsOn(configurations.runtimeClasspath)
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })

}

kotlin {
    jvmToolchain(8)
}


