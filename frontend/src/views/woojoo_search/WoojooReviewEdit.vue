<template>
  <!-- <HeaderView/> -->
  <div class="header-container">
    <div class="create-header">
      <div class="create-title">
        리뷰 수정
      </div>
      <div class="submit">
        <div class="submit-btn" @click="onSubmit">등록</div>
      </div>
    </div>
  </div>
  
  <div class="create-container">
    <div class="create-input">
      <div class="sool-name">
        술 이름: <span>{{ reviewData.review.product_id }}</span>
      </div>
      <div class="line"></div>
      <div class="sool-rate">
        <el-rate
          v-model="reviewData.review.star"
          allow-half
          size="large"
          show-score
          ></el-rate>
      </div>
      <div class="review-textarea">
        <el-input
          v-model="reviewData.review.content"
          :rows="12"
          type="textarea"
          placeholder="내용을 입력해주세요"
        />
      </div>
      <div class="img-upload">
        <div class="thumbnail-box">
          <div class="thumbnail gallary-btn">
            <img :src="reviewData.review.img[0]" alt="" class="thumb0">
          </div>
          <div class="thumbnail">
            <img :src="reviewData.review.img[1]" alt="" class="thumb1">
          </div>
          <div class="thumbnail">
            <img :src="reviewData.review.img[2]" alt="" class="thumb2">
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
        <div class="reset" @click="resetGallery">
          <div class="img-icon reset-btn">
            - 첨부 초기화
          </div>
        </div>
        <!-- <div class="alert">파일은 최대 3개까지 첨부가 가능합니다.</div> -->
      </div>
    </div>
  </div>
</template>

<script setup>
import HeaderView from "@/views/common/HeaderView.vue"
import { ref, computed, onMounted } from "vue";
import { useStore } from "vuex";
import { useRoute, useRouter } from "vue-router"

const route = useRoute()
const store = useStore();
const reviewPk = route.params.articlePk

const reviewData = computed(() => store.getters.reviews);

onMounted(() => {
  store.dispatch("fetchReview", reviewPk)
})


// image upload
const maxLength = ref(3)

const onFileChange = (image) => {
  if (image.target.files.length > maxLength.value) {
    alert("이미지는 최대 3개까지 첨부가 가능합니다.")
    document.getElementById("review-upload-input").value = "";
  } else {
    for (let index = 0; index < image.target.files.length; index++) {
      reviewData.value.review.img.push(image.target.files[index])
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

const resetGallery = () => {
  reviewData.value.review.img = []

  for (let index = 0; index < 3; index++) {
    document.querySelector(`.thumb${index}`).src = "";
   
  }
}


// submit
const onSubmit = () => {
  var imgData = new FormData()
  
  reviewData.value.review.img.forEach(function(img) {
    imgData.append("file", img)
  })

  const reviewData = {
    id: reviewPk,
    star: rate.value,
    title: reviewData.value.review.title,
    content: reviewData.value.review.conntent,
    img: reviewData.value.review.img
  }

  store.dispatch('createReview', reviewData)
};




</script>

<style>
</style>