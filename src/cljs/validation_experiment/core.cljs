(ns validation-experiment.core
  (:require [reagent.core :as reagent :refer [atom]]
            [validation-experiment.ssn :as ssn]
            [clojure.spec.alpha :as s]))

(defonce ssn (atom "123-45-6789"))

(defn example []
  [:div [:label "Enter SSN: " [:input {:type :text :value @ssn :on-change #(reset! ssn (-> % .-target .-value))}]]
   [:p {:style {:color "red"}} (str (s/explain-data :validation-experiment.ssn/ssn @ssn))]])

(defn mount-root []
  (reagent/render [example] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
