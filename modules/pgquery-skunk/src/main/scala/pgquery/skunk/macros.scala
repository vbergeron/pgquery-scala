package pgquery.skunk.macros

import scala.quoted.*
import pgquery.PgVersion
import skunk.syntax.StringContextOps
import skunk.util.Origin
import skunk.syntax.StringContextOps.*
import cats.syntax.all.*
import skunk.Encoder
import skunk.Fragment

def process(sc: Expr[StringContext], args: Expr[Seq[Any]], version: Expr[PgVersion])(using Quotes): Expr[Any] =
  import quotes.reflect.*

  val parts = pgquery.macros.utils.parts(sc)

  val str = parts.mkString("null")

  pgquery.macros.parse(version, Expr(str)) match
    case Some(err) => report.warning(err.message)
    case None      => report.info(parts.mkString("?"))
  StringContextOps.sqlImpl(sc, args)
