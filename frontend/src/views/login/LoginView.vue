<template>
  <RouterView/>
</template>

<script setup>
</script>

<style>
.login-container{
  margin-top: 60px;
  padding-top: 40px;
  height: calc(100vh - 130px);
  background-color: var(--highlight-bg-color);
}

.login-container .login-button-image:active{
  filter: brightness(0.8);
}
</style>