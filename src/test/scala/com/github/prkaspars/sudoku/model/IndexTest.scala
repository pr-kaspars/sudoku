package com.github.prkaspars.sudoku.model

import com.github.prkaspars.sudoku.model.Index._
import org.scalatest.prop.TableDrivenPropertyChecks.{Table, forEvery}
import org.scalatest.{FlatSpec, Matchers}

class IndexTest extends FlatSpec with Matchers {

  val indexTable = Table(
    ("Index", "Row", "Col", "Box"),
    (0, 0, 0, 0),
    (8, 0, 8, 2),
    (9, 1, 0, 0),
    (80, 8, 8, 8)
  )

  "toRow" should "return row number" in {
    forEvery(indexTable) {
      (i, r, _, _) => toRow(i) should be(r)
    }
  }

  "toCol" should "return column number" in {
    forEvery(indexTable) {
      (i, _, c, _) => toCol(i) should be(c)
    }
  }

  "toBox" should "return box number" in {
    forEvery(indexTable) {
      (i, _, _, b) => toBox(i) should be(b)
    }
  }

  "fromCoordinates" should "return index for coordinates" in {
    forEvery(indexTable) {
      (i, r, c, _) => fromCoordinates(r, c) should be(i)
    }
  }

  "row" should "return row number" in {
    forEvery(indexTable) {
      (i, r, _, _) => Index(i).row should be(r)
    }
  }

  "col" should "return column number" in {
    forEvery(indexTable) {
      (i, _, c, _) => Index(i).col should be(c)
    }
  }

  "box" should "return box number" in {
    forEvery(indexTable) {
      (i, _, _, b) => Index(i).box should be(b)
    }
  }

}
