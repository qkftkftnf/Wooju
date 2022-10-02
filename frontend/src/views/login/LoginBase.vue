<template>
  <HeaderView/>
  <div class="login-container">
    <div class="login-button-group">
      <img class="login-button-image" :src="google" alt="login with google"
        @click="loginPopup('google')" />
      <img class="login-button-image" :src="naver" alt="login with naver"
        @click="loginPopup('naver')" />
      <p class="login-message">소셜 계정으로 우-주에 로그인하세요!</p>
    </div>
  </div>
  <MenuView menuTab="my-page-menu"/>
</template>

<script setup>
import HeaderView from "@/views/common/HeaderView.vue"
import MenuView from "@/views/common/MenuView.vue"
import google from "@/assets/images/login/google.svg"
import naver from "@/assets/images/login/naver.svg"
// import { onMounted } from "vue";


// onMounted(() => {
// })
// 'menubar=no, status=no, toolbar=no'
const loginPopup = (path) => window.open(`/login/popup/${path}`, '_blank', )
</script>

<style>
</style>