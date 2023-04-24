<!--<template>-->
<!--  <div class="resume-library">-->
<!--    <el-row>-->
<!--      <el-col :span="6">-->
<!--        <el-card class="filter-card">-->
<!--          <div slot="header">-->
<!--            <h3>筛选条件</h3>-->
<!--          </div>-->
<!--          <div class="filter-item">-->
<!--            <h4>工作经验</h4>-->
<!--            <el-checkbox-group v-model="filters.experience">-->
<!--              <el-checkbox label="1年以下"></el-checkbox>-->
<!--              <el-checkbox label="1-3年"></el-checkbox>-->
<!--              <el-checkbox label="3-5年"></el-checkbox>-->
<!--              <el-checkbox label="5年以上"></el-checkbox>-->
<!--            </el-checkbox-group>-->
<!--          </div>-->
<!--          <div class="filter-item">-->
<!--            <h4>学历要求</h4>-->
<!--            <el-checkbox-group v-model="filters.education">-->
<!--              <el-checkbox label="本科及以上"></el-checkbox>-->
<!--              <el-checkbox label="大专及以上"></el-checkbox>-->
<!--              <el-checkbox label="硕士及以上"></el-checkbox>-->
<!--            </el-checkbox-group>-->
<!--          </div>-->
<!--          <div class="filter-item">-->
<!--            <h4>期望薪资</h4>-->
<!--            <el-slider v-model="filters.salary" range :marks="salaryMarks"></el-slider>-->
<!--          </div>-->
<!--        </el-card>-->
<!--      </el-col>-->
<!--      <el-col :span="18">-->
<!--        <h2>简历列表</h2>-->
<!--        <el-card v-for="(resume, index) in filteredResumes" :key="index" class="resume-card">-->
<!--          <div slot="header">-->
<!--            <h3>{{ resume.name }}</h3>-->
<!--          </div>-->
<!--          <div class="resume-info">-->
<!--            <p><strong>工作经验：</strong>{{ resume.experience }}</p>-->
<!--            <p><strong>学历要求：</strong>{{ resume.education }}</p>-->
<!--            <p><strong>期望薪资：</strong>{{ resume.salary }}</p>-->
<!--            <p><strong>最近更新时间：</strong>{{ resume.updatedAt }}</p>-->
<!--          </div>-->
<!--          <div slot="footer">-->
<!--            <el-link type="primary" @click="openResumeDetail(resume)">查看详情</el-link>-->
<!--          </div>-->
<!--        </el-card>-->
<!--      </el-col>-->
<!--    </el-row>-->

