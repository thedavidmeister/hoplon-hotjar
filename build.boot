(def project 'thedavidmeister/hoplon-hotjar)
(def description "Hoplon wrapper for hotjar snippets")
(def version "0.1.0-SNAPSHOT")
(def url "https://github.com/thedavidmeister/hoplon-hotjar")

(set-env!
 :source-paths #{"src"}
 :dependencies
 '[[org.clojure/clojure "1.9.0-alpha19"]
   [org.clojure/clojurescript "1.9.908"]
   [adzerk/bootlaces "0.1.13" :scope "test"]
   [crisptrutski/boot-cljs-test "0.3.4" :scope "test"]])

(task-options!
 pom {:project project
      :version version
      :description description
      :url url
      :scm {:url url}})

(require
 '[adzerk.bootlaces :refer :all]
 '[crisptrutski.boot-cljs-test :refer [test-cljs]])
(bootlaces! version)

(deftask tests
 []
 (comp
  (test-cljs)))

(deftask deploy
 []
 (comp
  (build-jar)
  (push-snapshot)))
