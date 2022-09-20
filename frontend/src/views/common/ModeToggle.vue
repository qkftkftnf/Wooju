<template>
  <button @click="toggleFunc" class="mode-toggle">
    <span class="mode-icon">
      <i class="fas fa-moon" id="mode-icon"></i>
    </span>
  </button>
</template>

<script setup>
import { ref } from 'vue'

const toggleValue = ref(false);

const toggleFunc = () => {
  if (!toggleValue.value) {
    // 다크모드
    document.querySelector('meta[name="theme-color"]').setAttribute('content',  '#091022')

    toggleValue.value = !toggleValue.value
    document.documentElement.style.setProperty('--main-color', '#ffd524');
    document.documentElement.style.setProperty('--main-bg-color', '#1d222e');
    document.documentElement.style.setProperty('--main-header-color', '#1d222e');
    document.documentElement.style.setProperty('--highlight-bg-color', '#091022');
    document.documentElement.style.setProperty('--menu-color', '#23283c');
    document.documentElement.style.setProperty('--text-color', '#f4f4f4');
    document.documentElement.style.setProperty('--card-bg-color', '#282B37');
    document.documentElement.style.setProperty('--border-color', '#282B37');
    document.documentElement.style.setProperty('--review-body-color', '#091022');

    document.documentElement.style.setProperty("--shadow-color", "rgba(255, 0, 0, 0.4)")
    console.log(document.documentElement.style)
    // var bsCard03 = document.querySelectorAll(".bs-card-03")
    // bsCard03.forEach(eachClass => eachClass.style.boxShadow = "0px -4px 6px 6px rgba(255, 255, 255, 0.9) !important")
    // bsCard03.forEach(eachClass => eachClass.classList.replace("bs-card-03", "bs-dark-card-03"))
    document.querySelector("#mode-icon").classList.add('fa-sun')
    document.querySelector("#mode-icon").classList.remove('fa-moon')

  } else {
    // 라이트모드
    document.querySelector('meta[name="theme-color"]').setAttribute('content',  '#FFD634')

    toggleValue.value = !toggleValue.value
    document.documentElement.style.setProperty('--main-color', '#FFD634');    
    document.documentElement.style.setProperty('--main-bg-color', '#f9f9f9');
    document.documentElement.style.setProperty('--main-header-color', '#FFD634');
    document.documentElement.style.setProperty('--highlight-bg-color', '#FFD634');
    document.documentElement.style.setProperty('--menu-color', '#fafafa');
    document.documentElement.style.setProperty('--text-color', '#000');
    document.documentElement.style.setProperty('--card-bg-color', '#fff');
    document.documentElement.style.setProperty('--border-color', '#E8E8E8');
    document.documentElement.style.setProperty('--review-body-color', '#fff');
    
    document.querySelector("#mode-icon").classList.add('fa-moon')
    document.querySelector("#mode-icon").classList.remove('fa-sun')

  }
}

</script>

<style>
.mode-toggle {
  width: 40px;
  height: 40px;
  background-color: transparent;
  border: 0px solid #aaa;
  position: absolute;
  top: 5px;
  right: 10px;
} 
</style>