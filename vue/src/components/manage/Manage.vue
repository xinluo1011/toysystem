<template>
    <div>
        <el-row style="height:840px;">
             <el-col :span="8">
            <search-bar @onSearch="searchResult" ref="searchBar"></search-bar>
             </el-col>
                <el-col :span="4">
                <el-button size="small" type="primary" @click="addDialogVisible=true">添加用户</el-button>
                </el-col>
                <el-table :data="users"  border stripe>
                    <el-table-column label="用户id" prop="id"></el-table-column>
                    <el-table-column label="用户名" prop="username"></el-table-column>
                    <el-table-column label="密码" prop="password"></el-table-column>
                    <el-table-column label="联系电话" prop="telephone"></el-table-column>
                    <el-table-column label="所在小区" prop="address"></el-table-column>
                    <el-table-column label="状态" prop="state">
                        <!--作用域插槽-->
                        <template slot-scope="scope">
                        <!--{{scope.row}} 为每一行封存的数据 -->
                        <el-switch v-model="scope.row.state" @change="userStateChanged(scope.row)"></el-switch>
                        </template>
                    </el-table-column>
                    <el-table-column label="操作" >
                    <template slot-scope="scope">
                        <!--修改-->
                        <el-button type="primary" icon="el-icon-edit" size="mini" @click="showEditDialog(scope.row.id)"></el-button>
                        <!--删除-->
                        <el-button type="danger" icon="el-icon-delete" size="mini" @click="deleteUser(scope.row.id)" ></el-button>
                    </template>
                </el-table-column>
                </el-table>
        </el-row>
        <el-row>
             <el-pagination 
            @current-change="handleCurrentChange"
            :current-page="currentPage" 
            :page-size="pagesize" 
            :total="users.length">
            </el-pagination>
        </el-row>
        <!--新增用户区域-->
        <el-dialog title="添加用户" :visible.sync="addDialogVisible" width="50%" @close="addDialogClosed">
            <el-form :model="addForm" :rules="addFormRules" ref="addFormRef" label-width="70px">
                   <el-form-item label="用户名" prop="username">
                    <!-- 用户名 -->
                    <el-input v-model="addForm.username"></el-input>
                </el-form-item>
                    <!-- 密码 -->
                <el-form-item label="密码" prop="password">
                    <el-input v-model="addForm.password"></el-input>
                </el-form-item>
                <!-- 联系电话-->
                <el-form-item label="手机号" prop="telephone">
                    <el-input v-model="addForm.telephone"></el-input>
                </el-form-item>
                <!-- 所在小区-->
                <el-form-item label="小区" prop="address">
                    <el-input v-model="addForm.address"></el-input>
                </el-form-item>
            </el-form>
            <!-- 内容底部区域 -->
            <span slot="footer" class="dialog-footer">
                <el-button @click="addDialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="addUser">确 定</el-button>
            </span>
        </el-dialog>
        <!--修改对话框-->
        <el-dialog title="修改用户信息" :visible.sync="editDialogVisible" width="50%" @close="editDialogClosed">
            <el-form :model="editForm" :rules="addFormRules" ref="editFormRef" label-width="70px">
                <el-form-item label="用户名" prop="username">
                    <!-- 用户名 -->
                    <el-input v-model="editForm.username"></el-input>
                </el-form-item>
                    <!-- 密码 -->
                <el-form-item label="密码" prop="password">
                    <el-input v-model="editForm.password"></el-input>
                </el-form-item>
                <!-- 联系电话-->
                <el-form-item label="手机号" prop="telephone">
                    <el-input v-model="editForm.telephone"></el-input>
                </el-form-item>
                <!-- 所在小区-->
                <el-form-item label="小区" prop="address">
                    <el-input v-model="editForm.address"></el-input>
                </el-form-item>
            </el-form>
            <!-- 内容底部区域 -->
            <span slot="footer" class="dialog-footer">
                <el-button @click="editDialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="editUserInfo">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>
