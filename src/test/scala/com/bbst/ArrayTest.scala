package com.bbst

import org.scalatest.funsuite.AnyFunSuite

class ArrayTest extends AnyFunSuite {
  test("should resize array") {
    val itemsCount = 25
    val initialCapacity = 10

    val myStack = new MyStack(initialCapacity)
    for (it <- (0 until itemsCount)) {
      myStack.push(it)
    }

    val array = myStack.popToArray
    assert(Array[Int](24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0) sameElements array)
  }
}
