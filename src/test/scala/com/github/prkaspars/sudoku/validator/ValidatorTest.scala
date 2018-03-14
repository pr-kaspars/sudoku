package com.github.prkaspars.sudoku.validator

import com.github.prkaspars.sudoku.validator.Validator._
import org.scalatest.{FlatSpec, Matchers}

class ValidatorTest extends FlatSpec with Matchers {

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

}
