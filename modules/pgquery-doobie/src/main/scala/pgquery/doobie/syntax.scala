package pgquery.doobie

import pgquery.PgVersion
import doobie.syntax.SqlInterpolator.SingleFragment
import doobie.util.fragment.Fragment

inline given PgVersion = PgVersion.V17

extension (inline sc: StringContext)
  inline def pgsql(args: SingleFragment[?]*)(using
      inline version: PgVersion
  ): Fragment =
    ${ macros.process('sc, 'args, 'version) }

  inline def pgsql15(args: SingleFragment[?]*): Fragment =
    ${ macros.process('sc, 'args, '{ PgVersion.V15 }) }

  inline def pgsql16(args: SingleFragment[?]*): Fragment =
    ${ macros.process('sc, 'args, '{ PgVersion.V16 }) }

  inline def pgsql17(args: SingleFragment[?]*): Fragment =
    ${ macros.process('sc, 'args, '{ PgVersion.V17 }) }
