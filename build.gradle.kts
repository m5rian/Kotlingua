import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    kotlin("plugin.serialization") version "1.5.30"
    `maven-publish`
}

group = "com.github.m5rian"
val id = "Kotlingua"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    // Serialization
    implementation(group = "org.jetbrains.kotlinx", name = "kotlinx-serialization-json", version = "1.2.2")
    // Coroutines
    implementation(group = "org.jetbrains.kotlinx", name = "kotlinx-coroutines-core", version = "1.5.2")
    implementation("org.jetbrains.kotlinx", name = "kotlinx-coroutines-jdk8", version = "1.5.2")
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