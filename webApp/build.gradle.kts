import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
  alias(libs.plugins.kotlinMultiplatform)
  alias(libs.plugins.composeMultiplatform)
  alias(libs.plugins.composeCompiler)
  alias(libs.plugins.ktlint)
}

kotlin {
  listOf(
    js(),
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs(),
  ).forEach { target ->
    target.apply {
      outputModuleName = "kmptemplate"
      browser {
        commonWebpackConfig {
          outputFileName = "kmptemplate.js"
        }
      }
      binaries.executable()
    }
  }

  sourceSets {
    jsMain {
      dependencies {
        implementation(projects.shared)
      }
    }

    wasmJsMain {
      dependencies {
        implementation(projects.shared)
      }
    }
  }
}
