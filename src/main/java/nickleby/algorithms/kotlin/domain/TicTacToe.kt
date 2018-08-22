package nickleby.algorithms.kotlin.domain

import java.util.*
import java.util.stream.Collectors

object TicTacToe {

  //region TESTS

  private val TEST1 = "xxxxoxoxo"
  private val TEST2 = "xxoxxxoxo"
  private val TEST3 = "xxoxooooo"
  private val TEST4 = "xxoxoxxxo"
  private val TEST5 = "oxoxxooxx"
  private val TEST6 = "ooxxoxoxx"
  private val TEST7 = "xxooxxxox"
  private val TEST8 = "oxxxxoxoo"
  private val TEST9 = "xxxxoxooo"

  private val TEST_STRINGS = listOf(TEST1, TEST2, TEST3, TEST4, TEST5, TEST6, TEST7, TEST8, TEST9)

  //endregion TRANSFORMATION METHODS


  //region FUNCTIONS

  private val CHECK_GRID = { s: String -> if (s == "xxx") "x" else if (s == "ooo") "o" else "" }

  private val TOP_ROW = { s: String -> s.substring(0, 3) }
  private val MIDDLE_ROW = { s: String -> s.substring(3, 6) }
  private val BOTTOM_ROW = { s: String -> s.substring(6, 9) }

  private val LEFT_COLUMN = { s: String -> makeColumn(s, 0) }
  private val MIDDLE_COLUMN = { s: String -> makeColumn(s, 1) }
  private val RIGHT_COLUMN = { s: String -> makeColumn(s, 2) }

  private val TOP_LEFT_TO_BOTTOM_RIGHT = { s: String -> transform(s, 0, 4) }
  private val TOP_RIGHT_TO_BOTTOM_LEFT = { s: String -> transform(s, 2, 2) }

  private val FUNCTIONS = listOf(
      TOP_ROW, MIDDLE_ROW, BOTTOM_ROW, LEFT_COLUMN, MIDDLE_COLUMN, RIGHT_COLUMN, TOP_LEFT_TO_BOTTOM_RIGHT, TOP_RIGHT_TO_BOTTOM_LEFT
  )

  //endregion TESTS


  //region TRANSFORMATION METHODS
  private fun transform(s: String, start: Int, increment: Int): String {
    val split = s.split("".toRegex())
    return split[start] + split[start + increment] + split[start + increment * 2]
  }

  private fun makeColumn(s: String, start: Int): String {
    return transform(s, start, 3)
  }

  //endregion FUNCTIONS


  //region MAIN ROUTINE

  private fun checkIfDrawOrWinner(s: String): String {
    return if (s == "" || s.contains("xo") || s.contains("ox")) "DRAW" else s.substring(0, 1)
  }

  private fun checkTicTacToe(grid: String): String {
    val finalString = FUNCTIONS.map( { fn ->
      val gridArea = fn(grid)

      val winner = CHECK_GRID(gridArea)
      winner
    }).joinToString()

    return checkIfDrawOrWinner(finalString)
  }


  @JvmStatic
  fun main(args: Array<String>) {
    TEST_STRINGS.forEach { ts ->
      val answer = checkTicTacToe(ts)

      println(answer)
    }
  }

  //endregion MAIN ROUTINE

}