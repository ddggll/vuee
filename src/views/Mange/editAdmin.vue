<template>
  <div>
    <h2>修改信息</h2>
    <div style="padding: 20px ;margin: 20px;width: 400px" class="form-area">
      <el-form  label-position="" label-width="80px" :model="form" ;inline="true" style="width: 600px;margin-left:auto;">
        <el-form-item label="姓名">
          <el-input v-model="form.name" placeholder="请输入姓名"></el-input>
        </el-form-item>
        <el-form-item  label="年龄">
          <el-input v-model="form.age" placeholder="请输入年龄"></el-input>
        </el-form-item>
        <el-form-item  label="性别">
          <el-radio v-model="form.sex" label="男">男</el-radio>
          <el-radio v-model="form.sex" label="女">女</el-radio>
        </el-form-item>
      </el-form>
      <el-form  label-position="top" label-width="80px" :model="form" style="width: 600px;margin-left:40px;">
        <el-form-item label="地址">
          <el-input v-model="form.address" placeholder="请输入地址"></el-input>
        </el-form-item>
        <el-form-item label="电话">
          <el-input v-model="form.phone" placeholder="请输入电话"></el-input>
        </el-form-item>
      </el-form>
    </div>
    <div style="text-align: center">
      <el-button type="primary" @click="addAdmin" >提交</el-button>
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
import router from "@/router/index";

export default {
  name: "editAdmin",
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
  created() {
    request.get("/user/" +router.currentRoute.query.id ).then(res => {
      this.form = res.data;
    })
  },
  methods: {

    addAdmin(){
      request.put("/user/updateAdmin",this.form).then(res => {
        if(res.code === "success"){
          this.$notify.success('更新成功')
          this.$router.push({path:"/checkAdmin"})
        }
        else{
          this.$notify.error(res.msg);
        }
      })
    }
  }
}
</script>