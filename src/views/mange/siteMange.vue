<template>
<div>
  <div style="margin-bottom: 20px">
    <el-input style="width: 150px" placeholder="请输入地点" v-model="params.siteName"></el-input>
    <el-input style="width: 150px" placeholder="请输入地址" v-model="params.siteAddress"></el-input>
    <el-input style="width: 150px" placeholder="请输入类型" v-model="params.siteType"></el-input>

    <el-button style="margin-left: 5px " type="primary" @click="load">
      <i class="el-icon-search"></i>搜索
    </el-button>
    <el-button style="margin-left: 5px " type="warning" @click="reset">
      <i class="el-icon-refresh"></i>重置
    </el-button>
<!--    <el-button type="primary" style="margin-left: 670px" @click="openTan" >添加通知-->
<!--    </el-button>-->
    </div>
  <div style="height:450px">
    <el-table :data="tableData" border  stripe style="height: 100%"
              v-loading="loading"
              element-loading-text="拼命加载中"
              element-loading-spinner="el-icon-loading"
              element-loading-background="rgba(0, 0, 0, 0.8)">
      <el-table-column prop="id" label="编号" width="50px"></el-table-column>
      <el-table-column prop="siteName" label="地点名称"></el-table-column>
      <el-table-column prop="siteAddress" label="地点地址"></el-table-column>
      <el-table-column prop="number" label="地点容量"></el-table-column>

      <!--        <el-table-column prop="content" label="内容"></el-table-column>-->



    </el-table>
  </div>
</div>
</template>

<style>

</style>

<script>


import request from "@/utils/requeset";

export default {
  data(){
    return {
      loading: false,
      options: [],
      tableData: [],
      total: 0,
      page: 1,
      size: 10,
      params: {
        page: 1,
        size: 10,
        siteState:'',
        siteName:'',
        siteAddress:'',
        siteType:'',
      },
      value: ''
    }

  },
  mounted() {
    this.load();
  },
  methods:{
    load(){
      request.get("/site/page" ,{
        params:this.params}).then(res=>{
        if(res.code === "success") {
          this.loading=false
          this.tableData = res.data.list
          this.total = res.data.total
        }
      })
    },
    reset(){
      this.params ={
        page: 1,
        size: 10,
        siteState:'',
        siteName:'',
        siteAddress:'',
        siteType:'',
        siteId:''
      }
    }
  }
}
</script>