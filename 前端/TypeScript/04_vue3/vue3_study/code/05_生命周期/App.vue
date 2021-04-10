<template>
    <div>
        <h2>父级组件</h2>
        <button @click="isShow = !isShow">切换显示</button>
        <hr />
        <Child v-if="isShow"/>
    </div>
    
</template>

<script lang="ts">
import { defineComponent, ref } from 'vue';
import Child from './components/Child.vue'

export default defineComponent({
    name: 'App',
    components: {
        Child
    },
    setup() {
        const isShow = ref(true)
        return {
            isShow
        }
    }
});
</script>

<style>
</style>
