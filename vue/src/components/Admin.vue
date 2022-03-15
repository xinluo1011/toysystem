<template>
    <div>
      欢迎进入玩具共享平台（用户界面）
    </div>
</template>

<script>
  export default {
    name: 'Admin',
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      }
  }
  }
</script>

<style scoped>

</style>