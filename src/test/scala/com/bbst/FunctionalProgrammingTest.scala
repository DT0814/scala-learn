package com.bbst

import org.mockito.Mockito.{mock, times, verify}
import org.scalatest.funsuite.AnyFunSuite
import org.slf4j.Logger

class FunctionalProgrammingTest extends AnyFunSuite {
  test("functional test") {
    val createSayHelloFun = (log: Logger) => (name: String, sex: String) => {
      sex match {
        case "man" => log.info(s"hello Mr.$name")
        case "woman" => log.info(s"hello Ms.$name")
        case _ => log.info(s"hello $name")
      }
    }

    val logger: Logger = mock(classOf[Logger])
    val sayHello = createSayHelloFun(logger)

    sayHello("zhangSan", "man")

    verify(logger, times(1)).info("hello Mr.zhangSan")
  }
  
  test("functional test2") {

    def createSayHelloFun(log: Logger): (String, String) => Unit = {
      def sayHello(name: String, sex: String): Unit = {
        sex match {
          case "man" => log.info(s"hello Mr.$name")
          case "woman" => log.info(s"hello Ms.$name")
          case _ => log.info(s"hello $name")
        }
      }

      sayHello
    }

    val logger: Logger = mock(classOf[Logger])
    val sayHello = createSayHelloFun(logger)

    sayHello("zhangSan", "man")

    verify(logger, times(1)).info("hello Mr.zhangSan")
  }

  test("curried test") {
    val mu = new MathUtils()
    val addFun = mu.add _

    val curriedFun = addFun.curried

    val res = curriedFun(1) {
      2
    }

    assert(res == 3)
  }
}
