# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

EmptyDaggerProject is an Android application template configured with Hilt dependency injection (despite the "Dagger" name in the project title). The project uses Jetpack Compose for UI, Room for local database, Retrofit/OkHttp for networking, and WorkManager for background tasks.

**Package name**: `com.rpm.emptydaggerproject`

## Build Commands


```bash
# Build the project
./gradlew build

# Build debug APK
./gradlew assembleDebug

# Build release APK
./gradlew assembleRelease

# Clean build
./gradlew clean

# Run unit tests
./gradlew test

# Run specific unit test
./gradlew test --tests com.rpm.emptydaggerproject.ExampleUnitTest

# Run instrumented tests (requires emulator/device)
./gradlew connectedAndroidTest

# Run specific instrumented test
./gradlew connectedAndroidTest -Pandroid.testInstrumentationRunnerArguments.class=com.rpm.emptydaggerproject.ExampleInstrumentedTest

# Install on connected device
./gradlew installDebug
```

## Architecture

### Dependency Injection
- **Framework**: Hilt (Google's recommended DI framework)
- **KSP**: Uses KSP (Kotlin Symbol Processing) instead of KAPT for annotation processing
- The project is currently a template with Hilt configured but not yet implemented
- When adding Hilt, ensure Application class is annotated with `@HiltAndroidApp` and activities with `@AndroidEntryPoint`

### Key Dependencies
- **UI**: Jetpack Compose with Material3
- **Database**: Room (requires KSP for annotation processing)
- **Networking**: Retrofit 3.0.0 with Gson converter, OkHttp 5.2.1 with logging interceptor
- **Background Work**: WorkManager with Hilt integration
- **Data Storage**: DataStore for preferences
- **Testing**: JUnit, Espresso, MockK (both JVM and Android variants), Hilt Testing, Room Testing

### Build Configuration
- **Min SDK**: 24 (Android 7.0)
- **Target SDK**: 36
- **Compile SDK**: 36
- **JVM Toolchain**: Java 11
- **Kotlin**: 2.2.20 with Compose plugin
- **KSP version**: 1.9.23-1.0.20

### Version Catalog
Dependencies are managed via Gradle version catalog in `gradle/libs.versions.toml`. When adding dependencies, add them to the version catalog first, then reference them in `app/build.gradle.kts` using `libs.` prefix.

## Project Structure

- `app/src/main/java/com/rpm/emptydaggerproject/` - Main source code
  - `ui/theme/` - Compose theme definitions (Color, Type, Theme)
  - `MainActivity.kt` - Entry point activity
- `app/src/test/` - Unit tests (JVM)
- `app/src/androidTest/` - Instrumented tests (Android)

## Notes for Development

- The project name references "Dagger" but uses Hilt (which is built on Dagger)
- KSP is used for all annotation processing (Hilt, Room) - do not use KAPT
- Firebase dependencies are commented out in libs.versions.toml but available if needed
- The project uses version catalog for dependency management - avoid hardcoding versions in build.gradle.kts files
