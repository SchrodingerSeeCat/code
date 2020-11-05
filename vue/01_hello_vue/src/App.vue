<template>
	<h2>欢迎来到王者荣耀</h2>
	<div>请选择你的英雄</div>
	<div>
		<button 
			v-for="(item, index) in data.heros" 
			v-bind:key="index"
			@click="data.selectHeroFun(index)"
		>
			{{index}} : {{item}}
	</button>
	</div>
	<div>你选择了【{{data.selectHero}}】英雄</div>
</template>

<script lang="ts">

// 第一种方式
// import {defineComponent, ref, reactive } from 'vue';
// export default defineComponent({
// 	name: 'App',
// 	setup() {
// 		const heros = ref(["干将莫邪", "张飞", "百里守约"])
// 		const selectHero = ref("")
// 		const selectHeroFun = (index: number)=>{
// 			// 如果需要获得某一变量或者修改某一变量值的时候需要添加value属性
// 			selectHero.value = heros.value[index]
// 		}
// 		return{
// 			heros,
// 			selectHero,
// 			selectHeroFun
// 		}
// 	}
// });


// 第二种方式
// reactive的使用
// import {ref, reactive} from 'vue';
// interface DataProps{
// 	heros: string[];
// 	selectHero: string;
// 	selectHeroFun: (index: number) => void;
// }
// export default {
// 	name: 'App',
// 	setup() {

// 		const data: DataProps = reactive({
// 			heros: ["干将莫邪", "张飞", "百里守约"],
// 			selectHero: "",
// 			selectHeroFun: (index: number)=>{
// 			// 如果需要获得某一变量或者修改某一变量值的时候需要添加value属性
// 				data.selectHero = data.heros[index]
// 			}
// 		})
		
// 		return{
// 			data
// 		}
// 	}
// }


// 第三种方式
// reactive的使用
// import {ref, reactive, toRefs } from "vue";
// interface DataProps{
// 	heros: string[];
// 	selectHero: string;
// 	selectHeroFun: (index: number) => void;
// }
// export default {
// 	name: 'App',
// 	setup() {

// 		const data: DataProps = reactive({
// 			heros: ["干将莫邪", "张飞", "百里守约"],
// 			selectHero: "",
// 			selectHeroFun: (index: number)=>{
// 			// 如果需要获得某一变量或者修改某一变量值的时候需要添加value属性
// 				data.selectHero = data.heros[index]
// 			}
// 		})

// 		const refData = toRefs(data)

// 		return{
// 			...refData
// 		}
// 	}
// }


// 钩子函数
import {ref, reactive, onBeforeMount, onMounted, onBeforeUpdate, onUpdated } from 'vue';
interface DataProps{
	heros: string[];
	selectHero: string;
	selectHeroFun: (index: number) => void;
}
export default {
	name: 'App',
	setup() {

		console.log("1-开始创建组件----setup()")

		const data: DataProps = reactive({
			heros: ["干将莫邪", "张飞", "百里守约"],
			selectHero: "",
			selectHeroFun: (index: number)=>{
			// 如果需要获得某一变量或者修改某一变量值的时候需要添加value属性
				data.selectHero = data.heros[index]
			}
		})
		
		onBeforeMount(()=>{
			console.log("2-组件挂载之前执行----onBeforeMount()")
		})

		onMounted(()=>{
			console.log("3-组件挂载之后执行----onMounted()")
		})

		onBeforeUpdate(()=> {
			console.log("4-组件更新之前执行----onBeforeUpdate()")
		})

		onUpdated(()=> {
			console.log("5-组件更新之后执行----OnUpdated()")
		})
		return{
			data
		}
	}
}

</script>

<style>
#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
}
</style>
