<template>
    <div>
        <h2>自定义hook函数</h2>
        <h3>x: {{x}}  y: {{y}}</h3>
        <h3 v-if="loading">正在加载中。。。</h3>
        <h3 v-else-if="error">错误信息：{{error}}</h3>
        <ul v-else>
            <li>id: {{data.id}}</li>
            <li>address: {{data.address}}</li>
            <li>distance: {{data.distance}}</li>
        </ul>
        <hr />
        <ul v-for="item in data" :key="item.id">
            <li>id: {{item.id}}</li>
            <li>title: {{item.title}}</li>
            <li>price: {{item.price}}</li>
        </ul>
    </div>
    
</template>

<script lang="ts">
import { defineComponent, watch } from 'vue';
import useMousePositon from './hooks/useMousePosition'
import useRequest from './hooks/useRequest'

// 定义接口，约束对象的类型
interface AddressData{
    id: number,
    address: string,
    distance: string
}

interface ProductsData{
    id: string,
    title: string,
    price: number
}
export default defineComponent({
    name: 'App',
    // 用户在页面中点击页面，把点击的位置横纵坐标收集起来并展示出来
    setup() {
        
        const {x, y} = useMousePositon()
        // 发送请求
        // const {loading, data, error} = useRequest<AddressData>('/data/address.json') // 对象数据
        const {loading, data, error} = useRequest<ProductsData[]>('/data/products.json')

        // 监视
        watch(data, () => {
            if (data.value) {
                console.log(data.value.length)
            }
        })
        return {
            x,
            y,
            loading,
            data,
            error
        }
    }
});
</script>

<style>
</style>
