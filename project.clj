(defproject cljs-template "20.08.03"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version "2.9.1"

  :global-vars {*warn-on-reflection* false}

  :excludes [org.clojure/clojure
             org.clojure/clojurescript]

  :dependencies
  [
   [org.clojure/spec.alpha "0.2.187"]
   [org.clojure/test.check "1.1.0"]
   [org.clojure/tools.reader "1.3.2"]
   [prismatic/schema "1.1.12"]

   ; #todo clojures pprint doesn't work under graal native-image
   ]

  ; Using `lein-ancient check :all` checks plugins
  :plugins [[lein-cljsbuild "1.1.8"]
            [lein-codox "0.10.7"]
            ;[lein-nomis-ns-graph "0.14.2"]
            [com.jakemccrary/lein-test-refresh "0.24.1"]]

  :test-refresh {:quiet true ; true => suppress printing namespaces when testing
                 }

  :codox {:src-dir-uri               "http://github.com/cloojure/tupelo/blob/master/"
          :src-linenum-anchor-prefix "L"
          :source-paths              ["src/clj" "src/cljc"]
          :language                  :clojure
          :namespaces                [#"^tupelo\."]}

  :profiles {:provided {:dependencies [[org.clojure/clojure "1.8.0" :scope "provided"]
                                       [org.clojure/clojurescript "1.10.597" :scope "provided"]
                                       ]}
             :dev      {:dependencies [
                                       [org.clojure/clojure "1.10.2-alpha1"]
                                      ;[org.clojure/clojurescript  "1.10.764"] ; "1.10.597"
                                       ]
                        }
             :test     {:dependencies [[overtone/at-at "1.2.0"]]}
             :1.8      {:dependencies [[org.clojure/clojure "1.8.0"]]}
             :1.9      {:dependencies [[org.clojure/clojure "1.9.0"]]}
             }
  :source-paths ["src/clj" "src/cljc"]
  :test-paths ["test/clj" "test/cljc"]
  :target-path "target/%s"

  ; need to add the compliled assets to the :clean-targets
  :clean-targets ^{:protect false} ["resources/public/js/compiled"
                                    "out"
                                    :target-path]

  ; "lein test"         will not  run tests marked with the ":slow" metadata
  ; "lein test :slow"   will only run tests marked with the ":slow" metadata
  ; "lein test :all"    will run all  tests (built-in)
  :test-selectors {:default (complement :slow)
                   :slow    :slow
                   :fast    :fast}
  ; #todo broken for tupelo.test/dospec - why?

  ; :main ^:skip-aot demo.core
  ; :uberjar      {:aot :all}

  ; :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}

  ; automatically handle `--add-modules` stuff req'd for Java 9 & Java 10
  :jvm-opts ["-Xms500m" "-Xmx2g"
             ; "--illegal-access=permit"  ; may need for Java10+  [ permit, warn, debug, deny ]
             ]
  )
















