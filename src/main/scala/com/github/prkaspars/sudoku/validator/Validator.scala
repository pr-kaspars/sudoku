package com.github.prkaspars.sudoku.validator

object Validator {

  def seqStatus(s: Seq[Byte]): Status =
    s.size match {
      case l if l != s.toSet.size => Invalid
      case 9 => Valid
      case _ => Incomplete
    }

  sealed trait Status

  case object Incomplete extends Status

  case object Invalid extends Status

  case object Valid extends Status

}
