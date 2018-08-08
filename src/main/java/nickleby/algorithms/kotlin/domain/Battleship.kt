package nickleby.algorithms.kotlin.domain

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

      return "$sunk, $hit"
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
      val coordinates = coordinateString.split(" ").map {Coordinate(it.split("".toRegex()))}

      if (coordinates.size == 1)
        mapSingleCoordinates(coordinates)
      else
        mapMultipleCoordinates(coordinates)
    }

    fun mapSingleCoordinates(coordinates: List<Coordinate>) {
      dimensions = (coordinates[0].x until coordinates[1].x+1).map({selectedX ->
        val selectedY = coordinates[0].y
        val xy = selectedX.toString() + selectedY
        xy to Tile(selectedY, selectedX)
      }).toMutableMap()
    }

    fun mapMultipleCoordinates(coordinates: List<Coordinate>) {
      val (first, last) = Pair(coordinates[0], coordinates[1])

      listOf(first, last).forEach {addDimension(it)}
      listOf(Pair(first, last), Pair(last, first)).forEach { addDimension(it.first, it.second); }
    }

    fun addDimension(vararg coordinates: Coordinate) {
      val first = coordinates[0]
      val last = if (coordinates.size == 1) coordinates[0] else coordinates[1]

      dimensions["${first.x}${last.y}"] = Tile(last.y, last.x)
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