<!--<template>-->
<!--  <div>-->
<!--    <h1>搜索潜在申请人，而不仅仅局限于他们的职位列表或已知的简历。一个基于搜索的页面，或者到一个推荐职位或人才的地方。</h1>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--  name: "PersonnelMarket"-->
<!--}-->
<!--</script>-->

<!--<style scoped>-->

<!--</style>-->


<!--<template>-->
<!--  <div class="personnelmarket">-->
<!--    <div style="padding-top: 40px;">-->
<!--      <template>-->
<!--        <el-row :gutter="40">-->

<!--          <el-col :span="8">-->
<!--            <el-card style="margin-right: 10px;width:400px" class="box-card">-->
<!--              <div slot="header" class="clearfix">-->
<!--                <span>卡片名称</span>-->
<!--                <el-button style="float: right; padding: 3px 0" type="text">详情</el-button>-->
<!--              </div>-->
<!--              <div v-for="o in 4" :key="o" class="text item">-->
<!--                {{'列表内容 ' + o }}-->
<!--              </div>-->
<!--            </el-card>-->
<!--          </el-col>-->


<!--          <el-col :span="8">-->
<!--            <el-card style="margin-right: 10px;width:400px" class="box-card">-->
<!--              <div slot="header" class="clearfix">-->
<!--                <span>卡片名称</span>-->
<!--                <el-button style="float: right; padding: 3px 0" type="text">详情</el-button>-->
<!--              </div>-->
<!--              <div v-for="o in 4" :key="o" class="text item">-->
<!--                {{'列表内容 ' + o }}-->
<!--              </div>-->
<!--            </el-card>-->
<!--          </el-col>-->

<!--          <el-col :span="8">-->
<!--            <el-card style="margin-light: 5px;width:400px" class="box-card">-->
<!--              <div slot="header" class="clearfix">-->
<!--                <span>卡片名称</span>-->
<!--                <el-button style="float: right; padding: 3px 0" type="text">详情</el-button>-->
<!--              </div>-->
<!--              <div v-for="o in 4" :key="o" class="text item">-->
<!--                {{'列表内容 ' + o }}-->
<!--              </div>-->
<!--            </el-card>-->
<!--          </el-col>-->

<!--          <el-col :span="8">-->
<!--            <el-card style="margin-right: 10px;width:400px" class="box-card">-->
<!--              <div slot="header" class="clearfix">-->
<!--                <span>卡片名称</span>-->
<!--                <el-button style="float: right; padding: 3px 0" type="text">详情</el-button>-->
<!--              </div>-->
<!--              <div v-for="o in 4" :key="o" class="text item">-->
<!--                {{'列表内容 ' + o }}-->
<!--              </div>-->
<!--            </el-card>-->
<!--          </el-col>-->

<!--          <el-col :span="8">-->
<!--            <el-card style="margin-right: 10px;width:400px" class="box-card">-->
<!--              <div slot="header" class="clearfix">-->
<!--                <span>卡片名称</span>-->
<!--                <el-button style="float: right; padding: 3px 0" type="text">详情</el-button>-->
<!--              </div>-->
<!--              <div v-for="o in 4" :key="o" class="text item">-->
<!--                {{'列表内容 ' + o }}-->
<!--              </div>-->
<!--            </el-card>-->
<!--          </el-col>-->




<!--        </el-row>-->
<!--      </template>-->
<!--    </div>-->
<!--  </div>-->

<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--  name: "PersonnelMarket"-->
<!--}-->
<!--</script>-->

<!--<style>-->
<!--.text {-->
<!--  font-size: 14px;-->
<!--}-->

<!--.item {-->
<!--  margin-bottom: 18px;-->
<!--}-->

<!--.clearfix:before,-->
<!--.clearfix:after {-->
<!--  display: table;-->
<!--  content: "";-->
<!--}-->
<!--.clearfix:after {-->
<!--  clear: both-->
<!--}-->

<!--.box-card {-->
<!--  width: 480px;-->
<!--}-->
<!--</style>-->





