package pgquery

final case class ParseError(message: String)
    extends Exception(s"Parse error: $message")

enum PgVersion:
  case V15, V16, V17

object utils:
  inline def comptimeEnv(inline input: String): Unit =
    ${ macros.utils.comptimeEnv('input) }
