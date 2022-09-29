import { createStore } from "vuex";

import community from "./modules/community"
import mypage from "./modules/mypage"
import reviewCreate from "./modules/reviewCreate"

const store = createStore({
  modules: {
    community,
    mypage,
    reviewCreate,
  },
})

export default store;