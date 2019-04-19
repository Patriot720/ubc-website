(ns ubc-website.views.page-utils
  (:use [hiccup core page])
  (:require
    [ubc-website.presenters.product-page :as p]
    [ubc-website.presenters.util :refer [add-hiccup]]))

;link from publish.twitter.com
(def embedded-twitter-feed "<a class=\"twitter-timeline\" data-width=\"400\" data-height=\"400\" data-theme=\"light\" href=\"https://twitter.com/unclebobmartin?ref_src=twsrc%5Etfw\">Tweets by unclebobmartin</a> <script async src=\"https://platform.twitter.com/widgets.js\" charset=\"utf-8\"></script>")

(defn page-template [content {:keys [events]}]
  (html5
    [:head
     [:title "UBC"]
     (include-css "/css/style.css")]
    [:body
     [:div#header
      [:a {:href "/"}
       [:img#logo {:src "/images/cleancodelogo.png"
                   :align "left"}]]
      [:a {:href "/files/about.md"}
       [:img#caricature {:src "/images/BobCaricature.jpg"
                         :align "right"}]]
      [:p#ubc "Uncle Bob Martin"]
      [:p#ubc-subtitle "Programmer, Speaker, Teacher"]]
     [:div#tabs
      [:a.tab {:href "products"} "Classes & Talks"]
      [:a.tab {:href "books"} "Recommended Books"]
      ]
     content
     [:div#sidebar
      (add-hiccup [:p.sidebar-title "Up Comming Events"]
                  (p/present-events events))
      (add-hiccup [:p.sidebar-title "Uncle Bob's Tweets"]
                  embedded-twitter-feed)

      ]]))