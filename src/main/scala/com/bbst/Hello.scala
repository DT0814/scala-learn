package com.bbst

import org.slf4j.Logger

class Hello(log: Logger) {
  def sayHello(): Unit = {
    log.info("com.bbst.Hello, world!")
  }
}

