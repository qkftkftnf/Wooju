<template>
  <HeaderView/>
  <div class="nonmember-container">
    <div class="illustration">
      <img src="@/assets/images/drinking_people.png" alt="drinking_people">
    </div>
    <div class="nonmenber-intro">
      더 많은 기능,<br/>더 많은 우주를 둘러보기 위해<br/><span>로그인</span>을 해주세요!
    </div>
    <div class="login">
      <div class="login-btn">로그인</div>
    </div>
    <div class="signup">
      <div class="signup-btn">회원 가입</div>
    </div>
  </div>
  <MenuView menuTab="my-page-menu"/>
</template>

<script setup>
import HeaderView from "@/views/common/HeaderView.vue"
import MenuView from "@/views/common/MenuView.vue"
</script>

<style>
  
</style>