(ns ^:figwheel-no-load validation-experiment.dev
  (:require
    [validation-experiment.core :as core]
    [devtools.core :as devtools]))

(devtools/install!)

(enable-console-print!)

(core/init!)
