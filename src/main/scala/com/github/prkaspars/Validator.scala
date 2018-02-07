package com.github.prkaspars

import com.github.prkaspars.Board.{box, col, row}

object Validator {

  def seqStatus(s: Seq[Byte]): Status =
    s.size match {
      case l if l != s.toSet.size => Invalid
      case 9 => Valid
      case _ => Incomplete
    }

  def blockStatus(s: Seq[Byte], i: Int, f: (Seq[Byte], Int) => Seq[Byte]): Status =
    seqStatus(f(s, i))

  def rowStatus(s: Seq[Byte], i: Int): Status =
    blockStatus(s, i, row)

  def colStatus(s: Seq[Byte], i: Int): Status =
    blockStatus(s, i, col)

  def boxStatus(s: Seq[Byte], i: Int): Status =
    blockStatus(s, i, box)

}
