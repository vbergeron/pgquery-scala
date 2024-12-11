package pgquery.bridge

import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment
import libpg_query.*

sealed trait Bridge:
  def pg_query_parse(arena: Arena, buffer: MemorySegment): MemorySegment
  def pg_query_free_parse_result(result: MemorySegment): Unit
  def pg_query_parse_result_error(result: MemorySegment): MemorySegment
  def pg_query_error_message(error: MemorySegment): MemorySegment

object Bridge:

  case object V17 extends Bridge:

    def pg_query_parse(arena: Arena, buffer: MemorySegment): MemorySegment =
      v17.pg_query_h.pg_query_parse(arena, buffer)

    def pg_query_free_parse_result(result: MemorySegment): Unit =
      v17.pg_query_h.pg_query_free_parse_result(result)

    def pg_query_parse_result_error(result: MemorySegment): MemorySegment =
      v17.PgQueryParseResult.error(result)

    def pg_query_error_message(error: MemorySegment): MemorySegment =
      v17.PgQueryError.message(error)

  case object V16 extends Bridge:

    def pg_query_parse(arena: Arena, buffer: MemorySegment): MemorySegment =
      v16.pg_query_h.pg_query_parse(arena, buffer)

    def pg_query_free_parse_result(result: MemorySegment): Unit =
      v16.pg_query_h.pg_query_free_parse_result(result)

    def pg_query_parse_result_error(result: MemorySegment): MemorySegment =
      v16.PgQueryParseResult.error(result)

    def pg_query_error_message(error: MemorySegment): MemorySegment =
      v16.PgQueryError.message(error)

  case object V15 extends Bridge:

    def pg_query_parse(arena: Arena, buffer: MemorySegment): MemorySegment =
      v15.pg_query_h.pg_query_parse(arena, buffer)

    def pg_query_free_parse_result(result: MemorySegment): Unit =
      v15.pg_query_h.pg_query_free_parse_result(result)

    def pg_query_parse_result_error(result: MemorySegment): MemorySegment =
      v15.PgQueryParseResult.error(result)

    def pg_query_error_message(error: MemorySegment): MemorySegment =
      v15.PgQueryError.message(error)
