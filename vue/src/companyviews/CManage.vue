<!--&lt;!&ndash;<template>&ndash;&gt;-->

<!--&lt;!&ndash;</template>&ndash;&gt;-->

<!--&lt;!&ndash;<script>&ndash;&gt;-->
<!--&lt;!&ndash;export default {&ndash;&gt;-->
<!--&lt;!&ndash;  name: "CManage"&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->
<!--&lt;!&ndash;</script>&ndash;&gt;-->

<!--&lt;!&ndash;<style scoped>&ndash;&gt;-->

<!--&lt;!&ndash;</style>&ndash;&gt;-->


<!--<template>-->
<!--  <el-container style="min-height: 100vh">-->
<!--    <el-aside :width="sideWidth +'px'" style="background-color: rgb(238, 241, 246);box-shadow: 2px 0 6px rgb(0 21 41 / 35%)">-->
<!--      <Aside :isCollapse="isCollapse" :logoTextShow="logoTextShow"/>-->
<!--    </el-aside>-->

<!--    <el-container>-->
<!--      <el-header style="border-bottom: 1px solid #ccc;">-->
<!--        <Header :collapseBtnClass="collapseBtnClass" :collapse="isCollapse"></Header>-->
<!--      </el-header>-->

<!--      <el-main>-->
<!--        &lt;!&ndash;          表示当前页面的子路由会在<router-view />里展示&ndash;&gt;-->
<!--        <router-view />-->
<!--      </el-main>-->
<!--    </el-container>-->
<!--  </el-container>-->
<!--</template>-->

<!--<script>-->

<!--import CManageAside from "@/companycomponents/CManageAside.vue";-->
<!--import CManageHeader from "@/companycomponents/CManageHeader.vue";-->
<!--// import {Collapse} from "element-ui";-->
<!--export default {-->

<!--  name: 'CManage',-->
<!--  // computed: {-->
<!--  //   Collapse() {-->
<!--  //     return Collapse-->
<!--  //   }-->
<!--  // },-->
<!--  data() {     //全局-->
<!--    return {-->
<!--      collapseBtnClass:'el-icon-s-fold',-->
<!--      isCollapse: false,-->
<!--      sideWidth:200,-->
<!--      logoTextShow:true,-->

<!--    }-->
<!--  },-->
<!--  components: {-->
<!--    CManageAside,-->
<!--    CManageHeader-->
<!--  },-->
<!--  methods:{-->
<!--    collapse(){    //点击收缩按钮触发-->
<!--      this.isCollapse=!this.isCollapse-->
<!--      if(this.isCollapse){   //收缩-->
<!--        this.sideWidth=64-->
<!--        this.collapseBtnClass='el-icon-s-unfold'-->
<!--        this.logoTextShow=false-->
<!--      }else{                 //展开-->
<!--        this.sideWidth=200-->
<!--        this.collapseBtnClass='el-icon-s-fold'-->
<!--        this.logoTextShow=true-->
<!--      }-->
<!--    }-->

<!--  }-->
<!--}-->
<!--</script>-->
