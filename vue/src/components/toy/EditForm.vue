<template>
    <div>
        <el-dialog title="玩具信息" :visible.sync="dialogFormVisible" @close="clear" width="25%">
            <el-form class="text item" label-width="70px">
            <div class="photo"><img :src="form.photo"></div>
                <div> 玩 具 id: {{form.toyid}}</div>
                <div> 玩 具 名 : {{form.name}}</div>
                <div> 价 格 : {{form.price}}元</div>
                <div> 持 有 者 名 : {{form.username}}</div>
                <div> 联 系 电 话 : {{form.telephone}}</div>
                <div> 所 在 小 区 : {{form.address}}</div>
            </el-form>
            <el-button size="small" type="primary" @click="addorder(form.toyid)">购买</el-button>
        </el-dialog>
    </div>    
</template>
<script>
    export default {
        name: 'EditForm',
        data() {
            return {
                username:JSON.parse(window.localStorage.getItem('user')).username,
                dialogFormVisible: false,
                form: {
                    toyid:'',
                    price:'',
                    photo:'',
                    id:'',
                    username:'',
                    telephone:'',
                    address:'',
                    // category:{
                    //     id:'',
                    //     name:''
                    // }
                },
                formLabelWidth: '120px'
            }
        },
        methods: {
            addorder(toyid){
                this.$confirm('是否确定购买此玩具','提示',{
                    confirmButtonText:'确定',
                    cancelButtonText:'取消',
                }).then(() => {
                            this.$axios.post('/addorder',{
                                tid:this.form.toyid,
                                name:this.form.name,
                                price:this.form.price,
                                bname:this.username,
                                sid:this.form.id
                            }).then(resp => {
                                if(resp =="error"){
                                    return this.$message.error("购买失败");
                                }
                                this.$message.success("购买成功");
                            })
                }).then(()=>{
                    this.$axios.post('/delete',{toyid,toyid})
                })
            },
            clear() {
                this.form ={
                    toyid:'',
                    price:'',
                    photo:'',
                    id:'',
                    name:'',
                    telephone:'',
                    address:'',
                    // category:{}
                }
            },
            onSubmit() {
                this.$axios
                .post('/toys',{
                    toyid:this.form.toyid,
                    price:this.form.price,
                    photo:this.form.photo,
                    id:this.form.id,
                    // category:this.form.category
                }).then(res =>{
                    if(res && res.status===200){
                        this.dialogFormVisible = false
                        this.$emit('onSubmit')
                    }
                })
            }
        }
    }
</script>
<style scoped>
.text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }
  img {
    width: 180px;
    height: 172px;
  }
  .photo {  
    width: 180px;
    height: 172px;
    margin-bottom: 7px;
    overflow: hidden;
    cursor: pointer;
  }
</style>