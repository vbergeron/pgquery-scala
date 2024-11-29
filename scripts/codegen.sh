#!/usr/bin/env bash

# download jextract
JEXTRACT_URL="https://download.java.net/java/early_access/jextract/22/6/openjdk-22-jextract+6-47_linux-x64_bin.tar.gz"

echo "Downloading jextract..."
curl -s -o jextract.tar.gz $JEXTRACT_URL
tar -xzf jextract.tar.gz
rm jextract.tar.gz
echo "Downloaded jextract."

LIBPG_QUERY_URL="git@github.com:pganalyze/libpg_query.git"

for version in $(cat scripts/PG_VERSIONS)
do
    LIBPG_QUERY_TAG="$version-latest"
    # fetch
    echo "Cloning libpg_query... ($LIBPG_QUERY_TAG)"
    git clone --depth 1 --branch $LIBPG_QUERY_TAG $LIBPG_QUERY_URL
    
    PG_QUERY_PACKAGE="libpg_query.v$version"
    
    echo "Generating bindings ($PG_QUERY_PACKAGE)"
    ./jextract-22/bin/jextract \
       --output modules/pgquery/src/main/java/ libpg_query/pg_query.h \
       --target-package $PG_QUERY_PACKAGE \
       --library pg_query
    
    rm -rf libpg_query
done

rm -rf jextract-22
echo "Done."