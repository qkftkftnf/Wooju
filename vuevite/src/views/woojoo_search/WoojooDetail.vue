<template>
  <div class="tab-template detail-header-container">
    <!-- <div class="mypage-header">
      <div class="header-nick">
        닉네임스토리
      </div>
      <div class="mode-toggle">
        <ModeToggle/>
      </div>
    </div>
    <div class="mypage-profile">
      <div class="bg-box"></div>
      <div class="profile-pic" style="background-image: url('https://www.sciencetimes.co.kr/wp-content/uploads/2022/06/%EB%B3%B4%EB%9E%8F%EB%B9%9B1.jpg')"></div>
      <div class="level">
        lv.8
      </div>
      <div class="email">
        hey@gmail.com
      </div>
      <div class="edit-profile">
        <i class="fas fa-cog"></i>
      </div>
    </div> -->
    <HeaderView/>
    <div class="detail-header-container">
      <div class="woojoo-pic">
        <img class="image" src="@/assets/images/woojoo1.jpg" alt="">
      </div>
      <!-- <div class="detail-content">
        <div class="wooju">
          <span class="wooju-name">술 이름 : </span>
          만강에 비친 달 
        </div>
        <div class="degree">
          <span class="wooju-alcohol">도수 :  </span>
          <i class="alcohol"></i> 17%
        </div>
        <div class="rate">
          <span class="wooju-star">별점  </span>
          <i class="fas fa-star star"></i> 4.5
        </div>
        <p class="detail-text">
          수상내역 등등
        </p>
      </div> -->
    </div>
    <div class="mypage-container">
      <!-- tabs menu -->
      <div class="mypage-tabs">
        <div class="tabs-menu-container">
          <div class="tab tab-type" @click="tabPosition('detail-content')">
            상세정보
          </div>
          <div class="tab tab-likes" @click="tabPosition('mypage-likes')">
            ????
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
import ModeToggle from "@/views/common/ModeToggle.vue"
import MyPagePreference from "@/views/mypage/MyPagePreference.vue"
import MyPageLikes from "@/views/mypage/MyPageLikes.vue"
import MyPageReviews from "@/views/mypage/MyPageReviews.vue"
import { ref, onMounted } from "vue";

const position = ref(0)

onMounted(() => {
  const mypageTabs = document.querySelector(".mypage-container")
  window.onscroll = function() {scrollTabMenu()};
  position.value = mypageTabs.getBoundingClientRect().top
  
  function scrollTabMenu() {

    if (position.value <= 120) {
      document.querySelector(".mypage-header .header-nick").style.top = "0"
      document.querySelector(".mypage-header .header-nick").style.fontSize = "1.2rem"
      document.querySelector(".scroll-false").style.display = "none"
    } else {
      document.querySelector(".mypage-header .header-nick").style.top = `${240 * ((position.value - 120) / 390)}px`
      document.querySelector(".mypage-header .header-nick").style.fontSize = `${1.5 - 0.3 * (1- (position.value - 120) / 390)}rem`
      document.querySelector(".mypage-profile .bg-box").style.opacity = `${(position.value - 350) / 160}`
      document.querySelector(".mypage-profile .profile-pic").style.opacity = `${(position.value - 350) / 160}`
      document.querySelector(".mypage-profile .level").style.opacity = `${(position.value - 350) / 160}`
      document.querySelector(".mypage-profile .email").style.opacity = `${(position.value - 350) / 160}`
      document.querySelector(".mypage-profile .edit-profile").style.opacity = `${(position.value - 350) / 160}`
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