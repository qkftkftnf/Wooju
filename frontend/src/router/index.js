import { createRouter, createWebHistory } from "vue-router";

import CommunityView from "../views/community/CommunityView.vue";
import CommunityMain from "../views/community/CommunityMain.vue";
import CommunityHotReview from "../views/community/CommunityHotReview.vue";
import WoojooView from "../views/woojoo_search/WoojooView.vue"
import WoojooSearch from "../views/woojoo_search/WoojooSearch.vue"
<<<<<<< HEAD
import WoojooReviewCreate from "../views/woojoo_search/WoojooReviewCreate.vue"
import MyPageView from "../views/mypage/MyPageView.vue";
=======
import WoojooDetail from "../views/woojoo_search/WoojooDetail.vue"
>>>>>>> b03ce1f70c6106ea1fdd480b058540eee9d20ed3
import MyPageMain from "../views/mypage/MyPageMain.vue";
import MyRecommendationView from "../views/recommendation/MyRecommendationView.vue";
import MyRecommendationResult from "../views/recommendation/MyRecommendationResult.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      name: "CommunityView",
      path: "/community",
      component: CommunityView,
      children: [
        {
          name: "CommunityMain",
          path: "",
          component: CommunityMain,
        },
        {
          name: "CommunityHotReview",
          path: "hotreview",
          component: CommunityHotReview,
        },
      ]
    },
    {
      name: "WoojooView",
      path: "/woojoo",
      component: WoojooView,
      children: [
        {
          name: "WoojooSearch",
          path: "search",
          component: WoojooSearch,
        },
        {
          name: "WoojooReviewCreate",
          path: "pk/review/create",
          component: WoojooReviewCreate,
        }
      ]
    },
    {
      name: "MyPageView",
      path: "/mypage",
      component: MyPageView,
      children: [
        {
          name: "MyPageMain",
          path: "id",
          component: MyPageMain,
        },
      ],
    },
    {
      name: "WoojooDetail",
      path: "/woojoo/1",
      component: WoojooDetail,
    },
    {
      name: "MyRecommendationView",
      path: "/recommendation",
      component: MyRecommendationView,
      children: [
        {
          name: "MyRecommendationResult",
          path: "userpk",
          component: MyRecommendationResult,
        },
      ]
    },
  ],
});

export default router;
