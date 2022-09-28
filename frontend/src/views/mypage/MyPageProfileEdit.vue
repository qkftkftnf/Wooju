<template>
  <div>
    <HeaderView/>
    <div class="profile-edit-container">
      <div class="title">
        개인 정보 수정
      </div>
      <div class="avatar">
        <div class="pic">
          <img id="pic-thumbnail" src="https://images.unsplash.com/photo-1621351813579-4ceefec7235c?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8eWVsbG93JTIwYWVzdGhldGljfGVufDB8fDB8fA%3D%3D&w=1000&q=80" alt="">
        </div>
        <div class="pic-edit" @click="openGallery">
          <div class="pic-edit-btn">
            <i class="fas fa-pen"></i>
          </div>
          <input
            type="file"
            accept="image/jpeg, image/jpg, image/png"
            @change="onFileChange"
            id="pic-upload-input"
          >
        </div>

        <div class="profile-info">
          <div class="nick">
            <el-input type="text" class="edit-nickname" v-model="nickname"/>
          </div>
          <div class="email">
            <i class="fas fa-envelope envelope"></i> hey@gmail.com
          </div>
        </div>

        <div class="submit">
          수정
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import HeaderView from "@/views/common/HeaderView.vue"

import { ref } from "vue";


// image upload  
const uploadImages = ref([])

const openGallery = () => {
  document.querySelector("#pic-upload-input").click()
}

const onFileChange = (image) => {
  uploadImages.value.push(image.target.files[0])
  getThumbnail()
}

const getThumbnail = () => {
  const pic = document.getElementById("pic-upload-input").files[0]
  var reader = new FileReader()

  if (pic) {
    reader.readAsDataURL(pic);
    reader.addEventListener('load', function() {
      document.querySelector("#pic-thumbnail").src = reader.result;
    });
  }

  console.log(nickname.value)
}


// eidt nickname
const nickname = ref("편백나무")

</script>

<style>
  
</style>