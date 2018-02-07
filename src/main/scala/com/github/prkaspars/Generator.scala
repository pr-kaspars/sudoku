package com.github.prkaspars

import com.github.prkaspars.Board.held

import scala.util.Random

object Generator {

  val aValueList = 1.to(9).map(_.toByte).toList

  def puzzle(s: List[Byte], p: List[Byte]): Option[List[Byte]] = {
    s.length match {
      case 81 => Some(s)
      case _ => {
        val d = Random.shuffle(aValueList.diff(held(s.reverse, s.length).toList ::: p))
        if (d.isEmpty) None
        else {
          val q = puzzle(d.head :: s, Nil)
          if (q.nonEmpty) q
          else puzzle(s, d.head :: p)
        }
      }
    }
  }

}
