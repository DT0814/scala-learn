package com.bbst

import org.scalatest.funsuite.AnyFunSuite

class CollectionsTest extends AnyFunSuite {
  test("practice list api") {
    val list = List("foo", "bar")

    assert(list.reverse == List("bar", "foo"))
    assert(list.contains("foo"))
    assert(list.corresponds(List("foo1", "bar1"))((k, v) => v == k.concat("1")))
    assert(list.exists(it => it.startsWith("f")))
    assert(List("foo", "bar", "foo").foldRight[String]("right")((it, it2) => it.concat(it2)) == "foobarfooright")
    assert(List("foo", "bar", "foo").foldLeft[String]("left")((it, it2) => it.concat(it2)) == "leftfoobarfoo")
    assert(list.appendedAll(List("new foo", "new bar")) == List("foo", "bar", "new foo", "new bar"))
    assert(list.appended("new foo") == List("foo", "bar", "new foo"))
    assert(list.forall(it => !it.isEmpty))
    assert(list.::("new foo") == List("new foo", "foo", "bar"))
    assert(list.:::(List("new foo", "new bar")) == List("new foo", "new bar", "foo", "bar"))
    assert(list.collect(it => "new " + it) == List("new foo", "new bar"))
    assert(list.filter(it => it != "foo") == List("bar"))
    assert(list.filterNot(it => it != "foo") == List("foo"))
    assert(list.flatMap(it => it + " ") == List('f', 'o', 'o', ' ', 'b', 'a', 'r', ' '))
    assert(list.flatten == List('f', 'o', 'o', 'b', 'a', 'r'))
    assert(list.map(it => {
      it + " "
    }) == List("foo ", "bar "))
    assert(list.slice(0, 1) == List("foo"))
    assert(list.take(1) == List("foo"))
    assert(list.takeRight(1) == List("bar"))
    assert(list.takeWhile(it => it == "foo") == List("foo"))
    assert(list.mapConserve(_.toUpperCase) == List("FOO", "BAR"))
  }

}