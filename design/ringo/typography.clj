(ns ringo.typography
  (:refer-clojure :exclude [+ - * / rem])
  (:require [garden.def :refer [defstyles defrule defkeyframes]]
            [garden.core :refer [css]]
            [garden.units :as u :refer [px pt]]
            [garden.units :refer (px+ px* px- px-div em rem)]
            [garden.arithmetic :refer [+ - * /]]
            [garden.stylesheet :refer [at-media]]))

(def font-family-serif ["\"EB Garamond\"" "serif"])
(def font-family-sans-serif ["\"Fira Sans\"" "sans-serif"])
(def font-family-monospace ["\"Source Code Pro\"" "monospace"])

(def fonts {:font-size-base (em 1.5)
            :line-height-base (em 1.45)
            :ff-serif ["EB Garamond" "Serif"]
            :ff-sans ["Fira Sans" "sans-serif"]
            :ff-mono ["Source Code Pro" "monospace"]})

;; Basic

(def typesetting
  [[:body :p (font font-family-sans-serif 2 300 0.1 1.5)]
   [:h1 (font font-family-sans-serif 3 600 0.5 2)]
   [:h2 (font font-family-sans-serif 3 400 0.5 2)]
   [:h3 (font font-family-serif 2 300 0.5 2)]
   [:h4 (font font-family-serif 1.5 300 0.3 2)]
   [:h5 :h6 (font font-family-serif 1.5 300 0.3 1.5)]
   [:header (font font-family-sans-serif 4 700 0.3 1.5 "small-caps")]
   [:footer (font font-family-sans-serif 1 100 0.3 1.5)]])

;; Mixins

(defn font [family size weight letter-spacing line-height & options]
  {:font-family family
   :font-size (rem size)
   :font-weight weight
   :letter-spacing (rem letter-spacing)
   :line-height (em line-height)
   :text-transform (get options :text-transform "none")})

(defn reset [fonts]
  {:font (font font-family-serif 2 300 2 2)
   :text {:decoration "none"}
   :font-size-base (em (:font-size-base fonts))
   :line-height-base (em (:line-height-base fonts))})

(defn wrap [fonts selector]
  (fn [rules]
    (let [styles (selector rules)]
      (conj [] styles fonts))))

(defn responsive-font [min max width]
  (at-media {:min-width (px min)
             :max-width (px max)}
            [:container {:width (px width)}]))

;; Elements

(def defaults
  [:body :p :h1 :h2 (font font-family-sans-serif 2 300 0.3 2)])

(def typography
  (-> fonts
      reset
      (wrap [:h1 :h2 :h3 :h4 :h5 :h6])))

(defstyles styles
  (list defaults typesetting))
