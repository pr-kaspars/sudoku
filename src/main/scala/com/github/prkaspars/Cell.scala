package com.github.prkaspars

import java.lang.Math.{floorDiv, floorMod}

object Cell {

  def toRow(i: Int): Int =
    floorDiv(i, 9)

  def toCol(i: Int): Int =
    floorMod(i, 9)

  def toBox(i: Int): Int =
    floorDiv(i, 27) * 3 + floorDiv(i % 9, 3)

  def toIndex(r: Int, c: Int): Int =
    r * 9 + c

}