<!--    <el-dialog :visible.sync="isResumeDetailOpen" title="简历详情" width="50%">-->
<!--      <div v-if="selectedResume">-->
<!--        <h3>{{ selectedResume.name }}</h3>-->
<!--        <p><strong>工作经验：</strong>{{ selectedResume.experience }}</p>-->
<!--        <p><strong>学历要求：</strong>{{ selectedResume.education }}</p>-->
<!--        <p><strong>期望薪资：</strong>{{ selectedResume.salary }}</p>-->
<!--        <p><strong>联系方式：</strong>{{ selectedResume.contact }}</p>-->
<!--        <p><strong>自我介绍：</strong>{{ selectedResume.introduction }}</p>-->
<!--        <p><strong>工作经历：</strong></p>-->
<!--        <ul>-->
<!--          <li v-for="(work, index) in selectedResume.workExperience" :key="index">-->
<!--            {{ work.company }}（{{ work.duration }}）：{{ work.position }}-->
<!--          </li>-->
<!--        </ul>-->
<!--        <p><strong>教育经历：</strong></p>-->
<!--        <ul>-->
<!--          <li v-for="(edu, index) in selectedResume.educationExperience" :key="index">-->
<!--            {{ edu.school }}（{{ edu.duration }}）：{{ edu.major }}-->
<!--          </li>-->
<!--        </ul>-->
<!--      </div>-->
<!--    </el-dialog>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--  data() {-->
<!--    return {-->
<!--      resumes: [-->
<!--        {-->
<!--          name: '张三',-->
<!--          experience: '3年',-->
<!--          education: '本科',-->
<!--          salary: [10, 20],-->
<!--          updatedAt: '2022-03-01',-->
<!--          contact: 'zhangsan@test.com',-->
<!--          introduction: '我是一名热爱前端开发的程序员，擅长Vue和React。',-->
<!--          workExperience: [-->
<!--            {-->
<!--              company: 'ABC公司',-->
<!--              position: '前端工程师',-->
<!--              duration: '2019-2022'-->
<!--            },-->
<!--            {-->
<!--              company: 'DEF公司',-->
<!--              position: '实习生',-->
<!--              duration: '2018-2019'-->
<!--            }-->
<!--          ],-->
<!--          educationExperience: [-->
<!--            {-->
<!--              school: 'GHI大学',-->
<!--              major: '计算机科学与技术',-->
<!--              degree: '本科',-->
<!--              duration: '2015-2019'-->
<!--            }-->
<!--          ]-->
<!--        },-->
<!--        {-->
<!--          name: '李四',-->
<!--          experience: '5年',-->
<!--          education: '硕士',-->
<!--          salary: [20, 30],-->
<!--          updatedAt: '2022-03-05',-->
<!--          contact: 'lisi@test.com',-->
<!--          introduction: '我是一名有多年全栈开发经验的程序员，熟悉Java和Angular。',-->
<!--          workExperience: [-->
<!--            {-->
<!--              company: 'JKL公司',-->
<!--              position: '全栈工程师',-->
<!--              duration: '2019-2022'-->
<!--            },-->
<!--            {-->
<!--              company: 'MNO公司',-->
<!--              position: 'Java开发工程师',-->
<!--              duration: '2016-2019'-->
<!--            },-->
<!--            {-->
<!--              company: 'PQR公司',-->
<!--              position: '实习生',-->
<!--              duration: '2015-2016'-->
<!--            }-->
<!--          ],-->
<!--          educationExperience: [-->
<!--            {-->
<!--              school: 'STU大学',-->
<!--              major: '软件工程',-->
<!--              degree: '硕士',-->
<!--              duration: '2012-2015'-->
<!--            },-->
<!--            {-->
<!--              school: 'VWX大学',-->
<!--              major: '计算机科学与技术',-->
<!--              degree: '本科',-->
<!--              duration: '2008-2012'-->
<!--            }-->
<!--          ]-->
<!--        },-->
<!--        {-->
<!--          name: '王五',-->
<!--          experience: '1年以下',-->
<!--          education: '大专',-->
<!--          salary: [5, 10],-->
<!--          updatedAt: '2022-03-08',-->
<!--          contact: 'wangwu@test.com',-->
<!--          introduction: '我是一名热爱前端开发的初级程序员，正在努力学习Vue和React。',-->
<!--          workExperience: [],-->
<!--          educationExperience: [-->
<!--            {-->
<!--              school: 'YZ大学',-->
<!--              major: '计算机应用技术',-->
<!--              degree: '大专',-->
<!--              duration: '2017-2020'-->
<!--            }-->
<!--          ]-->
<!--        },-->
<!--        {-->
<!--          name: '张三',-->
<!--          experience: '3年',-->
<!--          education: '本科',-->
<!--          salary: [10, 20],-->
<!--          updatedAt: '2022-03-01',-->
<!--          contact: 'zhangsan@test.com',-->
<!--          introduction: '我是一名热爱前端开发的程序员，擅长Vue和React。',-->
<!--          workExperience: [-->
<!--            {-->
<!--              company: 'ABC公司',-->
<!--              position: '前端工程师',-->
<!--              duration: '2019-2022'-->
<!--            },-->
<!--            {-->
<!--              company: 'DEF公司',-->
<!--              position: '实习生',-->
<!--              duration: '2018-2019'-->
<!--            },-->
<!--            {-->
<!--              school: 'GHI大学',-->
<!--              major: '计算机科学与技术',-->
<!--              duration: '2015-2019'-->
<!--            }-->
<!--          ],-->
<!--          educationExperience: []-->
<!--        },-->
<!--        {-->
<!--          name: '李四',-->
<!--          experience: '5年',-->
<!--          education: '硕士',-->
<!--          salary: [15, 25],-->
<!--          updatedAt: '2022-02-14',-->
<!--          contact: 'lisi@test.com',-->
<!--          introduction: '我是一名资深的全栈开发工程师，精通Java和Python。',-->
<!--          workExperience: [-->
<!--            {-->
<!--              company: 'JKL公司',-->
<!--              position: '高级工程师',-->
<!--              duration: '2018-至今'-->
<!--            },-->
<!--            {-->
<!--              company: 'MNO公司',-->
<!--              position: '中级工程师',-->
<!--              duration: '2015-2018'-->
<!--            }-->
<!--          ],-->
<!--          educationExperience: [-->
<!--            {-->
<!--              school: 'PQR大学',-->
<!--              major: '软件工程',-->
<!--              duration: '2012-2015'-->
<!--            },-->
<!--            {-->
<!--              school: 'STU研究院',-->
<!--              major: '计算机科学与技术',-->
<!--              duration: '2008-2012'-->
<!--            }-->
<!--          ]-->
<!--        }-->
<!--      ],-->
<!--      filters: {-->
<!--        experience: [],-->
<!--        education: [],-->
<!--        salary: [0, 30]-->
<!--      },-->
<!--      salaryMarks: {-->
<!--        0: '¥0',-->
<!--        10: '¥10k',-->
<!--        20: '¥20k',-->
<!--        30: '¥30k'-->
<!--      },-->
<!--      isResumeDetailOpen: false,-->
<!--      selectedResume: null-->
<!--    };-->
<!--  },-->
<!--  computed: {-->
<!--    filteredResumes() {-->
<!--      let filtered = this.resumes;-->
<!--      if (this.filters.experience.length > 0) {-->
<!--        filtered = filtered.filter(resume => this.filters.experience.includes(resume.experience.replace(/[^0-9]/g, '')));-->
<!--      }-->
<!--      if (this.filters.education.length > 0) {-->
<!--        filtered = filtered.filter(resume => this.filters.education.includes(resume.education));-->
<!--      }-->
<!--      filtered = filtered.filter(resume => resume.salary[0] >= this.filters.salary[0] && resume.salary[1] <= this.filters.salary[1]);-->
<!--      return filtered;-->
<!--    }-->
<!--  },-->
<!--  methods: {-->
<!--    openResumeDetail(resume) {-->
<!--      this.isResumeDetailOpen = true;-->
<!--      this.selectedResume = resume;-->
<!--    }-->
<!--  }-->
<!-- };-->
<!--</script>-->

