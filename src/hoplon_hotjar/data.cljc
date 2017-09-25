(ns hoplon-hotjar.data
 #?(:clj (:require
          environ.core)))

#?(:clj (def id (or (environ.core/env :hoplon-hotjar-id) ""))
   :cljs (goog-define id ""))
#?(:clj (def sv (or (environ.core/env :hoplon-hotjar-sv) ""))
   :cljs (goog-define sv ""))

(def enabled?
 (and
  (not (= "" id))
  (not (= "" sv))))
