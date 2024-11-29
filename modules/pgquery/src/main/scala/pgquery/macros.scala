package pgquery.macros

import pgquery.PgVersion
import java.lang.foreign.Arena
import libpg_query.*
import scala.quoted.*

final case class ParseTree(value: String)
final case class ParseError(message: String)

def parse(version: Expr[PgVersion], query: Expr[String])(using Quotes): Expr[String] =
  val bridge = version match
    case '{ PgVersion.V17 } => pgquery.bridge.Bridge.V17
    case '{ PgVersion.V16 } => pgquery.bridge.Bridge.V16
    case '{ PgVersion.V15 } => pgquery.bridge.Bridge.V15
    case _ => quotes.reflect.report.errorAndAbort("Unsupported PgVersion")
  
  val arena = Arena.ofConfined()
  try
    val buffer = arena.allocateFrom(query.valueOrError)
    val result = bridge.pg_query_parse(arena, buffer)
    try
      val error = bridge.pg_query_parse_result_error(result)

      if error.address() != 0 
      then
        val message = bridge.pg_query_error_message(error).getString(0)
        quotes.reflect.report.errorAndAbort(s"PgQuery: $message")
      else
        query
    finally bridge.pg_query_free_parse_result(result)

  finally arena.close()
