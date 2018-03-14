package com.github.prkaspars.sudoku.util

import scala.io.Source

trait PuzzleSource {

  def fromResource(resource: String): List[Byte] =
    Source.fromResource(resource)
      .getLines
      .flatMap(_.split(" ").toList)
      .map(_.trim)
      .filterNot(_.isEmpty)
      .map(_.toByte)
      .toList

}
