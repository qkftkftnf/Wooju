<template>
  <div class="tap-template container">
    <div class="tap-header">
      <div class="tap-title">
        커뮤니티
      </div>
      <div class="mode-toggle">
        <ModeToggle/>
      </div>
    </div>
    <div class="header-content">
      <img class="content-img" src="@/assets/images/community.jpg" alt="communityMainPic">
      <p class="header-intro">더 많은 사람들과 더 많은 우주를 나눠보세요</p>
    </div>
    
    <div class="inner-container">
      <!-- <div class="upper-rounding"></div> -->
      <div class="inner-section">
        <!-- 본문 입력 -->
        <CommunityMain/>
      </div>
    </div>
  </div>
</template>

<script setup>
import ModeToggle from "@/views/common/ModeToggle.vue"
import CommunityMain from "@/views/community/CommunityMain.vue"
import { ref, onMounted } from "vue";

const position = ref(0)

onMounted(() => {
  const innerContainer = document.getElementsByClassName("inner-container")
  window.onscroll = function() {scrollInnerHeader()};
  
  function scrollInnerHeader() {
    position.value = innerContainer[0].getBoundingClientRect()

    if (position.value.top < 60) {
      document.querySelector(".tap-header .tap-title").style.top = "0";
      document.querySelector(".tap-header").style.boxShadow = "0px 4px 6px 6px rgba(0, 0, 0, 0.05)";
    } else {
      document.querySelector(".tap-header").style.boxShadow = "0px 4px 6px 6px rgba(0, 0, 0, 0.0)";
      document.querySelector(".tap-header .tap-title").style.top = `${50 * (position.value.top / 450)}px`;
      document.querySelector(".tap-header .tap-title").style.fontSize = `${1.2 + position.value.top / 450}rem`;
      document.querySelector(".header-content .content-img").style.opacity = `${((position.value.top - 260) / 250 )}`;
      document.querySelector(".header-content .content-img").style.scale = `${((position.value.top - 60) /  390)}`;
      document.querySelector(".header-content .header-intro").style.opacity = `${((position.value.top - 260) / 190 )}`;
      
    }
  }
})  


  
</script>

<style>
  
</style>