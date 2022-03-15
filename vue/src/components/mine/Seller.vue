<template>
    <div>
        <el-dialog title="订单信息" :visible.sync="dialogFormVisible" @close="clear" width="25%">
            <el-form class="text item" label-width="70px">
            <div class="photo"><img :src="form.photo"></div>
                <div> 玩 具 id: {{form.toyid}}</div>
                <div> 买 家 id: {{form.id}}</div>
                <div> 价 格 : {{form.price}}元</div>
                <div> 持 有 者 名 : {{form.username}}</div>
                <div> 联 系 电 话 : {{form.telephone}}</div>
                <div> 所 在 小 区 : {{form.address}}</div>
            </el-form>
        </el-dialog>
    </div>    
</template>
<script>
    export default {
        name: 'Seller',
        data() {
            return {
                dialogFormVisible: false,
                form: {
                    toyid:'',
                    price:'',
                    photo:'',
                    id:'',
                    username:'',
                    telephone:'',
                    address:'',
                },
                formLabelWidth: '120px'
            }
        },
        methods: {

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