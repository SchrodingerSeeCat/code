<template>
    <h2>Teleport</h2>
    <button @click="modalOpen = true">打开对话框</button>

    <Teleport to="body">
        <div v-if="modalOpen">
            这是对话框<br />
            <button @click="modalOpen = false">关闭对话框</button>
        </div>
    </Teleport>
</template>
<script lang="ts">
import { defineComponent, ref } from 'vue'

// Teleport中包裹的代码会被渲染到指定的标签中
export default defineComponent({
    name: "App",

    setup() {
        const modalOpen = ref(false)
        return {
            modalOpen
        }
    }
})
</script>
