
<template>
<el-dialog title="添加成员" :visible.sync="addAdminLog" width="50%" center>
<div style="padding: 20px ;margin: 20px;width: 400px" class="form-area">
  <el-form  label-position="" :rules="rules" ref="form" label-width="80px" :model="form" :inline="flag" style="width: 600px;margin-left:auto;">
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
  <el-form  label-position="left" :rules="rules" ref="form" label-width="80px" :model="form" style="width: 510px;margin-left:40px;">
    <el-form-item label="地址" prop="address">
      <el-input v-model="form.address" placeholder="请输入地址"></el-input>
    </el-form-item>
    <el-form-item label="电话" prop="phone">
      <el-input v-model="form.phone" placeholder="请输入电话"></el-input>
    </el-form-item>
  </el-form>
</div>
<div style="text-align: center">
  <el-button type="primary" @click ="addAdmin" >提交</el-button>
  <!--      <el-button type="danger">取消</el-button>-->
</div>
</el-dialog>
</template>
<style scoped lang="scss">

</style>
<script>
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
        phone: ''
      },
      form: {
        name: '',
        age: '',
        sex: '男',
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
    addAdmin(){
      this.$refs["form"].validate((valid) => {
        if(valid)
        {
          request.post("/user/addAdmin",this.form).then(res => {
            if(res.code === "success"){
              this.$notify.success('新增成功')
              this.refresh()
            }
            else{
              this.$notify.error(res.msg);
            }
          })
        }
      })

    },
    refresh() {
      location.reload();
    },
    Opentan(){
      console.log('调用子组件方法');
      this.addAdminLog=true;


    }
  }
}
</script>