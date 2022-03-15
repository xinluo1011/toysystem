// 侧边栏
<template>
    <el-menu
    text-color="#fff"
    background-color="#545c64"
    class="categories"
    default-active="0"
    @select="handleSelect"
    active-text-color="#ffd04b">
    <el-menu-item index="2000">
      <i class="el-icon-menu"></i>
      <span slot="title">全部</span>
    </el-menu-item>
    <el-menu-item index="2001">
      <i class="el-icon-menu"></i>
      <span slot="title">积木类</span>
    </el-menu-item>
    <el-menu-item index="2002">
      <i class="el-icon-menu"></i>
      <span slot="title">拼图</span>
    </el-menu-item>
    <el-menu-item index="2003">
      <i class="el-icon-menu"></i>
      <span slot="title">桌面游戏</span>
    </el-menu-item>
    <el-menu-item index="2004">
      <i class="el-icon-menu"></i>
      <span slot="title">毛绒类</span>
    </el-menu-item>
    <el-menu-item index="2005">
      <i class="el-icon-menu"></i>
      <span slot="title">球类玩具</span>
    </el-menu-item>
    <el-menu-item index="2006">
      <i class="el-icon-menu"></i>
      <span slot="title">其他</span>
    </el-menu-item>
  </el-menu>
</template>
<script>
    export default {
        name: 'SideMenu',
        data(){
          return{
            cid: ''
          }
        },
        methods:{
          handleSelect(key,keyPath){
            this.cid=key
            this.$emit('indexSelect')
          }
        }
    }
</script>
<style scoped>
    .categories {
        height: 100%;
    }
</style>