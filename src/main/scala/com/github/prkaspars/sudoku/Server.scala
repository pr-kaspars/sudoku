package com.github.prkaspars.sudoku

import com.github.prkaspars.sudoku.service.GridService
import com.twitter.finagle.Http
import com.twitter.util.Await
import io.circe.generic.auto._
import io.finch.circe._

object Server extends App {

  Await.ready(Http.server.serve(":8081", GridService().api.toService))
}
