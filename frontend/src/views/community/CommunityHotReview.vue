<template>
  <div class="container">
    <HeaderView/>
    <h1 class="hot-review-title">모든 핫 리뷰</h1>
      <div class="review-body" v-for="item in 2" :key="item">
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
            <el-carousel trigger="click" height="250px" indicator-position="outside" autoplay="false">
              <el-carousel-item v-for="item in 4" :key="item">
                <h3 class="small justify-center" text="2xl">{{ item }}</h3>
              </el-carousel-item>
            </el-carousel>
          </div>          
          <div class="review-content">
            <div class="wooju">
              만강에 비친 달
            </div>
            <div class="rate">
              <i class="fas fa-star star"></i> 4.5
            </div>
            <p class="review-text">
            Lorem ipsum dolor sit, amet consectetur adipisicing elit. Excepturi modi reiciendis aspernatur similique, officiis sit tenetur mollitia eius qui fugit?
            </p>
          </div>
      </div>
    <img src="@/assets/images/pic2.jpg"/>
    <p>
      Lorem ipsum dolor, sit amet consectetur adipisicing elit. Blanditiis unde nulla cum voluptatum nemo praesentium dolor facilis harum labore illum, neque sint tempora in. Corrupti vel fuga amet illo provident!
    </p>
    <img src="@/assets/images/pic1.jpg"/>
    <p>
      Lorem ipsum dolor sit amet consectetur adipisicing elit. Hic, delectus?
    </p>
    <img src="@/assets/images/pic3.jpg"/>
    <p>
      Lorem ipsum dolor sit amet consectetur adipisicing elit. Eveniet tenetur commodi obcaecati nulla adipisci repellendus ipsum possimus reprehenderit dolore omnis voluptatem eaque dolorum officia consequatur, quos quasi recusandae tempora amet, placeat aliquam voluptates laboriosam cumque sapiente minima! Velit, officiis vero.
    </p>
    <img src="@/assets/images/pic2.jpg"/>
    <p>
      Lorem ipsum dolor sit, amet consectetur adipisicing elit. Excepturi modi reiciendis aspernatur similique, officiis sit tenetur mollitia eius qui fugit?
    </p>

    

  </div>
</template>

<script setup>

import HeaderView from "@/views/common/HeaderView.vue"
</script>

<style>

</style>
