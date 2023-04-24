<!--<template>-->
<!--  <div>-->
<!--    <h1>企业管理自己发布的招聘信息和应聘者信息，包括更改职位的状态（例如是否已关闭）。并支持在线筛选和管理简历以及进行面试和就业通知等。</h1>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--  name: "MyRecruitment"-->
<!--}-->
<!--</script>-->

<!--<style scoped>-->

<!--</style>-->



<!--<template>-->
<!--  <div>-->
<!--    <el-row :gutter="20">-->
<!--      <el-col :span="12">-->
<!--        <el-card class="job-card" v-for="(job, index) in jobs" :key="index">-->
<!--          <div slot="header" class="clearfix">-->
<!--            <span>{{ job.title }}</span>-->
<!--            <el-button type="danger" size="mini" class="fr" @click="closeJob(job)">-->
<!--              关闭职位-->
<!--            </el-button>-->
<!--          </div>-->
<!--          <div class="job-info">-->
<!--            <div class="job-desc">{{ job.desc }}</div>-->
<!--            <div class="job-requirements">{{ job.requirements }}</div>-->
<!--          </div>-->
<!--          <el-divider></el-divider>-->
<!--          <div class="job-applicants">-->
<!--            <el-row :gutter="10" class="applicant-item" v-for="(applicant, i) in job.applicants" :key="i">-->
<!--              <el-col :span="4"><img :src="applicant.avatar" alt=""></el-col>-->
<!--              <el-col :span="14">-->
<!--                <div class="applicant-name">{{ applicant.name }}</div>-->
<!--                <div class="applicant-email">{{ applicant.email }}</div>-->
<!--              </el-col>-->
<!--              <el-col :span="6">-->
<!--                <el-button-group>-->
<!--                  <el-button type="primary" size="mini" @click="interview(applicant)">邀请面试</el-button>-->
<!--                  <el-button type="success" size="mini" @click="sendOffer(applicant)">发送录用通知</el-button>-->
<!--                </el-button-group>-->
<!--              </el-col>-->
<!--            </el-row>-->
<!--          </div>-->
<!--        </el-card>-->
<!--      </el-col>-->
<!--      <el-col :span="12">-->
<!--        <el-card class="applicant-card" v-for="(applicant, index) in applicants" :key="index">-->
<!--          <div slot="header" class="clearfix">-->
<!--            <span>{{ applicant.name }}</span>-->
<!--            <el-button type="danger" size="mini" class="fr" @click="removeApplicant(applicant)">-->
<!--              删除应聘者-->
<!--            </el-button>-->
<!--          </div>-->
<!--          <div class="applicant-info">-->
<!--            <div class="applicant-email">{{ applicant.email }}</div>-->
<!--            <div class="applicant-resume">{{ applicant.resume }}</div>-->
<!--          </div>-->
<!--        </el-card>-->
<!--      </el-col>-->
<!--    </el-row>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--  data() {-->
<!--    return {-->
<!--      jobs: [-->
<!--        {-->
<!--          id: 1,-->
<!--          title: '前端工程师',-->
<!--          desc: '负责公司Web项目前端开发及维护工作，包括JavaScript代码编写、HTML/CSS布局设计、前端性能优化等。',-->
<!--          requirements: '1. 精通JavaScript、HTML和CSS等Web前端技术；2. 熟悉React/Vue等主流框架；3. 具备良好的团队合作能力。',-->
<!--          applicants: [-->
<!--            { name: '张三', email: 'zhangsan@example.com', resume: 'https://example.com/resume/zhangsan', avatar: 'https://example.com/avatar/zhangsan.jpg' },-->
<!--            { name: '李四', email: 'lisi@example.com', resume: 'https://example.com/resume/lisi', avatar: 'https://example.com/avatar/lisi.jpg' }-->
<!--          ]-->
<!--        },-->
<!--        {-->
<!--          id: 2,-->
<!--          title: 'Java开发工程师',-->
<!--          desc: '负责公司Java后台项目的设计、开发和维护，能独立完成Java Web应用程序开发。',-->
<!--          requirements: '1. 熟悉Java Web相关技术，如Spring、MyBatis等；2. 具备良好的编码规范和代码质量意识；3. 具备团队合作精神。',-->
<!--          applicants: [-->
<!--            { name: '王五', email: 'wangwu@example.com', resume: 'https://example.com/resume/wangwu', avatar: 'https://example.com/avatar/wangwu.jpg' },-->
<!--            { name: '赵六', email: 'zhaoliu@example.com', resume: 'https://example.com/resume/zhaoliu', avatar: 'https://example.com/avatar/zhaoliu.jpg' }-->
<!--          ]-->
<!--        }-->
<!--      ],-->
<!--      applicants: [-->
<!--        { name: '张三', email: 'zhangsan@example.com', resume: 'https://example.com/resume/zhangsan' },-->
<!--        { name: '李四', email: 'lisi@example.com', resume: 'https://example.com/resume/lisi' },-->
<!--        { name: '王五', email: 'wangwu@example.com', resume: 'https://example.com/resume/wangwu' },-->
<!--        { name: '赵六', email: 'zhaoliu@example.com', resume: 'https://example.com/resume/zhaoliu' }-->
<!--      ]-->
<!--    }-->
<!--  },-->
<!--  methods: {-->
<!--    closeJob(job) {-->
<!--      // 关闭职位的逻辑处理代码-->
<!--      console.log(`关闭职位：${job.title}`)-->
<!--    },-->
<!--    interview(applicant) {-->
<!--      // 邀请面试的逻辑处理代码-->
<!--      console.log(`邀请面试：${applicant.name}`)-->
<!--    },-->
<!--    sendOffer(applicant) {-->
<!--      // 发送录用通知的逻辑处理代码-->
<!--      console.log(`发送录用通知：${applicant.name}`)-->
<!--    },-->
<!--    removeApplicant(applicant) {-->
<!--      // 删除应聘者的逻辑处理代码-->
<!--      console.log(`删除应聘者：${applicant.name}`)-->
<!--    }-->
<!--  }-->
<!--}-->
<!--</script>-->

