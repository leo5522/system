<template>
  <div class="companyinfo-container">
    <div class="card">
      <h2 class="title">企业简介</h2>
      <p class="description">我公司集团自2015年创建成立，是一个立足于科技领域的企业，郑州定慧智达智能科技有限公司作为郑州分公司，一直很重视每一位伙伴的成长和改变，系统化，专业化，规范化，有目的有要求的培训体系，已经培养，造就了大批人才，他们在企业的各个岗位发挥着越来越重要的作用，一直以来，企业始终坚持以人为本的企业文化，而且公司是依照公司法在中国境内设立的有限责任公司和股份有限公司，它是适应市场经济社会化大生产的需要而形成的一种企业组织形式，每个员工都很友爱互帮互助，然而公司的发展速度极快，在各大城市都有分公司这一点有做出成绩，公司文化：如果您是客户，我们为您提供最满意的至诚服务。如果你是员工，我们为您提供最理想的发展平台。只要您是社会一份子，请相信我们会为社会提供最有价值的时代精神。公司愿景：中国最佳创业联盟，员工幸福指数最高。企业价值观: 让我们一起创造美好的生活追求卓越，突破自我，不断创新，不断成长。企业使命：成就顾客，成就伙伴，成就自己，成就家人，成就社会。企业优势：培养创业伙伴，成就企业伙伴。 公司的主要产品：智能家居，电子产品，健康产品</p>
      <h2 class="title">公司相册</h2>
      <div class="demo-image__placeholder">
        <div class="block">
          <span class="demonstration">内部环境</span>
          <el-image :src="src"></el-image>
        </div>
        <div class="block">
          <span class="demonstration">办公地点</span>
          <el-image :src="src">
            <div slot="placeholder" class="image-slot">
              加载中<span class="dot">...</span>
            </div>
          </el-image>
        </div>
      </div>
      <h2 class="title">企业文化</h2>
      <p class="description">作为同创主悦的联合创始人，不论遇到任何困难和挫折，我们都将倾尽全力，把同创主悦做大做强，有福同享，有难共担，绝不退缩，共同完成同创大业</p>
  <!--    <div class="photo-group">-->
  <!--      <img src="demo01.jpg" alt="photo1" class="photo">-->
  <!--      <img src="demo02.jpg" alt="photo2" class="photo">-->
  <!--      <img src="demo03.jpg" alt="photo3" class="photo">-->
  <!--      <img src="demo04.jpg" alt="photo4" class="photo">-->
  <!--    </div>-->
      <h2 class="title">人才发展</h2>
      <div class="talent-group">
        <el-tag type="info">考核晋升</el-tag>
  <!--      <p class="talent-description">这里是对Java技能的描述。</p>-->
        <el-tag type="info">完善的晋升机制</el-tag>
  <!--      <p class="talent-description">这里是对Python技能的描述。</p>-->
        <el-tag type="info">晋级涨薪</el-tag>
  <!--      <p class="talent-description">这里是对JavaScript技能的描述。</p>-->
        <el-tag type="info">项目奖金</el-tag>
        <el-tag type="info">团队奖金</el-tag>
        <el-tag type="info">个人奖金</el-tag>
        <el-tag type="info">岗前带薪培训</el-tag>
        <el-tag type="info">国内外进修</el-tag>
        <p class="talent-description">高端引领 充分发挥高层次人才，高级人才，高技能人才在企业发展和人才队伍建设中的引领作用，重点引进，培养一批技艺精湛的高技能人才，一批技术水平高，创新能力强的专业技术带头人才，一批综合素养高，开拓能力强的高级人才，统筹推进各类人才队伍建设。</p>
      </div>
      <h2 class="title">工商信息</h2>
      <el-descriptions title="" direction="vertical" :column="4" border>
        <el-descriptions-item label="企业名称">郑州科技有限公司</el-descriptions-item>
        <el-descriptions-item label="法定代表人">张三</el-descriptions-item>
        <el-descriptions-item label="成立时间" >2012-06-09</el-descriptions-item>
        <el-descriptions-item label="企业类型">有限责任公司</el-descriptions-item>
        <el-descriptions-item label="经营状态">存续</el-descriptions-item>
        <el-descriptions-item label="居住地注册资本">100万人民币</el-descriptions-item>
        <el-descriptions-item label="营业期限" >2012-06-09至</el-descriptions-item>
        <el-descriptions-item label="所属省区" >河南省</el-descriptions-item>
  <!--      <el-descriptions-item label="备注">-->
  <!--        <el-tag size="small">学校</el-tag>-->
  <!--      </el-descriptions-item>-->
        <el-descriptions-item label="注册地址">郑州金水区浦发国际金融中心17楼1706</el-descriptions-item>
      </el-descriptions>
      <h2 class="title">企业地址</h2>
      <el-card style="width: 800px" class="address-card">
        <div class="card-content">
          <div class="address-line">
            <i class="el-icon-location"></i>
            郑州金水区浦发国际金融中心17楼1706
          </div>
  <!--        <div id="baidu-map-container" style="width: 100%; height: 500px;"></div>-->
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      src: 'https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg'
    }
  }
}
</script>

<style>
.companyinfo-container {
  max-width: 900px;
  margin: 0 auto;
  padding: 30px;
  border: 1px solid #ccc;
  background-color: #ffffff;
}
.card {
  width: 800px;
  max-width: 100%;
  margin: auto;
}

.title {
  font-size: 24px;
  margin-top: 40px;
  margin-bottom: 20px;
}

.description {
  font-size: 16px;
  line-height: 1.5;
  margin-bottom: 40px;
}

/*.photo-group {*/
/*  display: flex;*/
/*  justify-content: space-between;*/
/*  margin-bottom: 40px;*/
/*}*/

/*.photo {*/
/*  width: calc(25% - 10px);*/
/*}*/

.talent-group {
  display: flex;
  flex-wrap: wrap;
}

.el-tag {
  margin-right: 10px;
  margin-bottom: 10px;
}
.address-card {
  width: 400px;
}

.card-header {
  font-size: 18px;
  font-weight: bold;
}

.address-line {
  display: flex;
  align-items: center;
  margin-bottom: 10px;
}

.el-icon-location {
  font-size: 20px;
  margin-right: 10px;
}

.map-container {
  height: 200px;
  /* 在这里设置地图容器高度 */
}
</style>