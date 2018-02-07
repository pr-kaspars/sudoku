package com.github.prkaspars

import com.github.prkaspars.Board.{box, col, row}
import com.github.prkaspars.Validator._
import org.scalatest.{FlatSpec, Matchers}

class ValidatorTest extends FlatSpec with Matchers with PuzzleSource {

  val puzzleValid = fromResource("puzzle.01.valid.txt")
  val puzzleIncomplete = fromResource("puzzle.01.incomplete.txt")
  val puzzleInvalid = fromResource("puzzle.01.invalid.txt")

  "seqStatus" should "return Valid" in {
    val s = Seq(1, 7, 2, 5, 4, 9, 6, 8, 3).map(_.toByte)
    seqStatus(s) should be(Valid)
  }

  it should "return Invalid" in {
    val s = Seq(1, 7, 2, 5, 4, 9, 6, 8, 1).map(_.toByte)
    seqStatus(s) should be(Invalid)
  }

  it should "return Incomplete" in {
    val s = Seq(1, 7, 2, 5, 4, 9, 6).map(_.toByte)
    seqStatus(s) should be(Incomplete)
  }

  "blockStatus" should "return Valid" in {
    for (i <- 0 until 9) {
      blockStatus(puzzleValid, i, row) shouldBe Valid
      blockStatus(puzzleValid, i, col) shouldBe Valid
      blockStatus(puzzleValid, i, box) shouldBe Valid
    }
  }

  "rowStatus" should "return Valid" in {
    for (i <- 0 until 9) {
      rowStatus(puzzleValid, i) shouldBe Valid
    }
  }

  it should "return Incomplete" in {
    for (i <- 0 until 9) {
      rowStatus(puzzleIncomplete, i) shouldBe Incomplete
    }
  }

  it should "return Invalid" in {
    for (i <- 0 until 9) {
      rowStatus(puzzleInvalid, i) shouldBe Invalid
    }
  }

  "colStatus" should "return Valid" in {
    for (i <- 0 until 9) {
      colStatus(puzzleValid, i) shouldBe Valid
    }
  }

  it should "return Incomplete" in {
    for (i <- 0 until 9) {
      colStatus(puzzleIncomplete, i) shouldBe Incomplete
    }
  }

  it should "return Invalid" in {
    for (i <- 0 until 9) {
      colStatus(puzzleInvalid, i) shouldBe Invalid
    }
  }

  "boxStatus" should "return Valid" in {
    for (i <- 0 until 9) {
      boxStatus(puzzleValid, i) shouldBe Valid
    }
  }

  it should "return Incomplete" in {
    for (i <- 0 until 9) {
      boxStatus(puzzleIncomplete, i) shouldBe Incomplete
    }
  }

  it should "return Invalid" in {
    for (i <- 0 until 9) {
      boxStatus(puzzleInvalid, i) shouldBe Invalid
    }
  }

}
