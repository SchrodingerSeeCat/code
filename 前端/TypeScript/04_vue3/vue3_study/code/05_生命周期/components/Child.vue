<template>
    <div>
        <h2>Child组件</h2>
        <h2>msg: {{msg}}</h2>
        <button @click="update">update</button>
    </div>
</template>
<script>
import { 
    defineComponent, 
    ref, 
    onBeforeMount, 
    onMounted, 
    onBeforeUpdate, 
    onUpdated, 
    onBeforeUnmount, 
    onUnmounted } from 'vue';

export default defineComponent({
    name: 'Child',
    // vue2中的生命周期钩子
    beforeCreate() {
        console.log("vue2...beforeCreate")
    },
    created() {
        console.log("vue2...created")
    },
    beforeMount() {
        console.log("vue2...beforeMount")
    },
    mounted() {
        console.log("vue2...mounted")
    },
    beforeUpdate() {
        console.log("vue2...beforeUpdate")
    },
    updated() {
        console.log("vue2...updated")
    },

    // beforeDestroy destroyed已改名
    beforeUnmount() {
        console.log("vue2...beforeUnmount")
    },
    unmounted() {
        console.log("vue2...unmounted")
    },

    // vue3.x
    setup() {
        console.log("vue3...setup")
        const msg = ref('default')
        const update = ()=> {
            msg.value = "测试update"
        }

        onBeforeMount(() => {
            console.log("vue3...onBeforeMount")
        })

        onMounted(() => {
            console.log("vue3...onMounted")
        })

        onBeforeUpdate(() => {
            console.log("vue3...onBeforeUpdate")
        }) 

        onUpdated(() => {
            console.log("vue3...onUpdated")
        })

        onBeforeUnmount(() => {
            console.log("vue3...onBeforeUnmount")
        })

        onUnmounted(() => {
            console.log("vue3...onUnmounted")
        })
        
        return {
            msg,
            update
        }
    },
})
</script>
