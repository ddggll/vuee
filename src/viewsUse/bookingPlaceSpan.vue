<template>

  <body>


  <div class="service">
    <div class="title">
      <h2>资源列表:</h2>
    </div>
    <!-- 使用v-for来循环渲染图片列表 -->
    <div class="images" v-for="(img, index) in imgList" :key="index">
        <span class="imgs">
          <img :src="img.src" @click="shenqingbiao(img.name, img.adres)" />


        </span>
      <div class="name">{{ img.name }}</div>
    </div>
  </div>

  <!-- 申请表 -->
  <div class="modal" v-if="chuangkou === 'block'">
    <form id="tijiao" :style="{ display: chuangkou }" @submit.prevent="tijiao()">
      <h1>学生活动中心场地借用申请表</h1>
      <table>
        <tbody>
        <!-- 第一行 -->
        <tr>
          <td>申请人</td>
          <td>
            <input type="text" class="organizationName shuru" v-model="formData.organizationName"
                   placeholder="请输入申请人名称" required />
          </td>
          <td>联系电话</td>
          <td>
            <input type="text" class="phonenumber shuru" v-model="formData.phonenumber" placeholder="请输入手机号码"
                   required />
          </td>
        </tr>

        <!-- 第二方 -->
        <tr>
          <td>使用学院或组织</td>
          <td>
            <input type="text" class="borrowerName shuru" v-model="formData.borrowerName" placeholder="请输入学院名称"
                   required />
          </td>
          <td>活动人数</td>
          <td>
            <input type="text" class="renshu shuru" v-model="formData.renshu" placeholder="请输入活动人数" required />
          </td>
        </tr>

        <!-- 第三行 -->
        <tr>
          <td>活动内容</td>
          <td colspan="3" style="height: 80px;">
                <textarea class="eventDescription ziyou" v-model="formData.eventDescription" rows="5" cols="50">
    简述活动内容和议程，大型活动应附活动策划
</textarea>
          </td>
        </tr>
        <!-- 第四行 -->
        <tr>
          <td>活动时间</td>

          <td colspan="3">
            <input type="text" class="supervisorName shuru" v-model="formData.supervisorName"
                   placeholder="__年__月__日__点__分至__点__分" required />
          </td>
        </tr>

        <!-- 第六行 -->
        <tr>
          <td>使用场地</td>

          <td>{{ changdi }}</td>

          <td>地址</td>
          <td>{{ adres }}</td>
        </tr>

        <!-- 第八行 -->
        <tr>
          <td>使用设备</td>
          <td colspan="3">
            <input type="text" class="shebei shuru" v-model="formData.shebei" placeholder="电脑，投影仪，空调，其他..."
                   required />
          </td>
        </tr>

        <!-- 第九行 -->

        <tr>
          <td>
            指导老师
          </td>
          <td colspan="3">
            <input type="text" class="laoshi shuru" v-model="formData.laoshi" placeholder="请输入指导老师姓名" required>
          </td>
        </tr>

        <tr>
          <td colspan="4" style="text-align: center; height: 50px ;">
            <input type="submit" value="提交申请" />
            <input type="submit" value="取消申请" style="margin-left: 50px" @click="quxiao()" />
          </td>
        </tr>



        </tbody>
      </table>
      <div>
        <h3 style="width: 600px;">
          ★填表说明:
          <br />1.申请人请如实填写活动负责人的各项信息。
          <br />2.若活动因故取消，请提前至少一个工作日通知办公室值班人员。
        </h3>
      </div>
    </form>





    <!-- 封装弹框 -->

    <div class="modal2" v-if="chuangkouu === 'block'">
      <div id="popup" class="popup" :style="{ display: chuangkouu }">
        <span class="close" @click="quxiaotijiao()">&times;</span>
        <h2>提交成功</h2>
      </div>
    </div>
  </div>
  </body>
</template>



<style scoped>
* {
  margin: 0;
}


/* 播放 */
.image-slider {
  display: flex;
  width: 1505px;
  /* 盒子宽度 */
  height: 220px;
  /* 盒子高度 */
  overflow: hidden;
  /* 超出部分隐藏 */
}

.image-slider img {
  width: 100%;
  /* 图片宽度填充盒子 */
  height: 272px;
  /* 高度自适应 */
}






body {

  /* display: flex; */
  width: 1505px;
  height: 930px;
  background-image: url('../assets/bcg.png');
  background-repeat: no-repeat;
  background-size: 100%;
  overflow: hidden;

}

.title {
  position: relative;
  width: 1950px;
  height: 50px;
  top: 0px;
  line-height: 50px;
}

