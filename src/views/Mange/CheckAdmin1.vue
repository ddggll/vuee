
<template>
  <div>
    <!--    搜索表单-->
    <div style="margin-bottom: 20px">
      <el-input style="width: 150px" placeholder="请输入名称" v-model="params.name"></el-input>
      <el-input style="width: 150px; margin-left: 5px" placeholder="请输入学号" v-model="params.phone"></el-input>
      <el-button style="margin-left: 5px " type="primary" @click="load">
        <i class="el-icon-search"></i>搜索
      </el-button>
      <el-button style="margin-left: 5px " type="warning" @click="reset">
        <i class="el-icon-refresh"></i>重置
      </el-button>
      <AddAdminShow ref="AddAdminShow"></AddAdminShow>
      <el-button type="primary" style="margin-left: 650px" @click="OpenAddAdminShow" >添加成员
      </el-button>
    </div>
    <el-table :data="tableData" stripe>
      <el-table-column prop="id" label="编号" width="50px"></el-table-column>
      <el-table-column prop="name" label="姓名" width="80px"></el-table-column>
      <el-table-column prop="sex" label="性别"></el-table-column>
      <el-table-column prop="phone" label="电话"></el-table-column>
      <el-table-column prop="studentId" label="学号"></el-table-column>
      <el-table-column prop="academy" label="院系"></el-table-column>
      <el-table-column prop="major" label="专业"></el-table-column>
      <el-table-column prop="department" label="部门"></el-table-column>
      <el-table-column prop="cardNumber" label="银行卡号"></el-table-column>
      <el-table-column label="操作">
        <template v-slot:default="scope">
          <!--         scope.row是行数据-->
          <UpdateAdminShow @sendSuccess="SuccessUpdateAdminShow" ref="UpdateAdminShow"></UpdateAdminShow>
          <el-button type="primary" @click="OpenUpdateAdminShow(scope.row.id)">编辑1</el-button>
          <el-popconfirm
              title="这是一段内容确定删除吗？"
              @confirm="del(scope.row.id)"
          >
            <el-button type="danger" style="margin-left: 5px" slot="reference">删除</el-button>

          </el-popconfirm>
        </template>
      </el-table-column>

    </el-table>
    <!--    分页-->
    <div style="margin-top: 20px">
      <el-pagination
          background
          :current-page="params.page"
          :page-size="params.size"
          layout="prev, pager, next"
          @current-change="handleCurrentChange"
          :total="total">
      </el-pagination>

    </div>
  </div>

</template>

<style scoped lang="scss">

</style>

<script>

import request from "@/utils/requeset";
import router from '@/router';
import UpdateAdminShow from "@/views/Mange/UpdateAdmin.vue";
import AddAdminShow from "@/views/Mange/AddAdmin.vue";


export default {
  name:'test',
  components: {
    AddAdminShow,
    UpdateAdminShow,
  },
  data(){

    const checkAge = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('年龄不能为空'));
      }if (!/^[0-9]+$/.test(value)) {
        callback(new Error('请输入数字值'));
      }
      callback()

    };
    return {
      flag: true,
      tableData: [],
      total: 0,
      form: {
        name: '',
        sex: '',
        studentId: '',
        academy: '',
        major: '',
        phone: '',
        department: '',
        carNumber: '',
        qq: '',
        weiXin: '',
        email: ''

      },
      params: {
        page: 1,
        size: 10,
        name: '',
        studentId: ''
      },
      rules: {
        name: [
          {required: true, message: '请输入姓名', trigger: 'blur'},
          {min: 1, message: '请输入合法姓名', trigger: 'blur'}
        ],
        phone: [
          {required: true, message: '请输入电话号码', trigger: 'blur'},
          {pattern: /^1[3456789]\d{9}$/, message: '手机号码格式不正确', trigger: 'blur'}
        ]
      },
      radio: '男',
      editAdminLog: false,
      addAdminLog: false,
    }
  },
  created() {

    this.load()

  },
  methods:{


    load() {
      // fetch('http://localhost:9090/user/list').then(res => res.json()).then(res=> {
      //   console.log(res)
      //   this.tableData=res
      // })
      request.get('/admin/page', {
        params: this.params
      }).then(res => {
        if (res.code === "success") {
          this.tableData = res.data.list
          this.total = res.data.total
          console.log(this.tableData)
        }

      })
    },
  reset(){
    this.params = {
      page: 1,
      size: 10,
      name:'',
      studentId: ''
    }
  },
  handleCurrentChange(page) {
    //点击分页按钮触发
    this.params.page = page;
    this.load()
  },
  del(id){
    request.delete("user/deleteAdmin/" + id).then(res => {
      if (res.code === "success") {
        this.$notify.success("删除成功");
        this.load()
      }
      else {
        this.$notify.error(res.msg);
      }
    })
  },
  OpenAddAdminShow(){
    this.$refs.AddAdminShow.Opentan();
  },
  SuccessUpdateAdminShow(){
    this.load();
  },
  OpenUpdateAdminShow(ID){
    this.$refs.UpdateAdminShow.OpenUpdateAdminShow(ID);
  },
}
}


</script>