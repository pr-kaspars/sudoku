package com.github.prkaspars.sudoku.generator

import com.github.prkaspars.sudoku.model.Index.{toBox, toCol, toRow}

import scala.util.Random.shuffle

object Generator {

  val theValueList: List[Byte] = (1 to 9).map(_.toByte).toList

  def filterByIndex(s: Seq[Byte], p: Int => Boolean): List[Byte] =
    s.zipWithIndex.filter(t => p(t._2)).map(_._1).filterNot(_ == 0).toList

  def regions(s: Seq[Byte], i: Int): List[Byte] =
    filterByIndex(s, j => toRow(i) == toRow(j) || toCol(i) == toCol(j) || toBox(i) == toBox(j))

  def puzzle(s: List[Byte], p: List[Byte]): Option[List[Byte]] = {
    s.length match {
      case 81 => Some(s)
      case _ =>
        val d = shuffle(theValueList.diff(regions(s.reverse, s.length) ::: p))
        if (d.isEmpty) None
        else {
          val q = puzzle(d.head :: s, Nil)
          if (q.nonEmpty) q
          else puzzle(s, d.head :: p)
        }
    }
  }

  def aPuzzle(): List[Byte] =
    puzzle(Nil, Nil).get

}
