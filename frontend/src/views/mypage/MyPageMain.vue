<template>
  <div class="tab-template container">
    <div class="mypage-header">
      <div class="header-nick">
        공사중입니다
      </div>
      <div class="mode-toggle">
        <ModeToggle/>
      </div>
    </div>
    <div class="mypage-profile">
      <div class="bg-box"></div>
      <div class="profile-pic" style="background-image: url('https://www.sciencetimes.co.kr/wp-content/uploads/2022/06/%EB%B3%B4%EB%9E%8F%EB%B9%9B1.jpg')"></div>
      <div class="level">
        lv.8
      </div>
      <div class="email">
        hey@gmail.com
      </div>
      <div class="edit-profile">
        <i class="fas fa-cog"></i>
      </div>
    </div>
    
    
    <div class="mypage-container">
      <!-- tabs menu -->
      <div class="mypage-tabs">
        <div class="tabs-menu-container">
          <div class="tab tab-type" @click="tabPosition('mypage-type')">
            내 취향
          </div>
          <div class="tab tab-likes" @click="tabPosition('mypage-likes')">
            내 좋아요
          </div>
          <div class="tab tab-reviews" @click="tabPosition('mypage-reviews')">
            내 리뷰
          </div>
          <div class="tabs-now">
            <span class="under-bar"></span>
          </div>
        </div>
      </div>
      <div class="tabs-container">
        <div class="con">
          <!-- tab1 -->
          <div class="tab-section mypage-type">
            <el-scrollbar>
              <MyPagePreference/>
            </el-scrollbar>
          </div>
          <!-- tab2 -->
          <div class="tab-section mypage-likes">
            <el-scrollbar>
              <p>
                토스의 Front-end Developer 포지션은 사일로와 프론트엔드 챕터에 매트릭스 구조로 속해있어요. 토스는 사일로 조직 단위로 서비스/제품이 만들어지는데요, Product Owner, Product Designer, Server Developer, Front-end Developer, Data Analyst 등 6~8명의 직군이 하나의 사일로를 이루어 작은 스타트업처럼 자율성을 갖고 일하고 있어요. 인터뷰를 거치면서 본인의 강점을 발휘할 수 있는 제품을 점점 구체화하고, 선택할 수 있어요.
                프론트엔드 챕터는 하나의 팀처럼 협업하고 있어요! 주기적으로 챕터 위클리를 진행하여, 'Tech Talk'로 새로운 기술 토픽 또는 개발 노하우를 공유하고, UI 컴포넌트, 비동기 처리와 같이 라이브러리 개발과 코드리뷰를 함께 진행해요.
                프론트엔드 챕터의 올해 목표는 전보다 더 많은 리소스를 요구하는 토스의 비즈니스가 매끄럽게 운영될 수 있도록 프론트엔드 챕터의 규모적 성장을 하려고 해요.
                프론트엔드 챕터에 대해 더 알아보고 싶다면? → 토스 프론트엔드 챕터의 모든 것
                합류하면 함께 할 업무에요

                토스 홈페이지, 토스피드 등 토스의 다양한 정적 콘텐츠를 효과적으로 개발하고 배포할 수 있는 환경을 만들어요.
                정적 콘텐츠를 다양한 유형의 기기에서 높은 성능으로 제공할 수 있도록 연구해요.
                최고의 에디터 경험을 목표로 글을 작성하고 게시하는 워크플로우를 개선해요.
                TDS 등 토스커뮤니티 공통 라이브러리 제작에 참여해요.
                이런 분과 함께하고 싶어요

                React, Vue, Angular 등 SPA 프레임워크 사용에 능숙하신 분이면 좋아요.
                TypeScript, Flow를 이용한 JavaScript 정적 타입 분석을 경험해보신 분이면 좋아요.
                HTML, CSS, JavaScript에 대한 이해가 깊은 분을 찾아요.
                UI/UX에 대해 높은 가치를 두고 있는 분이면 좋아요.
                단순히 주어진 개발을 해내는 것보다, 주도적으로 문제를 발견하고 분석해 솔루션을 제안할 수 있는 분이 필요해요.
                이력서는 이렇게 작성하시는 걸 추천해요

                그동안의 경험을 단순 나열하는 것이 아닌, 경험 속에서의 임팩트 및 러닝 포인트를 기술해주세요.
                제품 또는 서비스를 주도적으로 개발하신 경험이 있으면 기술해주세요.
                서버 사이드 렌더링(SSR) 및 모바일 앱 내 웹앱 개발 경험이 있으면 좋아요.
                기존 소스 코드를 새로운 코드 베이스로 점진적으로 이관한 경험이 있으면 좋아요.
                Node.js, Python, PHP와 같은 다양한 언어 및 프레임워크 경험이 있으면 좋아요.
                산업기능요원은 현역 전직 및 보충역 신규 편입/전직이 가능하며, 전문연구요원은 전직만 가능해요. 다만 이력서에 병역 관련한 사항을 자세하게 기입 부탁드려요.
                토스가 사용하는 기술

                코어: React, TypeScript, Next.js
                상태 관리: React-Query, Recoil
                스타일링: Emotion
                패키지 매니저: Yarn Berry, PNPM
                빌드: Webpack, ESBuild, SWC, Babel
                CI/CD: GitHub Actions, CircleCI
                꼭 확인해주세요

                산업기능요원은 현역 전직 및 보충역 신규편입/전직이 가능하며, 전문연구요원의 경우 전직만 가능합니다
                토스로의 합류여정

                서류접수 > 사전과제 > 직무 인터뷰 > 문화적합성 인터뷰 > 최종 합격
                함께 할 동료를 위한 한마디
              </p>
            </el-scrollbar>
          </div>
          <!-- tab3 -->
          <div class="tab-section mypage-reviews">
            <el-scrollbar>
              
            </el-scrollbar>
          </div>
        </div>
        <div class="scroll-false"></div>
      </div>
    </div>

  </div>
