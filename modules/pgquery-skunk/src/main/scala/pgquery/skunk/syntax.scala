package pgquery.skunk

import pgquery.PgVersion
import skunk.Fragment

inline given PgVersion = PgVersion.V17

extension (inline sc: StringContext)
  // transparent inline def pgsql(inline args: Any*)(using inline version: PgVersion): Any =
  //  ${ macros.process('sc, 'args, 'version) }

  transparent inline def pgsql15(inline args: Any*): Any =
    ${ macros.process('sc, 'args, '{ PgVersion.V15 }) }

  transparent inline def pgsql16(inline args: Any*): Any =
    ${ macros.process('sc, 'args, '{ PgVersion.V16 }) }

  transparent inline def pgsql17(inline args: Any*): Any =
    ${ macros.process('sc, 'args, '{ PgVersion.V17 }) }
