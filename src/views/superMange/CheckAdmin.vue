
<template>
  <div>
    <!--    搜索表单-->
    <div style="margin-bottom: 20px">
      <el-input style="width: 150px" placeholder="请输入名称" v-model="params.name"></el-input>
      <el-input style="width: 150px; margin-left: 5px" placeholder="请输入学号" v-model="params.studentId"></el-input>
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
    <el-table :data="tableData" stripe >
      <el-table-column prop="id" label="编号" width="50px"></el-table-column>
      <el-table-column prop="name" label="姓名" ></el-table-column>
      <el-table-column prop="sex" label="性别" ></el-table-column>
      <el-table-column prop="phone" label="电话" ></el-table-column>
      <el-table-column prop="studentId" label="学号" ></el-table-column>
      <el-table-column prop="academy" label="院系" ></el-table-column>
      <el-table-column prop="major" label="专业" ></el-table-column>
      <el-table-column prop="department" label="部门" ></el-table-column>
      <el-table-column prop="cardNumber" label="银行卡号" ></el-table-column>
      <el-table-column label="操作" width="200px">
        <template v-slot:default="scope" style="width: 200px" >
          <!--         scope.row是行数据-->

          <ShowAdmin ref="ShowAdmin"></ShowAdmin>
          <UpdateAdminShow @sendSuccess="SuccessUpdateAdminShow" ref="UpdateAdminShow"></UpdateAdminShow>


          <el-row>
            <el-button type="success" icon="el-icon-star-off" size="mini" @click="OpenShowAdminShow(scope.row.id)"></el-button>
            <el-button type="primary" icon="el-icon-edit" style="margin-left: 6px " size="mini" @click="OpenUpdateAdminShow(scope.row.id)"></el-button>
            <el-popconfirm title="这是一段内容确定删除吗？" @confirm="del(scope.row.id)">
              <el-button type="danger" icon="el-icon-delete"  size="mini" style="margin-left: 5px" slot="reference"></el-button>
            </el-popconfirm>
          </el-row>



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

import UpdateAdminShow from "@/views/superMange/UpdateAdmin.vue";
import AddAdminShow from "@/views/superMange/AddAdmin.vue";
import ShowAdmin from "@/views/superMange/ShowAdmin.vue";


export default {
  name:'test',
  components: {
    AddAdminShow,
    UpdateAdminShow,
    ShowAdmin,
  },
  data(){

    return {
      flag: true,
      tableData: [],
      total: 0,
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
        studentId: [
          {required: true, message: '请输入学号', trigger: 'blur'},
          {pattern: /^\d{10}$/, message: '学号格式不正确', trigger: 'blur'}
        ]
      },
      editAdminLog: false,
      addAdminLog: false,
    }
  },
  created() {

    this.load()

  },
  methods:{


    load() {
      request.get('/admin/page', {
        params: this.params
      }).then(res => {
        if (res.code === "success") {
          this.tableData = res.data.list
          this.total = res.data.total
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
    request.delete("admin/deleteAdmin/" + id).then(res => {
      if (res.code === "success") {
        this.$notify.success("删除成功");
        location.reload();
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
    OpenShowAdminShow(ID) {
      this.$refs.ShowAdmin.OpenShowAdminShow(ID);
    }
  }
}


</script>