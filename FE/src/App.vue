<script setup>
import { RouterLink, RouterView } from 'vue-router'
import Customer from './pages/customer.vue';
</script>

<template>
  <!-- <header>

    <div class="wrapper">

      <nav>
        <RouterLink to="/">Home</RouterLink> -->
        <!-- <RouterLink to="/about">About</RouterLink> -->
      <!-- </nav>
    </div>
  </header>

  <RouterView /> -->
  <Customer/>
</template>

<style>
body{
  margin: 0;
}
</style>