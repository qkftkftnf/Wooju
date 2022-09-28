import { createStore } from "vuex";

import community from "./modules/community"
import mypage from "./modules/mypage"

const store = createStore({
  modules: {
    community,
    mypage,
  },
})

export default store;