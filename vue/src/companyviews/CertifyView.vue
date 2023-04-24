<!--<template>-->
<!--  <div class="container">-->
<!--    <h2>{{pageTitle}}</h2>-->
<!--    <el-form :model="form" :rules="rules" ref="form" label-width="120px" class="form">-->
<!--      <el-form-item label="企业名称：" prop="name">-->
<!--        <el-input v-model="form.name"></el-input>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="营业执照号码：" prop="licenseNumber">-->
<!--        <el-input v-model="form.licenseNumber"></el-input>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="法定代表人：" prop="legalRepresentative">-->
<!--        <el-input v-model="form.legalRepresentative"></el-input>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="联系电话：" prop="phone">-->
<!--        <el-input v-model="form.phone"></el-input>-->
<!--      </el-form-item>-->
<!--      <el-form-item>-->
<!--        <el-button type="primary" @click="submitForm('form')">提交认证</el-button>-->
<!--      </el-form-item>-->
<!--    </el-form>-->
<!--    <div v-if="authenticationDetails">-->
<!--      <h3>已认证信息：</h3>-->
<!--      <p><strong>企业名称：</strong>{{authenticationDetails.name}}</p>-->
<!--      <p><strong>营业执照号码：</strong>{{authenticationDetails.licenseNumber}}</p>-->
<!--      <p><strong>法定代表人：</strong>{{authenticationDetails.legalRepresentative}}</p>-->
<!--      <p><strong>联系电话：</strong>{{authenticationDetails.phone}}</p>-->
<!--    </div>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--  name: "AuthenticationPage",-->
<!--  data() {-->
<!--    return {-->
<!--      pageTitle: "企业认证申请",-->
<!--      form: {-->
<!--        name: "",-->
<!--        licenseNumber: "",-->
<!--        legalRepresentative: "",-->
<!--        phone: "",-->
<!--      },-->
<!--      rules: {-->
<!--        name: [-->
<!--          {-->
<!--            required: true,-->
<!--            message: "请输入企业名称",-->
<!--            trigger: "blur",-->
<!--          },-->
<!--        ],-->
<!--        licenseNumber: [-->
<!--          {-->
<!--            required: true,-->
<!--            message: "请输入营业执照号码",-->
<!--            trigger: "blur",-->
<!--          },-->
<!--        ],-->
<!--        legalRepresentative: [-->
<!--          {-->
<!--            required: true,-->
<!--            message: "请输入法定代表人",-->
<!--            trigger: "blur",-->
<!--          },-->
<!--        ],-->
<!--        phone: [-->
<!--          {-->
<!--            required: true,-->
<!--            message: "请输入联系电话",-->
<!--            trigger: "blur",-->
<!--          },-->
<!--        ],-->
<!--      },-->
<!--      authenticationDetails: null,-->
<!--    };-->
<!--  },-->
<!--  methods: {-->
<!--    submitForm(formName) {-->
<!--      this.$refs[formName].validate((valid) => {-->
<!--        if (valid) {-->
<!--          // 提交认证信息到后台-->
<!--          // 在这里你需要使用axios或者其他的HTTP库来向服务器发送请求-->
<!--          // 请求成功后将authenticationDetails设置为服务器返回的结果-->
<!--          const fakeResponse = {-->
<!--            name: this.form.name,-->
<!--            licenseNumber: this.form.licenseNumber,-->
<!--            legalRepresentative: this.form.legalRepresentative,-->
<!--            phone: this.form.phone,-->
<!--          };-->
<!--          this.authenticationDetails = fakeResponse;-->
<!--        } else {-->
<!--          console.log("验证失败");-->
<!--          return false;-->
<!--        }-->
<!--      });-->
<!--    },-->
<!--  },-->
<!--};-->
<!--</script>-->
<template>
  <div class="container">
    <h2>{{pageTitle}}</h2>
    <el-form :model="form" :rules="rules" ref="form" label-width="120px" class="form">
      <el-form-item label="企业名称：" prop="name">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item label="营业执照号码：" prop="licenseNumber">
        <el-input v-model="form.licenseNumber"></el-input>
      </el-form-item>
      <el-form-item label="法定代表人：" prop="legalRepresentative">
        <el-input v-model="form.legalRepresentative"></el-input>
      </el-form-item>
      <el-form-item label="联系电话：" prop="phone">
        <el-input v-model="form.phone"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('form')">提交认证</el-button>
      </el-form-item>
    </el-form>
    <div v-if="authenticationDetails" class="authentication-details">
      <h3>已认证信息：</h3>
      <p><strong>企业名称：</strong>{{authenticationDetails.name}}</p>
      <p><strong>营业执照号码：</strong>{{authenticationDetails.licenseNumber}}</p>
      <p><strong>法定代表人：</strong>{{authenticationDetails.legalRepresentative}}</p>
      <p><strong>联系电话：</strong>{{authenticationDetails.phone}}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "AuthenticationPage",
  data() {
    return {
      pageTitle: "企业认证申请",
      form: {
        name: "",
        licenseNumber: "",
        legalRepresentative: "",
        phone: "",
      },
      rules: {
        name: [
          {
            required: true,
            message: "请输入企业名称",
            trigger: "blur",
          },
        ],
        licenseNumber: [
          {
            required: true,
            message: "请输入营业执照号码",
            trigger: "blur",
          },
        ],
        legalRepresentative: [
          {
            required: true,
            message: "请输入法定代表人",
            trigger: "blur",
          },
        ],
        phone: [
          {
            required: true,
            message: "请输入联系电话",
            trigger: "blur",
          },
        ],
      },
      authenticationDetails: null,
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          // 提交认证信息到后台
          // 在这里你需要使用axios或者其他的HTTP库来向服务器发送请求
          // 请求成功后将authenticationDetails设置为服务器返回的结果
          const fakeResponse = {
            name: this.form.name,
            licenseNumber: this.form.licenseNumber,
            legalRepresentative: this.form.legalRepresentative,
            phone: this.form.phone,
          };
          this.authenticationDetails = fakeResponse;
        } else {
          console.log("验证失败");
          return false;
        }
      });
    },
  },
};
</script>

<style scoped>
.container {
  max-width: 800px;
  margin: auto;
  padding: 20px;
}

h2 {
  font-size: 28px;
  text-align: center;
  margin-bottom: 20px;
}

.form {
  border: 1px solid #ddd;
  padding: 20px;
  background-color: #f9f9f9;
}

.authentication-details {
  margin-top: 30px;
  padding: 20px;
  border: 1px solid #ddd;
  background-color: #f5f5f5;
}
</style>

