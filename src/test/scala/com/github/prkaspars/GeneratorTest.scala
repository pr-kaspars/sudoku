package com.github.prkaspars

import com.github.prkaspars.Generator.puzzle
import org.scalatest.{FlatSpec, Matchers}

class GeneratorTest extends FlatSpec with Matchers with PuzzleSource {

  it should "generate puzzle with 81 valid values" in {
    val result = puzzle(Nil, Nil)
    result.nonEmpty shouldBe true
    result.get.size shouldBe 81
    result.get.toSet.size shouldBe 9
  }

}
