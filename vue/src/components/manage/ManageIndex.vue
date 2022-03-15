<template>
<div>
    <el-container >
        <!-- 侧边栏 -->
      <el-aside width="200px">
        <el-menu  active-text-color="#ffd04b" background-color="#545c64" text-color="#fff" :router="true" 
        :default-active="activePath">
          <!-- 一级菜单 -->
          <el-menu-item :index="item.path" v-for="(item,id) in menuList" :key="id">
          <template solt="title">
              <i class="el-icon-location"></i>
            <span>{{item.title}}</span>
          </template>
        </el-menu-item>
      </el-menu>
  </el-aside>
  <el-main>
        <router-view>
        </router-view>
  </el-main>
    </el-container>
     
</div>

</template>
<script>
export default {
    data(){
        return{
            //菜单列表
            menuList:[
                {id:1,title:"用户信息",path:"/man"},
                {id:2,title:"玩具信息",path:"/toymes"},
            ],
            activePath:'/manage1',//默认路径
        }
    },
}
</script>
<style scoped>
.el-aside {
   background-color:#545c64;
}
.el-container{
   height: 990px;
   
}
</style>