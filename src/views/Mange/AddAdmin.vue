<template>
  <div>
    <h2 style="margin-left: 200px">新增成员</h2>
    <div style="padding: 20px ;margin-left: 300px;width: 600px;border: blue solid 1px " class="demo-form-inline">
      <el-form  label-position="top" label-width="80px" :model="form" style="width: 600px;margin-left:auto;" :inline="true">
        <el-form-item label="姓名" style="width: 100px;">
          <el-input v-model="form.name" placeholder="请输入姓名"></el-input>
        </el-form-item>
        <el-form-item  label="年龄" style="width: 100px;">
          <el-input v-model="form.age" placeholder="请输入年龄"></el-input>
        </el-form-item>
        <br>
        <el-form-item  label="性别">
          <!--       <el-input v-model="form.sex" placeholder="请输入性别"></el-input>-->
          <el-radio v-model="form.sex" label="男">男</el-radio>
          <el-radio v-model="form.sex" label="女">女</el-radio>
        </el-form-item>
        <br>
        <el-form-item label="地址" style="width: 200px;">
          <el-input v-model="form.address" placeholder="请输入地址"></el-input>
        </el-form-item>
        <br>
        <el-form-item label="电话" style="width: 200px;">
          <el-input v-model="form.phone" placeholder="请输入电话"></el-input>
        </el-form-item>
      </el-form>
    </div>
    <div style="text-align: center">
      <el-button type="primary"  @click="addAdmin">提交</el-button>
      <!--      <el-button type="danger">取消</el-button>-->
    </div>
  </div>
</template>

<style  lang="scss">
//.el-form .el-form-item:nth-child(2) .el-input__inner{
//  width: 100px;
//}
//.el-form .el-form-item:nth-child(3) .el-input__inner{
//  width: 100px;
//}
.el-f{
  width:100px;
}
</style>
<script>
import request from "@/utils/requeset";

export default {
  name: "addAdmin",
  data() {
    return {
      form: {
        name: '',
        age: '',
        sex: '',
        address: '',
        phone: ''
      },
      radio: '男'

    }
  },
  methods: {

    addAdmin(){
      request.post("/user/addAdmin",this.form).then(res => {
        if(res.code === "success"){
          this.$notify.success('新增成功')
          this.form={}
        }
        else{
          this.$notify.error(res.msg);
        }
      })
    }
  }
}
</script>