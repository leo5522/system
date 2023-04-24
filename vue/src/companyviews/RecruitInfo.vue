<!--<template>-->
<!--  <div>-->
<!--    <el-card class="filter-card">-->
<!--      <div slot="header" class="card-header">-->
<!--        职位类型-->
<!--      </div>-->
<!--      <div class="card-body">-->
<!--        <el-select style="width: 150px" v-model="workplace" placeholder="工作地点">-->
<!--          <el-option label="北京" value="beijing"></el-option>-->
<!--          <el-option label="上海" value="shanghai"></el-option>-->
<!--        </el-select>-->
<!--        <el-select style="width: 150px" v-model="experience" placeholder="工作经验">-->
<!--          <el-option label="不限" value="bachelor"></el-option>-->
<!--          <el-option label="应届生" value="master"></el-option>-->
<!--          <el-option label="1年以内" value="doctor"></el-option>-->
<!--          <el-option label="1~3年" value="doctor"></el-option>-->
<!--          <el-option label="3以上年" value="doctor"></el-option>-->
<!--        </el-select>-->
<!--        <el-select style="width: 150px"  v-model="education" placeholder="学历要求">-->
<!--          <el-option label="本科" value="bachelor"></el-option>-->
<!--          <el-option label="硕士" value="master"></el-option>-->
<!--          <el-option label="博士" value="doctor"></el-option>-->
<!--        </el-select>-->

<!--        <el-button type="primary" @click="load">查询</el-button>-->
<!--        <el-button  @click="reset">重置</el-button>-->
<!--      </div>-->
<!--    </el-card>-->

<!--    <el-card class="job-card" v-for="(item, index) in jobList" :key="index">-->
<!--      <div class="card-header">-->
<!--        {{ item.position }}-->
<!--      </div>-->
<!--      <div class="card-body">-->
<!--        {{ item.description }}-->
<!--      </div>-->
<!--      <div class="card-footer">-->
<!--        工作地点：{{ item.workplace }} | 学历要求：{{ item.education }}-->
<!--      </div>-->
<!--    </el-card>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--  name: "RecruitInfo"-->
<!--}-->
<!--</script>-->

<!--<style scoped>-->

<!--</style>-->



<!--<template>-->

