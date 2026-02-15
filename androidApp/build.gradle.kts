plugins {
  alias(libs.plugins.androidApplication)
  alias(libs.plugins.composeCompiler)
  alias(libs.plugins.ktlint)
}

val sdkVersion =
  libs.versions.android.sdk
    .get()
    .toInt()
val jdkVersion =
  libs.versions.java
    .get()
    .toInt()

android {
  namespace = "com.kmptemplate.app"
  compileSdk = sdkVersion

  defaultConfig {
    applicationId = "com.kmptemplate.app"
    minSdk = sdkVersion
    versionCode = 1 // You can add this code into libs.versions.toml file.
    versionName = "1.0" // You can add this code into libs.versions.toml file.

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }

  buildTypes {
    release {
      isMinifyEnabled = true
      isShrinkResources = true
      proguardFiles(
        getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro",
      )
    }
  }

  compileOptions {
    sourceCompatibility = JavaVersion.toVersion(jdkVersion)
    targetCompatibility = JavaVersion.toVersion(jdkVersion)
  }

  buildFeatures {
    compose = true
  }
}

dependencies {
  implementation(projects.shared)
  implementation(libs.androidx.activity.compose)
  implementation(libs.compose.ui)
  implementation(libs.compose.uiTooling)
  implementation(libs.compose.uiToolingPreview)
}

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(JavaVersion.toVersion(jdkVersion).toString()))
  }
}
