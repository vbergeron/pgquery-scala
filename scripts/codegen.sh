#!/usr/bin/env bash

SHOULD_BUILD_SHARED=${PGQUERY_BUILD_SHARED:-false}
SHOULD_BUILD_BINDINGS=${PGQUERY_BUILD_BINDINGS:-true}

JEXTRACT_URL="https://download.java.net/java/early_access/jextract/22/6/openjdk-22-jextract+6-47_linux-x64_bin.tar.gz"

LIBPG_QUERY_URL="git@github.com:pganalyze/libpg_query.git"

if [ $SHOULD_BUILD_BINDINGS == "true" ];
then
    echo "Downloading jextract..."
    curl -s -o jextract.tar.gz $JEXTRACT_URL
    tar -xzf jextract.tar.gz
    rm jextract.tar.gz
    echo "Downloaded jextract."
fi

for version in $(cat scripts/PG_VERSIONS)
do
    LIBPG_QUERY_TAG="$version-latest"
    # fetch
    echo "Cloning libpg_query... ($LIBPG_QUERY_TAG)"
    git clone --depth 1 --branch $LIBPG_QUERY_TAG $LIBPG_QUERY_URL
    
    PG_QUERY_PACKAGE="libpg_query.v$version"
    
    # if PGQUERY_BUILD_BINDINGS is set, generate bindings
    if [ $SHOULD_BUILD_BINDINGS == "false" ];
    then
        echo "Generating bindings ($PG_QUERY_PACKAGE)"
        ./jextract-22/bin/jextract \
           --output modules/pgquery-bindings/src/main/java/ libpg_query/pg_query.h \
           --target-package $PG_QUERY_PACKAGE \
           --library pg_query_v$version
    fi

    # if PGQUERY_BUILD_SHARED is set, build shared library
    if [ $SHOULD_BUILD_SHARED == "true" ];
    then
        echo "Compiling shared library ($PG_QUERY_PACKAGE)"
        cd libpg_query
        make build_shared
        mkdir -p ../lib
        mv libpg_query.so ../lib/libpg_query_v$version.so
        cd ..
    fi
    
    rm -rf libpg_query
done

rm -rf jextract-22
echo "Done."