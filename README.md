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

```
implementation "cl.emilym.kmp:parcelable:<latest>"
```

## Usage
Add the `kotlin-parcelize` class to your plugins:

```kotlin
CompositionLocalProvider(
    LocalBaseDp provides 8.dp
) {
    // Box is sized to 16dp by 16dp
    Box(Modifier.size(2.rdp))
}
```
