(ns validation-experiment.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [validation-experiment.core-test]))

(doo-tests 'validation-experiment.core-test)
