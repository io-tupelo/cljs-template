#!/bin/bash -v

rm -rf target
# clojure  -m figwheel.main  --compile demo.core  --repl   # or -b, -r
clojure  -m figwheel.main  --build dev  --repl   # or -b, -r

