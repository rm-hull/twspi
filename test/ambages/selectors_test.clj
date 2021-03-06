;; The MIT License (MIT)
;;
;; Copyright (c) 2016 Richard Hull
;;
;; Permission is hereby granted, free of charge, to any person obtaining a copy
;; of this software and associated documentation files (the "Software"), to deal
;; in the Software without restriction, including without limitation the rights
;; to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
;; copies of the Software, and to permit persons to whom the Software is
;; furnished to do so, subject to the following conditions:
;;
;; The above copyright notice and this permission notice shall be included in all
;; copies or substantial portions of the Software.
;;
;; THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
;; IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
;; FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
;; AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
;; LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
;; OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
;; SOFTWARE.

(ns ambages.selectors-test
  (:require
    [clojure.test :refer :all]
    [ambages.selectors :refer :all]))

(deftest check-lvl
  (is (nil? (lvl 3)))
  (is (= 0 (lvl (molec 0 '?x)))))

(deftest check-xpr
  (is (nil? (xpr 3)))
  (is (= '?x (xpr (molec 0 '?x)))))

(def env
  (->>
    []
    (bind '?x 3)
    (bind '?y 4)
    (bind '?z '?y)))

(deftest check-bind
  (is (= '((?z ?y) (?y 4) (?x 3)) env)))

(deftest check-bond
  (is (= 3 (bond '?x env)))
  (is (nil? (bond '?a env))))
