<template>
  <div class="content">
    <div class="login-content">
      <div style="text-align: center; margin-bottom: 20px">
        <h2 style="color: #0d85b5">智慧招聘</h2>
      </div>
      <el-tabs v-model="loginTab" type="card">
        <el-tab-pane label="密码登录" name="password">
          <el-form ref="form" :model="form" :rules="rules" auto-complete="on" label-position="left">
            <el-form-item prop="username">
              <el-input
                ref="username"
                size="small"
                v-model="form.username"
                placeholder="请输入用户名"
                name="username"
                type="text"
                tabindex="1"
                auto-complete="on"
              />
            </el-form-item>

            <el-form-item prop="password">
              <el-input
                ref="password"
                v-model="form.password"
                show-password
                placeholder="请输入密码"
                name="password"
                tabindex="2"
                auto-complete="on"
                size="small"
              />
            </el-form-item>

            <div style="text-align: center">
              <el-button
                :loading="loading"
                type="primary"
                style="width: 80%; margin-top: 15px; background: linear-gradient(296deg, rgb(122, 239, 223) 0%, rgb(3, 138, 241) 100%); border: 0px"
                @click="handlePasswordLogin"
                size="small"
              >
                登 录
              </el-button>
            </div>
          </el-form>
        </el-tab-pane>
        <el-tab-pane label="企业注册" name="register">
          <el-form ref="registerForm" :model="registerForm" :rules="registerRules" auto-complete="on" label-position="left">
            <el-form-item prop="companyName">
              <el-input
                ref="companyName"
                size="small"
                v-model="registerForm.companyName"
                placeholder="请输入企业名称"
                name="companyName"
                type="text"
                tabindex="1"
                auto-complete="on"
              />
            </el-form-item>
            <el-form-item prop="username">
              <el-input
                ref="username"
                size="small"
                v-model="registerForm.username"
                placeholder="请输入用户名"
                name="username"
                type="text"
                tabindex="1"
                auto-complete="on"
              />
            </el-form-item>

            <el-form-item prop="password">
              <el-input
                ref="password"
                v-model="registerForm.password"
                show-password
                placeholder="请输入密码"
                name="password"
                tabindex="2"
                auto-complete="on"
                size="small"
              />
            </el-form-item>

            <el-form-item prop="confirmPwd">
              <el-input
                ref="confirmPwd"
                v-model="registerForm.confirmPwd"
                show-password
                placeholder="请再次输入密码"
                name="confirmPwd"
                tabindex="2"
                auto-complete="on"
                size="small"
              />
            </el-form-item>

            <div style="text-align: center">
              <el-button
                :loading="loading"
                type="primary"
                style="width: 80%; margin-top: 15px; background: linear-gradient(296deg, rgb(122, 239, 223) 0%, rgb(3, 138, 241) 100%); border: 0px"
                @click="handleRegister"
                size="small"
              >
                登 录
              </el-button>
            </div>
          </el-form>
        </el-tab-pane>
      </el-tabs>
    </div>
  </div>
</template>

<script>
import { validUsername } from '@/utils/validate';
import { login, register } from '@/api/login';

export default {
  data() {
    const validateUsername = (rule, value, callback) => {
      if (!validUsername(value)) {
        callback(new Error('请输入用户名'));
      } else {
        callback();
      }
    };
    const validatePassword = (rule, value, callback) => {
      if (value && value.length > 0) {
        callback();
      } else {
        callback(new Error('请输入密码'));
      }
    };
    var validateConfirmPwd = (rule, value, callback) => {
      if (!value) {
        callback(new Error('请再次输入密码'));
      } else if (this.registerForm.password !== value) {
        callback(new Error('确认密码与密码不一致'));
      } else {
        callback();
      }
    };
    return {
      loginTab: 'password',
      form: {
        username: '',
        password: '',
      },
      rules: {
        username: [{ required: true, trigger: 'blur', validator: validateUsername }],
        password: [{ required: true, trigger: 'blur', validator: validatePassword }],
      },
      registerForm: {
        companyName: '',
        username: '',
        password: '',
        confirmPwd: '',
      },
      registerRules: {
        companyName: [{ required: true, trigger: 'blur', message: '请输入企业名称' }],
        username: [{ required: true, trigger: 'blur', validator: validateUsername }],
        password: [{ required: true, validator: validatePassword, trigger: 'blur' }],
        confirmPwd: [{ required: true, validator: validateConfirmPwd, trigger: 'blur' }],
      },
      loading: false,
    };
  },
  methods: {
    // 登录
    handlePasswordLogin() {
      let data = {
        username: this.form.username,
        password: this.form.password,
      };
      login(data).then((res) => {
        if ((res.code = 200)) {
          localStorage.setItem('tokenName', res.data.tokenName);
          localStorage.setItem('tokenValue', res.data.tokenValue);
          this.$router.push({
            path: '/chomefirst',
          });
        }
      });
    },
    // 注册
    handleRegister() {
      let data = {
        companyName: this.registerForm.companyName,
        userName: this.registerForm.username,
        password: this.registerForm.password,
        password2: this.registerForm.confirmPwd,
      };
      register(data).then((res) => {
        if ((res.code = 200)) {
          this.$message({
            message: '注册成功',
            type: 'success',
          });
          this.loginTab = 'password';
          this.$refs['registerForm'].resetFields();
        }
      });
    },
  },
};
</script>

<style scoped>
.content {
  width: 100%;
  height: 100vh;
  overflow: hidden;
  background-image: url('@/assets/login.jpg');
  background-repeat: no-repeat;
  background-size: cover;
}
.login-content {
  width: 35%;
  height: 60vh;
  background-color: #e7e8eb;
  padding: 50px;
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  margin: auto;
}
::v-deep(.el-form) {
  padding: 0 150px;
}
::v-deep(.el-tabs__nav-scroll) {
  display: flex;
  justify-content: center;
}
:deep(.is-active) {
  border-bottom-color: var(--el-color-primary) !important;
}
</style>
