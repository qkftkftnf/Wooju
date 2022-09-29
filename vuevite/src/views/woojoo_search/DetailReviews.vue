<template>
    <div class="review-body bs-card-03" v-for="item in 3" :key="item">
          <div class="review-header">
            <div class="profile">
              <div class="profile-box">
                <img class="profile-img" src="@/assets/images/profile_img_1.jpg" alt="">
              </div>
              <div class="review-writer">
                <div class="review-nickname">hanssss</div>
                <div class="review-level">레벨 153</div>
              </div>
            </div>
            <span class="review-date">2022.09.16</span> 
          </div>
          <!-- <img src="@/assets/images/pic3.jpg"/> -->
          <div class="block text-center" m="t-4">
            <el-carousel trigger="click" height="250px" indicator-position="outside" :autoplay="false">
              <el-carousel-item v-for="i in 4" :key="i">
                <!-- <h3 class="small justify-center" text="2xl">{{ item }}</h3> -->
                <!-- <img :src="`@/assets/images/pic${i}.jpg`" alt=""> -->
                <img src="@/assets/images/pic1.jpg" alt="pic">
              </el-carousel-item>
              <span class="like">
                <i class="fas fa-heart icon"></i> 73
              </span>              
            </el-carousel>
          </div>          
          <div class="review-content">
            <div class="wooju">
              <span class="wooju-name">술 이름 : </span>
              만강에 비친 달 
              <i class="fas fa-chevron-right"></i>
            </div>
            <div class="rate">
              <span class="wooju-star">별점  </span>
              <i class="fas fa-star star"></i> 4.5
            </div>
            <p class="review-text">
            Lorem ipsum dolor sit, amet consectetur adipisicing elit. Excepturi modi reiciendis aspernatur similique, officiis sit tenetur mollitia eius qui fugit?
            </p>
          </div>
      </div>
</template>
<script setup>
import { ref, computed, onMounted } from "vue";
import { useRouter } from "vue-router";
import { useStore } from "vuex";

const router = useRouter();
// const linkTo = () => router.push({ name: "", params: { }})

const store = useStore();
const woojooReviews = computed(() => store.getters.woojooReviews);

onMounted(() => {
  store.dispatch("fetchWoojooReviews")
})
</script>
<style>
    
</style>