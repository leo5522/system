<template>
  <div class="content">
    <div class="top-content">
      <div class="search">
        <el-select size="normal" style="width: 250px; margin-right: 10px" class="input" v-model="status" placeholder="请选择投诉状态">
          <el-option v-for="item in statusList" :key="item.value" :label="item.label" :value="item.value"></el-option>
        </el-select>
        <el-button size="normal" type="primary" @click="reloadTable">搜索</el-button>
      </div>
    </div>
    <el-table ref="multipleTable" :data="tableData" size="normal" style="width: 100%">
      <el-table-column label="#" width="55" type="index" align="center" fixed="left"></el-table-column>
      <template v-for="(col, index) in columns">
        <el-table-column
          v-if="col.show"
          :show-overflow-tooltip="col.showOverflow"
          :type="col.type"
          :prop="col.dataIndex"
          :label="col.title"
          :width="col.width"
          :align="col.align || 'left'"
        >
          <template #default="scope" v-if="col.dataIndex === 'operation' || col.dataIndex === 'status'">
            <div v-if="col.dataIndex === 'status'">{{ showStatus[scope.row.status] }}</div>
            <div v-if="col.dataIndex === 'operation'">
              <a class="btn" href="javascript:;" @click="dialogVisible = true">申诉</a>
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
    <el-dialog width="70%" :visible.sync="dialogVisible" title="申诉投诉" :close-on-click-modal="false" :before-close="handleClose">
      <div class="row">
        <span style="width: 100px">管理员回复：</span>
        被投诉了，请申诉
      </div>
      <div class="row">
        <span style="width: 100px">申诉回复:</span>
        <el-input
          style="width: 300px"
          type="textarea"
          resize="none"
          :autosize="{ minRows: 5 }"
          clearable
          size="small"
          v-model="companyReply"
          placeholder="请输入申诉内容"
        ></el-input>
      </div>
      <div class="footer">
        <el-button type="primary" size="big" @click="submitComplain">提交申诉</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { getRecruitmentList, delRecruitment } from '@/api/recruitment';

export default {
  components: {},
  data() {
    return {
      dialogVisible: false,
      companyReply: '',
      status: null,
      statusList: [
        {
          label: '待处理',
          value: 1,
        },
        {
          label: '申诉中',
          value: 2,
        },
        {
          label: '被驳回',
          value: 5,
        },
      ],
      showStatus: {
        1: '待处理',
        2: '申诉中',
        5: '被驳回',
      },
      tableData: [
        {
          reason:
            '投诉原因投诉原因投诉原因投诉原因投诉原因投诉原因投诉原因投诉原因投诉原因投诉原因投诉原因投诉原因投诉原因投诉原因投诉原因投诉原因投诉原因投诉原因投诉原因投诉原因投诉原因投诉原因投诉原因投诉原因投诉原因投诉原因投诉原因投诉原因投诉原因投诉原因投诉原因投诉原因',
          createTime: '2021-2-1',
          status: 1,
        },
      ],
      columns: [
        {
          title: '投诉原因',
          show: true,
          dataIndex: 'reason',
          showOverflow: true,
        },
        {
          title: '投诉时间',
          show: true,
          dataIndex: 'createTime',
          width: 150,
        },
        {
          title: '状态',
          show: true,
          dataIndex: 'status',
          width: 150,
        },
        {
          title: '操作',
          align: 'right',
          show: true,
          dataIndex: 'operation',
          width: 150,
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
        status: this.status,
      };
      // getRecruitmentList(obj).then((res) => {
      //   this.tableData = res.records;
      //   this.pagination.total = res.total;
      // });
    },
    // 提交申诉
    submitComplain() {
      this.dialogVisible = false;
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
  justify-content: flex-end;
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
  margin-bottom: 10px;
}
.footer {
  margin: 20px 0;
  text-align: center;
}
</style>
