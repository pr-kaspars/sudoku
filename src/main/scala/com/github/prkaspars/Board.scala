package com.github.prkaspars

import Cell.{toBox, toCol, toRow}

object Board {

  def filterByIndex(s: Seq[Byte], p: Int => Boolean): List[Byte] =
    s.zipWithIndex.filter(t => p(t._2)).map(_._1).filterNot(_ == 0).toList

  def filterBySegment(s: Seq[Byte], i: Int, c: Int => Int): List[Byte] =
    filterByIndex(s, j => c(j) == i)

  def row(s: Seq[Byte], i: Int): List[Byte] =
    filterBySegment(s, i, toRow)

  def col(s: Seq[Byte], i: Int): List[Byte] =
    filterBySegment(s, i, toCol)

  def box(s: Seq[Byte], i: Int): List[Byte] =
    filterBySegment(s, i, toBox)

  def format(s: Seq[Byte]): String =
    s.reverse.sliding(9, 9).map(_.mkString(" ")).mkString("\n")

  def held(s: Seq[Byte], i: Int): Set[Byte] =
    row(s, toRow(i)) ::: col(s, toCol(i)) ::: box(s, toBox(i)) toSet

}
