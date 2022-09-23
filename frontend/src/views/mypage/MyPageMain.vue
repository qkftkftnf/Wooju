<template>
  <div class="tab-template profile-container">
    <div class="mypage-header">
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
    </div>
    
    
    <div class="mypage-container">
      <!-- tabs menu -->
      <div class="mypage-tabs">
        <div class="tabs-menu-container">
          <div class="tab tab-type" @click="tabPosition('mypage-type')">
            내 취향
          </div>
          <div class="tab tab-likes" @click="tabPosition('mypage-likes')">
            내 좋아요
          </div>
          <div class="tab tab-reviews" @click="tabPosition('mypage-reviews')">
            내 리뷰
          </div>
          <div class="tabs-now">
            <span class="under-bar"></span>
          </div>
        </div>
      </div>
      <div class="tabs-container">
        <div class="tab-control">
          <!-- tab1 -->
          <div class="tab-section mypage-type">
            <el-scrollbar>
              <MyPagePreference/>
            </el-scrollbar>
          </div>
          <!-- tab2 -->
          <div class="tab-section mypage-likes">
            <el-scrollbar>
              <MyPageLikes/>
            </el-scrollbar>
          </div>
          <!-- tab3 -->
          <div class="tab-section mypage-reviews">
            <el-scrollbar>
              <MyPageReviews/>
            </el-scrollbar>
          </div>
        </div>
        <div class="scroll-false"></div>
      </div>
    </div>

  </div>
</template>

<script setup>
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
    if (tabName == "mypage-type") {
      document.querySelector(".tabs-container .tab-control").style.margin = "0 0 0 0"
      document.querySelector(".tabs-container .scroll-false").style.left = "0"
      document.querySelector(".tabs-now").style.left = "0"
    } else if (tabName == "mypage-likes") {
      document.querySelector(".tabs-container .tab-control").style.margin = "0 0 0 -500px"
      document.querySelector(".tabs-container .scroll-false").style.left = "-500px"
      document.querySelector(".tabs-now").style.left = "33%"
    } else if (tabName == "mypage-reviews") {
      document.querySelector(".tabs-container .tab-control").style.margin = "0 0 0 -1000px"
      document.querySelector(".tabs-container .scroll-false").style.left = "-1000px"
      document.querySelector(".tabs-now").style.left = "66%"
    }
  } else {
    if (tabName == "mypage-type") {
      document.querySelector(".tabs-container .tab-control").style.margin = "0 0 0 0"
      document.querySelector(".tabs-container .scroll-false").style.left = "0"
      document.querySelector(".tabs-now").style.left = "0"
    } else if (tabName == "mypage-likes") {
      document.querySelector(".tabs-container .tab-control").style.margin = "0 0 0 -100vw"
      document.querySelector(".tabs-container .scroll-false").style.left = "-100vw"
      document.querySelector(".tabs-now").style.left = "33%"
    } else if (tabName == "mypage-reviews") {
      document.querySelector(".tabs-container .tab-control").style.margin = "0 0 0 -200vw"
      document.querySelector(".tabs-container .scroll-false").style.left = "-200vw"
      document.querySelector(".tabs-now").style.left = "66%"
    }
  }
}
</script>

<style>
  
</style>