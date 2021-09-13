import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    `maven-publish`
}

group = "com.github.m5rian"
val id = "Kotlingua"
version = "0.1"

repositories {
    mavenCentral()
}

tasks.test {
    useJUnit()
}

/* publishing */
val sourcesJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets["main"].allSource)
}

publishing {
    repositories {
        maven {
            name = "jfrog"
            url = uri("https://m5rian.jfrog.io/artifactory/java")
            credentials {
                username = System.getenv("JFROG_USERNAME")
                password = System.getenv("JFROG_PASSWORD")
            }
        }
    }

    publications {
        create<MavenPublication>("jfrog") {
            from(components["java"])

            group = project.group as String
            version = project.version as String
            artifactId = id

            artifact(sourcesJar)
        }
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "13"
}