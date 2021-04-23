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
    .el-menu-demo {
        position: relative;
    }
    .login-container{
        position: absolute;
        right: 0;
    }
    .logo {
        height: 61px;
        float: left;
    }
    .account{
        margin: 0 auto;
        width: 60%;
    }
    .github-img {
        float: right;
        position: relative;
    }
    .github-img img {
        width: 32px;
        position: absolute;
        right: 10px;
    }
    .username {
        margin-bottom: 12px;
    }
    .login {
        width: 150px;
        position: relative;
        top: -20px;
    }
</style>
