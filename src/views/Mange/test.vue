<script>
import request from "@/utils/requeset";
export default {
  name: "test",
  data() {
    return {
      form: {
        name: '',
        age: '',
        sex: '',
        address: '',
        phone: ''
      },
      radio: '男',

      centerDialogVisible: false,
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

<template>
<div>
  <el-button type="text" @click="centerDialogVisible = true">点击打开 Dialog</el-button>
  <el-dialog title="提示" :visible.sync="centerDialogVisible" width="50%" center>
    <h2 style="text-align: center">新增成员</h2>
    <div class="login-box">
      <el-form  label-position="labelPosition" label-width="80px"  model="form" :inline="true">
        <el-form-item label="姓名" style="width: 300px;">
          <el-input v-model="form.name" placeholder="请输入姓名"></el-input>
        </el-form-item>
        <el-form-item  label="年龄" style="width: 300px;">
          <el-input v-model="form.age" placeholder="请输入年龄"></el-input>
        </el-form-item>
        <br>
        <el-form-item  label="性别">
          <!--       <el-input v-model="form.sex" placeholder="请输入性别"></el-input>-->
          <el-radio v-model="form.sex" label="男">男</el-radio>
          <el-radio v-model="form.sex" label="女">女</el-radio>
        </el-form-item>
        <br>
        <el-form-item label="地址" style="width: 300px;">
          <el-input v-model="form.address" placeholder="请输入地址"></el-input>
        </el-form-item>
        <br>
        <el-form-item label="电话" style="width: 300px;">
          <el-input v-model="form.phone" placeholder="请输入电话"></el-input>
        </el-form-item>
      </el-form>
    </div>
    <div style="text-align: center">
      <el-button type="primary"  @click="addAdmin">提交</el-button>
      <!--      <el-button type="danger">取消</el-button>-->
    </div>


  </el-dialog>
</div>

</template>

<style scoped lang="scss">
.login-box {
 // border: 0px solid #DCDFE6;
  width: 60%;
  margin: 18px auto;
  padding: 35px 35px 15px 35px;
  border-radius: 0px;
  //-webkit-border-radius: 5px;
  //-moz-border-radius: 5px;
  //box-shadow: 0 0 25px #909399;
  //background-color: white;
}

</style>