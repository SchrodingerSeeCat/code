<template>
    <h2>App父级组件: Suspense组件的使用</h2>
    <Suspense>
        <!-- 异步组件 -->
        <template #default>
            <!-- <AsyncComponent /> -->
            <AsyncAddress />
        </template>
        <!-- 异步组件未加载时默认显示的内容 -->
        <template v-slot:fallback>
            loading....
        </template>
    </Suspense>
</template>
<script lang="ts">
import { defineAsyncComponent, defineComponent } from 'vue'
// 引入组件：静态引入和动态引入

// vue2动态引入, vue3已弃用
// const AsyncComponent = () => import('./AsyncComponent.vue')

// vue3动态引入
// const AsyncComponent = defineAsyncComponent(() => import('./components/AsyncComponent.vue'))

import AsyncAddress from './components/AsyncAddress.vue'
import AsyncComponent from './components/AsyncComponent.vue'
export default defineComponent({
    name: "App",
    components: {
        // AsyncComponent,
        AsyncAddress
    }
})
</script>
