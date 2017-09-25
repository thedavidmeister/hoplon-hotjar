(ns hoplon-hotjar.data
 #?(:clj (:require
          environ.core)))

#?(:clj (def id (or (environ.core/env :hoplon-hotjar-id) ""))
   :cljs (goog-define id ""))

(def enabled?
 (and
  (not (= "" id))))
