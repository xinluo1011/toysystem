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
            <sell-item ref="itemsell"></sell-item>
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
import SellItem from './SellItem.vue'
export default {
    components:{SellItem},
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
            var url='user/'+this.username+'/user'
            this.$axios.get(url).then(resp=>{
                if(resp && resp.status===200){
                    var url='sid/'+resp.data+'/order'
                    this.$axios.get(url).then(res=>{
                        _this.order=res.data
                    })
                }
            })                    
        },
        handleCurrentChange: function(currentPage) {
                this.currentPage=currentPage
                console.log(this.currentPage)
            },
        editToy(item){
            this.$refs.itemsell.dialogFormVisible=true
            this.$refs.itemsell.form={
                toyid:item.tid,
                username:item.bname
            }
           var url='user/'+item.bname+'/name'
                this.$axios.get(url).then(res=>{
                    if(res && res.status === 200){
                        this.$refs.itemsell.form={
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