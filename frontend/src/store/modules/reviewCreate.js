import router from "../../router";
import axios from "axios";
import http from "@/api/index.js"

const reviewCreate = {
  state: {
    review: {},
  },
  mutations: {
    SET_REVIEW: (state, review) => (state.review = review),
  },
  getters: {
    review: (state) => state.review,
  },
  actions: {
    fetchReview({ commit }, reviewPk) {
      http.get(`review/${reviewPk}`)
        .then(({ data }) => {
          commit("SET_REVIEW", data)
        })
        .catch((err) => console.log(err))
    },
    createReview({ getters }, reviewData) {
      console.log(typeof reviewData.file.FormData == "undefined")
      console.log(reviewData.file.FormData)
      if (typeof reviewData.file.FormData != "undefined") {
        axios({
          method: "POST",
          url: "https://j7a304.p.ssafy.io/api/image/uploads",
          headers: {
            "Content-Type": "multipart/form-data",
          },
          data: reviewData.file,
        })
          .then(({ data }) => {
            http.post("/review", {
              content: reviewData.content,
              img: data.imgs,
              product_id: reviewData.product_id,
              star: reviewData.star,
            }, {
              headers: {Authorization: getters.authHeader}
            })
            .then(({ data }) => {
              router.push({ 
                name: "WoojooDetail",
                params: { productPk: reviewData.product_id }
              })
            })
            .catch((err) => console.log(err))
        })
        .catch((err) => console.log(err))
      } else {
        http.post("/review", {
          content: reviewData.content,
          img: [],
          product_id: reviewData.product_id,
          star: reviewData.star,
        }, {
          headers: {Authorization: getters.authHeader}
        })
        .then(({ data }) => {
          router.push({ 
            name: "WoojooDetail",
            params: { productPk: reviewData.product_id }
          })
        })
        .catch((err) => console.log(err))
  }
    },
  },
}

export default reviewCreate