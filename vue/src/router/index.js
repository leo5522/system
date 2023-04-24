import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [

  {/*企业端主页路由*/
    path: '/',
    name: '企业端首页',
    component: ()=> import('../companyviews/CHomeView'),
    redirect:"/chomefirst",
    children: [
      {path: 'chomefirst', name: 'CHomeFirst', component: () => import('../companyviews/CHomeFirst')},
      {path: 'companyabout', name: 'CompanyAbout', component: () => import('../companyviews/CompanyAbout')},
      {path: 'certifyview', name: 'CertifyView', component: () => import('../companyviews/CertifyView')},
      // {path: 'companycontact', name: 'CompanyContact', component: () => import('../companyviews/CompanyContact')},
      {path: 'recruitinfo', name: 'RecruitInfo', component: () => import('../companyviews/RecruitInfo')},
      {path: 'resumesearch', name: 'ResumeSearch', component: () => import('../companyviews/ResumeSearch')},
      {path: 'myrecruitment', name: 'MyRecruitment', component: () => import('../companyviews/MyRecruitment')},
      {path: 'personnelmarket', name: 'PersonnelMarket', component: () => import('../companyviews/PersonnelMarket')},
      {path: 'companyinfo', name: 'CompanyInfo', component: () => import('../companyviews/CompanyInfo')},
      {path: 'cmanage', name: 'CManage', component: () => import('../companyviews/CManage.vue')},
      {path: 'cstatistics', name: 'CStatistics', component: () => import('../companyviews/CStatistics.vue')},
    ]

  },


]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
