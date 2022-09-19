<template>
  <div class="container">
    <div class="inner-header">
      <div class="title">
        커뮤니티
      </div>
      <div class="header-content">
        <img class="content-img" src="@/assets/images/community.jpg" alt="communityMainPic">
        <p class="header-intro">더 많은 사람들과 더 많은 우주를 나눠보세요</p>
      </div>
    </div>
    
    <div class="inner-container">
      <div class="upper-rounding"></div>
      <div class="community-category" v-for="i in 4">
        <div class="category-header">
          <div class="category-title">
            핫 리뷰
          </div>
          <div class="more"> 
            <!-- linkTo -->
            더보기 <i class="fas fa-chevron-right"></i>
          </div>
        </div>
        <div class="category-intro">
          지금 하트를 많이 받은 리뷰를 만나보세요
        </div>
        <div class="category-carousel">
          <el-scrollbar>
            <div class="carousel-container">
              <div class="review-card" v-for="i in 4">
                <div class="image">
                  <img src="@/assets/images/pic3.jpg" alt="reviewPic">
                  <span class="like">
                    <i class="fas fa-heart icon"></i> 73
                  </span>
                </div>
                <div class="review-content">
                  <div class="wooju">
                    만강에 비친 달
                  </div>
                  <div class="rate">
                    <i class="fas fa-star star"></i> 4.5
                  </div>
                  <div class="preview">
                    님들 이거 진짜 개맛있어요미침
                  </div>
                </div>
              </div>
              <div class="more-card review-card">
                <div class="more-btn">
                  <span>
                    더보기 <i class="fas fa-arrow-right"></i>
                  </span>
                </div>
              </div>
            </div>
          </el-scrollbar>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";

const position = ref(0)

onMounted(() => {
  const innerContainer = document.getElementsByClassName("inner-container")
  window.onscroll = function() {scrollInnerHeader()};
  
  function scrollInnerHeader() {
    position.value = innerContainer[0].getBoundingClientRect()

    if (position.value.top < 60) {
      document.querySelector(".inner-header").style.height = "60px";
      document.querySelector(".inner-header .title").style.padding = "0 0 0 30px";
    } else {
      document.querySelector(".inner-header").style.height = `${position.value.top}px`;
      document.querySelector(".inner-header .title").style.padding = `${50 * (position.value.top / 390)}px 0 ${50 * (position.value.top / 390)}px 30px`;
      document.querySelector(".inner-header .title").style.fontSize = `${1.2 + (position.value.top - 60) /  390}rem`;
      document.querySelector(".header-content .content-img").style.opacity = `${((position.value.top - 260) / 250 )}`;
      document.querySelector(".header-content .content-img").style.scale = `${((position.value.top - 60) /  390)}`;
      document.querySelector(".header-content .header-intro").style.opacity = `${((position.value.top - 260) / 190 )}`;
      
    }
  }
})  


  
</script>

<style>
  
</style>