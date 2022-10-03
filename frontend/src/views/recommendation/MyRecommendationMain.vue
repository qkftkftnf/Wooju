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
    
    <div class="inner-container" v-if="member">
      <div class="rec-container inner-section">
        <div class="mt"></div>
        <!-- preferance -->
        <div class="rec-type rec-preferance">
          <div class="title">
            당신의 취향에 딱 맞는 술
          </div>

          <!-- v-if not surveyed -->
          <div class="not-surveyed" v-if="!preference">
            <div class="not-surveyed-content">
              아직 취향 조사를 하지 않으셨어요! <br/> 당신의 우주를 같이 알아볼까요?
            </div>
            <div class="survey-btn" @click="linkTo('MyRecommendationType')">
              <div class="btn-box">취향 알아보러 가기 ></div>
            </div>
          </div>

          <!-- v-if surveyed -->
          <div class="bottles" v-if="preference">
            <div class="bottle-card" v-for="i in 3">
              <div class="bottle-img">
                <img src="@/assets/images/woojoo1.jpg" alt="bottle">
              </div>
              <div class="bottle-content">
                <div class="bottle-title">
                  술 이름이 길어요
                </div>
                <div class="bottle-intro">
                  14.5% | 375ml
                </div>
              </div>
            </div>
          </div>
        </div>

        <!-- life style -->
        <div class="rec-type rec-preferance">
          <div class="title">
            당신의 오늘에 딱 맞는 술
          </div>

          <!-- v-if not surveyed -->
          <div class="not-surveyed" v-if="!lifestyle">
            <div class="not-surveyed-content">
              당신의 라이프 스타일을 알려주세요! <br/> 우주가 추천해드릴게요.
            </div>
            <div class="survey-btn life-style-btn" @click="linkTo('MyRecommendationType')">
              <div class="btn-box">오늘의 라이프 스타일은? ></div>
            </div>
          </div>

         <!-- v-if surveyed -->
          <div class="bottles" v-if="lifestyle">
            <div class="bottle-card" v-for="i in 3">
              <div class="bottle-img">
                <img src="@/assets/images/woojoo1.jpg" alt="bottle">
              </div>
              <div class="bottle-content">
                <div class="bottle-title">
                  술 이름
                </div>
                <div class="bottle-intro">
                  14.5% | 375ml
                </div>
              </div>
            </div>
          </div>
        </div>

        <!-- award -->
        <div class="rec-type rec-preferance">
          <div class="title award-title">
            아직 전통주에 대해 잘 모르겠다면,<br/>모두의 인정을 받은 술들은 어떤가요?
          </div>
          <div class="bottles">
            <div class="bottle-card">
              <div class="bottle-img">
                <img src="https://thesool.com/common/imageView.do?targetId=PR00000330&targetNm=PRODUCT" alt="bottle">
              </div>
              <div class="bottle-content">
                <div class="bottle-title">
                  감사
                </div>
                <div class="bottle-intro">
                  14% | 375ml
                </div>
              </div>
            </div>
            <div class="bottle-card">
              <div class="bottle-img fake">
                <img src="https://thesool.com/common/imageView.do?targetId=PR00000112&targetNm=PRODUCT" alt="bottle">
              </div>
              <div class="bottle-content">
                <div class="bottle-title">
                  담은
                </div>
                <div class="bottle-intro">
                  6.5% | 750ml
                </div>
              </div>
            </div>
  
            <div class="bottle-card">
              <div class="bottle-img fake2">
                <img src="https://thesool.com/common/imageView.do?targetId=PR00000568&targetNm=PRODUCT" alt="bottle">
              </div>
              <div class="bottle-content">
                <div class="bottle-title">
                  두레앙22
                </div>
                <div class="bottle-intro">
                  22% | 375ml
                </div>
              </div>
            </div>
          </div>


        </div>

      </div>
    </div>



    <div class="inner-container" v-if="!member">
      <div class="rec-container inner-section">
        <div class="mt"></div>

        <div class="recommend-content">
          여러분
        </div>
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
const linkTo = (name) => router.push({ name: name })

// vuex axios
const store = useStore();
const reviewsData = computed(() => store.getters.reviews);

onMounted(() => {
  store.dispatch("fetchAllReviews")
})


// whether member
const member = ref(true)

// whether surveyed
const preference = ref(false)
const lifestyle = ref(false)


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
.mt {
  width: 100%;
  max-width: 500px;
  height: 60px;
  background-color: transparent;
}

.fake img {
width: 50% !important;
}

.fake2 img {
  width: 100% !important;
}
</style>