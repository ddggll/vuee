

<template>
    <div>
      <div style="margin-top: 20px">
        <div style="margin-bottom: 20px">
          <el-input style="width: 150px" placeholder="请输入名称" v-model="params.username"></el-input>
          <el-input style="width: 150px; margin-left: 5px" placeholder="请输入电话" v-model="params.phone"></el-input>
          <el-button style="margin-left: 5px " type="primary" @click="load">
            <i class="el-icon-search"></i>搜索
          </el-button>
          <el-button style="margin-left: 5px " type="warning" @click="reset">
            <i class="el-icon-refresh"></i>重置
          </el-button>
          <div >
            <el-menu class="el-menu-demo" mode="horizontal">
              <el-menu-item index="1" @click="set('')">全部预约</el-menu-item>
              <el-menu-item index="2" @click="set('0')">待处理</el-menu-item>
              <el-menu-item index="3" @click="set('1')">已处理</el-menu-item>
            </el-menu>
          </div>

        </div>
      </div>
      <div>
        <div style="height: 450px;text-align: center">
        <el-table :data="tableData" style="width: 100%; height: 100%;"
                  v-loading="loading"
                  element-loading-text="拼命加载中"
                  element-loading-spinner="el-icon-loading"
                  element-loading-background="rgba(0, 0, 0, 0.5)">
          <el-table-column prop="id" label="编号" width="50px"></el-table-column>
          <el-table-column prop="day" label="日期" width="100px"></el-table-column>
          <el-table-column prop="time" label="时间" ></el-table-column>
          <el-table-column prop="username" label="申请人"></el-table-column>
          <el-table-column prop="admin" label="学号"></el-table-column>
          <el-table-column prop="phone" label="联系电话"></el-table-column>
          <el-table-column prop="number" label="人数"></el-table-column>
          <el-table-column prop="site" label="使用场地"></el-table-column>
          <el-table-column prop="teacher" label="指导老师"></el-table-column>
          <el-table-column prop="opinion" label="处理意见"></el-table-column>
          <el-table-column label="操作">
            <template v-slot:default="scope">

              <el-button icon="el-icon-edit" v-if="scope.row.state==='0'" type=primary @click="handle(scope.row.id)"></el-button>
              <el-button icon="el-icon-check" v-if="scope.row.state==='1'" type=success @click="handle(scope.row.id)"></el-button>
              <el-popconfirm title="这是一段内容确定删除吗？" v-if="admin.superAdmin==='yes' " @confirm="del(scope.row.id)">
                <el-button icon="el-icon-delete" type="danger" style="margin-left: 5px" slot="reference"></el-button>
              </el-popconfirm>

            </template>

          </el-table-column>

        </el-table>
        </div>

<!--        分页-->
        <div style="margin-top: 20px ; width: 100%;display: flex;" >
          <div style="position: relative;">
            <p style="font-size:10px;margin-top: 2px">共{{ tableData.length }}条预约</p>
          </div>
          <div style="width: 200px;margin-left:1000px">
            <el-pagination
                background
                :current-page="params.page"
                :page-size="params.size"
                layout="prev, pager, next"
                @current-change="handleCurrentChange"
                :total="tableData.length">
            </el-pagination>
          </div>


        </div>




      </div>

      <div>
        <el-dialog title="西安理工大学“一站式学生社区场地使用申请表" :visible.sync="handleLog" width="60%" center>
          <div>
            <el-descriptions title="申请信息" :column="2" :size="'medium'" class="margin-top" border>
              <el-descriptions-item label="用户名">{{ form.username }}</el-descriptions-item>
              <el-descriptions-item label="学号">{{form.admin}}</el-descriptions-item>
              <el-descriptions-item label="手机号">{{ form.phone }}</el-descriptions-item>
              <el-descriptions-item label="使用学院或组织">{{ form.academy }}</el-descriptions-item>
              <el-descriptions-item label="活动人数">{{ form.number }}</el-descriptions-item>
              <el-descriptions-item label="活动日期">{{ form.day }}</el-descriptions-item>
              <el-descriptions-item label="活动时间">{{ form.time }}</el-descriptions-item>
              <el-descriptions-item label="活动内容">{{ form.content }}</el-descriptions-item>
              <el-descriptions-item label="使用场地">{{ form.site }}</el-descriptions-item>
              <el-descriptions-item label="使用设备">{{ form.equipment }}</el-descriptions-item>
              <el-descriptions-item label="指导老师">{{ form.teacher }}</el-descriptions-item>
            </el-descriptions>
            <div style="margin-top: 20px;margin-left: 500px">
              <p>审核意见 :{{form.opinion}}</p>

              <el-radio-group v-model="form.opinion" v-if="form.state==='0'" size="middle" style="margin-top: 20px">
                <el-radio v-model="form.opinion" label="通过">通过</el-radio>
                <el-radio v-model="form.opinion" label="不通过">不通过</el-radio>
                <el-button type="primary"   @click="submit">提交</el-button>

              </el-radio-group>
            </div>


          </div>
        </el-dialog>
      </div>


    </div>
</template>

<style scoped lang="scss">

</style>
<script>


import request from "@/utils/requeset";
import Cookies  from "js-cookie";



export default {
  computed: {

  },
  data(){
    return{
      admin: Cookies.get('admin')?JSON.parse(Cookies.get('admin')):{},
      handleLog : false,
      opinions:'',
      form:{
        username:'',
        admin:'',
        phone:'',
        content:'',
        time:'',
        day:'',
        site:'',
        equipment:'通过',
        teacher:'',
        opinion:'',
        state:'',
        id:'',
        academy:'',
        number:''
      },
      tableData: [],
      loading: true,
      handleFlag:'',
      params: {
        pageNum: 1,
        pageSize: 10,
        username: '',
        phone: '',
        opinion:'',
        state:'',
        time:'',
        day:'',
        id:''
      },
    }
  },
  mounted() {

     this.load();
  },
  methods:{
    load(){
      this.params.state = this.handleFlag
      request.get("application/page" ,{
        params:this.params}).then(res=>{
        if(res.code === "success") {
          this.loading=false
          console.log(res.data.list)
          this.tableData = res.data.list
          this.total = res.data.total
        }
      })
    },
    set(val){
      this.handleFlag=val
      this.load()
    },
    reset(){
      this.params = {
        pageNum: 1,
        pageSize: 10,
        username:'',
        phone:'',
        opinion:''
      }
    },
    // handleClose(done) {
    //   this.$confirm('确认关闭？')
    //       .then(_ => {
    //         done()
    //       })
    //       .catch(_ => {})
    // },
    handle(id){
      request.get("/application/"+id).then(res=>{
        this.form = res.data;
        if(res.code === "success"){
          this.handleLog = true;
        }
      })
    },
    submit(){
      this.form.opinion=this.form.opinion==='通过'?'通过':'不通过'
      this.form.state='1'
      console.log(this.form.opinion)
      request.put("/application/handleApplication",this.form).then(res=>{
        // console.log(res.code)
        if(res.code === "success"){
          this.$notify.success('更新成功')
          this.handleLog=false
          this.load()
           this.$emit('sendSuccess');
        }
        else{
          this.$notify.error(res.msg);
        }
      })
    },
    del(id){
      request.delete("/application/delete/"+id).then(res=>{
        if(res.code==="success"){
          this.$notify.success("删除成功！" )
          location.reload()
        }
        else{
          this.$notify(res.msg)
        }
      })
    }
  }

}
</script>