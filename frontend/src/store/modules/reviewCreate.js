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
    createReview({}, reviewData) {
      axios({
        method: "POST",
        url: "https://j7a304.p.ssafy.io/api/image/uploads",
        headers: {
          "Content-Type": "multipart/form-data",
        },
        data: reviewData.file,
      })
        .then(({ data }) => {
          console.log("hey", data)

          http.post("/review", {
            content: reviewData.content,
            img: data.imgs,
            product_id: reviewData.product_id,
            star: reviewData.star,
            title: "title 핑료?"
          })
          .then(({ data }) => {
            router.push({
              name: "MyPageMain",
            })
            console.log("success", data)
          })
          .catch((err) => console.log(err))
      })
      .catch((err) => console.log(err))
    },
  },
}

export default reviewCreate