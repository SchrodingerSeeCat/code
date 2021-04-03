<template>
    <h2 :style="{color}">GrandSon孙子组件</h2>
</template>

<script>
import { defineComponent, inject } from "vue";

export default defineComponent({
    name: "GrandSon",

    // 注入inject
    setup() {
        const color = inject('color')
        return {
            color
        }
    }
})
</script>

<style>

</style>