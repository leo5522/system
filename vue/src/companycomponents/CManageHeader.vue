<!--&lt;!&ndash;<template>&ndash;&gt;-->

<!--&lt;!&ndash;</template>&ndash;&gt;-->

<!--&lt;!&ndash;<script>&ndash;&gt;-->
<!--&lt;!&ndash;export default {&ndash;&gt;-->
<!--&lt;!&ndash;  name: "CManageHeader"&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->
<!--&lt;!&ndash;</script>&ndash;&gt;-->

<!--&lt;!&ndash;<style scoped>&ndash;&gt;-->

<!--&lt;!&ndash;</style>&ndash;&gt;-->

<!--<template>-->
<!--  <div style="line-height: 60px;display: flex">-->
<!--    <div style="flex: 1;">-->
<!--      <span :class="collapseBtnClass" style="cursor: pointer; font-size: 18px" @click="collapse"></span>-->

<!--      <el-breadcrumb separator="/" style="display: inline-block; margin-left: 10px">-->
<!--        <el-breadcrumb-item :to="'/'">首页</el-breadcrumb-item>-->
<!--        <el-breadcrumb-item>{{ currentPathName }}</el-breadcrumb-item>-->
<!--      </el-breadcrumb>-->
<!--    </div>-->


<!--    &lt;!&ndash;    <el-dropdown style="width: 100px; cursor: pointer">&ndash;&gt;-->
<!--    &lt;!&ndash;      <div style="display: inline-block">&ndash;&gt;-->
<!--    &lt;!&ndash;        <img :src="user.avatarurl" alt="" referrerpolicy="no-referrer"&ndash;&gt;-->
<!--    &lt;!&ndash;             style="width: 30px; border-radius: 50%; position: relative; top: 10px; right: 5px">&ndash;&gt;-->
<!--    &lt;!&ndash;        <span>{{ user.cname }}</span><i class="el-icon-arrow-down" style="margin-left: 5px"></i>&ndash;&gt;-->
<!--    &lt;!&ndash;      </div>&ndash;&gt;-->
<!--    &lt;!&ndash;      <el-dropdown-menu slot="dropdown" style="width: 100px; text-align: center">&ndash;&gt;-->
<!--    &lt;!&ndash;        <el-dropdown-item style="font-size: 14px; padding: 5px 0">&ndash;&gt;-->
<!--    &lt;!&ndash;          <router-link to="/person">企业信息</router-link>&ndash;&gt;-->
<!--    &lt;!&ndash;        </el-dropdown-item>&ndash;&gt;-->
<!--    &lt;!&ndash;        <el-dropdown-item style="font-size: 14px; padding: 5px 0">&ndash;&gt;-->
<!--    &lt;!&ndash;          <span style="text-decoration: none" @click="logout">退出</span>&ndash;&gt;-->
<!--    &lt;!&ndash;        </el-dropdown-item>&ndash;&gt;-->
<!--    &lt;!&ndash;      </el-dropdown-menu>&ndash;&gt;-->
<!--    &lt;!&ndash;    </el-dropdown>&ndash;&gt;-->

<!--    <el-dropdown style="width: 100px; cursor: pointer">-->
<!--      <div style="display: inline-block">-->
<!--        &lt;!&ndash;        <img :src="user.avatarurl" alt=""&ndash;&gt;-->
<!--        &lt;!&ndash;             style="width: 30px; border-radius: 50%; position: relative; top: 10px; right: 5px">&ndash;&gt;-->
<!--        &lt;!&ndash;        <span>{{ user.cname }}</span><i class="el-icon-arrow-down" style="margin-left: 5px"></i>&ndash;&gt;-->
<!--        <span>企业用户1</span><i class="el-icon-arrow-down" style="margin-left: 5px"></i>-->
<!--      </div>-->
<!--      <el-dropdown-menu slot="dropdown" style="width: 100px; text-align: center">-->
<!--        <el-dropdown-item style="font-size: 14px; padding: 5px 0">-->
<!--          <router-link to="/company" style="text-decoration: none">企业信息</router-link>-->
<!--        </el-dropdown-item>-->
<!--        <el-dropdown-item style="font-size: 14px; padding: 5px 0">-->
<!--          <router-link to="/companyhome" style="text-decoration: none">前台</router-link>-->
<!--        </el-dropdown-item>-->
<!--&lt;!&ndash;        <el-dropdown-item style="font-size: 14px; padding: 5px 0">&ndash;&gt;-->
<!--&lt;!&ndash;          <span style="text-decoration: none" @click="logout">退出</span>&ndash;&gt;-->
<!--&lt;!&ndash;        </el-dropdown-item>&ndash;&gt;-->

<!--      </el-dropdown-menu>-->
<!--    </el-dropdown>-->






<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--  name: "CManageHeader",-->
<!--  props: {-->
<!--    collapseBtnClass: String,-->
<!--    collapse: Boolean,-->
<!--  },-->
<!--  computed: {-->
<!--    currentPathName () {-->
<!--      return this.$store.state.currentPathName;　　//需要监听的数据-->
<!--    }-->
<!--  },-->
<!--  data() {-->
<!--    return {-->
<!--      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}-->
<!--    }-->
<!--  },-->
<!--  watch: {      //顶上的斜杠那里-->
<!--    currentPathName (newVal, oldVal) {-->
<!--      console.log(newVal)-->
<!--    }-->
<!--  },-->
<!--  methods: {-->
<!--    // logout() {-->
<!--    //   this.$router.push("/login")-->
<!--    //   localStorage.removeItem("user")-->
<!--    //   this.$message.success("退出成功")-->
<!--    // }-->
<!--  }-->
<!--  // methods: {-->
<!--  //   collapse() {-->
<!--  //     this.$emit("asideCollapse")-->
<!--  //   }-->
<!--  // },-->
<!--  // logout(){-->
<!--  //   this.$router.push("/login")-->
<!--  //   localStorage.removeItem("user")-->
<!--  //   this.$message.success("退出成功")-->
<!--  // }-->
<!--}-->
<!--</script>-->

<!--<style scoped>-->

<!--</style>-->