<!--<style scoped>-->
<!--.resume-library {-->
<!--  margin: 20px;-->
<!--}-->

<!--.filter-card {-->
<!--  height: 100%;-->
<!--}-->

<!--.filter-item {-->
<!--  margin-bottom: 20px;-->
<!--}-->

<!--.resume-card {-->
<!--  margin-bottom: 20px;-->
<!--}-->

<!--.resume-info {-->
<!--  padding: 20px;-->
<!--}-->
<!--</style>-->


<!--&lt;!&ndash;<template>&ndash;&gt;-->
<!--&lt;!&ndash;  <div class="container">&ndash;&gt;-->
<!--&lt;!&ndash;    <h2>{{pageTitle}}</h2>&ndash;&gt;-->
<!--&lt;!&ndash;    <el-input placeholder="输入关键词进行搜索" v-model="searchKeyword" class="search-input"></el-input>&ndash;&gt;-->
<!--&lt;!&ndash;    <el-row :gutter="20" class="resume-cards">&ndash;&gt;-->
<!--&lt;!&ndash;      <el-col :xs="24" :sm="12" :md="8" :lg="6" v-for="(resume, index) in filteredResumes" :key="index">&ndash;&gt;-->
<!--&lt;!&ndash;        <el-card shadow="hover" class="resume-card">&ndash;&gt;-->
<!--&lt;!&ndash;          <div slot="header" class="resume-card-header">&ndash;&gt;-->
<!--&lt;!&ndash;            <h3 class="resume-title">{{resume.name}}</h3>&ndash;&gt;-->
<!--&lt;!&ndash;            <el-button type="text" @click="showResumeDetails(index)">详情</el-button>&ndash;&gt;-->
<!--&lt;!&ndash;          </div>&ndash;&gt;-->
<!--&lt;!&ndash;          <div class="resume-card-body">&ndash;&gt;-->
<!--&lt;!&ndash;            <p><strong>期望职位：</strong>{{resume.position}}</p>&ndash;&gt;-->
<!--&lt;!&ndash;            <p><strong>工作经验：</strong>{{resume.experience}}年</p>&ndash;&gt;-->
<!--&lt;!&ndash;            <p><strong>最高学历：</strong>{{resume.education}}</p>&ndash;&gt;-->
<!--&lt;!&ndash;          </div>&ndash;&gt;-->
<!--&lt;!&ndash;        </el-card>&ndash;&gt;-->
<!--&lt;!&ndash;      </el-col>&ndash;&gt;-->
<!--&lt;!&ndash;    </el-row>&ndash;&gt;-->
<!--&lt;!&ndash;    <el-dialog title="求职者简历详情" :visible.sync="resumeDetailsDialogVisible" width="60%">&ndash;&gt;-->
<!--&lt;!&ndash;      <div v-html="selectedResume.htmlContent" class="resume-details"></div>&ndash;&gt;-->
<!--&lt;!&ndash;    </el-dialog>&ndash;&gt;-->
<!--&lt;!&ndash;  </div>&ndash;&gt;-->
<!--&lt;!&ndash;</template>&ndash;&gt;-->

