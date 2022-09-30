import { createStore } from "vuex";

import community from "./modules/community"
import mypage from "./modules/mypage"
import woojooDetail from "./modules/woojooDetail"
import reviewCreate from "./modules/reviewCreate"
import woojooSearch from "./modules/woojooSearch"

const store = createStore({
  modules: {
    community,
    mypage,
    woojooDetail,
    reviewCreate,
    woojooSearch,
  },
})

export default store;