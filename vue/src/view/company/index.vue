<template>
  <div class="content">
    <el-form ref="form" disabled :model="form" label-width="150px">
      <el-row :gutter="30">
        <el-col :span="12">
          <el-form-item label="企业名称" prop="company_name">
            <el-input clearable size="small" v-model="form.company_name" placeholder="请输入企业名称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="统一社会信用代码" prop="uscc">
            <el-input clearable size="small" v-model="form.uscc" placeholder="请输入统一社会信用代码"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="30">
        <el-col :span="12">
          <el-form-item label="企业类型" prop="company_type">
            <el-select size="small" v-model="form.company_type" placeholder="请选择企业类型">
              <el-option v-for="item in orgTypeList" :key="item.value" :label="item.label" :value="item.value"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="所属行业" prop="industry">
            <el-cascader
              size="small"
              v-model="form.industry"
              :options="businessRelativeList"
              :props="defaultProps2"
              placeholder="所属行业"
            ></el-cascader>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="30">
        <el-col :span="12">
          <el-form-item label="企业地址" prop="address">
            <el-input clearable size="small" v-model="form.address" placeholder="请输入企业地址"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="企业邮箱" prop="company_email">
            <el-input clearable size="small" v-model="form.company_email" placeholder="请输入企业邮箱"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="30">
        <el-col :span="12">
          <el-form-item label="注册资金" prop="capital">
            <el-input clearable size="small" v-model="form.capital" placeholder="请输入注册资金" />
            <span class="suffix">万元</span>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="实缴资本" prop="paid_in">
            <el-input clearable size="small" v-model="form.paid_in" placeholder="请输入实缴资金" />
            <span class="suffix">万元</span>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="30">
        <el-col :span="12">
          <el-form-item label="法定代表人" prop="legalperson">
            <el-input clearable size="small" v-model="form.legalperson" placeholder="请输入法定代表人"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="手机号码" prop="company_phone">
            <el-input clearable size="small" v-model="form.company_phone" placeholder="请输入手机号码"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="30">
        <el-col :span="12">
          <el-form-item label="成立日期" prop="establish_date">
            <el-date-picker
              clearable
              style="width: 250px"
              size="small"
              value-format="YYYY-MM-DD"
              v-model="form.establish_date"
              type="date"
              placeholder="选择日期"
            ></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="营业期限" prop="businessDeadlineStartDate">
            <div class="flex">
              <el-date-picker clearable v-model="form.businessDeadlineStartDate" size="small" type="date" placeholder="开始日期"></el-date-picker>
              <span style="margin: 0 10px">至</span>
              <el-date-picker clearable v-model="form.businessDeadlineEndDate" size="small" type="date" placeholder="无固定期限"></el-date-picker>
            </div>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="30">
        <el-col :span="12">
          <el-form-item label="登记机关" prop="authority">
            <el-input clearable size="small" v-model="form.authority" placeholder="请输入登记机关"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="人员规模" prop="staff_size">
            <el-input clearable size="small" v-model="form.staff_size" placeholder="请输入人员规模"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="30">
        <el-col :span="12">
          <el-form-item label="工商注册号" prop="number">
            <el-input clearable size="small" v-model="form.number" placeholder="请输入工商注册号"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="组织机构代码" prop="code">
            <el-input clearable size="small" v-model="form.code" placeholder="请输入组织机构代码"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="30">
        <el-col :span="12">
          <el-form-item label="核准日期" prop="approval_date">
            <el-date-picker
              clearable
              style="width: 250px"
              size="small"
              value-format="YYYY-MM-DD"
              v-model="form.approval_date"
              type="date"
              placeholder="选择日期"
            ></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="企业logo" prop="logo">
            <el-upload class="upload-demo" action="https://jsonplaceholder.typicode.com/posts/" :limit="1" :file-list="form.logo">
              <el-button size="small" type="primary">点击上传</el-button>
            </el-upload>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="30">
        <el-col :span="12">
          <el-form-item label="营业执照" prop="license">
            <el-upload class="upload-demo" action="https://jsonplaceholder.typicode.com/posts/" :limit="1" :file-list="form.license">
              <el-button size="small" type="primary">点击上传</el-button>
            </el-upload>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
  </div>
</template>

<script>
import { BUSINESS_RELATIVE, ORG_STATUS } from '@/config/dict.js';
import { isMobile, isUnifiedSocialCreditCode } from '@/utils/validate';

export default {
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
    const validateSocialCreditCode = (rule, value, callback) => {
      if (!value) {
        callback(new Error('请输入统一社会信用代码'));
      } else {
        if (!isUnifiedSocialCreditCode(value)) {
          callback(new Error('请正确输入统一社会信用代码'));
        } else {
          callback();
        }
      }
    };
    return {
      form: {
        company_name: '',
        uscc: '',
        company_type: '',
        industry: '',
        address: '',
        company_email: '',
        capital: '',
        paid_in: '',
        legalperson: '',
        company_phone: '',
        establish_date: '',
        businessDeadlineStartDate: '',
        businessDeadlineEndDate: '',
        authority: '',
        staff_size: '',
        number: '',
        code: '',
        approval_date: '',
        logo: [],
        license: [],
      },
      // 企业类型
      orgTypeList: ORG_STATUS,
      // 行业
      businessRelativeList: BUSINESS_RELATIVE,
      defaultProps2: {
        children: 'childs',
        label: 'name',
      },
    };
  },
  methods: {},
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
}
::v-deep(.el-form) {
  padding: 20px 16px;
}
.suffix {
  margin-left: 10px;
}

::v-deep(.el-input) {
  width: 250px;
}
.flex {
  display: flex;
}
.footer {
  margin: 20px 0;
  text-align: center;
}
</style>
