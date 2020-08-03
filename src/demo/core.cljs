;   Copyrigh (c) Alan Thompson. All rights reserved.
;   The use and distribution terms for this software are covered by the Eclipse Public License 1.0
;   (http://opensource.org/licenses/eclipse-1.0.php) which can be found in the file epl-v10.html at
;   the root of this distribution.  By using this software in any fashion, you are agreeing to be
;   bound by the terms of this license.  You must not remove this notice, or any other, from this
;   software.
(ns demo.core
  (:require
    [tupelo.core :as t]
    [reagent.core :as r]
    [reagent.dom :as rdom]
    ))

(defn add2
  "adds 2 numbers"
  [x y]
  (+ x y))

; NOTE:  it seems this must be in a *.cljs file or it doesn't work on figwheel reloading
(enable-console-print!)
(println
  "This text is printed from src/flintstones/core.cljs.
  Go ahead and edit it and see reloading in action. Again, or not.")
(println "Hello World! ")
(t/spyx :something (+ 2 3))

;---------------------------------------------------------------------------------------------------
(defn root []
  [:div {:class "container"}
   [:hr]
   [:div
    [:p "I am a component!"]
    [:p.someclass
     "I have " [:strong "bold"]
     [:span {:style {:color "red"}} " and red"] " text."]]
   [:hr]
   [:div
    [:p "Last paragraph....."]]])


(defn app-start
  "Initiates the cljs application"
  []
  (println "app-start - enter")
  (rdom/render [root] (js/document.getElementById "tgt-div"))
  (println "app-start - leave"))

;***************************************************************************************************
; kick off the app
(app-start)

