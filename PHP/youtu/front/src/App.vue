<template>
    <el-menu
        class="el-menu-demo"
        mode="horizontal">
        <router-link to="/">
            <img class="logo" src="./assets/logo.png" alt="logo">
        </router-link>
        <el-menu-item index="1">动漫</el-menu-item>
        <el-menu-item index="2">风景</el-menu-item>
        <el-menu-item index="3">生活</el-menu-item>

        <el-submenu index="4" class="login-container">
            <template #title>{{loginMsg}}</template>
            <el-menu-item index="4-1" v-if="isLogin">个人资料</el-menu-item>
            <el-menu-item index="4-2" v-if="isLogin">我的收藏</el-menu-item>
            <el-menu-item index="4-3" v-if="isLogin">我的上传</el-menu-item>
            <el-menu-item index="4-4" v-if="isLogin">退出登陆</el-menu-item>
            <el-menu-item index="4-5" v-if="!isLogin" @click="dialogVisible = true">点我登陆</el-menu-item>
        </el-submenu>
    </el-menu>

    <el-dialog
        title="请登陆"
        v-model="dialogVisible"
        width="30%"
        center>
        <div class="account">
            <el-input class="username" v-model="userName" placeholder="请输入账号"></el-input>
            <el-input placeholder="请输入密码" v-model="password" show-password></el-input>
        </div>
        <template #footer>
            <span class="dialog-footer">
                <el-button class="login" type="primary" @click="dialogVisible = false">登陆</el-button>
            </span>
            <a class="github-img">
                <img src="./assets/github.png">
            </a>
        </template>
    </el-dialog>
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
