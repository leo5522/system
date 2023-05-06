<template>
  <div class="content">
    <div class="top-content">
      <div class="btn-group"></div>
      <div class="search">
        <el-input
          v-model="career"
          style="width: 150px; margin-right: 10px"
          size="normal"
          clearable
          class="input input-content"
          placeholder="请输入投递职位名称"
        />
        <el-button size="normal" type="primary" @click="reloadTable">搜索</el-button>
      </div>
    </div>
    <el-table ref="multipleTable" :data="tableData" size="normal" style="width: 100%">
      <el-table-column label="#" width="55" type="index" align="center" fixed="left"></el-table-column>
      <template v-for="(col, index) in columns">
        <el-table-column v-if="col.show" :type="col.type" :prop="col.dataIndex" :label="col.title" :width="col.width" :align="col.align || 'left'">
          <template #default="scope" v-if="col.dataIndex === 'operation' || col.dataIndex === 'jobtype' || col.dataIndex === 'sta'">
            <div v-if="col.dataIndex === 'sta'">{{ showStatus[scope.row.sta] }}</div>
            <div v-if="col.dataIndex === 'jobtype'">{{ scope.row.jobtype == 1 ? '长期' : '短期' }}</div>
            <div v-if="col.dataIndex === 'operation'">
              <a class="btn" href="javascript:;" @click="handleDetail(scope.row)">简历详情</a>
              <a v-show="scope.row.sta == 7" class="btn" href="javascript:;" @click="handleSuccess(scope.row)">通过简历</a>
              <a v-show="scope.row.sta == 3" class="btn" href="javascript:;" @click="appoint(scope.row)">预约面试</a>
              <el-popconfirm
                title="确定面试已完成?"
                @confirm="pass(scope.row)"
                confirmButtonText="确定"
                cancelButtonText="取消"
                v-show="scope.row.sta == 5"
              >
                <template #reference>
                  <a class="btn" href="javascript:;">结束面试</a>
                </template>
              </el-popconfirm>
              <el-popconfirm
                title="确定要拒绝该份简历吗?"
                @confirm="handleFail(scope.row)"
                confirmButtonText="确定"
                cancelButtonText="取消"
                v-show="scope.row.sta == 7"
              >
                <template #reference>
                  <a class="btn" href="javascript:;">拒绝简历</a>
                </template>
              </el-popconfirm>
            </div>
          </template>
        </el-table-column>
      </template>
    </el-table>
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
    <el-dialog :visible.sync="dialogVisible" title="简历信息" width="20%">
      <div class="jobhunt-details">
        <div class="row">
          <div class="label">姓名：</div>
          <div class="jobhunt-name">{{ itemDetail.name }}</div>
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
      </div>
      <div slot="footer">
        <el-button size="normal" @click="dialogVisible = false">关闭</el-button>
      </div>
    </el-dialog>
    <el-dialog :visible.sync="dialogVisible1" title="企业回复" width="40%">
      <el-form ref="form" :model="form" :rules="rules" label-width="80px" size="small">
        <el-row :gutter="30">
          <el-col :span="24">
            <el-form-item label="回复内容" prop="career">
              <el-input
                type="textarea"
                resize="none"
                :autosize="{ minRows: 3 }"
                clearable
                size="small"
                v-model="form.reply"
                placeholder="请回复内容"
              ></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" style="text-align: center">
        <el-button size="normal" @click="dialogVisible1 = false">关闭</el-button>
        <el-button size="normal" type="primary" @click="agreeResume">通过简历</el-button>
      </div>
    </el-dialog>
    <el-dialog :visible.sync="dialogVisible2" title="预约面试" width="40%">
      <el-form ref="interviewFrom" :model="interviewFrom" :rules="interviewRules" label-width="80px" size="small">
        <el-row :gutter="30">
          <el-col :span="24">
            <el-form-item label="面试时间" prop="interviewTime">
              <el-date-picker
                v-model="interviewFrom.interviewTime"
                value-format="yyyy-MM-dd HH:mm:ss"
                type="datetime"
                placeholder="请选择面试日期"
              ></el-date-picker>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="30">
          <el-col :span="24">
            <el-form-item label="面试方式" prop="interviewWay">
              <el-input clearable size="small" v-model="interviewFrom.interviewWay" placeholder="请输入面试方式"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="30">
          <el-col :span="24">
            <el-form-item label="面试地点" prop="interviewPlace">
              <el-input clearable size="small" v-model="interviewFrom.interviewPlace" placeholder="请输入面试地点"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" style="text-align: center">
        <el-button size="normal" @click="dialogVisible2 = false">关闭</el-button>
        <el-button size="normal" type="primary" @click="appointmentDetail">通过简历</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { getResumeList, Agree, Refuse, appointment, pass } from '@/api/resume';

