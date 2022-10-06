import http from "@/api/index.js"
import axios from "axios"
import router from "../../router";

const recommendation = {
  state: {
    recommendation: {
      taste: [],
      today: [],
      award: [],
    },
    isSurveyed: false,
  },
  mutations: {
    SET_RECOMMENDATION: (state, recommendation) => (state.recommendation = recommendation),
    SET_IS_SURVEYED:(state, isSurveyed) => (state.isSurveyed = isSurveyed),
  },
  getters: {
    recommendation: (state) => state.recommendation,
    isSurveyed: (state) => state.isSurveyed,
  },
  actions: {
    submitSurvey({ commit, getters }, surveyInfo) {
      console.log(surveyInfo)
      http.put("/user/survey", 
        {dto: {
          type: surveyInfo.type,
          question1: surveyInfo.question1,
          question2: surveyInfo.question2,
          question3: surveyInfo.question3,
          question4: surveyInfo.question4,
          question5: surveyInfo.question5,
          question6: surveyInfo.question6,
        }},
        {headers: { Authorization: getters.authHeader },
      })
      .then((data) => {
        // console.log(data)
        commit("SET_IS_SURVEYED", true)
        commit("SET_RECOMMENDATION", data.obj)
        router.push({ 
          name: "MyRecommendationMain",
          // params: { articlePk: res.data },
        });
      })
      .catch((err) => console.log(err))
    },
    fetchRecommendationResult({ commit, getters }) {
      if (getters.isLoggedIn) {
        http.post("/user/survey",
        {dto: {}},
        {
          headers: { Authorization: getters.authHeader },
        })
        .then(({ data }) => {
          console.log(data)
          commit("SET_RECOMMENDATION", data.obj)
          console.log(getters.recommendation)
        })
        .catch((err) => console.log(err))
      }
    }
  },
}

export default recommendation