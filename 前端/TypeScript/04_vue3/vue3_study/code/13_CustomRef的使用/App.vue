<template>
    <div>
        <h2>CustomRef的使用</h2>
        <input type="text" v-model="keyword">
        <p>{{keyword}}</p>
    </div>
</template>
<script lang="ts">
import { customRef, defineComponent } from 'vue'

// 自定义hook防抖的函数
// value的类型不确定，delay为防抖的间隔时间 ms
function useDebounceRef<T>(value: T, delay=200) {
    // 准备一个存储定时器的id的变量
    let timeOutId: number
    return customRef((track, trigger) => {
        return {
            // 返回数据
            get() {
                // 告诉vue追踪数据
                track()
                return value
            },

            // 设置数据
            set(val: T) {
                // 清理定时器
                clearTimeout(timeOutId)
                // 开启一个定时器
                timeOutId = setTimeout(() => {
                    value = val
                    // 告诉vue更新页面
                    trigger()
                }, delay)
            }
        }
    })
}

export default defineComponent({
    name: "App",

    // 需求实现在input中修改后，p等待一段时间后再渲染
    setup() {
        
        const keyword = useDebounceRef('abc', 1000)
        return {
            keyword
        }
    }
})
</script>
