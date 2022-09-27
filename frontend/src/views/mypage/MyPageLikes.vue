<template>
  <div class="likes-container mypage-inner">
    <div class="like-wooju" v-for="data in likesData">
      <div class="wooju-img">
        <img :src="data.image" alt="">
      </div>
      <div class="introduction">
        <div class="title">
          {{ data.name }}
        </div>
        <div class="content">
          <span class="proof">{{ data.alcohol }}%</span> | <span class="bottle">{{ data.volume }}</span>
        </div>
        <div class="likes">
            <!-- <span class="star" v-for="i in 4">
              <i class="fas fa-star star-icon"></i>
            </span>
            <span class="half"><i class="far fa-star star-icon"></i></span>
            <span> | </span> -->
            <span class="heart">
              <i class="fas fa-heart heart-icon"></i>
            </span>
            <span class="count">{{ data.like_num }}</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { computed, onMounted } from "vue";
import { useRouter } from "vue-router";
import { useStore } from "vuex";

const router = useRouter();

// vuex axios
const store = useStore();
const likesData = computed(() => store.getters.sool);

onMounted(() => {
  store.dispatch("fetchSool")
})


</script>

<style>
  
</style>