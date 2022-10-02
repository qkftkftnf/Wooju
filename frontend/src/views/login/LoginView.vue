<template>
  <RouterView/>
</template>

<script setup>
</script>

<style>
.login-container {
  margin-top: 60px;
  height: calc(100vh - 130px);
  background-color: var(--bg-color);
  display: flex;
  align-items: center;
}

.login-container .login-button-group {
  padding-bottom: 15vh;
}

.login-container .login-message {
  font-size: 1.4rem;
  text-transform: uppercase;
}

.login-container .login-button-image {
  width: 20%;
  margin: 9%;
  cursor: pointer;
}

.login-container .login-button-image:active {
  filter: brightness(0.8);
}

</style>