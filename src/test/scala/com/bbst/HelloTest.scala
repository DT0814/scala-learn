package com.bbst

import org.mockito.Mockito._
import org.scalatest.funsuite.AnyFunSuite
import org.slf4j.Logger

class HelloTest extends AnyFunSuite {
  test("should log hello world.") {
    val logger: Logger = mock(classOf[Logger])
    val hello = new Hello(logger)

    hello.sayHello()
    verify(logger, times(1)).info("com.bbst.Hello, world!")
  }
}
