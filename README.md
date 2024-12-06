# PgQuery Scala

## Fast and extensible compile time checked sql

The `pgquery-scala` library provides a set of bindings to access the power of [libpg_query](https://github.com/pganalyze/libpg_query) at compile time in your scala projects. Since Postgres' parser is used no need for a local container nor a database connection to check your code ! All errors won't be cought this way (for instance references to unexisting columns and such) but its overload on compilation time is minimal.

## Postgres Version support

Currently the versions 15, 16 and 17 of Postgres are supported. Just add a line in the `scripts/PG_VERSIONS` file to add one !

## Features

### Compile time query syntax validation

The main engine here is `pgquery.macros.check`, which is loading the right library for the asked Postgres Version and is issuing the native calls.
To poke around and test the query parsing, you can use the provided convienience method `pgquery.pgsql(PgVersion, String)`. For now, sql errors results in warnings but switching between warning and hard errors is in the roadmap.

```scala
pgquery.pgsql("select foo from bar where bloop = 2") // compiles fine
pgquery.pgsql("select foo form bar where bloop = 2") // errors at compile time 
```

### Doobie integration
`pgquery-scala-doobie` extends `doobie-postgres` with additional interpolators.

```scala
val age: Int = ???

pgsql"select name from user"                  
// Output a `Fragment` like the `sql` interpolator

pgsql"select name from user where age = $age" 
// Support for interpolated values is limited : for now they are replaced with NULL for parsing

inline given PgVersion = PgVersion.V15
// default version is the latest (17) but you can tune it

pgsql15"merge into target using source on [...] returning [...]" // fails
pgsql17"merge into target using source on [...] returning [...]" // compiles
//Exemples: `returning` is not available on `merge` until version 17
```

### Skunk integration
`pgquery-scala-skunk` extends `skunk-core` with additional interpolators

The universal `pgsql` interpolator is not available due du some interraction between `pgquery-scala` and `skunk` macros,
but the fixed SQL versions of them are available for testing.

## Installation and usage

NOTE: Maven publishing TBD. In the meantime, you have to clone and run `sbt publishLocal`.
NOTE: The set of libraries provided contains only macros, so their scope can be only `Compile` on SBT.

You can use the script provided in `scripts/codegen.sh` to generate the shared libraries for you :
```
PGQUERY_BUILD_BINDINGS=false PGQUERY_BUILD_SHARED=true
```
Since this is compiling many files from many version of `libpg_query` you can expect it to take time.

Then add the `lib` folder that got created to your `LD_LIBRARY_PATH` variable when running tooling, IDE, and such.
In order to help debugging nasty env variable issues the `pgquery.utils.comptimEnv("SOME_ENV_VAR")` is provided, just call it in the current file and the compiler should emit an INFO log.




