package com.github.prkaspars.sudoku.model

case class Cell(value: Byte, index: Index)

object Cell {

  def fromTuple(t: (Byte, Int)): Cell =
    Cell(t._1, Index(t._2))
}
