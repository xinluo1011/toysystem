<template>
<body id="poster">
<el-form class="login-container" label-position="left"
           label-width="0px"
          :rules="loginRules" :model="loginForm">
    <h3 class="login_title">玩具共享登录</h3>
    <el-form-item>
      <el-input type="text" v-model="loginForm.username"
                auto-complete="off" placeholder="账号"></el-input>
    </el-form-item>
    <el-form-item>
      <el-input type="password" v-model="loginForm.password"
                auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item class="btns">
      <el-button type="primary" @click="login" style="background:#505458 ;border: none">登录</el-button>
      <el-button type="primary" @click="dialogVisible=true" style="background:#505458 ;border: none">注册</el-button>
    </el-form-item>
  <!-- 注册窗口 -->
  </el-form>
  <el-dialog title="注册" :visible.sync="dialogVisible" width="50%" @close="addDialogClosed" append-to-body>
    <el-form :model="addForm" :rules="addFormRules" ref="addFormRef" label-width="70px">
    <el-form-item label="用户名" prop="username">
    <!-- 用户名 -->
    <el-input v-model="addForm.username"></el-input>
    </el-form-item>
    <!-- 密码 -->
    <el-form-item label="密码" prop="password">
      <el-input v-model="addForm.password"></el-input>
    </el-form-item>
  <el-form-item label="手机号" prop="telephone">
    <!-- 手机号 -->
    <el-input v-model="addForm.telephone"></el-input>
  </el-form-item>
  <el-form-item label="小区" prop="address">
    <!-- 所在小区 -->
    <el-input v-model="addForm.address"></el-input>
  </el-form-item>
    </el-form>
    <!-- 内容底部区域 -->
    <span slot="footer" class="dialog-footer">
      <el-button @click="dialogVisible = false">取 消</el-button>
      <el-button type="primary" @click="addUser">确 定</el-button>
    </span>
    </el-dialog>
  </body>
</template>

<script>

  export default {
    name: 'Login',
    data () {
      return {
        dialogVisible:false,
        // 添加表单验证
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
        addForm:{
          username:'',
          password:'',
          telephone:'',
          address:''
        },
        loginRules:{
          // 校验用户名
          username:[
             {required: true,message: '请输入用户名',trigger: 'blur',},//对必填项的验证
             {min: 3,max: 12,message: '长度在3到12个字符',trigger: 'blur',}//对长度的验证
            ],
          // 校验密码
          password:[
          {required: true,message: '请输入密码',trigger: 'blur',},//对必填项的验证
          {min: 6,max: 10,message: '长度在6到10个字符',trigger: 'blur',}//对长度的验证
          ],
        },
        loginForm: {
          username: 'admin',
          password: '1231234'
        },
        responseResult: []
      }
    },
    methods: {
      //监听添加用户
      addDialogClosed(){
        this.$refs.addFormRef.resetFields();
      },
      addUser(){
         this.$axios
          .post('/addUser', {
            username: this.addForm.username,
            password: this.addForm.password,
            telephone: this.addForm.telephone,
            address: this.addForm.address
          }).then(res=>{
            if(res=="error"){
            return this.$message.error("注册失败");
          }
          this.$message.success("注册成功");
          this.dialogVisible = false;
          })
      },
      /**逻辑：
       * 1.点击登录按钮，向后端发送数据
       * 2.收到后端返回的成功代码时，触发store中的login()方法，把loginForm对象传递给store
       * 中的user对象
       * 3.获取登录前页面的路径并跳转，如果路径不存在，则跳转到首页
       */
      login () {
        var _this=this
        console.log(this.$store.state)
        this.$axios
          .post('/login', {
            username: this.loginForm.username,
            password: this.loginForm.password
          })
          .then(successResponse => {
            // 用户界面
            if (successResponse.data.code === 200) {
              
               this.$message.success("登录成功");//信息提示
              _this.$store.commit('login',_this.loginForm)
              var path = this.$route.query.redirect
              this.$router.replace({path: path === '/' || path === undefined ? '/index2' : path})
            }
            //管理员界面
            else if(successResponse.data.code === 100){
              this.$message.success("登录成功");//信息提示
               _this.$store.commit('login',_this.loginForm)
              var path = this.$route.query.redirect
              this.$router.replace({path: path === '/' || path === undefined ? '/index' : path})
            }
            else if(successResponse.data.code === 400) {
               this.$message.error("用户名或密码错误");//错误提示
            }
          })
          .catch(failResponse => {
          })
      }
    }
  }
</script>
<style scoped>
  #poster {
    background:url("../assets/ts.jpg") no-repeat;
    background-position: center;
    height: 100%;
    width: 100%;
    background-size: cover;
    position: fixed;
  }
  body{
    margin: 0px;
  }
   .login-container {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 90px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: rgb(63, 158, 182);
    border: 1px solid rgb(63, 158, 182);
    box-shadow: 0 0 25px #0e0000;
    position: center;
  }
  
  .login_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }
  .btns {
    display: flex;
    justify-content: center;
}
</style>
