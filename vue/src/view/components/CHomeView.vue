<template>
  <div>
    <!-- 导航栏 -->
    <Header />

    <el-main>
      <router-view />
    </el-main>

    <el-footer>
      <Copyright />
      <!-- 版权信息 -->
    </el-footer>
  </div>
</template>

<script>
import Header from './CHeader.vue';
import Copyright from '@/companycomponents/CCopyright.vue';
export default {
  name: 'CHomeView',
  data() {
    return {
      activeTab: '首页',
    };
  },
  components: {
    Header,
    Copyright,
  },
  methods: {
    handleTabClick(tab) {
      this.activeTab = tab.index;
    },
  },
};
</script>

<style>
/* 样式代码 */
</style>
