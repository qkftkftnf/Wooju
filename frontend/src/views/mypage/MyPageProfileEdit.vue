<template>
  <div>
    <HeaderView/>
    <div class="profile-edit-container">
      <div class="title">
        개인 정보 수정
      </div>
      <div class="avatar">
        <div class="pic">
          <img src="https://images.unsplash.com/photo-1621351813579-4ceefec7235c?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8eWVsbG93JTIwYWVzdGhldGljfGVufDB8fDB8fA%3D%3D&w=1000&q=80" alt="">
        </div>
        <div class="pic-edit">
          <div class="edit-btn">
            프로필 사진 수정
          </div>
          <div class="input-box">
            <input
              type="file"
              accept="image/jpeg, image/jpg, image/png"
              @change="onFileChange"
              id="review-upload-input"
            >
          </div>
        </div>

        <div class="profile-info">
          <div class="nick">
            편백나무
          </div>
          <div class="email">
            hey@gmail.com
          </div>
        </div>

        <div class="submit">
          수정
        </div>
        <div class="logout">
          로그아웃
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import HeaderView from "@/views/common/HeaderView.vue"

import { ref } from "vue";
  
const uploadImages = ref([])
const maxLength = ref(3)

const onFileChange = (image) => {
  uploadImages.value.push(image.target.files[index])
  getThumbnail(index)
}

const getThumbnail = (index) => {
  const pic = document.getElementById("review-upload-input").files[index]
  var reader = new FileReader()

  if (pic) {
    reader.readAsDataURL(pic);
    reader.addEventListener('load', function() {
      document.querySelector(`.thumb${index}`).src = reader.result;
    });
  }
}

</script>

<style>
  
</style>