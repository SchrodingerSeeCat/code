<template>
    <div>
        <h2>toRefs的使用</h2>
        <h3>name: {{name}}</h3>
        <h3>age: {{age}}</h3>
    </div>
</template>
<script lang="ts">
import { defineComponent, reactive, toRefs } from 'vue'

/**
 * toRefs可以把一个响应式对象转换成普通对象，该普通对象的每个property都是一个ref
 */
export default defineComponent({

    setup() {
        const state = reactive({
            name: '自来也',
            age: 65
        })

        // 定时器，更新数据，(如果数据变化了，界面也会随之变化，肯定是响应式的数据)
        setInterval(() => {
            state.age += 1
        }, 1000)

        // 将state中的每一个属性都转换为响应式对象
        const state2 = toRefs(state)
        return{
            // ...state, // 不是响应式的数据
            ...state2
        }
    },
})
</script>
