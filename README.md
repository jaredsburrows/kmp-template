# KMP-Template

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![build](https://github.com/jaredsburrows/kmp-template/actions/workflows/build.yml/badge.svg)](https://github.com/jaredsburrows/kmp-template/actions/workflows/build.yml)
[![Twitter Follow](https://img.shields.io/twitter/follow/jaredsburrows.svg?style=social)](https://twitter.com/jaredsburrows)

A Kotlin Multiplatform template targeting Android, iOS, and Web.

## Screenshots

| Android | iOS | Web |
| --- | --- | --- |
| <img width="1280" height="2856" alt="android" src="https://github.com/user-attachments/assets/fe0923fb-7c9c-4a21-bc18-404d5a5eb482" /> | <img width="1179" height="2556" alt="ios" src="https://github.com/user-attachments/assets/7c5554de-77a2-492d-8902-509897e5cd78" /> | <img width="1728" height="1080" alt="web" src="https://github.com/user-attachments/assets/a7859761-4130-4cfc-9701-f3675472df45" /> |

## Project Structure

- `androidApp/` - Android application
- `shared/` - Common KMP code shared across all platforms
- `webApp/` - Web application (JS and WASM targets)
- `iosApp/` - iOS application (Swift entry point)

## Build and Run

### Android

```bash
./gradlew :androidApp:installDebug
```

Or use the run configuration in your IDE.

### iOS

Open `iosApp/iosApp.xcodeproj` in Xcode and run from there, or use the run configuration in your IDE.

### Web

**WASM target** (faster, modern browsers):

```bash
./gradlew :webApp:wasmJsBrowserDevelopmentRun
```

**JS target** (broader browser support):

```bash
./gradlew :webApp:jsBrowserDevelopmentRun
```

## Learn More

- [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)
- [Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/)
- [Kotlin/Wasm](https://kotl.in/wasm/)
