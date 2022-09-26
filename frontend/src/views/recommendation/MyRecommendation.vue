<template>
  <div class="tab-template container">
    <div class="tab-header">
      <div class="tab-title">
        오늘의 추천
      </div>
      <div class="mode-toggle">
        <ModeToggle/>
      </div>
    </div>
    <div class="header-content">
      <img class="content-img" src="@/assets/images/community.jpg" alt="communityMainPic">
      <p class="header-intro">당신이 오늘 좋아할 만한 우주를 소개해드려요</p>
    </div>
    
    <div class="inner-container">
      <div class="rec-container inner-section">
        
        <!-- preferance -->
        <div class="rec-type rec-preferance">
          <div class="title">
            ㅇㅇ 님의 취향에 딱 맞는 술
          </div>
          <div class="bottles">
            <div class="bottle-card" v-for="i in 3">
              <div class="bottle-img">
                <img src="@/assets/images/woojoo1.jpg" alt="bottle">
              </div>
              <div class="bottle-title">
                술 이름
              </div>
              <div class="bottle-content">
                14.5% | 375ml
              </div>
            </div>
          </div>
        </div>

        <!-- life style -->


        <!-- award -->
      </div>
    </div>
  </div>
</template>

<script setup>
import ModeToggle from "@/views/common/ModeToggle.vue"
import { ref, computed, onMounted } from "vue";
import { useRouter } from "vue-router";
import { useStore } from "vuex";

const router = useRouter();
const linkTo = () => router.push({ name: "CommunityHotReview",  params: { reportPk: 1 } })

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
      document.querySelector(".tab-header .tab-title").style.top = "0";
      document.querySelector(".tab-header").style.boxShadow = "0px 4px 6px 6px rgba(0, 0, 0, 0.05)";
    } else {
      document.querySelector(".tab-header").style.boxShadow = "0px 4px 6px 6px rgba(0, 0, 0, 0.0)";
      document.querySelector(".tab-header .tab-title").style.top = `${50 * (position.value.top / 450)}px`;
      document.querySelector(".tab-header .tab-title").style.fontSize = `${1.2 + position.value.top / 450}rem`;
      document.querySelector(".header-content .content-img").style.opacity = `${((position.value.top - 260) / 250 )}`;
      document.querySelector(".header-content .content-img").style.scale = `${((position.value.top - 60) /  390)}`;
      document.querySelector(".header-content .header-intro").style.opacity = `${((position.value.top - 260) / 190 )}`;
    }
  }
})

</script>

<style>
  
</style>