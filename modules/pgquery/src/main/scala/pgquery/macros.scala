package pgquery.macros

import pgquery.*
import java.lang.foreign.Arena
import scala.quoted.*


def check(version: Expr[PgVersion], query: Expr[String])(using Quotes): Option[ParseError] =
  import quotes.reflect.*
  val bridge = version match
    case '{ PgVersion.V17 }  => pgquery.bridge.Bridge.V17
    case '{ PgVersion.V16 }  => pgquery.bridge.Bridge.V16
    case '{ PgVersion.V15 }  => pgquery.bridge.Bridge.V15
    case term => report.errorAndAbort(s"PgVersion: ${term.show}")
  
  val arena = Arena.ofConfined()
  try
    val buffer = arena.allocateFrom(query.valueOrError)
    val result = bridge.pg_query_parse(arena, buffer)
    try
      val error = bridge.pg_query_parse_result_error(result)

      Option.when(error.address() != 0): 
        val message = bridge.pg_query_error_message(error).getString(0)
        ParseError(message)
    finally bridge.pg_query_free_parse_result(result)

  finally arena.close()

def pgsql(version: Expr[PgVersion], query: Expr[String])(using Quotes): Expr[Unit] =
  import quotes.reflect.*
  check(version, query) match
    case Some(err) => report.warning(err.message)
    case None      => ()
  '{}

object utils:
  def parts(sc: Expr[StringContext])(using Quotes): List[String] =
    import quotes.reflect.*
    sc match
        case '{ StringContext(${ Varargs(Exprs(parts)) }*) } => parts.toList
        case expr                                            =>
            report.errorAndAbort(s"Invalid string context: ${expr.show}")

  def args(exprs: Expr[Seq[?]])(using Quotes): List[Expr[?]] =
    // The interpolated args are a list of size `parts.length - 1`
    val Varargs(args) = exprs: @unchecked
    args.toList

  def comptimeEnv(input: Expr[String])(using Quotes): Expr[Unit] =
    import quotes.reflect.*
    val key = input.valueOrError
    report.info(s"Env: $key=${Option(System.getenv(key)).getOrElse("N/A")}")
    '{()}
