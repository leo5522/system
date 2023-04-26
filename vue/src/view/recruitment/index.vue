<template>
  <div class="content">
    <div class="top-content">
      <div class="btn-group">
        <el-button size="normal" type="primary" @click="addRecruitment">新增</el-button>
      </div>
      <div class="search">
        <el-input
          v-model="career"
          style="width: 250px; margin-right: 10px"
          size="normal"
          clearable
          class="input input-content"
          placeholder="请输入职位名称"
        />
        <el-select size="normal" style="width: 250px; margin-right: 10px" class="input" v-model="jobtype" placeholder="请选择职位分类">
          <el-option v-for="item in jobtypeList" :key="item.value" :label="item.label" :value="item.value"></el-option>
        </el-select>
        <el-button size="normal" type="primary" @click="reloadTable">搜索</el-button>
      </div>
    </div>
    <el-table ref="multipleTable" :data="tableData" size="normal" style="width: 100%">
      <el-table-column label="#" width="55" type="index" align="center" fixed="left"></el-table-column>
      <template v-for="(col, index) in columns">
        <el-table-column v-if="col.show" :type="col.type" :prop="col.dataIndex" :label="col.title" :width="col.width" :align="col.align || 'left'">
          <template #default="scope" v-if="col.dataIndex === 'operation' || col.dataIndex === 'jobtype' || col.dataIndex === 'status'">
            <div v-if="col.dataIndex === 'status'">{{ showStatus[scope.row.status] }}</div>
            <div v-if="col.dataIndex === 'jobtype'">{{ scope.row.jobtype == 1 ? '长期' : '短期' }}</div>
            <div v-if="col.dataIndex === 'operation'">
              <a class="btn" href="javascript:;" @click="editRecruitment(scope.row)">编辑</a>
              <el-popconfirm title="确定要下架本条数据吗?" @confirm="handleDeleteRecord" confirmButtonText="确定" cancelButtonText="取消">
                <template #reference>
                  <a class="btn" href="javascript:;">下架</a>
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
    <AddEditDialog ref="addEditDialog" :recruitmentId="recruitmentId"></AddEditDialog>
  </div>
</template>

<script>
import AddEditDialog from './components/AddEditDialog.vue';
import { getRecruitmentList } from '@/api/recruitment';

export default {
  components: {
    AddEditDialog,
  },
  data() {
    return {
      recruitmentId: '',
      career: '',
      jobtype: '',
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
          label: '待审核',
          value: 1,
        },
        {
          label: '审核通过',
          value: 2,
        },
        {
          label: '审核未通过',
          value: 3,
        },
        {
          label: '下架',
          value: 4,
        },
      ],
      showStatus: {
        1: '待审核',
        2: '审核通过',
        3: '审核未通过',
        4: '下架',
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
        },
        {
          title: '联系电话',
          show: true,
          dataIndex: 'phone',
        },
        {
          title: '发布时间',
          show: true,
          dataIndex: 'createTime',
        },
        {
          title: '状态',
          show: true,
          dataIndex: 'status',
        },
        {
          title: '操作',
          align: 'right',
          show: true,
          dataIndex: 'operation',
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
        jobtype: this.jobtype,
      };
      getRecruitmentList(obj).then((res) => {
        this.tableData = res.data.records;
        this.pagination.total=res.data.total
      });
    },
    // 新增
    addRecruitment() {
      this.$refs.addEditDialog.dialogVisible = true;
      this.$refs.addEditDialog.isSaveBtn = true;
      this.$refs.addEditDialog.getTitle('新增招聘信息');
    },
    // 编辑
    editRecruitment(record) {
      // this.recruitmentId = record.id;
      this.$refs.addEditDialog.dialogVisible = true;
      this.$refs.addEditDialog.isSaveBtn = false;
      this.$refs.addEditDialog.getTitle('编辑招聘信息');
    },
    // 下架
    handleDeleteRecord() {
      console.log('del');
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
</style>
