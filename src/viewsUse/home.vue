<template>

  <div class="body">
    <!-- 轮播 -->


    <div class="image-slider">


      <img :src="images[currentIndex]">
      <div class="r">
        <img src="@/assets/xia.png" @click="xiayige()">

      </div>
      <div class="l">
        <img src="@/assets/shang.png" @click="shangyige()">
      </div>

      <div class="yuan">
        <img src="@/assets/yuan.png" :style="{ backgroundColor: bkg }">
        <img src="@/assets/yuan.png" :style="{ backgroundColor: bkg1 }">
        <img src="@/assets/yuan.png" :style="{ backgroundColor: bkg2 }">
      </div>

    </div>

    <div class="header">
      <span id="myAppointmentSpan" class="myAppointmentSpan big" @click="myAppointmentSpan()">我的预约</span>

      <span id="bookingPlaceSpan" class="bookingPlaceSpan big" @click="bookingPlaceSpan()">预约场地</span>

      <span id="instructionSpan" class="instructionSpan big" @click="instructionSpan()">操作说明</span>

      <span id="feedbackSpan" class="feedbackSpan big" @click="feedbackSpan()">意见反馈</span>

      <span id="feedbackSpan" class="adminSpan big" @click="adminOpen()">管理员</span>


    </div>

    <div class="service">
      <div class="xinxi" id="xinxi">
        <h2>通知公告：</h2>
      </div>
      <div class="shuoming" id="shuoming">
        <h2>使用说明：</h2>
      </div>
    </div>

    <div class="modal" v-if="display === 'block'">
      <div class="caozuoshuoming yijian">
        <div class="chuangkou1" :style="{ display: display }">
          <span class="close" @click="guanbi()">&times;</span>

          <div class="sm" :style="{ display: sm }">
            <h2>操作说明</h2>
          </div>
          <div class="fk" :style="{ display: fk }">
            <h2>意见反馈</h2>
            <tr>
              <td>
                <textarea class="eventDescription ziyou" rows="5" cols="50">
    反馈内容：
</textarea>
              </td>
              <br><br>
              <button style="width: 60px;height: 30px">提交</button>
            </tr>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "home",
  data() {
    return {
      images: [
        require('@/assets/7.jpg'),
        require('@/assets/3.jpg'),
        require('@/assets/4.jpg'),




      ],
      display: "none",
      sm: "none",
      fk: "none",
      currentIndex: 0,
      bkg: '#ffffff',
      bkg1: '',
      bkg2: ''

    };
  },

  methods: {
    adminOpen(){
      this.$router.push("/layout");
    },
    myAppointmentSpan() {
      this.$router.push("/myAppointmentSpan");
    },

    bookingPlaceSpan() {
      this.$router.push("/about");
    },
    instructionSpan() {
      this.display = "block";
      document.body.style.overflow = "hidden";
      this.fk = "none";
      this.sm = "block";
    },
    feedbackSpan() {
      this.display = "block";
      document.body.style.overflow = "hidden";
      this.sm = "none";
      this.fk = "block";
    },
    guanbi() {
      this.display = "none";
      document.body.style.overflow = "auto";
    },

    // 轮播
    startSlider() {
      setInterval(() => {
        this.currentIndex = (this.currentIndex + 1) % this.images.length;
        if (this.currentIndex === 0) {
          this.bkg = '#ffffff',
              this.bkg1 = '#ffffff00',
              this.bkg2 = '#ffffff00'

        }
        else if (this.currentIndex === 1) {
          this.bkg = '#ffffff00',
              this.bkg1 = '#ffffff',
              this.bkg2 = '#ffffff00'
        }
        else if (this.currentIndex === 2) {
          this.bkg = '#ffffff00',
              this.bkg1 = '#ffffff00',
              this.bkg2 = '#ffffff'

        }

      }, 4000);

    },
    xiayige() {
      this.currentIndex = this.currentIndex + 1;
      if (this.currentIndex === 3) {
        this.currentIndex = 0;

      }
      if (this.currentIndex === 0) {
        this.bkg = '#ffffff',
            this.bkg1 = '#ffffff00',
            this.bkg2 = '#ffffff00'

      }
      else if (this.currentIndex === 1) {
        this.bkg = '#ffffff00',
            this.bkg1 = '#ffffff',
            this.bkg2 = '#ffffff00'
      }
      else if (this.currentIndex === 2) {
        this.bkg = '#ffffff00',
            this.bkg1 = '#ffffff00',
            this.bkg2 = '#ffffff'

      }
    },
    shangyige() {
      this.currentIndex = this.currentIndex - 1;
      if (this.currentIndex === -1) {
        this.currentIndex = 2;
      }
      if (this.currentIndex === 0) {
        this.bkg = '#ffffff',
            this.bkg1 = '#ffffff00',
            this.bkg2 = '#ffffff00'

      }
      else if (this.currentIndex === 1) {
        this.bkg = '#ffffff00',
            this.bkg1 = '#ffffff',
            this.bkg2 = '#ffffff00'
      }
      else if (this.currentIndex === 2) {
        this.bkg = '#ffffff00',
            this.bkg1 = '#ffffff00',
            this.bkg2 = '#ffffff'

      }
    },

  },


  // 轮播

  mounted() {
    this.startSlider();







  },
};
</script>




