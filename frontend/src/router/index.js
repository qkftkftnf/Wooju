import { createRouter, createWebHistory } from "vue-router";

import CommunityMain from "../views/community/CommunityMain.vue";
import CommunityHotReview from "../views/community/CommunityHotReview.vue";

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
  ],
});

export default router;
