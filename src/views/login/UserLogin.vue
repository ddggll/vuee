<template>
  <div >
    <el-form ref="loginForm" :model="form" :rules="rules" label-width="8epx" class="login-box">
      <h3 class="login-title">用户登录</h3>
      <el-form-item label="账号" prop="username">
        <el-input type="text" placeholder="请输入账号" v-model="form.username"/>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input type="password" placeholder="请输入密码" v-model="form.password"/>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" v-on:click="onSubmit('loginForm')">登录</el-button>
        <a href="http://localhost:8082/home">忘记密码</a>
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
       >
      <span>请输入账号和密码</span>
      <span slot="footer" class="dialog-footer">
            <el-button type="primary" @click="dialogVisible = false">确定</el-button>
          </span>
    </el-dialog>
  </div>
</template>

<script>

export default {
  name: 'UserView',
  data() {
    return {
      radio: '1',
      form: {
        username: '',
        password: ''
      },
      //表单验证，需要在el-form-item元素中增加 prop 属性
      rules: {
        username: [
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
    onSubmit(formName) {
      //为表单绑定验证功能
      this.$refs[formName].validate((valid) => {
        if (valid) {
          //使用vue-router路由到指定页面，该方式称之为编程式导航
          this.$router.push("/main");
        } else {
          this.dialogVisible = true;
          return false;
        }
      });
    },
    handleClose() {
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
