<template>
  <el-dialog width="70%" :visible.sync="dialogVisible" :title="dialogTitle" :close-on-click-modal="false" :before-close="handleClose">
    <el-form ref="form" :model="form" :rules="rules" label-width="110px" size="small">
      <el-row :gutter="30">
        <el-col :span="12">
          <el-form-item label="职位名称" prop="career">
            <el-input clearable size="small" v-model="form.career" placeholder="请输入职位名称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="职位分类" prop="jobtype">
            <el-select size="size" v-model="form.jobtype" placeholder="请选择职位分类">
              <el-option v-for="item in jobtypeList" :key="item.value" :label="item.label" :value="item.value"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="30">
        <el-col :span="12">
          <el-form-item label="工作经验" prop="experience">
            <el-input clearable size="small" v-model="form.experience" placeholder="请输入工作经验"></el-input>
            <span style="margin-left: 10px">年</span>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="学历要求" prop="education">
            <el-input clearable size="small" v-model="form.education" placeholder="请输入学历要求"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="30">
        <el-col :span="12">
          <el-form-item label="负责人" prop="principal">
            <el-input clearable size="small" v-model="form.principal" placeholder="请输入负责人"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="联系电话" prop="phone">
            <el-input clearable size="small" v-model="form.phone" placeholder="请输入联系电话"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="30">
        <el-col :span="12">
          <el-form-item label="最高薪资" prop="maxsalary">
            <el-input clearable size="small" v-model="form.maxsalary" placeholder="请输入最高薪资"></el-input>
            <span style="margin-left: 10px">元</span>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="最低薪资" prop="minsalary">
            <el-input clearable size="small" v-model="form.minsalary" placeholder="请输入最低薪资"></el-input>
            <span style="margin-left: 10px">元</span>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="30">
        <el-col :span="12">
          <el-form-item label="工作地点" prop="workplace">
            <el-input clearable size="small" v-model="form.workplace" placeholder="请输入工作地点"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="30">
        <el-col :span="12">
          <el-form-item label="工作内容" prop="description">
            <el-input
              type="textarea"
              resize="none"
              :autosize="{ minRows: 3 }"
              clearable
              size="small"
              v-model="form.description"
              placeholder="请输入工作内容"
            ></el-input>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
    <div class="footer">
      <el-button size="big" @click="resetForm('form')">重置</el-button>
      <el-button type="primary" size="big" @click="submitForm('form')">{{ isSaveBtn ? '新增' : '修改' }}</el-button>
    </div>
  </el-dialog>
</template>
<script>
import { BUSINESS_RELATIVE, ORG_STATUS } from '@/config/dict.js';
import { isMobile } from '@/utils/validate';
import { addRecruitmentDetail, getRecruitmentDetail } from '@/api/recruitment';

export default {
  props: {
    recruitmentId: {
      default: null,
    },
  },
  watch: {
    dialogVisible(val) {
      if (val) {
        if (this.isSaveBtn == false) {
          this.initRecruitmentDetail();
        }
        // this.initSponsorArrangeList();
        // this.initRecruitment();
      }
    },
  },
  data() {
    const validateNum = (rule, value, callback) => {
      if (!value) {
        callback();
      } else {
        if (isNaN(value)) {
          callback(new Error('请输入数字'));
        } else {
          callback();
        }
      }
    };
    const validateCellMobile = (rule, value, callback) => {
      if (!value) {
        callback();
      } else {
        if (!isMobile(value)) {
          callback(new Error('请正确输入手机号'));
        } else {
          callback();
        }
      }
    };
    return {
      dialogVisible: false,
      dialogTitle: '',
      isSaveBtn: null,
      jobtypeList: [
        {
          label: '长期',
          value: '1',
        },
        {
          label: '短期',
          value: '2',
        },
      ],
      form: {
        career: '',
        jobtype: '',
        experience: '',
        education: '',
        principal: '',
        phone: '',
        minsalary: '',
        maxsalary: '',
        workplace: '',
        description: '',
      },
      rules: {
        career: [{ required: true, message: '请输入职位名称', trigger: 'blur' }],
        jobtype: [{ required: true, message: '请输入职位名称', trigger: 'blur' }],
        experience: [
          { validator: validateNum, trigger: 'blur' },
          { required: true, message: '请输入工作经验', trigger: 'blur' },
        ],
        education: [{ required: true, message: '请选择学历要求', trigger: 'blur' }],
        principal: [{ required: true, message: '请输入负责人', trigger: 'blur' }],
        phone: [
          { validator: validateCellMobile, trigger: 'blur' },
          { required: true, trigger: 'blur', message: '请输入手机号码' },
        ],
        minsalary: [
          { validator: validateNum, trigger: 'blur' },
          { required: true, trigger: 'blur', message: '请输入最低薪资' },
        ],
        maxsalary: [
          { validator: validateNum, trigger: 'blur' },
          { required: true, trigger: 'blur', message: '请输入最高薪资' },
        ],
        workplace: [{ required: true, message: '请输入工作地点', trigger: 'blur' }],
        description: [{ required: true, message: '请输入工作内容', trigger: 'blur' }],
      },
    };
  },
  mounted() {},
  methods: {
    // 获取传过来的数据
    getTitle(title) {
      this.dialogTitle = title;
    },
    handleClose() {
      this.$refs['form'].resetFields();
      this.dialogVisible = false;
    },
    // 初始化表单
    initRecruitmentDetail() {
      let obj = {
        id: this.recruitmentId,
      };
      getRecruitmentDetail(obj).then((res) => {
        this.form = res.data;
      });
    },
    // 新增招聘信息
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          addRecruitmentDetail(this.form).then((res) => {
            this.$emit('reload')
            this.handleClose();
          });
        } else {
          return false;
        }
      });
    },
    // 重置表单
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
  },
};
</script>

<style scoped>
::v-deep(.el-input) {
  width: 250px;
}
.footer {
  margin: 20px 0;
  text-align: center;
}
</style>
