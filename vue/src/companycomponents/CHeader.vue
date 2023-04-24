<template>
  <!-- 导航栏 -->
  <el-menu style="background-color: #409EFF"
           text-color="#fff"
           active-text-color="#ffd04b"
           mode="horizontal"
           router="true"
           @select="handleTabClick"
           :default-active="activeIndex"
           class="el-menu-demo">
    <el-menu-item index="/chomefirst" >首页</el-menu-item>
    <el-menu-item index="/recruitinfo">招聘信息</el-menu-item>
    <el-menu-item index="/resumesearch">简历库</el-menu-item>
    <el-menu-item index="/myrecruitment">我的招聘</el-menu-item>
    <el-menu-item index="/personnelmarket">人才市场</el-menu-item>
<!--    <el-menu-item index="/cstatistics">统计报告</el-menu-item>-->
<!--    <el-menu-item @click="Schange">切换学生端</el-menu-item>-->
<!--    <el-menu-item @click="Cmanagechange">企业端后台</el-menu-item>-->
    <el-submenu index="myrecruitment">

      <template slot="title">我的企业</template>
      <el-menu-item index="companyinfo">企业简介</el-menu-item>
      <el-menu-item index="certifyview">企业认证</el-menu-item>
      <el-menu-item index="certifyview">工作反馈</el-menu-item>
    </el-submenu>
    <!--    <el-menu-item index="6" class="login-btn">登录 / 注册</el-menu-item>-->
    <el-dropdown>
      <span>账户</span><i class="el-icon-arrow-down" style="margin-left: 5px"></i>
      <el-dropdown-menu slot="dropdown" style="width: 100px ">
        <el-dropdown-item>账号信息</el-dropdown-item>
        <el-dropdown-item>修改密码</el-dropdown-item>
        <el-dropdown-item>退出</el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
  </el-menu>
</template>

<script>
export default {
  name: "CHeader",
  data() {
    return {
      activeIndex: '1',
    };
  },
  methods:{
    // Schange(){
    //   this.$router.push({path:'/'}),
    //       console.log("企业端跳转学生端")
    // },
    // Cmanagechange(){
    //   this.$router.push({path:'/cmanage'}),
    //       console.log("跳转企业端后台")
    // },
    handleTabClick(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>

<style>
.el-menu {
  display: flex;
  justify-content: center;
}
/*.dropdown{*/
/*  width: 120px;*/
/*}*/
.footer {
  position: fixed;
  bottom: 0;
  width: 100%;
  text-align: center;
}
/*.login-btn {*/
/*  float: right;*/
/*}*/
.el-menu-item:hover {
  color: #2a73c4;
  background-color: #296fbd !important;
}
.el-menu-item.is-active {
  background-color: #296fbd !important;
  color: #ffffff !important;
}
.el-menu--horizontal .el-menu-item.is-active {
  background-color: #409EFF !important;
  color: #ffffff !important;
}
</style>
