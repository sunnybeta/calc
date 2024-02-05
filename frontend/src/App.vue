<template>

<main class='box'>
	<section class='container'>
		<Numeric />
		<Scientific />
		<History :computations='[{expression:"1+1", answer: 2}, {expression: "99 * 99", answer: 9801}]' />
	</section>
</main>

</template>

<script setup lang="ts">
import Numeric from './components/Numeric.vue'
import History from './components/History.vue'
import Scientific from './components/Scientific.vue'
</script>

<style scoped>

.box{
	display: flex;
	justify-content: center;
}

.container{
	position: fixed;
	top: 10%;
	border-radius: 2rem;
	box-shadow: 0 0 20px black;
	width: 600px;
	height: 800px;
	overflow: hidden;
}

</style>
