<template>
  <!-- <span>{{woojooInfo.list}}</span> -->
  <div class="button-container">
    <button class="review-button" @click="goToReviewCreate(woojooInfo.object.id)">
      리뷰 작성하기
    </button>
  </div>
    <div class="review-body bs-card-03" v-for="review in woojooInfo.list">
          <div class="review-header">
            <div class="profile">
              <div class="profile-box">
                <img class="profile-img" :src="review.user_img" alt="">
              </div>
              <div class="review-writer">
                <div class="review-nickname">{{review.nickname}}</div>
                <!-- <div class="review-level">레벨 153</div> -->
              </div>
            </div>
            <span class="review-date">{{review.time}}</span> 
          </div>
          <!-- <img src="@/assets/images/pic3.jpg"/> -->
          <div class="block text-center" m="t-4">
            <el-carousel trigger="click" height="250px" indicator-position="outside" :autoplay="false">
              <el-carousel-item v-for="review_pic in review.img" :key="i">
                <!-- <h3 class="small justify-center" text="2xl">{{ item }}</h3> -->
                <!-- <img :src="`@/assets/images/pic${i}.jpg`" alt=""> -->
                <img :src="review_pic" alt="">
              </el-carousel-item>
              <span class="like">
                <i class="fas fa-heart icon"></i> {{review.like}}
              </span>              
            </el-carousel>
          </div>          
          <div class="review-content">
            <!-- <div class="wooju">
              <span class="wooju-name"> 제목 : </span>
              {{review}}
            </div> -->
            <div class="rate">
              <span class="wooju-star">별점  </span>
              <i class="fas fa-star star"></i> {{review.star}}
            </div>
            <p class="review-text">
              {{review.content}}
            </p>
          </div>
      </div>
</template>
<script setup>
import { computed } from "vue";
import { useRouter } from "vue-router";
import { useStore } from "vuex";

const router = useRouter();
// // const linkTo = () => router.push({ name: "", params: { }})
const store = useStore();
const woojooInfo = computed(() => store.getters.woojooInfo);
// const reviewId = woojooInfo.object

const goToReviewCreate = (productId) => {
  router.push({name: 'WoojooReviewCreate', params:{'productPk': productId}}, )
}
// onMounted(() => {
//   store.dispatch("fetchWoojooReviews")
// })
</script>
<style>
.button-container {
  
}

.review-button {
  /* font-size: 0.9em; */
  width: 80%;
  margin-top: 30px;
  border: 0ch;
  border-radius: 25px;
}
</style>