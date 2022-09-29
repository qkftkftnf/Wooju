import router from "../../router";
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
    createReview({}, data) {
      http
        .post("/review", data)
        .then((res) => {
          // router.push({
          //   name: "",
          //   params: { something: res.data },
          // });
          console.log(res.data)
        })
        .catch((err) => console.log(err));
    }
  },
}

export default reviewCreate