.service {
  display: flex;
  position: relative;
  top: 80px;
  left: 80px;
  flex-wrap: wrap;
  /*可以换行*/
  justify-content: flex-start;
  /*起始位置开始*/
  width: 1350px;
  height: auto;
  background-color: rgba(250, 235, 215, 0.6);
}

/* 鼠标悬浮效果 */
img:hover {
  transform: scale(1.1);
  transition: all 0.3s;
}

.imgs img {
  max-width: 100%;
  /* 图片的最大宽度不超过其容器的宽度 */
  height: 200px;
  margin-left: 60px;
  margin-right: 0px;
}

.name {
  margin-left: 60px;
  text-align: center;
}

/* 表格 */

.modal {
  background-color: rgba(21, 21, 21, 0.5);
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}

.modal2 {
  background-color: rgba(21, 21, 21, 0.5);
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  margin: 0%;
}

#tijiao {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 800px;
  height: 600px;
  background-color: #efefef;
  box-shadow: 5px 5px 5px 2px rgba(0, 0, 0, 0.5);
  pointer-events: auto;
}

h1 {
  text-align: center;
  line-height: 100px;
  font-size: 46px;
}

table {
  width: 100%;
  /* 表格宽度占据整个容器宽度 */
  border-collapse: collapse;
  /*边框合并*/
}

th,
td {
  border: 1px solid black;
  /* 单元格边框 */
  padding: 3px;
  /* 内边距 */
  text-align: center;
  /*文本居中*/
}

th {
  background-color: #ffffff;
  /* 表头背景色 */
}

.shuru {
  width: -webkit-fill-available;
  height: 25px;
  text-align: left;
  padding: 0px;
}

.ziyou {
  width: -webkit-fill-available;
}

/* CSS 样式，用于控制弹窗的外观 */
.popup {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 300px;
  height: 200px;
  background-color: #fff;
  border: 1px solid #ccc;
  box-shadow: 5px 5px 5px 2px rgba(0, 0, 0, 0.5);
  z-index: 1000;
  padding: 20px;
}

.popup h2 {
  margin-top: 0;
  font-size: 18px;
  line-height: 200px;
  text-align: center;
}

.popup .close {
  position: absolute;
  top: -4px;
  right: 19px;
  cursor: pointer;
  width: 13px;
  font-size: 2pc;
}

.l,
h2:hover {
  cursor: pointer;
}
</style>

<script>
export default {
  name: "bookingPlaceSpan",

  data() {
    return {
      // 将模拟数据移动到data选项中
      imgList: [
        // ...你的图片数组数据
        { name: "教室1", src: require("../assets/logo.png"), adres: "地址1" },
        { name: "教室2", src: require("../assets/logo.png"), adres: "地址2" },
        { name: "教室3", src: require("../assets/logo.png"), adres: "地址3" },
        { name: "教室4", src: require("../assets/logo.png"), adres: "地址4" },
        { name: "教室5", src: require("../assets/logo.png"), adres: "地址5" },
        { name: "教室6", src: require("../assets/logo.png"), adres: "地址6" },
        { name: "教室7", src: require("../assets/logo.png"), adres: "地址7" },
        { name: "教室8", src: require("../assets/logo.png"), adres: "地址8" },
        { name: "教室9", src: require("../assets/logo.png"), adres: "地址9" },
        { name: "教室10", src: require("../assets/logo.png"), adres: "地址10" },
        { name: "教室11", src: require("../assets/logo.png"), adres: "地址11" }
      ],



      // 窗口操作
      changdi: "",
      adres: "",
      chuangkou: "none",
      chuangkouu: "none",
      jingji: "auto",

      // 表单信息
      formData: {
        organizationName: '',
        phonenumber: '',
        borrowerName: '',
        renshu: '',
        eventDescription: '',
        supervisorName: '',
        shebei: '',
        laoshi: ''

      }




    };
  },
  methods: {
    // 可以添加方法来处理鼠标悬浮效果
    shenqingbiao(name, adres) {
      this.chuangkou = "block";
      this.changdi = name;
      this.adres = adres;
      document.body.style.overflow = "hidden";

    },
    tijiao() {
      // 可以在这里处理表单提交逻辑，例如：
      console.log('提交的数据：', this.formData);
      // this.changdi
      // this.adres

      // 在实际应用中，你可以使用 axios 或者 fetch 发送数据到后端处理
      // 例如：
      axios.post('127.0.0.1/submit-form', this.formData)
          .then(response => {
            console.log('提交成功！', response.data);
          })
          .catch(error => {
            console.error('提交失败！', error);
          });



      this.chuangkouu = "block";
    },
    quxiaotijiao() {
      this.chuangkouu = "none";
    },
    quxiao() {
      document.body.style.overflow = "auto";  // 恢复页面主体滚动
      this.chuangkou = "none";
    },


  },


};
</script>
