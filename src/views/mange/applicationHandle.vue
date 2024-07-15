<template>
  <el-dialog title="西安理工大学“一站式学生社区场地使用申请表" :visible.sync="handleLog" width="60%" :before-close="handleClose" center>
    <div>
      <el-descriptions title="申请信息" :column="2" :size="'medium'" class="margin-top" border>
        <el-descriptions-item label="用户名">{{ form.username }}</el-descriptions-item>
        <el-descriptions-item label="手机号">{{ form.phone }}</el-descriptions-item>
        <el-descriptions-item label="使用学院或组织">{{ form.academy }}</el-descriptions-item>
        <el-descriptions-item label="活动人数">{{ form.number }}</el-descriptions-item>
        <el-descriptions-item label="活动内容">{{ form.content }}</el-descriptions-item>
        <el-descriptions-item label="活动时间">{{ form.useTime }}</el-descriptions-item>
        <el-descriptions-item label="使用场地">{{ form.site }}</el-descriptions-item>
        <el-descriptions-item label="使用设备">{{ form.equipment }}</el-descriptions-item>
        <el-descriptions-item label="指导老师">{{ form.teacher }}</el-descriptions-item>
      </el-descriptions>
      <div style="margin-top: 20px;margin-left: 500px">
        <p>审核意见 :</p>
        <el-radio-group v-model="form.opinion" size="middle" style="margin-top: 20px">
          <el-radio v-model="form.opinion" label="通过">通过</el-radio>
          <el-radio v-model="form.opinion" label="不通过">不通过</el-radio>
          <el-button type="primary" @click="submit">提交</el-button>

        </el-radio-group>
      </div>


    </div>
  </el-dialog>
</template>
<script>
import request from "@/utils/requeset";

export default {
  data() {
    return {
      handleLog : false,
      opinions:'',
      form:{
        username:'',
        phone:'',
        content:'',
        useTime:'',
        site:'',
        equipment:'通过',
        teacher:'',
        opinion:'',
        state:'',
        id:'',
        academy:'',
        number:''
      }
    }
  },
  methods: {
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done()
        })
        .catch(_ => {})
    },
    handled(id){
      request.get("/application/"+id).then(res=>{
        this.form = res.data;
        if(res.code === "success"){
          this.handleLog = true;
        }
      })
    },
    submit(){
      this.form.opinion=this.form.opinion==='通过'?'通过':'不通过'
      this.form.state='yes'
        console.log(this.form.opinion)
      request.put("/application/handleApplication",this.form).then(res=>{
        console.log(res.code)
        if(res.code === "success"){
          this.$notify.success('更新成功')
          this.handleLog=false
          // this.$emit('sendSuccess');
        }
        else{
          this.$notify.error(res.msg);
        }
      })

    }
  }
}
</script>
<style >


</style>