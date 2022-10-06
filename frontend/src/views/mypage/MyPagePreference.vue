<template>
  <div class="preferance-container mypage-inner">
    <div class="type-main">
      <span class="name prefer-type">
        <span class="nick">{{ profileData.profile?.nickname }}</span> 님은
      </span>
      <span class="person-type prefer-type">
        애호가
      </span>
      <span class="type-end">
        형입니다.
      </span>
    </div>

    <div class="type-image">
      <img src="@/assets/images/type/lover.png" alt="like-soju">
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
    </div>
  </div>


  <div class="again-container rec-preferance">
    <div class="again-content">
      다시 취향을 알아보고 싶다면
      <div class="survey-btn" @click="linkTo('MyRecommendationType')">
        <div class="btn-box">취향 알아보러 가기 ></div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted ,computed } from "vue";
import { useStore } from "vuex";
import { useRouter } from "vue-router";

const router = useRouter();
const linkTo = (name) => router.push({ name: name })

const store = useStore();
const profileData = computed(() => store.getters.profile)

</script>

<style>
  
</style>