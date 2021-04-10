<template>
    <div>
        <h2>计算属性和监视</h2>
        <fieldset>
            <legend>姓名操作</legend>
            姓氏：<input 
                    type="text" 
                    placeholder="请输入姓氏" 
                    v-model="user.firstName" /><br />
            名字：<input 
                    type="text" 
                    placeholder="请输入名字" 
                    v-model="user.lastName" /><br />
        </fieldset>
        <fieldset>
            <legend>计算属性和监视演示</legend>
            姓名1：<input type="text" placeholder="显示姓名" v-model="fullName1"/><br />
            姓名2：<input type="text" placeholder="显示姓名" v-model="fullName2"/><br />
            姓名3：<input type="text" placeholder="显示姓名" v-model="fullName3"/><br />
        </fieldset>
    </div>
    
</template>

<script lang="ts">
import { computed, defineComponent, reactive, watch, ref } from 'vue';

export default defineComponent({
    name: 'App',
    setup() {
        const user = reactive({
            firstName: '东方',
            lastName: '不败'
        })
        // 通过计算属性方式，实现姓名的显示
        // 1.计算属性的函数如果只传入一个回调函数， 表示的是get
        const fullName1 = computed(() => {
            return user.firstName + " " + user.lastName
        })

        // 2.提供get和set方法
        const fullName2 = computed({
            get() {
                return user.firstName + " " + user.lastName
            },
            set(val:string) {
                const names = val.split(" ")
                user.firstName = names[0]
                user.lastName = names[1]
            }
        })

        // 3.监视----监视指定的数据
        const fullName3 = ref("")
        // 第一个参数要监视的数据，第二个参数监视的数据发生变化时的回调，第三个参数immediate默认会调用一次deep深度监视
        // 如果watch监视的数据是非响应式的，则需要使用回调的方式监视
        // watch(() => user, (val) => {
        watch(user, (val) => {
            fullName3.value = val.firstName + " " + val.lastName
        }, {immediate: true, deep: true})

        return {
            user,
            fullName1,
            fullName2,
            fullName3
        }
    }
});
</script>

<style>
</style>
