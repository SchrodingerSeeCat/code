<template>
    <div>
        <h2>toRef的使用及特点</h2>
        <h3>state: {{state}}</h3>
        <h3>age: {{age}}</h3>
        <h3>money: {{money}}</h3>
        <hr />
        <button @click="update">更新数据</button>
    </div>
</template>
<script lang="ts">
import { defineComponent, reactive, toRef, ref } from 'vue'

/**
 * toRef是引用对象中某个值
 * ref是拷贝对象中的某个属性
 */
export default defineComponent({
    name: "App",

    setup() {
        const state = reactive({
            age: 5,
            money: 100
        })

        // 把响应式数据state对象中的某个属性age变成了ref对象
        const age = toRef(state, 'age')

        // 把响应式对象中的某个属性使用ref进行包装，变成了一个ref对象
        const money = ref(state.money)

        const update = () => {
            // 更新数据
            state.age += 2
            state.money += 3
        }
        return {
            state,
            age,
            money,
            update
        }
    }
})
</script>
