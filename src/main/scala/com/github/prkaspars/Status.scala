package com.github.prkaspars

sealed trait Status

case object Incomplete extends Status

case object Invalid extends Status

case object Valid extends Status
