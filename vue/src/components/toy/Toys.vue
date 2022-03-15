<template>
    <div>
        <el-row style="height:840px;">
            <search-bar @onSearch="searchResult" ref="searchBar"></search-bar>
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
                    <div class="price"> 价 格 : {{item.price}} 元</div>
                </div>
                </el-card>
            </div>
            <edit-form ref="edit"></edit-form>
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
import EditForm from './EditForm'
import SearchBar from './SearchBar'
    export default {
        components: {EditForm ,SearchBar},
        name: 'Toys',
        data() {
            return {
                dialogFormVisible: false,
                toys: [],
                currentPage:1,
                pagesize:10
            }
        },
        mounted: function(){
            this.loadToys()
        },
        methods:{
            loadToys() {
                var _this=this
                this.$axios.get('/toys').then(res=>{
                    if(res && res.status===200){
                        _this.toys=res.data
                    }
                })
            },
            handleCurrentChange: function(currentPage) {
                this.currentPage=currentPage
                console.log(this.currentPage)
            },
            searchResult(){
                var _this =this
                this.$axios
                .get('/search?keywords='+this.$refs.searchBar.keywords,{
                }).then(res =>{
                    if(res && res.status===200){
                        _this.toys=res.data
                    }
                })
            },
            editToy(item){
                this.$refs.edit.dialogFormVisible=true
                this.$refs.edit.form ={
                    id:item.id,
                    // category: {
                    //     id:item.category.id.toString(),
                    //     name:item.category.name
                    // }
                }
                var url='user/'+item.id+'/userid'
                        this.$axios.get(url).then(resp=>{
                            if(resp && resp.status ===200){
                                this.$refs.edit.form={
                                    id:item.id,
                                    toyid: item.toyid,
                                    name:item.name,
                                    price:item.price,
                                    photo:item.photo,
                                    username:resp.data.username,
                                    telephone:resp.data.telephone,
                                    address:resp.data.address
                                }
                                
                            }
                        })
                // this.$axios.get('/toyid').then(res=>{
                //     if(res && res.status === 200){
                //         _this.toys=res.data
                //     }
                // })
                
            }
        }
    }
</script>
<style scoped>
    .photo {
        width: 150px;
        height: 172px;
        margin-bottom: 7px;
        overflow: hidden;
        cursor: pointer;
    }
    img {
        width: 150px;
        height: 172px;
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
    .switch {
        display: flex;
        position: absolute;
        left: 780px;
        top: 25px;
    }
    a {
        text-decoration: none;
    }
    a:link, a:visited, a:focus {
        color: #3377aa;
    }
</style>