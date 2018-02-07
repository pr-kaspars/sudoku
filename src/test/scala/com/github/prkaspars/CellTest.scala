package com.github.prkaspars

import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.prop.TableDrivenPropertyChecks.{Table, forEvery}

class CellTest extends FlatSpec with Matchers {

  val indexTable = Table(
    ("Index", "Row", "Col", "Box"),
    (0, 0, 0, 0),
    (8, 0, 8, 2),
    (9, 1, 0, 0),
    (80, 8, 8, 8)
  )

  "toRow" should "return row number" in {
    forEvery(indexTable) {
      (i, r, _, _) => Cell.toRow(i) should be(r)
    }
  }

  "toCol" should "return column number" in {
    forEvery(indexTable) {
      (i, _, c, _) => Cell.toCol(i) should be(c)
    }
  }

  "toBox" should "return box number" in {
    forEvery(indexTable) {
      (i, _, _, b) => Cell.toBox(i) should be(b)
    }
  }

  "toIndex" should "return index for coordinates" in {
    forEvery(indexTable) {
      (i, r, c, _) => Cell.toIndex(r, c) should be(i)
    }
  }

}
