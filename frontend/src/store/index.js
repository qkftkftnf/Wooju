import { createStore } from "vuex";

import community from "./modules/community"
import mypage from "./modules/mypage"
import woojooDetail from "./modules/woojooDetail";
import reviewCreate from "./modules/reviewCreate"

const store = createStore({
  modules: {
    community,
    mypage,
    woojooDetail,
    reviewCreate,
  },
})

export default store;