
<template>
  <div>
    <el-dialog title="修改信息" :visible.sync="editAdminLog" width="50%" center>
      <div style="padding: 20px ;margin: 20px;width: 400px" class="form-area">
        <el-form  label-position="" :rules="rules" ref="form" label-width="80px" :model="form" :inline="flag" style="width: 600px;margin-left:auto;">
          <el-form-item label="姓名" prop="name">
            <el-input v-model="form.name" placeholder="请输入姓名"></el-input>
          </el-form-item>
          <el-form-item  label="性别">
            <el-radio v-model="form.sex" label="男">男</el-radio>
            <el-radio v-model="form.sex" label="女">女</el-radio>
          </el-form-item>
        </el-form>
        <el-form  label-position="left" :rules="rules" ref="form" label-width="80px" :model="form" style="width: 510px;margin-left:40px;">
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
      <div style="text-align: center">
        <el-button type="primary" @click="updateAdmin" >提交</el-button>
        <!--      <el-button type="danger">取消</el-button>-->
      </div>
    </el-dialog>
  </div>
</template>

<style scoped lang="scss">

</style>
<script>
import AddAdminShow from "@/views/superMange/AddAdmin.vue";
import router from "@/router";
import request from "@/utils/requeset";

export default {
  name: 'test',
  data() {

    const checkAge = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('年龄不能为空'));
      }if (!/^[0-9]+$/.test(value)) {
        callback(new Error('请输入数字值'));
      }
      callback()

    };
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
      rules: {
        name: [
          {required :true,message:'请输入姓名',trigger:'blur'  },
          {min:1,message: '请输入合法姓名',trigger:'blur' }
        ],
        age: [
          {required: true,message:'请输入年龄',trigger:'blur'},
          {validator:checkAge,trigger: 'blur'}
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

  },
  methods: {
    updateAdmin(){
      this.$refs["form"].validate((valid)=>{
        if(valid)
        {
          request.put("/admin/updateAdmin",this.form).then(res => {
            if(res.code === "success"){
              this.$notify.success('更新成功')
              this.editAdminLog=false
              this.$emit('sendSuccess');
              // this.refresh()
            }
            else{
              this.$notify.error(res.msg);
            }
          })
        }
      })

    },
    pushId(ID){
      this.editAdminLog=true
      request.get("/admin/" +ID ).then(res => {
        this.form = res.data;
        //this.editAdminLog=true;
      })
    },
    OpenUpdateAdminShow(ID){
      this.pushId(ID);
    }
  }
}</script>