<template>
    <div>
        <el-row style="height:840px;">
            <div effect="dark" placement="right" 
                v-for="item in order.slice((currentPage-1)*pagesize,currentPage*pagesize)" 
                :key="item.oid">
                <el-card style="width: 170px;margin-bottom:30px;height: 100px;float: left;margin-right: 15px"
                class="order" bodyStyle="padding: 10px" shadow="hover" >
                <div class="info" >
                    <div class="name" @click="editToy(item)">
                        {{item.name}}
                    </div>
                </div>
                <div class="price">价 格 : {{item.price}} 元</div>
                </el-card>
            </div>
            <seller ref="seller"></seller>
        </el-row>
        <el-row>
            <el-pagination 
            @current-change="handleCurrentChange"
            :current-page="currentPage" 
            :page-size="pagesize" 
            :total="order.length">
            </el-pagination>
        </el-row>
    </div>
</template>
<script>
import Seller from './Seller.vue'
export default {
    components:{Seller},
    name: 'MyOrder',
    data() {
        return {
            username:JSON.parse(window.localStorage.getItem('user')).username,
            order:[],
            currentPage:1,
            pagesize:10
        }
    },
    mounted: function(){
        this.loadBuyerOrder()      
    },
    methods:{
        loadBuyerOrder(){
            var _this=this
            var url='bid/'+this.username+'/order'
            this.$axios.get(url).then(resp=>{
                if(resp && resp.status===200){
                    _this.order=resp.data
                }
            })                    
        },
        handleCurrentChange: function(currentPage) {
                this.currentPage=currentPage
                console.log(this.currentPage)
            },
        editToy(item){
            this.$refs.seller.dialogFormVisible=true
            this.$refs.seller.form={
                toyid:item.tid,
                id:item.sid
            }
           var url='user/'+item.sid+'/userid'
                this.$axios.get(url).then(res=>{
                    if(res && res.status === 200){
                        this.$refs.seller.form={
                            toyid: item.tid,
                            id:res.data.id,
                            price:item.price,
                            username:res.data.username,
                            telephone:res.data.telephone,
                            address:res.data.address
                    }
                    }
                })
            
    }
    },
    
}
</script>
<style scoped>

</style>