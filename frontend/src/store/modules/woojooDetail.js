import http from "@/api/index.js"

const WoojooDetail = {
  state: {
    // woojooReviews : [],
    woojooInfo : {},
    isLike : false,
  },
  mutations: {
    // SET_WOOJOOREVIEWS: (state, woojooReviews) => (state.woojooReviews = woojooReviews),
    SET_WOOJOOINFO: (state, woojooInfo) => (state.woojooInfo = woojooInfo),
    // SET_WOOJOO: (state, woojoo) => (state.woojoo = woojoo),
    SET_ISLIKE: (state, isLike) => (state.isLike = isLike),
  },
  getters: {
    // woojooReviews: (state) => state.woojooReviews,
    woojooInfo: (state) => state.woojooInfo,
    // woojoo: (state) => state.woojoo,
    isLike: (state) => state.isLike,
  },
  actions: {
    // fetchWoojooReviews({ commit }) {
    //   console.log('-----3---')
    //   http.get('/product/103')
    //     .then(({ data }) => {
    //       console.log(data.list)
    //       commit("SET_WOOJOOREVIEWS", data.list)
    //     })
    //     .catch((err) => console.log(err))
    // },
    fetchWoojooInfo({ commit }, productId) {
      console.log('-----2---')
      http.get(`/product/${productId}`)
        .then(({ data }) => {
          console.log(data)
          commit("SET_WOOJOOINFO", data)
        })
        .catch((err) => console.log(err))
    },

    likeProduct({ getters }, productId) {
      console.log('like')
      console.log(productId)
      http.post('/product/like',{
        headers: {Authorization: getters.authHeader},
        params: {
          'productId': productId
        },
      })
        .then(({data}) => {
          console.log(data)
          commit("SET_ISLIKE", true)
          }
        )
        .catch((err) => console.log(err))
    }
    // fetchWoojoo({ commit }) {
    //   http.get('/product',
    //     {
    //       params: {
    //         size: 10,
    //       }
    //     }
    //   )
    //     .then(({ data }) => {
    //       commit("SET_WOOJOO", data.items)
    //     })
    //     .catch((err) => console.log(err))
    // }
  },
}

export default WoojooDetail