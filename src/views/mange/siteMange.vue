<template>
<div>
  <div style="margin-top: 20px">
    <el-input style="width: 150px" placeholder="请输入地点" v-model="params.siteName"></el-input>
    <el-input style="width: 150px; margin-left: 5px" placeholder="请输入地址" v-model="params.siteAddress"></el-input>
    <el-input style="width: 150px; margin-left: 5px" placeholder="请输入类型" v-model="params.siteType"></el-input>
    <el-button style="margin-left: 5px " type="primary" @click="load">
      <i class="el-icon-search"></i>搜索
    </el-button>
    <el-button style="margin-left: 5px " type="warning" @click="reset">
      <i class="el-icon-refresh"></i>重置
    </el-button>
    <el-button type="primary" style="margin-left: 530px" @click="addSiteLogOpen" >添加场地
    </el-button>

    <div>
      <el-menu class="el-menu-demo" mode="horizontal">
        <el-menu-item index="1">全部场地</el-menu-item>
      </el-menu>
    </div>

<!--    <el-button type="primary" style="margin-left: 670px" @click="openTan" >添加通知-->
<!--    </el-button>-->
    </div>
  <div style="height:500px">
    <el-table :data="tableData" border  stripe style="height: 100%"
              v-loading="loading"
              element-loading-text="拼命加载中"
              element-loading-spinner="el-icon-loading"
              element-loading-background="rgba(0, 0, 0, 0.8)">

      <el-table-column prop="id" label="编号" width="50px"></el-table-column>
      <el-table-column prop="siteName" label="地点名称"></el-table-column>
      <el-table-column prop="siteAddress" label="地点地址"></el-table-column>
      <el-table-column prop="number" label="地点容量"></el-table-column>
      <el-table-column prop="siteType" label="地点类型"></el-table-column>
      <el-table-column prop="siteState" label="地点状态">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.siteState==='1'" type="success">正常</el-tag>
          <el-tag v-else type="danger">禁用</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="150px">
        <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit" style="margin-left: 6px " size="mini" @click="handle(scope.row.id)"></el-button>
          <el-popconfirm title="这是一段内容确定删除吗？" @confirm="del(scope.row.id)">
            <el-button type="danger" icon="el-icon-delete"  size="mini" style="margin-left: 5px" slot="reference"></el-button>
          </el-popconfirm>
        </template>
      </el-table-column>


      <!--        <el-table-column prop="content" label="内容"></el-table-column>-->
    </el-table>
  </div>
  <div style="margin-top: 20px ; width: 100%;display: flex;" >
    <div style="position: relative; margin-left: 1px;width: 100%">
      <p style="font-size:10px;margin-top: 2px">共{{ tableData.length }}个场地</p>
    </div>
    <div style="width: 200px;margin-left:900px">
      <el-pagination
          background
          :current-page="params.pageNum"
          :page-size="params.pageSize"
          @current-change="next"
          layout="prev, pager, next"
          :total="total">
      </el-pagination>

    </div>
  </div>

<!--修改场地信息表单-->
  <div>
    <el-dialog title="场地管理" :visible.sync="handleLog" width="60%" center>
      <div>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="场地名称">
            <el-input v-model="form.siteName"></el-input>
          </el-form-item>
          <el-form-item label="场地地址">
            <el-input v-model="form.siteAddress"></el-input>
          </el-form-item>
          <el-form-item label="场地容量">
            <el-input v-model="form.number"></el-input>
          </el-form-item>
          <el-form-item label="场地类型">
            <el-input v-model="form.siteType"></el-input>
          </el-form-item>
          <el-form-item label="场地图片">
            <img :src="form.photo" :alt="form.imageUrl" style="width: 100px">
          </el-form-item>
          <el-form-item label="场地状态">
            <el-switch
                v-model="value"
                active-text="正常"
                inactive-text="禁用">
            </el-switch>
          </el-form-item>
          <el-button type="primary" @click="submit">提交</el-button>

        </el-form>
      </div>

    </el-dialog>
  </div>
<!--添加场地-->
  <div>
    <el-dialog title="场地添加" :visible.sync="addSiteLog" width="60%" center>
      <div>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="场地名称">
            <el-input v-model="form.siteName"></el-input>
          </el-form-item>
          <el-form-item label="场地地址">
            <el-input v-model="form.siteAddress"></el-input>
          </el-form-item>
          <el-form-item label="场地容量">
            <el-input v-model="form.number"></el-input>
          </el-form-item>
          <el-form-item label="场地类型">
            <el-input v-model="form.siteType"></el-input>
          </el-form-item>
          <el-form-item label="场地图片">
            <el-input v-model="form.imageUrl"></el-input>
          </el-form-item>
          <el-form-item label="场地状态">
            <el-switch
                v-model="value"
                active-text="正常"
                inactive-text="禁用">
            </el-switch>
          </el-form-item>
          <el-button type="primary" @click="addSubmit">提交</el-button>

        </el-form>
      </div>

    </el-dialog>
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
      loading: true,
      options: [],
      tableData: [],
      total: 0,
      pageNum: 1,
      pageSize: 20,
      params: {
        pageNum: 1,
        pageSize: 10,
        siteState:'',
        siteName:'',
        siteAddress:'',
        siteType:'',
      },
      form:{
        id:'',
        imageUrl:'',
        siteName:'',
        siteAddress:'',
        number:'',
        siteType:'',
        siteState:'',
        photo:'',
      },
      handleLog:false,
      addSiteLog:false,
      value: 'ture'
    }

  },
  mounted() {
    this.load();
  },
  methods:{
    next(newPage){
      this.params.pageNum=newPage
      this.load();
    },
    load(){
      request.get("/site/page" ,{
        params:this.params}).then(res=>{
        if(res.code === "success") {
          this.loading=false
          this.tableData = res.data.list
          this.total = res.data.total
          console.log(this.total)
        }
      })
    },
    reset(){
      this.params ={
        pageNum: 1,
        pageSize: 10,
        siteState:'',
        siteName:'',
        siteAddress:'',
        siteType:'',
        siteId:''
      }
    },
    del(id){

        request.delete("/site/delete/"+id).then(res=>{
          if(res.code === "success"){
            this.$message({
              type: 'success',
              message: '删除成功!'
            });
            this.load()
          }
        })
    },
    handle(id){
      request.get("/site/"+id).then(res=>{
          this.form=res.data
        this.form.photo= 'http://36.133.97.46:9999/images/' + this.form.imageUrl
        this.value=this.form.siteState === '1'
        if(res.code==="success"){
          console.log(this.form.photo)
          this.handleLog=true;
        }
      })
    },
    submit(){
      this.form.siteState=this.value?'1':'0';
      console.log(this.value)
      request.put("/site/siteUpdate",this.form).then(res=>{
        if(res.code==="success"){
          this.$notify.success("更新成功！");
          this.handleLog=false;
          this.load();
        }
        else{
          console.log(res.msg);
        }
      })
    },
    addSiteLogOpen(){
      this.addSiteLog=true;
    },
    addSubmit(){
      request.post("/site/siteAdd",this.form).then(res=>{
        if(res.code==="success"){
          this.$notify.success("新增成功!");
          this.addSiteLog=false;
          this.load();
        }
      })
    }

  }
}
</script>