<script>
import SearchBar from './SearchBar'
export default {
    components: {SearchBar},
    data(){
        return {
            addFormRules:{
          username:[
            {required:true,message:'请输入用户名',trigger:'blur'},
            {min:3,max:8,message:'长度在3到8个字符',trigger:'blur'}
          ],
          password:[
            {required:true,message:'请输入密码',trigger:'blur'},
            {min:6,max:11,message:'长度在6到11个字符',trigger:'blur'}
          ],
          telephone:[
            {required:true,message:'请输入手机号',trigger:'blur'},
            {min:11,max:12,message:'输入正确的手机号',trigger:'blur'}
          ],
          address:[
            {required:true,message:'请输入所在小区',trigger:'blur'},
            {min:4,max:8,message:'输入正确的小区名',trigger:'blur'}
          ],
        },
            users:[],
            currentPage:1,
            pagesize:10,
            addForm:{
                username:'',
                password:'',
                telephone:'',
                address:'',
            },
            editForm:{
                id:'',
                username:'',
                password:'',
                telephone:'',
                address:''
            },
            editDialogVisible:false,
            addDialogVisible:false,
        }
    },
    mounted: function(){
            this.loadUsers()
    },
    methods:{
        loadUsers() {
                var _this=this
                this.$axios.get('/users').then(res=>{
                    if(res && res.status===200){
                        _this.users=res.data
                    }
                })
            },
        searchResult(){
                var _this =this
                this.$axios
                .get('/searchuser?keywords='+this.$refs.searchBar.keywords,{
                }).then(res =>{
                    if(res && res.status===200){
                        _this.users=res.data
                    }
                })
            },
        handleCurrentChange: function(currentPage) {
            this.currentPage=currentPage
            console.log(this.currentPage)
        },
        editDialogClosed(){
            this.editForm={
                id:'',
                username:'',
                password:'',
                telephone:'',
                address:''
            }
        },
        addDialogClosed(){
            this.addForm={
                username:'',
                password:'',
                telephone:'',
                address:''
            }
        },
        addUser(){
            this.$axios.post('/adduser',{
                username:this.addForm.username,
                password:this.addForm.password,
                telephone:this.addForm.telephone,
                address:this.addForm.address,
            }).then(res =>{
                if(res=="error"){
                    return this.$message.error("添加失败");
                }
                this.$message.success("添加成功");
            this.addDialogVisible = false;
            this.loadUsers();
                
            })
            
        },

        showEditDialog(id){
            var url='user/'+id+'/userid'
            this.$axios.get(url).then(res=>{
                this.editForm=res.data
                })
                this.editDialogVisible=true
        },    
        editUserInfo(){
                this.$axios.post('/edituser',{
                id:this.editForm.id,
                username:this.editForm.username,
                telephone:this.editForm.telephone,
                password:this.editForm.password,
                address:this.editForm.address
             }).then(resp=>{
                if(resp=="error"){
                    return this.$message.error("修改失败");
                }
                this.$message.success("修改成功");
                this.editDialogVisible=false;
                this.loadUsers();
            })
        },
        userStateChanged(userInfo){
            this.$axios.post('/userstate',{
                id:userInfo.id,
                state:userInfo.state
            }).then(resp=>{
                if(resp=="error"){
                    userInfo.id=!userInfo.id;
                    this.$message.error("操作失败");
                }
                this.$message.success("操作成功");
            })
        },
        deleteUser(id){
            this.$confirm('此操作将永久删除该用户信息，是否继续？','提示',{
                confirmButtonText:'确定',
                cancelButtonText: '取消',
                type:'warning'
            }).then(()=>{
                this.$axios.post('/deleteid',{id,id}).then(
                this.$axios.post('/deleteuser',{id,id}).then(()=>{
                        this.loadUsers ()                    
                })
            )
            }).catch(()=>{
                this.$message({
                    type:'info',
                    message:'已取消删除'
                })
            })
            this.loadUsers();
        }
    }
}
</script>
<style scoped>
.el-card {
    box-shadow: 0 1px 1px rgba(0,8,10,0.15) !important;
}
</style>