<template>
  <div>
    <RouterView/>
    <MenuView menuTab="community-menu"/>
  </div>
</template>

<script setup>
// import MyRecommendation from "./MyRecommendation.vue"; 
import MenuView from "@/views/common/MenuView.vue"
import { ref, onMounted } from "vue";


onMounted (() => {
  window.scrollTo(0, 0)
})


</script>

<style>  
</style>