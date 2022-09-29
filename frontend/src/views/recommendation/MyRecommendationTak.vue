<template>
  <HeaderView/>
  <div class="survey-container">
    <div class="weekday">

      <!-- monday -->
      <div class="ques-container">
        <div class="day">
          월요일
        </div>
        <div class="question">
          월요병에 걸린 당신, 카페에서 늘상 테이크아웃하는 커피는?
        </div>
        <div class="ques-img-container">
          <div class="left-img ques-img">
            <img src="@/assets/images/test.png" alt="ques1-left">
          </div>
          <div class="right-img ques-img">
            <img src="@/assets/images/test.png" alt="ques1-right">
          </div>
        </div>
      </div>

      <!-- tuesday -->
      <div class="ques-container">
        <div class="day">
          화요일
        </div>
        <div class="question">
          동기들과 후식으로 마실 것을 사려고 합니다. 둘 중 어느 음료가 더 당기나요?
        </div>
        <div class="ques-img-container">
          <div class="left-img ques-img">
            <img src="@/assets/images/test.png" alt="ques1-left">
          </div>
          <div class="right-img ques-img">
            <img src="@/assets/images/test.png" alt="ques1-right">
          </div>
        </div>
      </div>

      <!-- wednesday -->
      <div class="ques-container">
        <div class="day">
          수요일
        </div>
        <div class="question">
          지친 발걸음으로 집으로 돌아가는 길, 집앞에 새로운 과일 주스 가게가 생겼네요. 메뉴판에서 어떤 주스를 고를 건가요?
        </div>
        <div class="ques-img-container">
          <div class="left-img ques-img">
            <img src="@/assets/images/test.png" alt="ques1-left">
          </div>
          <div class="right-img ques-img">
            <img src="@/assets/images/test.png" alt="ques1-right">
          </div>
        </div>
      </div>

      <!-- thursday -->
      <div class="ques-container">
        <div class="day">
          목요일
        </div>
        <div class="question">
          오랜만에 집 근처 공원을 돌고 왔습니다. 집에 오자마자 찾는 음료는?
        </div>
        <div class="ques-img-container">
          <div class="left-img ques-img">
            <img src="@/assets/images/test.png" alt="ques1-left">
          </div>
          <div class="right-img ques-img">
            <img src="@/assets/images/test.png" alt="ques1-right">
          </div>
        </div>
      </div>

      <!-- friday -->
      <div class="ques-container">
        <div class="day">
          금요일
        </div>
        <div class="question">
          지치는 금요일, 머리를 너무 많이 써서 먹을 게 생각납니다. 무엇을 먹을까요?
        </div>
        <div class="ques-img-container">
          <div class="left-img ques-img">
            <img src="@/assets/images/test.png" alt="ques1-left">
          </div>
          <div class="right-img ques-img">
            <img src="@/assets/images/test.png" alt="ques1-right">
          </div>
        </div>
      </div>

    </div>
    
    <div class="submit-survey">
        <div class="submit-btn">
          나의 술 취향은?
        </div>
      </div>

  </div>
</template>

<script setup>
  import HeaderView from "@/views/common/HeaderView.vue"
</script>

<style>
  
</style>