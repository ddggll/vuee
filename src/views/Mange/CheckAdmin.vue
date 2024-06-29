<template>
  <div>
    <!--    搜索表单-->
    <div style="margin-bottom: 20px">
      <el-input style="width: 150px" placeholder="请输入名称" v-model="params.name"></el-input>
      <el-input style="width: 150px; margin-left: 5px" placeholder="请输入学号" v-model="params.phone"></el-input>
      <el-button style="margin-left: 5px " type="primary" @click="load">
        <i class="el-icon-search"></i>搜索
      </el-button>
      <el-button style="margin-left: 5px " type="warning" @click="reset">
        <i class="el-icon-refresh"></i>重置
      </el-button>
    </div>
    <el-table :data="tableData" stripe>
      <el-table-column prop="id" label="编号"></el-table-column>
      <el-table-column prop="name" label="名称"></el-table-column>
      <el-table-column prop="age" label="年龄"></el-table-column>
      <el-table-column prop="sex" label="性别"></el-table-column>
      <el-table-column prop="address" label="地址"></el-table-column>
      <el-table-column prop="phone" label="电话"></el-table-column>
      <el-table-column label="操作">
        <template v-slot:default="scope">
          <!--         scope.row是行数据-->
          <el-button type="primary" @click="$router.push('/editAdmin?id=' + scope.row.id)">编辑</el-button>
          <el-popconfirm
              title="这是一段内容确定删除吗？"
              @confirm="del(scope.row.id)"
          >
            <el-button type="danger" style="margin-left: 5px" ;slot="reference">删除</el-button>
          </el-popconfirm>

        </template>
      </el-table-column>

    </el-table>
    <!--    分页-->
    <div style="margin-top: 20px">
      <el-pagination
          background
          :current-page="params.page"
          :page-size="params.size"
          layout="prev, pager, next"
          @current-change="handleCurrentChange"
          :total="total">
      </el-pagination>
    </div>
  </div>
</template>
<script>


import request from "@/utils/requeset";
import router from '@/router'
export default {
  name: 'test',
  data() {
    return {
      tableData: [],
      total: 0,
      params: {
        page: 1,
        size: 10,
        name: '',
        phone: ''
      }
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
    reset() {
      this.params = {
        page: 1,
        size: 10,
        name: '',
        phone: ''
      }
      this.load()
    },
    handleCurrentChange(page) {
      //点击分页按钮触发
      this.params.page = page;
      this.load()
    },
    del(id){
      request.delete("user/deleteAdmin/" + id).then(res => {
        if (res.code === "success") {
          this.$notify.success("删除成功");
          this.load()
        }
        else {
          this.$notify.error(res.msg);
        }
      })
    }
  }
}
</script>