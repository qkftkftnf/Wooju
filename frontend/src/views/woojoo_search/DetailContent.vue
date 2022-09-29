<template>
  <div class="preferance-container mypage-inner add">
    <!-- <div class="type-main">
      <span class="name prefer-type">
        <span class="nick">닉네임스토리</span> 님은
      </span>
      <span class="person-type prefer-type">
        애호가
      </span>
      <span class="end prefer-type">
        형입니다.
      </span>
    </div>

    <div class="type-image">
      <img src="@/assets/images/soju.png" alt="like-soju">
    </div>
  
    <div class="preferance">
      <div class="abst">
        깔끔한 맛을 좋아하는 당신!
      </div>
      <div class="sweet flavor">
        단 맛을 <span class="highlight">싫어</span>하고,
      </div>
      <div class="acidity flavor">
        신 맛을 <span class="highlight">좋아</span>하고,
      </div>
      <div class="proof flavor">
        도수가 <span class="highlight">높은</span> 술을 좋아합니다.
      </div>
    </div> -->
  </div>
  <div class="detail-content">
    <div class="woojoo-text">
      "{{woojooInfo.object?.subtext}}"
    </div>
    <div>
      <img class="content-img" :src="woojooInfo.object?.image" alt="">
    </div>
    <div class="wooju">
      <span class="wooju-name">술 이름 : </span>
      {{woojooInfo.object?.name}}
    </div>
    <div class="degree">
      <span class="wooju-alcohol">도수 :  </span>
      <i class="alcohol"></i> {{woojooInfo.object?.alcohol}}%
    </div>
    <div class="rate">
      <span class="wooju-star">별점  </span>
      <i class="fas fa-star star"></i> {{woojooInfo.object?.star}}
    </div>
    <p class="detail-text">
      {{woojooInfo.object.award}}
    </p>
    <div class="title">
      어울리는 음식
    </div>
    <div class="fitfood-container">
      <div v-for="food in woojooInfo.object?.foods">
        <div class="fitfood-box">
          <div class="food-img">
            <img :src="food.img" alt="">
          </div>
          <div class="food-name">
            {{food.name}}
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useStore } from "vuex"; 
import { ref, computed, onMounted } from "vue";

const store = useStore();
const woojooInfo = computed(() => store.getters.woojooInfo);
</script>

<style>
.add {
  height: 0px !important;
}

.woojoo-text {
  text-align: center;
  font-size: 1.8rem;
  margin: 30px 0px 60px 0px;
}

.title {
  margin-top: 50px;
  margin-bottom: 50px;
  text-align: center;
}

.fitfood-container {
  display: flex;
  flex-flow: row;
}

.fitfood-box {
  width: 120px;
  margin: 0px;
}

.food-name {
  text-align: center;
}
.food-img {
  width: 100px;
}
</style>