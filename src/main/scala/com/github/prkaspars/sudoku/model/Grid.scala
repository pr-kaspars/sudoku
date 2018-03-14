package com.github.prkaspars.sudoku.model

import com.github.prkaspars.sudoku.model.Cell.fromTuple

case class Grid(cells: Seq[Cell])

object Grid {

  def fromSeq(s: Seq[Byte]): Grid =
    new Grid(s.zipWithIndex.map(fromTuple))

}
