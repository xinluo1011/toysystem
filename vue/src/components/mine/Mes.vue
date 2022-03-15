<template>
    <div>
        <el-row style="height:840px;">
            <div effect="dark" placement="right" >
                <el-card style="width: 1050px;padding-left:600px;margin-bottom:30px;height:255px;margin-right: 15px">
                    <h1> 个  人  中  心 </h1>
                    <div class="info">
                        <div class="username">用 户 名 : {{user.username}}</div>
                        <div class="password">密 码 : {{user.password}}</div>
                        <div class="telephone">联 系 方 式 : {{user.telephone}} </div>
                        <div class="address">所 在 小 区 : {{user.address}}</div>
                    </div>
                    <br>
                    <el-button size="mini" type="primary" @click="dialogFormVisible=true">修改</el-button>    
                </el-card>
            </div>
        </el-row>
        <el-dialog title="修改信息" 
        :visible.sync="dialogFormVisible"
        width="50%">
        <el-form v-model="user" style="text-align:left" ref="dataForm">
            <el-form-item label="用户名" :label-width="formLabelWidth" prop="username">
                <el-input v-model="user.username" autocomplete="off" placeholder="请输入正确的用户名"></el-input>
            </el-form-item>
            <el-form-item label="密码" :label-width="formLabelWidth" prop="password">
                <el-input v-model="user.password" autocomplete="off" placeholder="请输入正确的密码"></el-input>
            </el-form-item>
            <el-form-item label="联系方式" :label-width="formLabelWidth" prop="telephone">
                <el-input v-model="user.telephone" autocomplete="off" placeholder="联系方式"></el-input>
            </el-form-item>
            <el-form-item label="所在小区" :label-width="formLabelWidth" prop="address">
                <el-input v-model="user.address" autocomplete="off" placeholder="所在小区"></el-input>
            </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="EditMes">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>
<script>
export default {
data() {
        return {
            dialogFormVisible:false,
            username:JSON.parse(window.localStorage.getItem('user')).username,
            user:{
                id:'',
                username:'',
                telephone:'',
                address:'',
                password:'',
            },
            formLabelWidth: '120px', 
        }
    },
    mounted: function(){
            this.FindMess()
        },
methods:{
    FindMess(){
        var url='user/'+this.username+'/name'
        this.$axios.get(url).then(res=>{
            if(res && res.status ===200){
               this.user=res.data 
            }
        })
    },
     EditMes(){
         this.$axios.post('/edituser',{
             id:this.user.id,
             username:this.user.username,
             telephone:this.user.telephone,
             password:this.user.password,
             address:this.user.address
     }).then(resp=>{
         if(resp=="error"){
                    return this.$message.error("修改失败");
                }
                this.$message.success("修改成功");
                this.dialogFormVisible = false;
           })          
     }
}
}
</script>
<style scoped>
.body {
    font-size: 20px;
}
.el-button {
    font-size: 15px
}
.el-card{
    position: center;
}

</style>