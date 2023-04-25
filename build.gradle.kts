import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.0.5"
    id("io.spring.dependency-management") version "1.1.0"
    id("com.google.cloud.tools.jib") version "3.3.1"
    id("org.flywaydb.flyway") version "9.16.3"
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.spring") version "1.7.22"
}

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.flywaydb:flyway-mysql:9.16.3")
    }
}

group = "world.good2go"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

// jib configs
jib {
    from {
        image = "amazoncorretto:17.0.6-al2023"
    }
    to {
        image = "world.good2go.bishop:$version"
        tags = setOf(version, "latest") as MutableSet<String>
    }
}

// flyway configs for gradle plugin
flyway {
    url = "jdbc:mysql://localhost:3306/good2go"
    user = "root"
    password = "7083720235"
    schemas = listOf("good2go").toTypedArray()
}

repositories {
    mavenCentral()
}

dependencies {
    // kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // web
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // database
    implementation("mysql:mysql-connector-java:8.0.33")
    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation("org.jooq:jooq:3.18.2")
    implementation("org.flywaydb:flyway-mysql")
    implementation(project("db.jooq"))

    // dev tools
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // testing
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // start adding any other dependency here
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
