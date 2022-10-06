<template>
  <!-- <div class="preferance-container mypage-inner add">
   
  </div> -->
  <div class="detail-content">
    <div class="woojoo-text">
      "{{woojooInfo.object?.subtext}}"
    </div>
    <!-- <div>
      <img class="content-img" :src="woojooInfo.object?.image" alt="">
    </div> -->
    <div class="wooju">
      <span class="wooju-name">술 이름 : </span>
      {{woojooInfo.object?.name}}
    </div>
    <div class="degree">
      <span class="wooju-alcohol">도수 :  </span>
      <i class="alcohol"></i> {{woojooInfo.object?.alcohol}}%
    </div>
    <div class="degree">
      <span class="wooju-alcohol">용량 :  </span>
      <i class="alcohol"></i> {{woojooInfo.object?.volume}}
    </div>
    <div class="rate">
      <span class="price">가격 :</span>
      {{woojooInfo.object?.price}}원
    </div>
    <p class="detail-text">
      {{woojooInfo.object?.award}}
    </p>

    <div class="graph">
      <canvas id="productChart" width="250" height="250"></canvas>
    </div>

    <div class="title">
      어울리는 음식
    </div>
    <div class="fitfood-container">
      <div v-for="food in woojooInfo.object?.foods">
        <div class="fitfood-box">
          <div class="food-img">
            <img :src="food.img" alt="">
          </div>
          <div class="food-name">
            {{food.name}}
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useStore } from "vuex"; 
import { ref, computed, onMounted } from "vue";

const store = useStore();
const woojooInfo = computed(() => store.getters.woojooInfo);


onMounted(() => {

  // rader chart
  var ctx = document.getElementById('productChart').getContext('2d');

  var myChart = new Chart(ctx, {
    type: "radar",
    data: {
      labels: [
        '단맛',
        '신맛',
        '바디감',
        '탄산',
        '풍미',
      ],
      datasets: [{
        label: ' ',
        data: [
          2,4,5,4,3
        ],
        fill: true,
        backgroundColor: 'rgba(255, 99, 132, 0.2)',
        borderColor: 'rgb(255, 99, 132)',
        pointBackgroundColor: 'rgb(255, 99, 132)',
        pointBorderColor: '#fff',
        pointHoverBackgroundColor: '#fff',
        pointHoverBorderColor: 'rgb(255, 99, 132)'
      }]
    },
    options: {
      responsive: false,
      maintainAspectRatio: true,
      elements: {
        line: {
          borderWidth: 3
        }
      },
      scale: {
        ticks: {
            beginAtZero: true,
            max: 5,
            min: 0,
        }
      },
      legend: {
        display: false
      }
    },
  })
})

</script>

<style>
.detail-content .rate {
  font-size: 1.5rem;
  font-weight: 200;
  color: #a4a4a4;
}

.price {
  font-size: 1.5rem;
    font-weight: 200;
    color: #a4a4a4;
}
  
.add {
  height: 0px !important;
}

.woojoo-text {
  text-align: center;
  font-size: 1.4rem;
  margin: 30px 0px 60px 0px;
}

.title {
  margin-top: 50px;
  margin-bottom: 30px;
  text-align: center;
}

.fitfood-container {
  display: flex;
  margin-bottom: 50px;
  flex-flow: row;
}

.fitfood-box {
  width: 120px;
  margin: 0px;
}

.food-name {
  text-align: center;
}
.food-img {
  width: 100px;
}
</style>