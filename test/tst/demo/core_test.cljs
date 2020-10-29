;   Copyright (c) Alan Thompson. All rights reserved.
;   The use and distribution terms for this software are covered by the Eclipse Public License 1.0
;   (http://opensource.org/licenses/eclipse-1.0.php) which can be found in the file epl-v10.html at
;   the root of this distribution.  By using this software in any fashion, you are agreeing to be
;   bound by the terms of this license.  You must not remove this notice, or any other, from this
;   software.
(ns tst.demo.core-test
  ;---------------------------------------------------------------------------------------------------
  ;   https://code.thheller.com/blog/shadow-cljs/2019/10/12/clojurescript-macros.html
  ;   http://blog.fikesfarm.com/posts/2015-12-18-clojurescript-macro-tower-and-loop.html
  (:require-macros
    [tupelo.testy]
    )
  (:require
    [clojure.test] ; sometimes this is required - not sure why
    [clojure.string :as str]
    [demo.core :as demo]
    [tupelo.core :as t :refer [spy spyx spyxx spy-pretty spyx-pretty
                               vals->map map-plain? forv glue]]
    [tupelo.testy :refer [deftest testing is dotest dotest-focus isnt is= isnt= is-set= is-nonblank=
                          throws? throws-not? define-fixture]]))

(enable-console-print!)

(define-fixture :once
  {:enter (fn [ctx]
            (println "*** TEST ONCE *** - tst.demo.core enter ")
            )
   :leave (fn [ctx]
            (println "*** TEST ONCE *** - tst.demo.core leave ")
            )})


(dotest
  (is= 5 (+ 2 3))
  (is= 5 (demo/add2 2 3))

  ; (is= 99 (+ 2 3))
  )

