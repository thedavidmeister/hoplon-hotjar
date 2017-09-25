(ns hoplon-hotjar.data
 #?(:clj (:require
          environ.core)))

#?(:clj (def id (environ.core/env :hoplon-hotjar-id))
   :cljs (goog-define id ""))
#?(:clj (def sv (environ.core/env :hoplon-hotjar-sv))
   :cljs (goog-define sv ""))

(def enabled?
 (and
  (not (= "" id))
  (not (= "" sv))))
