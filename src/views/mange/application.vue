

<template>
    <div>
      <div>
        <div style="margin-bottom: 20px">
          <el-input style="width: 150px" placeholder="请输入名称" v-model="params.username"></el-input>
          <el-input style="width: 150px; margin-left: 5px" placeholder="请输入电话" v-model="params.phone"></el-input>
          <el-button style="margin-left: 5px " type="primary" @click="load">
            <i class="el-icon-search"></i>搜索
          </el-button>
          <el-button style="margin-left: 5px " type="warning" @click="reset">
            <i class="el-icon-refresh"></i>重置
          </el-button>
          <div>
            <el-menu
                :default-active="activeIndex2"
                class="el-menu-demo"
                mode="horizontal"
                @select="handleSelect">
              <el-menu-item index="1" @click="load">全部预约</el-menu-item>
              <el-menu-item index="2" @click="handle">待处理</el-menu-item>
              <el-menu-item index="3" @click="handled">已处理</el-menu-item>
            </el-menu>
          </div>

        </div>
      </div>
      <div>
        <el-table :data="tableData" style="width: 100%">
          <el-table-column prop="date" label="日期"></el-table-column>
          <el-table-column prop="username" label="申请人"></el-table-column>
          <el-table-column prop="phone" label="联系电话"></el-table-column>
          <el-table-column prop="site" label="使用场地"></el-table-column>
          <el-table-column prop="teacher" label="指导老师"></el-table-column>
          <el-table-column prop="opinion" label="处理意见"></el-table-column>
          <el-table-column label="操作"></el-table-column>
        </el-table>
      </div>




    </div>
</template>

<style scoped lang="scss">

</style>
<script>


import request from "@/utils/requeset";
import AddAdminShow from "@/views/superMange/AddAdmin.vue";

export default {
  components: {
    AddAdminShow

  },
  data(){
    return{
      tableData: [],
      params: {
        page: 1,
        size: 10,
        username: '',
        phone: '',
        opinion:'',
        stata:''
      },
    }
  },
  created() {
    this.load();
  },
  methods:{
    load(){
      this.params.stata='同意'
      request.get("application/page" ,{
        params:this.params}).then(res=>{
        if(res.code === "success") {
          console.log(res.data.list)
          this.tableData = res.data.list
          this.total = res.data.total
        }
      })
    },
    reset(){
      this.params = {
        page: 1,
        size: 10,
        username:'',
        phone:'',
        opinion:''
      }
    },
    handleSelect(val){
      console.log(val)
    }
  }

}
</script>