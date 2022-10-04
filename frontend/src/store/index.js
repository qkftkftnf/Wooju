import { createStore } from "vuex";

import community from "./modules/community"
import mypage from "./modules/mypage"
import woojooDetail from "./modules/woojooDetail"
import reviewCreate from "./modules/reviewCreate"
import woojooSearch from "./modules/woojooSearch"
import recommendation from "./modules/recommendation";
import auth from "./modules/auth"

const store = createStore({
  modules: {
    community,
    mypage,
    woojooDetail,
    reviewCreate,
    woojooSearch,
    recommendation,
    auth
  },
})

export default store;