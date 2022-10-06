<template>
  <HeaderView/>
  <div class="result-container">
    <div class="result-title">
      <span class="nick">당신의 전통주 취향</span>은<br/>
    </div>
    <TypeMak v-if="recommData.usertype?.type == 1"/>
    <TypeSommelier v-if="recommData.usertype?.type == 2"/>
    <TypeExpert v-if="recommData.usertype?.type == 3"/>
    <TypeSparkle v-if="recommData.usertype?.type == 4"/>
    <TypeParty v-if="recommData.usertype?.type == 5"/>
    <TypeWizard v-if="recommData.usertype?.type == 6"/>
    <TypeExplorer v-if="recommData.usertype?.type == 7"/>
    <TypeCritics v-if="recommData.usertype?.type == 8"/>


    <div class="graph">
      <canvas id="myChart" width="250" height="250"></canvas>
    </div>

    <div class="preferance">
      <div class="sweet flavor">
        술의 단 맛을 <span class="highlight">좋아</span>하고,
      </div>
      <div class="proof flavor">
        술의 신 맛을 <span class="highlight">싫어</span>합니다.
      </div>
    </div>

    <div class="recommends rec-type">
      <div class="result-intro">
        아마 이 전통주들이 취향에 <span>딱</span> 맞을 거예요.
      </div>
      <div class="bottles">
      <div class="bottle-card" v-for="product in 3">
        <div class="bottle-img">
          <img src="@/assets/images/pic1.jpg" alt="bottle">
        </div>
        <div class="bottle-content">
          <div class="bottle-title cl-ellipsis">
            product.name
          </div>
          <div class="bottle-intro">
            product.alcohol%
          </div>
        </div>
      </div>
    </div>

    </div>
  </div>
</template>

<script setup>
import HeaderView from '../common/HeaderView.vue';
import TypeCritics from './SurveyResult/TypeCritics.vue';
import TypeExplorer from './SurveyResult/TypeExplorer.vue';
import TypeMak from './SurveyResult/TypeMak.vue';
import TypeParty from './SurveyResult/TypeParty.vue';
import TypeSommelier from './SurveyResult/TypeSommelier.vue';
import TypeSparkle from './SurveyResult/TypeSparkle.vue';
import TypeExpert from './SurveyResult/TypeExpert.vue';
import TypeWizard from './SurveyResult/TypeWizard.vue';

import { ref, onMounted ,computed } from "vue";
import { useStore } from "vuex";

const store = useStore();
const recommData = computed(() => store.getters.recommendation)
onMounted(() => {
  const type = ref(false)
  store.dispatch("fetchRecommendationResult")

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
          5,2,3,5,2,
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