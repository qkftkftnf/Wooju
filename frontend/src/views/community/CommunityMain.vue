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
      <div class="inner-section">
        <!-- 본문 입력 -->
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
                <div class="review-card" v-for="i in 4" @click="linkTo">
                  <div class="image">
                    <img src="@/assets/images/pic3.jpg" alt="reviewPic">
                    <span class="like">
                      <i class="fas fa-heart heart"></i> 73
                    </span>
                  </div>
                  <div class="card-content">
                    <div class="wooju">
                      만강에 비친 달
                    </div>
                    <div class="rate">
                      <i class="fas fa-star star"></i> 4.5
                    </div>
                    <div class="preview">
                      님들 이거 진짜 개맛있어요 저번에 시음회에서 먹었었는데 처음 맛보는 술이었음
                    </div>
                  </div>
                </div>
                <div class="more-card review-card bs-none">
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
  </div>
</template>

<script setup>
import ModeToggle from "@/views/common/ModeToggle.vue"
import { ref, onMounted } from "vue";
import { useRouter } from "vue-router";

const router = useRouter();
const linkTo = () => router.push({ name: "CommunityHotReview",  params: { reportPk: 1 } })

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