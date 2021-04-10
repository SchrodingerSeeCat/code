<template>
  <div>
    <h2>子级组件</h2>
    <h3>
        {{msg}}
    </h3>
  </div>
</template>

<script>
import { defineComponent } from "vue"
/**
 * setup在beforeCreate生命周期执行之前执行，this不能使用
 */
export default defineComponent({
    name: 'Child',
    props: ['msg'],

    setup() {
        return {

        }
    }
})
</script>

<style>

</style>