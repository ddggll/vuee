<template>
  <div>
    <el-form ref="loginForm" :model="form" :rules="rules" label-width="8epx" class="login-box">
      <h3 class="login-title">管理员登录</h3>

      <el-form-item label="账号" prop="studentId">
        <el-input type="text" placeholder="请输入账号" v-model="form.studentId"/>
      </el-form-item>

      <el-form-item label="密码" prop="password">
        <el-input type="password" show-password placeholder="请输入密码" v-model="form.password"/>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="login">登录</el-button>
        <el-form>
          <router-link to="/user">
            <el-radio v-model="radio" label="1">用户</el-radio>
          </router-link>
          <router-link to="/admin">
            <el-radio v-model="radio" label="2">管理员</el-radio>
          </router-link>
        </el-form>

      </el-form-item>
    </el-form>

    <el-dialog
        title="温馨提示"
        :visible.sync="dialogVisible"
        width="30%"
        :before-close="handleClose">
      <span>请输入账号和密码</span>
      <span slot="footer" class="dialog-footer">
            <el-button type="primary" @click="dialogVisible = false">确定</el-button>
          </span>
    </el-dialog>
  </div>
</template>

<script>

import request from "@/utils/requeset";

export default {
  name: 'AboutView',
  data() {
    return {
      radio: '2',
      form: {
        name: '',
        password: '',
        studentId:''
      },
      //表单验证，需要在el-form-item元素中增加 prop 属性
      rules: {
        studentId: [
          {required: true, message: '账号不可为空', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '密码不可为空', trigger: 'blur'}
        ]
      },
      //对话框显示和隐藏
      dialogVisible: false
    }
  },
  methods: {
    login(){
      this.$refs["loginForm"].validate((valid) => {
        if (valid) {
          request.post('admin/login', this.form).then((res) => {
            if (res.code === "success") {
              this.$notify.success("登录成功")
              this.$router.push('/layout')
            } else {
              this.$notify.error(res.msg);
            }
          })
        }
    })
    },
    handleClose(){
      // 实现关闭的逻辑
      console.log('Closing...');
      // 可能需要通知父组件或其他组件
      this.$emit('close');
    }
  }
}

</script>
<style lang="scss" scoped>
.login-box {
  border: 1px solid #DCDFE6;
  width: 350px;
  margin: 18px auto;
  padding: 35px 35px 15px 35px;
  border-radius: 5px;
  -webkit-border-radius: 5px;
  -moz-border-radius: 5px;
  box-shadow: 0 0 25px #909399;
  background-color: white;
}

.login-title {
  text-align: center;
  margin: 0 auto 40px auto;
  color: #303133;
}
</style>
