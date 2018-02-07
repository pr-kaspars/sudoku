package com.github.prkaspars

import scala.io.Source

trait PuzzleSource {

  def fromResource(resource: String): List[Byte] =
    Source.fromResource(resource)
      .getLines
      .map(_.split(" ").toList)
      .flatten
      .map(_.trim)
      .filterNot(_.isEmpty)
      .map(_.toByte)
      .toList

}
