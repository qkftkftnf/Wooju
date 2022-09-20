import { createRouter, createWebHistory } from "vue-router";

import TapTemplate from "../views/community/TapTemplate.vue";
import CommunityHotReview from "../views/community/CommunityHotReview.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      name: "TapTemplate",
      path: "",
      component: TapTemplate,
    },
    {
      name: "CommunityHotReview",
      path: "/hotreview",
      component: CommunityHotReview,
    },
  ],
});

export default router;
