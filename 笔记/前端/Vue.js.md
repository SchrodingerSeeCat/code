# Vue

## 1. 环境搭建

1. 安装官方的脚手架工具`vue-cli`

   ```cmd
   # npm换淘宝源
   npm config set registry https://registry.npm.taobao.org
   npm install -g @vue/cli
   ```

2. 查看`vue-cli`的版本

   ```cmd
   vue --version
   ```

3. 创建项目

   ```cmd
   vue create vueProjectName
   ```

4. 启动项目

   ```
   cd vueProjectName
   npm run serve
   ```

vue项目目录详解

```
// 项目依赖包
node_modules

// 源代码文件
src
----assets // 静态资源目录
----components // 组件目录
----App.vue // 根主页
----main.ts // ts入口文件
----shims-vue.d.ts // 定义文件，类文件
----package.json   // node配置
```

`main.ts`

```typescript
import { createApp } from 'vue'
import App from './App.vue'

// 创建App组件并挂载
createApp(App).mount('#app')
```

## 2. 基础使用

`setup`和`ref`

```typescript
<template>
	<h2>欢迎来到王者荣耀</h2>
	<div>请选择你的英雄</div>
	<div>
		<button 
		v-for="(item, index) in heros" 
		v-bind:key="index"
		@click="selectHeroFun(index)"
	>
		{{index}} : {{item}}
	</button>
	</div>
	<div>你选择了【{{selectHero}}】英雄</div>
</template>

<script lang="ts">
import { defineComponent, ref } from 'vue';


export default defineComponent({
	name: 'App',
	setup() {
		const heros = ref(["干将莫邪", "张飞", "百里守约"])
		const selectHero = ref("")
		const selectHeroFun = (index: number)=>{
			// 如果需要获得某一变量或者修改某一变量值的时候需要添加value属性
			selectHero.value = heros.value[index]
		}
		return{
			heros,
			selectHero,
			selectHeroFun
		}
	}
});
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

```

`reactive`

```typescript
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

// reactive的使用
import {ref, reactive } from 'vue';
interface DataProps{
	heros: string[];
	selectHero: string;
	selectHeroFun: (index: number) => void;
}
export default {
	name: 'App',
	setup() {

		const data: DataProps = reactive({
			heros: ["干将莫邪", "张飞", "百里守约"],
			selectHero: "",
			selectHeroFun: (index: number)=>{
			// 如果需要获得某一变量或者修改某一变量值的时候需要添加value属性
				data.selectHero = data.heros[index]
			}
		})
		return{
			data
		}
	}
}
```

`...`

```typescript
<template>
	<h2>欢迎来到王者荣耀</h2>
	<div>请选择你的英雄</div>
	<div>
		<button 
			v-for="(item, index) in heros" 
			v-bind:key="index"
			@click="selectHeroFun(index)"
		>
			{{index}} : {{item}}
	</button>
	</div>
	<div>你选择了【{{selectHero}}】英雄</div>
</template>

<script lang="ts">

import {ref, reactive, toRefs } from 'vue';
interface DataProps{
	heros: string[];
	selectHero: string;
	selectHeroFun: (index: number) => void;
}
export default {
	name: 'App',
	setup() {

		const data: DataProps = reactive({
			heros: ["干将莫邪", "张飞", "百里守约"],
			selectHero: "",
			selectHeroFun: (index: number)=>{
			// 如果需要获得某一变量或者修改某一变量值的时候需要添加value属性
				data.selectHero = data.heros[index]
			}
		})

		const refData = toRefs(data)

		return{
			...refData
		}
	}
}
</script>
```

## 3. 生命周期和钩子函数

```typescript
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

```

