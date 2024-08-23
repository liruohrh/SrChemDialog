plugins {
    `java-library`
    `maven-publish`
    id("io.izzel.taboolib") version "1.60"
    id("org.jetbrains.kotlin.jvm") version "1.6.10"
}

taboolib {
    install("common")
    install("common-5")
    install("platform-bukkit")
    install("expansion-command-helper")
    classifier = null
    version = "6.0.12-61"
    description {
        dependencies {
            name("Chemdah").with("bukkit")
            name("GermPlugin").with("bukkit")
        }
    }
}

version = "1.0.3"

tasks.jar {
    // Set the archive file name
    // This will create an output file with the given name and version, for example: 'myapp-1.0.0.jar'
    archiveFileName.set("SrChemDialog-${version}.jar")
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("ink.ptms:nms-all:1.0.0")
    compileOnly("ink.ptms.core:v11902:11902-minimize:mapped")
    compileOnly("ink.ptms.core:v11902:11902-minimize:universal")
    compileOnly(kotlin("stdlib"))
    compileOnly(fileTree("libs"))
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjvm-default=all")
    }
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
