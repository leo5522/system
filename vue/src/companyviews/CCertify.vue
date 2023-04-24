<!--<template>-->

<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--  name: "SCertify"-->
<!--}-->
<!--</script>-->

<!--<style scoped>-->

<!--</style>-->

<!--<template>-->

<!--  <div>-->
<!--    <h1>信息认证</h1>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--  name: "Certify"-->
<!--}-->
<!--</script>-->

<!--<style scoped>-->

<!--</style>-->

<template>
  <div>

    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="企业类型">
        <el-select v-model="form.type" placeholder="请选择企业类型">
          <el-option label="国有企业" value="shanghai"></el-option>
          <el-option label="集体企业" value="beijing"></el-option>
          <el-option label="联营企业" value="beijing"></el-option>
          <el-option label="股份合作制企业" value="beijing"></el-option>
          <el-option label="私营企业" value="beijing"></el-option>
          <el-option label="个体户" value="beijing"></el-option>
          <el-option label="合伙企业" value="beijing"></el-option>
          <el-option label="有限责任公司" value="beijing"></el-option>
          <el-option label="股份有限公司" value="beijing"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="企业名称">
        <el-input v-model="form.cname" style="width: 200px" placeholder="请输入企业名称"></el-input>
      </el-form-item>
      <el-form-item label="企业地址">
        <el-select v-model="form.address" placeholder="请选择省份" style="width: 110px">
          <el-option label="--请选择--" value="shanghai"></el-option>
          <el-option label="安徽" value="shanghai" style="text-align: center"></el-option>
          <el-option label="北京" value="beijing" style="text-align: center"></el-option>
          <el-option label="重庆" value="beijing" style="text-align: center"></el-option>
          <el-option label="福建" value="beijing" style="text-align: center"></el-option>
          <el-option label="甘肃" value="beijing" style="text-align: center"></el-option>
          <el-option label="广东" value="beijing" style="text-align: center"></el-option>
          <el-option label="广西" value="beijing" style="text-align: center"></el-option>
          <el-option label="贵州" value="beijing" style="text-align: center"></el-option>
          <el-option label="海南" value="beijing" style="text-align: center"></el-option>
          <el-option label="河北" value="beijing" style="text-align: center"></el-option>
          <el-option label="河南" value="beijing" style="text-align: center"></el-option>
          <el-option label="黑龙江" value="beijing" style="text-align: center"></el-option>
          <el-option label="湖北" value="beijing" style="text-align: center"></el-option>
          <el-option label="湖南" value="beijing" style="text-align: center"></el-option>
          <el-option label="吉林" value="beijing" style="text-align: center"></el-option>
          <el-option label="江苏" value="beijing" style="text-align: center"></el-option>
          <el-option label="江西" value="beijing" style="text-align: center"></el-option>
        </el-select>
        <el-select v-model="form.address" placeholder="请选择城市" style="width: 110px">
          <el-option label="--请选择--" value="shanghai"></el-option>
        </el-select>
        <el-select v-model="form.address" placeholder="请选择地区" style="width: 110px">
          <el-option label="--请选择--" value="shanghai"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="企业logo">
        <el-upload
            action="https://jsonplaceholder.typicode.com/posts/"
            list-type="picture-card"
            :on-preview="handlePictureCardPreview"
            :on-remove="handleRemove">
          <i class="el-icon-plus"></i>
        </el-upload>
        <el-dialog :visible.sync="dialogVisible">
          <img width="100%" :src="dialogImageUrl" alt="">
        </el-dialog>
      </el-form-item>

      <el-form-item label="所属行业">
        <el-select v-model="form.address" placeholder="请选择所属行业" style="width: 200px">
          <el-option label="------请选择------" value="shanghai" style="text-align: center"></el-option>
          <el-option label="信息传输、软件和信息技术服务业" value="shanghai" style="text-align: center"></el-option>
          <el-option label="金融业" value="beijing" style="text-align: center"></el-option>
          <el-option label="交通运输、仓储和邮政业" value="beijing" style="text-align: center"></el-option>
          <el-option label="水利、环境和公共设施管理业" value="beijing" style="text-align: center"></el-option>
          <el-option label="交通运输、仓储和邮政业" value="beijing" style="text-align: center"></el-option>
          <el-option label="居民服务、修理和其他服务业" value="beijing" style="text-align: center"></el-option>
          <el-option label="教育" value="beijing" style="text-align: center"></el-option>
          <el-option label="科学研究和技术服务业" value="beijing" style="text-align: center"></el-option>
          <el-option label="公共管理、社会保障和社会组织" value="beijing" style="text-align: center"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="法定人">
        <el-input v-model="form.cname" style="width: 200px" placeholder="请输入法定人"></el-input>
      </el-form-item>
      <el-form-item label="联系电话">
        <el-input v-model="form.cname" style="width: 200px" placeholder="请输入联系电话"></el-input>
      </el-form-item>
      <!--      <div class="block">-->
      <!--        <span class="demonstration">成立日期</span>-->
      <el-form-item label="成立日期">
        <el-date-picker
            v-model="value1"
            type="date"
            placeholder="选择日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="企业邮箱">
        <el-input v-model="form.cname" style="width: 200px" placeholder="请输入企业邮箱"></el-input>
      </el-form-item>
      <el-form-item label="登记机关">
        <el-input v-model="form.cname" style="width: 200px" placeholder="请输入登记机关"></el-input>
      </el-form-item>
      <el-form-item label="组织机构代码">
        <el-input v-model="form.cname" style="width: 200px" placeholder="请输入组织机构代码"></el-input>
      </el-form-item>
      <!--      </div>-->
      <!--      <el-form-item label="长文本框">-->
      <!--        <el-input type="textarea" v-model="form.desc"></el-input>-->
      <!--      </el-form-item>-->
      <el-form-item>
        <el-button type="primary" @click="onSubmit">立即认证</el-button>
        <el-button>重置</el-button>
      </el-form-item>
    </el-form>

  </div>
</template>
<script>
export default {
  data() {
    return {
      form: {
        name: 'CCertify',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      },
      dialogImageUrl: '',
      dialogVisible: false,
      pickerOptions: {
        disabledDate(time) {
          return time.getTime() > Date.now();
        },
      },
      value1: '',
      value2: '',
    }
  },
  methods: {
    onSubmit() {
      console.log('submit!');
    },
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    }
  }
}
</script>