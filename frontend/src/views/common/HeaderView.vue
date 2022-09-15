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
      document.documentElement.style.setProperty('--main-color', '#ffd524');
      document.documentElement.style.setProperty('--main-bg-color', '#161b27');
      document.documentElement.style.setProperty('--frame-color', '#23283c');
      document.documentElement.style.setProperty('--text-color', '#f4f4f4');

      document.querySelector("#mode-icon").classList.add('fa-sun')
      document.querySelector("#mode-icon").classList.remove('fa-moon')
    } else {
      toggleValue.value = !toggleValue.value
      document.documentElement.style.setProperty('--main-color', '#f05555');    
      document.documentElement.style.setProperty('--main-bg-color', '#fff');
      document.documentElement.style.setProperty('--frame-color', '#fff');
      document.documentElement.style.setProperty('--text-color', '#000');

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