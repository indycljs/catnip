(defproject catnip "0.6.0-SNAPSHOT"
  :plugins [[lein-cljsbuild "0.3.0"]
            [lein-exec "0.2.1"]]
  :description "The irresistible Clojure IDE-in-a-plugin"
  :url "https://github.com/bodil/catnip"
  :license {:name "Mozilla Public License"
            :url "http://www.mozilla.org/MPL/2.0/"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.webbitserver/webbit "0.4.6"]
                 [org.clojure/clojurescript "0.0-1576"]
                 [clj-info "0.3.1"]
                 [enlive "1.0.1"]
                 [clj-stacktrace "0.2.5"]
                 [cheshire "5.0.1"]
                 ; -- Cljs deps --
                 [jayq "2.0.0"]
                 [hiccups "0.1.1"]
                 [org.bodil/pylon "0.3.0"]
                 [org.bodil/redlobster "0.2.0"]]
  :hooks [leiningen.cljsbuild]
  :source-paths ["src"]
  :cljsbuild {:builds
              [{:source-paths ["cljs"]
                :compiler
                {:output-to "resources/catnip/cljs/main.js"
                 :output-dir "resources/catnip/cljs"
                 :optimizations :whitespace
                 :pretty-print true}}]}
  :main catnip.server)
