package com.kmptemplate.app

class Greeting {
  private val platform = getPlatform()

  fun greet(): String = "Hello, ${platform.name}!"
}
