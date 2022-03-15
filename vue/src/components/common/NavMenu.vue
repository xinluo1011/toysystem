<template>
<!-- 在el-menu中开启了router模式，router：是否使用vue-router的模式，启用该模式
会在激活导航时以index作为path进行路由跳转 -->
<el-container class="home-container">
    <!-- 头部 -->
    <el-header>
        <el-menu :default-active="'/index'" router mode="horizontal" background-color="#545c64"
      text-color="#fff" active-text-color="#ffd04b" style="min-width: 1300px">
            <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name">
                {{item.navItem}}
            </el-menu-item>
            <span style=" position: absolute;padding-top: 20px;right: 43%;font-size: 20px;font-weight: bold"> 玩具共享平台 </span>
        </el-menu>
        <div><el-button type="info" @click="logout">安全退出</el-button></div>    
    </el-header>
</el-container>
</template>
<script>
    export default {
        name: 'NavMenu',
        data () {
        return {
            navList:[
                {name: '/toy',navItem: '玩具'},
                {name: '/mine',navItem: '我的'},
            ]
         }
        },
        methods: {
            logout(){
                window.sessionStorage.clear();//清楚Session存储
                 this.$message.success("退出成功");
                this.$router.push("/login");//返回至首页
            }
        }
    }
</script>
<style scoped>
    .home-container {
        height: 100%;
    }
    /* 头部样式 */
    .el-header {
        background-color: #545c64;
        display: flex;
        justify-content: space-between; /*左右贴边*/
        padding-left: 0%; /*左边界*/
        align-items: center;
        color: #fff;
        font-size: 20px;
        }
    span {
        pointer-events: none;
    }
    img {
        width: 55px;
        height: 55px;
    }
</style>
