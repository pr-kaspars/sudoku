package com.github.prkaspars.sudoku.model

import com.github.prkaspars.sudoku.model.Grid.fromSeq
import org.scalatest.{FlatSpec, Matchers}

class GridTest extends FlatSpec with Matchers {

  "fromSeq" should "return a Grid" in {
    fromSeq(Nil) shouldBe Grid(Nil)
    fromSeq(Seq(1, 2, 3)) shouldBe Grid(Seq(
      Cell(1, Index(0)), Cell(2, Index(1)), Cell(3, Index(2))
    ))
  }

}
