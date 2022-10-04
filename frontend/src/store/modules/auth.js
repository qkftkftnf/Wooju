import router from "../../router";
import axios from "axios";
import http from "@/api/index.js"

const mypage = {
  state: {
    token: sessionStorage.getItem('token') || ''
  },
  mutations: {
    SET_TOKEN: (state, token) => state.token = token,
  },
  getters: {
    token: state => state.token,
    isLoggedIn: state => !!state.token,
    authHeader: state => ({ Authorization: `Bearer ${state.token}` }),
  },
  actions: {
    saveToken({ commit }, token) {
      commit('SET_TOKEN', token)
      localStorage.setItem('token', '')
      sessionStorage.setItem('token', token)
    },
    logout({ commit, getters }) {
      router.push({ name: 'home' })
      if (getters.isLoggedIn) {
        logout(getters.authHeader)
          .then(res => {
            sessionStorage.setItem('token', '')
            commit('SET_TOKEN', '')
          })
      }
    },
    signup(signupInfo) {
      http.post("/user/signup", signupInfo)
      .then(({ data }) => {
        console.log(data)
        // router push to main page
        router.push({ name: communityMain })
      })
      .catch((err) => console.log(err))
    },
  },
}

export default mypage