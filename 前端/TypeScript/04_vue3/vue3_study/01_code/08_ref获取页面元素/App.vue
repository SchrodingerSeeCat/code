<template>
    <div>
        <h2>ref获取页面元素</h2>
        <input type="text" ref="inputRef">
    </div>
</template>
<script lang="ts">
import { defineComponent, onMounted, ref } from 'vue'

/**
 * toRefs可以把一个响应式对象转换成普通对象，该普通对象的每个property都是一个ref
 */
export default defineComponent({
    name: "App",

    // 当页面加载完毕后，页面中的文本可以直接获取焦点
    setup() {
        const inputRef = ref<HTMLElement | null>(null)

        onMounted(() => {
            if (inputRef.value) {
                inputRef.value.focus() // 自动获取焦点
            }
        })
        return {
            inputRef
        }
    }
})
</script>
