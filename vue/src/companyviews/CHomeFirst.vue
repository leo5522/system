<!--这里是企业点击首页后跳转的页面-->
<template>
  <div class="chomefirst">
    <!--滚动-->
    <template>
      <el-carousel :interval="5000" arrow="always">
        <el-carousel-item v-for="(image, index) in images" :key="index">
          <img :src="require(`@/images/${image}`)" alt="">
        </el-carousel-item>
      </el-carousel>
    </template>

    <div style="padding-top: 40px;">
      <template>
        <el-row :gutter="20">


          <el-col :span="6">
            <!-- 第一个卡片 -->
            <el-card :body-style="{ padding: '20px' }">
              <div slot="header">
                站内公告
              </div>
              <div>
                <div v-for="(item, index) in infoTitles" :key="index" class="info-item" @click="goToDetail(index)">
                  <el-link href="https://element.eleme.io" target="_blank">{{ item }}</el-link>
                </div>
              </div>
            </el-card>
          </el-col>


          <el-col :span="6">
            <!-- 第二个卡片 -->
            <el-card :body-style="{ padding: '20px' }">
              <div slot="header">
                招聘资讯
              </div>
              <div>
                <div v-for="(item, index) in infoTitles" :key="index" class="info-item" @click="goToDetail(index)">
                  <el-link href="https://element.eleme.io" target="_blank">{{ item }}</el-link>
                </div>
              </div>
            </el-card>
          </el-col>

          <el-col :span="6">
            <!-- 第二个卡片 -->
            <el-card :body-style="{ padding: '20px' }">
              <div slot="header">
                新闻资讯
              </div>
              <div>
                <div v-for="(item, index) in infoTitles" :key="index" class="info-item" @click="goToDetail(index)">
                  <el-link href="https://element.eleme.io" target="_blank">{{ item }}</el-link>
                </div>
              </div>
            </el-card>
          </el-col>

          <el-col :span="6">
            <!-- 第二个卡片 -->
            <el-card :body-style="{ padding: '20px' }">
              <div slot="header">
                企业名录
              </div>
              <div>
                <div v-for="(item, index) in infoTitles" :key="index" class="info-item" @click="goToDetail(index)">
                  <el-link href="https://element.eleme.io" target="_blank">{{ item }}</el-link>
                </div>
              </div>
            </el-card>
          </el-col>

        </el-row>
      </template>

    </div>

  </div>
</template>

<script>
export default {
  name: 'CHomeFirst',
  data() {
    return {
      currentDate: new Date(),
      infoTitles: [
        '信息1',
        '信息2',
        '信息3',
        '信息4',
        '信息5',
        '信息6',
        '信息7',
        '信息8'
      ],
      value: new Date(),
      images:[
        'demo01.jpg',
        'demo02.jpg',
        'demo03.jpg',
        'demo04.jpg',
      ]
    };
  }
}
</script>

<style>
.el-carousel__item h3 {

  /*走马灯的CSS*/
  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}
/**/
.time {
  font-size: 13px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
}

.button {
  padding: 0;
  float: right;
}

.image {
  width: 100%;
  display: block;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}
img {
  display: block;
  margin: 0 auto;

  width: 100%;
  height: 100%;
  object-fit: cover;
}
</style>



<!--<template>-->
<!--  <div class="chomefirst">-->
<!--    <div class="banner">-->
<!--      &lt;!&ndash; Banner区域，可以放置网站Logo和宣传语 &ndash;&gt;-->
<!--&lt;!&ndash;      <img src="/static/logo.png" alt="logo">&ndash;&gt;-->
<!--      <h1>欢迎来到企业招聘网站</h1>-->
<!--      <p>为您提供优质的招聘服务</p>-->
<!--    </div>-->

<!--    <div class="features">-->
<!--      &lt;!&ndash; 核心功能区域，列出网站的主要功能特点 &ndash;&gt;-->
<!--      <div class="feature">-->
<!--        <img src="/static/job.png" alt="job">-->
<!--        <h2>招聘信息</h2>-->
<!--        <p>提供最新的招聘信息和职位详情，让求职者能够更加方便地浏览和搜索适合自己的工作机会。</p>-->
<!--      </div>-->
<!--      <div class="feature">-->
<!--        <img src="/static/resume.png" alt="resume">-->
<!--        <h2>简历搜索</h2>-->
<!--        <p>为企业提供在线搜索和管理简历的服务，快速找到符合条件的人才。</p>-->
<!--      </div>-->
<!--      <div class="feature">-->
<!--        <img src="/static/forum.png" alt="forum">-->
<!--        <h2>就业论坛</h2>-->
<!--        <p>为用户提供在线交流和分享经验的平台，方便他们了解就业市场的动态，提高求职技能和职场竞争力。</p>-->
<!--      </div>-->
<!--    </div>-->

<!--    <div class="call-to-action">-->
<!--      &lt;!&ndash; 行动号召区域，鼓励用户注册或登录 &ndash;&gt;-->
<!--      <h2>加入我们，找到你的理想职位！</h2>-->
<!--      <router-link to="/register" class="btn">立即注册</router-link>-->
<!--      <router-link to="/login" class="btn">登录</router-link>-->
<!--    </div>-->
<!--  </div>-->
<!--</template>-->

<!--<style>-->
<!--/* 样式表 */-->
<!--.home {-->
<!--  max-width: 1200px;-->
<!--  margin: 0 auto;-->
<!--}-->

<!--.banner {-->
<!--  text-align: center;-->
<!--  padding-top: 80px;-->
<!--  padding-bottom: 80px;-->
<!--}-->

<!--.features {-->
<!--  display: flex;-->
<!--  justify-content: space-around;-->
<!--  margin-top: 80px;-->
<!--}-->

<!--.feature {-->
<!--  text-align: center;-->
<!--}-->

<!--.call-to-action {-->
<!--  text-align: center;-->
<!--  margin-top: 80px;-->
<!--}-->

<!--.btn {-->
<!--  display: inline-block;-->
<!--  padding: 10px 20px;-->
<!--  background-color: #008CBA;-->
<!--  color: #fff;-->
<!--  border-radius: 5px;-->
<!--  margin: 20px;-->
<!--  text-decoration: none;-->
<!--}-->
<!--</style>-->
