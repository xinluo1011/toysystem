// 用户界面
<template>
 <div>
   欢迎进入玩具共享平台（管理员界面）
 </div>
</template>

<script>
  export default {
    name: 'AppIndex',
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
  .tac {
    height: 100%;
  }
</style>

