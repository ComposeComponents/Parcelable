<p align="center">
    <a href="https://github.com/ComposeComponents/Parcelable" rel="noopener">
        <img width=150px src="https://raw.githubusercontent.com/ComposeComponents/.github/main/logo_transparent.png" ></img>
    </a>
    <h1 align="center">Kotlin Multiplatform Parcelable</h1>
    <p align="center">
        Use `@Parcelize` in your Kotlin Multiplatform Projects
    </p>
</p>

<div align="center">
    
[![Build](https://github.com/ComposeComponents/Parcelable/actions/workflows/build-library.yml/badge.svg)](https://github.com/ComposeComponents/Parcelable/actions/workflows/build-library.yml)
[![Lint](https://github.com/ComposeComponents/Parcelable/actions/workflows/lint.yml/badge.svg)](https://github.com/ComposeComponents/Parcelable/actions/workflows/lint.yml)

</div>

## Installation
![Stable](https://img.shields.io/github/v/release/ComposeComponents/Parcelable?label=Stable)
![Preview](https://img.shields.io/github/v/release/ComposeComponents/Parcelable?label=Preview&include_prereleases)

Add the `kotlin-parcelize` class to your plugins:

```kotlin
plugins {
    ...
    id("kotlin-parcelize")
}
```

then add the following line to your `androidTarget` configuration:
```kotlin
kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    freeCompilerArgs.addAll("-P", "plugin:org.jetbrains.kotlin.parcelize:additionalAnnotation=cl.emilym.kmp.parcelable.Parcelize")
                }
            }
        }
    }
}
```

then add the dependency:
```kotlin
implementation("cl.emilym.kmp:parcelable:<latest>")
```

## Usage

```kotlin
import cl.emilym.kmp.parcelable.Parcelable
import cl.emilym.kmp.parcelable.Parcelize

@Parcelize
data class Thing(
    val data: String
): Parcelable
```
