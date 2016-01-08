package com.niki.learning
import scala.collection.mutable.Map

/**
  * Created by liyajin on 16/1/8.
  */
class ChecksumAccumulator {

  private var sum = 0

  def add(b:Byte) : Unit = sum += 1

  def checkSum() : Int = (sum & 0xFF) +1

}

object ChecksumAccumulator{
  private val cache = Map [String, Int]()

  def calculate(s:String) : Int =
    if(cache.contains(s))
      cache(s)
    else{
      val acc = new ChecksumAccumulator
      for(c <- s)
        acc.add(c.toByte)
      val cs = acc.checkSum()
      cache += (s -> cs)
      cs
    }

  def main(args: Array[String]) {
    println ( ChecksumAccumulator.calculate("1"))
  }
}

