import { createStore } from "vuex";

import community from "./modules/community"
import mypage from "./modules/mypage"
import woojooDetail from "./modules/woojooDetail";

const store = createStore({
  modules: {
    community,
    mypage,
    woojooDetail
  },
})

export default store;