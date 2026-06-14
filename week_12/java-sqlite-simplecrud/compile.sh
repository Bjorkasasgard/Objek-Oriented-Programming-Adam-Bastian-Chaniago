#!/bin/sh
set -e
cd "$(dirname "$0")"
mkdir -p out
javac -cp lib/sqlite-jdbc.jar -d out src/com/example/book/*.java
echo "Compiled to out/"
