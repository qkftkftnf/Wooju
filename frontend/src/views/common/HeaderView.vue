<template>
  <div class="header-container">
    <img src="@/assets/images/Samsung_Logo.svg" alt="logo" class="logo">
    <button @click="toggleFunc" class="mode-toggle">
      <span class="mode-icon">
        <i class="fas fa-moon" id="mode-icon"></i>
      </span>
    </button>
  </div>
</template>

<script setup>
  import { ref } from 'vue'

  const toggleValue = ref(false);

  // var toggleValue = false

  const toggleFunc = () => {
    if (!toggleValue.value) {
      toggleValue.value = !toggleValue.value
      document.documentElement.style.setProperty('--main-color', '#232437');
      document.documentElement.style.setProperty('--main-bg-color', '#091022');
      document.documentElement.style.setProperty('--menu-color', '#23283c');
      document.documentElement.style.setProperty('--text-color', '#f4f4f4');
      document.documentElement.style.setProperty('--card-bg-color', '#282B37');

      document.querySelector("#mode-icon").classList.add('fa-sun')
      document.querySelector("#mode-icon").classList.remove('fa-moon')
    } else {
      toggleValue.value = !toggleValue.value
      document.documentElement.style.setProperty('--main-color', '#FFD634');    
      document.documentElement.style.setProperty('--main-bg-color', '#FFFAE8');
      document.documentElement.style.setProperty('--menu-color', '#fafafa');
      document.documentElement.style.setProperty('--text-color', '#000');
      document.documentElement.style.setProperty('--card-bg-color', '#fff');

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
    border-radius: 100%;
    border: 0px solid #aaa;
    position: absolute;
    top: 10px;
    right: 10px;
  }
</style>