<style scoped>
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
  height: 220px;
  /* 高度自适应 */
  transition: all 0.6s;

}

.l img {
  position: absolute;
  width: 60px;
  height: 60px;
  left: 10px;
  top: 100px;
}

.r img {
  position: absolute;
  width: 60px;
  height: 60px;
  left: 1456px;
  top: 100px;
}

.yuan :nth-child(1) {
  position: absolute;
  width: 30px;
  height: 30px;
  left: 700px;
  top: 190px;
  border-radius: 30px;
}

.yuan :nth-child(2) {
  position: absolute;
  width: 30px;
  height: 30px;
  left: 750px;
  top: 190px;
  border-radius: 30px;
}

.yuan :nth-child(3) {
  position: absolute;
  width: 30px;
  height: 30px;
  left: 800px;
  top: 190px;
  border-radius: 30px;
}

* {
  margin: 0;
  padding: 0;
}

.body {
  width: 1505px;
  height: 865px;
  background-image: url('../assets/bcg.png');
  background-repeat: no-repeat;
  background-size: 100%;
}


.myAppointmentSpan {
  position: absolute;
  left: 30px;
}

.bookingPlaceSpan {
  position: absolute;
  left: 150px;
}

.instructionSpan {
  position: absolute;
  left: 270px;
}

.feedbackSpan {
  text-align: center;
  position: absolute;
  left: 390px;
}
.adminSpan {
  text-align: center;
  position: absolute;
  left: 510px;
}

.big:hover {
  cursor: pointer;
  font-size: 25px;
  transition: all 0.3s;
  transform: scale(1.1);
}

.header {
  position: absolute;
  top: 227px;
  left: 8px;
  width: 1505px;
  height: 65px;
  background-color: #a34885;
  line-height: 65px;
  font-size: 19px;
  display: flex;
}

.service {
  position: relative;
  width: 1505px;
  height: 560px;
  top: 64px;
  display: flex;
}



.xinxi {
  position: relative;
  top: 30px;
  left: 30px;
  background-color: rgba(184, 182, 182, 0.8);
  width: 400px;
  height: 500px;
}

.shuoming {
  position: relative;
  top: 30px;
  left: 68px;
  width: 965px;
  height: 500px;
  background-color: rgba(173, 171, 171, 0.8);
}

/* 窗口 */

.modal {
  background-color: rgba(21, 21, 21, 0.5);
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}

.chuangkou1 {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 900px;
  height: 600px;
  background-color: #efefef;
  box-shadow: 5px 5px 5px 2px rgba(0, 0, 0, 0.5);
  pointer-events: auto;
}

.ziyou {
  height: 267px;
  width: 846px;
  margin-left: 20px;
  resize: none;


}

.close {
  position: absolute;
  top: -4px;
  right: 19px;
  cursor: pointer;
  width: 13px;
  font-size: 2pc;
}

button {

  position: absolute;
  top: 55%;
  left: 50%;
  transform: translate(-50%, -50%);
}
</style>