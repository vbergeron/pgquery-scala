package pgquery

enum PgVersion:
  case V15, V16, V17

inline def parse(inline version: PgVersion, inline query: String): String =
  ${ macros.parse('version, 'query) }
