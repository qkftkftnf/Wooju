import router from "../../router";
import axios from "axios";
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
        })
        .then(() => {
          commit("SET_ISLOADED", true)
          }
        )
        .catch((err) => console.log(err))
    },
    profileEdit({}, profileInfo) {
      axios({
        method: "POST",
        url: "https://j7a304.p.ssafy.io/api/image/upload",
        headers: {
          "Content-Type": "multipart/form-data",
        },
        data: profileInfo.file,
      })
        .then(({ data }) => {
          http.put("/user/profile", {
            nickname: profileInfo.nickname,
            img: data.img
          })
          .then(({ data }) => {
            router.push({
              name: "MyPageMain",
            })
          })
          .catch((err) => console.log(err))
      })
      .catch((err) => console.log(err))
    },
  },
}

export default mypage