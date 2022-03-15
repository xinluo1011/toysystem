<template>
    <div>
        <nav-menus></nav-menus>
        <router-view/>
    </div>
</template>

<script>
import NavMenus from './common/NavMenu2.vue'
    export default {
  components: { NavMenus },
        name: 'Home2'
    }
</script>

<style scoped>

</style>