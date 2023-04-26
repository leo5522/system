<template>
  <div class="content">
    <!-- :rules="rules" -->
    <el-form ref="form" :model="form" label-width="150px" :rules="rules" :disabled="disabled">
      <el-row :gutter="30">
        <el-col :span="12">
          <el-form-item label="企业名称" prop="companyName">
            <el-input clearable size="small" v-model="form.companyName" placeholder="请输入企业名称"></el-input>
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
          <el-form-item label="企业类型" prop="companyType">
            <el-select size="small" v-model="form.companyType" placeholder="请选择企业类型">
              <el-option v-for="item in orgTypeList" :key="item.value" :label="item.label" :value="item.value"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="所属行业" prop="industryShow">
            <el-cascader
              size="small"
              v-model="form.industryShow"
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
          <el-form-item label="企业邮箱" prop="companyEmail">
            <el-input clearable size="small" v-model="form.companyEmail" placeholder="请输入企业邮箱"></el-input>
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
          <el-form-item label="实缴资本" prop="paidIn">
            <el-input clearable size="small" v-model="form.paidIn" placeholder="请输入实缴资金" />
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
          <el-form-item label="手机号码" prop="companyPhone">
            <el-input clearable size="small" v-model="form.companyPhone" placeholder="请输入手机号码"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="30">
        <el-col :span="12">
          <el-form-item label="成立日期" prop="establishDate">
            <el-date-picker
              clearable
              style="width: 250px"
              size="small"
              value-format="YYYY-MM-DD"
              v-model="form.establishDate"
              type="date"
              placeholder="选择日期"
            ></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="营业期限" prop="bdsd">
            <div class="flex">
              <el-date-picker
                clearable
                v-model="form.bdsd"
                size="small"
                value-format="YYYY-MM-DD"
                type="date"
                placeholder="开始日期"
              ></el-date-picker>
              <span style="margin: 0 10px">至</span>
              <el-date-picker
                clearable
                v-model="form.bded"
                size="small"
                value-format="YYYY-MM-DD"
                type="date"
                placeholder="无固定期限"
              ></el-date-picker>
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
          <el-form-item label="人员规模" prop="staffSize">
            <el-input clearable size="small" v-model="form.staffSize" placeholder="请输入人员规模"></el-input>
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
          <el-form-item label="核准日期" prop="approvalDate">
            <el-date-picker
              clearable
              style="width: 250px"
              size="small"
              value-format="YYYY-MM-DD"
              v-model="form.approvalDate"
              type="date"
              placeholder="选择日期"
            ></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="企业logo" prop="logoShow">
            <el-upload class="upload-demo" action="http://localhost:9090/images/upload" :limit="1" :file-list="form.logoShow" :on-success="upload1" :on-preview="openImg1">
              <el-button size="small" type="primary">点击上传</el-button>
            </el-upload>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="30">
        <el-col :span="12">
          <el-form-item label="营业执照" prop="licenseShow">
            <el-upload class="upload-demo" action="http://localhost:9090/images/upload" :limit="1" :file-list="form.licenseShow" :on-success="upload2" :on-preview="openImg2">
              <el-button size="small" type="primary">点击上传</el-button>
            </el-upload>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
    <div class="footer">
      <el-button v-show="!disabled" size="big" @click="resetForm('form')">重置</el-button>
      <el-button v-show="!disabled" type="primary" size="big" @click="submitForm('form')">提交认证</el-button>
      <el-button v-show="disabled" type="primary" size="big" @click="disabled = false">重新认证</el-button>
    </div>
  </div>
</template>

