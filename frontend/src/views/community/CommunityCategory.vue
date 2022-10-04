<template>
  <div class="container pt-60">
    <!-- {{ reviewsData.review[firstPost]?.img }} -->
    <HeaderView/>
    <div class="review-body first-review" v-if="!showAll">
      <div class="review-header">
        <div class="profile">
          <div class="profile-box">
            <img class="profile-img" src="@/assets/images/profile_img_1.jpg" alt="">
          </div>
          <div class="review-writer">
            <div class="review-nickname">{{ reviewsData.review[firstPost]?.user_nickname }}</div>
            <div class="review-level">레벨 153</div>
          </div>
        </div>
        <span class="review-date">{{ reviewsData.review[firstPost]?.time }}</span> 
      </div>
      <div class="image-carousel">
        <el-carousel trigger=click :autoplay="false" arrow="always">
          <el-carousel-item v-for="image in reviewsData.review[firstPost]?.img">
            <img :src="image" alt="pic">
          </el-carousel-item>
        </el-carousel>
      </div>
      <div class="review-content">
        <div class="wooju">
          <span class="wooju-name">술 이름 : </span>
          {{ reviewsData.review[firstPost]?.product_name }}
          <i class="fas fa-chevron-right"></i>
        </div>
        <div class="rate">
          <span class="wooju-star">별점  </span>
          <i class="fas fa-star star"></i> {{ reviewsData.review[firstPost]?.star }}
        </div>
        <p class="review-text">
          {{ reviewsData.review[firstPost]?.content }}
        </p>
      </div>
    </div>


    <h1 class="hot-review-title">모든 {{ title }}</h1>
    <div v-for="review, idx in reviewsData.review">
      <div class="review-body" v-if="firstPost != idx">
        <div class="review-header">
          <div class="profile">
            <div class="profile-box">
              <img class="profile-img" src="@/assets/images/profile_img_1.jpg" alt="">
            </div>
            <div class="review-writer">
              <div class="review-nickname">{{ review.user_nickname }}</div>
              <div class="review-level">레벨 153</div>
            </div>
          </div>
          <span class="review-date">{{ review.time }}</span> 
        </div>
        <div class="image-carousel">
          <el-carousel trigger=click :autoplay="false" arrow="always">
            <el-carousel-item v-for="image in review.img">
              <img :src="image" alt="pic">
            </el-carousel-item>
          </el-carousel>
        </div>
        <div class="review-content">
          <div class="wooju">
            <span class="wooju-name">술 이름 : </span>
            {{ review.product_name }} 
            <i class="fas fa-chevron-right"></i>
          </div>
          <div class="rate">
            <span class="wooju-star">별점  </span>
            <i class="fas fa-star star"></i> {{ review.star }}
          </div>
          <p class="review-text">
            {{ review.content }}
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import HeaderView from "@/views/common/HeaderView.vue"
import { ref, computed, onMounted } from "vue";
import { useRoute } from 'vue-router'
import { useStore } from "vuex";

const store = useStore();
const route = useRoute()
const titles = {
  hotreview: "핫 리뷰",
  Hotproductsreview: "핫한 술 리뷰",
  gosureview: "맛 고수 리뷰",
  recentreview: "최신 리뷰",
}

const firstReview = ref({
  user_nickname: "",
  time: "",
  image: [],
  product_name: "",
  star: 0,
  content: "",
})

onMounted (() => {
  store.dispatch("fetchReviews", route.query.name)


})

const reviewsData = computed(() => store.getters.reviews)

const title = titles[route.query.category]
const showAll = ref(false)
const firstPost = ref(0)
if (route.query.post == 0) {
  showAll.value = true
} else {
  firstPost.value = route.query.post - 1
}

</script>

<style>

</style>
