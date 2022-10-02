<template>
  <HeaderView/>
  <div class="result-container">
    <div class="result-title">
      당신의 전통주 취향은…
    </div>
    <div class="type-main">
      <span class="name prefer-type">
        <span class="nick">{{ profileData.profile?.nickname }}</span> 님은
      </span>
      <span class="person-type prefer-type">
        애호가
      </span>
      <span class="end prefer-type">
        형입니다.
      </span>
    </div>

    <div class="type-image">
      <img src="@/assets/images/soju.png" alt="like-soju">
    </div>

    <div class="graph">
      <canvas id="myChart" width="250" height="250"></canvas>
    </div>
 

    <div class="preferance">
      <div class="abst">
        깔끔한 맛을 좋아하는 당신!
      </div>
      <div class="sweet flavor">
        단 맛을 <span class="highlight">싫어</span>하고,
      </div>
      <div class="acidity flavor">
        신 맛을 <span class="highlight">좋아</span>하고,
      </div>
      <div class="proof flavor">
        도수가 <span class="highlight">높은</span> 술을 좋아합니다.
      </div>
    </div>
  </div>
</template>

<script setup>
import HeaderView from '../common/HeaderView.vue';
import { ref, onMounted ,computed } from "vue";
import { useStore } from "vuex";


// script
const store = useStore();
const profileData = computed(() => store.getters.profile)

onMounted(() => {
  store.dispatch("fetchProfile")

  // rader chart
  var ctx = document.getElementById('myChart').getContext('2d');

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
          2,4,5,3,4,
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
  
</style>