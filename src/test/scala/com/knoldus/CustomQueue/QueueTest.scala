package com.knoldus.CustomQueue

import org.scalatest.flatspec.AnyFlatSpec

class QueueTest extends AnyFlatSpec {
  //scalastyle:off magic.number

  "Queue" should "It reversion only enqueued value as the list was empty initially" in{
    val queue = new Queue[String](List())
    val enqueued = queue.enqueue("Hi to be there!").toString
    assertResult("List(Hi to be there!)")(enqueued)
  }

  it should "return enqueued list of string" in{
    val queue = new Queue[String](List("Sagar"))
    val result=queue.enqueue("Goel").toString
    assertResult("List(Sagar, Goel)")(result)
  }

  it should "return dequeued list of string" in{
    val queue = new Queue[String](List("Hi to be there"))
    val enqueued = queue.enqueue("Hi to be there")
    val dequeued=enqueued.dequeue.toString
    assertResult("Success(List(Hi to be there))")(dequeued)
  }

  it should "return enqueued list of int" in{
    val queue = new Queue[Int](List(3,4))
    val result=queue.enqueue(7).toString
    assertResult("List(3, 4, 7)")(result)
  }

  it should "return dequeued list of int" in{
    val queue = new Queue[Int](List(4,5))
    val enqueued = queue.enqueue(9)
    val dequeued=enqueued.dequeue.toString
    assertResult("Success(List(5, 9))")(dequeued)
  }

  it should "return nothing" in{
    val queue = new Queue[String](List())
    val dequeued =queue.dequeue.toString
    assertResult("Failure(java.lang.UnsupportedOperationException: tail of empty list)")(dequeued)
  }
}

