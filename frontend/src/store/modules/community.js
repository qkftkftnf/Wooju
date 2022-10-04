import http from "@/api/index.js"

const community = {
  state: {
    reviews: {review: []},
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
    },
    fetchReviews({ commit }, category) {
      http.get(`/review/more/${category}`)
        .then(({ data }) => {
          commit("SET_REVIEWS", data)
        })
        .catch((err) => console.log(err))
    }
  }, 
}

export default community