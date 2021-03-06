(ns {{name}}.ui.router
  (:require [goog.events :as events]
            [goog.history.EventType :as EventType][om.core :as om]
            [om.dom :as dom]
            [secretary.core :as sec :refer-macros [defroute]]
            [{{name}}.ui.state :as state :refer [app-state]]
            [{{name}}.ui.components.typeahead :as typeahead]
            [{{name}}.ui.components.navigation :as nav]
            [{{name}}.ui.utils :as utils])
  (:import goog.History))

;; (sec/set-config! :prefix "#")

(defn enable-history []
  ;;(sec/set-config! :prefix "#")
  (let [history (History.)
        navigation EventType/NAVIGATE]
    (events/listen history
                   navigation
                   #(-> % .-token sec/dispatch!))
    (doto history (.setEnabled true))))

(defn mount [id page]
  (om/root
   page
   app-state
   {:target (.getElementById js/document id)
    :shared {:url utils/host}
    ;;:instrument (utils/with-omi)
    }))

(defn unmount [id]
  (om/root
   empty-comp
   app-state
   {:target (.getElementById js/document id)}))

(defn refresh-navigation [app-state]
  (let [token (.getToken (History.))
        set-active (fn [nav]
                     (assoc nav :active (= (:path nav) token)))]
    (swap! app-state #(map set-active %))))

(defn on-navigate [event handler]
  (handler)
  (sec/dispatch! (.-token event)))

(defroute "/" []
  (mount "app" nav/view))
(defroute "/typeahead" []
  (mount "app" typeahead/view))

(defn dispatch-current-route []
  (sec/dispatch! (.-pathname (.-location js/window))))
