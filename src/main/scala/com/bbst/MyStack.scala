package com.bbst

class MyStack(val initCapacity: Int) {
  private var storage = new Array[Int](initCapacity)
  private var count = 0
  private var capacity = initCapacity
  private val GROW_FACTOR = 2


  def push(value: Int): Unit = {
    if (count == capacity) ensureCapacity()
    storage(count) = value
    count += 1
  }

  private def ensureCapacity(): Unit = {
    val newCapacity = capacity * GROW_FACTOR

    val newStorage = new Array[Int](newCapacity)
    Array.copy(storage, 0, newStorage, 0, count)
    capacity = newCapacity
    this.storage = newStorage
  }

  def popToArray: Array[Int] = {
    val totalItemsCount = count
    val array = new Array[Int](totalItemsCount)
    while ( {
      count > 0
    }) array(totalItemsCount - count) = pop
    array
  }

  private def pop = {
    val result = storage({
      count -= 1;
      count
    })
    result
  }

}
