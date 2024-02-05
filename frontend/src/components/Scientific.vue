<template>

<section class="scientific" :class="{ 'scientific-animation' : state}">
	<div @click="animate" class="toggle-scientific">
		v
	</div>
	<div id="keypad" @click="offState">
		<div class="button-row">
			<Button data="Inv" />
			<Button data="Deg" />
			<Button data="%" />
		</div>
		<div class="button-row">
			<Button data="sin" />
			<Button data="cos" />
			<Button data="tan" />
		</div>
		<div class="button-row">
			<Button data="ln" />
			<Button data="log" />
			<Button data="!" />
		</div>
		<div class="button-row">
			<Button data="π" />
			<Button data="e" />
			<Button data="^" />
		</div>
		<div class="button-row">
			<Button data="(" />
			<Button data=")" />
			<Button data="√" />
		</div>
	</div>
</section>

</template>

<script setup lang="ts">
	import { ref } from 'vue';
	import Button from './Button.vue';

	const state = ref(false);

	function animate() {
		state.value = state.value ? false : true;
	}

	function offState() {
		if (state.value == true)
			state.value = false;
	}
</script>

<style scoped>

.scientific{
	position: absolute;
	bottom: 0;
	height: 555px;
	width: 450px;
	z-index: 20;
	border-radius: 2rem;
	background-color: var(--scientific);
	transform: translateX(600px);
}

.scientific .button-row{
	display: flex;
	align-items: center;
	justify-content: center;
	padding: 5px;
}

.scientific .button-row .effect{
	background-color: transparent;
}
.scientific .button-row .button:hover{
	background-color: var(--numeric);
	cursor:pointer;
	transition-duration: 150ms;
	font-weight: bold;
}

.scientific .button-row .noeffect:hover{
	background-color: inherit;
	cursor: default;
}


.toggle-scientific{
	display: flex;
	align-items: center;
	justify-content: center;
	position: absolute;
	left: -150px;
	bottom: 335px;
	background-color: var(--scientific);
	z-index: 20;
	border-radius: 0;
	border-top-left-radius: 5rem;
	border-bottom-left-radius: 5rem;
	font-size: 3rem;
	height: 100px;
	width: 150px;
	cursor: pointer;
	color: black;
}

.toggle-scientific:hover{
	font-weight: bold;
	z-index: 40;
}

.scientific-animation{
	animation-name: sci-full;
	animation-duration: 0.5s;
	animation-fill-mode: both;
	z-index: 40;
}


@keyframes sci-full{
	from{
		transform: translateX(600px);
	}
	to {
		transform: translateX(150px);
	}
}

</style>
