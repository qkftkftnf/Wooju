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
import { useStore } from "vuex"
import { useRouter } from "vue-router"

const store = useStore()
const router = useRouter()

window.checkLogin = () => {
  const token = localStorage.getItem('token')
  console.log(token)
  if (!!token) {
    store.dispatch('saveToken', token)
    router.push({ name: 'CommunityMain' })
  } else {
    alert('로그인 실패')
  }
}
// 'menubar=no, status=no, toolbar=no'
const loginPopup = (path) => window.open(`/login/popup/${path}`, '_blank', )
</script>

<style>
</style>