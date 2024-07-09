<template>
  <div id="app" class="login-body">

  <!--头部-->
    <div style="height: 60px;line-height: 60px;background-color: white; margin-bottom: 2px;">
      <img src="@/assets/logo.png" alt="" style="width: 40px; position: relative; top: 10px;left: 10px">
      <span style="margin-left: 20px; font-size: 24px;">一站式社区服务</span>
    </div>

<router-link to="/">

</router-link>

    <!--侧边栏和主体-->
    <div style="display: flex">
      <!--侧边栏导航-->
      <div style="width: 200px;min-height: calc(100vh - 62px); overflow: hidden;margin-right: 2px;background-color: #42b983">
        <el-menu :default-active="$route.path === '/'?$route.path :$route.path.substring()" :active-openeds="['about']" router class="el-menu-demo">
          <el-menu-item index="/test">
            <i class="el-icon-s-cooperation"></i>
            <span>处理中心</span>
          </el-menu-item>
          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-setting"></i>
              <span>我的工作台</span>

            </template>
            <el-menu-item index="/user">用户登录</el-menu-item>
            <el-menu-item index="/admin">管理员登录</el-menu-item>

          </el-submenu>
          <el-submenu index="3">
            <template slot="title">
              <i class="el-icon-setting"></i>
              <span>成员管理</span>
            </template>
            <el-menu-item index="/checkAdmin">成员查看</el-menu-item>
<!--            <el-menu-item index="/addAdmin">成员添加</el-menu-item>-->
<!--            <el-menu-item index="/test">成员删除</el-menu-item>-->
          </el-submenu>
        </el-menu>
      </div>

      <!--主体数据-->
      <div style="flex: 1; background-color: white; padding: 10px">
        <router-view/>
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">
</script>