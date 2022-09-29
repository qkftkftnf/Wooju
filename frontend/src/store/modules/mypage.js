import router from "../../router";
import http from "@/api/index.js"

const mypage = {
  state: {
    profile: {},
    woojoo: [],
    isLoaded: false,
  },
  mutations: {
    SET_PROFILE: (state, profile) => (state.profile = profile),
    SET_WOOJOO: (state, woojoo) => (state.woojoo = woojoo),
    SET_ISLOADED: (state, isLoaded) => (state.isLoaded = isLoaded),
  },
  getters: {
    profile: (state) => state.profile,
    woojoo: (state) => state.woojoo,
    isLoaded: (state) => state.isLoaded,
  },
  actions: {
    fetchProfile({ commit }) {
      commit("SET_ISLOADED", false)
      http.get("/user/profile")
        .then(({ data }) => {
          commit("SET_PROFILE", data)
          console.log(data)
        })
        .then(() => {
          commit("SET_ISLOADED", true)
          }
        )
        .catch((err) => console.log(err))
    },
    updateProfile({}, profileInfo) {
      http.put("/review", profileInfo)
        .then(({ data }) => {
          router.push({
            name: "MyPageMain",
          })
        })
        .catch((err) => console.log(err))
    }
  },
}

export default mypage