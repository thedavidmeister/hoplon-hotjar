(ns hoplon-hotjar.build
 (:require
  hoplon-hotjar.data))

(defn with-cljs-compiler-options
 ([] (with-cljs-compiler-options {}))
 ([options]
  (-> options
   (assoc-in [:closure-defines 'hoplon-hotjar.data/id] hoplon-hotjar.data/id))))
