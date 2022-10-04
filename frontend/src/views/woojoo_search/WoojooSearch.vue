<template>
  <div class="container pt-60">
    <HeaderView />
    <div class="search-container">
      <div class="category-title">종류로 찾기</div>
      <div class="search-checkbox-group">
        <input type="checkbox" id="types-tak"  value="탁주" v-model="searchInfo.types" class="search-checkbox">
        <label for="types-tak">
          <img class="checkbox-img" src="@/assets/images/tak.svg" alt="">
        </label>
        <input type="checkbox" id="types-fruit"  value="약주, 과실주" v-model="searchInfo.types" class="search-checkbox">
        <label for="types-fruit">
          <img class="checkbox-img" src="@/assets/images/fruit.svg" alt="">
        </label>
        <input type="checkbox" id="types-soju"  value="소주" v-model="searchInfo.types" class="search-checkbox">
        <label for="types-soju">
          <img class="checkbox-img" src="@/assets/images/soju.svg" alt="">
        </label>
      </div>
      <div class="search-alcohol">
        도수
        <input v-model="searchInfo.alcohol" type="number">
        이하인 술만 검색
      </div>
      <div>
        수상여부
        <input type="checkbox" id="check-award" v-model="searchInfo.award" class="search-checkbox">
      </div>
      <div>
        검색어
        <input type="text" v-model="searchInfo.search">
      </div>
    </div>
    <button class="search-button" @click="searchProducts">검색</button>
  </div>
  <div class="tab-template container">

    <div class="products-list">
      <div class="products-list-box" v-for="product in products.items" v-if="isProductLoad">
        <div class="image">
          <img :src="product.image" alt="">
          <span class="like">
            <i class="fas fa-heart heart"></i> 73
          </span>
        </div>
        <div class="content">
          <p class="product-name">{{ product.name }}</p>
          <p>도수: <span class="product-alcohol">{{ product.alcohol }}%</span></p>
          <p>용량: <span class="product-volume">{{ product.volume }}</span></p>
          <p class="product-price">가격: {{ product.price }}원</p>
        </div>
      </div>
      <el-pagination layout="prev, pager, next"
      :current-page="searchInfo.page"
      @current-change="changePage"
      :total="products.total" />
    </div>
  </div>
</template>

<script setup>
import HeaderView from "@/views/common/HeaderView.vue"
import ModeToggle from "@/views/common/ModeToggle.vue"
import { ref, onMounted, computed } from "vue";
import { useRouter, useRoute } from "vue-router";
import { useStore } from "vuex"

const router = useRoute();
const store = useStore();
const position = ref(0);
const products = computed(() => store.getters.products)
const isProductLoad = computed(() => store.getters.isProductLoad)
const searchInfo = ref({
  alcohol: 100,
  award: false,
  page: 1,
  size: 10,
  types: [],
  search: ""
})
const searchProducts = () => {
  console.log(searchInfo.value)
  store.dispatch('fetchProducts', searchInfo.value)
}
const changePage = (page) => {
  searchInfo.value.page = page
  searchProducts()
}

// const setType = (type) => {
//   if (type in searchInfo.value.types) {

//   }
// }



store.dispatch('fetchProducts', searchInfo.value)
const productsData = computed(() => store.getters.products);

onMounted(() => {
  const innerContainer = document.getElementsByClassName("inner-container")
  window.onscroll = function () { scrollInnerHeader() };

  function scrollInnerHeader() {
    position.value = innerContainer[0].getBoundingClientRect()

    if (position.value.top < 60) {
      document.querySelector(".tab-header .tab-title").style.top = "0";
      document.querySelector(".tab-header").style.boxShadow = "0px 4px 6px 6px rgba(0, 0, 0, 0.05)";
    } else {
      document.querySelector(".tab-header").style.boxShadow = "0px 4px 6px 6px rgba(0, 0, 0, 0.0)";
      document.querySelector(".tab-header .tab-title").style.top = `${50 * (position.value.top / 450)}px`;
      document.querySelector(".tab-header .tab-title").style.fontSize = `${1.2 + position.value.top / 450}rem`;
      document.querySelector(".header-content .search-container").style.opacity = `${((position.value.top - 260) / 200)}`;
      document.querySelector(".header-content .search-container").style.scale = `${((position.value.top - 60) / 390)}`;
    }
  }
})  
</script>

<style>
.search-container .category-list {
  display: flex;
  padding: 0 20px 0 20px;
}

.search-container .checkbox-img {
  width: 130px;
}

.products-list {
  margin-bottom: 30px;
  padding-bottom: 15px;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
  background: var(--main-bg-color);
}

.products-list .products-list-box {
  width: 170px;
  height: 350px;
  padding: 5px;
  margin: 10px 0px 10px 0px;
  text-align: left;
}

.products-list .products-list-box .product-name {
  text-align: center;
  font-size: 1.2rem;
  font-weight: bold;
}

.products-list .products-list-box .product-alcohol {
  font-weight: bold;
}

.products-list .products-list-box .product-alcohol {
  font-size: 0.9rem;
}

.products-list .el-pagination {
  --el-pagination-button-disabled-bg-color: var(--main-bg-color);
  --el-pagination-bg-color: var(--main-bg-color);
}
</style>