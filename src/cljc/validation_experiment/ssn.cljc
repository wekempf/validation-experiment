(ns validation-experiment.ssn
  (:require [clojure.spec.alpha :as s]
            [clojure.string :as string]))

(defn- valid-format? [ssn]
  (boolean (re-matches #"\d{9}|\d{3}-\d{2}-\d{4}" ssn)))

(defn- parseInt [s]
  #?(:clj (Integer/parseInt s))
  #?(:cljs (js/parseInt s)))

(defn- valid-area? [ssn]
  (let [area (subs ssn 0 3)]
    (and
     (not= area "000")
     (not (some #{(parseInt area)} (range 700 799))))))

(defn digits [ssn]
  (string/replace ssn "-" ""))

(defn- valid-group? [ssn]
  (let [group (subs (digits ssn) 3 5)]
    (not= group "00")))

(defn- valid-serial-number? [ssn]
  (let [serial-number (subs (digits ssn) 5 9)]
    (not= serial-number "0000")))

(s/def ::ssn (s/and string? valid-format? valid-area? valid-group? valid-serial-number?))
