package com.kmptemplate.app

interface Platform {
  val name: String
}

expect fun getPlatform(): Platform
