<template>

	<section class='numeric'>
		<div class='button-row'>
			<Button data="7"/>
			<Button data="8"/>
			<Button data="9"/>
			<Button data=" " class="noeffect"/>
		</div>
		<div class='button-row'>
			<Button data="4"/>
			<Button data="5"/>
			<Button data="6"/>
			<Button data=" " class="noeffect"/>
		</div>
		<div class='button-row'>
			<Button data="1"/>
			<Button data="2"/>
			<Button data="3"/>
			<Button data="ANS" id="ans"/>
		</div>
		<div class='button-row'>
			<Button data="CE" id="delete" />
			<Button data="0" />
			<Button data="." />
			<Button data="=" id="equals" />
		</div>
		<div class='button-row'>
			<Button data="÷" class="operator" />
			<Button data="×" class="operator" />
			<Button data="-" class="operator" />
			<Button data="+" class="operator" />
		</div>
	</section>

</template>

<script lang="ts">

import Button from './Button.vue';

export default {
	components: { Button }
}

</script>

<style scoped>

#equals:hover{
	background-color: lightgreen;
}

#ans:hover{
	background-color: lightpink;
}

#delete:hover{
	background-color: lightcoral;
}

.numeric{
	position: absolute;
	border-radius: 2rem;
	width: 600px;
	height: 800px;
	background-color: var(--numeric);
	z-index: 10;
	padding-top: 250px;
}

.numeric .button-row{
	display: flex;
	align-items: center;
	justify-content: center;
	padding: 5px;
}

.numeric .button-row .button:hover{
	background-color: lightgrey;
	cursor:pointer;
	transition-duration: 150ms;
	font-weight: bold;
}

.numeric .button-row .operator:hover{
	background-color: lightblue;
}

.numeric .button-row .toggle-scientific{
	background-color: lightgrey;
	border-radius: 0;
	border-top-left-radius: 5rem;
	border-bottom-left-radius: 5rem;
}

.numeric .button-row .noeffect:hover{
	background-color: inherit;
	cursor: default;
}

</style>
