
<template>
  <div>
    <el-dialog title="信息" :visible.sync="ShowAdminLog" width="50%" center>
      <div style="padding: 20px ;margin: 20px;width: 400px" class="form-area">
        <el-form  label-position=""  ref="form" label-width="80px" :model="form" :inline="flag" style="width: 600px;margin-left:auto;">
          <el-form-item label="姓名" prop="name">
            <el-input v-model="form.name" placeholder="请输入姓名"></el-input>
          </el-form-item>
          <el-form-item  label="性别">
            <el-radio v-model="form.sex" label="男">男</el-radio>
            <el-radio v-model="form.sex" label="女">女</el-radio>
          </el-form-item>
        </el-form>
        <el-form  label-position="left"  ref="form" label-width="80px" :model="form" style="width: 510px;margin-left:40px;">
          <el-form-item label="学号" prop="studentId">
            <el-input v-model="form.studentId" placeholder="请输入学号"></el-input>
          </el-form-item>
          <el-form-item label="学院" prop="academy">
            <el-input v-model="form.academy" placeholder="请输入学院"></el-input>
          </el-form-item>
          <el-form-item label="专业" prop="major">
            <el-input v-model="form.major" placeholder="请输入专业"></el-input>
          </el-form-item>
          <el-form-item label="部门" prop="department">
            <el-input v-model="form.department" placeholder="请输入部门"></el-input>
          </el-form-item>
          <el-form-item label="电话" prop="phone">
            <el-input v-model="form.phone" placeholder="请输入电话"></el-input>
          </el-form-item>
          <el-form-item label="银行卡号" prop="cardNumber">
            <el-input v-model="form.cardNumber" placeholder="请输入银行卡号"></el-input>
          </el-form-item>
          <el-form-item label="QQ" prop="qq">
            <el-input v-model="form.qq" placeholder="请输入QQ"></el-input>
          </el-form-item>
          <el-form-item label="微信" prop="weiXin">
            <el-input v-model="form.weiXin" placeholder="请输入微信"></el-input>
          </el-form-item>
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="form.email" placeholder="请输入邮箱"></el-input>
          </el-form-item>
        </el-form>
      </div>
    </el-dialog>
  </div>
</template>

<style scoped lang="scss">

</style>
<script>
import request from "@/utils/requeset";

export default {
  data() {
    return {
      flag:true,
      tableData: [],
      total: 0,
      params: {
        page: 1,
        size: 10,
        name: '',
        studentId: ''
      },
      form: {
        name: '',
        sex: '',
        studentId: '',
        academy: '',
        major: '',
        phone: '',
        department: '',
        cardNumber: '',
        qq: '',
        weiXin: '',
        email: ''

      },
      ShowAdminLog: false
    }
  },
  methods:{
    pushId(ID){
      this.ShowAdminLog=true
      request.get("/admin/" +ID ).then(res => {
        this.form = res.data;
        //this.editAdminLog=true;
      })
    },
    OpenShowAdminShow(ID){
      this.pushId(ID);
    }
  }
}

</script>