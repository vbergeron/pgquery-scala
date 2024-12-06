package pgquery.skunk

import skunk.syntax.all.*
import skunk.codec.all.*

def foo =
  val query = pgsql15"SELECT * FROM person WHERE name = $text AND age > $int8"
