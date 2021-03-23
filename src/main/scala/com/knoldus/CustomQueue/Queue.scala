package com.knoldus.CustomQueue

import scala.collection.immutable.List
import scala.util.Try

class Queue[+P](list:List[P]) {

  override def toString: String = list.toString

  def enqueue[Q >: P](input: Q): Queue[Q] = { //we are using lower-type-bound
    new Queue[Q](list :+ input)
  }

  def dequeue[Q >: P]: Try[Queue[Q]] = {
    Try(new Queue[Q](list.tail)) //using Try() for error handling
  }
}
