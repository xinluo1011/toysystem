<template>
    <div>
        <el-row style="height:840px;">
            <div effect="dark" placement="right" 
                v-for="item in toys.slice((currentPage-1)*pagesize,currentPage*pagesize)" 
                :key="item.toyid">
                <el-card style="width: 170px;margin-bottom:30px;height: 240px;float: left;margin-right: 15px"
                class="toys" bodyStyle="padding: 10px" shadow="hover">
                <div class="photo" @click="editToy(item)">
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
            <edit-form ref="edit"></edit-form>
            <edit ref="edittoy"></edit>
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
import EditForm from './MineForm.vue'
import Edit from './EditForm.vue'
export default {
    name: 'MyPost',    
    components: {EditForm,Edit},
    data() {
        return {
            username:JSON.parse(window.localStorage.getItem('user')).username,
            toys:[],
            currentPage:1,
            pagesize:10
        }
    },
    mounted: function(){
        this.loadUserName()      
    },
    methods:{
        handleCurrentChange: function(currentPage) {
                this.currentPage=currentPage
                console.log(this.currentPage)
            },
        loadUserName() {
            var _this=this
            var url='user/'+_this.username+'/user'
            this.$axios.get(url).then(res =>{
                if(res && res.status === 200){
                    var url='id/'+res.data+'/toy'
                    this.$axios.get(url).then(resp=>{
                        if(resp && resp.status===200){
                            _this.toys=resp.data
                        }
                    }) 
                }
            })    
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
                        this.loadUserName()
                    }
                })
            }).catch(() =>{
                this.$message({
                    type:'info',
                    message:'已取消删除'
                })
            })
        },
        editToy(item) {
            this.$refs.edittoy.dialogVisible=true
            this.$refs.edittoy.form={
                toyid:item.toyid,
            }
        }
    }
}
</script>
<style scoped>
.photo {
        width: 115px;
        height: 150px;
        margin-bottom: 7px;
        overflow: hidden;
        cursor: pointer;
    }
    img {
        width: 115px;
        height: 150px;
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
    a {
        text-decoration: none;
    }
    a:link, a:visited, a:focus {
        color: #3377aa;
    }
</style>