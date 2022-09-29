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

import MyRecommendationView from "../views/recommendation/MyRecommendationView.vue";
import MyRecommendationResult from "../views/recommendation/MyRecommendationResult.vue";

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
          path: "id",
          component: MyPageMain,
        },
        {
          name: "MyPageProfileEdit",
          path: "id/edit",
          component: MyPageProfileEdit,
        }
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
