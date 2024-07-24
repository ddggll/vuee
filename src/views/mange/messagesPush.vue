<template>
<div>
  <div>
    <div style="margin-top: 20px;margin-left: 10px">
      <div style="margin-bottom: 20px">
        <el-input style="width: 150px" placeholder="请输入标题" v-model="params.headline"></el-input>
        <el-button style="margin-left: 5px " type="primary" @click="load">
          <i class="el-icon-search"></i>搜索
        </el-button>
        <el-button style="margin-left: 5px " type="warning" @click="reset">
          <i class="el-icon-refresh"></i>重置
        </el-button>
        <el-button type="primary" style="margin-left: 670px" @click="openTan" >添加通知
        </el-button>
      </div>

      <el-table :data="tableData" border  stripe>
        <el-table-column prop="id" label="编号" width="50px"></el-table-column>
        <el-table-column prop="headline" label="标题"></el-table-column>
        <el-table-column prop="address" label="地址">
          <template v-slot:default="scope">
            <a :href="scope.row.address">{{ scope.row.address }}</a>
          </template>
        </el-table-column>
<!--        <el-table-column prop="content" label="内容"></el-table-column>-->
        <el-table-column prop="time" label="时间"></el-table-column>
        <el-table-column label="操作">
          <template v-slot:default="scope">
            <el-button type="success" icon="el-icon-star-off" size="mini" @click="detail(scope.row.id)"></el-button>
            <el-button type="primary" icon="el-icon-edit" size="mini" @click="edit(scope.row.id)"></el-button>
            <el-popconfirm title="这是一段内容确定删除吗？" @confirm="del(scope.row.id)">
              <el-button type="danger" icon="el-icon-delete" size="mini" style="margin-left: 10px" slot="reference"></el-button>
            </el-popconfirm>
          </template>
        </el-table-column>

      </el-table>

    </div>

    <!--        分页-->
    <div style="margin-top: 20px ; width: 100%;display: flex;" >
      <div style="position: relative; margin-left: 1px;width: 100px">
        <p style="font-size:15px;margin-top: 2px">共{{ tableData.length }}条通知</p>
      </div>
      <div style="width: 200px;margin-left:900px">
        <el-pagination
            background
            :current-page="params.page"
            :page-size="params.size"
            layout="prev, pager, next"
            :total="tableData.length">
        </el-pagination>
      </div>
    </div>
  </div>

<!--  消息推送-->
  <div>
    <el-dialog title="消息推送" :visible.sync="editLog" width="60%" justify="center">
      <div>
        <el-form :model="form"  label-width="80px" style="margin-top: 20px">
          <el-form-item label="标题" prop="headline">
            <el-input v-model="form.headline" placeholder="请输入标题"></el-input>
          </el-form-item>
          <el-form-item label="地址" prop="address">
            <el-input v-model="form.address" placeholder="请输入地址"></el-input>
          </el-form-item>
          <el-form-item label="内容" prop="content">
            <el-input type="textarea" v-model="form.content" placeholder="请输入内容"></el-input>
          </el-form-item>

        </el-form>
        <div style="text-align: center">
          <el-button type="primary" @click="messagePush">提交</el-button>
          <el-button @click="editLog=false">取消</el-button>
        </div>

      </div>
    </el-dialog>
  </div>

<!--  详情-->
  <div>
    <el-dialog title="通知详情" :visible.sync="noticeLog" width="60%" center>
      <div>
        <el-descriptions title="详情" :column="1" :size="'medium'" class="margin-top" border>

          <el-descriptions-item label="标题">{{ form.headline }}</el-descriptions-item>
          <el-descriptions-item label="内容">{{ form.content }}</el-descriptions-item>
          <el-descriptions-item label="地址">{{ form.address }}</el-descriptions-item>
        </el-descriptions>
      </div>
    </el-dialog>
  </div>








</div>

</template>



<script>
import request from "@/utils/requeset";
import AddAdminShow from "@/views/superMange/AddAdmin.vue";


export default {
  components: {AddAdminShow},
  computed: {
    row() {
      return row
    }
  },
  data() {
    return {
      tableData: [],
      total: 0,
      page: 1,
      size: 10,
      params: {
        page: 1,
        size: 10,
       address: '',
        phone: '',
        opinion:'',
        state:'',
        id:''
      },
      editLog : false,
      noticeLog: false,
      form:{
        id:'',
        address:'',
        content:'',
        time:'',
        state:'',
        headline:'',
        type:''

      }
    }
  },
  mounted() {
    this.load();
  },
  methods:{
    load(){
      request.get("/message/page" ,{
        params:this.params}).then(res=>{
        if(res.code === "success") {
          this.tableData = res.data.list
          this.total = res.data.total
        }
      })
    },
    reset(){
      this.params ={
        size: 10,
        page:1,
        headline:'',
        address:'',
        content:'',
        time:'',
        state:'',
        id:''
      }
      this.load()
    },
    del(id){
      request.delete("/message/delete/"+id).then(res=>{
        if(res.code==="success"){
          this.$notify.success("删除成功！" )
          location.reload()
        }
        else{
          this.$notify(res.msg)
        }
      })
    },
    edit(id){
      request.get("/message/" + id).then(res=>{

        if(res.code === "success"){
          this.form = res.data;
          this.editLog = true;
        }
      })

    },
    detail(id){
      request.get("/message/" + id).then(res=>{

        if(res.code === "success"){
          this.form = res.data;
          this.noticeLog = true;
        }
      })
    },
    openTan(){
      this.editLog = true;
    },
    messagePush(){
      request.post("/message/add",this.form).then(res=>{
        if(res.code === "success"){
          this.$notify.success('新增成功')
          this.editLog=false
          this.load()
        }
        else{
          this.$notify.error(res.msg);
        }
      })

    }
  }
}
</script>


<style>

</style>