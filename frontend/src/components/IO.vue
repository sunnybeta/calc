<script lang="ts">
	export default {
		data() {
			return {
				expression: '',
				answer: 0,
			}
		},
		methods: {
			async evaluate() {
				const url = "http://localhost:8080/eval"
				const response = await fetch(url, {
					method: "POST",
					headers: {
						"Content-Type": "application/json"
					},
					body: JSON.stringify({expression: this.expression})
				})
				const res = await response.json()
				this.answer = res.data;
			}
		}
	}
</script>

<template>
	<section>
		<input
			v-model='expression'
			type="text"
			placeholder="Expression ..."
			@keydown.enter="evaluate"
		/>
		<br/>
		<button @click="evaluate">Evaluate</button>
		<br/>
		<div class="answer">
			{{answer}}
		</div>
	</section>
</template>

<style scoped>
	section{
		margin-top: 17%;
		text-align: center;
		width: 50%;
	}
	input{
		width: 80%;
		border-radius: 1rem;
		padding: 1rem;
		outline: none;
		font-size: 1.3rem;
	}
	button{
		text-transform: uppercase;
		background-color: white;
		color: black;
		border-radius: 1rem;
		margin: 1rem 0;
		padding: 0.5rem;
	}
	.answer {
		font-size: 2rem;
	}
</style>
