<template>
  <div class="menu-container">
    <div class="my-page menu-div">
      <i class="fas fa-home icon"></i>
      <span class="menu-title">마이 페이지</span>
    </div>
    <div class="my-page menu-div">
      <i class="fas fa-hand-holding-heart icon"></i>
      <span class="menu-title">오늘의 추천</span>
    </div>
    <div class="my-page menu-div" @click="linkTo('CommunityMain')">
      <i class="fas fa-users icon is-active"></i>
      <span class="menu-title">커뮤니티</span>
    </div>
    <div class="my-page menu-div">
      <i class="fas fa-wine-bottle icon"></i>
      <span class="menu-title">우리술 찾기</span>
    </div>
    <div class="my-page menu-div" @click="linkTo('MyPageMain')">
      <i class="fas fa-user icon"></i>
      <span class="menu-title">마이 페이지</span>
    </div>
  </div>
</template>

<script setup>
import { useRouter } from "vue-router";

const router = useRouter();
const linkTo = (name) => router.push({ name: name })
</script>

<style>
  
</style>