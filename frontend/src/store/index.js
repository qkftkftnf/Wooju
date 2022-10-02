import { createStore } from "vuex";

import community from "./modules/community"
import mypage from "./modules/mypage"
import woojooDetail from "./modules/woojooDetail";
import reviewCreate from "./modules/reviewCreate"
import recommendation from "./modules/recommendation";

const store = createStore({
  modules: {
    community,
    mypage,
    woojooDetail,
    reviewCreate,
    recommendation,
  },
})

export default store;