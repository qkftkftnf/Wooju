import http from "@/api/index.js"

const community = {
  state: {
    reviews: {review: []},
    review: {},
    isCommunityLoaded: false,
  },
  mutations: {
    SET_REVIEWS: (state, reviews) => (state.reviews = reviews),
    SET_IS_COMMUNITY_LOADED: (state, isCommunityLoaded) => (state.isCommunityLoaded = isCommunityLoaded),
  },
  getters: {
    reviews: (state) => state.reviews,
    isCommunityLoaded: (state) => state.isCommunityLoaded,
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
      commit("SET_IS_COMMUNITY_LOADED", false)
      http.get(`/review/more/${category}`)
        .then(({ data }) => {
          commit("SET_REVIEWS", data)
        })
        .then(() => {
          commit("SET_IS_COMMUNITY_LOADED", true)
        })
        .catch((err) => console.log(err))
    }
  }, 
}

export default community