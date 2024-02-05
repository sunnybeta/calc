<template>

<div class="button">{{data}}</div>

</template>

<script lang="ts">
	export default {
		props: ["data"],
	}
</script>

<style scoped>

.button{
	display: flex;
	align-items: center;
	justify-content: center;
	width: 150px;
	height: 100px;
	font-size: 3rem;
	border-radius: 2rem;
}

</style>