<template>
  <div class="center">
    <div class="card-container">
      <div class="card" v-for="(card, index) in cards" :key="index" @mouseover="card.hover = true" @mouseleave="card.hover = false">
        <img :src="card.photo" alt="学生头像" class="photo">
        <div class="card-content">
          <div class="card-title">{{ card.position }}</div>
          <ul class="card-info-list">
            <li class="card-info">{{ card.workExperience }}</li>
            <li class="card-info">{{ card.honorsAwards }}</li>
            <li class="card-info">{{ card.selfEvaluation }}</li>
          </ul>
        </div>
        <div class="card-hover" v-show="card.hover">
          <el-button type="text" @click="showDialog(card)">详情</el-button>
        </div>
      </div>
    </div>



    <el-dialog :visible.sync="dialogVisible" title="求职信息" width="20%">
      <div class="jobhunt-details" v-for="(jobhunt, index) in jobhunts" :key="index">
        <div class="row">
          <div class="label">姓名：</div>
          <div class="jobhunt-name">{{ jobhunt.name }}</div>
        </div>
        <div class="row">
          <div class="label">性别：</div>
          <div class="jobhunt-gender">{{ jobhunt.gender }}</div>
        </div>
        <div class="row">
          <div class="label">年龄：</div>
          <div class="jobhunt-age">{{ jobhunt.age }}</div>
        </div>
        <div class="row">
          <div class="label">专业：</div>
          <div class="jobhunt-major">{{ jobhunt.major }}</div>
        </div>
        <div class="row">
          <div class="label">专业：</div>
          <div class="jobhunt-university">{{ jobhunt.university }}</div>
        </div>
        <div class="row">
          <div class="label">爱好：</div>
          <div class="jobhunt-hobby">{{ jobhunt.hobby }}</div>
        </div>
        <div class="row">
          <div class="label">地址：</div>
          <div class="jobhunt-address">{{ jobhunt.address }}</div>
        </div>
      </div>
      <div slot="footer">
        <el-button @click="dialogVisible = false">关闭</el-button>
        <el-button type="primary" @click="showMessage">查看简历</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "PersonnelMarket",
  data() {
    return {
      searchValue: '',
      cards: [
        {
          photo: 'https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png',
          position: '学生用户',
          workExperience: 'xx公司任职',
          honorsAwards: '获得过奖励',
          selfEvaluation: '学习能力强',
          hover: false
        },
        {
          photo: 'https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png',
          position: '学生用户',
          workExperience: 'xx公司任职',
          honorsAwards: '获得过奖励',
          selfEvaluation: '学习能力强',
          hover: false
        },
        {
          photo: 'https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png',
          position: '学生用户',
          workExperience: 'xx公司任职',
          honorsAwards: '获得过奖励',
          selfEvaluation: '学习能力强',
          hover: false
        },
      ],
      dialogVisible: false,
      jobhunts: [
        {
          name: '李',
          gender: '女',
          age: '21',
          major: '信息安全',
          university: '北京大学',
          hobby: '打网球',
          address: '河南省郑州市'
        },

      ],

    }
  },
  methods: {
    showDialog(card) {
      this.dialogVisible = true
    },
    showMessage() {
      this.$message('登陆后查看简历信息')
    }
  }
}
</script>

<style scoped>
.center {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.search {
  display: flex;
  align-items: center;
  margin-top: 20px;
}

.card-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  margin-top: 20px;
}
.card {
  width: 300px;
  height: 250px;
  margin: 10px;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
  position: relative;
  overflow: hidden;
}

.card:before {
  content: "";
  display: block;
  position: absolute;
  top: -10px;
  left: -10px;
  right: -10px;
  bottom: -10px;
  clip-path: polygon(
      0% 0%,
      100% 0%,
      100% calc(100% - 30px),
      calc(100% - 30px) 100%,
      0% 100%
  );
  background-color: #fff;
  z-index: -1;
}

.photo {
  width: 80px;
  height: 80px;
  position: absolute;
  top: 20px;
  left: 20px;
  border-radius: 50%;
  border: 3px solid #fff;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}

.card-content {
  position: absolute;
  top: 30px;
  left: 120px;
  right: 20px;
  bottom: 20px;
}

.card-title {
  font-size: 20px;
  font-weight: bold;
  margin-bottom: 5px;
}

.card-info-list {
  list-style: none;
  padding: 0;
  margin: 0;
  color: #666;
}

.card-info {
  margin-bottom: 5px;
}

.card:hover:before {
  transform: scale(1.05);
  transition: all 0.3s ease-out;
}

.card:hover .card-title {
  color: #0078ff;
}

.card-hover {
  position: absolute;
  bottom: 20px;
  left: 20px;
  opacity: 0;
  transition: opacity 0.3s;
}

.card:hover .card-hover {
  opacity: 1;
}

.card-hover el-button {
  color: #0078ff;
}

/*.card {*/
/*  width: 300px;*/
/*  height: 250px;*/
/*  margin: 10px;*/
/*  border-radius: 10px;*/
/*  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);*/
/*  position: relative;*/
/*  overflow: hidden;*/
/*}*/
/*.photo {*/
/*  width: 80px;*/
/*  height: 80px;*/
/*  position: absolute;*/
/*  top: 10px;*/
/*  left: 10px;*/
/*}*/

/*.card-content {*/
/*  position: relative;*/
/*  top: 85px;*/
/*  left: 100px;*/
/*}*/

/*.card-title {*/
/*  font-size: 20px;*/
/*  font-weight: bold;*/
/*  margin-bottom: 10px;*/
/*}*/

/*.card-info-list {*/
/*  list-style: none;*/
/*  padding: 0;*/
/*  margin: 0;*/
/*}*/

/*.card-info {*/
/*  margin-bottom: 5px;*/
/*}*/

/*.card-hover {*/
/*  position: absolute;*/
/*  bottom: 10px;*/
/*  right: 10px;*/
/*  opacity: 0;*/
/*  transition: opacity 0.3s;*/
/*}*/
.row {
  display: flex;
  margin-bottom: 10px;
}
.label {
  width: 50px;
  font-weight: bold;
}
/*.card:hover .card-hover {*/
/*  opacity: 1;*/
/*}*/

</style>