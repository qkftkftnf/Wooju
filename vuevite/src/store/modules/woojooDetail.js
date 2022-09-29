import http from "@/api/index.js"

const WoojooDetail = {
  state: {
    woojooReviews : {},
  },
  mutations: {
    SET_WOOJOOREVIEWS: (state, woojooReviews) => (state.woojooReviews = woojooReviews),
    // SET_WOOJOO: (state, woojoo) => (state.woojoo = woojoo),
  },
  getters: {
    woojooReviews: (state) => state.woojooReviews,
    // woojoo: (state) => state.woojoo,
  },
  actions: {
    fetchWoojooReviews({ commit }) {
      http.get("")
        .then(({ data }) => {
          commit("SET_WOOJOOREVIEWS", data)
        })
        .catch((err) => console.log(err))
    },
    // fetchWoojoo({ commit }) {
    //   http.get('/product',
    //     {
    //       params: {
    //         size: 10,
    //       }
    //     }
    //   )
    //     .then(({ data }) => {
    //       commit("SET_WOOJOO", data.items)
    //     })
    //     .catch((err) => console.log(err))
    // }
  },
}

export default WoojooDetail