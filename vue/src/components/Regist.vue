<template>
<body>
      <!-- 注册窗口 -->
  <el-dialog title="注册" :visible.sync="dialogVisible" width="50%" @close="addDialogClosed">
    <el-form :model="addForm" :rules="addFormRules" ref="addFormRef" label-width="70px">
    <el-form-item label="用户名" prop="username">
    <!-- 用户名 -->
    <el-input v-model="addForm.username"></el-input>
    </el-form-item>
    <!-- 密码 -->
    <el-form-item label="密码" prop="password">
      <el-input v-model="addForm.password"></el-input>
    </el-form-item>
    <!-- 用户身份状态 -->
    <el-form-item label="用户身份">
    <el-radio-group v-model="addForm.state">
      <el-radio label="买家" value="false"></el-radio>
      <el-radio label="卖家" value="true"></el-radio>
    </el-radio-group>
  </el-form-item>
  <el-form-item label="手机号" prop="telephone">
    <!-- 手机号 -->
    <el-input v-model="addForm.telephone"></el-input>
  </el-form-item>
  <el-form-item label="所在小区" prop="address">
    <!-- 所在小区 -->
    <el-input v-model="addForm.address"></el-input>
  </el-form-item>
    </el-form>
    <!-- 内容底部区域 -->
    <span slot="footer" class="dialog-footer">
      <el-button @click="dialogVisible = false">取消</el-button>
      <el-button type="primary" @click="addUser">确 定</el-button>
    </span>
    </el-dialog>
</body>    
</template>
<script>

</script>
<style scoped>

</style>