<template>
    <div>
        <nav-menu></nav-menu>
        <router-view/>
    </div>
</template>

<script>
import NavMenu from './common/NavMenu.vue'
    export default {
  components: { NavMenu },
        name: 'Home'
    }
</script>

<style scoped>

</style>