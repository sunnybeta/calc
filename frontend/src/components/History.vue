<template>

<section class="history" :class="{ 'history-animation' : state}">
	<ul @click="offState">
		<li v-for="computation in props.computations">
			<div class="expression">
				{{ computation.expression }}
			</div>
			<div class="answer">
				= {{ computation.answer }}
			</div>
		</li>
	</ul>
	<div @click="animate" class="toggle-history">
		v
	</div>
</section>

</template>

<script setup lang="ts">
	import { ref }  from 'vue'

	interface IComputation {
		expression: string,
		answer: number,
	}
	const state = ref(false);

	function animate() {
		state.value = state.value ? false : true;
	}

	function offState() {
		if (state.value == true)
			state.value = false;
	}

	const props = defineProps({
		computations: Array<IComputation>,
	})
</script>

<style scoped>

.history{
	position: absolute;
	background-color: var(--history);
	z-index: 20;
	border-radius: 2rem;
	border-bottom-right-radius: 0;
	width: 600px;
	height: 800px;
	transform: translateY(-550px);
}

.answer{
	text-align: right;
	font-size: 3.5rem;
}

.expression{
	text-align: right;
	font-size: 2.5rem;
}

ul{
	position: absolute;
	margin-right: 2rem;
	list-style-type: none;
	bottom: 0;
	right: 0;
}

ul li{
	padding: 4.5rem 0;
}

.toggle-history{
	display: flex;
	align-items: center;
	justify-content: center;
	position: absolute;
	bottom: -100px;
	right: 0px;
	background-color: var(--history);
	z-index: 30;
	border-radius: 0;
	border-bottom-left-radius: 5rem;
	border-bottom-right-radius: 5rem;
	font-size: 3rem;
	height: 100px;
	width: 150px;
	cursor: pointer;
	color: black;
}

.toggle-history:hover{
	background-color: inherit;
	font-weight: bold;
}

.history-animation{
	animation-name: his-full;
	animation-duration: 0.4s;
	animation-fill-mode: both;
}

@keyframes his-full{
	from{
		transform: translateY(-550px);
	}
	to {
		transform: translateY(0px);
	}
}

</style>
