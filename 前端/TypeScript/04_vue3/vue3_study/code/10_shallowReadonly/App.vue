<template>
    <div>
        <h2>readonly和shallowReadonly</h2>
        <h3>state: {{state}}</h3>
        <h3>state2: {{state2}}</h3>
        <h3>state3: {{state3}}</h3>
        <button @click="update">更新数据</button>
    </div>
</template>
<script lang="ts">
import { defineComponent, reactive, readonly, shallowReadonly } from 'vue'

export default defineComponent({
    name: "App",

    setup() {

        const state = reactive({
            name: "佐助",
            age: 20,
            car: {
                name: "奔驰",
                color: "yellow"
            }
        })

        // 深度只读
        const state2 = readonly(state);

        // 浅只读
        const state3 = shallowReadonly(state);
        const update = () => {
            // 只读属性不可修改
            // state2.car.name += "==="

            state3.car.name += "==="
        }
        return {
            state,
            state2,
            state3,
            update
        }
    }
})
</script>
