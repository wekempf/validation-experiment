(ns validation-experiment.core
  (:require [reagent.core :as reagent :refer [atom]]
            [validation-experiment.ssn :as ssn]
            [clojure.spec.alpha :as s]
            [phrase.alpha :refer [phrase-first defphraser]]
            [validation-experiment.i18n :refer [tr lang]]))

(defonce ssn (atom "123-45-6789"))

(defphraser :default
  [_ _]
  "Invalid value!")

(defn- swap-lang [cur-lang]
  (if (= cur-lang :en)
    :de-DE
    :en))

(defn example []
  [:div [:label (tr [:ui/ssn-label "Enter SSN: "]) [:input {:type :text :value @ssn :on-change #(reset! ssn (-> % .-target .-value))}]]
   [:p {:style {:color "red"}} (phrase-first {} :validation-experiment.ssn/ssn @ssn)]
   [:p [:input {:type :button :value (if (= @lang :en) "German" "English") :on-click #(swap! lang swap-lang)}]]])

(defn mount-root []
  (reagent/render [example] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
