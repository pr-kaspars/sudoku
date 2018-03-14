package com.github.prkaspars.sudoku.generator

import com.github.prkaspars.sudoku.generator.Generator.{aPuzzle, filterByIndex, puzzle, regions}
import com.github.prkaspars.sudoku.util.PuzzleSource
import org.scalatest.{FlatSpec, Matchers}

class GeneratorTest extends FlatSpec with Matchers with PuzzleSource {

  val puzzleValid: List[Byte] = fromResource("valid.02.pzl")
  val puzzleInvalid: List[Byte] = fromResource("invalid.03.pzl")

  "puzzle" should "generate puzzle with 81 valid values" in {
    val result = puzzle(Nil, Nil)
    result.nonEmpty shouldBe true
    result.get.size shouldBe 81
    result.get.toSet.size shouldBe 9
  }

  it should "return input list if the length is 81" in {
    val s = fromResource("valid.01.pzl")
    puzzle(s, Nil) shouldBe Some(s)
  }

  it should "return None if the puzzle cannot be completed" in {
    val s = fromResource("invalid.02.pzl")
    puzzle(s, Nil) shouldBe None
  }

  "filterByIndex" should "return sequence filtered by index" in {
    val s = Seq(4, 8, 3, 9, 2)
    filterByIndex(puzzleValid, i => i < 5) should be(s)
  }

  "regions" should "return values from all three regions" in {
    regions(puzzleInvalid, 10).toSet shouldBe Set(1, 2, 3, 4, 7)
    regions(puzzleInvalid, 70).toSet shouldBe Set(7, 8, 9, 3, 6)
  }

  "aPuzzle" should "return a list of 81 bytes" in {
    aPuzzle().length shouldBe 81
  }

  it should "return a list of values from 1 to 9" in {
    aPuzzle().toSet shouldBe Set(1, 2, 3, 4, 5, 6, 7, 8, 9)
  }
}
