#!/bin/sh

cd $(dirname $0)/..
[ -d dist ] || mkdir dist
javac -d dist src/*.java

