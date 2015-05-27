(ns ui.components.page-styles
  (:require  [garden.core :refer [css]]
             [garden.units :as u :refer [px pt em]]
             [garden.color :as color :refer [hsl rgb]]
             [mesh.dom :as mesh-dom :refer [insert-styles]]
             [mesh.utils :as utils]
             [mesh.images :as images]
             [mesh.respond :as respond :refer [breakpoints]]
             [mesh.grid :as grid]
             [mesh.typography :as typo :refer [typeset]]
             [mesh.typesetting :as typesetting :refer [scale-type make-serifs]]))

(def serif ["Alegreya" "Baskerville" "Georgia" "Times" "serif"])
(def ff-sans ["\"Fira Sans\"" "sans-serif"])
(def ff-mono ["\"Source Code Pro\"" "monospace"])

(def base-color "#f921ab")
(def color-grey "#fff")

(def red (hsl 0 100 50))
(def orange (color/hsl 30 100 50))

(defn page-settings [bg-color padding]
  [:body
   {:border-width (px 100)
    :background-color bg-color
    :color (color/mix bg-color red)
    :padding (em padding)
    :marging (em 10)
    :line-height 3}])

(def gutter (px 20))

(def defaults
  {:line-height-ratio 1.5
   :header-ratio (:golden scales)
   :min-width (px 480)
   :max-width (px 960)
   :min-font (px 12)
   :max-font (px 28)
   :body-color "#666"
   :body-font (:garamond font-families)
   :body-font-weight 400
   :header-font (:garamond font-families)
   :header-font-weight 600
   :header-color "#111"
   :breakpoints {:mobile (px 480)
                 :tablet (px 720)
                 :laptop (px 960)}})

(def typography-base
  (typeset serif sans mono))

(defn body-copy [declarations]
  [:div :p])

(defn headings [declarations]
  [:h1 :h2])

(defn sub-headings [declarations]
  [:h3 :h4])

(def grids
  (list (grid/create ".grid" (px 30))
        (grid/wrap-widths 960)
        (grid/nuke-gutters-and-padding)
        (grid/respond-small (:mobile breakpoints) (px 20))
        (grid/respond-medium (:tablet breakpoints))
        (images/fit-images ".unit")
        utils/alignments))

(def typography
  (-> headings
      (scale-type settings)
      (make-serifs typo/font-families)))

(def index
  (css (merge
        (page-settings color-grey 2)
        (images/photos)
        grids
        typography-base
        typography)))
