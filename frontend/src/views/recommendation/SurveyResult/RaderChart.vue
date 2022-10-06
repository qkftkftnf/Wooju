<template>
    <div class="graph">
      <canvas id="myChart" width="250" height="250"></canvas>
    </div>
</template>

<script setup>
import { ref, onMounted, } from "vue";

const props = defineProps({
  analysis: Object,
})


onMounted(() => {
  var ctx = document.getElementById('myChart').getContext('2d');
  
  var myChart = new Chart(ctx, {
    type: "radar",
    data: {
      labels: props.analysis.labels,
      datasets: [{
        label: ' ',
        data: props.analysis.data,
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