<!--&lt;!&ndash;<script>&ndash;&gt;-->
<!--&lt;!&ndash;export default {&ndash;&gt;-->
<!--&lt;!&ndash;  name: "ResumeSearch",&ndash;&gt;-->
<!--&lt;!&ndash;  data() {&ndash;&gt;-->
<!--&lt;!&ndash;    return {&ndash;&gt;-->
<!--&lt;!&ndash;      pageTitle: "搜索候选人简历",&ndash;&gt;-->
<!--&lt;!&ndash;      searchKeyword: "",&ndash;&gt;-->
<!--&lt;!&ndash;      resumes: [&ndash;&gt;-->
<!--&lt;!&ndash;        {&ndash;&gt;-->
<!--&lt;!&ndash;          name: "张三",&ndash;&gt;-->
<!--&lt;!&ndash;          position: "软件工程师",&ndash;&gt;-->
<!--&lt;!&ndash;          experience: 5,&ndash;&gt;-->
<!--&lt;!&ndash;          education: "本科",&ndash;&gt;-->
<!--&lt;!&ndash;          htmlContent:&ndash;&gt;-->
<!--&lt;!&ndash;              "<p>张三，男，1990年出生，本科学历，五年工作经验。曾在IBM、华为等知名企业担任Java开发工程师，熟悉Spring、MyBatis、Oracle等技术。</p><p>具有良好的代码编写能力和沟通协调能力，能够独立完成复杂系统的设计与开发。</p>",&ndash;&gt;-->
<!--&lt;!&ndash;        },&ndash;&gt;-->
<!--&lt;!&ndash;        {&ndash;&gt;-->
<!--&lt;!&ndash;          name: "李四",&ndash;&gt;-->
<!--&lt;!&ndash;          position: "产品经理",&ndash;&gt;-->
<!--&lt;!&ndash;          experience: 8,&ndash;&gt;-->
<!--&lt;!&ndash;          education: "研究生",&ndash;&gt;-->
<!--&lt;!&ndash;          htmlContent:&ndash;&gt;-->
<!--&lt;!&ndash;              "<p>李四，女，1987年出生，研究生学历，八年工作经验。曾在腾讯等知名企业担任产品经理，负责多款移动应用和Web应用的产品策划和设计。</p><p>擅长用户研究和需求分析，有丰富的产品设计和项目管理经验。</p>",&ndash;&gt;-->
<!--&lt;!&ndash;        },&ndash;&gt;-->
<!--&lt;!&ndash;        {&ndash;&gt;-->
<!--&lt;!&ndash;          name: "王五",&ndash;&gt;-->
<!--&lt;!&ndash;          position: "UI设计师",&ndash;&gt;-->
<!--&lt;!&ndash;          experience: 3,&ndash;&gt;-->
<!--&lt;!&ndash;          education: "本科",&ndash;&gt;-->
<!--&lt;!&ndash;          htmlContent:&ndash;&gt;-->
<!--&lt;!&ndash;              "<p>王五，男，1995年出生，本科学历，三年工作经验。曾在网易等知名企业担任UI设计师，负责多款游戏和应用的界面设计。</p><p>熟练使用Photoshop、Illustrator等设计工具，有出色的创意和设计能力，能够快速响应业务需求。</p>",&ndash;&gt;-->
<!--&lt;!&ndash;        },&ndash;&gt;-->
<!--&lt;!&ndash;      ],&ndash;&gt;-->
<!--&lt;!&ndash;      filteredResumes: [],&ndash;&gt;-->
<!--&lt;!&ndash;      selectedResume: null,&ndash;&gt;-->
<!--&lt;!&ndash;      resumeDetailsDialogVisible: false,&ndash;&gt;-->
<!--&lt;!&ndash;    };&ndash;&gt;-->
<!--&lt;!&ndash;  },&ndash;&gt;-->
<!--&lt;!&ndash;  mounted() {&ndash;&gt;-->
<!--&lt;!&ndash;    this.filterResumes();&ndash;&gt;-->
<!--&lt;!&ndash;  },&ndash;&gt;-->
<!--&lt;!&ndash;  methods: {&ndash;&gt;-->
<!--&lt;!&ndash;    filterResumes() {&ndash;&gt;-->
<!--&lt;!&ndash;      if (this.searchKeyword === "") {&ndash;&gt;-->
<!--&lt;!&ndash;        this.filteredResumes = this.resumes;&ndash;&gt;-->
<!--&lt;!&ndash;      } else {&ndash;&gt;-->
<!--&lt;!&ndash;        this.filteredResumes = this.resumes.filter((resume) =>&ndash;&gt;-->
<!--&lt;!&ndash;            resume.name.toLowerCase().includes(this.searchKeyword.toLowerCase())&ndash;&gt;-->
<!--&lt;!&ndash;        );&ndash;&gt;-->
<!--&lt;!&ndash;      }&ndash;&gt;-->
<!--&lt;!&ndash;    },&ndash;&gt;-->
<!--&lt;!&ndash;    showResumeDetails(index) {&ndash;&gt;-->
<!--&lt;!&ndash;      this.selectedResume = this.filteredResumes[index];&ndash;&gt;-->
<!--&lt;!&ndash;      this.resumeDetailsDialogVisible = true;&ndash;&gt;-->
<!--&lt;!&ndash;    },&ndash;&gt;-->
<!--&lt;!&ndash;  },&ndash;&gt;-->
<!--&lt;!&ndash;  watch: {&ndash;&gt;-->
<!--&lt;!&ndash;    searchKeyword() {&ndash;&gt;-->
<!--&lt;!&ndash;      this.filterResumes();&ndash;&gt;-->
<!--&lt;!&ndash;    },&ndash;&gt;-->
<!--&lt;!&ndash;  },&ndash;&gt;-->
<!--&lt;!&ndash;};&ndash;&gt;-->
<!--&lt;!&ndash;</script>&ndash;&gt;-->


