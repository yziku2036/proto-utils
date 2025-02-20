import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.text.SimpleDateFormat
import java.util.Date

buildscript {
    repositories {
        maven("https://maven.minecraftforge.net")
        mavenCentral()
    }
    dependencies {
        classpath("net.minecraftforge.gradle:ForgeGradle:5.1.+") {
            isChanging = true
        }
    }
}

plugins {
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.serialization") version "1.9.0"
    java
}
apply(plugin = "net.minecraftforge.gradle")

group = "org.example"
version = "1.0.0"

repositories {
    mavenCentral()
    maven {
        name = "Kotlin for Forge"
        setUrl("https://thedarkcolour.github.io/KotlinForForge/")
    }
}

dependencies {
    "minecraft"("net.minecraftforge:forge:1.18.2-40.2.10")
    implementation("thedarkcolour:kotlinforforge:3.12.0")
}

val Project.minecraft: net.minecraftforge.gradle.common.util.MinecraftExtension
    get() = extensions.getByType()

minecraft.let {
    it.mappings("official", "1.18.2")
    it.runs {
        create("client") {
            workingDirectory(project.file("run"))
            property("forge.logging.console.level", "debug")
            mods {
                this.create("example-mod") {
                    source(sourceSets.main.get())
                }
            }
        }
        create("server") {
            workingDirectory(project.file("run"))
            property("forge.logging.console.level", "debug")
            mods {
                this.create("example-mod") {
                    source(sourceSets.main.get())
                }
            }
        }
    }
}

tasks {
    val javaVersion = JavaVersion.VERSION_17
    withType<JavaCompile> {
        options.encoding = "UTF-8"
        sourceCompatibility = javaVersion.toString()
        targetCompatibility = javaVersion.toString()
        if (JavaVersion.current().isJava9Compatible) {
            options.release.set(javaVersion.toString().toInt())
        }
    }
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = javaVersion.toString()
            languageVersion ="2.0"
        }
    }
    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(javaVersion.toString()))
        }
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }
    withType<Jar> {
        archiveBaseName.set("example-mod")
        manifest {
            attributes(
                mapOf(
                    "Specification-Title" to project.name,
                    "Specification-Vendor" to "author",
                    "Specification-Version" to "1",
                    "Implementation-Title" to project.name,
                    "Implementation-Vendor" to "author",
                    "Implementation-Version" to project.version,
                    "Implementation-Timestamp" to SimpleDateFormat("yyyy-MM-dd").format(Date())
                )
            )
        }
        finalizedBy("reobfJar")
    }
}
