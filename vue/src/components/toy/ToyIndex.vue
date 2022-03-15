<template>
    <el-container>
        <!-- 侧边栏 -->
        <el-aside style="width:200px">
            <switch></switch>
            <SideMenu  ref="sideMenu" @indexSelect="listByCategory"></SideMenu>
            
        </el-aside>
        <!-- 主要部分 -->
        <el-main>
            <toys class="toys-area" ref="toysArea"></toys>
        </el-main>
    </el-container>
</template>
<script>
    import Toys from './Toys'
    import SideMenu from './SideMenu'
    export default {
        name: 'AppToy',
        components: {Toys,SideMenu},
        methods:{
            listByCategory(){
                var _this=this
                var cid=this.$refs.sideMenu.cid
                var url='cid/'+cid+'/toy'
                this.$axios.get(url).then(res=>{
                    if(res && res.status===200){
                        _this.$refs.toysArea.toys=res.data
                    }
                })
            }
        }
    }
</script>
<style scoped>
    .toys-area {
        width: 990px;
        margin-left: auto;
        margin-right: auto;
    }
</style>
