<template>
  <div class="body">
    <div class="header">
      <div class="box" @click="confirmed()"
           :style="{ backgroundColor: confirmedd }">
        <span class="big confirmed" >已通过预约</span>
      </div>

      <div class="box " @click="pending()" :style="{ backgroundColor: pendingg }">
        <span class="big pending">待审批预约</span>
      </div>

      <div class="box" @click="rejected()" :style="{ backgroundColor: rejectedd }">
        <span class="big rejected">未通过预约</span>
      </div>

      <div class="box" @click="appointments()" :style="{ backgroundColor: appointmentss }">
        <span class="big appointments">所有预约</span>
      </div>
    </div>

    <div class="service">


      <table>
        <thead>
        <tr>
          <th>场馆类型</th>
          <th>场馆名称</th>
          <th>场馆地点</th>
          <th>申请人</th>
          <th>联系方式</th>
          <th>使用日期</th>
          <th>场馆用途</th>
          <th>容纳人数</th>
          <th>申请时间</th>
          <th>操作</th>


        </tr>
        </thead>
        <tbody>
        <tr>
          <td>学生活动中心</td>
          <td>学术报告厅</td>
          <td>8号楼</td>
          <td>...</td> <!-- 继续填充其他列 -->
          <td>...</td>
          <td>...</td>
          <td>...</td>
          <td>...</td>
          <td>...</td>
          <td>...</td>
        </tr>




        </tbody>
      </table>

    </div>

  </div>
</template>

<script>
export default {
  name: "myAppointmentSpan",

  data() {
    return {
      confirmedd: '#a34885', // 默认背景颜色
      pendingg:'#a34885',
      rejectedd:'#a34885',
      appointmentss:'#a34885',

      red: '#5f1f49', // 点击色
    };
  },

  methods: {
    confirmed() {
      console.log("已通过预约");

      this.pendingg='#a34885'
          this.rejectedd='#a34885'
          this.appointmentss='#a34885'

          this.confirmedd = this.red; // 设置背景颜色为红色
    },

    pending() {
      console.log("待审批预约");
      this.confirmedd='#a34885'
          this.rejectedd='#a34885'
          this.appointmentss='#a34885'



          this.pendingg = this.red; // 设置背景颜色为红色

    },
    rejected() {
      console.log("未通过预约");
      this.confirmedd='#a34885',
          this.pendingg='#a34885',
          this.appointmentss='#a34885'



          this.rejectedd = this.red; // 设置背景颜色为红色

    },
    appointments() {

      console.log("所有预约");
      this.confirmedd='#a34885',
          this.pendingg='#a34885'
          this.rejectedd='#a34885'

          this.appointmentss = this.red; // 设置背景颜色为红色

    }
  }

};
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
}



.body {
  width: 1000px;
  height: 711px;

  background-repeat: no-repeat;
  background-size: 100%;
  overflow: hidden;

}

.header {
  position: relative;
  top: 161px;
  width: 1511px;
  height: 65px;
  background-color: #a34885;
  display: flex; /* 使用 Flexbox 布局 */
  font-size: 19px;
  color: white;
}

.box {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 180px;
  height: 100%;
  cursor: pointer;
}

.big {
  font-size: 17px;
}

.big:hover {
  font-size: 20px;
  transition: all 0.3s ease;
}

.service {
  position: relative;
  width: 1505px;
  top: 110px;
  height: auto;
  background-color: rgb(213, 213, 213);
  margin-left: 0;
  margin-top: 51px;
  display: flex;
}


th{
  text-align: center;
  padding-left: 80px; /* 设置表头单元格的内边距 */

}

td{

  text-align: center;
  padding-left: 80px; /* 设置表头单元格的内边距 */

}
table{
  width: 1520px;
}




</style>