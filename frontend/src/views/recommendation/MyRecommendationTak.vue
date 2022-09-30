<template>
  <HeaderView/>
  <div class="survey-container">
    <div class="weekday">
      <!-- monday -->
      <div class="ques-container">
        <div class="day">
          <span>
            월요일
          </span>
        </div>
        <div class="question">
          <div class="ques-img-container">
            <img src="@/assets/images/survey/headache.png" alt="qest-img">
          </div>
          <div class="ask">
            월요병에 걸린 당신,<br/>카페에서 늘상 사는 커피는?
          </div>
        </div>
        <div id="question1" class="options">
          <div class="opt upper" @click="question(1, 0)">
            달달하게 힘이 나는<br/>
            <span>돌체 라떼</span>
          </div>
          <div class="opt" @click="question(1, 1)">
            깔끔하게 정신 차리자!<br/>
            <span>아메리카노</span>
          </div>
        </div>
      </div>

      <!-- tuesday -->
      <div class="ques-container">
        <div class="day">
          <span>
            화요일
          </span>
        </div>
        <div class="question">
          <div class="ques-img-container">
            <img src="@/assets/images/survey/company.png" alt="qest-img">
          </div>
          <div class="ask">
            동기들과 후식으로 마실 것을 사려고 합니다.<br/>둘 중 어느 음료가 더 당기나요?
          </div>
        </div>
        <div id="question2" class="options">
          <div class="opt upper" @click="question(2, 0)">
            입안이 가벼워지는<br/>
            <span>루이보스 차</span>
          </div>
          <div class="opt" @click="question(2, 1)">
            부드럽게 넘어가는<br/>
            <span>밀크 쉐이크</span>
          </div>
        </div>
      </div>

      <!-- wednesday -->
      <div class="ques-container">
        <div class="day">
          <span>
            수요일
          </span>
        </div>
        <div class="question">
          <div class="ques-img-container">
            <img src="@/assets/images/survey/juice.png" alt="qest-img">
          </div>
          <div class="ask">
            집으로 돌아가는 길에 생긴 과일 주스 가게에서<br/>어떤 주스를 고를 건가요?
          </div>
        </div>
        <div id="question3" class="options">
          <div class="opt upper" @click="question(3, 0)">
            당 충전으로 힘내기!<br/>
            <span>바나나 주스</span>
          </div>
          <div class="opt" @click="question(3, 1)">
            힘이 들 땐 비타민 C!<br/>
            <span>레모네이드</span>
          </div>
        </div>
      </div>

      <!-- thursday -->
      <div class="ques-container">
        <div class="day">
          <span>
            목요일
          </span>
        </div>
        <div class="question">
          <div class="ques-img-container">
            <img src="@/assets/images/survey/walkin.png" alt="qest-img">
          </div>
          <div class="ask">
            오랜만에 집 근처 공원을 돌고 왔습니다.<br/>집에 오자마자 찾는 음료는?
          </div>
        </div>
        <div id="question4" class="options">
          <div class="opt upper" @click="question(4, 0)">
            벌컥벌컥 마실 수 있는 상큼한<br/>
            <span>이온 음료</span>
          </div>
          <div class="opt" @click="question(4, 1)">
            목 마를 땐 탄산이지!<br/>
            <span>사이다</span>
          </div>
        </div>
      </div>

      <!-- friday -->
      <div class="ques-container">
        <div class="day">
          <span>
            금요일
          </span>
        </div>
        <div class="question">
          <div class="ques-img-container">
            <img src="@/assets/images/survey/friday.png" alt="qest-img">
          </div>
          <div class="ask">
            지치는 금요일,<br/>머리를 너무 많이 써서 먹을 게 생각납니다.<br/>무엇을 먹을까요?
          </div>
        </div>
        <div id="question5" class="options">
          <div class="opt upper" @click="question(5, 0)">
            딱 알맞게 구워진 바삭한<br/>
            <span>크림 치즈 베이글</span>
          </div>
          <div class="opt" @click="question(5, 1)">
            한 조각만 먹어도 힘이 나는<br/>
            <span>초코 케이크</span>
          </div>
        </div>
      </div>
    </div>
    
    <div class="ques-container submit-survey">
      <div class="submit-btn" @click="SubmitSurvey">
        나의 술 취향은?
      </div>
    </div>

  </div>
</template>

<script setup>
import HeaderView from "@/views/common/HeaderView.vue"
import { ref, onMounted } from "vue";

onMounted (() => {
  window.scrollTo(0, 0)
})


const answerList = ref({
  "question1": -1,
  "question2": -1,
  "question3": -1,
  "question4": -1,
  "question5": -1,
  "question6": -1,
  "type": "증류주",
})



const question = (idx, option) => {
  answerList.value[`question${idx}`] = option
  document.querySelectorAll(`#question${idx} div.opt`)[!!option ? 0 : 1].classList.remove('active')
  document.querySelectorAll(`#question${idx} div.opt`)[option].classList.add('active')
}

const SubmitSurvey = () => {
  console.log(answerList.value)
}
</script>

<style>
  
</style>