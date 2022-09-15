import { createRouter, createWebHistory } from "vue-router";

import CommunityMain from "../views/community/CommunityMain.vue";


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      name: "CommunityMain",
      path: "",
      component: CommunityMain,
    },
  ],
});

export default router;
