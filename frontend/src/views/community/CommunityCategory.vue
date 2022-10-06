<template>
  <div class="container pt-60" v-if="isCommunityLoaded">
    <HeaderView/>
    <div class="review-body first-review" v-if="!showAll">
      <div class="review-header">
        <div class="profile">
          <div class="profile-box">
            <img class="profile-img" :src="reviewsData.review[firstPost]?.user_img" alt="">
          </div>
          <div class="review-writer">
            <div class="review-nickname">{{ reviewsData.review[firstPost]?.user_nickname }}</div>
          </div>
        </div>
        <span class="review-date">{{ reviewsData.review[firstPost]?.time }}</span> 
      </div>
      <div class="image-carousel">
        <el-carousel trigger=click :autoplay="false" arrow="always">
          <el-carousel-item v-for="image in reviewsData.review[firstPost]?.img">
            <img :src="image" alt="pic" class="review-detail-img">
          </el-carousel-item>
          <span class="like">
            <i class="fas fa-heart icon" @click="likeReview(reviewsData.review[firstPost].id)"></i> {{reviewsData.review[firstPost].like}}
          </span>           
        </el-carousel>
      </div>
      <div class="review-content">
        <div class="wooju" @click="linkToProduct(reviewsData.review[firstPost].product_id)">
          <span class="wooju-name">술 이름 : </span>
          {{ reviewsData.review[firstPost]?.product_name }} >
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
              <img class="profile-img" :src="review.user_img" alt="">
            </div>
            <div class="review-writer">
              <div class="review-nickname">{{ review.user_nickname }}</div>
            </div>
          </div>
          <span class="review-date">{{ review.time }}</span> 
        </div>
        <div class="image-carousel">
          <el-carousel trigger=click :autoplay="false" arrow="always">
            <el-carousel-item v-for="image in review.img">
              <img :src="image" alt="pic" class="review-detail-img">
            </el-carousel-item>
            <span class="like">
              <i class="fas fa-heart icon" @click="likeReview(review.id)"></i> {{review.like}}
            </span>   
          </el-carousel>
        </div>
        <div class="review-content">
          <div class="wooju" @click="linkToProduct(review.product_id)">
            <span class="wooju-name">술 이름 : </span>
            {{ reviewsData.review[firstPost]?.product_name }} >
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
import { useRouter, useRoute } from "vue-router";
import { useStore } from "vuex";

const store = useStore();
const route = useRoute()
const router = useRouter();
const linkToProduct = (productPk) => router.push({ name: "WoojooDetail", params: { productPk: productPk }})

const titles = {
  hotreview: "핫 리뷰",
  Hotproductsreview: "핫한 술 리뷰",
  gosureview: "맛 고수 리뷰",
  recentreview: "최신 리뷰",
}

const reviewsData = computed(() => store.getters.reviews)
const isCommunityLoaded = computed(() => store.getters.isCommunityLoaded)

onMounted(() => {
  store.commit("SET_IS_COMMUNITY_LOADED", false)
  store.dispatch("fetchReviews", route.query.name)
  console.log(reviewsData)
})


const title = titles[route.query.name]
const showAll = ref(false)
const firstPost = ref(0)
if (route.query.post == 0) {
  showAll.value = true
} else {
  firstPost.value = route.query.post - 1
}

const isLikeReview = computed(() => store.getters.isLikeReview);

function likeReview(reviewId) {
  console.log(store.getters.isLikeReview)
  store.dispatch('likeCheckReview', reviewId)
  if (store.getters.isLikeReview === false) {
    console.log('좋아요 누름')
    store.dispatch('likeReview', reviewId)
    // router.go()
  } else if (store.getters.isLikeReview === true) {
    console.log('싫어요')
    store.dispatch('unlikeReview', reviewId)
    // router.go()
  }
}

</script>

<style>

</style>
