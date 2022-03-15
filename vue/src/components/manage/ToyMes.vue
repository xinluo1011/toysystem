<template>
    <div>
        <el-row style="height:840px;">
            <div effect="dark" placement="right" 
                v-for="item in toys.slice((currentPage-1)*pagesize,currentPage*pagesize)" 
                :key="item.toyid">
                <el-card style="width: 170px;margin-bottom:30px;height: 260px;float: left;margin-right: 15px"
                class="toys" bodyStyle="padding: 10px" shadow="hover">
                <div class="photo" >
                    <img :src="item.photo" alt="封面">
                </div>
                <div class="info">
                    <div class="name">
                        <a href="">{{item.name}}</a>
                    </div>
                </div>
                <div class="price">价 格 : {{item.price}} 元</div>
                <i class="el-icon-delete" @click="deleteToy(item.toyid)"></i>
                </el-card>
            </div>
            
        </el-row>
        <el-row>
            <el-pagination 
            @current-change="handleCurrentChange"
            :current-page="currentPage" 
            :page-size="pagesize" 
            :total="toys.length">
            </el-pagination>
        </el-row>
    </div>
</template>
<script>
    export default {     
        name: 'ToysMes',
        data() {
            return {
                dialogFormVisible: false,
                toys: [],
                currentPage:1,
                pagesize:10
            }
        },
        mounted: function(){
            this.loadToys()
        },
        methods:{
            loadToys() {
                var _this=this
                this.$axios.get('/toys').then(res=>{
                    if(res && res.status===200){
                        _this.toys=res.data
                    }
                })
            },
            handleCurrentChange: function(currentPage) {
                this.currentPage=currentPage
                console.log(this.currentPage)
            },
            deleteToy(toyid) {
            this.$confirm('此操作将永久删除该玩具信息，是否继续？','提示',{
                confirmButtonText:'确定',
                cancelButtonText: '取消',
                type:'warning'
            }).then(() =>{
                this.$axios
                .post('/delete',{toyid,toyid}).then(res=>{
                    if(res && res.status === 200){
                        this.loadToys()
                    }
                })
            }).catch(() =>{
                this.$message({
                    type:'info',
                    message:'已取消删除'
                })
            })
        },
        }
    }
</script>
<style scoped>
    .photo {
        width: 150px;
        height: 172px;
        margin-bottom: 7px;
        overflow: hidden;
        cursor: pointer;
    }
    img {
        width: 150px;
        height: 172px;
        /*margin: 0 auto;*/
    }
    .name {
        font-size: 14px;
        text-align: center;
    }
    .price {
        color: #333;
        width: 102px;
        font-size: 13px;
        margin-bottom: 6px;
        text-align: center;
    }
    .switch {
        display: flex;
        position: absolute;
        left: 780px;
        top: 25px;
    }
    a {
        text-decoration: none;
    }
    a:link, a:visited, a:focus {
        color: #3377aa;
    }
</style>