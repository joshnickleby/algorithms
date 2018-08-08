package nickleby.algorithms.kotlin.domain

import java.util.ArrayList
import java.util.HashSet
import java.util.stream.IntStream

object Elevators {

  private val weights = arrayOf(40, 40, 100, 80, 20)
  private val floors = arrayOf(3, 3, 2, 2, 3)

  private class Elevator(var capacity: Int, var maxWeight: Int) {
    var weights: MutableList<Int> = ArrayList()
    var tempWeight: Int = 0
    var tempCapacity: Int = 0
    var floors: MutableSet<Int> = HashSet()
    var count: Int = 0

    fun leftLessThanRight(left: Int?, right: Int?, modifier: Int?) : Boolean {
      return left?.let { it < right!! + modifier!! }!!
    }

    fun enter(weight: Int?, floor: Int?): Elevator {
      if (leftLessThanRight(capacity, tempCapacity, 1) ||
          leftLessThanRight(maxWeight, tempWeight, weight))
      { finish() }

      weights.add(weight!!)
      floors.add(floor!!)
      tempCapacity++
      tempWeight += weight

      return this
    }

    fun finish(): Elevator {
      count += floors.size + 1
      weights = ArrayList()
      floors = HashSet()
      tempWeight = 0
      tempCapacity = 0

      return this
    }
  }

  @JvmStatic
  fun main(args: Array<String>) {
    val elevator = Elevator(5, 200)

    for(i in 0 until weights.size) { elevator.enter(weights[i], floors[i]) }

    elevator.finish()

    println(elevator.count)
  }
}