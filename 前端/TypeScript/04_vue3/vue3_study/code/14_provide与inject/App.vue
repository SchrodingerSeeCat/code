<template>
    <h2>provide与inject</h2>
    <p>当前的颜色：{{color}}</p>
    <button @click="red">红色</button>
    <button @click="blue">蓝色</button>
    <button @click="green">绿色</button>

    <hr/>
    <Son />
</template>
<script lang="ts">
import { defineComponent, provide, ref } from 'vue'
import Son from './components/Son.vue'

export default defineComponent({
    name: "App",

    components: {
        Son
    },
    setup() {

        const color = ref('red')

        // 提供数据
        provide('color', color)

        const red = () => {
            color.value = "red" 
        }

        const blue = () => {
            color.value = "blue" 
        }

        const green = () => {
            color.value = "green" 
        }
        return {
            color,
            red,
            blue,
            green
        }
    }
})
</script>
