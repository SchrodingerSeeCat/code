<template>
    <div>
        <h2>toRaw和markRaw</h2>
        <h3>state: {{state}}</h3>
        <button @click="testToRaw">测试toRaw</button>
        <button @click="testMarkRaw">测试markRaw</button>
    </div>
</template>
<script lang="ts">
import { defineComponent, markRaw, reactive, toRaw } from 'vue'

/**
 * 通过接口来约束state
 */
interface User{
    name: string,
    age: number,
    likes?: string[]
}
export default defineComponent({
    name: "App",

    setup() {
        const state = reactive<User>({
            name: '小明',
            age: 20
        })

        const testToRaw = () => {
            // 将代理对象变为普通对象
            const user = toRaw(state)
            user.name += "=="
        }

        const testMarkRaw = () => {
            // 默认新添加的属性也是响应式的
            // state.likes = ["吃", "喝"]
            // state.likes[0] += "--"

            const likes = ["吃", "喝"]

            // markRaw标记的对象数据，从此以后都不能再成为代理对象
            state.likes = markRaw(likes)
            setInterval (() => {
                if (state.likes) {
                    // 数据不可更改
                    state.likes[0] += "--"
                    console.log("定时器走起来了")
                }
            }, 1000)
        }

        return {
            state,
            testToRaw,
            testMarkRaw
        }
    }
})
</script>
