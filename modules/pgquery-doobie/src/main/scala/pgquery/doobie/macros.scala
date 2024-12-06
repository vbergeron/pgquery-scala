package pgquery.doobie.macros

import scala.quoted.*
import pgquery.PgVersion
import doobie.syntax.SqlInterpolator
import doobie.util.fragment.Fragment
import doobie.syntax.SqlInterpolator.SingleFragment

def process(
    sc: Expr[StringContext],
    args: Expr[Seq[SingleFragment[?]]],
    version: Expr[PgVersion]
)(using Quotes): Expr[Fragment] =
  import quotes.reflect.*
  val parts = pgquery.macros.utils.parts(sc)

  val str = parts.mkString("null")

  pgquery.macros.parse(version, Expr(str)) match
    case Some(err) => report.warning(err.message)
    case None      => report.info(parts.mkString("?"))

  '{ SqlInterpolator($sc).sql($args*) }
