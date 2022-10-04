<template>
  <HeaderView/>
  <div class="signup-container">
    <div class="title">
      회원 가입
    </div>
    <div class="avatar">
      <div class="pic">
        <img id="pic-thumbnail" :src="userInfo.img" alt="profile image">
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
          <div class="label">
            닉네임
          </div>
          <el-input type="text" class="edit-nickname" v-model="userInfo.nickname"/>
        </div>
        <div class="birthdate">
          <div class="label">
            생일
          </div>
          <el-input type="date" class="edit-nickname" v-model="userInfo.birthdate"/>
        </div>
        <div class="gender">
          <div class="label">
            성별
          </div>
          <el-radio-group class="gender-radio" v-model="userInfo.gender">
            <el-radio label="남자" />
            <el-radio label="여자" />
          </el-radio-group>
        </div>
      </div>
      <div class="submit" @click="onSubmit">
        회원 가입
      </div>

    </div>
  </div>
</template>

<script setup>
import HeaderView from "@/views/common/HeaderView.vue"
import { ref, onMounted ,computed } from "vue";
import { useStore } from "vuex";
import { useRoute } from "vue-router";
import http from "@/api/index.js"

const store = useStore()
const route = useRoute()
const userInfo = ref({
  "birthdate": "",
  "email": route.query.email,
  "gender": "",
  "img": "https://wooju-bucket.s3.ap-northeast-2.amazonaws.com/48817946-7a86-45e4-8209-b17ec8716fcc-user.png",
  "nickname": "",
  "usertype": route.query.usertype,
})

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
}


const onSubmit = () => {
  const signupInfo = {
    "birthdate": userInfo.value.birthdate,
    "email": userInfo.value.email,
    "gender": userInfo.value.gender,
    "img": userInfo.value.img,
    "nickname": userInfo.value.nickname,
    "usertype": userInfo.value.usertype,
  }

  if (signupInfo.gender == '남자') {
    signupInfo.gender = 'M'
  } else if (signupInfo.gender == '여자') {
    signupInfo.gender = 'F'
  }

}

</script>

<style>
  .signup-container {
  margin-top: 60px;
  width: 100vw;
  height: calc(100vh - 60px);
  max-width: 500px;
  position: relative;
  display: flex;
  flex-direction: column;
  justify-content: center;
}

.signup-container .title {
  font-size: 1.4rem;
  font-weight: 600;
  margin-top: 0px;
  margin-bottom: 30px;
}

.signup-container .avatar {
  position: relative;
}

.signup-container .avatar .pic {
  width: 150px;
  height: 150px;
  margin-bottom: 20px;
  overflow: hidden;
  border-radius: 100%;
  position: relative;
}

.signup-container .avatar .pic img {
  width: 150px;
  height: 150px;
  object-fit: cover;
  object-position: center;
}  

.signup-container .avatar .pic-edit {
  position: absolute;
  top: 120px;
  width: 100%;
  height: 40px;
}

.signup-container .avatar .pic-edit .pic-edit-btn {
  width: 30px;
  height: 30px;
  line-height: 30px;
  position: absolute;
  left: calc(50% + 35px);
  border-radius: 100%;
  background-color: var(--card-bg-color);
  box-shadow: 0px 2px 2px 2px rgba(0, 0, 0, 0.07)

}

.signup-container .avatar .pic-edit .edit-btn {
  margin-top: 20px;
  width: 120px;
  height: 35px;
  line-height: 35px;
  border-radius: 10px;
  border: 1px solid var(--main-color);
  font-size: 0.9rem;
}

.signup-container .avatar .pic-edit #pic-upload-input {
  display: none;
}

.signup-container .profile-info {
  /* margin-right: 10px; */
  width: 250px;
}

.signup-container .profile-info .el-input {
  width: 190px;
}

.signup-container .profile-info .el-radio-group {
  width: 155px;
  margin-right: 25px;
}

.signup-container .profile-info .label {
  width: 60px;
  text-align: left;
}

.signup-container .profile-info .nick,
.signup-container .profile-info .birthdate,
.signup-container .profile-info .gender {
  display: flex;
  margin-top: 10px;
}


.signup-container .buttons {
  margin-top: 50px;
  width: 100vw;
  max-width: 500px;
  height: 100px;
  position: relative;
}

.signup-container .submit {
  margin-top: 30px;
  width: 100px;
  height: 40px;
  line-height: 40px;
  border-radius: 10px;
  background-color: var(--highlight-bg-color);
}

</style>