import { createRouter, createWebHistory } from "vue-router";

import CommunityMain from "../views/community/CommunityMain.vue";
import CommunityHotReview from "../views/community/CommunityHotReview.vue";
import WoojooSearch from "../views/woojoo_search/WoojooSearch.vue"
import WoojooDetail from "../views/woojoo_search/WoojooDetail.vue"
import MyPageMain from "../views/mypage/MyPageMain.vue";
import MyRecommendationView from "../views/recommendation/MyRecommendationView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      name: "CommunityMain",
      path: "",
      component: CommunityMain,
    },
    {
      name: "CommunityHotReview",
      path: "/hotreview",
      component: CommunityHotReview,
    },
    {
      name: "WoojooSearch",
      path: "/Woojoo",
      component: WoojooSearch,
    },
    {
      name: "MyPageMain",
      path: "/id",
      component: MyPageMain,
    },
    {
      name: "WoojooDetail",
      path: "/woojoo/1",
      component: WoojooDetail,
    },
    {
      name: "MyRecommendationView",
      path: "/recommendation/userpk",
      component: MyRecommendationView,
    }
  ],
});

export default router;