<!--  <div>-->
<!--    <el-card class="filter-card">-->
<!--      <div slot="header" class="card-header">-->
<!--        职位信息-->
<!--      </div>-->
<!--      <div class="card-body">-->
<!--        <el-input style="width: 200px" placeholder="请输入职位类别" prefix-icon="el-icon-search" v-model="career"></el-input>-->
<!--        <el-input style="width: 200px" placeholder="请输入工作地点" prefix-icon="el-icon-search" v-model="workplace"></el-input>-->
<!--        <el-input style="width: 200px" placeholder="请输入学历要求" prefix-icon="el-icon-search" class="ml-5" v-model="education"></el-input>-->
<!--        &lt;!&ndash;            <el-input style="width: 200px" placeholder="请输入邮箱" prefix-icon="el-icon-message" class="ml-5"></el-input>&ndash;&gt;-->
<!--        &lt;!&ndash;            <el-input style="width: 200px" placeholder="请输入地址" prefix-icon="el-icon-position" class="ml-5"></el-input>&ndash;&gt;-->
<!--        <el-button class="ml-5" type="primary" @click="load">搜索</el-button>-->
<!--        <el-button @click="reset">重置</el-button>-->
<!--      </div>-->
<!--    </el-card>-->
<!--    <div style="margin: 10px 0">-->
<!--      <el-button type="primary" @click="handleAdd">新增<i class="el-icon-circle-plus-outline"></i></el-button>-->
<!--      <el-popconfirm-->
<!--          class="ml-5"-->
<!--          confirm-button-text='确定'-->
<!--          cancel-button-text='取消'-->
<!--          icon="el-icon-info"-->
<!--          icon-color="red"-->
<!--          title="您确定批量删除这些数据吗？"-->
<!--          @confirm="delBatch"-->
<!--      >-->
<!--      <el-button type="danger" slot="reference">批量删除<i class="el-icon-remove-outline"></i></el-button>-->
<!--      </el-popconfirm>-->
<!--    </div>-->
<!--&lt;!&ndash;    <div class="container">&ndash;&gt;-->
<!--&lt;!&ndash;      <div class="card-container">&ndash;&gt;-->
<!--&lt;!&ndash;        &ndash;&gt;-->
<!--    <el-table :data="tableData" border stripe :header-cell-class-name="'headerBg'" @selection-change="handleSelectionChange">-->
<!--      <el-table-column type="selection" width="55"></el-table-column>-->
<!--      <el-table-column prop="id" label="ID" width="70"></el-table-column>-->
<!--&lt;!&ndash;      <el-table-column prop="cname" label="企业名称" width="120"></el-table-column>&ndash;&gt;-->
<!--      <el-table-column prop="career" label="职位类别" width="120"></el-table-column>-->
<!--      <el-table-column prop="job" label="职位名称"></el-table-column>-->
<!--      <el-table-column prop="minsalary" label="最低薪资"></el-table-column>-->
<!--      <el-table-column prop="maxsalary" label="最高薪资"></el-table-column>-->
<!--      <el-table-column prop="experience" label="工作经验"></el-table-column>-->
<!--      <el-table-column prop="education" label="学历要求"></el-table-column>-->
<!--      <el-table-column prop="workplace" label="工作地点"></el-table-column>-->
<!--      <el-table-column prop="description" label="工作内容"></el-table-column>-->
<!--      <el-table-column prop="principal" label="负责人"></el-table-column>-->
<!--      <el-table-column prop="phone" label="联系电话"></el-table-column>-->
<!--      <el-table-column prop="status" label="审核状态"></el-table-column>-->
<!--&lt;!&ndash;      <el-table-column prop="clickCout" label="点击次数"></el-table-column>&ndash;&gt;-->
<!--      <el-table-column label="操作" width="200" align="center">-->
<!--        <template slot-scope="scope">-->
<!--          <el-button type="success" @click="handleEdit(scope.row)">编辑<i class="el-icon-edit"></i></el-button>-->
<!--          <el-popconfirm-->
<!--              class="ml-5"-->
<!--              confirm-button-text='确定'-->
<!--              cancel-button-text='取消'-->
<!--              icon="el-icon-info"-->
<!--              icon-color="red"-->
<!--              title="您确定删除吗？"-->
<!--              @confirm="del(scope.row.id)"-->
<!--          >-->
<!--            <el-button type="danger" slot="reference">删除<i class="el-icon-remove-outline"></i></el-button>-->
<!--          </el-popconfirm>-->
<!--        </template>-->
<!--      </el-table-column>-->
<!--    </el-table>-->
<!--    <div style="padding: 10px 0">-->
<!--      <el-pagination-->
<!--          @size-change="handleSizeChange"-->
<!--          @current-change="handleCurrentChange"-->
<!--          :current-page="pageNum"-->
<!--          :page-sizes="[2, 5, 10, 20]"-->
<!--          :page-size="pageSize"-->
<!--          layout="total, sizes, prev, pager, next, jumper"-->
<!--          :total="total">-->
<!--      </el-pagination>-->
<!--    </div>-->
<!--    <el-dialog title="招聘信息" :visible.sync="dialogFormVisible" width="30%">-->
<!--      <el-form label-width="80px" size="small">-->
<!--&lt;!&ndash;        <el-form-item label="企业名称">&ndash;&gt;-->
<!--&lt;!&ndash;          <el-input v-model="form.cname" autocomplete="off"></el-input>&ndash;&gt;-->
<!--&lt;!&ndash;        </el-form-item>&ndash;&gt;-->
<!--        <el-form-item label="职位类别">-->
<!--          <el-input v-model="form.career" autocomplete="off"></el-input>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="职位名称">-->
<!--          <el-input v-model="form.job" autocomplete="off"></el-input>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="最低薪资">-->
<!--          <el-input v-model="form.minsalary" autocomplete="off"></el-input>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="最高薪资">-->
<!--          <el-input v-model="form.maxsalary" autocomplete="off"></el-input>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="工作经验">-->
<!--          <el-input v-model="form.experience" autocomplete="off"></el-input>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="学历要求">-->
<!--          <el-input v-model="form.education" autocomplete="off"></el-input>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="工作地点">-->
<!--          <el-input v-model="form.workplace" autocomplete="off"></el-input>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="工作内容">-->
<!--          <el-input v-model="form.description" autocomplete="off"></el-input>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="负责人">-->
<!--          <el-input v-model="form.principal" autocomplete="off"></el-input>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="联系电话">-->
<!--          <el-input v-model="form.phone" autocomplete="off"></el-input>-->
<!--        </el-form-item>-->
<!--      </el-form>-->
<!--      <div slot="footer" class="dialog-footer">-->
<!--        <el-button @click="dialogFormVisible = false">取 消</el-button>-->
<!--        <el-button type="primary" @click="save">确 定</el-button>-->
<!--      </div>-->
<!--    </el-dialog>-->

