<template>
  <div class="mypage-review-container mypage-inner">
    <div class="list-row">
      <div class="mypage-review-card" v-for="i in 9" @click="openModal(i)">
        <div class="review-img">
          <img src="@/assets/images/pic1.jpg" alt="pic1">
        </div>
        <div class="review-content">
          <div class="review-wooju">
            만강에 비친 달
          </div>
          <div class="review-date">
            2022.09.22
          </div>
          <div class="review-rate">
            <i class="fas fa-star star"></i> 4.5
          </div>
        </div>
      </div>
    </div>

  </div>
  
  <teleport to='.tab-template' />
    <transition name="review">
      <div v-if="isOpen" class="teleport-container">
        <el-scrollbar>
          <div class="modal-header">
            <div class="date">
              2022.09.10
            </div>
            <div class="edit-btn">
              수정
            </div>
          </div>

          <div class="image-carousel">
            <div class="img">
              <img src="@/assets/images/pic1.jpg" alt="pic1">
            </div>
            <div class="img">
              <img src="@/assets/images/pic2.jpg" alt="pic2">
            </div>
            <div class="img">
              <img src="@/assets/images/pic3.jpg" alt="pic3">
            </div>
          </div>

          <div class="review-stat">
            <div class="wooju">
              황금보리 17%
            </div>
            <div class="rate">
              <i class="fas fa-star star" v-for="i in 4"></i>
            </div>
          </div>

          <div class="reivew-content">
            전통주 갤러리에서 시행하는 전통주 시음회에 다녀왔습니다. 다섯 개의 전통주를 마실 수 있었는데, 그 중 저에게는 ‘만강에 비친 달’이 가장 인상 깊었습니다. 단호박을 재료로 해서 빚은 막걸리라는데, 노란 빛이 추석을 생각나게 하더군요. 맛도 독특하고 계속 생각나는 맛이었습니다. 모두들 한번쯤 도전해볼만 한 술인 것 같습니다. 
          </div>
          <button @click="closeModal()"></button>
        </el-scrollbar>
      </div>
    </transition>
</template>

<script setup>
import { ref } from "vue"

const isOpen = ref(false)

const openModal = (n) => {
  isOpen.value = true
}
const closeModal = () => {
  isOpen.value = false
}

</script>

<style>
  button {
  width: 100px;
  height: 40px;
  }
  
  .review-enter-from {
    top: calc(100vh - 190px);
  }

  .review-enter-to {
    top: 0;
  }

  .review-leave-to {
    top: calc(100vh - 190px);
  }
  
</style>