<!--&lt;!&ndash;<style>&ndash;&gt;-->
<!--&lt;!&ndash;.container {&ndash;&gt;-->
<!--&lt;!&ndash;  max-width: 1200px;&ndash;&gt;-->
<!--&lt;!&ndash;  margin: auto;&ndash;&gt;-->
<!--&lt;!&ndash;  padding: 20px;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;.search-input {&ndash;&gt;-->
<!--&lt;!&ndash;  margin-bottom: 20px;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;.resume-cards {&ndash;&gt;-->
<!--&lt;!&ndash;  margin-left: -10px;&ndash;&gt;-->
<!--&lt;!&ndash;  margin-right: -10px;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;.resume-card {&ndash;&gt;-->
<!--&lt;!&ndash;  margin-bottom: 20px;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;.resume-card-header {&ndash;&gt;-->
<!--&lt;!&ndash;  display: flex;&ndash;&gt;-->
<!--&lt;!&ndash;  justify-content: space-between;&ndash;&gt;-->
<!--&lt;!&ndash;  align-items: center;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;.resume-title {&ndash;&gt;-->
<!--&lt;!&ndash;  font-size: 18px;&ndash;&gt;-->
<!--&lt;!&ndash;  margin-bottom: 0;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;.resume-details {&ndash;&gt;-->
<!--&lt;!&ndash;  max-height: 500px;&ndash;&gt;-->
<!--&lt;!&ndash;  overflow-y: auto;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->
<!--&lt;!&ndash;</style>&ndash;&gt;-->
