import router from "../../router"
import axios from "axios"

import http from "@/api/index.js"

const community = {
  state: {
    reviews: {},
    review: {},
  },
  mutations: {
    SET_REVIEWS: (state, reviews) => (state.reviews = reviews),
  },
  getters: {
    reviews: (state) => state.reviews,
  },
  actions: {
    fetchAllReviews({ commit }) {
      http.get("/review")
        .then(({ data }) => {
          commit("SET_REVIEWS", data)
        })
        .catch((err) => console.log(err))
    }
  }, 
}

export default community