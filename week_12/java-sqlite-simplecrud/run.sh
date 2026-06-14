#!/bin/sh
set -e
cd "$(dirname "$0")"
./compile.sh
java -cp "lib/sqlite-jdbc.jar;out" com.example.book.Main
