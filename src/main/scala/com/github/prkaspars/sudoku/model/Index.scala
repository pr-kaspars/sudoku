package com.github.prkaspars.sudoku.model

import java.lang.Math.{floorDiv, floorMod}

case class Index(value: Int) {

  def row(): Int =
    Index.toRow(value)

  def col(): Int =
    Index.toCol(value)

  def box(): Int =
    Index.toBox(value)

}

object Index {

  def toRow(i: Int): Int =
    floorDiv(i, 9)

  def toCol(i: Int): Int =
    floorMod(i, 9)

  def toBox(i: Int): Int =
    floorDiv(i, 27) * 3 + floorDiv(i % 9, 3)

  def fromCoordinates(r: Int, c: Int): Int =
    r * 9 + c
}
