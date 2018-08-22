(ns validation-experiment.i18n
  #?(:clj  (:require [taoensso.tempura :as tempura]))
  #?(:cljs (:require [taoensso.tempura :as tempura]
                     [reagent.core :as reagent :refer [atom]])))

(defonce lang (atom :en))

(def ^:private translations
  {:en
   {:missing "en missing text"
    :ui {:ssn-label "Please enter an SSN: "}
    :ssn {:invalid-format "Not a valid SSN format."
          :invalid-area (fn [[v]] (str "\"" v "\" is not a valid area segment."))
          :invalid-group (fn [[v]] (str "\"" v "\" is not a valid group segment."))
          :invalid-serial-number (fn [[v]] (str "\"" v "\" is not a valid serial number."))}}
   :de-DE
   {:missing "de-DE missing text"
    :ui {:ssn-label "Bitte geben Sie eine SSN ein: "}
    :ssn {:invalid-format "Kein gültiges SSN-Format."
          :invalid-area (fn [[v]] (str "\"" v "\" ist kein gültiges Flächensegment."))
          :invalid-group (fn [[v]] (str "\"" v "\" ist kein gültiges Gruppensegment."))
          :invalid-serial-number (fn [[v]] (str "\"" v "\" ist keine gültige Seriennummer."))}}})

(defn tr
  ([resource-ids] (tr resource-ids nil))
  ([resource-ids resource-args] (tempura/tr {:dict translations} [@lang :en] resource-ids resource-args)))