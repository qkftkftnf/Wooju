import http from "@/api/index.js"

const mypage = {
  state: {
    profile: {},
    sool: [],
  },
  mutations: {
    SET_PROFILE: (state, profile) => (state.profile = profile),
    SET_SOOL: (state, sool) => (state.sool = sool),
  },
  getters: {
    profile: (state) => state.profile,
    sool: (state) => state.sool,
  },
  actions: {
    fetchProfile({ commit }) {
      http.get("/user/profile")
        .then(({ data }) => {
          commit("SET_PROFILE", data)
        })
        .catch((err) => console.log(err))
    },
    fetchSool({ commit }) {
      http.get('/product',
        {
          params: {
            size: 10,
          }
        }
      )
        .then(({ data }) => {
          commit("SET_SOOL", data.items)
        })
        .catch((err) => console.log(err))
    }
  },
}

export default mypage