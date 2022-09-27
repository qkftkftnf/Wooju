<template>
  <div>
  <HeaderView/>
  <div class="create-container">
    <div class="title">
      리뷰 작성
    </div>
    <div class="create-input">
      <div class="sool-name">
        술이름 들어가고요
      </div>
      <div class="sool-rate">
        별점 el-rate였나
      </div>
      <div class="review-textarea">
        <textarea
          name="review-content"
          id="review-content"
          rows="15"
          placeholder="내용을 입력해주세요"
        >
        </textarea>
      </div>
      <div class="img-upload">
        <div class="thumbnail-box">
          <img src="" alt="" class="thumb0 th">
          <img src="" alt="" class="thumb1 th">
          <img src="" alt="" class="thumb2 th">
        </div>
        <div class="alert">파일은 최대 3개까지 첨부가 가능합니다.</div>
        <div>
        </div>
        <input
          type="file"
          accept="image/jpeg, image/jpg, image/png"
          @change="onFileChange"
          multiple
          id="review-upload-input"
        >
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
  if (image.target.files.length > maxLength.value) {
    alert("이미지는 최대 3개까지 첨부가 가능합니다.")
    document.getElementById("review-upload-input").value = "";
  } else {
    for (let index = 0; index < image.target.files.length; index++) {
      uploadImages.value.push(image.target.files[index])
      eachThumbnail(index)
    }
  }
}

const eachThumbnail = (index) => {
  const pic = document.getElementById("review-upload-input").files[index]
  var reader = new FileReader()

  if (pic) {
    reader.addEventListener('load', function() {
      document.querySelector(`.thumb${index}`).src = reader.result;
    });
    reader.readAsDataURL(pic);
  }
}
</script>

<style>
</style>