<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--  name: "RecruitInfo",-->
<!--  data() {-->
<!--    return {-->
<!--      tableData:[],-->
<!--      total:0,-->
<!--      pageNum:1,-->
<!--      pageSize:10,-->
<!--      career:"",            //此处和多条件查询有关-->
<!--      workplace:"",-->
<!--      education:"",-->
<!--      form:{},-->
<!--      dialogFormVisible:false, //即默认不展示-->
<!--      multipleSelection:[]-->
<!--    }-->
<!--  },-->
<!--  created() {-->
<!--    this.load()-->
<!--  },-->
<!--  methods: {-->
<!--    load(){-->
<!--      this.request.get("/recruitment/page",{-->
<!--        params:{-->
<!--          pageNum: this.pageNum,-->
<!--          pageSize: this.pageSize,-->
<!--          career: this.career,-->
<!--          workplace: this.workplace,-->
<!--          education: this.education              //此处和多条件查询有关-->
<!--        }-->
<!--      }).then(res => {-->
<!--        console.log(res)-->
<!--        this.tableData = res.records-->
<!--        this.total = res.total-->
<!--      })-->

<!--    },-->
<!--    save(){       //新增数据时与后台连接发送数据，返回结果-->
<!--      this.request.post("/recruitment",this.form).then(res => {-->
<!--        if(res){-->
<!--          this.$message.success("保存成功")-->
<!--          this.dialogFormVisible = false-->
<!--          this.load()   //修改或新增数据后自动调用刷新加载出来-->
<!--        }else{-->
<!--          this.$message.error("保存失败")-->
<!--        }-->
<!--      })-->
<!--    },-->
<!--    handleAdd(){-->
<!--      this.dialogFormVisible = true-->
<!--      this.form = {}-->
<!--    },-->
<!--    handleEdit(row){-->
<!--      this.form = row-->
<!--      this.dialogFormVisible = true-->
<!--    },-->
<!--    del(id){-->
<!--      this.request.delete("/recruitment/" + id).then(res => {     // 请求接口-->
<!--        if(res){-->
<!--          this.$message.success("删除成功")-->
<!--          this.load()   //删除数据后自动调用刷新加载出来-->
<!--        }else{-->
<!--          this.$message.error("删除失败")-->
<!--        }-->
<!--      })-->
<!--    },-->
<!--    handleSelectionChange(val){-->
<!--      console.log(val)-->
<!--      this.multipleSelection = val-->
<!--    },-->
<!--    delBatch(){    //批量删除方法-->
<!--      let ids = this.multipleSelection.map(v => v.id)  //把对象的数组转化成了[1,2,3,...]即[{},{},...] => [1,2,3,...]-->
<!--      this.request.post("/recruitment/del/batch",ids).then(res => {     // 请求接口-->
<!--        if(res){-->
<!--          this.$message.success("删除成功")-->
<!--          this.load()   //删除数据后自动调用刷新加载出来-->
<!--        }else{-->
<!--          this.$message.error("删除失败")-->
<!--        }-->
<!--      })-->
<!--    },-->
<!--    reset(){-->
<!--      this.career = ""-->
<!--      this.workplace = ""-->
<!--      this.education = ""-->
<!--      this.load()-->
<!--    },-->
<!--    handleSizeChange(pageSize){-->
<!--      console.log(pageSize)-->
<!--      this.pageSize = pageSize-->
<!--      this.load()-->
<!--    },-->
<!--    handleCurrentChange(pageNum){-->
<!--      console.log(pageNum)-->
<!--      this.pageNum = pageNum-->
<!--      this.load()-->
<!--    },-->
<!--  }-->
<!--}-->
<!--</script>-->

<!--<style>-->
<!--.headerBg{-->
<!--  background: #eee!important;-->
<!--}-->
<!--</style>-->


