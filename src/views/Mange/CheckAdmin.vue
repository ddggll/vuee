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
      <el-button type="primary" style="margin-left: 650px" @click="addAdminLog = true">添加成员</el-button>
    </div>
    <el-table :data="tableData" stripe>
      <el-table-column prop="id" label="编号"></el-table-column>
      <el-table-column prop="name" label="名称"></el-table-column>
      <el-table-column prop="age" label="年龄"></el-table-column>
      <el-table-column prop="sex" label="性别"></el-table-column>
      <el-table-column prop="address" label="地址"></el-table-column>
      <el-table-column prop="phone" label="电话"></el-table-column>
      <el-table-column label="操作">
        <template v-slot:default="scope">
          <!--         scope.row是行数据-->
          <el-button type="primary" @click="pushId(scope.row)">编辑</el-button>
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


<!--    添加成员弹窗-->
    <el-dialog title="添加成员" :visible.sync="addAdminLog" width="50%" center>
      <div style="padding: 20px ;margin: 20px;width: 400px" class="form-area">
        <el-form  label-position="" rules="rules" label-width="80px" :model="form" inline="true" style="width: 600px;margin-left:auto;">
          <el-form-item label="姓名" prop="name">
            <el-input v-model="form.name" placeholder="请输入姓名"></el-input>
          </el-form-item>
          <el-form-item  label="年龄" prop="age">
            <el-input v-model="form.age" placeholder="请输入年龄"></el-input>
          </el-form-item>
          <el-form-item  label="性别">
            <el-radio v-model="form.sex" label="男">男</el-radio>
            <el-radio v-model="form.sex" label="女">女</el-radio>
          </el-form-item>
        </el-form>
        <el-form  label-position="left" rules="rules" label-width="80px" :model="form" style="width: 510px;margin-left:40px;">
          <el-form-item label="地址" prop="address">
            <el-input v-model="form.address" placeholder="请输入地址"></el-input>
          </el-form-item>
          <el-form-item label="电话" prop="phone">
            <el-input v-model="form.phone" placeholder="请输入电话"></el-input>
          </el-form-item>
        </el-form>
      </div>
      <div style="text-align: center">
        <el-button type="primary" @click="addAdmin" >提交</el-button>
        <!--      <el-button type="danger">取消</el-button>-->
      </div>
    </el-dialog>

<!--    修改信息-->
    <div>
      <el-dialog title="修改信息" :visible.sync="editAdminLog" width="50%" center>
      <div style="padding: 20px ;margin: 20px;width: 400px" class="form-area">
        <el-form  label-position="" rules="rules" label-width="80px" :model="form" inline="true" style="width: 600px;margin-left:auto;">
          <el-form-item label="姓名" prop="name">
            <el-input v-model="form.name" placeholder="请输入姓名"></el-input>
          </el-form-item>
          <el-form-item  label="年龄" prop="age">
            <el-input v-model="form.age" placeholder="请输入年龄"></el-input>
          </el-form-item>
          <el-form-item  label="性别">
            <el-radio v-model="form.sex" label="男">男</el-radio>
            <el-radio v-model="form.sex" label="女">女</el-radio>
          </el-form-item>
        </el-form>
        <el-form  label-position="left" rules="rules" label-width="80px" :model="form" style="width: 510px;margin-left:40px;">
          <el-form-item label="地址" prop="address">
            <el-input v-model="form.address" placeholder="请输入地址"></el-input>
          </el-form-item>
          <el-form-item label="电话" prop="phone">
            <el-input v-model="form.phone" placeholder="请输入电话"></el-input>
          </el-form-item>
        </el-form>
      </div>
      <div style="text-align: center">
        <el-button type="primary" @click="updateAdmin" >提交</el-button>
        <!--      <el-button type="danger">取消</el-button>-->
      </div>
      </el-dialog>
    </div>
  </div>
  </template>

<script>


import request from "@/utils/requeset";
import router from '@/router'
export default {
  name: 'test',
  data() {
    return {
      tableData: [],
      total: 0,
      params: {
        page: 1,
        size: 10,
        name: '',
        phone: ''
      },
      form: {
        name: '',
        age: '',
        sex: '',
        address: '',
        phone: ''
      },
      rules: {
        name: [
          {required :true,message:'请输入姓名',trigger:'blur'  },
          {min:1,message: '请输入合法姓名',trigger:'blur' }
        ],
        age: [
          {required: true,message:'请输入年龄',trigger:'blur'},
          {type: 'number',message:'年龄必须为数字',trigger: 'blur'}
        ],
        address: [
          {required: true,message:'请输入地址',trigger:'blur'}
        ],
        phone: [
          {required: true,message:'请输入电话号码',trigger: 'blur'},
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
  methods: {
    sendId(id){
      router.push(`/editAdmin/?id=${id}`)
    },
    load() {
      // fetch('http://localhost:9090/user/list').then(res => res.json()).then(res=> {
      //   console.log(res)
      //   this.tableData=res
      // })
      request.get('/user/page', {
        params: this.params
      }).then(res => {

        if (res.code === "success") {
          this.tableData = res.data.list
          this.total = res.data.total
        }
      })
    },
    reset() {
      this.params = {
        page: 1,
        size: 10,
        name: '',
        phone: ''
      }
      this.load()
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
    addAdmin(){
      request.post("/user/addAdmin",this.form).then(res => {
        if(res.code === "success"){
          this.$notify.success('新增成功')
          this.refresh()
        }
        else{
          this.$notify.error(res.msg);
        }
      })
    },
    updateAdmin(){
      request.put("/user/updateAdmin",this.form).then(res => {
        if(res.code === "success"){
          this.$notify.success('更新成功')
          this.editAdminLog=false
          this.refresh()
        }
        else{
          this.$notify.error(res.msg);
        }
      })
    },
    pushId(low){
      this.editAdminLog=true
      request.get("/user/" +low.id ).then(res => {
        this.form = res.data;
      })
    },
    refresh() {
      location.reload();
    }
  }
}
</script>