<template>
  <div>
    <div class="login-title">
      <img src="../../assets/logo.png" alt="" style="width: 40px; position: relative; top: 10px;left: 10px">
      <span style="margin-left: 20px; font-size: 24px;">一站式社区服务</span>
    </div>
    <div class="login-box">
      <router-view />
    </div>
  </div>
</template>

<style scoped lang="scss">
.login-title{
  height: 100px;
  line-height:100px;

  background-color: powderblue;
}
.login-box{

  height: calc(100vh - 100px);
  padding-top: 1px;
  background-color:white;
}
</style>
<script setup>

</script>