export default {
  components: {},
  data() {
    return {
      itemDetail: {},
      dialogVisible: false,
      dialogVisible1: false,
      dialogVisible2: false,
      career: '',
      jobtypeList: [
        {
          label: '长期',
          value: 1,
        },
        {
          label: '短期',
          value: 2,
        },
      ],
      statusList: [
        {
          label: '待查看',
          value: 7,
        },
        {
          label: '已回复',
          value: 1,
        },
        {
          label: '可约面试',
          value: 3,
        },
        {
          label: '已约面试',
          value: 5,
        },
      ],
      showStatus: {
        7: '待查看',
        1: '已回复',
        3: '可约面试',
        5: '已约面试',
      },
      tableData: [],
      columns: [
        {
          title: '职位名称',
          show: true,
          dataIndex: 'career',
        },
        {
          title: '职位分类',
          show: true,
          dataIndex: 'jobtype',
          width: 100,
        },
        {
          title: '投递者姓名',
          show: true,
          dataIndex: 'name',
          width: 100,
        },
        {
          title: '意向工作地点',
          show: true,
          dataIndex: 'address',
        },
        {
          title: '状态',
          show: true,
          dataIndex: 'sta',
        },
        {
          title: '操作',
          align: 'right',
          show: true,
          dataIndex: 'operation',
          width: 300,
          scopedSlots: { customRender: 'operation' },
        },
      ],
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
      form: {
        reply: '',
      },
      rules: {
        reply: [{ required: true, message: '请输入回复内容', trigger: 'blur' }],
      },
      interviewFrom: {
        interviewTime: '',
        interviewWay: '',
        interviewPlace: '',
      },
      interviewRules: {
        interviewTime: [{ required: true, message: '请选择面试日期', trigger: 'blur' }],
        interviewWay: [{ required: true, message: '请输入面试地点', trigger: 'blur' }],
        interviewPlace: [{ required: true, message: 'interviewPlace', trigger: 'blur' }],
      },
    };
  },
  mounted() {
    this.reloadTable();
  },
  methods: {
    reloadTable() {
      let obj = {
        pageNum: this.pagination.current,
        pageSize: this.pagination.pageSize,
        career: this.career,
      };
      getResumeList(obj).then((res) => {
        this.tableData = res.data;
        this.pagination.total = res.total;
      });
    },
    // 简历详情
    handleDetail(record) {
      this.itemDetail = record;
      this.dialogVisible = true;
    },
    // 通过简历
    handleSuccess(record) {
      this.itemDetail = record;
      this.dialogVisible1 = true;
    },
    agreeResume() {
      let data = {
        aId: this.itemDetail.id,
        reply: this.form.reply,
      };
      Agree(data).then((res) => {
        if (res.code == 200) {
          this.$refs['form'].resetFields();
          this.dialogVisible1 = false;
          this.reloadTable();
          this.$message({
            message: '通过简历',
            type: 'success',
          });
        }
      });
    },
    // 拒绝简历
    handleFail(record) {
      let data = {
        aId: record.id,
      };
      Refuse(data).then((res) => {
        if (res.code == 200) {
          this.reloadTable();
          this.$message({
            message: '拒绝简历',
            type: 'success',
          });
        }
      });
    },
    // 约定面试
    appoint(record) {
      this.itemDetail = record;
      this.dialogVisible2 = true;
    },
    appointmentDetail() {
      let data = {
        aId: this.itemDetail.id,
        interviewTime: this.interviewFrom.interviewTime,
        interviewWay: this.interviewFrom.interviewWay,
        interviewPlace: this.interviewFrom.interviewPlace,
      };
      appointment(data).then((res) => {
        if (res.code == 200) {
          this.reloadTable();
          this.dialogVisible2 = false;
          this.$message({
            message: '面试邀请已发送',
            type: 'success',
          });
        }
      });
    },
    pass(record) {
      let data = {
        aId: record.id,
      };
      pass(data).then((res) => {
        if (res.code == 200) {
          this.reloadTable();
        }
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
.content {
  max-width: 1200px;
  margin: 0 auto;
  border-radius: 4px;
  border: 1px solid #ebeef5;
  background-color: #fff;
  overflow: hidden;
  color: #303133;
  box-shadow: 0 2px 12px 0 rgb(0 0 0 / 10%);
  padding: 20px 16px;
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
.flex {
  display: flex;
}
.pagination-wrapper {
  margin-top: 15px !important;
}
.el-pagination {
  text-align: right !important;
}
.row {
  display: flex;
}
</style>
