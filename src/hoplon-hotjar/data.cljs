(ns hoplon-hotjar.data)

(goog-define id "")

(goog-define sv "")

(def enabled? (and (not (= "" id))
                   (not (= "" sv))))
