<template>
    <div>
        <el-dialog title="修改玩具" 
        :visible.sync="dialogVisible"
        width="50%" 
        @close="clear">
            <!-- 玩具名 -->
            <el-form v-model="form" style="text-align:left" ref="dataForm">
                <el-form-item label="玩具名" :label-width="formLabelWidth" prop="name">
                    <el-input v-model="form.name" autocomplete="off" placeholder="请输入正确的玩具名"></el-input>
                </el-form-item>
                <!-- 玩具价格 -->
                <el-form-item label="价格" :label-width="formLabelWidth" prop="price">
                    <el-input v-model="form.price" autocomplete="off" placeholder="请输入价格"></el-input>
                </el-form-item>
                <!-- 玩具图片上传 -->
                <el-form-item label="封面" :label-width="formLabelWidth" prop="photo">
                    <img-upload @onUpload="uploadImg" ref="imgUpload"></img-upload>
                </el-form-item>
                <!-- 玩具分类 -->
                <el-form-item label="分类" :label-width="formLabelWidth" >
                    <el-select v-model="form.cid" placeholder="请选择分类">
                        <el-option label="积木类" value="2001"></el-option>
                        <el-option label="拼图" value="2002"></el-option>
                        <el-option label="桌面游戏" value="2003"></el-option>
                        <el-option label="毛绒类" value="2004"></el-option>
                        <el-option label="球类玩具" value="2005"></el-option>
                        <el-option label="其他" value="2006"></el-option>
                    </el-select>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="editToy">确 定</el-button>
            </span>
        </el-dialog>
    </div>        
</template>
<script>
import ImgUpload from './ImgUpload';
export default {
    components:{ImgUpload},
    name:'MineForm',
data() {
        return {
            username:JSON.parse(window.localStorage.getItem('user')).username,
            dialogVisible: false,
            form:{
                toyid:'',
                name: '',
                price: '',
                photo: '',
                cid:'',
                id: '',
            },
            formLabelWidth: '120px', 
        }
    },
    methods:{
        editToy(){
           this.$axios.post('/edittoy',{
               toyid:this.form.toyid,
               name:this.form.name,
               price:this.form.price,
               photo:this.form.photo,
               cid:this.form.cid,
           }).then(resp=>{
               if(resp=="error"){
                    return this.$message.error("修改失败");
                }
                this.$message.success("修改成功");
                this.dialogVisible = false;
           })
        },
        clear() {
             this.form={
                name: '',
                price: '',
                photo: '',
                cid:'',
                id: '',
            }
        },
        uploadImg() {
            this.form.photo=this.$refs.imgUpload.url
        }
        // onSubmit() {
        //     this.$axios
        //     .post('/toys',{
        //     })
        // }
    }
}
</script>
<style scoped>

</style>