<template>
  <!-- <HeaderView/> -->
  <div class="header-container">
    <div class="create-header">
      <div class="title">
        리뷰 작성
      </div>
      <div class="submit">
        <div class="submit-btn" @click="onSubmit">등록</div>
      </div>
    </div>
  </div>
  
  <div class="create-container">
    <div class="create-input">
      <div class="sool-name">
        술 이름: <span>황금 보리 17.5%</span>
      </div>
      <div class="line"></div>
      <div class="sool-rate">
        <el-rate
          v-model="rate"
          allow-half
          size="large"
          show-score
          ></el-rate>
      </div>
      <div class="review-textarea">
        <el-input
          v-model="reviewTextarea"
          :rows="12"
          type="textarea"
          placeholder="내용을 입력해주세요"
        />
      </div>
      <div class="img-upload">
        <div class="thumbnail-box">
          <div class="thumbnail gallary-btn">
            <img src="" alt="" class="thumb0">
          </div>
          <div class="thumbnail">
            <img src="" alt="" class="thumb1">
          </div>
          <div class="thumbnail">
            <img src="" alt="" class="thumb2">
          </div>
        </div>
        <div class="gallary" @click="openGallery">
          <div class="img-icon">
            + 사진 첨부
          </div>
          <input
          type="file"
          accept="image/jpeg, image/jpg, image/png"
          @change="onFileChange"
          multiple
          id="review-upload-input"
          >
        </div>
        <!-- <div class="alert">파일은 최대 3개까지 첨부가 가능합니다.</div> -->
      </div>
    </div>
  </div>
</template>

<script setup>
import HeaderView from "@/views/common/HeaderView.vue"
import { ref } from "vue";
import { useStore } from "vuex";
  

// image upload
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
    reader.readAsDataURL(pic);
    reader.addEventListener('load', function() {
      document.querySelector(`.thumb${index}`).src = reader.result;
    });
  }
}

const openGallery = () => {
  document.querySelector("#review-upload-input").click()
}


// submit
const rate = ref(0)
const reviewTextarea = ref("")
const store = useStore()

const onSubmit = () => {
  // var imgData = new FormData()
  // uploadImages.value.forEach(function(img) {
  //   imgData.append("img", img)
  // })
  const reviewData = ref({
    product_id: 100,
    star: rate.value,
    title: "필요한가요?",
    content: reviewTextarea.value,
    // img: imgData,
    img: [],
  })
  
  // console.log(reviewData.value)
  store.dispatch('createReview', reviewData.value)
};




</script>

<style>
</style>