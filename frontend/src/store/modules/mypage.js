import http from "@/api/index.js"

const mypage = {
  state: {
    profile: {},
    woojoo: [],
  },
  mutations: {
    SET_PROFILE: (state, profile) => (state.profile = profile),
    SET_WOOJOO: (state, woojoo) => (state.woojoo = woojoo),
  },
  getters: {
    profile: (state) => state.profile,
    woojoo: (state) => state.woojoo,
  },
  actions: {
    fetchProfile({ commit }) {
      http.get("/user/profile")
        .then(({ data }) => {
          commit("SET_PROFILE", data)
        })
        .catch((err) => console.log(err))
    },
    fetchWoojoo({ commit }) {
      http.get('/product',
        {
          params: {
            size: 10,
          }
        }
      )
        .then(({ data }) => {
          commit("SET_WOOJOO", data.items)
        })
        .catch((err) => console.log(err))
    }
  },
}

export default mypage