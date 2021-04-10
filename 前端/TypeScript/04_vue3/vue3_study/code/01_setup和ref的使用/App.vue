<template>
    <div>
        <h2>setup和ref的使用</h2>
        <h1>{{count}}</h1>
        <button @click="updateCount">更新数据</button>
    </div>
    
</template>

<script lang="ts">
import { defineComponent, ref } from 'vue';

export default defineComponent({
    name: 'App',
    setup() {

        // 定义一个响应式的数据, 返回一个Ref对象,可以通过value属性拿到值
        // 但在html的模板中不需要使用.value获取属性
        const count = ref(10)
        // 更新number的方法
        function updateCount() {
            count.value++
        }
        return {
            count: count,
            updateCount
        }
    }
});
</script>

<style>
</style>
