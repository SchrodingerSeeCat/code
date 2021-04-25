<template>
    <el-input class="input" v-model="userName" placeholder="请输入账号"></el-input>
    <el-input class="input" v-model="password" placeholder="请输入密码" show-password></el-input>
    <el-button class="login" type="primary">登陆</el-button>
</template>

<script>
import {defineComponent, ref} from "vue";

export default defineComponent({
    name: "Login",
    setup() {
        const userName = ref("")
        const password = ref("")

        return{
            userName,
            password
        }
    }
})
</script>
<style scoped>
    .input{
        margin: 10px 0 10px 0;
    }
    .login{
        width: 100%;
    }
</style>