<script>
import { BUSINESS_RELATIVE, ORG_STATUS } from '@/config/dict.js';
import { isMobile, isUnifiedSocialCreditCode } from '@/utils/validate';
import { getCompanyDetail, saveCompanyDetail } from '@/api/company';

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
      // 表单是否禁用，根据状态判断
      disabled: false,
      form: {
        companyName: '',
        uscc: '',
        companyType: '',
        industryShow: '',
        address: '',
        companyEmail: '',
        capital: '',
        paidIn: '',
        legalperson: '',
        companyPhone: '',
        establishDate: '',
        bdsd: '',
        bded: '',
        authority: '',
        staffSize: '',
        number: '',
        code: '',
        approvalDate: '',
        logo: '',
        license: '',
        logoShow: [],
        licenseShow: [],
      },
      rules: {
        companyName: [{ required: true, message: '请输入企业名称', trigger: 'blur' }],
        uscc: [{ validator: validateSocialCreditCode, required: true, trigger: 'blur' }],
        companyType: [{ required: true, message: '请选择企业类型', trigger: 'change' }],
        industryShow: [{ required: true, message: '请选择所属行业', trigger: 'change' }],
        address: [{ required: true, message: '请输入企业地址', trigger: 'blur' }],
        companyEmail: [{ required: true, message: '请输入企业邮箱', trigger: 'blur' }],
        capital: [
          { validator: validateNum, trigger: 'blur' },
          { required: true, trigger: 'blur', message: '请输入实缴资本' },
        ],
        paidIn: [
          { validator: validateNum, trigger: 'blur' },
          { required: true, trigger: 'blur', message: '请输入实缴资本' },
        ],
        legalperson: [{ required: true, message: '请输入法定代表人', trigger: 'blur' }],
        companyPhone: [
          { validator: validateCellMobile, trigger: 'blur' },
          { required: true, trigger: 'blur', message: '请输入手机号码' },
        ],
        establishDate: [{ required: true, message: '请选择成立日期', trigger: 'blur' }],
        bdsd: [{ required: true, message: '请选择营业开始日期', trigger: 'blur' }],
        authority: [{ required: true, message: '请输入登记机关', trigger: 'blur' }],
        staffSize: [{ required: true, message: '请输入人员规模', trigger: 'blur' }],
        number: [{ required: true, message: '请输入工商注册号', trigger: 'blur' }],
        code: [{ required: true, message: '请输入组织机构代码', trigger: 'blur' }],
        approvalDate: [{ required: true, message: '请选择核准日期', trigger: 'blur' }],
        logoShow: [{ required: true, message: '请上传企业logo', trigger: 'change' }],
        licenseShow: [{ required: true, message: '请上传营业执照', trigger: 'change' }],
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
  mounted() {
    this.initCompany();
  },
  methods: {
    // 初始化企业信息
    initCompany() {
      getCompanyDetail().then((res) => {
        if (res.code === 200 || res.code === '200') {
          if (res.data && Object.keys(res.data).length > 0) {
            if (res.data == 1 || res.data == 3) {
              this.disabled = false;
            } else {
              this.form = res.data;
              this.form['industryShow'] = '';
              this.form['logoShow'] = [
                {
                  url: 'http://localhost:9090/upload/' + this.form.logo,
                  name: this.form.logo,
                },
              ];
              this.form['licenseShow'] = [
                {
                  url: 'http://localhost:9090/upload/' + this.form.license,
                  name: this.form.license,
                },
              ];
              this.disabled = true;
              this.$message({
                message: '企业已认证完成，可点击重新认证按钮，进行重新认证',
                type: 'warning',
              });
            }
          }
        }
      });
    },
    // 图片上传
    upload1(file) {
      let obj = {
        name: file.data.filename,
        url: file.data.url,
      };
      this.form.logoShow.push(obj);
      this.form.logo = this.form.logoShow[0].name;
    },
    upload2(file) {
      let obj = {
        name: file.data.filename,
        url: file.data.url,
      };
      this.form.licenseShow.push(obj);
      this.form.license = this.form.licenseShow[0].name;
    },
    openImg1(file){
      console.log(window.open(file.url));
    },
    openImg2(file){
      console.log(window.open(file.url));
    },
    // 提交企业认证
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.form.industry = this.form.industryShow[1];
          saveCompanyDetail(this.form).then((res) => {
            if (res.code == 200 || res.code == '200') {
              this.$message({
                message: '认证成功，即将为您刷新页面',
                type: 'success',
              });
              setTimeout(() => {
                location.reload();
              }, 1000);
            }
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
