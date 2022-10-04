<template>
  <MainHomeVue v-if="isLoggedIn" />
  <MainHomeNonmemberVue v-else />

  <!-- <div>
    <RouterView/>
  </div> -->
</template>

<script setup>
import { computed } from 'vue';
import { useStore } from 'vuex';
import MainHomeNonmemberVue from './MainHomeNonmember.vue';
import MainHomeVue from './MainHome.vue';

const store = useStore()

const isLoggedIn = computed(() => store.getters.isLoggedIn)

</script>

<style>  
</style>