<!--<style scoped>-->
<!--.job-card,-->
<!--.applicant-card {-->
<!--  margin-bottom: 20px;-->
<!--}-->
<!--.job-desc,-->
<!--.job-requirements,-->
<!--.applicant-resume {-->
<!--  white-space: pre-wrap;-->
<!--}-->
<!--.job-applicants .applicant-item {-->
<!--  margin-bottom: 10px;-->
<!--}-->
<!--.applicant-card .el-card__body {-->
<!--  text-align: center;-->
<!--}-->
<!--.applicant-card .applicant-info {-->
<!--  padding: 20px 0;-->
<!--}-->
<!--.applicant-card .applicant-email {-->
<!--  font-size: 16px;-->
<!--  margin-bottom: 10px;-->
<!--}-->
<!--.fr {-->
<!--  float: right;-->
<!--}-->
<!--</style>-->


<template>
  <div>
    <!-- 招聘信息卡片列表 -->
    <el-row>
      <el-col v-for="recruitment in recruitments" :key="recruitment.id" :span="8">
        <el-card :body-style="{ padding: '20px' }">
          <p>企业名称：{{ recruitment.companyName }}</p>
          <p>职位分类：{{ recruitment.career }}</p>
          <p>职位名称：{{ recruitment.job }}</p>
          <p>最低薪资：{{ recruitment.minsalary }}</p>
          <p>最高薪资：{{ recruitment.maxsalary }}</p>
          <p>工作经验：{{ recruitment.experience }}</p>
          <p>学历要求：{{ recruitment.education }}</p>
          <p>工作地点：{{ recruitment.workplace }}</p>
          <p>工作内容：{{ recruitment.description }}</p>
          <p>负责人：{{ recruitment.principal }}</p>
          <p>联系电话：{{ recruitment.phone }}</p>
          <p>点击次数：{{ recruitment.clickCount }}</p>
          <p>创建时间：{{ recruitment.createTime }}</p>
          <el-button type="primary" @click="showDetailDialog(recruitment)">详情</el-button>
          <el-button type="warning" @click="showEditDialog(recruitment)">编辑</el-button>
          <el-button type="danger" @click="deleteRecord(recruitment)">删除</el-button>
        </el-card>
      </el-col>
    </el-row>

    <!-- 新增招聘信息弹窗 -->
    <el-dialog title="新增招聘信息" v-model="addDialogVisible">
      <el-form :model="newRecruitment" ref="newRecruitmentForm" :rules="newRecruitmentRules">
        <el-form-item label="企业名称" prop="companyName">
          <el-input v-model="newRecruitment.companyName"></el-input>
        </el-form-item>
        <el-form-item label="职位分类" prop="career">
          <el-input v-model="newRecruitment.career"></el-input>
        </el-form-item>
        <!-- 其他表单项 -->
      </el-form>
      <div slot="footer">
        <el-button @click="addDialogVisible = false">取消</el-button>
        <el-button type="primary" @click="addRecord">确定</el-button>
      </div>
    </el-dialog>

    <!-- 编辑招聘信息弹窗 -->
    <el-dialog title="编辑招聘信息" v-model="editDialogVisible">
      <el-form :model="selectedRecruitment" ref="editRecruitmentForm" :rules="editRecruitmentRules">
        <el-form-item label="企业名称" prop="companyName">
          <el-input v-model="selectedRecruitment.companyName"></el-input>
        </el-form-item>
        <el-form-item label="职位分类" prop="career">
          <el-input v-model="selectedRecruitment.career"></el-input>
        </el-form-item>
        <!-- 其他表单项 -->
      </el-form>
      <div slot="footer">
        <el-button @click="editDialogVisible = false">取消</el-button>
        <el-button type="primary" @click="editRecord">确定</el-button>
      </div>
    </el-dialog>

    <!-- 查看招聘信息详情弹窗 -->
    <el-dialog title="招聘信息详情" v-model="detailDialogVisible">
      <p>企业名称：{{ selectedRecruitment.companyName }}</p>
      <p>职位分类：{{ selectedRecruitment.career }}</p>
      <p>职位名称：{{ selectedRecruitment.job }}</p>
      <p>最低薪资：{{ selectedRecruitment.minsalary }}</p>
      <p>最高薪资：{{ selectedRecruitment.maxsalary }}</p>
      <p>工作经验：{{ selectedRecruitment.experience }}</p>
      <p>学历要求：{{ selectedRecruitment.education }}</p>
      <p>工作地点：{{ selectedRecruitment.workplace }}</p>
      <p>工作内容：{{ selectedRecruitment.description }}</p>
      <p>负责人：{{ selectedRecruitment.principal }}</p>
    </el-dialog>
    <!-- 查看学生简历弹窗 -->
    <el-dialog title="学生简历详情" v-model="resumeDialogVisible">
      <p>姓名：{{ selectedResume.name }}</p>
      <p>性别：{{ selectedResume.gender }}</p>
      <p>年龄：{{ selectedResume.age }}</p>
      <p>家庭住址：{{ selectedResume.address }}</p>
      <p>专业：{{ selectedResume.major }}</p>
      <p>大学：{{ selectedResume.university }}</p>
      <p>爱好：{{ selectedResume.hobby }}</p>
      <el-divider></el-divider>
      <p>工作经历：{{ selectedResume.workExperience }}</p>
      <p>荣誉经历：{{ selectedResume.honorsAwards }}</p>
      <p>自我评价：{{ selectedResume.selfEvaluation }}</p>
      <div slot="footer">
        <el-button @click="resumeDialogVisible = false">关闭</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      recruitments: [], // 招聘信息列表
      addDialogVisible: false, // 新增招聘信息弹窗可见性
      editDialogVisible: false, // 编辑招聘信息弹窗可见性
      detailDialogVisible: false, // 查看招聘信息详情弹窗可见性
      resumeDialogVisible: false, // 查看学生简历弹窗可见性
      newRecruitment: {}, // 新增招聘信息表单数据
      selectedRecruitment: {}, // 编辑/查看招聘信息表单数据
      selectedResume: {}, // 查看学生简历的数据
      newRecruitmentRules: { // 新增招聘信息表单验证规则
        companyName: [{ required: true, message: '请输入企业名称', trigger: 'blur' }],
        career: [{ required: true, message: '请输入职位分类', trigger: 'blur' }],
// 其他表单项的验证规则
      },
      editRecruitmentRules: { // 编辑招聘信息表单验证规则
        companyName: [{ required: true, message: '请输入企业名称', trigger: 'blur' }],
        career: [{ required: true, message: '请输入职位分类', trigger: 'blur' }],
// 其他表单项的验证规则
      },
    }
  },
  mounted() {
    this.getRecruitments()
  },
  methods: {
    getRecruitments() {
// 从数据库中获取招聘信息列表
// ...
// 将招聘信息赋值给 this.recruitments
    },
    addRecord() {
// 提交新增招聘信息表单
// 验证表单并提交到后端保存到数据库
// 更新 this.recruitments
// 关闭新增招聘信息弹窗
    },
    showEditDialog(recruitment) {
// 显示编辑招聘信息弹窗
// 将选中的招聘信息赋值给 this.selectedRecruitment
// 打开弹窗
    },
    editRecord() {
// 提交编辑招聘信息表单
// 验证表单并提交到后端更新数据库
// 更新 this.recruitments
// 关闭编辑招聘信息弹窗
    },
    showDetailDialog(recruitment) {
// 显示查看招聘信息详情弹窗
// 将选中的招聘信息赋值给 this.selectedRecruitment
// 打开弹窗
    },
    deleteRecord(recruitment) {
// 删除招聘信息记录
// 从数据库中删除该招聘信息
// 更新 this.recruitments
    },
    showResumeDialog(resume) {
// 显示学生简历详情弹窗
// 将选中的学生简历赋值给 this.selectedResume
// 打开弹窗
    },
    replyToApplicant(reply, recruitmentId, resumeId) {
// 回复求职者信息
//将回复信息保存到数据库
// 更新对应的招聘信息和学生简历的状态
// 根据情况发送通知给学生端
    },
    decideApplication(decision, recruitmentId, resumeId) {
// 录用/不录用求职者
// 将决定保存到数据库
// 更新对应的招聘信息和学生简历的状态
// 根据情况发送通知给学生端
    }
  }
}
</script>





