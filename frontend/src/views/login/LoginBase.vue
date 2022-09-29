<template>
  <HeaderView/>
  <div class="login-container">
    <div id="login_button_group" class="fade-animation">
      <img class="login-button-image" src="@/assets/images/login/google.png" alt="login with google"
        @click="loginPopup('google')" />
      <img class="login-button-image" src="@/assets/images/login/naver.png" alt="login with naver"
        @click="loginPopup('naver')" />
    </div>
  </div>
  <MenuView menuTab="my-page-menu"/>
</template>

<script setup>
import HeaderView from "@/views/common/HeaderView.vue"
import MenuView from "@/views/common/MenuView.vue"
// import { onMounted } from "vue";


// onMounted(() => {
// })
// 'menubar=no, status=no, toolbar=no'
const loginPopup = (path) => window.open(`/login/popup/${path}`, '_blank', )
</script>

<style>  
</style>