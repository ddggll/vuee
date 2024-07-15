
<template>
  <div>
    <el-dialog title="人员信息" :visible.sync="ShowAdminLog" width="50%" center>
      <div style="padding: 20px ;margin: 20px;">
        <el-descriptions  :column="2" :size="'medium'" class="margin-top" border>
          <el-descriptions-item label="姓名">{{ form.name }}</el-descriptions-item>
          <el-descriptions-item label="性别">{{ form.sex }}</el-descriptions-item>
          <el-descriptions-item label="学号">{{ form.studentId }}</el-descriptions-item>
          <el-descriptions-item label="学院">{{ form.academy }}</el-descriptions-item>
          <el-descriptions-item label="专业">{{ form.major }}</el-descriptions-item>
          <el-descriptions-item label="部门">{{ form.department }}</el-descriptions-item>
          <el-descriptions-item label="电话">{{ form.phone }}</el-descriptions-item>
          <el-descriptions-item label="银行卡号">{{ form.cardNumber }}</el-descriptions-item>
          <el-descriptions-item label="QQ">{{ form.qq }}</el-descriptions-item>
          <el-descriptions-item label="微信">{{ form.weiXin }}</el-descriptions-item>
          <el-descriptions-item label="邮箱">{{ form.email }}</el-descriptions-item>
        </el-descriptions>
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