<template>
  <HeaderView/>
  <div class="signup-container">
    <div class="title">
      회원 가입
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
          닉네임
          <el-input type="text" class="edit-nickname" v-model="signupInfo.nickname"/>
        </div>
        <div class="birthdate">
          생일
          <el-input type="date" class="edit-nickname" v-model="signupInfo.birthdate"/>
        </div>
        <div class="gender">
          성별
          <el-radio-group v-model="signupInfo.gender">
            <el-radio label="M" />
            <el-radio label="F" />
          </el-radio-group>
        </div>
        <div class="submit" @click="onSubmit">
          회원 가입
        </div>
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
const signupInfo = ref({
  "birthdate": "",
  "email": route.query.email,
  "gender": "",
  "img": "",
  "nickname": "",
  "usertype": route.query.usertype,
})
console.log(signupInfo)

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
  signupInfo.value.img = 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTJgdkzZiGruJOVzqaKOz091hE2lkNHq8b4jPIdJdxaVw&s'
  http.post("/user/signup", signupInfo.value)
    .then(({ data }) => {
      console.log(data)
      // router push to main page
    })
    .catch((err) => console.log(err))
}

</script>

<style>
  .signup-container {
  margin-top: 60px;
  width: 100vw;
  max-width: 500px;
  height: calc(100vh - 130px);
  position: relative;
}

.signup-container .title {
  padding: 40px 0 50px 0;
  font-size: 1.4rem;
  font-weight: 600;
}

.signup-container .avatar {
  position: relative;
}

.signup-container .avatar .pic {
  width: 150px;
  height: 150px;
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
  margin: 0 auto;
  width: 250px;
  height: 100px;
}

.signup-container .buttons {
  margin-top: 50px;
  width: 100vw;
  max-width: 500px;
  height: 100px;
  position: relative;
}

.signup-container .submit {
  margin-top: 40px;
  width: 100px;
  height: 40px;
  line-height: 40px;
  border-radius: 10px;
  background-color: var(--highlight-bg-color);
}

</style>