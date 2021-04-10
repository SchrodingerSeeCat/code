<template>
    <div>
        <h2>父级组件</h2>
        <div>{{msg}}</div>
        <hr />
        <Child :msg="msg"/>
    </div>
    
</template>

<script lang="ts">
import { defineComponent, ref } from 'vue';
import Child from './components/Child.vue'

/**
 * setup中的属性和data函数中的对象属性和方法会合并为组件对象的属性和方法
 * 一般不建议setup和methods和data混合使用
 * setup中不能访问data和methods中的属性和方法
 */
export default defineComponent({
    name: 'App',
    components: {
        Child
    },

    // props参数是一个对象，里面有父级组件向子级组件传递的数据，并且是在子级组件中使用props接收到的所有属性
    // context参数，是一个对象，有attrs(获取当前组件标签上的属性，但是该属性是在props中没有声明)，emit(事件分发)
    setup(props, context) {
        const msg = ref('hahah')

        console.log(props)
        console.log(context)
        return {
            msg
        }
    },

    // 界面渲染后的声明周期回调
    mounted() {
        // console.log(this)
    },
    methods:{

    }
});
</script>

<style>
</style>