</template>

<script setup>
import ModeToggle from "@/views/common/ModeToggle.vue"
import MyPagePreference from "@/views/mypage/MyPagePreference.vue"
import MyPageLikes from "@/views/mypage/MyPageLikes.vue"
import MyPageReviews from "@/views/mypage/MyPageReviews.vue"
import { ref, onMounted } from "vue";

const position = ref(0)

onMounted(() => {
  const mypageTabs = document.querySelector(".mypage-container")
  window.onscroll = function() {scrollTabMenu()};
  const hey = document.getElementsByClassName("tab-section")
  function scrollTabMenu() {
    position.value = mypageTabs.getBoundingClientRect().top

    if (position.value <= 120) {
      // document.querySelector(".mypage-tabs .tabs-menu-container").style.top = "0px"
      document.querySelector(".mypage-header .header-nick").style.top = "0"
      document.querySelector(".mypage-header .header-nick").style.fontSize = "1.2rem"
      document.querySelector(".scroll-false").style.display = "none"
    } else {
      // document.querySelector(".mypage-tabs .tabs-menu-container").style.top = `${position.value - 120}px`
      document.querySelector(".mypage-header .header-nick").style.top = `${240 * ((position.value - 120) / 390)}px`
      document.querySelector(".mypage-header .header-nick").style.fontSize = `${1.5 - 0.3 * (1- (position.value - 120) / 390)}rem`
      document.querySelector(".mypage-profile .bg-box").style.opacity = `${(position.value - 350) / 160}`
      document.querySelector(".mypage-profile .profile-pic").style.opacity = `${(position.value - 350) / 160}`
      document.querySelector(".mypage-profile .level").style.opacity = `${(position.value - 350) / 160}`
      document.querySelector(".mypage-profile .email").style.opacity = `${(position.value - 350) / 160}`
      document.querySelector(".mypage-profile .edit-profile").style.opacity = `${(position.value - 350) / 160}`
      document.querySelector(".scroll-false").style.display = "block"
    }
  }

})

function tabPosition(tabName) {
  if (tabName == "mypage-type") {
    document.querySelector(".tabs-container .con").style.left = "0"
    document.querySelector(".tabs-container .scroll-false").style.left = "0"
    document.querySelector(".tabs-now").style.left = "0"
  } else if (tabName == "mypage-likes") {
    document.querySelector(".tabs-container .con").style.left = "-100vw"
    document.querySelector(".tabs-container .scroll-false").style.left = "-100vw"
    document.querySelector(".tabs-now").style.left = "33%"
  } else if (tabName == "mypage-reviews") {
    document.querySelector(".tabs-container .con").style.left = "-200vw"
    document.querySelector(".tabs-container .scroll-false").style.left = "-200vw"
    document.querySelector(".tabs-now").style.left = "66%"
  }
}
</script>

<style>
  
</style>