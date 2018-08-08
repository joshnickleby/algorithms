package nickleby.algorithms.kotlin.domain

import java.util.*

object Battleship {

  private class PlayBoard(shipLocations: String, shots: String) {
    // get the coordinates, create the ship, and check the shots on it
    var ships: List<Ship> = shipLocations.split(",").map {coordinates ->
      val ship = Ship(coordinates)
      ship.checkHit(shots)
    }


    fun countHitsAndSunk(): String {
      var (hit, sunk) = Pair(0, 0)

      ships.forEach { ship ->
        when {
          ship.isSunk -> sunk++
          ship.isHit -> hit++
        }
      }

      return sunk.toString() + "," + hit
    }
  }

  private class Tile(var column: String, var row: Int?) {
    var hit = false

    fun toggleHit(): Tile {hit = true; return this}

  }

  fun List<Boolean>.andReduce(): Boolean = this.reduce {acc, b -> acc && b}
  fun List<Boolean>.orReduce():  Boolean = this.reduce {acc, b -> acc || b}
  fun <A, B> Iterable<Pair<A, B>>.toMutableMap() = this.toMap().toMutableMap()

  class Coordinate(positions: List<String>) {
    val x: Int = positions[0].toInt()
    val y: String = positions[1]
  }

  private class Ship(coordinateString: String) {
    var dimensions = mutableMapOf<String, Tile>()

    val extractHit = {tile: Tile -> tile.hit}

    val isSunk: Boolean get() = dimensions.values.map(extractHit).andReduce()
    val isHit:  Boolean get() = dimensions.values.map(extractHit).orReduce()

    init {
      val positions = coordinateString.split(" ".toRegex())

      val coordinates = positions.map {Coordinate(it.split("".toRegex()))}

      val columns = coordinates.map({it.x}).toHashSet()

      if (columns.size == 1) {
        dimensions = (coordinates[0].x until coordinates[1].x+1).map({selectedX ->
          val selectedY = coordinates[0].y
          val xy = selectedX.toString() + selectedY
          xy to Tile(selectedY, selectedX)
        }).toMutableMap()

      } else {
        // first and last
        val (zuerst, letzte) = Pair(coordinates[0], coordinates[1])
        dimensions[zuerst.x.toString() + zuerst.y] = Tile(zuerst.y, zuerst.x)
        dimensions[letzte.x.toString() + letzte.y] = Tile(letzte.y, letzte.x)
        dimensions[zuerst.x.toString() + letzte.y] = Tile(letzte.y, zuerst.x)
        dimensions[letzte.x.toString() + zuerst.y] = Tile(zuerst.y, letzte.x)
      }
    }

    fun checkHit(shots: String): Ship {
      shots.split(" ".toRegex()).forEach {dimensions[it]?.toggleHit()}

      return this
    }
  }

  @JvmStatic
  fun main(args: Array<String>) {
    val playBoard = PlayBoard("1B 2C,2D 4D", "2B 2D 3D 4D 4A")

    println(playBoard.countHitsAndSunk())
  }
}