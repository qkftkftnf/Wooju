<template>
  <div class="tab-template detail-header-container">
    <!-- <div class="mypage-header">
      <div class="header-nick">
        닉네임스토리
      </div>
      <div class="mode-toggle">
        <ModeToggle/>
      </div>
    </div> -->
    <div class="detail-header">
      <span class="like">
        <i class="fas fa-heart icon"></i>{{woojooInfo.object?.like_num}}
      </span>
      <div>
        <img class="bg-box" :src="woojooInfo.object?.image" alt="">
        
      </div>
      <span class="like-add">
        <i class="fas fa-heart icon"></i>{{woojooInfo.object?.like_num}}
      </span>
    </div>
    <HeaderView/>
    <div class="mypage-container" id="detail-container">
      <!-- tabs menu -->
      <div class="mypage-tabs">
        <div class="tabs-menu-container">
          <div class="tab tab-type" @click="tabPosition('detail-content')">
            상세정보
          </div>
          <div class="tab tab-likes" @click="tabPosition('mypage-likes')">
            구매처 링크
          </div>
          <div class="tab tab-reviews" @click="tabPosition('detail-reviews')">
            리뷰
          </div>
          <div class="tabs-now">
            <span class="under-bar"></span>
          </div>
        </div>
      </div>
      <div class="tabs-container">
        <div class="tab-control">
          <!-- tab1 -->
          <div class="tab-section detail-content">
            <el-scrollbar>
              <DetailContent/>
            </el-scrollbar>
          </div>
          <!-- tab2 -->
          <div class="tab-section mypage-likes">
            <el-scrollbar>
              <MyPageLikes/>
            </el-scrollbar>
          </div>
          <!-- tab3 -->
          <div class="tab-section detail-reviews">
            <el-scrollbar>
              <DetailReviews/>
            </el-scrollbar>
          </div>
        </div>
        <div class="scroll-false"></div>
      </div>
    </div>

  </div>
</template>

<script setup>
import HeaderView from "@/views/common/HeaderView.vue"
import DetailContent from "@/views/woojoo_search/DetailContent.vue"
import DetailReviews from "@/views/woojoo_search/DetailReviews.vue"
import MyPageLikes from "@/views/mypage/MyPageLikes.vue"
import { ref, computed, onMounted } from "vue";
import { useRouter, useRoute } from "vue-router";
import { useStore } from "vuex";

const router = useRouter();
const route = useRoute()
// const linkTo = () => router.push({ name: "", params: { }})

const store = useStore();
const woojooInfo = computed(() => store.getters.woojooInfo);
const position = ref(0)
const productId = route.params.productPk

onMounted(() => {
  store.dispatch("fetchWoojooInfo", productId)
  const mypageTabs = document.querySelector("#detail-container")
  window.onscroll = function() {scrollTabMenu()};
  function scrollTabMenu() {
    position.value = mypageTabs.getBoundingClientRect().top

    if (position.value <= 120) {
      // document.querySelector(".mypage-header .header-nick").style.top = "0"
      // document.querySelector(".mypage-header .header-nick").style.fontSize = "1.2rem"
      document.querySelector(".scroll-false").style.display = "none"
    } else {
      // document.querySelector(".mypage-header .header-nick").style.top = `${240 * ((position.value - 120) / 390)}px`
      // document.querySelector(".mypage-header .header-nick").style.fontSize = `${1.5 - 0.3 * (1- (position.value - 120) / 390)}rem`
      document.querySelector(".detail-header .bg-box").style.opacity = `${(position.value - 350) / 160}`
      // document.querySelector(".mypage-profile .profile-pic").style.opacity = `${(position.value - 350) / 160}`
      // document.querySelector(".mypage-profile .level").style.opacity = `${(position.value - 350) / 160}`
      // document.querySelector(".mypage-profile .email").style.opacity = `${(position.value - 350) / 160}`
      // document.querySelector(".mypage-profile .edit-profile").style.opacity = `${(position.value - 350) / 160}`
      document.querySelector(".scroll-false").style.display = "block"
    }
  }

})

function tabPosition(tabName) {
  if (window.innerWidth >= 500) {
    if (tabName == "detail-content") {
      document.querySelector(".tabs-container .tab-control").style.margin = "0 0 0 0"
      document.querySelector(".tabs-container .scroll-false").style.left = "0"
      document.querySelector(".tabs-now").style.left = "0"
    } else if (tabName == "mypage-likes") {
      document.querySelector(".tabs-container .tab-control").style.margin = "0 0 0 -500px"
      document.querySelector(".tabs-container .scroll-false").style.left = "-500px"
      document.querySelector(".tabs-now").style.left = "33%"
    } else if (tabName == "detail-reviews") {
      document.querySelector(".tabs-container .tab-control").style.margin = "0 0 0 -1000px"
      document.querySelector(".tabs-container .scroll-false").style.left = "-1000px"
      document.querySelector(".tabs-now").style.left = "66%"
    }
  } else {
    if (tabName == "detail-content") {
      document.querySelector(".tabs-container .tab-control").style.margin = "0 0 0 0"
      document.querySelector(".tabs-container .scroll-false").style.left = "0"
      document.querySelector(".tabs-now").style.left = "0"
    } else if (tabName == "mypage-likes") {
      document.querySelector(".tabs-container .tab-control").style.margin = "0 0 0 -100vw"
      document.querySelector(".tabs-container .scroll-false").style.left = "-100vw"
      document.querySelector(".tabs-now").style.left = "33%"
    } else if (tabName == "detail-reviews") {
      document.querySelector(".tabs-container .tab-control").style.margin = "0 0 0 -200vw"
      document.querySelector(".tabs-container .scroll-false").style.left = "-200vw"
      document.querySelector(".tabs-now").style.left = "66%"
    }
  }
}
</script>

<style>

</style>