(ns hoplon-hotjar.hoplon
 (:require
  [hoplon.core :as h]
  hoplon-hotjar.data
  [cljs.test :refer-macros [deftest is]]
  wheel.dom.traversal))

(defn snippet
 []
 (when hoplon-hotjar.data/enabled?
  (js* "(function(h,o,t,j,a,r){ h.hj=h.hj||function(){(h.hj.q=h.hj.q||[]).push(arguments)};})(window,document,'//static.hotjar.com/c/hotjar-','.js?sv=');")
  (aset js/window "_hjSettings" (clj->js {:hjid hoplon-hotjar.data/id :hjsv "5"}))
  (h/script
   :src (str "//static.hotjar.com/c/hotjar-" hoplon-hotjar.data/id ".js?sv=5")
   :async true)))

; TESTS

(deftest ??snippet
 (let [el (snippet)]
  (is (.-hj js/window))
  (is (.-_hjSettings js/window))
  (is (wheel.dom.traversal/is? el "script[async]"))))
