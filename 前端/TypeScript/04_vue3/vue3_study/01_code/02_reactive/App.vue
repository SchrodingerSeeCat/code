<template>
    <div>
        <h2>reactive的使用</h2>
        <h3>名字: {{user.name}}</h3>
        <h3>年龄: {{user.age}}</h3>
        <h3>媳妇: {{user.wife}}</h3>
        <button @click="updateUser">更新数据</button>
    </div>
    
</template>

<script lang="ts">
import { defineComponent, reactive } from 'vue';

export default defineComponent({
    name: 'App',

    /**
     * 作用：定义多个数据的响应式
     * const proxy = reactive(obj) 接受一个普通对象然后返回该对象的响应式代理器对象
     * 响应式转换是"深层的"：会影响对象内部所有嵌套的属性
     */
    setup() {

        // 返回一个Proxy的代理对象
        const user = reactive({
            name: '小明',
            age: 20,
            wife: {
                name: '迪丽热巴',
                age: 18,
                cars: ['奔驰', '宝马', '奥迪']
            }
        })

        const updateUser = () => {
            user.name = 'haha'
        }
        return {
            user,
            updateUser
        }
    }
});
</script>

<style>
</style>
