import { createRouter, createWebHistory } from "vue-router";

import CommunityView from "../views/community/CommunityView.vue";
import CommunityMain from "../views/community/CommunityMain.vue";
import CommunityHotReview from "../views/community/CommunityHotReview.vue";

import WoojooView from "../views/woojoo_search/WoojooView.vue"
import WoojooSearch from "../views/woojoo_search/WoojooSearch.vue"
import WoojooDetail from "../views/woojoo_search/WoojooDetail.vue"
import WoojooReviewCreate from "../views/woojoo_search/WoojooReviewCreate.vue"

import MyPageView from "../views/mypage/MyPageView.vue";
import MyPageMain from "../views/mypage/MyPageMain.vue";
import MyPageProfileEdit from "../views/mypage/MyPageProfileEdit.vue"

import MyRecommendationMain from "../views/recommendation/MyRecommendationMain.vue"
import MyRecommendationView from "../views/recommendation/MyRecommendationView.vue";
import MyRecommendationType from "../views/recommendation/MyRecommendationType.vue";
import MyRecommendationTak from "../views/recommendation/MyRecommendationTak.vue";
import MyRecommendationFruit from "../views/recommendation/MyRecommendationFruit.vue";
import MyRecommendationSoju from "../views/recommendation/MyRecommendationSoju.vue";
import MyRecommendationLover from "../views/recommendation/MyRecommendationLover.vue";
import MyRecommendationExplorer from "../views/recommendation/MyRecommendationExplorer.vue";

import NonmemberView from "../views/common/NonmemberView.vue";

import LoginView from "../views/login/LoginView.vue";
import LoginBase from "../views/login/LoginBase.vue";
import LoginPopup from "../views/login/LoginPopup.vue";
import LoginRedirect from "../views/login/LoginRedirect.vue";
import SignupView from "../views/common/SignupView.vue";


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
          path: "",
          component: MyPageMain,
        },
        {
          name: "MyPageProfileEdit",
          path: "/edit",
          component: MyPageProfileEdit,
        }
      ],
    },
    {
      name: "WoojooDetail",
      path: "/woojoo/:productId",
      component: WoojooDetail,
    },
    {
      name: "MyRecommendationView",
      path: "/recommendation",
      component: MyRecommendationView,
      children: [
        {
          name: "MyRecommendationMain",
          path: "",
          component: MyRecommendationMain,
        },
        {
          name: "MyRecommendationType",
          path: "type",
          component: MyRecommendationType,
        },
        {
          name: "MyRecommendationTak",
          path: "tak",
          component: MyRecommendationTak,
        },
        {
          name: "MyRecommendationFruit",
          path: "fruit",
          component: MyRecommendationFruit,
        },
        {
          name: "MyRecommendationSoju",
          path: "soju",
          component: MyRecommendationSoju,
        },
        {
          name: "MyRecommendationLover",
          path: "result/lover",
          component: MyRecommendationLover,
        },
        {
          name: "MyRecommendationExplorer",
          path: "result/explorer",
          component: MyRecommendationExplorer,
        },
      ]
    },
    // path 수정 요망
    {
      name: "NonmemberView",
      path: "/nonmember",
      component: NonmemberView,
    },
    {
      name: "LoginView",
      path: "/login",
      component: LoginView,
      children: [
        {
          name: "LoginBase",
          path: "",
          component: LoginBase,
        },
        {
          name: "LoginPopup",
          path: "popup/:path",
          component: LoginPopup,
        },
        {
          name: "LoginRedirect",
          path: "redirect/:path",
          component: LoginRedirect,
        },
      ]
    },
    {
      name: "SignupView",
      path: "/signup",
      component: SignupView,
    },
  ],
});

export default router;
