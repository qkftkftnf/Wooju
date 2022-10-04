<template>
  <div class="tab-template container">
    <div class="tab-header">
      <div class="mainhome-logo">
        <img src="@/assets/images/logo.png" alt="homelogo">
      </div>
      <div class="mode-toggle">
        <ModeToggle/>
      </div>
    </div>
    <div class="header-content">
      <p class="home-intro">당신의 우주에 전통주를 채워보세요</p>
    </div>
    
    <div class="inner-container mainhome-container">
      <div class="rec-container inner-section">
        <div class="mt"></div>
        <div class="home-corner recommendation-corner">

          <div class="community-category">
            <div class="category-header">
              <div class="category-title">
                오늘의 추천
              </div>
              <div class="more"> 
                <!-- linkTo -->
                더보기 <i class="fas fa-chevron-right"></i>
              </div>
            </div>
            <div class="category-intro">
              오늘밤 취향 가득한 전통주 어떤가요?
            </div>
            <div class="category-carousel">
              <el-scrollbar>
                <div class="carousel-container">
                  <div class="review-card" v-for="idx in 3">
                    <div @click="linkToCommunity('hotreview', idx + 1)">
                      <div class="image main-review-img">
                        <img src="@/assets/images/profile_img_1.jpg" alt="reviewThumbnail">
                        <span class="like">
                          <i class="fas fa-heart heart"></i> review.like
                        </span>
                      </div>
                      <div class="card-content">
                        <div class="wooju">
                          review.product_name
                        </div>
                        <div class="rate">
                          <i class="fas fa-star star"></i> review.star
                        </div>
                        <div class="preview">
                          review.content
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="more-card review-card bs-none" @click="linkToCommunity('hotreview', 0)">
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

        <div class="home-corner search-corner">

          <div class="community-category">
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
              지금 마시고 싶은 전통주를 찾고 있다면?
            </div>
            <div class="category-carousel">
              <el-scrollbar>
                <div class="carousel-container">
                  <div class="review-card" v-for="idx in 3">
                    <div @click="linkToCommunity('hotreview', idx + 1)">
                      <div class="image main-review-img">
                        <img src="@/assets/images/profile_img_1.jpg" alt="reviewThumbnail">
                        <span class="like">
                          <i class="fas fa-heart heart"></i> review.like
                        </span>
                      </div>
                      <div class="card-content">
                        <div class="wooju">
                          review.product_name
                        </div>
                        <div class="rate">
                          <i class="fas fa-star star"></i> review.star
                        </div>
                        <div class="preview">
                          review.content
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="more-card review-card bs-none" @click="linkToCommunity('hotreview', 0)">
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

  </div>
  <MenuView menuTab="main-home-menu"/>
</template>

<script setup>
import ModeToggle from "@/views/common/ModeToggle.vue"
import MenuView from "@/views/common/MenuView.vue"
import { ref, computed, onMounted } from "vue";
import { useRouter } from "vue-router";
import { useStore } from "vuex";

const router = useRouter();
const linkTo = (name) => router.push({ name: name })
const linkToCommunity = (category, post) => router.push({ name: "CommunityCategory", query: { name: category, post: post }})

// vuex axios
const store = useStore();
const reviewsData = computed(() => store.getters.reviews);

onMounted(() => {
  store.dispatch("fetchAllReviews")
})


// header scroll event js
const position = ref(0)

onMounted(() => {
  const innerContainer = document.getElementsByClassName("inner-container")
  window.onscroll = function() {scrollInnerHeader()};

  function scrollInnerHeader() {
    position.value = innerContainer[0].getBoundingClientRect()

    if (position.value.top < 60) {
      document.querySelector(".tab-header .mainhome-logo").style.top = "0";
      document.querySelector(".tab-header .mainhome-logo img").style.width = "150px";
      document.querySelector(".tab-header").style.boxShadow = "0px 4px 6px 6px rgba(0, 0, 0, 0.05)";
    } else {
      document.querySelector(".tab-header").style.boxShadow = "0px 4px 6px 6px rgba(0, 0, 0, 0.0)";
      document.querySelector(".tab-header .mainhome-logo").style.top = `${150 * ((position.value.top - 60) / 390)}px`;
      document.querySelector(".tab-header .mainhome-logo img").style.width = `${150 + 100 * ((position.value.top - 60) / 390)}px`;
      document.querySelector(".header-content .home-intro").style.opacity = `${((position.value.top - 260) / 190 )}`;
      document.querySelector(".header-content .home-intro").style.top = `${35 + 30 * ((position.value.top - 260) / 190 )}%`;
    }
  }
})

</script>

<style>
.mt {
  width: 100%;
  max-width: 500px;
  height: 60px;
  background-color: transparent;
}

.main-review-img img {
  object-fit: contain !important;
  object-position: center;

}

.togo-btn span {
  font-weight: 400;
  font-size: 1rem;
}

</style>