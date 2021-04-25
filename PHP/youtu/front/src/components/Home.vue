<template>
    <el-menu
        class="el-menu-demo"
        mode="horizontal"
        default-active="recommend">
        <router-link to="/">
            <img class="logo" src="../assets/logo.png" alt="logo">
        </router-link>
        <el-menu-item index="recommend" @click="select">推荐</el-menu-item>
        <el-menu-item index="comic" @click="select">动漫</el-menu-item>
        <el-menu-item index="scenery" @click="select">风景</el-menu-item>
        <el-menu-item index="life" @click="select">生活</el-menu-item>

        <el-submenu index="personal" class="login-container">
            <template #title>{{loginMsg}}</template>
            <el-menu-item index="5-1" v-if="isLogin">个人资料</el-menu-item>
            <el-menu-item index="5-2" v-if="isLogin">我的收藏</el-menu-item>
            <el-menu-item index="5-3" v-if="isLogin">我的上传</el-menu-item>
            <el-menu-item index="5-4" v-if="isLogin">退出登陆</el-menu-item>
            <el-menu-item index="5-5" v-if="!isLogin" @click="dialogVisible = true">点我登陆</el-menu-item>
        </el-submenu>
    </el-menu>

    <el-dialog
        v-model="dialogVisible"
        width="30%"
        center>
        <div class="account">
            <el-tabs v-model="activeName">
                <el-tab-pane label="登陆" name="first">
                    <Login />
                </el-tab-pane>
                <el-tab-pane label="注册" name="second">
                    <Register />
                </el-tab-pane>
                <el-tab-pane label="第三方" name="third">
                    <Third />
                </el-tab-pane>
            </el-tabs>
        </div>
    </el-dialog>
    <router-view></router-view>
</template>

<script lang="ts">
import {defineComponent, onMounted, ref} from 'vue'
import Login from './user/login/Login.vue'
import Register from "./user/login/Register.vue";
import Third from "./user/login/Third.vue";
import {useRouter} from "vue-router";

interface Nav {
    index: string,
    indexPath?: string[]
}

export default defineComponent({
    name: 'Home',
    components: {
        Third,
        Register,
        Login
    },
    setup() {
        // 引入路由
        const router = useRouter()

        const loginMsg = ref("登陆")
        const isLogin = ref(false)
        const activeName = ref('first')
        const dialogVisible = ref(false) // 登陆对话框

        // 默认回调
        const select = (index: Nav) => {
            router.push({
                path: `/home/${index.index}`,
                name: index.index
            })
        }

        // 生命周期钩子
        onMounted(() => { // 挂载之后
            select({index: 'recommend'})
        })

        return {
            loginMsg,
            isLogin,
            dialogVisible,
            select,
            activeName
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
.login {
    width: 150px;
    position: relative;
    top: -20px;
}
</style>
