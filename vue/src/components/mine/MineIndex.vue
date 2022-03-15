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
                {id:201,title:"个人信息",path:"/mes"},
                {id:202,title:"我的发布",path:"/mypost"},
                {id:203,title:"我的订单",path:"myorder"},
                {id:204,title:"我卖出的",path:"/sell"}
            ],
            activePath:'/mine',//默认路径
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