<template>
    <router-view></router-view>
</template>

<script lang="ts">
import { defineComponent, ref } from 'vue'

export default defineComponent({
    name: 'App',
    components: {
    },
    setup() {
        const loginMsg = ref("登陆")
        const isLogin = ref(false)
        const userName = ref("")
        const password = ref("")

        // 登陆对话框
        const dialogVisible = ref(false)
        return {
            loginMsg,
            isLogin,
            dialogVisible,
            userName,
            password
        }
    }
})
</script>

<style scoped>

</style>
