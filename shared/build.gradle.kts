import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
  alias(libs.plugins.kotlinMultiplatform)
  alias(libs.plugins.androidKotlinMultiplatformLibrary)
  alias(libs.plugins.composeMultiplatform)
  alias(libs.plugins.composeCompiler)
  alias(libs.plugins.ktlint)
}

val sdkVersion =
  libs.versions.android.sdk
    .get()
    .toInt()

kotlin {
  applyDefaultHierarchyTemplate()

  // Android
  androidLibrary {
    namespace = "com.kmptemplate.library"
    compileSdk = sdkVersion
    minSdk = sdkVersion
    androidResources {
      enable = true
    }

    withHostTest {
      isIncludeAndroidResources = true
    }

    withDeviceTest {
      instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
      execution = "HOST"
    }
  }

  // iOS
  listOf(
    iosArm64(),
    iosSimulatorArm64(),
  ).forEach { target ->
    target.binaries.framework {
      baseName = "shared"
      isStatic = true
      binaryOption("bundleId", "com.kmptemplate.shared")
    }
  }

  // Web
  listOf(
    js(),
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs(),
  ).forEach { target ->
    target.apply {
      browser()
      binaries.executable()
    }
  }

  // Common
  sourceSets {
    commonMain.dependencies {
      api(libs.compose.runtime)
      api(libs.compose.foundation)
      api(libs.compose.material3)
      api(libs.compose.ui)
      api(libs.compose.components.resources)
      api(libs.compose.uiToolingPreview)
      api(libs.androidx.lifecycle.viewmodelCompose)
      api(libs.androidx.lifecycle.runtimeCompose)
    }
    commonTest.dependencies {
      api(libs.kotlin.test)
    }
  }
}
