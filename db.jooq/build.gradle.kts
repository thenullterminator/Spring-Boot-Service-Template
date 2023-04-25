plugins {
    kotlin("jvm") version "1.7.22"
    id("nu.studer.jooq") version "8.2"
}

group = "world.good2go"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    jooqGenerator("mysql:mysql-connector-java:8.0.33")
}

jooq {
    version.set("3.18.2")
    edition.set(nu.studer.gradle.jooq.JooqEdition.OSS)
    configurations {
        create("main") {
            generateSchemaSourceOnCompilation.set(false) // making it false, since we do not want to run it on each build.

            jooqConfiguration.apply {
                logging = org.jooq.meta.jaxb.Logging.WARN
                jdbc.apply {
                    driver = "com.mysql.cj.jdbc.Driver"
                    url = "jdbc:mysql://localhost:3306/good2go"
                    user = "root"
                    password = "7083720235"
                    properties.add(
                        org.jooq.meta.jaxb.Property().apply {
                            key = "ssl"
                            value = "true"
                        },
                    )
                }
                generator.apply {
                    name = "org.jooq.codegen.KotlinGenerator"
                    database.apply {
                        name = "org.jooq.meta.mysql.MySQLDatabase"
                        inputSchema = "good2go"
                        // commenting it to get rid of jooq warning for now.
//                        forcedTypes.addAll(
//                            listOf(
//                                ForcedType().apply {
//                                    name = "varchar"
//                                    includeExpression = ".*"
//                                    includeTypes = "JSONB?"
//                                },
//                                ForcedType().apply {
//                                    name = "varchar"
//                                    includeExpression = ".*"
//                                    includeTypes = "INET"
//                                }
//                            )
//                        )
                    }
                    generate.apply {
                        isDeprecated = false
                        isRecords = true
                        isImmutablePojos = true
                        isFluentSetters = true
                    }
                    target.apply {
                        packageName = "world.good2go.db.jooq"
                        directory = "src/main/kotlin"
                    }
                    strategy.name = "org.jooq.codegen.DefaultGeneratorStrategy"
                }
            }
        }
    }
}

tasks.named("generateJooq") {
    dependsOn(":flywayMigrate")
}
