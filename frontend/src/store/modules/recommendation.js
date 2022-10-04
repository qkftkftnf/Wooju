import http from "@/api/index.js"
import axios from "axios"
import router from "../../router";

const recommendation = {
  state: {
    recommendation: {
      taste: {},
      today: {},
      award: {},
    }
  },
  mutations: {
    SET_RECOMMENDATION: (state, recommendation) => (state.survey = recommendation)
  },
  getters: {
    recommendation: (state) => state.recommendation,
  },
  actions: {
    submitSurvey({ getters }, surveyInfo) {
      axios.get("https://j7a304.p.ssafy.io/fastapi/test", {
        headers: {Authorization: getters.authHeader},
        params: {
          type: surveyInfo.type,
          question1: surveyInfo.question1,
          question2: surveyInfo.question2,
          question3: surveyInfo.question3,
          question4: surveyInfo.question4,
          question5: surveyInfo.question5,
          question6: surveyInfo.question6,
        }})
      .then(({ data }) => {
        router.push({ 
          name: "MyRecommendationResult",
          // params: { articlePk: res.data },
        });
      })
    },
    fetchRecommendationResult({ commit }) {
      // http.get
    }
  },
}

export default recommendation