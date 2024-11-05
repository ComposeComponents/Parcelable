import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import com.vanniktech.maven.publish.SonatypeHost
import com.vanniktech.maven.publish.KotlinMultiplatform
import com.vanniktech.maven.publish.JavadocJar

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    id("kotlin-parcelize")
    alias(libs.plugins.dokka)
    alias(libs.plugins.mavenPublish)
}

val desc = "Use `@Parcelize` in your Kotlin Multiplatform Projects"

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_11)
                    freeCompilerArgs.addAll("-P", "plugin:org.jetbrains.kotlin.parcelize:additionalAnnotation=cl.emilym.kmp.parcelable.Parcelize")
                }
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = desc
        homepage = findProperty("pom.url") as String
        version = findProperty("version") as String
        ios.deploymentTarget = "16.0"
        framework {
            baseName = "parcelable"
            isStatic = true
        }
    }
    
    sourceSets {
        commonMain.dependencies {

        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

description = desc
group = "cl.emilym.kmp"

android {
    namespace = "cl.emilym.kmp.parcelable"
    compileSdk = 34
    defaultConfig {
        minSdk = 21
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    coordinates("cl.emilym.kmp", "parcelable", findProperty("version") as String)

    pom {
        name.set("Parcelable")
        description.set(desc)
        url.set(findProperty("pom.url") as String)
        licenses {
            license {
                name.set(findProperty("pom.license.name") as String)
                url.set(findProperty("pom.license.url") as String)
            }
        }
        developers {
            developer {
                name.set(findProperty("pom.developer.name") as String)
                email.set(findProperty("pom.developer.email") as String)
            }
        }
        scm {
            connection.set(findProperty("pom.scm.connection") as String)
            developerConnection.set(findProperty("pom.scm.developerConnection") as String)
            url.set(findProperty("pom.scm.url") as String)
        }
    }

    configure(
        KotlinMultiplatform(
            javadocJar = JavadocJar.Dokka("dokkaHtml"),
            sourcesJar = true
        )
    )

    signAllPublications()
}