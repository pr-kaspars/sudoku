package com.github.prkaspars.sudoku.model

import com.github.prkaspars.sudoku.model.Cell.fromTuple
import org.scalatest.{FlatSpec, Matchers}

class CellTest extends FlatSpec with Matchers {

  "fromTuple" should "return Cell case class" in {
    fromTuple((8.toByte, 10)) shouldBe Cell(8.toByte, Index(10))
  }
}
