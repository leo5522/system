<template>
  <div class="content">
    <div class="top-content">
      <div class="btn-group">
        <!-- <el-button size="normal" type="primary" @click="addRecruitment">新增</el-button> -->
      </div>
      <div class="search">
        <el-input
          v-model="position"
          style="width: 250px; margin-right: 10px"
          size="normal"
          clearable
          class="input input-content"
          placeholder="请输入意向职位名称"
        />
        <el-input
          v-model="minSalary"
          style="width: 250px; margin-right: 10px"
          size="normal"
          clearable
          class="input input-content"
          placeholder="请输入期望薪资"
        />
        <el-input
          v-model="positionWorkplace"
          style="width: 250px; margin-right: 10px"
          size="normal"
          clearable
          class="input input-content"
          placeholder="请输入期望工作地点"
        />
        <el-button size="normal" type="primary" @click="reloadTable">搜索</el-button>
      </div>
    </div>
    <div class="card-box">
      <div class="card-container">
        <div class="card" v-for="(item, index) in cards" :key="index" @mouseover="item.hover = true" @mouseleave="item.hover = false">
          <img src="../../assets/defult.jpg" alt="学生头像" class="photo" />
          <div class="card-content">
            <div class="card-title">{{ item.NAME }}</div>
            <ul class="card-info-list">
              <li class="card-info">{{ item.gender }}</li>
              <li class="card-info">{{ item.age }}</li>
              <li class="card-info">{{ item.position }}</li>
              <li class="card-info">{{ item.minSalary }}</li>
              <li class="card-info">{{ item.positionWorkplace }}</li>
              <li class="card-info">{{ item.university }}</li>
              <li class="card-info">{{ item.major }}</li>
            </ul>
          </div>
          <div class="card-hover" v-show="item.hover">
            <el-button type="text" @click="showDialog(item)">详情</el-button>
          </div>
        </div>
      </div>
      <el-dialog :visible.sync="dialogVisible" title="求职信息" width="20%">
        <div class="jobhunt-details">
          <div class="row">
            <div class="label">姓名：</div>
            <div class="jobhunt-name">{{ itemDetail.NAME }}</div>
          </div>
          <div class="row">
            <div class="label">性别：</div>
            <div class="jobhunt-gender">{{ itemDetail.gender }}</div>
          </div>
          <div class="row">
            <div class="label">年龄：</div>
            <div class="jobhunt-age">{{ itemDetail.age }}</div>
          </div>
          <div class="row">
            <div class="label">毕业学院：</div>
            <div class="jobhunt-university">{{ itemDetail.university }}</div>
          </div>
          <div class="row">
            <div class="label">专业：</div>
            <div class="jobhunt-major">{{ itemDetail.major }}</div>
          </div>
          <div class="row">
            <div class="label">爱好：</div>
            <div class="jobhunt-hobby">{{ itemDetail.hobby }}</div>
          </div>
          <div class="row">
            <div class="label">荣获奖项：</div>
            <div class="jobhunt-award">{{ itemDetail.award }}</div>
          </div>
          <div class="row">
            <div class="label">自我评价：</div>
            <div class="jobhunt-selfAssessment">{{ itemDetail.selfAssessment }}</div>
          </div>
        </div>
        <div slot="footer">
          <el-button @click="dialogVisible = false">关闭</el-button>
        </div>
      </el-dialog>
    </div>
    <div class="pagination-wrapper">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="pagination.current"
        :page-size="pagination.pageSize"
        :page-sizes="pagination.pageSizeOptions"
        :layout="layout"
        background
        :total="pagination.total"
      />
    </div>
  </div>
</template>

<script>
import { getJobHuntList } from '@/api/talent.js';
export default {
  name: 'PersonnelMarket',
  data() {
    return {
      minSalary: '',
      position: '',
      positionWorkplace: '',
      dialogVisible: false,
      cards: [],
      itemDetail: {},
      jobtypeList: {
        1: '长期',
        2: '短期',
      },
      layout: 'total, sizes, prev, pager, next, jumper',
      pagination: {
        current: 1,
        pageSize: 10,
        pageSizeOptions: [5, 10, 20, 30, 50, 100, 500],
        total: 10,
        showTotal: (total, range) => {
          return `共 ${total} 条 `;
        },
      },
    };
  },
  mounted() {
    this.reloadTable();
  },
  methods: {
    showDialog(item) {
      this.itemDetail = item;
      this.dialogVisible = true;
    },
    reloadTable() {
      let obj = {
        pageNum: this.pagination.current,
        pageSize: this.pagination.pageSize,
        minSalary:this.minSalary,
        position:this.position,
        positionWorkplace:this.positionWorkplace,
      };
      getJobHuntList(obj).then((res) => {
        res.data.forEach((item) => {
          item['hover'] = false;
        });
        this.cards = res.data;
        this.pagination.total = res.total;
      });
    },
    handleSizeChange(pageSize) {
      if (this.pagination) {
        this.pagination.pageSize = pageSize;
        this.pagination.current = 1;
        this.reloadTable();
      } else {
        this.reloadTable();
      }
    },
    handleCurrentChange(current) {
      if (this.pagination) {
        this.pagination.current = current;
        this.reloadTable();
      } else {
        this.reloadTable();
      }
    },
  },
};
</script>

<style scoped>
.card-box {
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
  width: 100%;
}
.card {
  flex: 1;
  box-sizing: border-box;
  height: 290px;
  margin: 0 10px;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
  position: relative;
  overflow: hidden;
}

.card:before {
  content: '';
  display: block;
  position: absolute;
  top: -10px;
  left: -10px;
  right: -10px;
  bottom: -10px;
  clip-path: polygon(0% 0%, 100% 0%, 100% calc(100% - 30px), calc(100% - 30px) 100%, 0% 100%);
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

.row {
  display: flex;
  margin-bottom: 10px;
}

.label {
  width: 100px;
  font-weight: bold;
}

.top-content {
  display: flex;
  justify-content: space-between;
  margin-bottom: 25px;
}
.search {
  display: flex;
}
.btn {
  color: #096dd9;
  margin-left: 5px;
  text-decoration: none;
}
.pagination-wrapper {
  margin-top: 15px !important;
}
.el-pagination {
  text-align: right !important;
}
</style>
