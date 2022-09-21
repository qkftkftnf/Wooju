<template>
  <div class="likes-container">
    <div class="like-wooju" v-for="i in 8">
      <div class="wooju-img">
        <img src="https://thesool.com/common/imageView.do?targetId=PR00000106&targetNm=PRODUCT" alt="">
      </div>
      <div class="introduction">
        <div class="title">
          만강에 비친 달
        </div>
        <div class="content">
          <span class="proof">17%</span> | <span class="bottle">375ml</span>
        </div>
        <div class="likes">
            <span class="star" v-for="i in 4">
              <i class="fas fa-star star-icon"></i>
            </span>
            <span class="half"><i class="far fa-star star-icon"></i></span>
            <span> | </span>
            <span class="heart">
              <i class="fas fa-heart heart-icon"></i>
            </span>
            <span class="count">74</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>

</script>

<style>
  
</style>