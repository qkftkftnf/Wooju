<template>
  <div class="container">
    <div class="community-header">
      <div class="title">
        커뮤니티
      </div>
      <div class="header-content">
        <img class="content-img" src="@/assets/images/community.jpg" alt="communityMainPic">
        <p class="header-intro">더 많은 사람들과 더 많은 우주를 나눠보세요</p>
      </div>
    </div>
    
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
</template>

<script setup>
</script>

<style>
  
</style>