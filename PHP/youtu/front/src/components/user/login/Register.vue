<template>
    <el-input class="input" v-model="userName" placeholder="请输入账号"></el-input>
    <el-input class="input" v-model="password1" placeholder="请输入密码" show-password></el-input>
    <el-input class="input" v-model="password2" placeholder="请再次输入密码" show-password></el-input>
    <el-button class="login" type="primary">注册</el-button>
</template>

<script>
import {defineComponent, ref} from "vue";

export default defineComponent({
    name: "Register",
    setup() {
        const userName = ref("")
        const password1 = ref("")
        const password2 = ref("")

        return{
            userName,
            password1,
            password2
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