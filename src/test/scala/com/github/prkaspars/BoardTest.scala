package com.github.prkaspars

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class BoardTest extends FlatSpec with Matchers with PuzzleSource {

  val puzzleValid = fromResource("puzzle.02.valid.txt")

  "row" should "return row values" in {
    val s = Seq(2, 5, 1, 8, 7, 6, 4, 9, 3)
    Board.row(puzzleValid, 2) should be(s)
  }

  "col" should "return column values" in {
    val s = Seq(3, 7, 1, 8, 9, 6, 2, 4, 5)
    Board.col(puzzleValid, 2) should be(s)
  }

  "box" should "return box values" in {
    val s = Seq(6, 8, 9, 2, 5, 3, 4, 1, 7)
    Board.box(puzzleValid, 7) should be(s)
  }

  "filterByIndex" should "return sequence filtered by index" in {
    val s = Seq(4, 8, 3, 9, 2)
    Board.filterByIndex(puzzleValid, i => i < 5) should be(s)
  }

  "filterBySegment" should "return segment sequence" in {
    val s = Seq(2, 5, 1, 8, 7, 6, 4, 9, 3)
    Board.filterBySegment(puzzleValid, 2, Cell.toRow) should be(s)
  }

}
