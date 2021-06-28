package com.bbst

import org.scalatest.funsuite.AnyFunSuite

class LambdaTest extends AnyFunSuite {
  test("should apply to interface with single abstract method") {
    val people: People = (name) => {
      "Hello " + name
    }
    assert("Hello zhangSan" == people.sayHello("zhangSan"))
  }

  test("should be able to bind to instance method") {
    val people: People = (name: String) => sayHello(name: String)
    assert("Hello zhangSan" == people.sayHello("zhangSan"))
  }

  test("should evaluate captured variable when executing") {
    var workType = "engineer"

    val people: People = (name) => {
      "Hello " + name + " " + workType
    }

    workType = "teacher"
    assert("Hello zhangSan teacher" == people.sayHello("zhangSan"))
  }

  private def sayHello(name: String): String = {
    "Hello " + name
  }
}


