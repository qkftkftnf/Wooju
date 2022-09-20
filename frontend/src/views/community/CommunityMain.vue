<template>
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
          <div class="review-card bs-card-03" v-for="i in 4" @click="linkTo">
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
</template>

<script setup>
import { useRouter } from "vue-router";

const router = useRouter();

const linkTo = () => router.push({ name: "CommunityHotReview",  params: { reportPk: 1 } })
</script>

<style>
  
</style>