<template>
  <!-- 导航栏 -->
  <div class="navbar">
    <el-menu background-color="#409eff" text-color="#fff" active-text-color="#ffd04b" mode="horizontal" router="true" class="el-menu">
      <el-menu-item index="/chomefirst">首页</el-menu-item>
      <el-menu-item index="/recruitment-index">招聘信息</el-menu-item>
      <el-menu-item index="/resumesearch">简历库</el-menu-item>
      <!-- <el-menu-item index="/myrecruitment">我的招聘</el-menu-item> -->
      <el-menu-item index="/personnelmarket">人才市场</el-menu-item>
      <el-submenu index="myrecruitment">
        <template slot="title">我的企业</template>
        <el-menu-item index="company-index">企业信息</el-menu-item>
        <el-menu-item index="company-edit">修改企业信息</el-menu-item>
        <el-menu-item index="company-add">企业认证</el-menu-item>
      </el-submenu>
      <div class="user">
        <el-dropdown>
          <span>账户</span>
          <i class="el-icon-arrow-down"></i>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>账号信息</el-dropdown-item>
            <el-dropdown-item>修改密码</el-dropdown-item>
            <el-dropdown-item>退出</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </el-menu>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  methods: {},
};
</script>

<style scoped>
.el-menu {
  padding: 0 50px;
}
.user {
  position: absolute;
  right: 50px;
  top: 20px;
  cursor: pointer;
}
/deep/ .el-dropdown {
  color: white;
}
.el-icon-arrow-down {
  margin-left: 5px;
}
</style>
